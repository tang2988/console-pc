package com.heshidai.gold.console.module.info.service;

import java.util.List;
import java.util.Map;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.module.sys.entity.Orderinformation;

public interface OrderService {
	
	public List<Orderinformation> findAlloder();
	
	public List<Map<String, Object>> findAllorder();
	
	public Map<String, Object> findById(Long orderId);
	
	public Integer updateorder(Orderinformation orderinformation);
	
	public Page<Orderinformation> findPage(int pageno, int pageSize);
	
	public Long findCount();
	
	

}
