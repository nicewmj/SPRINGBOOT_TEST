package com.example.aop;

import com.example.annotation.UserLog;
import com.example.entity.UserInfoDTO;
import com.example.entity.UserLogDTO;
import com.example.service.userAOP.UserLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 操作日志注解切面实现
 */
@Slf4j
@Aspect
@Component
public class UserLogAspect {
	// 这次不用RequestContextHolder了，改成直接注入
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    UserLogService userLogService;


    @Pointcut("@annotation(com.example.annotation.UserLog)")
    public void pointcut() {
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint point) {
        saveSysUserLog(point);
    }

    private void saveSysUserLog(JoinPoint point) {
        // 获取当前登录用户
        UserInfoDTO userInfoDTO = getUserInfoDTO();

        // 目标方法、以及方法上的@UserLog注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        UserLog userLogAnnotation = method.getAnnotation(UserLog.class);
        if (userLogAnnotation == null) {
            return;
        }

        // 收集相关信息并保存
        UserLogDTO userLogDTO = new UserLogDTO();
        userLogDTO.setModuleCode(userLogAnnotation.module().getModuleCode());
        userLogDTO.setContent(getContentJson(point));
        userLogDTO.setTitle(userLogAnnotation.title());
        userLogDTO.setOperatorId(userInfoDTO.getId());
        userLogDTO.setOperateTime(new Date());
        userLogDTO.setType(userLogAnnotation.type().getValue());

        userLogService.addSysLog(userLogDTO);
    }

    private UserInfoDTO getUserInfoDTO() {
        // UserInfoDTO userInfoDTO = (UserInfoDTO) ThreadLocalMap.get(WebConst.USER_INFO_DTO);
		// 模拟从ThreadLocal获取用户信息，关于ThreadLocal请参考小册相关章节
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setId(10086L);
        userInfoDTO.setName("小强");
        userInfoDTO.setSex("男");
        return userInfoDTO;
    }

    private String getContentJson(JoinPoint point) {
        String requestType = request.getMethod();
        if ("GET".equals(requestType)) {
            // 如果是GET请求，直接返回QueryString（目前没有针对查询操作进行日志记录，先留着吧）
            return request.getQueryString();
        }

        Object[] args = point.getArgs();
        Object[] arguments = new Object[args.length];

        for (int i = 0; i < args.length; i++) {
            // 只打印客户端传递的参数，排除Spring注入的参数，比如HttpServletRequest
            if (args[i] instanceof ServletRequest
                    || args[i] instanceof ServletResponse
                    || args[i] instanceof MultipartFile) {
                continue;
            }
            arguments[i] = args[i];
        }

        try {
            return objectMapper.writeValueAsString(arguments);
        } catch (JsonProcessingException e) {
            log.error("UserLogAspect#getContentJson JsonProcessingException", e);
        }
        return "";
    }
}