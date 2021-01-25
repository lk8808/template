package com.lk.template.org.dao;

import java.util.List;
import java.util.Map;

import com.lk.template.comm.dao.IBaseDao;
import com.lk.template.org.model.Empposlnk;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpposlnkDao extends IBaseDao<Empposlnk> {
	
	public int insertByDepidPosids(Map<String, Object> params);

	public List<Long> queryPosidsByEmpid(long empid);

	public int deleteByEmpid(long empid);
	
}
