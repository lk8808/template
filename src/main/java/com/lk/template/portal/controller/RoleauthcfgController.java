package com.lk.template.portal.controller;

import java.util.List;
import java.util.Map;

import com.lk.template.portal.model.Roleauthcfg;
import com.lk.template.portal.service.IRoleauthcfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roleauthcfg")
public class RoleauthcfgController {
	
	@Autowired
	private IRoleauthcfgService roleauthcfgService;
	
	@RequestMapping("/queryByRoleid")
	public List<Roleauthcfg> queryByRoleid(Integer roleid) {
		return roleauthcfgService.queryByRoleid(roleid);
	}

	@RequestMapping("/saveBath")
	public Integer saveBath(@RequestBody Map<String, Object> params) {
		return roleauthcfgService.saveBath(params);
	}
}
