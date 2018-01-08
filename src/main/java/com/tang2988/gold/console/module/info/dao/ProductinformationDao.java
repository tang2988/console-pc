package com.tang2988.gold.console.module.info.dao;

import java.util.List;
import java.util.Map;

import com.tang2988.gold.console.module.sys.entity.Productinformation;

public interface ProductinformationDao {


		public Productinformation addProduct(Productinformation productinformation);

		public Map<String, Object> findProById(Long productId);

		public List<Productinformation> findAllPage(int pageNo, int pageSize);

		public Integer UpdateAll(Productinformation productinformation);

		public Long procount();

}
