package com.tang2988.gold.console.module.info.service;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.module.sys.entity.Productinformation;

public interface ProductinformationService {
	
	public Productinformation addProduct(Productinformation productinformation);

	public Map<String, Object> findProById(Long productId);

	public Page<Productinformation> findAllPage(int pageNo, int pageSize);
	
	/**
	 * 将查询结果封装进XLS
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Workbook findAllPageIntoXLS( ) ;
	

	public Integer UpdateAll(Productinformation productinformation);

	public Long procount();
}
