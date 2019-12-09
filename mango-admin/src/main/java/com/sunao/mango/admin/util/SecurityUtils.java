package com.sunao.mango.admin.util;

import com.sunao.mango.admin.security.JwtAuthenticatioToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

/**
 * SecurityUtils 系统登录认证工具类
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/9 10:49
 */
public class SecurityUtils {
    /**
     * 系统登录认证
     *
     * @param request               请求参数
     * @param userName              用户名
     * @param password              密码
     * @param authenticationManager 认证管理器
     * @return 认证结果
     */
    public static JwtAuthenticatioToken login(HttpServletRequest request, String userName, String password, AuthenticationManager authenticationManager) {
        JwtAuthenticatioToken token = new JwtAuthenticatioToken(userName, password);
        token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        // 执行登录认证过程
        Authentication authentication = authenticationManager.authenticate(token);
        // 认证成功存储认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 生成令牌并返回给客户端
        token.setToken(JwtTokenUtils.generateToken(authentication));
        return token;
    }

    /**
     * 获取令牌进行认证
     *
     * @param request 请求参数
     */
    public static void checkAuthentication(HttpServletRequest request) {
        // 获取令牌并根据令牌获取登录认证信息
        Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request);
        // 设置登录认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * 获取当前用户名
     *
     * @return 当前用户名
     */
    public static String getUserName() {
        String userName = null;
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal != null && principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            }
        }
        return userName;
    }

    /**
     * 获取用户名
     *
     * @return 用户名
     */
    public static String getUserName(Authentication authentication) {
        String userName = null;
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal != null && principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            }
        }
        return userName;
    }

    /**
     * 获取当前登录信息
     *
     * @return 当前登录信息
     */
    public static Authentication getAuthentication() {
        if (SecurityContextHolder.getContext() == null) {
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
