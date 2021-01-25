package com.lk.template.org.dao;

import java.util.List;
import java.util.Map;

import com.lk.template.comm.dao.IBaseDao;
import com.lk.template.org.model.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao extends IBaseDao<Employee> {
	
	public List<Employee> queryEmpsByDepidWithPage(Map<String, Object> params);
	
	public int countEmpsByDepid(Map<String, Object> params);

	public List<Employee> queryAllEmpsByDepidWithPage(Map<String, Object> params);
	
	public int countAllEmpsByDepid(Map<String, Object> params);

}
