package cn.zqs.sso.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SsoUserDetailsService ssoUserDetailsService;
    //密码加密器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //自定义登录页面
        http.formLogin().loginPage("/authentication/require")
                //配置让Spring知道让UsernamePasswordAuthenticationFilter过滤器去处理/authentication/form路径
                .loginProcessingUrl("/authentication/form")
                //授权的配置
                .and().authorizeRequests()
                //拦截规则
                .antMatchers("/authentication/require",
                        "/authentication/form",
                        "/**/*.js",
                        "/**/*.css",
                        "/**/*.jpg",
                        "/**/*.png",
                        "/**/*.woff2"
                )
                .permitAll()
                .anyRequest().authenticated()
                .and()
                //禁用 CSRF 跨站伪造请求
                .csrf().disable();
//        http.formLogin().and().authorizeRequests().anyRequest().authenticated(); //任何请求,登录后可以访问

/*        http.authorizeRequests().anyRequest().permitAll() //任何请求,登录后可以访问
        // 配置登录URI、登录失败跳转URI与登录成功后默认跳转URI
        .and().formLogin().loginPage("/login").defaultSuccessUrl("/").successForwardUrl("/index2").failureForwardUrl("/fail").permitAll()
        // 注销行为任意访问
        .and().logout().permitAll()
        // 设置拒绝访问的提示URI
        .and().exceptionHandling().accessDeniedPage("/login?illegal")
        .and().csrf().disable().anonymous().disable();*/

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(ssoUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
