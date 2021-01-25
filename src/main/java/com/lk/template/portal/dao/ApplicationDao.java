package com.lk.template.portal.dao;

import java.util.List;

import com.lk.template.comm.dao.IBaseDao;
import org.apache.ibatis.annotations.Mapper;

import com.lk.template.portal.model.Application;

@Mapper
public interface ApplicationDao extends IBaseDao<Application> {
	
	List<Application> queryAllAuthList(String userid);
	
}
