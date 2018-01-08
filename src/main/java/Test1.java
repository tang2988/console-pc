

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tang2988.gold.console.module.info.dao.MediaDao;
import com.tang2988.gold.console.module.sys.entity.Media;

public class Test1 {
	public static void main(String[] args) {

		ApplicationContext ct = new ClassPathXmlApplicationContext(
				"spring-context.xml");
		MediaDao dao = (MediaDao) ct.getBean("mediaDaoImpl");
		 Media media = new Media();
		 media.setContent("123");
		 media.setPicture("123");
		 media.setTime(new Date());
		 media.setTitle("123");
		 Media lst = dao.add(media );
		System.out.println(lst);
	}

}
