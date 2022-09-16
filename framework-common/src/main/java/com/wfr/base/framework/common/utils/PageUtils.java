package com.wfr.base.framework.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wfr.base.framework.common.PageRequest;
import com.wfr.base.framework.common.PageResponse;

/**
 * 分页工具
 *
 * @author wangfarui
 * @since 2022/9/16
 */
public abstract class PageUtils {

    /**
     * 包装为 PageResponse 对象
     *
     * @param page MyBatis-Plus分页对象
     * @param <T>  分页对象类型
     * @return 分页响应对象
     */
    public static <T> PageResponse<T> wrapPage(IPage<T> page) {
        PageResponse<T> response = new PageResponse<>();
        response.setCurrentPage(page.getCurrent());
        response.setPageSize(page.getSize());
        response.setTotalSize(page.getTotal());
        response.setData(page.getRecords());
        return response;
    }

    /**
     * 转为 MyBatis-Plus 分页对象
     *
     * @param pageRequest 分页请求对象
     * @param <T>         分页响应对象类型
     * @return MyBatis-Plus 分页对象
     */
    public static <T> IPage<T> toPage(PageRequest pageRequest) {
        return new Page<>(pageRequest.getCurrentPage(), pageRequest.getCurrentPage());
    }
}
