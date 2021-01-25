package com.lk.template.portal.service;

import java.util.List;
import java.util.Map;

import com.lk.template.portal.model.Roleauthcfg;

public interface IRoleauthcfgService {

	public List<Roleauthcfg> queryByRoleid(Integer roleid);

	public Integer saveBath(Map<String, Object> params);
}
