package com.tang2988.gold.console.module.info.dao;

import java.text.SimpleDateFormat;

public class Date {

	public static void main(String[] args) {
		SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd"); //格式化当前系统日期
		String dateTime = dateFm.format(new java.util.Date());
		System.out.println(dateTime);
		
	
	}
}
