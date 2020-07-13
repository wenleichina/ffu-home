package com.funzuqiu.ffu.home.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my")
public class MyProperties {

    private String userfilesBasedir;
    private Integer pageSize = 15;

    public String getUserfilesBasedir() {
        return userfilesBasedir;
    }

    public void setUserfilesBasedir(String userfilesBasedir) {
        this.userfilesBasedir = userfilesBasedir;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
