package com.tang2988.gold.console.module.info.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidDataSource;
import com.tang2988.gold.console.module.sys.entity.Announcement;

@Repository("announcementDao")
public class AnnouncementDaoImpl implements AnnouncementDao {
	
	@Autowired
	DruidDataSource dataSource;
	
	
	public Integer update(Announcement announcement){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update t_announcement SET title=?,content=?,imageruri=? WHERE announcementId=?";
		int count = jdbcTemplate.update(sql, new Object[]{announcement.getTitle(),announcement.getContent(),announcement.getImageruri(),announcement.getAnnouncementId()});
		return count;
		
	}
	
	public Announcement addAnnouncement(Announcement announcement){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO t_announcement(title,content,imageruri)values(?,?,?)";
		 int add = jdbcTemplate.update(sql, new Object[]{announcement.getTitle(),announcement.getContent(),announcement.getImageruri()});
		return announcement;
		
	}
	
	public Map<String,Object> findByid(Long id){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql ="select * from t_announcement WHERE announcementId = ?";
		List<Map<String, Object>> map = jdbcTemplate.queryForList(sql,new Object[]{id});
		return map.get(0);
	}
	
	public List<Announcement> findAll(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Announcement> list = new ArrayList<Announcement>();
		String sql ="select * FROM t_announcement";
		 List<Map<String, Object>> map1 = jdbcTemplate.queryForList(sql);
		 Announcement announcement = new Announcement();
		 for(Map<String, Object> map:map1){
			 try {
				BeanUtils.populate(announcement, map);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		 }
		 list.add(announcement);
		return list;
		
	}
	
	public List<Map<String, Object>> findAAll() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * FROM t_announcement";
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
		return mapList;
	}
	
	public Long findCount(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select COUNT(1) from t_announcement ";
		
		Long count = jdbcTemplate.queryForObject(sql,Long.class);
		return count;
		
		
	}
	
	public List<Announcement> findAllPage(int pageNo, int pageSize){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Announcement> list = new ArrayList<Announcement>();
		int  offset = pageSize*(pageNo-1) ;
		String sql = "select * from t_announcement LIMIT "+offset +","+pageSize;
		System.out.println(sql); 
		List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		 System.out.println(map);
		 
		 for(Map<String, Object> map1:map){
			 Announcement announcement = new Announcement();
			 try {
				BeanUtils.populate(announcement, map1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(announcement);
		 }
		 
		return list;
		
	}

}
