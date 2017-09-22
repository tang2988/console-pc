package com.heshidai.gold.console.module.info.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.common.util.ResultUtil;
import com.heshidai.gold.console.module.info.service.AnnouncementService;
import com.heshidai.gold.console.module.sys.entity.Announcement;

@Controller
@RequestMapping("Announcement")
public class AnnouncementController {
	
	@Resource
	 private AnnouncementService announcementService;
	
	
	@RequestMapping("addAc")
	public String addAc(){
		return "modules/info/announ/add";
		
	}
	
	@RequestMapping("list.html")
	public String list(){
		return "modules/info/announ/list";
		
	}
	
	@RequestMapping("findAllpg.do")
	@ResponseBody
	public String findAll(Integer page,Integer pagesize){
		 Page<Announcement> pg = announcementService.findAllPage(page, pagesize);
		
		return ResultUtil.getJsonString(pg.getDatas(), pg.getTotalElements());
		
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public String add(String title,String content,String imageruri){
		Announcement announcement = new Announcement();
		announcement.setContent(content);
		announcement.setTitle(title);
		announcement.setImageruri(imageruri);
		announcementService.addAnnouncement(announcement);
		return "true";
		
	}
	
	@RequestMapping("update.html")
	public String update(Model model,Long announcementId){
		 Map<String, Object> map = announcementService.findByid(announcementId);
		 model.addAttribute("map", map);
		return "modules/info/announ/update";
		
	}
	@RequestMapping("update1.do")
	@ResponseBody
	public String update1(String title,String content,String imageruri,Long announcementId){
		Announcement announcement = new Announcement();
		announcement.setAnnouncementId(announcementId);
		announcement.setContent(content);
		announcement.setTitle(title);
		announcement.setImageruri(imageruri);
		announcementService.update(announcement);
		return "true";
		
	}
	

	@RequestMapping("findAllApi.do")
	@ResponseBody
	public String findAllApi( ){
		 List<Map<String, Object>> list = announcementService.findAAll();
		 JSONObject obj = new JSONObject();
	        obj.put("list", list);
	        return obj.toString();
	}
	
}
