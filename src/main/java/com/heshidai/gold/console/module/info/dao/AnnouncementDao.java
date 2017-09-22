package com.heshidai.gold.console.module.info.dao;

import java.util.List;
import java.util.Map;

import com.heshidai.gold.console.module.sys.entity.Announcement;

public interface AnnouncementDao {
	
	public Integer update(Announcement announcement);
	
	public Announcement addAnnouncement(Announcement announcement);
	
	public Map<String,Object> findByid(Long id);
	
	public List<Announcement> findAll();
	
	public List<Map<String, Object>> findAAll();
	
	public Long findCount();
	public List<Announcement> findAllPage(int pageNo, int pageSize);

}
