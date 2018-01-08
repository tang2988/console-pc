package com.tang2988.gold.console.module.info.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidDataSource;
import com.tang2988.gold.console.module.sys.entity.Productinformation;

@Repository("productinformationDaoImpl")
public class ProductinformationDaoImpl implements ProductinformationDao {

	@Autowired
	DruidDataSource dataSource;

	public Productinformation addProduct(Productinformation pf) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "INSERT INTO t_productinformation(productType,gramWeight,brand,productPrice,bepertory,detailpage,productName,productStatus)"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		int tiaoshu = jdbcTemplate.update(
				sql,
				new Object[] { pf.getProductType(), pf.getGramWeight(),
						pf.getBrand(), pf.getProductPrice(), pf.getBepertory(),
						pf.detailpage, pf.getProductName(),
						pf.getProductStatus() });
		System.out.println(tiaoshu);
		return pf;
	}

	public Map<String, Object> findProById(Long productId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from t_productinformation where productId = ?";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,new Object[]{productId});
		return list.get(0);
	}

	public List<Productinformation> findAllPage(int pageNo, int pageSize) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Productinformation> list = new ArrayList<Productinformation>();

		int gongshi = pageSize*(pageNo - 1);
		String sql = "select * from t_productinformation LIMIT "+gongshi+","+pageSize;
		 List<Map<String, Object>> list2 = jdbcTemplate.queryForList(sql);
		 for(Map<String, Object> map:list2){
			 Productinformation  productinformation = new Productinformation();
			 try {
				 
				BeanUtils.populate(productinformation, map);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(productinformation);
		 }
		return list;

	}

	public Integer UpdateAll(Productinformation productinformation) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update t_productinformation SET productType=?,gramWeight=?,brand=?,productPrice=?,"
				+ "bepertory=?,detailpage=?,productName=?,productStatus=? "
				+ "WHERE productId = ?";
		 int ct = jdbcTemplate.update(sql);
		return ct;
	}

	public Long procount() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select count(1) from t_productinformation";
		 Long lg = jdbcTemplate.queryForObject(sql, Long.class);
		return lg;
	}
	
	public Integer StateofModification(Productinformation productinformation){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "";
		jdbcTemplate.queryForList(sql );
		return null;
		
		
	}

}
