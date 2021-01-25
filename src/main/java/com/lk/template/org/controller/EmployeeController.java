package com.lk.template.org.controller;

import java.util.List;
import java.util.Map;

import com.lk.template.org.model.Employee;
import com.lk.template.org.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	
	@RequestMapping("/get")
	public Employee get(int id) {
		return employeeService.get(id);
	}

	@RequestMapping("/queryAllList")
	public List<Employee> queryAllList() {
		return employeeService.queryAllList();
	}
	
	@RequestMapping("/queryEmpsByDepid")
	public Map<String, Object> queryEmpsByDepid(@RequestBody Map<String, Object> params) {
		return employeeService.queryEmpsByDepid(params);
	}
	
	@RequestMapping("/queryAllEmpsByDepid")
	public Map<String, Object> queryAllEmpsByDepid(@RequestBody Map<String, Object> params) {
		return employeeService.queryAllEmpsByDepid(params);
	}
	
	@RequestMapping(value="/save")
	public Integer save(@RequestBody Employee employee) throws Exception {
		return employeeService.save(employee);
	}
	
	@RequestMapping(value="/del")
	public Integer del(String ids) {
		return employeeService.del(ids);
	}

}
