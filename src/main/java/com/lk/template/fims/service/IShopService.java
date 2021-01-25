package com.lk.template.fims.service;

import com.lk.template.fims.model.Shop;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface IShopService {

    public Map<String, Object> queryListWithPage(@RequestBody Map<String, Object> params);

    public Integer save(Shop shop) throws Exception;

    public Integer del(String ids);

}
