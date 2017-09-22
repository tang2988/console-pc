package com.heshidai.gold.console.module.info.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidDataSource;
import com.heshidai.gold.console.common.dao.BasicDAO;
import com.heshidai.gold.console.module.sys.entity.Channel;
import com.heshidai.gold.console.module.sys.entity.Notice;
import com.sun.mail.util.BEncoderStream;

/**
 * 功能：渠道dao层
 * 
 * @version 2016年8月5日下午2:45:45
 * @author baocheng.ren
 */
@Repository("noticeDAO")
public class NoticeDAOImpl implements NoticeDAO {
	@Autowired
	DruidDataSource dataSource;

	public void insertPo() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "INSERT INTO t_notice "
				+ "(title, title2 ,content,noticeTime ) values " + "(?,?,?,?)";

		int count = jdbcTemplate.update(sql, new Object[] { "title", "title2",
				"content", new Date() });
		System.out.println(count);
	}

	public List<Map<String, Object>> selectAll() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select noticeId,title,title2,content,DATE_FORMAT(noticeTime,'%Y-%m-%d %H:%i:%s') AS noticeTime from t_notice";
		 List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
		return mapList;
	}

	public Integer update(Notice notice) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "update t_notice SET title=?,title2=?,content=?,noticeTime=?  WHERE noticeId=?";
		int updatenotice = jdbcTemplate.update(sql, new Object[]{notice.getTitle(),notice.getTitle2(),notice.getContent(),notice.getNoticeTime(),notice.getNoticeId()});
		System.out.println(updatenotice);
		return updatenotice;
	}

	public Notice addNotice(Notice notice) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO t_notice(title,title2,content,noticeTime)VALUES(?,?,?,?)";
		int updatenotice = jdbcTemplate.update(sql, new Object[]{notice.getTitle(),notice.getTitle2(),notice.getContent(),notice.getNoticeTime()});
		System.out.println(updatenotice);
		return notice;
	}

	
	public List<Notice> findAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Notice> list = new ArrayList<Notice>();
		String sql = "select * from t_notice";
		 List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		 System.out.println(map);
		 for(Map<String, Object> map1:map){
			 Notice notice = new Notice();
			
			 try {
				BeanUtils.populate(notice, map1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(notice);
		 }
		
		return list;
	}
	
	public Notice findById(Long id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_notice where noticeId = ? ";
		
		 List<Map<String, Object>> map = jdbcTemplate.queryForList(sql,new Object[]{id});
		 System.out.println(map);
		 Notice notice = new Notice();
		Map<String, Object> nt = map.get(0);
		try {
			BeanUtils.populate(notice, nt);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return notice;
	}
	
	
	public Map<String, Object> findOne(Long id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_notice where noticeId = ? ";
		
		  List<Map<String, Object>> map = jdbcTemplate.queryForList(sql,new Object[]{id});
		return map.get(0);
	}
	
	public List<Map<String, Object>> finddAll() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String sql = "select * from t_notice";
		List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
		return mapList;
	}
	
	public Long findOne11(Long id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		String sql = "select * from t_notice where noticeId = ? ";
		
		  List<Map<String, Object>> map = jdbcTemplate.queryForList(sql,new Object[]{id});
		return id;
	}
	

	public Long queryForPageCount( ) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select count(1) from t_notice ";
		 Long totalCount = jdbcTemplate.queryForObject(sql, Long.class);
		return totalCount;
	}
	
	public List<Notice> queryForPage(int pageNo,int pageSize ) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Notice> list = new ArrayList<Notice>();
		int offset = pageSize*(pageNo-1);
		String sql = "select * from t_notice LIMIT "+offset +","+pageSize;
		System.out.println(sql);
		 List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		 System.out.println(map);
		
		 for(Map<String, Object> map1:map){
			 Notice notice = new Notice();
			 try {
				BeanUtils.populate(notice, map1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(notice);
		 }
		
		return list;
	}
	
	
}
