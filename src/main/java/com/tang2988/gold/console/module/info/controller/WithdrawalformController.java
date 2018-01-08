package com.tang2988.gold.console.module.info.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tang2988.gold.console.common.util.ResultUtil;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.api.WithdrawalformApi;

@Controller
@RequestMapping("Withdrawalform")
public class WithdrawalformController {
	
	@Resource
	WithdrawalformApi withdrawalformApi;
	
	@RequestMapping("withUi")
	public String withUI(){
		return "modules/info/TopupWith/withform";
	}
	@RequestMapping("with.do")
	@ResponseBody
	public String withdo(Page page){
		 page= withdrawalformApi.findTopuprechargePage(page);
		return ResultUtil.getJsonString(page.getDatas(), page.getTotalElements());
	}

	

}
