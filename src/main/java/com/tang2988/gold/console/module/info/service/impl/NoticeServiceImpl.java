package com.tang2988.gold.console.module.info.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.module.info.dao.NoticeDAO;
import com.tang2988.gold.console.module.info.service.NoticeService;
import com.tang2988.gold.console.module.sys.entity.Notice;

/**
 * 功能：渠道业务层
 *
 * @version 2016年8月5日下午2:47:06
 * @author baocheng.ren
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDAO noticeDAO;

	
	public void addNotice() {
		noticeDAO.insertPo();
	}
	
	
	public List<Map<String, Object>> selectAll() {
		return noticeDAO.selectAll();
	}


	public Integer updateNotice(Notice notice) {
		return noticeDAO.update(notice);
	}


	public Notice addNotice(Notice notice) {
		return noticeDAO.addNotice(notice);
	}


	public List<Notice> findAll() {
		return noticeDAO.findAll();
	}
	@Override
	public Notice findById(Long id){
		return noticeDAO.findById(id);
	}
	
	public Map<String, Object> findOne(Long id){
		return noticeDAO.findOne(id);
	}


	public List<Map<String, Object>> finddAll() {
		return noticeDAO.finddAll();
	}


	public Long findOne11(Long id) {
		return noticeDAO.findOne11(id);
	}
	
	public Page<Notice> queryForPage(int pageNo,int pageSize ) {
		
		Page<Notice> p = new Page<>();
		Long totalCount = noticeDAO.queryForPageCount( );
		List<Notice> list =new ArrayList<Notice>();
		if(totalCount>0){
			list = noticeDAO.queryForPage(pageNo, pageSize);
		}
		p.setPage(pageNo);
		p.setPagesize(pageSize);
		p.setTotalElements(totalCount);
		p.setDatas(list);
		return p;
	}
}
