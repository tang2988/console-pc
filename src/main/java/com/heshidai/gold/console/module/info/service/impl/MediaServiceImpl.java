package com.heshidai.gold.console.module.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heshidai.gold.console.common.entity.Page;
import com.heshidai.gold.console.module.info.dao.MediaDao;
import com.heshidai.gold.console.module.info.service.MediaService;
import com.heshidai.gold.console.module.sys.entity.Media;


@Service("mediaServiceImpl")
public class MediaServiceImpl implements MediaService {
	
	@Autowired
	MediaDao mediaDao;

	public List<Media> findAll() {
		return mediaDao.findAll();
	}

	public Map<String, Object> findById(Long mediaId) {
		return mediaDao.findById(mediaId);
	}
	


	public Page<Media> queryForPage(int pageNo,int pageSize ) {
		Page<Media> p = new Page<>();
		List<Media> list = new ArrayList<Media>();
		Long count = mediaDao.findCount();
		 if(count>0){
			 list = mediaDao.queryForPage(pageNo, pageSize);
		 }
		 p.setDatas(list);
		 p.setPage(pageNo);
		 p.setPagesize(pageSize);
		 p.setTotalElements(count);
		 
		return p;
	}

	public Long findCount() {
		return mediaDao.findCount();
	}

	public List<Map<String, Object>> findAllall() {
		return mediaDao.findAllall();
	}

	public Media add(Media media) {
		return mediaDao.add(media);
	}

	public Integer Modificationofnews(Media media) {
		return mediaDao.Modificationofnews(media);
	}

}
