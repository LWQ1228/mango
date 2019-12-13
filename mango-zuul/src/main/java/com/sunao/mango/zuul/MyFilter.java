package com.sunao.mango.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * MyFilter
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/13 16:03
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * 定义日志
     */
    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 定义filter的类型
     *
     * @return filter的类型
     */
    @Override
    public String filterType() {
        // 定义filter的类型，有pre、route、post、error四种
        return "pre";
    }

    /**
     * 定义filter的顺序
     *
     * @return filter的顺序
     */
    @Override
    public int filterOrder() {
        // 定义filter的顺序，数字越小表示顺序越高，越先执行
        return 0;
    }

    /**
     * 表示是否需要执行该filter
     *
     * @return 是否需要执行该filter
     */
    @Override
    public boolean shouldFilter() {
        // 表示是否需要执行该filter，true表示执行，false表示不执行
        return true;
    }

    /**
     * Filter运行逻辑 转发请求时进行token认证
     *
     * @return 认证结果
     * @throws ZuulException 异常信息
     */
    @Override
    public Object run() throws ZuulException {
        // filter需要执行的具体操作
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        System.out.println(token);
        //如果请求没有带token
        if (token == null) {
            log.warn("there is no request token");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("there is no request token");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
