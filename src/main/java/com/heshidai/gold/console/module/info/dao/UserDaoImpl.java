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
import com.heshidai.gold.console.module.sys.entity.User;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

	@Autowired
	DruidDataSource dataSource;
	
	public Map<String, Object> findUserById(Long userId) {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from t_user WHERE UserId = ?";
		 List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,new Object[]{userId});
		return list.get(0);
	}

	public Integer Update(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update t_user SET RealName =?,Password=?,transactionPwd=?,mobilePhone=?,UserStatus=?,idcardNo = ? where UserId =?";
		 int ts = jdbcTemplate.update(sql, new Object[]{user.getRealName(),user.getPassword(),user.getTransactionPwd(),user.getMobilePhone(),user.getUserStatus(),user.getIdcardNo(),user.getUserId()});
		return ts;
	}

	public User addUser(User user) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO t_user "
				+ "(RealName,Password,transactionPwd,mobilePhone,UserStatus,idcardNo)values"
				+ "(?,?,?,?,?,?)";
		int tiaoshu = jdbcTemplate.update(sql, new Object[]{user.getRealName(),user.getPassword(),user.getTransactionPwd(),user.getMobilePhone(),user.getUserStatus(),user.getIdcardNo()});
		System.out.println(tiaoshu);
		return user;
	}

	public Long findcount() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(1) from t_user ";
		Long longcount = jdbcTemplate.queryForObject(sql, Long.class);
		return longcount;
	}
	
	public List<User> findUser(int pageNo,int pageSize){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> list = new ArrayList<User>();
		int gongshi = pageSize*(pageNo-1);
		String sql = "select * from t_user LIMIT "+gongshi +","+pageSize;
		System.out.println(sql);
		 List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		 System.out.println(map);
		
		 for(Map<String, Object> map1:map){
			 User user = new User();
			 try {
				BeanUtils.populate(user, map1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(user);
		 }
		
		return list;
	}
	


}
