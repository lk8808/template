package com.lk.template.org.service.impl;

import com.lk.template.org.dao.DepartmentDao;
import com.lk.template.org.dao.DepposlnkDao;
import com.lk.template.org.service.IDepposlnkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepposlnkServiceImpl implements IDepposlnkService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DepposlnkDao depposlnkDao;
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Map<String, Object>> queryByDepid(Long depid) {
		return depposlnkDao.queryByDepid(depid);
	}

	@Override
	public List<Map<String, Object>> queryAllList() {
		return depposlnkDao.queryAllList_ext();
	}

}
