package com.funzuqiu.ffu.home.common.persistence;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;
    protected LocalDateTime gmtCreate;
    protected LocalDateTime gmtModified;

    protected Map<String, String> sqlMap; // 自定义SQL（SQL标识，SQL内容）

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    /**
     * 插入之前执行方法，子类实现
     */
    public abstract void preInsert();

    /**
     * 更新之前执行方法，子类实现
     */
    public abstract void preUpdate();

    @JsonIgnore
    @XmlTransient
    public boolean isNewRecord() {
        return StringUtils.isBlank(getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @JsonIgnore
    @XmlTransient
    public Map<String, String> getSqlMap() {
        return sqlMap;
    }

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

}
