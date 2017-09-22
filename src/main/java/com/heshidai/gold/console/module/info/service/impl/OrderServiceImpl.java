package com.heshidai.gold.console.module.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.module.info.dao.OrderDao;
import com.heshidai.gold.console.module.info.service.OrderService;
import com.heshidai.gold.console.module.sys.entity.Orderinformation;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	public List<Orderinformation> findAlloder() {
		return orderDao.findAlloder();
	}
	
	public List<Map<String, Object>> findAllorder(){
		return orderDao.findAllorder();
		
	}

	
	public Map<String, Object> findById(Long orderId) {
		return orderDao.findById(orderId);
	}

	
	public Integer updateorder(Orderinformation orderinformation) {
		return orderDao.updateorder(orderinformation);
	}

	public Page<Orderinformation> findPage(int pageno, int pageSize) {
		Page<Orderinformation> page = new Page<>();
		List<Orderinformation> list = new ArrayList<Orderinformation>();
		 Long count = orderDao.findCount();
		 if(count>0){
			   list = orderDao.findPage(pageno, pageSize);
		 }
		 page.setDatas(list);
		 page.setPage(pageno);
		 page.setPagesize(pageSize);
		 page.setTotalElements(count);
		 
		return page;
	}

	public Long findCount() {
		return orderDao.findCount();
	}

}
