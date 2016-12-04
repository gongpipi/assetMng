package com.asset.utils;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class POIExcelUtils {
	/**
	 * 创建标题行
	 * 
	 * @param createHelper
	 * @param sheet
	 * @param oarr
	 * @param styleFont
	 * @param rowIndex
	 */
	private static void createOutputTitleRow(Workbook wb, CreationHelper createHelper, Sheet sheet, Object[] oarr,
			short rowIndex) {
		CellStyle styleFont = wb.createCellStyle();
		Font font = wb.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(Font.COLOR_NORMAL);
		styleFont.setFont(font);
		Row row = sheet.createRow((short) rowIndex);
		styleFont.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styleFont.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		for (int i = 0; i < oarr.length; i++) {
			sheet.setColumnWidth(i, 100 * 46);
			Cell cell = row.createCell(i);
			cell.setCellValue(createHelper.createRichTextString(oarr[i] + ""));
			cell.setCellStyle(styleFont);
		}
	}

	/**
	 * 创建内容行
	 * 
	 * @param createHelper
	 * @param sheet
	 * @param listRows
	 * @param contentBeginRowIndex
	 * @throws Exception
	 */
	private static void createOutputContentRows(Workbook wb, CreationHelper createHelper, Sheet sheet,
			List<POIExcelBaseBean> listRows, int contentBeginRowIndex) throws Exception {
		CellStyle styleFont = wb.createCellStyle();
		Font font = wb.createFont();
		font.setColor(Font.COLOR_NORMAL);
		styleFont.setFont(font);
		for (int i = 0; i < listRows.size(); i++) {
			Row r = sheet.createRow((short) i + contentBeginRowIndex);
			POIExcelBaseBean bean = listRows.get(i);
			for (int j = 0; j < bean.size(); j++) {
				Cell cell = r.createCell(j);
				cell.setCellValue(createHelper.createRichTextString(bean.get(j + 1, bean)));
			}
		}
	}

	public static Workbook OutputExcel(Object[] oarr, List<POIExcelBaseBean> listRows, int contentBeginRowIndex,
			String filePath, String sheetName) throws Exception {
		Workbook wb = new HSSFWorkbook();
		// Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet=null;
		if(null!=sheetName){
			sheet = wb.createSheet(sheetName);
		}else{
			sheet = wb.createSheet();
		}
		/* ----------------------------创建标题行---------------------------- */
		createOutputTitleRow(wb, createHelper, sheet, oarr, (short) 0);

		/* ----------------------------创建内容行---------------------------- */
		createOutputContentRows(wb, createHelper, sheet, listRows, contentBeginRowIndex);
		return wb;
	}
	
}
