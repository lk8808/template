package com.lk.template.portal.controller;

import com.lk.template.portal.model.Rolereslnk;
import com.lk.template.portal.service.IRolereslnkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rolereslnk")
public class RolereslnkController {

    @Autowired
    private IRolereslnkService rolereslnkService;

    @RequestMapping("/queryByRoleid")
    public List<Rolereslnk> queryByRoleid(Integer roleid) {
        return rolereslnkService.queryByRoleid(roleid);
    }

    @RequestMapping("/saveBath")
    public Integer saveBath(@RequestBody Map<String, Object> params) {
        return rolereslnkService.saveBath(params);
    }

}
