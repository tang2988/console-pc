package com.tang2988.gold.console.module.info.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.api.OrderSteadyprofitApi;
import cn.xxh.gold.sys.api.http.OrderSteadyprofitHttpApi;

import com.tang2988.gold.console.common.util.ResultUtil;


@Controller
@RequestMapping("steady")
public class SteadyprofitController {
	
	@Resource
	OrderSteadyprofitApi orderSteadyprofitApi;
	
	OrderSteadyprofitHttpApi orderSteadyprofitHttpApi;
	@RequestMapping("findByPage")
	@ResponseBody
	public String findByPage(Page queryPage){
		
		queryPage = orderSteadyprofitApi.findByPage(queryPage);
		
		System.out.println(queryPage);
		
		return ResultUtil.getJsonString(queryPage.getDatas(), queryPage.getTotalElements());
	}
	@RequestMapping("steadyUi")
	public String  steadyUi(){
		
		return "modules/info/steadyprofit/stead";
		
	}
	
	

}
