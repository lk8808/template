package com.lk.template.portal.service;

import java.util.List;
import java.util.Map;

import com.lk.template.base.entity.UserObject;
import com.lk.template.portal.model.User;

public interface IUserService {
	
	public List<User> getAllUsers();
	
	public Map<String, Object> loginVerify (Map<String, Object> map) throws Exception;

	public void logout();
	
	public User getUserByUserName(String username);
	
	public UserObject getCurrentUser();
	
	public Map<String, Object> queryAllUsersByDepid(Map<String, Object> params);
	
	public Integer save(User user) throws Exception;
	public Integer resetPasswd(String ids);
	
	public Integer modifyPwd(String oldpasswd, String newpasswd) throws Exception;

	public Integer modifyTheme(String theme);

}
