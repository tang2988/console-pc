package com.heshidai.gold.console.module.info.dao;

import java.util.List;
import java.util.Map;

import com.heshidai.gold.console.module.sys.entity.Orderinformation;

public interface OrderDao {
	
	public List<Orderinformation> findAlloder();
	
	public List<Map<String, Object>> findAllorder();
	
	public Map<String, Object> findById(Long orderId);
	
	public Integer updateorder(Orderinformation orderinformation);
	
	public List<Orderinformation> findPage(Integer pageno, Integer pageSize);
	
	public Long findCount();

}
