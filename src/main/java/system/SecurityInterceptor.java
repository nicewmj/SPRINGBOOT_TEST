package system;

import com.example.annotation.LoginRequired;
import com.example.annotation.PermissionRequired;
import com.example.annotation.RequiresPermission;
import com.example.commom.ThreadLocalUtil;
import com.example.commom.WebConstant;
import com.example.entity.User;
import com.example.enumEntiy.ExceptionCodeEnum;
import com.example.enumEntiy.Logical;
import com.example.enumEntiy.UserType;
import com.example.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Set;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 不拦截跨域请求相关
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        // 如果类或方法上没有加@LoginRequired或@RequiredPermission（上面叠加了@LoginRequired），直接放行
        if (isLoginFree(handler)) {
            return true;
        }

        // 登录校验，session里如果没有用户信息，就抛异常给globalExceptionHandler提示“需要登录”
        User user = handleLogin(request, response);
        ThreadLocalUtil.put(WebConstant.USER_INFO, user);

        // 权限校验，校验不通过就抛异常，交给全局异常处理
        checkPermission(user, handler);

        // 放行到Controller
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 及时移除，避免ThreadLocal内存泄漏
        ThreadLocalUtil.remove(WebConstant.USER_INFO);
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 接口是否免登录（支持Controller上添加@LoginRequired）
     *
     * @param handler
     * @return
     */
    private boolean isLoginFree(Object handler) {

        // 判断是否支持免登录
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;

            // 类上是否有@LoginRequired
            Class<?> controllerClazz = handlerMethod.getBeanType();
            LoginRequired ControllerLogin = AnnotationUtils.findAnnotation(controllerClazz, LoginRequired.class);

            // 方法上是否有@LoginRequired
            Method method = handlerMethod.getMethod();
            LoginRequired methodLogin = AnnotationUtils.getAnnotation(method, LoginRequired.class);

            return ControllerLogin == null && methodLogin == null;
        }

        return true;
    }

    /**
     * 登录校验
     *
     * @param request
     * @param response
     * @return
     */
    private User handleLogin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute(WebConstant.CURRENT_USER_IN_SESSION);
        if (currentUser == null) {
            // 抛异常，请先登录
            throw new BizException(ExceptionCodeEnum.NEED_LOGIN);
        }
        return currentUser;
    }

    /**
     * 权限校验
     *
     * @param user
     * @param handler
     */
    private void checkPermission(User user, Object handler) {
        // 如果类和当前方法上都没有加@RequiresPermission，说明不需要权限校验，直接放行
        if (isPermissionFree(handler)) {
            return;
        }

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Class<?> controllerClazz = handlerMethod.getBeanType();

            // 代码走到这，已经很明确，当前方法需要权限才能访问，那么当前用户有没有权限呢？
            @SuppressWarnings("unchecked")
            Set<String> userPermissionMethods = (Set<String>) session.getAttribute(WebConstant.USER_PERMISSIONS);
            String currentRequestMethod = controllerClazz.getName() + "#" + method.getName();
            if (userPermissionMethods.contains(currentRequestMethod)) {
                return;
            }

            // 当前访问的方法需要权限，但是当前用户不具备该权限
            throw new BizException(ExceptionCodeEnum.PERMISSION_DENY);
        }
    }

    /**
     * 是否需要权限校验
     *
     * @param handler
     * @return
     */
    private boolean isPermissionFree(Object handler) {
        // 判断是否需要权限认证
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> controllerClazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            RequiresPermission controllerPermission = AnnotationUtils.getAnnotation(controllerClazz, RequiresPermission.class);
            RequiresPermission methodPermission = AnnotationUtils.getAnnotation(method, RequiresPermission.class);
            // 没有加@RequiresPermission，不需要权限认证
            return controllerPermission == null && methodPermission == null;
        }

        return true;
    }

}