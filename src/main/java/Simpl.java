import java.text.SimpleDateFormat;
import java.util.Date;

import cn.xxh.date.DateUtil;


public class Simpl {
	
	public static void main(String[] args) {
		SimpleDateFormat  formatter = new   SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss "); 
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		
		System.out.println(DateUtil.formatDate(new Date(), "yyyy年MM月dd日   HH:mm:ss "));
	}

}
