package com.ecommerce.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData {

	public static String excelSheet(int i, int j) throws EncryptedDocumentException, IOException
	{
		String path="C:\\Users\\ankus\\OneDrive\\Desktop\\Book2.xlsx";
		FileInputStream file=new FileInputStream(path);
		String data=WorkbookFactory.create(file).getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
		return data;
	}
}
 