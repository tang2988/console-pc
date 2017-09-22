package com.heshidai.gold.console.module.info.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidDataSource;
import com.heshidai.gold.console.module.sys.entity.Media;
import com.heshidai.gold.console.module.sys.entity.Orderinformation;
import com.sun.mail.util.BEncoderStream;

@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {

	@Autowired
	DruidDataSource dataSource;

	public List<Orderinformation> findAlloder() {
		List<Orderinformation> list = new ArrayList<Orderinformation>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from t_orderinformation";
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
		Orderinformation orderinformation = new Orderinformation();
		for (Map<String, Object> map : maps) {
			try {
				BeanUtils.populate(orderinformation, map);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			list.add(orderinformation);
		}
		return list;

	}

	public List<Map<String, Object>> findAllorder() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from t_orderinformation";
		List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

		return maps;

	}

	public Map<String, Object> findById(Long orderId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from t_orderinformation WHERE orderId = ?";
		 List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql,new Object[]{orderId});
		return maps.get(0);
	}
	
	public Integer updateorder(Orderinformation orderinformation){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "UPDATE t_orderinformation SET orderStatus = ?,deliverytime=? WHERE orderId = ?";
		 int tiaoshu = jdbcTemplate.update(sql,new Object[]{orderinformation.getOrderStatus(),orderinformation.getDeliverytime(),orderinformation.getOrderId()});
		return tiaoshu;
		
	}
	
	public List<Orderinformation> findPage(Integer pageno, Integer pageSize){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Orderinformation> list = new ArrayList<Orderinformation>();
		int offset = pageSize*(pageno-1);
		String sql = "select * from t_orderinformation LIMIT "+offset +","+pageSize;
		System.out.println(sql);
		 List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		 System.out.println(map);
		
		 for(Map<String, Object> map1:map){
			 Orderinformation order = new Orderinformation();
			 try {
				BeanUtils.populate(order, map1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(order);
		 }
		
		return list;
	}
	public Long findCount(){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(1) from t_orderinformation";
		Long count = jdbcTemplate.queryForObject(sql, Long.class);
		return count;
	}
}
