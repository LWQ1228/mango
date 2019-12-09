package com.sunao.mango.admin.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * GrantedAuthorityImpl 权限封装
 * 对权限的封装，内部包含一个字符串类型的权限标识authority，对应菜单表的perms字段的权限字符串，
 * 比如用户增、删、改、查权限标志sys:user:view、sys:user:add、sys:user:edit、sys:user:delete
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/9 13:23
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private static final long serialVersionUID = 1L;

    /**
     * 权限
     */
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
