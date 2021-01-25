package com.lk.template.portal.dao;

import java.util.List;
import java.util.Map;

import com.lk.template.comm.dao.IBaseDao;
import org.apache.ibatis.annotations.Mapper;

import com.lk.template.portal.model.Role;

@Mapper
public interface RoleDao extends IBaseDao<Role> {
	
	public List<Role> queryRolesByAppid(Integer appid);
	
	public List<Role> queryRolesByAppidWithPage(Map<String, Object> params);
	
	public Integer countByAppid(Map<String, Object> params);

}
