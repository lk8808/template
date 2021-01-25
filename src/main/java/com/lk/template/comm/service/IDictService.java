package com.lk.template.comm.service;

import java.util.List;
import java.util.Map;

import com.lk.template.comm.model.Dict;

public interface IDictService {

	public List<Dict> queryDictsByDicttypeid(String dicttypeid);
	
	public Dict getDict(String dicttypeid, String dictid);
	
	public Map<String, Object> queryDicttypesWithPage(Map<String, Object> params);
}
