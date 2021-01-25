package com.lk.template.test;

import com.lk.template.org.dao.EmployeeDao;
import com.lk.template.org.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test1 {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Test
	public void test1() {
		Employee emp = employeeDao.get(1);
		System.out.println(emp);
	}
}
