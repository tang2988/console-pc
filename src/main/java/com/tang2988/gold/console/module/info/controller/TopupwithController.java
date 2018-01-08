package com.tang2988.gold.console.module.info.controller;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("Topupwith")
public class TopupwithController {

	@RequestMapping("TopuUi")
	public String topui() {

		return "modules/info/TopupWith/Topup";
	}

	@RequestMapping("Withform")
	public String withform() {

		return "modules/info/TopupWith/withform";
	}

	@RequestMapping("Topup")
	@ResponseBody
	public String Topup(Integer page, Integer pagesize) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		String url = "http://localhost:8080/goldUser2/topwith/topup?pageno="
				+ page + "&pagesize=" + pagesize + "";
		HttpGet get = new HttpGet(url);
		String entity = "";
		try {
			CloseableHttpResponse rs = client.execute(get);
			entity = EntityUtils.toString(rs.getEntity());

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@RequestMapping("withform.do")
	@ResponseBody
	public String withform(Integer page, Integer pagesize) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		String url = "http://localhost:8080/goldUser2/topwith/withform?pageno="
				+ page + "&pagesize=" + pagesize + "";
		HttpGet get = new HttpGet(url);
		String entity = "";
		try {
			CloseableHttpResponse rs = client.execute(get);
			entity = EntityUtils.toString(rs.getEntity());

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@RequestMapping("findById")
	public String findById(Model model, Long withdrawalId) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		String url = "http://localhost:8080/goldUser2/topwith/findById?withdrawalId="
				+ withdrawalId + "";
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse rs;
		try {
			rs = httpClient.execute(get);
			String entity = EntityUtils.toString(rs.getEntity());
			JSONObject jsonObject = JSONObject.parseObject(entity);

			model.addAttribute("araay",
					JSONObject.parse(jsonObject.get("list") + ""));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "modules/info/TopupWith/updatWith";
	}

	@RequestMapping("modifystate.do")
	@ResponseBody
	public String modifystate(Long withdrawalId, Integer rechargeStatus) {
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		String url = "http://localhost:8080/goldUser2/topwith/updateStatusSuccesstime?withdrawalId="
				+ withdrawalId + "&rechargeStatus=" + Integer.valueOf(rechargeStatus) + "";
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse rs;
		try {
			rs = httpClient.execute(get);
			String entity = EntityUtils.toString(rs.getEntity());
			JSONObject.parseObject(entity);

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "true";
	}

}
