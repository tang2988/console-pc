package com.tang2988.gold.console.module.info.service.impl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.module.info.dao.ProductinformationDao;
import com.tang2988.gold.console.module.info.service.ProductinformationService;
import com.tang2988.gold.console.module.sys.entity.Productinformation;

@Service("productinformationServiceImpl")
public class ProductinformationServiceImpl implements ProductinformationService {

	@Autowired
	ProductinformationDao dao;

	public Productinformation addProduct(Productinformation productinformation) {
		return dao.addProduct(productinformation);
	}

	public Map<String, Object> findProById(Long productId) {
		return dao.findProById(productId);
	}

	public Page<Productinformation> findAllPage(int pageNo, int pageSize) {
		Page<Productinformation> pg = new Page<Productinformation>();
		List<Productinformation> list = new ArrayList<Productinformation>();
		Long count = dao.procount();
		if (count > 0) {
			list = dao.findAllPage(pageNo, pageSize);
		}
		pg.setDatas(list);
		pg.setPagesize(pageSize);
		pg.setPage(pageNo);
		pg.setTotalElements(count);
		return pg;
	}

	/**
	 * 将查询结果封装进XLS
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Workbook findAllPageIntoXLS( ) {
		List<Productinformation> list = new ArrayList<Productinformation>();
		list = dao.findAllPage(1, 999999999);
		if (list ==null) {
			list = new ArrayList<Productinformation>();
		}

		// 工作簿
		Workbook workbook = new HSSFWorkbook();
		// 工作表
		Sheet sheet = workbook.createSheet("xxh123");
		// 工作行
		Row row = sheet.createRow(0);
		// 单元格
		row.createCell(0).setCellValue("产品ID");
		row.createCell(1).setCellValue("产品类型");
		row.createCell(2).setCellValue("克重");
		row.createCell(3).setCellValue("品牌");
		row.createCell(4).setCellValue("产品价格");
		row.createCell(5).setCellValue("库存");
		row.createCell(6).setCellValue("详情页");
		row.createCell(7).setCellValue("产品名称");
		row.createCell(8).setCellValue("状态");
		
		int beginRow = 1;
		for (Productinformation product : list) {
			Row tmpRow = sheet.createRow(beginRow);
			tmpRow.createCell(0).setCellValue(product.getProductId() + "");
			tmpRow.createCell(1).setCellValue(product.getProductType() + "");
			tmpRow.createCell(2).setCellValue(product.getGramWeight() + "");
			tmpRow.createCell(3).setCellValue(product.getBrand() + "");
			tmpRow.createCell(4).setCellValue(product.getProductPrice()+ "");
			tmpRow.createCell(5).setCellValue(product.getBepertory() + "");
			tmpRow.createCell(6).setCellValue(product.getDetailpage() + "");
			tmpRow.createCell(7).setCellValue(product.getProductName() + "");
			tmpRow.createCell(8).setCellValue(product.getProductStatus() + "");

			beginRow++;
		}
		return workbook;
	}
	
	public Integer UpdateAll(Productinformation productinformation) {
		return dao.UpdateAll(productinformation);
	}

	public Long procount() {
		return dao.procount();
	}

}
