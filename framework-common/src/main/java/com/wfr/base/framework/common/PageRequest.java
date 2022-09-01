package com.wfr.base.framework.common;

/**
 * 分页请求对象
 *
 * @author wangfarui
 * @since 2022/9/1
 */
public class PageRequest {

    int page = 1;

    int pageSize = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
