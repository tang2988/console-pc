package com.heshidai.gold.console.module.info.service;

import java.util.List;
import java.util.Map;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.module.sys.entity.Productinformation;

public interface ProductinformationService {
	
	public Productinformation addProduct(Productinformation productinformation);

	public Map<String, Object> findProById(Long productId);

	public Page<Productinformation> findAllPage(int pageNo, int pageSize);

	public Integer UpdateAll(Productinformation productinformation);

	public Long procount();
}
