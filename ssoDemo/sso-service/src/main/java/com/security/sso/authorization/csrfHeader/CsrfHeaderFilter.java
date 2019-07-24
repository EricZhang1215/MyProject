package com.security.sso.authorization.csrfHeader;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 因为是前后端分离的项目，没有session的概念，也无法从session中获取信息，参考了官网的解决办法，把csrfToken放到cookie中，
 * 于是增加一个往cookie中加csrfToken的过滤器，该过滤器把csrfToken的信息放到cookie,并把cookie传到前台；
 * 这样把csrfToken的内容就可以通过前台JS获取，通过请求发送到后台，这样就会通过CsrfFilter的验证，从而POST请求可以正常执行，
 * 这就有了前边的把该过滤器注册到过滤器链中
 */
public class CsrfHeaderFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

		CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		if (csrf != null) {
			Cookie cookie = WebUtils.getCookie(request, "CSRF-TOKEN");
			String token = csrf.getToken();
			if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
				cookie = new Cookie("CSRF-TOKEN", token);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		filterChain.doFilter(request, response);
	}
}

/*
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        request.setAttribute(HttpServletResponse.class.getName(), response);
        //解释:先从session中拿到csrfToken的值，如果是第一次进入该方法，csrfToken是不存在的，拿到的是null
        CsrfToken csrfToken = this.tokenRepository.loadToken(request);
        boolean missingToken = csrfToken == null;
        //解释:若果拿到为null就根据本次请求的地址生成Token,并把该Token存储到session中
        if (missingToken) {
            csrfToken = this.tokenRepository.generateToken(request);
            this.tokenRepository.saveToken(csrfToken, request, response);
        }
        //解释:把csrfToken放到request中
        request.setAttribute(CsrfToken.class.getName(), csrfToken);
        request.setAttribute(csrfToken.getParameterName(), csrfToken);
        解释:如果该请求时非post请求，直接进入后续流程
        if (!this.requireCsrfProtectionMatcher.matches(request)) {
            filterChain.doFilter(request, response);
        } else {
            解释:如果是POST请求，重request中获取csrfToken传给actualToken
            String actualToken = request.getHeader(csrfToken.getHeaderName());
            if (actualToken == null) {
                actualToken = request.getParameter(csrfToken.getParameterName());
            }
            解释:验证从request中传过来的csrfToken和本次方法中的csrfToken是不是一致，不一致的话，抛出异常信息
            if (!csrfToken.getToken().equals(actualToken)) {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Invalid CSRF token found for " + UrlUtils.buildFullRequestUrl(request));
                }
                if (missingToken) {
                    this.accessDeniedHandler.handle(request, response, new MissingCsrfTokenException(actualToken));
                } else {
                    this.accessDeniedHandler.handle(request, response, new InvalidCsrfTokenException(csrfToken, actualToken));
                }
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
*/
