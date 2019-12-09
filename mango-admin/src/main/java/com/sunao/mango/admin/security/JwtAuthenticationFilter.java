package com.sunao.mango.admin.security;

import com.sunao.mango.admin.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JwtAuthenticationFilter 登录认证过滤器
 * 负责登录认真时检查并产生令牌保存到上下文，接口权限认证过程时，
 * 系统从上下文获取令牌校验接口访问权限
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/9 10:37
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    /**
     * 初始化构造方法
     *
     * @param authenticationManager 认证管理器
     */
    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * 过滤器
     *
     * @param request  请求参数
     * @param response 响应参数
     * @param chain    Filter链
     * @throws IOException      IO异常
     * @throws ServletException Servlet异常
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取token，并检查登录状态
        SecurityUtils.checkAuthentication(request);
        chain.doFilter(request, response);
    }
}
