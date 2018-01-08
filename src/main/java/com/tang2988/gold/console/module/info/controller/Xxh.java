package com.tang2988.gold.console.module.info.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

public class Xxh {
	public static void main(String[] args) {
		
		double qianfenwei = 11230.1000;
		

		NumberFormat numberFormat1 = NumberFormat.getNumberInstance();
		String number = numberFormat1.format(qianfenwei);
		System.out.println(number);
	
		
		
		 String str = DecimalFormat.getNumberInstance().format(qianfenwei);
		 System.out.println("转换成带千分位的格式："+str);   
		 

	        String currecy =new DecimalFormat("##,##0.00").format(qianfenwei);
	        System.out.println("转换成Currency格式："+currecy);


	        
	        
	        
	        System.out.println(Double.valueOf(currecy.replaceAll(",", "")));
	        
	        
	        
	}

}
