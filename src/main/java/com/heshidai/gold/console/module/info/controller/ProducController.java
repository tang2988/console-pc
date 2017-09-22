package com.heshidai.gold.console.module.info.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.common.util.ResultUtil;
import com.heshidai.gold.console.module.info.service.ProductinformationService;
import com.heshidai.gold.console.module.sys.entity.Productinformation;


@Controller
@RequestMapping("produ")
public class ProducController {
	
	@Resource 
	private ProductinformationService productinformationService;
	@RequestMapping("produUi")
	public String produUi(){
		
	
		return "modules/info/produ/produ";
		
	}
	
	@RequestMapping("findAll")
	@ResponseBody
	public String findAll(Integer page,Integer pagesize){
		
		 Page<Productinformation> list = productinformationService.findAllPage(page, pagesize);

		return ResultUtil.getJsonString(list.getDatas(), list.getTotalElements());
//		String entiy = "";
//		try {
//			String url = "http://localhost:8080/goldUser2/prod/findAll?pageNo="+page+"&pageSize="+pagesize+"";
//			CloseableHttpClient http = HttpClientBuilder.create().build();
//			HttpGet get = new HttpGet(url);
//			CloseableHttpResponse rs =  http.execute(get);
//			 entiy = EntityUtils.toString(rs.getEntity(),"utf-8");
//			JSONObject.parseObject(entiy);
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		 

	}
	
	@RequestMapping("addhtml")
	public String addhtml(){
		
		return "modules/info/produ/add";
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public String adddo(String productType,String gramWeight,String brand,BigDecimal productPrice,Integer bepertory,String detailpage,String productName,Integer productStatus){

		Productinformation productinformation = new Productinformation();
		productinformation.setProductType(productType);
		productinformation.setGramWeight(gramWeight);
		productinformation.setBrand(brand);
		productinformation.setProductPrice(productPrice);
		productinformation.setBepertory(bepertory);
		productinformation.setDetailpage(detailpage);
		productinformation.setProductName(productName);
		productinformation.setProductStatus(productStatus);
		 Productinformation aa = productinformationService.addProduct(productinformation);
		
		//		String entiy = "";
//		try {
//			String url = "http://localhost:8080/goldUser2/prod/addProduct?productType="+productType+"&gramWeight="+gramWeight+"&brand="+brand+"&productPrice="+productPrice+"&bepertory="+bepertory+"&detailpage="+detailpage+"&productName="+productName+"&productStatus="+productStatus+"";
//			CloseableHttpClient http = HttpClientBuilder.create().build();
//			HttpGet get = new HttpGet(url);
//			CloseableHttpResponse rs =  http.execute(get);
//			 entiy = EntityUtils.toString(rs.getEntity(),"utf-8");
//			JSONObject.parseObject(entiy);
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		 
		 
		return "true";
	}
	@RequestMapping("updateProdu")
	public String updateProdu(Model model ,Long productId){
		
		Map<String, Object> map = productinformationService.findProById(productId);
		model.addAttribute("json", map);
//		String entiy = "";
//		try {
//			String url = "http://localhost:8080/goldUser2/prod/findAllById?productId="+productId;
//			CloseableHttpClient http = HttpClientBuilder.create().build();
//			HttpGet get = new HttpGet(url);
//			CloseableHttpResponse rs =  http.execute(get);
//			 entiy = EntityUtils.toString(rs.getEntity(),"utf-8");
//			 JSONObject json = JSONObject.parseObject(entiy);
//			model.addAttribute("json", JSONObject.parse(json.get("product")+""));
//		} catch (ClientProtocolException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return "modules/info/produ/update";
	}
	
	@RequestMapping("update.do")
	@ResponseBody
	public String updatedo(String productType,String gramWeight,String brand,BigDecimal productPrice,Integer bepertory,String detailpage,String productName,Integer productStatus){
		
		Productinformation productinformation = new Productinformation();
		productinformation.setProductType(productType);
		productinformation.setGramWeight(gramWeight);
		productinformation.setBrand(brand);
		productinformation.setProductPrice(productPrice);
		productinformation.setBepertory(bepertory);
		productinformation.setDetailpage(detailpage);
		productinformation.setProductName(productName);
		productinformation.setProductStatus(productStatus);
		  Integer aa = productinformationService.UpdateAll(productinformation);
		  System.out.println(aa);
		return "true";
		
	}
	
}
