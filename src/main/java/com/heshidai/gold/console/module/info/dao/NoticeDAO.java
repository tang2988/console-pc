package com.heshidai.gold.console.module.info.dao;

import java.util.List;
import java.util.Map;

import com.heshidai.gold.console.module.sys.entity.Notice;

/**
 * 功能：渠道dao层
 *
 * @version 2016年8月5日下午2:45:45
 * @author baocheng.ren
 */
public interface NoticeDAO  {

	public void insertPo() ;
	
	public List<Map<String, Object>> selectAll() ;
	
	public Integer update(Notice notice);
	
	public Notice addNotice(Notice  notice);
	
	public List<Notice> findAll();
	
	public Notice findById(Long id);
	
	public Map<String, Object> findOne(Long id) ;

	public List<Map<String, Object>> finddAll();
	
	public Long findOne11(Long id);
	public Long queryForPageCount( ) ;
	public List<Notice> queryForPage(int pageNo,int pageSize ) ;
}
