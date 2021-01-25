package com.lk.template.org.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lk.template.base.entity.RespData;
import com.lk.template.base.entity.UserObject;
import com.lk.template.base.exception.RespException;
import com.lk.template.portal.dao.UserDao;
import com.lk.template.utils.DateUtil;
import com.lk.template.utils.MD5Util;
import com.lk.template.utils.RedisUtil;
import com.lk.template.org.dao.EmployeeDao;
import com.lk.template.org.dao.EmpposlnkDao;
import com.lk.template.org.model.Employee;
import com.lk.template.portal.model.User;
import com.lk.template.org.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmpposlnkDao empposlnkDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HttpSession session;

	@Override
	public Employee get(int id) {
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> queryAllList() {
		return employeeDao.queryAllList();
	}
	
	@Override
	public Map<String, Object> queryEmpsByDepid(Map<String, Object> params) {
		Map<String, Object> retMap = new HashMap<>();
		int depid = params.get("depid") == null ? 0 : (int)params.get("depid");
		List<Employee> bizdatas = null;
		int total = 0;
		if (depid > 0) {
			params.put("depid", depid);
			bizdatas = employeeDao.queryEmpsByDepidWithPage(params);
			total = employeeDao.countEmpsByDepid(params);
		} else {
			bizdatas = employeeDao.queryListWithPage(params);
			total = employeeDao.count(params);
		}
		for (Employee employee : bizdatas) {
			employee.setPosids(empposlnkDao.queryPosidsByEmpid(employee.getId()));
		}
		retMap.put("bizdatas", bizdatas);
		retMap.put("total", total);
		return retMap;
	}

	@Override
	public Map<String, Object> queryAllEmpsByDepid(Map<String, Object> params) {
		Map<String, Object> retMap = new HashMap<>();
		int depid = params.get("depid") == null ? 0 : (int)params.get("depid");
		List<Employee> bizdatas = null;
		int total = 0;
		if (depid > 0) {
			params.put("depid", depid);
			bizdatas = employeeDao.queryAllEmpsByDepidWithPage(params);
			total = employeeDao.countAllEmpsByDepid(params);
		} else {
			bizdatas = employeeDao.queryListWithPage(params);
			total = employeeDao.count(params);
		}
		for (Employee employee : bizdatas) {
			employee.setPosids(empposlnkDao.queryPosidsByEmpid(employee.getId()));
		}
		retMap.put("bizdatas", bizdatas);
		retMap.put("total", total);
		return retMap;
	}

	@Override
	@Transactional
	public Integer save(Employee employee) throws Exception{
		String token = request.getHeader("Token");
		Employee tmp = new Employee();
		tmp.setId(employee.getId());
		tmp.setEmpno(employee.getEmpno());
		if (!isUnique(tmp)) {
			throw new RespException("200001", "员工号不唯一！");
		}
		UserObject userObject = (UserObject)redisUtil.get(token);
		if (employee.getPhoto_ext() != null) {
			employee.setPhoto(employee.getPhoto_ext().getBytes());
		}
		if (employee.getId() != null && employee.getId() > 0) {
			employee.setModifier(userObject.getUser().getUsername());
			employee.setModifytime(new Date());
			employeeDao.update(employee);
			//更新用户
			User user = new User();
			user.setUsername(employee.getEmpno());
			user.setEmployeeid(employee.getId());
			user.setTelephone(employee.getTelephone());
			user.setModifier(userObject.getUser().getUsername());
			user.setModifytime(new Date());
			userDao.updateByEmployeeid(user);
		} else {
			employee.setDelflag("0");
			employee.setCreator(userObject.getUser().getUsername());
			employee.setCreatetime(new Date());
			employeeDao.insert(employee);
			//新增用户
			User user = new User();
			user.setEmployeeid(employee.getId());
			user.setUsername(employee.getEmpno());
			//密码默认000000
			user.setPasswd(MD5Util.md5Encode("000000"));
			user.setTelephone(employee.getTelephone());
			user.setCreator(userObject.getUser().getUsername());
			user.setCreatetime(new Date());
			user.setEnableflag("Y");
			user.setErrornum(0);
			user.setPasswdduedate(DateUtil.addDays(new Date(), -1));
			user.setDelflag("0");
			userDao.insert(user);
		}
		//删除旧的员工岗位
		empposlnkDao.deleteByEmpid(employee.getId());
		//添加员工岗位
		if (employee.getPosids() != null && employee.getPosids().size() > 0) {
			Map<String, Object> params = new HashMap<String, Object>();
			List posidArr = employee.getPosids();
			params.put("posids", posidArr);
			params.put("empid", employee.getId());
			params.put("depid", employee.getDepartmentid());
			params.put("creator", userObject.getUser().getUsername());
			empposlnkDao.insertByDepidPosids(params);
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer del(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			return employeeDao.deleteBatch(idArr);
		}
		return 0;
	}

	private boolean isUnique(Employee employee) {
		RespData respData = new RespData();
		Long tmpId = employee.getId();
		employee.setId(null);
		Employee tmp = employeeDao.expand(employee);
		if (tmp != null && tmpId != tmp.getId()) {
			return false;
		}
		return true;
	}

}
