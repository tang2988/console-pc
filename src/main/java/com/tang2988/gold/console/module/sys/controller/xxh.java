package com.tang2988.gold.console.module.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tang2988.gold.console.module.sys.entity.SysUser;

public class xxh extends SqlSessionDaoSupport{
	
	@RequestMapping("xxh")
	public String xxhh(HttpServletRequest request,Model model,String name){
		System.out.println(name);
		model.addAttribute("name", request.getParameter("name"));
		return "success";
		
	}
	@RequestMapping("/xxh1")
	public String xxh1(@RequestParam("name")String name,Model model){
		model.addAttribute("name", name);
		return "success";
	}
	
	@RequestMapping("/xxh2")
	public String xxh2(SysUser sysUser,Model model){
		model.addAttribute("name", sysUser.getLoginName());
		
		return "success";
	}
	
	
	@RequestMapping("/xxh3")
	public String xxh3(SysUser sysUser,Map<String,Object> map){
		map.put("name", sysUser.getLoginName());
		map.put("password", sysUser.getPassword());
		return "success";
	}
	
	@RequestMapping("/xxh4")
	public String xxh2(@ModelAttribute("user") SysUser user){
		
		
		return "success";
	}
	@RequestMapping("/xxh5")
	public String xxh5(){
		
		
		return "success";
	}
	
	
}
