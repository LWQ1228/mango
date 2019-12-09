package com.sunao.mango.admin.security;

import com.sunao.mango.admin.util.PasswordEncoder;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * JwtAuthenticationProvider 身份验证提供者
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/9 11:26
 */
public class JwtAuthenticationProvider extends DaoAuthenticationProvider {
    /**
     * 初始化构造函数
     *
     * @param userDetailsService 用户明细Service
     */
    public JwtAuthenticationProvider(UserDetailsService userDetailsService) {
        setUserDetailsService(userDetailsService);
    }

    /**
     * 密码匹配
     *
     * @param userDetails    用户信息
     * @param authentication 权限
     * @throws AuthenticationException 异常信息
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            logger.debug("Authentication failed: no credentials provided");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }

        String presentedPassword = authentication.getCredentials().toString();
        String salt = ((JwtUserDetails) userDetails).getSalt();
        // 覆写密码验证逻辑
        if (!new PasswordEncoder(salt).matches(userDetails.getPassword(), presentedPassword)) {
            logger.debug("Authentication failed: password does not match stored value");
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));
        }
    }

}
