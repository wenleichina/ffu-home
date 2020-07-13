package com.funzuqiu.ffu.home.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.funzuqiu.ffu.home.common.persistence.CrudMapper;
import com.funzuqiu.ffu.home.common.persistence.DataEntity;
import com.funzuqiu.ffu.home.common.persistence.Page;
import com.funzuqiu.ffu.home.common.persistence.Pager;
import com.github.pagehelper.PageHelper;

@Transactional(readOnly = true)
public abstract class CrudService<M extends CrudMapper<T>, T extends DataEntity> extends BaseService {

    /**
     * 持久层对象
     */
    @Autowired
    protected M mapper;

    /**
     * 获取单条数据
     * 
     * @param id
     * @return
     */
    public T get(String id) {
        if (id == null) {
            return null;
        }
        return afterRetrieve(mapper.getById(id));
    }

    /**
     * 获取单条数据
     * 
     * @param entity
     * @return
     */
    public T get(T entity) {
        if (entity == null) {
            return null;
        }
        return afterRetrieve(mapper.get(entity));
    }

    /**
     * 查询列表数据
     * 
     * @param entity
     * @return
     */
    public List<T> list(T entity) {
        return afterRetrieve(mapper.list(entity));
    }

    /**
     * 查询分页数据
     * 
     * @param page   分页对象
     * @param entity
     * @return
     */
    public Page<T> page(Pager pager, T entity) {
        PageHelper.startPage(pager);
        return new Page<>(afterRetrieve(mapper.list(entity)));
    }

    /**
     * 查询完成后对结果进行处理
     * 
     * @param entity
     * @return
     */
    protected T afterRetrieve(T entity) {
        return entity;
    }

    protected List<T> afterRetrieve(List<T> entities) {
        return entities;
    }

    /**
     * 保存数据（插入或更新）
     * 
     * @param entity
     */
    @WriteTx
    public void save(T entity) {
        if (entity.isNewRecord()) {
            entity.preInsert();
            mapper.insert(entity);
        } else {
            entity.preUpdate();
            mapper.update(entity);
        }
    }

    /**
     * 删除数据
     * 
     * @param entity
     */
    @WriteTx
    public void delete(String id) {
        if (id == null) {
            return;
        }
        mapper.delete(id);
    }

}
