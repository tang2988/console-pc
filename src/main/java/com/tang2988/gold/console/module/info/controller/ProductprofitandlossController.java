package com.tang2988.gold.console.module.info.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tang2988.gold.console.common.util.ResultUtil;

import cn.xxh.gold.common.utils.Page;
import cn.xxh.gold.sys.api.ProductProditandApi;
import cn.xxh.gold.vo.ProductProfitandLossVo;


@Controller
@RequestMapping("productloss")
public class ProductprofitandlossController {
	
	@Resource
	ProductProditandApi productProditandApiImpl;
	
	@RequestMapping("findloss")
	@ResponseBody
	public String findLoss(Page page){
		page = productProditandApiImpl.Pagefind(page);
		return ResultUtil.getJsonString(page.getDatas(), page.getTotalElements());
		
	}
	@RequestMapping("findlossui")
	public String findlossui(){
		return "modules/info/produloss/produloss";
		
	}
	
	@RequestMapping("addProductProditUl")
	
	public String addProductProditUl(){
		return "modules/info/produloss/add";
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public String adddo(String productName ,BigDecimal expectedAnnualizedInterestRate,BigDecimal activityPlusInterest,Integer productDeadline ,BigDecimal sumofMoneyPurchaseddecimal,Integer productStatus){
		ProductProfitandLossVo loss = new ProductProfitandLossVo();
		loss.setProductName(productName);
		loss.setExpectedAnnualizedInterestRate(expectedAnnualizedInterestRate);
		loss.setActivityPlusInterest(activityPlusInterest);
		loss.setProductDeadline(productDeadline);
		loss.setSumofMoneyPurchaseddecimal(sumofMoneyPurchaseddecimal);
		loss.setProductStatus(productDeadline);
		productProditandApiImpl.addProductProfitandLoss(loss );
		return "true";
		
	}
}
