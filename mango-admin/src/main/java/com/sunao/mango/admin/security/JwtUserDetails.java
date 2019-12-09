package com.sunao.mango.admin.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * JwtUserDetails 安全用户模型
 * 对认证信息的封装，实现Spring Security，提供UserDetails接口，主要包含用户名、密码、加密盐、权限信息
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/9 13:16
 */
public class JwtUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 加密盐
     */
    private String salt;

    /**
     * 权限列表
     */
    private Collection<? extends GrantedAuthority> authorities;

    /**
     * 构造方法
     *
     * @param username    用户名
     * @param password    密码
     * @param salt        加密盐
     * @param authorities 权限列表
     */
    JwtUserDetails(String username, String password, String salt, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
