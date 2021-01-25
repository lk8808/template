package com.lk.template.portal.service.impl;

import com.lk.template.base.entity.UserObject;
import com.lk.template.base.exception.RespException;
import com.lk.template.portal.dao.RoleDao;
import com.lk.template.utils.RedisUtil;
import com.lk.template.portal.model.Role;
import com.lk.template.portal.service.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Map<String, Object> queryListWithPage(Map<String, Object> params) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("bizdatas", roleDao.queryListWithPage(params));
		retMap.put("total", roleDao.count(params));
		return retMap;
	}

	@Override
	public Integer save(Role role) throws Exception {
		String token = request.getHeader("Token");
		Role tmp = new Role();
		tmp.setId(role.getId());
		tmp.setRoleno(role.getRoleno());
		if (!isUnique(tmp)) {
			throw new RespException("200001", "角色编号不唯一！");
		}
		UserObject userObject = (UserObject)redisUtil.get(token);
		if (role.getId() != null && role.getId() > 0) {
			role.setModifytime(new Date());
			role.setModifier(userObject.getUser().getUsername());
			return roleDao.update(role);
		} else {
			role.setDelflag("0");
			role.setCreatetime(new Date());
			role.setCreator(userObject.getUser().getUsername());
			return roleDao.insert(role);
		}
	}

	@Override
	public Integer del(String ids) {
		if (ids != null) {
			String[] idArr = ids.split(",");
			return roleDao.deleteBatch(idArr);
		}
		return 0;
	}

	private boolean isUnique(Role role) {
		Integer tmpId = role.getId();
		role.setId(null);
		Role tmp = roleDao.expand(role);
		if (tmp != null && tmpId != tmp.getId()) {
			return false;
		}
		return true;
	}
}
