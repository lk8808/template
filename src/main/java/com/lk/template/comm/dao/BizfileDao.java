package com.lk.template.comm.dao;

import com.lk.template.comm.model.Bizfile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BizfileDao extends IBaseDao<Bizfile> {

    public List<Bizfile> queryByEntity(Map<String, Object> params);

}
