package com.funzuqiu.ffu.home.modules.ffu.entity;

import com.funzuqiu.ffu.home.common.persistence.DataEntity;

public class FfuApplication extends DataEntity {

    private static final long serialVersionUID = 1L;

    private String phone;
    private String stadium;
    private String address;
    private String league;
    private String realname;
    private Integer state; // 0：待处理，1：已通过，2：已驳回
    private String remark; // 审核结果备注
    private String channel; // 注册渠道

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

}
