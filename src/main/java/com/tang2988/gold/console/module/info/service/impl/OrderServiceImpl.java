package com.tang2988.gold.console.module.info.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang2988.gold.console.common.entity.Page;
import com.tang2988.gold.console.module.info.dao.OrderDao;
import com.tang2988.gold.console.module.info.service.OrderService;
import com.tang2988.gold.console.module.sys.entity.Orderinformation;
import com.tang2988.gold.console.module.sys.entity.Productinformation;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	public List<Orderinformation> findAlloder() {
		return orderDao.findAlloder();
	}
	
	public List<Map<String, Object>> findAllorder(){
		return orderDao.findAllorder();
		
	}

	
	public Map<String, Object> findById(Long orderId) {
		return orderDao.findById(orderId);
	}

	
	public Integer updateorder(Orderinformation orderinformation) {
		return orderDao.updateorder(orderinformation);
	}

	public Workbook Orderxml() {
		
		List<Orderinformation> list = new ArrayList<Orderinformation>();
		list = orderDao.findPage(1, 1009999);
		 if(list==null){
			list = new ArrayList<Orderinformation>();
		 }
		 //创建工作簿
		 Workbook workbook = new HSSFWorkbook();
		 //创建工作表
		 Sheet sheet = workbook.createSheet("谢雄辉"); //表名
		//创建行
		 Row row = sheet.createRow(0);
		 //创建单元格		//为单元格赋值
		 row.createCell(0).setCellValue("订单ID");
		 row.createCell(1).setCellValue("产品ID");
		 row.createCell(2).setCellValue("数量");
		 row.createCell(3).setCellValue("订单金额");
		 row.createCell(4).setCellValue("状态");
		 row.createCell(5).setCellValue("下单时间");
		 row.createCell(6).setCellValue("支付时间");
		 row.createCell(7).setCellValue("发货时间");
		 row.createCell(8).setCellValue("收货时间");
		 row.createCell(9).setCellValue("失败时间");
		 row.createCell(10).setCellValue("失败原因");
		 row.createCell(11).setCellValue("地址ID");
		 row.createCell(12).setCellValue("发票信息");
		 row.createCell(13).setCellValue("用户ID");
		 row.createCell(14).setCellValue("配送公司");
		 row.createCell(15).setCellValue("快递单号");
		 row.createCell(16).setCellValue("备注");
		 row.createCell(17).setCellValue("付款方式");
		 int rowqishi = 1;
		 for(Orderinformation order:list){
			 Row row1 = sheet.createRow(rowqishi);
			 row1.createCell(0).setCellValue(order.getOrderId()+"");
			 row1.createCell(1).setCellValue(order.getProductId()+"");
			 row1.createCell(2).setCellValue(order.getQuantity()+"");
			 row1.createCell(3).setCellValue(order.getOrderAmount()+"");
			 row1.createCell(4).setCellValue(order.getOrderStatus()+"");
			 row1.createCell(5).setCellValue(order.getOrderTime()+"");
			 row1.createCell(6).setCellValue(order.getTimeofpayment()+"");
			 row1.createCell(7).setCellValue(order.getDeliverytime()+"");
			 row1.createCell(8).setCellValue(order.getReceivingtime()+"");
			 row1.createCell(9).setCellValue(order.getFailuretime()+"");
			 row1.createCell(10).setCellValue(order.getCauseoffailure()+"");
			 row1.createCell(11).setCellValue(order.getAddressId()+"");
			 row1.createCell(12).setCellValue(order.getInvoiceInformation()+"");
			 row1.createCell(13).setCellValue(order.getUserId()+"");
			 row1.createCell(14).setCellValue(order.getDistributioncompany()+"");
			 row1.createCell(15).setCellValue(order.getTrackingNumberCourierNumber()+"");
			 row1.createCell(16).setCellValue(order.getRemark()+"");
			 row1.createCell(17).setCellValue(order.getPaymentMethod()+"");
			 rowqishi++;
		 }
		return workbook;
	}

	public Long findCount() {
		return orderDao.findCount();
	}

	public Page<Orderinformation> findPage(int pageno, int pageSize) {
		Page<Orderinformation> page = new Page<Orderinformation>();
		List<Orderinformation> list = new ArrayList<Orderinformation>();
		Long count = orderDao.findCount();
		if (count > 0) {
			list = orderDao.findPage(pageno, pageSize);
		}
		page.setDatas(list);
		page.setPagesize(pageSize);
		page.setPage(pageno);
		page.setTotalElements(count);
		return page;
	
	}

}
