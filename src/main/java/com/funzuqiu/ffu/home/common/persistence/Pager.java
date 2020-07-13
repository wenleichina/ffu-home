package com.funzuqiu.ffu.home.common.persistence;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.github.pagehelper.IPage;

/**
 * 分页类
 */
public class Pager implements IPage {

    public static int DEFAULT_PAGE_SIZE = 15;

    // 当前页
    private int pageNum;
    // 每页的数量
    private int pageSize;
    // 排序
    private String orderBy;

    public Pager() {
        this.pageNum = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public Pager(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public Pager(HttpServletRequest request) {
        this();

        String pageNum = request.getParameter("pageNum");
        if (StringUtils.isNumeric(pageNum)) {
            this.pageNum = Integer.parseInt(pageNum);
        }

        String pageSizeStr = request.getParameter("pageSize");
        if (StringUtils.isNumeric(pageSizeStr)) {
            int pageSize = Integer.parseInt(pageSizeStr);
            if (pageSize <= 50) {
                this.pageSize = pageSize;
            }
        }
    }

    public Pager(HttpServletRequest request, int pageSize) {
        this(request);
        this.pageSize = pageSize;
    }

    @Override
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}
