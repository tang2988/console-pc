package com.tang2988.gold.console.module.info.service;

import java.util.Map;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.module.sys.entity.User;


public interface UserService {
	
public Map<String, Object> findUserById(Long userId);
	

	public Integer Update(User user);
	

	public User addUser(User user);
	
	public Long findcount();
	public Page<User> findUser(int pageNo,int pageSize);
	
}
