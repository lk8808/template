package com.lk.template.comm.service;

import com.lk.template.base.entity.RespData;

import java.util.Set;

public interface ICacheService {

    public Integer getInlineNum();

    public Set getKeys(String pattern);

    public Object getCache(String key);

    public RespData removeCache(String pattern);
    
}
