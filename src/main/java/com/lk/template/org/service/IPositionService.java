package com.lk.template.org.service;

import java.util.List;
import java.util.Map;

import com.lk.template.org.model.Position;
import org.springframework.web.bind.annotation.RequestBody;

public interface IPositionService {

	public Map<String, Object> queryListWithPage(@RequestBody Map<String, Object> params);

	public List<Position> queryAllList();
	
	public Integer save(Position position) throws Exception;
	
	public Integer del(String ids);
}
