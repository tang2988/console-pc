package com.tang2988.gold.console.module.info.service;

import java.util.List;
import java.util.Map;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.module.sys.entity.Notice;

public interface NoticeService {

	public void addNotice() ;
	
	public List<Map<String, Object>> selectAll() ;
	
	public Integer updateNotice(Notice notice);
	
	public Notice addNotice(Notice  notice);
	
	public List<Notice> findAll();

	public Notice findById(Long id);
	
	public Map<String, Object> findOne(Long id);
	
	public List<Map<String, Object>> finddAll();
	
	
	public Long findOne11(Long id);
	
	public Page<Notice> queryForPage(int pageNo,int pageSize ) ;
}


