package com.sunao.mango.admin.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * JwtAuthenticatioToken 自定义令牌对象
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/9 11:56
 */
public class JwtAuthenticatioToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;

    /**
     * 令牌
     */
    private String token;

    /**
     * 构造方法
     *
     * @param principal   数据
     * @param credentials 证书
     */
    public JwtAuthenticatioToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    /**
     * 构造方法
     *
     * @param principal   数据
     * @param credentials 证书
     * @param token       令牌
     */
    public JwtAuthenticatioToken(Object principal, Object credentials, String token) {
        super(principal, credentials);
        this.token = token;
    }

    /**
     * 构造方法
     *
     * @param principal   数据
     * @param credentials 证书
     * @param authorities 权限
     * @param token       令牌
     */
    public JwtAuthenticatioToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
