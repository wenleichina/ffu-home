package com.funzuqiu.ffu.home.common.persistence;

import java.util.List;

public interface CrudMapper<T> extends BaseMapper {

    /**
     * 获取单条数据
     * 
     * @param id
     * @return
     */
    public T getById(String id);

    /**
     * 获取单条数据
     * 
     * @param entity
     * @return
     */
    public T get(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     * 
     * @param entity
     * @return
     */
    public List<T> list(T entity);

    /**
     * 插入数据
     * 
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     * 
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 删除数据
     * 
     * @param entity
     * @return
     */
    public int delete(String id);

}