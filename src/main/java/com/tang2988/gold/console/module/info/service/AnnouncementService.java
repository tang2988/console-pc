package com.tang2988.gold.console.module.info.service;

import java.util.List;
import java.util.Map;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.module.sys.entity.Announcement;

public interface AnnouncementService {
	
public Integer update(Announcement announcement);
	
	public Announcement addAnnouncement(Announcement announcement);
	
	public Map<String,Object> findByid(Long id);
	
	public List<Announcement> findAll();
	
	public List<Map<String, Object>> findAAll();
	
	public Page<Announcement> findAllPage(int pageNo, int pageSize);
	
	public Long findCount();

}
