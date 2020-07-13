package com.funzuqiu.ffu.home.common.persistence;

public abstract class DataEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public DataEntity() {
    }

    public DataEntity(String id) {
        super(id);
    }

    /**
     * 插入之前执行方法，需要手动调用
     */
    @Override
    public void preInsert() {
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    @Override
    public void preUpdate() {
    }

}
