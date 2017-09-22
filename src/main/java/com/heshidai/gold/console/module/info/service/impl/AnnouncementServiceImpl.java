package com.heshidai.gold.console.module.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.module.info.dao.AnnouncementDao;
import com.heshidai.gold.console.module.info.service.AnnouncementService;
import com.heshidai.gold.console.module.sys.entity.Announcement;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	AnnouncementDao announcementDao;

	public Integer update(Announcement announcement) {
		return announcementDao.update(announcement);
	}

	public Announcement addAnnouncement(Announcement announcement) {
		return announcementDao.addAnnouncement(announcement);
	}

	public Map<String, Object> findByid(Long id) {
		return announcementDao.findByid(id);
	}

	public List<Announcement> findAll() {
		return announcementDao.findAll();
	}

	public List<Map<String, Object>> findAAll() {
		return announcementDao.findAAll();
	}

	public Page<Announcement> findAllPage(int pageNo, int pageSize) {
		
		Page<Announcement> pg = new Page<>();
		 Long count = announcementDao.findCount();
		 List<Announcement> list = new ArrayList<Announcement>();
		 if(count>0){
			  list = announcementDao.findAllPage(pageNo, pageSize);
		 }
		 pg.setPagesize(pageSize);
		 pg.setTotalElements(count);
		 pg.setPage(pageNo);
		 pg.setDatas(list);
		return pg;
		
	
	}

	public Long findCount() {
		return announcementDao.findCount();
	}
}
