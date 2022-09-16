package com.wfr.base.framework.common;

/**
 * 分页请求对象
 *
 * @author wangfarui
 * @since 2022/9/1
 */
public class PageRequest {

    /**
     * 当前页
     */
    private long currentPage = 1;

    /**
     * 每页数量
     */
    private long pageSize = 10;

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
}
