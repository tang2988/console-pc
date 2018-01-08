package com.tang2988.gold.console.module.info.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.common.util.ResultUtil;
import com.tang2988.gold.console.module.info.service.OrderService;
import com.tang2988.gold.console.module.sys.entity.Orderinformation;

@Controller
@RequestMapping("order")
public class OderController {

	@Resource
	private OrderService orderService;

	@RequestMapping("orderui")
	public String orderui(String deliverytime) {

		return "modules/info/order/order";
	}

	@RequestMapping("findAll.do")
	@ResponseBody
	public String findAll(Integer page,Integer pagesize) {
		
		Page<Orderinformation> pg = orderService.findPage(page, pagesize);
		return ResultUtil.getJsonString(pg.getDatas(), pg.getTotalElements());
	}

	@RequestMapping("delivery.html")
	public String updateHtml(Model model, Long orderId) {
		String url = "http://localhost:8080/goldUser2/order/findOne.do?orderrId="
				+ orderId;
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		String entity = "";
		try {
			CloseableHttpResponse rsp = http.execute(get);
			entity = EntityUtils.toString(rsp.getEntity(), "utf-8");
			JSONObject jsonObject = JSONObject.parseObject(entity);

			model.addAttribute("orderBean",
					JSONObject.parse(jsonObject.get("order") + ""));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "modules/info/order/update";
	}

	@RequestMapping("delivery.do")
	@ResponseBody
	public String update(Long orderId, Long trackingNumberCourierNumber,
			String distributioncompany) {

		String url = "http://localhost:8080/goldUser2/order/delivery.do?orderId="
				+ orderId
				+ "&distributioncompany="
				+ distributioncompany
				+ "&trackingNumberCourierNumber=" + trackingNumberCourierNumber;
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		try {
			CloseableHttpResponse response = http.execute(get);
			String entity = EntityUtils.toString(response.getEntity());
			JSONObject.parseObject(entity);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//

		return "true";
	}

	@RequestMapping("Returngoods.html")
	
	public String Returngood(Model model, Long orderId) {
		String url = "http://localhost:8080/goldUser2/order/findOne.do?orderrId="
				+ orderId;
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(url);
		String entity = "";
		try {
			CloseableHttpResponse rsp = http.execute(get);
			entity = EntityUtils.toString(rsp.getEntity(), "utf-8");
			JSONObject jsonObject = JSONObject.parseObject(entity);

			model.addAttribute("orderBean",
					JSONObject.parse(jsonObject.get("order") + ""));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "modules/info/order/Returngoods";
		
	
	}
	
	@RequestMapping("Returngoods.do")
	@ResponseBody
	public String Returngoods(Long orderId) {
		String uri = "http://localhost:8080/goldUser2/order/ReturnGoods.do?orderId="+orderId;
		CloseableHttpClient http = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet(uri);
		String entity = "";
		try {
			CloseableHttpResponse rsp = http.execute(get);
			entity = EntityUtils.toString(rsp.getEntity(), "utf-8");
			JSONObject jsonObject = JSONObject.parseObject(entity);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "true";
	
	}
	@RequestMapping("Xls.do")
	@ResponseBody
	public void orderxml(HttpServletResponse rs) {
		Workbook workbook = orderService.Orderxml();
		try {
			rs.addHeader("Content-Disposition", "attachment; filename=xxh.xls");
			ServletOutputStream output = rs.getOutputStream();
			
			workbook.write(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
