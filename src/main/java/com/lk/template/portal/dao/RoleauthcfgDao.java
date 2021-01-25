package com.lk.template.portal.dao;

import java.util.List;

import com.lk.template.comm.dao.IBaseDao;
import org.apache.ibatis.annotations.Mapper;

import com.lk.template.portal.model.Roleauthcfg;

@Mapper
public interface RoleauthcfgDao extends IBaseDao<Roleauthcfg> {

	public List<Roleauthcfg> queryByRoleid(Integer roleid);
	
	public Integer insertBatch(List<Roleauthcfg> roleauthcfgs);
	
	public Integer delByRoleid(Integer roleid);
	
}
