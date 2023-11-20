package excelutil;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelUtil(String excelpath, String sheetname)
	{
		try {
			workbook = new XSSFWorkbook(excelpath);
			sheet=workbook.getSheet(sheetname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getRow() 
	{
		return( sheet.getPhysicalNumberOfRows());
		
		
	}
	public int getColumn(int x)
	{
	 return(sheet.getRow(x).getLastCellNum());
	}
	public String getCellData(int x, int y)
	{
		
		try{
			DataFormatter cellval = new DataFormatter();
			String s = cellval.formatCellValue(sheet.getRow(x).getCell(y+1));
			return s;
		}
		catch(Exception e)
		{
			return "";
		}
		
	}
//	public boolean checkSheet(String sheetname, String excelpath) throws IOException {
//		workbook = new XSSFWorkbook(excelpath);
//		 if (workbook.getNumberOfSheets() != 0) 
//		        for (int i = 0; i < workbook.getNumberOfSheets(); i++) 
//		           if (workbook.getSheetName(i).equals(sheetname)) 
//		                return  true;
//		                return false;
//		
//	}

}
