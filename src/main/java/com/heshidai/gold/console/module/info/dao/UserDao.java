package com.heshidai.gold.console.module.info.dao;

import java.util.List;
import java.util.Map;

import com.heshidai.gold.console.module.sys.entity.User;



public interface UserDao {
	

	
	public Map<String, Object> findUserById(Long userId);
	

	public Integer Update(User user);
	

	public User addUser(User user);
	
	public Long findcount();
	
	public List<User> findUser(int pageNo,int pageSize);
	
	

}
