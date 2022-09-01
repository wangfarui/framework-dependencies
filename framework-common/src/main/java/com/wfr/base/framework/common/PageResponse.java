package com.wfr.base.framework.common;

import java.util.List;

/**
 * 分页响应对象
 *
 * @author wangfarui
 * @since 2022/9/1
 */
public class PageResponse<T> {

    private int currentPage;

    private int pageSize;

    private int totalPage;

    private List<T> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
