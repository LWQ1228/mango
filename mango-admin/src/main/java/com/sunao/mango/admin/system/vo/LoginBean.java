package com.sunao.mango.admin.system.vo;

/**
 * LoginBean 登录接口封装对象
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/9 14:33
 */
public class LoginBean {
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 验证码
     */
    private String captcha;

    public String getAccount() {
        return account;
    }

    public LoginBean setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCaptcha() {
        return captcha;
    }

    public LoginBean setCaptcha(String captcha) {
        this.captcha = captcha;
        return this;
    }
}
