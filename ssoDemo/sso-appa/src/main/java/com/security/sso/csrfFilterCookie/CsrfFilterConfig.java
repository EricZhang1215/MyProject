package com.security.sso.csrfFilterCookie;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册CSRFCOOKIE过滤器
 */
@Configuration
public class CsrfFilterConfig {
	@Bean
	public FilterRegistrationBean filterRegist() {
		FilterRegistrationBean frBean = new FilterRegistrationBean();
		frBean.setFilter(new CsrfHeaderFilter());
		frBean.addUrlPatterns("/*");
		System.out.println("注册CSRFCOOKIE过滤器");
		return frBean;
	}
}
