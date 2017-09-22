import java.text.SimpleDateFormat;
import java.util.Date;


public class Simpl {
	
	public static void main(String[] args) {
		SimpleDateFormat  formatter = new   SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss "); 
		Date date = new Date(System.currentTimeMillis());
		formatter.format(date);
		System.out.println(date);
	}

}
