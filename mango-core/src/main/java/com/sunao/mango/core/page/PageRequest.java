package com.sunao.mango.core.page;

import java.util.HashMap;
import java.util.Map;

/**
 * PageRequest 分页请求
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/06
 */
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum = 1;

    /**
     * 每页数量
     */
    private int pageSize = 10;

    /**
     * 查询参数
     */
    private Map<String, Object> params = new HashMap<>();

    public int getPageNum() {
        return pageNum;
    }

    public PageRequest setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageRequest setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public PageRequest setParams(Map<String, Object> params) {
        this.params = params;
        return this;
    }

    public Object getParam(String key) {
        return getParams().get(key);
    }
}
