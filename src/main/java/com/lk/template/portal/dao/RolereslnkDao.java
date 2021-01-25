package com.lk.template.portal.dao;

import com.lk.template.comm.dao.IBaseDao;
import com.lk.template.portal.model.Rolereslnk;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolereslnkDao extends IBaseDao<Rolereslnk> {

    public List<Rolereslnk> queryByRoleid(Integer roleid);

    public Integer insertBatch(List<Rolereslnk> bizdatas);

    public Integer delByRoleid(Integer roleid);

}
