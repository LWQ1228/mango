package com.sunao.mango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sunao.mango.common.utils.ReflectionUtils;

import java.util.List;

/**
 * MybatisPageHelper 分页查询助手
 *
 * @author liuwenqing
 * @blame 刘文清
 * @date 2019/12/06
 */
public class MybatisPageHelper {
    /**
     * 约定的分页查询方法名
     */
    public static final String FIND_PAGE = "findPage";

    /**
     * 分页查询，约定查询方法名为"findPage"
     *
     * @param pageRequest 分页请求
     * @param mapper      Dao对象，MyBatis的Mapper
     * @return 分页查询结果
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, FIND_PAGE);
    }

    /**
     * 调用分页插件进行分页查询
     *
     * @param pageRequest     分页请求
     * @param mapper          Dao对象，MyBatis的Mapper
     * @param queryMethodName 要分页的查询方法名
     * @param args            方法参数
     * @return 分页查询结果
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {
        //设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        //利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo((List) result));
    }

    /**
     * 将分页信息封账到统一的接口
     *
     * @param pageRequest 分页请求
     * @param pageInfo    需要分页的数据
     * @return 封装结果
     */
    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum()).setPageSize(pageInfo.getPageSize())
                .setTotalSize(pageInfo.getTotal()).setTotalPages(pageInfo.getPages())
                .setContent(pageInfo.getList());
        return pageResult;
    }
}
