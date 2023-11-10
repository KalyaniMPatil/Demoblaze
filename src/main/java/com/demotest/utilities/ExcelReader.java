package com.demotest.utilities;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	public static int totalRow;
	public List<Map<String, String>> getdata(String excelFilePath, String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		Workbook workbook= WorkbookFactory.create(new File(excelFilePath));
		Sheet sheet= workbook.getSheet(sheetName);
		workbook.close();
		return readSheet(sheet);
	}
	private List<Map<String, String>> readSheet(Sheet sheet) {
		Row row;
		Cell cell;
		
		totalRow= sheet.getLastRowNum();
		List<Map<String, String>> excelRow = null;
		for(int currentRow=1; currentRow<=totalRow; currentRow++)
		{
			row=sheet.getRow(currentRow);
			int totalColumn= row.getLastCellNum();
			LinkedHashMap<String,String> columnMapData= new LinkedHashMap<String,String>();
			for(int currentColumn=0; currentColumn<totalColumn; currentColumn++)
			{
				cell=row.getCell(currentColumn);
				String columnHeaderName= sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
				columnMapData.put(columnHeaderName, cell.getStringCellValue());
			}
			excelRow.add(columnMapData);
		}
		return excelRow;
	}
	
	public int countRow()
	{
		return totalRow;
	}
	
	
}
