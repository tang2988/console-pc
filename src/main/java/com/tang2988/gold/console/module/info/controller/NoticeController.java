package com.tang2988.gold.console.module.info.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.common.util.ResultUtil;
import com.tang2988.gold.console.module.info.service.NoticeService;
import com.tang2988.gold.console.module.sys.entity.Notice;

/**
 * 功能：用户信息相关控制层
 *
 * @version 2016年8月16日下午5:09:47
 * @author baocheng.ren
 */
@Controller
@RequestMapping("notice")
public class NoticeController  {
    
    private Logger log = LoggerFactory.getLogger(getClass());
    
    /**
     * 用户信息service
     */
    @Resource
    private NoticeService noticeService;
    
    /**
     * 功能：跳转到添加用户界面
     *
     * @version 2016年12月27日下午7:02:47
     * @author baocheng.ren
     * @return String
     */
    @RequestMapping("addUI")
    public String addUI() {
        return "modules/info/notice/add";
    }
    
    @RequestMapping("xxhxxh")
    public String xxhxxh() {
        return "modules/info/notice/xxhxxh";
    }
    
    @RequestMapping("update")
    public String update(Model model ,Long noticeId) {
    	 Map<String, Object> notice = noticeService.findOne(noticeId);
    	 notice.put("noticeTimeFmt",  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(notice.get("noticeTime")));
    	model.addAttribute("notice", notice);
        return "modules/info/notice/update";
    }
    
    
    
    /**
     * 功能：添加用户信息
     *
     * @version 2016年12月27日下午7:03:00
     * @author baocheng.ren
     * @param sysUser 对象
     * @return String
     */
    @RequestMapping("add.do")
    @ResponseBody
    public String add(String title,String title2,String content,String noticeTime) {
    	Notice notice = new Notice();
    	
    	notice.setTitle(title);
    	notice.setTitle2(title2);
    	notice.setContent(content);
    	notice.setNoticeTime(new Date());
		noticeService.addNotice(notice);
        return  "true" ;
    }
    
    @RequestMapping("update.do")
    @ResponseBody
    public String updatedo(String title,String title2,String content,String noticeTime,Long noticeId) {
    	Notice notice = new Notice();
    	notice.setTitle(title);
    	notice.setTitle2(title2);
    	notice.setContent(content);
    	notice.setNoticeTime(new Date());
    	
    	notice.setNoticeId(noticeId);
		noticeService.updateNotice(notice );
        return "true";
    }
    
    
    
    /**
     * 功能：跳转到用户信息列表界面
     *
     * @version 2016年12月26日下午6:00:16
     * @author baocheng.ren
     * @return String
     */
    @RequestMapping("findListUI")
    public String findListTestUI() {
        return "modules/info/notice/list";
    }
    
    @RequestMapping("GirdUI")
    public String GirdUI() {
        return "modules/info/notice/Grid";
    }
    @RequestMapping("ToolBar")
    public String ToolBar() {
        return "modules/info/notice/ToolBar";
    }
    
    /**
     * 功能：查询用户信息列表
     *
     * @version 2016年12月26日下午6:00:34
     * @author baocheng.ren
     * @param model model
     * @param page page
     * @return String
     */
    @RequestMapping("findList.do")
    @ResponseBody
    public String findListTest(Model model,Integer page,Integer pagesize ) {
       Page<Notice> p = this.noticeService.queryForPage(page, pagesize);
        return ResultUtil.getJsonString( p.getDatas(),  p.getTotalElements());
    }
    
    @RequestMapping("notice.do")
    @ResponseBody
    public String announcement() {
        List<Map<String, Object>> maplist = noticeService.selectAll();
        JSONObject  jsonObject = new JSONObject();
        
        jsonObject.put("maplist", maplist);
         return jsonObject.toString();
     }
    
    
    @RequestMapping("noticeId.do")
    @ResponseBody
    public String noticeId(Long noticecId) {
        Map<String, Object> map = noticeService.findOne(noticecId);
        if(map==null){
        	map = new HashMap<String, Object>();
        }
        JSONObject jo = new JSONObject(map);
        map.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(map.get("noticeTime")));
         return jo.toString();
     }
    
}
