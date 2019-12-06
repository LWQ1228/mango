package com.sunao.mango.core.page;

import java.util.List;

/**
 * PageResult 分页结果返回
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/06
 */
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;

    /**
     * 每页数量
     */
    private int pageSize;

    /**
     * 记录总数
     */
    private long totalSize;

    /**
     * 页码总数
     */
    private int totalPages;

    /**
     * 分页数据
     */
    private List<?> content;

    public int getPageNum() {
        return pageNum;
    }

    public PageResult setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageResult setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public PageResult setTotalSize(long totalSize) {
        this.totalSize = totalSize;
        return this;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public PageResult setTotalPages(int totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    public List<?> getContent() {
        return content;
    }

    public PageResult setContent(List<?> content) {
        this.content = content;
        return this;
    }
}
