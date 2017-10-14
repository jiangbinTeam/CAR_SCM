package com.scm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scm.pojo.Vin;
import com.scm.service.VinService;
import com.sun.xml.internal.ws.wsdl.writer.document.Service;

public class ToExcel {

	public static void export() {
		// 声明一个工作薄，就是创建一个client，来使用各种接口
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建一个excel子标签
        HSSFSheet sheet = wb.createSheet("用户表");
        //创建第一行（也可以称为表头）
        HSSFRow row = sheet.createRow(0);
        //给表头创建单元格，poi给excel每一格定义为cell（细胞）
        HSSFCell cell = row.createCell((short) 0);
        // 生成一个样式  
        HSSFCellStyle style = wb.createCellStyle();
        //样式字体居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        
        cell.setCellValue("序号"); 
        cell = row.createCell( (short) 1); 
        
        cell.setCellValue("vin号"); 
        cell = row.createCell( (short) 2); 
        
        cell.setCellValue("提单表ID");  
        cell = row.createCell( (short) 3);  
        
        cell.setCellValue("经销商分解表主键");  
        cell = row.createCell( (short) 4); 
        
        cell.setCellValue("汽车采购单主键");  
        cell = row.createCell( (short) 5); 
        
        cell.setCellValue("打款单主键"); 
        cell = row.createCell( (short) 6); 
        
        cell.setCellValue("车型编码");  
        cell = row.createCell( (short) 7); 
      
        cell.setCellValue("颜色代码");  
        cell = row.createCell( (short) 8); 
       
        cell.setCellValue("是否允许销售");  
        cell = row.createCell( (short) 9); 
       
        cell.setCellValue("生产日期");  
        cell = row.createCell( (short) 10); 
      
        cell.setCellValue("手续是否齐全");  
        cell = row.createCell( (short) 11); 
      
        cell.setCellValue("发票号");  
        cell = row.createCell( (short) 12); 
      
        cell.setCellValue("发动机号");  
        cell = row.createCell( (short) 13); 
       
        cell.setCellValue("开票日期");  
        cell = row.createCell( (short) 14); 
       
        cell.setCellValue("原产国");  
        cell = row.createCell( (short) 15); 
      
        cell.setCellValue("采购价");  
        cell = row.createCell( (short) 16); 
      
        cell.setCellValue("销售价");  
        cell = row.createCell( (short) 17); 
      
        cell.setCellValue("是否已销售");  
        cell = row.createCell( (short) 18); 
       
        cell.setCellValue("出入库登记");  
        cell = row.createCell( (short) 19); 
        
        cell.setCellValue("实际打款日期");  
        cell = row.createCell( (short) 20); 
     
        cell.setCellValue("VIN号后六位");  
        cell = row.createCell( (short) 21); 
        
        cell.setCellValue("销售日期");  
        cell = row.createCell( (short) 22); 
      
        cell.setCellValue("是否加装");  
        cell = row.createCell( (short) 23); 
       
        cell.setCellValue("加装说明");  
        cell = row.createCell( (short) 24); 
   
         
     System.out.println("111");
     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
     VinService service = ctx.getBean("vinService", VinService.class);
        //添加一些数据
       List<Vin> list = service.findAll();
     System.out.println(list.size());
 
        //向单元格里填充数据
        for (short i = 0; i < list.size(); i++) {
        	row = sheet.createRow(i + 1);
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        	
        	row.createCell(0).setCellValue(i);
	        if(list.get(i).getVinNumber()!=null) {row.createCell(1).setCellValue(list.get(i).getVinNumber());}
	        if(list.get(i).getWaybillId()!=null) { row.createCell(2).setCellValue(list.get(i).getWaybillId());}
	        if(list.get(i).getYearPlanDealerAnalyzeId()!=null) {row.createCell(3).setCellValue(list.get(i).getYearPlanDealerAnalyzeId());}
	        if(list.get(i).getCarProcurementListId()!=null) { row.createCell(4).setCellValue(list.get(i).getCarProcurementListId());}
	        if(list.get(i).getPaymentListId()!=null) { row.createCell(5).setCellValue(list.get(i).getPaymentListId());}
	       
	        if(list.get(i).getTypeCode()!=null) {row.createCell(6).setCellValue(list.get(i).getTypeCode());}
	        if(list.get(i).getColorCode()!=null) {row.createCell(7).setCellValue(list.get(i).getColorCode());}
	        if(list.get(i).getIfsell()!=null) { row.createCell(8).setCellValue(list.get(i).getIfsell());}
	        if(list.get(i).getProductionDate()!=null) {row.createCell(9).setCellValue(list.get(i).getProductionDate());}
	        if(list.get(i).getProcedureComplete()!=null) { row.createCell(10).setCellValue(list.get(i).getProcedureComplete());}
	        if(list.get(i).getInvoiceNumber()!=null) { row.createCell(11).setCellValue(list.get(i).getInvoiceNumber());}
	        if(list.get(i).getEngineCode()!=null) {row.createCell(12).setCellValue(list.get(i).getEngineCode());}
	        if(list.get(i).getInvoiceDate()!=null) { row.createCell(13).setCellValue(sdf.format(list.get(i).getInvoiceDate()));}
	        if(list.get(i).getProduceCountry()!=null) {row.createCell(14).setCellValue(list.get(i).getProduceCountry());}
	        if(list.get(i).getStockPrice()!=null) { row.createCell(15).setCellValue(list.get(i).getStockPrice());}
	        if(list.get(i).getSellPrice()!=null) { row.createCell(16).setCellValue(list.get(i).getSellPrice());}
	        if(list.get(i).getIssell()!=null) {row.createCell(17).setCellValue(list.get(i).getIssell());}
	        if(list.get(i).getOutOfStorage()!=null) {row.createCell(18).setCellValue(list.get(i).getOutOfStorage());}
	        if(list.get(i).getActualPaymentDate()!=null) {row.createCell(19).setCellValue(sdf.format(list.get(i).getActualPaymentDate()));}
	        if(list.get(i).getVinLast()!=null) {row.createCell(20).setCellValue(list.get(i).getVinLast());}
	        if(list.get(i).getSellDate()!=null) {row.createCell(21).setCellValue(sdf.format(list.get(i).getSellDate()));}
	        if(list.get(i).getIfRetrofitting()!=null) {row.createCell(22).setCellValue(list.get(i).getIfRetrofitting());}
	        if(list.get(i).getAddAccessorizeNote()!=null) {row.createCell(23).setCellValue(list.get(i).getAddAccessorizeNote());}
        }
         
        try {
	        //使用文件流导出,我默认在桌面
	        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\Jiangbin\\Desktop\\vin.xlsx"));
	        wb.write(out);
	        out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void read(){
		try {
			FileInputStream is = new FileInputStream(new File("C:\\Users\\Jiangbin\\Desktop\\用户表.xlsx"));
			POIFSFileSystem fs = new POIFSFileSystem(is);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			
			HSSFSheet sheet = wb.getSheetAt(0);
			// 得到总行数
			int rowNum = sheet.getLastRowNum();
			//获取总列数
			/*HSSFRow row = sheet.getRow(0);
        	int colNum = row.getPhysicalNumberOfCells();*/
			// 正文内容应该从第二行开始,第一行为表头的标题
			for (int i = 1; i <= rowNum; i++) {
				HSSFRow row = sheet.getRow(i);
				System.out.println(row.getCell(0).getNumericCellValue() + "-----" + row.getCell(1).getStringCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		export();
		/*SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		Date date=new Date();
		System.out.println(sdf.format(date));*/
	}
}
