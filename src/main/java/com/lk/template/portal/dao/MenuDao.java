package com.lk.template.portal.dao;

import java.util.List;
import java.util.Map;

import com.lk.template.comm.dao.IBaseDao;
import com.lk.template.portal.model.Menu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuDao extends IBaseDao<Menu> {

	public List<Menu> queryMenusByAppid(String appid);

	public List<Menu> queryAuthMenusByAppid(Map<String, Object> params);

	public List<Menu> queryMenusByParentid(String parentid);

	public List<Menu> queryAuthMenusByParentid(Map<String, Object> params);

	public Integer countSubMenusByParentid(Map<String, Object> params);

	public List<Menu> querySubMenusByAppidWithPage(Map<String, Object> params);
	
	public Integer countSubMenusByAppid(Map<String, Object> params);

}
