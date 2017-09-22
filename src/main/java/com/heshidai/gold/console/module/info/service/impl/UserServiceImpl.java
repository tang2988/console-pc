package com.heshidai.gold.console.module.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.module.info.dao.UserDao;
import com.heshidai.gold.console.module.info.service.UserService;
import com.heshidai.gold.console.module.sys.entity.User;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	public Map<String, Object> findUserById(Long userId) {
		return dao.findUserById(userId);
	}

	public Integer Update(User user) {
		return dao.Update(user);
	}

	public User addUser(User user) {
		return dao.addUser(user);
	}

	public Long findcount() {
		return dao.findcount();
	}

	public Page<User> findUser(int pageNo, int pageSize) {
		Page<User> pg = new Page<>();
		List<User> list = new ArrayList<User>();
		Long count = dao.findcount();
		if(count>0){
			list = dao.findUser(pageNo, pageSize);
		}
		pg.setDatas(list);
		pg.setPage(pageNo);
		pg.setPagesize(pageSize);
		pg.setTotalElements(count);
		return pg;
	}

	
}
