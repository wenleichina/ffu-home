package com.funzuqiu.ffu.home.common.persistence;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.funzuqiu.commons.mapper.JsonMapper;
import com.github.pagehelper.PageInfo;

/**
 * 分页类
 */
public class Page<T> {

    // 当前页
    private int pageNum;
    // 每页的数量
    private int pageSize;
    // 当前页的数量
    private int size;
    // 总页数
    private int pages;
    // 总记录数
    protected long total;
    // 返回结果集
    @JsonIgnore
    private List<T> list;

    public Page() {
    }

    /**
     * 直接返回查询结果集时使用
     * 
     * @param queryList 查询结果集，作为返回数据
     */
    public Page(List<T> queryList) {
        this(queryList, queryList);
    }

    /**
     * 返回自定义结果集时使用
     * 
     * @param queryList 查询结果集
     * @param dataList  自定义结果集，作为返回数据
     */
    public Page(List<?> queryList, List<T> dataList) {
        PageInfo<?> pageInfo = new PageInfo<>(queryList);
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.size = pageInfo.getSize();
        this.pages = pageInfo.getPages();
        this.total = pageInfo.getTotal();

        this.list = dataList;
    }

    @Override
    public String toString() {
        return JsonMapper.toJson(this);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
