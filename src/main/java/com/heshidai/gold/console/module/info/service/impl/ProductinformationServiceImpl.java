package com.heshidai.gold.console.module.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.module.info.dao.ProductinformationDao;
import com.heshidai.gold.console.module.info.service.ProductinformationService;
import com.heshidai.gold.console.module.sys.entity.Productinformation;

@Service("productinformationServiceImpl")
public class ProductinformationServiceImpl implements ProductinformationService {

	@Autowired
	ProductinformationDao dao;

	public Productinformation addProduct(Productinformation productinformation) {
		return dao.addProduct(productinformation);
	}

	public Map<String, Object> findProById(Long productId) {
		return dao.findProById(productId);
	}

	public Page<Productinformation> findAllPage(int pageNo, int pageSize) {
		Page<Productinformation> pg = new Page<Productinformation>();
		List<Productinformation> list = new ArrayList<Productinformation>();
		Long count = dao.procount();
		if (count > 0) {
			list = dao.findAllPage(pageNo, pageSize);
		}
		pg.setDatas(list);
		pg.setPagesize(pageSize);
		pg.setPage(pageNo);
		pg.setTotalElements(count);
		return pg;
	}

	public Integer UpdateAll(Productinformation productinformation) {
		return dao.UpdateAll(productinformation);
	}

	public Long procount() {
		return dao.procount();
	}

}
