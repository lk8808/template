package com.lk.template.comm.controller;

import com.lk.template.base.entity.RespData;
import com.lk.template.comm.model.Bizfile;
import com.lk.template.comm.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private IFileService fileService;

    @RequestMapping(value="/upload")
    public RespData upload(@RequestParam("file") MultipartFile file) {
        return fileService.upload(file);
    }

    @RequestMapping(value="/queryByEntity")
    public List<Bizfile> queryByEntity(@RequestBody Map<String, Object> params) {
        return fileService.queryByEntity(params);
    }

    @RequestMapping(value="/del")
    public Integer del(Long fileid) {
        return fileService.del(fileid);
    }

}
