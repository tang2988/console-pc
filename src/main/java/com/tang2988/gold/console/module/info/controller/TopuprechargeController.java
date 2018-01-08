package com.tang2988.gold.console.module.info.controller;

import javax.annotation.Resource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tang2988.gold.console.common.util.ResultUtil;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.api.TopuprechargeApi;

@Controller
@RequestMapping("topuprecharge")
public class TopuprechargeController {
	@Resource
	TopuprechargeApi topuprechargeApi;
	
	@RequestMapping("Topuprecharge.do")
	@ResponseBody
	public String Topuprechargedo(Page page){
		page = topuprechargeApi.findTopuprechargePage(page);
		System.out.println(page);
		return ResultUtil.getJsonString(page.getDatas(), page.getTotalElements());
		
	}
	@RequestMapping("TopuUi")
	public String TopuUi(){
		return "modules/info/TopupWith/Topup";
	}
}
