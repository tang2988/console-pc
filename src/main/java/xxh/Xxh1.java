package xxh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Xxh1 {
	public void  writea() throws IOException{
	//创建工作簿
	HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
	//创建工作表
	HSSFSheet hssfSheet  = hssfWorkbook.createSheet("hellow world");
	//创建行
	HSSFRow row = hssfSheet.createRow(1);
	//4.创建单元格
	HSSFCell Cell = row.createCell(2);
	Cell.setCellValue("123");
	//输出指定目录
	
	File file = new File("D:\\xxh\\123.xlsx");
	FileOutputStream output = new FileOutputStream("D:\\1xxh\\测试.xlsx");
	hssfWorkbook.write(output);
	
	output.close();
	}
	public void read() throws IOException{
		FileInputStream input  = new FileInputStream("D:\\1xxh\\测试.xlsx");
		//读取工作簿
		HSSFWorkbook workbook = new HSSFWorkbook(input);
		//读取工作表
		HSSFSheet hssfSheet = workbook.getSheetAt(0);
		//读取行
		HSSFRow row = hssfSheet.getRow(1);
		
		HSSFCell cell = row.getCell(2);
		
		System.out.println(cell.getStringCellValue());
		input.close();
		
	}
	public void wirte2() throws IOException{
		//工作簿
		Workbook workbook = new HSSFWorkbook();
		//工作表
		Sheet sheet = workbook.createSheet("xxh123");
		//工作行
		Row row = sheet.createRow(3);
		//单元格
		Cell cell = row.createCell(3);
		cell.setCellValue("谢雄辉");
		FileOutputStream output = new FileOutputStream("D:\\1xxh\\测试.xlsx");
		workbook.write(output);
		output.close();
	}
	
	public void read2() throws IOException{
		FileInputStream inputStream = new FileInputStream("D:\\1xxh\\测试.xlsx");
		//读取工作簿
		Workbook workbook = new HSSFWorkbook(inputStream);
		//读取工作表
		Sheet sheet = workbook.getSheetAt(0);
		//读取工作行
		Row row = sheet.getRow(1);
		//读取单元格
		Cell cel = row.getCell(2);
		System.out.println(cel.getStringCellValue());
		inputStream.close();
		
	}
	
	
	public static void main(String[] args) {
		Xxh1 xxh1 = new Xxh1();
		try {
			 xxh1.writea();
			 System.out.println(xxh1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
