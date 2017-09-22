package com.heshidai.gold.console.module.info.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.common.util.ResultUtil;
import com.heshidai.gold.console.module.info.service.MediaService;
import com.heshidai.gold.console.module.sys.entity.Media;

@Controller
@RequestMapping("mediaa")
public class MediaController {
	@Resource
	private MediaService service;
	
	@RequestMapping("findAllhtml.do")
	public String findAllHtml(){
		
		return "modules/info/media/media";
	}
	
	
	@RequestMapping("findAll.do")
	@ResponseBody
	public String findAlldo(Integer page,Integer pagesize) {
		
		 Page<Media> pagea = service.queryForPage(page, pagesize);
		 
		return ResultUtil.getJsonString(pagea.getDatas(), pagea.getTotalElements());
		
	}
	@ResponseBody
	@RequestMapping("findAll")
	public String findAll(){
		 List<Map<String, Object>> list = service.findAllall();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("list", list);
		
		return jsonObject.toJSONString();
	}
	
	@RequestMapping("findById")
	@ResponseBody
	public String findId(Long mediaId){
		
		Map<String, Object> map = service.findById(mediaId);
		if(map==null){
			map = new HashMap<String, Object>();
		}
		map.put("noticeTimeFmt", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(map.get("time")));
		  
		JSONObject jsonObject = new JSONObject(map);
		return jsonObject.toString();
	}
	
	@RequestMapping("modifymedia")
	
	public String update (Model model,Long mediaId){
		 Map<String, Object> map = service.findById(mediaId);
		 model.addAttribute("orderBean", map);
		
		return "modules/info/media/update";
	}
	@RequestMapping("modifymedia.do")
	@ResponseBody
	public String modifyemedia(Long mediaId,String content,String picture,String title){
		Media media = new Media();
		media.setContent(content);
		media.setMediaId(mediaId);
		media.setPicture(picture);
		media.setTitle(title);
		media.setTime(new Date());
		 service.Modificationofnews(media);
		
		return "true";
	}
	@RequestMapping("add.html")
	public String add(){
		
		return "modules/info/media/add";
	}
	
	@RequestMapping("add.do")
	@ResponseBody
		public String adddo(String picture,String content,String title){
		Media media = new Media();
		media.setPicture(picture);
		media.setContent(content);
		media.setTitle(title);
		media.setTime(new Date());
		service.add(media);
		
		return "true";
	}

	
	@RequestMapping("upload.do")
    @ResponseBody
    public String upload(HttpServletRequest request)   {

        MultipartHttpServletRequest req = (MultipartHttpServletRequest)request;
        MultipartFile f1 = req.getFile("image");
        if(f1==null){
        	JSONObject json = new JSONObject();
        	json.put("isOk", false);
        	return json.toJSONString();
        }
        
        File f = new File("D:\\0apache-tomcat-8.5.20\\webapps\\imgSrv\\"+f1.getOriginalFilename());
    	try {
			f1.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			JSONObject json = new JSONObject();
        	json.put("isOk", false);
        	return json.toJSONString();
			
		}
    	
    	String acessUrl = "http://192.168.1.6:8080/imgSrv/"+f1.getOriginalFilename();
    	JSONObject json = new JSONObject();
    	json.put("isOk", true);
    	json.put("acessUrl", acessUrl);
    	return json.toJSONString();
    }
	@RequestMapping("findPage")
	public String findPage(){
		return null;
		
	}
}
