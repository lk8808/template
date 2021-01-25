package com.lk.template.org.dao;

import java.util.List;
import java.util.Map;

import com.lk.template.comm.dao.IBaseDao;
import com.lk.template.org.model.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDao extends IBaseDao<Department> {

	public List<Department> queryDepartmentsLevel1();
	
	public List<Department> queryDepartmentsByParentid(long parentid);
	
	public List<Department> queryAllDepsByParentidWithPage(Map<String, Object> params);
	
	public int countAllDepsByParentid(Map<String, Object> params);

}
