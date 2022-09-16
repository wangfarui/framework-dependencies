package com.wfr.base.framework.common;

import java.util.List;

/**
 * 分页响应对象
 *
 * @author wangfarui
 * @since 2022/9/1
 */
public class PageResponse<T> {

    /**
     * 当前页
     */
    private long currentPage;

    /**
     * 每页数量
     */
    private long pageSize;

    /**
     * 总数量
     */
    private long totalSize;

    /**
     * 当前页数据
     */
    private List<T> data;

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(long totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
