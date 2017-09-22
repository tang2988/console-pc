package com.heshidai.gold.console.module.info.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidDataSource;
import com.heshidai.gold.console.module.sys.entity.Media;


@Repository("mediaDaoImpl")
public class MediaDaoImpl implements MediaDao {

	
	@Autowired
	DruidDataSource dataSource;
	
	public List<Media> findAll(){
		List<Media> list = new ArrayList<Media>();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from t_media";
		 List<Map<String, Object>> list2 = jdbcTemplate.queryForList(sql);
		
		 for(Map<String, Object> map:list2){
			 Media media = new Media();
			 try {
				BeanUtils.populate(media, map);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(media);
		 }
		return list;
		
	}
	public List<Map<String, Object>> findAllall(){
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select mediaId,picture,content,title,DATE_FORMAT(time,'%Y-%m-%d %H:%i:%s') as time from t_media";

		 List<Map<String, Object>> list2 = jdbcTemplate.queryForList(sql);
		
		return list2;
		
	}
	public Map<String, Object> findById(Long mediaId){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		 String sql = "select * from t_media where mediaId = ?";
		 List<Map<String, Object>> list = jdbcTemplate.queryForList(sql , new Object[]{mediaId});
		return list.get(0);
	}
	

	
	public List<Media> queryForPage(int pageNo,int pageSize ) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Media> list = new ArrayList<Media>();
		int offset = pageSize*(pageNo-1);
		String sql = "select * from t_media LIMIT "+offset +","+pageSize;
		System.out.println(sql);
		 List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		 System.out.println(map);
		
		 for(Map<String, Object> map1:map){
			 Media media = new Media();
			 try {
				BeanUtils.populate(media, map1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(media);
		 }
		
		return list;
	}

	public Long findCount() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select count(1) from t_media";
		
		Long aa = jdbcTemplate.queryForObject(sql, Long.class);
		return aa;
	}
	
	public Media add(Media media){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String  sql = "INSERT INTO t_media (picture,content,title,time) VALUES(?,?,?,?)";
		 int tiaoshu = jdbcTemplate.update(sql,media.getPicture(),media.getContent(),media.getTitle(),media.getTime());
		return media;
		
	}
	
	public Integer Modificationofnews(Media media){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String  sql = "update t_media SET picture=?,content=?,title=?,time=? WHERE mediaId = ?";
		 int modifnews = jdbcTemplate.update(sql,media.getPicture(),media.getContent(),media.getTitle(),media.getTime(),media.getMediaId());
		return modifnews;
		
	}
}
