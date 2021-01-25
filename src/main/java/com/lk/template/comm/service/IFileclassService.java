package com.lk.template.comm.service;

import com.lk.template.comm.model.Fileclass;

import java.util.Map;

public interface IFileclassService {

    public Map<String, Object> queryListWithPage(Map<String, Object> map);

    public Integer save(Fileclass fileclass) throws Exception;

    public Integer del(String ids);

}
