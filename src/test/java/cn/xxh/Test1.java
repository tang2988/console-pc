package cn.xxh;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tang2988.gold.console.module.info.dao.NoticeDAO;
import com.tang2988.gold.console.module.sys.entity.Notice;

public class Test1 {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		NoticeDAO noticeDAO = (NoticeDAO) ctx.getBean("noticeDAO");
		List<Notice> lst = noticeDAO.queryForPage(1, 2);
		System.out.println(lst);
	}

}
