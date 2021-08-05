package Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import system.LoginInterceptor;
import system.SecurityInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 把拦截器通过registry注册到Spring容器
     * 一般有两种方式：
     * 1.registry.addInterceptor(new LoginInterceptor())
     * 2.给LoginInterceptor加@Component，通过@Autowired注入，然后registry.addInterceptor(loginInterceptor)
     * 【推荐使用@Autowired注入】：如果LoginInterceptor内部需要注入其他组件比如RedisTemplate，那么直接new LoginInterceptor会注入失败
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //把Config包下的拦截器注入进来
        //LoginInterceptor      登录的拦截器（单纯的登录拦截
        //SecurityInterceptor   登录权限的拦截器（这个要有角色了
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**");
    }
}