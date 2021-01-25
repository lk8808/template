package com.lk.template.portal.service;

import java.util.Map;

import com.lk.template.portal.model.Role;

public interface IRoleService {

	public Map<String, Object> queryListWithPage(Map<String, Object> params);
	
	public Integer save(Role role) throws Exception;
	
	public Integer del(String ids);
	
}
