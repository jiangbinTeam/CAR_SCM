package com.scm.dao;

import java.util.List;
import java.io.File;  
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.ss.usermodel.WorkbookFactory;  
import org.apache.poi.ss.util.CellRangeAddress;  
import org.junit.Test;

import com.scm.pojo.Vin;  
  
 
public class TestReadMergeRegionExcel {  
  
 
public List<Vin> testReadExcel(String path) throws ParseException {  
	List<Vin> vins = new ArrayList<Vin>();
	return vins =  readExcelToObj(path);  
}  
  
 
private List<Vin> readExcelToObj(String path) throws ParseException {  
  
Workbook wb = null; 
List<Vin> vins = new ArrayList<Vin>();
try {  
wb = WorkbookFactory.create(new File(path));  
vins =  readExcel(wb, 0, 1, 0);  
} catch (InvalidFormatException e) {  
e.printStackTrace();  
} catch (IOException e) {  
e.printStackTrace();  
}
return null;
  
}  
  
 
private List<Vin> readExcel(Workbook wb,int sheetIndex, int startReadLine, int tailLine) throws ParseException {  
Sheet sheet = wb.getSheetAt(sheetIndex);  
Row row = null;  
List<Vin> vins = new ArrayList<Vin>();
for(int i=startReadLine; i<sheet.getLastRowNum(); i++) {  
row = sheet.getRow(i);




	Vin vin = null;
	

//boolean isMerge = isMergedRegion(sheet, i, c.getColumnIndex());  
////�ж��Ƿ���кϲ���Ԫ��  
//String rs = null;                                                                                                                                                                                                
//if(isMerge) {  
// rs = getMergedRegionValue(sheet, row.getRowNum(), c.getColumnIndex());  
//System.out.print(rs + " ");  
//}else {  
//	rs = c.getStringCellValue();
//System.out.print(c.getRichStringCellValue()+" ");  
//}  
	
	HSSFCell vinNumber = (HSSFCell) row.getCell(0);
	HSSFCell invoiceDate = (HSSFCell) row.getCell(1);
	HSSFCell engineCode = (HSSFCell) row.getCell(2);
	HSSFCell produceCountry = (HSSFCell) row.getCell(3);
	HSSFCell invoiceNumber = (HSSFCell) row.getCell(4);
	
	
 vin = new Vin();
vin.setVinNumber(getCellValue(vinNumber));
vin.setEngineCode(getCellValue(engineCode));
vin.setProduceCountry(getCellValue(produceCountry));
vin.setInvoiceNumber(getCellValue(invoiceNumber));




vins.add(vin);
System.out.println(vin.toString());
}  
System.out.println();  
  return vins;
  
}  

  
  
  
public String getMergedRegionValue(Sheet sheet ,int row , int column){    
    int sheetMergeCount = sheet.getNumMergedRegions();    
        
    for(int i = 0 ; i < sheetMergeCount ; i++){    
        CellRangeAddress ca = sheet.getMergedRegion(i);    
        int firstColumn = ca.getFirstColumn();    
        int lastColumn = ca.getLastColumn();    
        int firstRow = ca.getFirstRow();    
        int lastRow = ca.getLastRow();    
            
        if(row >= firstRow && row <= lastRow){    
                
            if(column >= firstColumn && column <= lastColumn){    
                Row fRow = sheet.getRow(firstRow);    
                Cell fCell = fRow.getCell(firstColumn);    
                return getCellValue(fCell) ;    
            }    
        }    
    }    
        
    return null ;    
}    
  
 
private boolean isMergedRow(Sheet sheet,int row ,int column) {  
  int sheetMergeCount = sheet.getNumMergedRegions();  
  for (int i = 0; i < sheetMergeCount; i++) {  
CellRangeAddress range = sheet.getMergedRegion(i);  
int firstColumn = range.getFirstColumn();  
int lastColumn = range.getLastColumn();  
int firstRow = range.getFirstRow();  
int lastRow = range.getLastRow();  
if(row == firstRow && row == lastRow){  
if(column >= firstColumn && column <= lastColumn){  
return true;  
}  
}  
  }  
  return false;  
}  
  
 
private boolean isMergedRegion(Sheet sheet,int row ,int column) {  
  int sheetMergeCount = sheet.getNumMergedRegions();  
  for (int i = 0; i < sheetMergeCount; i++) {  
CellRangeAddress range = sheet.getMergedRegion(i);  
int firstColumn = range.getFirstColumn();  
int lastColumn = range.getLastColumn();  
int firstRow = range.getFirstRow();  
int lastRow = range.getLastRow();  
if(row >= firstRow && row <= lastRow){  
if(column >= firstColumn && column <= lastColumn){  
return true;  
}  
}  
  }  
  return false;  
}  
  
 
private boolean hasMerged(Sheet sheet) {  
        return sheet.getNumMergedRegions() > 0 ? true : false;  
    }  
  
 
private void mergeRegion(Sheet sheet, int firstRow, int lastRow, int firstCol, int lastCol) {  
sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));  
}  
  
  
public String getCellValue(Cell cell){    
        
    if(cell == null) return "null";    
        
    if(cell.getCellType() == Cell.CELL_TYPE_STRING){    
            
        return cell.getStringCellValue();    
            
    }else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){    
            
        return String.valueOf(cell.getBooleanCellValue());    
            
    }else if(cell.getCellType() == Cell.CELL_TYPE_FORMULA){    
            
        return cell.getCellFormula() ;    
            
    }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
    	    Object inputValue = null; 
            Long longval = Math.round(cell.getNumericCellValue());
            Double doubleval = cell.getNumericCellValue();
            if(Double.parseDouble(longval+".00") == doubleval){
            	inputValue = longval;
            }else {
				inputValue = doubleval;
			}
            DecimalFormat df = new DecimalFormat("#.##");
            return String.valueOf(df.format(inputValue));
              
            
    }    
    return " ";    
}    
}  