package com.lk.template.org.dao;

import com.lk.template.comm.dao.IBaseDao;
import com.lk.template.org.model.Depposlnk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepposlnkDao extends IBaseDao<Depposlnk> {
	
	public List<Map<String, Object>> queryByDepid(Long depid);

	public List<Map<String, Object>> queryAllList_ext();
	
	public int insertByDepidPosids(Map<String, Object> params);

	public int deleteByDepid(long depid);
}
