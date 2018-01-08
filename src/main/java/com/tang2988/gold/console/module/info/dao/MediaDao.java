package com.tang2988.gold.console.module.info.dao;

import java.util.List;
import java.util.Map;

import com.tang2988.gold.console.module.sys.entity.Media;

public interface MediaDao {

	public List<Media> findAll();
	
	public Map<String, Object> findById(Long mediaId);
	

	
	public List<Media> queryForPage(int pageNo,int pageSize );
	
	public Long findCount();
	
	public List<Map<String, Object>> findAllall();
	
	public Media add(Media media);
	
	public Integer Modificationofnews(Media media);
}
