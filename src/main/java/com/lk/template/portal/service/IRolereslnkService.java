package com.lk.template.portal.service;

import com.lk.template.portal.model.Rolereslnk;

import java.util.List;
import java.util.Map;

public interface IRolereslnkService {

    public List<Rolereslnk> queryByRoleid(Integer roleid);

    public Integer saveBath(Map<String, Object> params);

}
