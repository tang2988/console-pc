package com.tang2988.gold.console.module.info.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.common.util.ResultUtil;
import com.tang2988.gold.console.module.info.service.UserService;
import com.tang2988.gold.console.module.sys.entity.User;

@Controller
@RequestMapping("User")
public class UserhyController {
	
	@Resource
	private UserService service;
	
	@RequestMapping("userui")
	public String user(){
		return "modules/info/user/user";
	}
	
	@RequestMapping("findUserhtml")
	@ResponseBody
	public String findUser(Integer page, Integer pagesize){
		 Page<User> pg = service.findUser(page, pagesize);
		return ResultUtil.getJsonString(pg.getDatas(), pg.getTotalElements());
	}
	
	@RequestMapping("Modifyhtml")
	public String Modifyhtml(Model model,Long userId){
		  Map<String, Object> map = service.findUserById(userId);
		  model.addAttribute("map", map);
		return "modules/info/user/update";
	}
	
	@RequestMapping("Modifytheuser.do")
	@ResponseBody
	public String Modifytheuser(Long userId,String RealName,String Password,String transactionPwd,String mobilePhone,Integer UserStatus,String idcardNo){
		User user = new User();
		user.setIdcardNo(idcardNo);
		user.setMobilePhone(mobilePhone);
		user.setRealName(RealName);
		user.setPassword(Password);
		user.setUserId(userId);
		user.setUserStatus(UserStatus);
		service.Update(user);
		return "true";
	}
	@RequestMapping("add.do")
	@ResponseBody
	public String add(String RealName,String Password,String transactionPwd,String mobilePhone,Integer UserStatus,String idcardNo){
		User user = new User();
		user.setIdcardNo(idcardNo);
		user.setMobilePhone(mobilePhone);
		user.setRealName(RealName);
		user.setPassword(Password);
		
		user.setUserStatus(UserStatus);
		service.addUser(user);
		return "true";
	}
	
}
