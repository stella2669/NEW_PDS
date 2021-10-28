/*
 * Copyright 2019 LLYNX TECH All right reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.llynx.cmn.excel;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.view.AbstractView;

import com.ibm.icu.text.SimpleDateFormat;

public class DownloadExcelView extends AbstractView { //AbstractPOIExcelView {
	private static final Logger logger = LoggerFactory.getLogger(DownloadExcelView.class);

	private static final String CONTENT_TYPE_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

//	private XSSFWorkbook workbook = null;
//	XSSFSheet sheet = null;
	
	public DownloadExcelView() {}

	@Override
	protected boolean generatesDownloadContent() {
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if (logger.isDebugEnabled()) {
			logger.debug("Excel Download Start");
			logger.debug("title: {}", (String)model.get("title"));
			logger.debug("items: {}", (List<String>)model.get("items"));
			logger.debug("dataKey: {}", (List<String>)model.get("dataKey"));
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		setContentType(CONTENT_TYPE_XLSX);
		
		buildExcelDocument(workbook, model, request, response);

		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String fileName = StringUtils.defaultString((String)model.get("title"), StringUtils.EMPTY);
		if (fileName.isEmpty()) {
			fileName = date+".xlsx";
		} else {
			fileName = fileName+"_"+date+".xlsx";
		}
		
		response.setContentType(getContentType());
		fileName = fileName.replaceAll("\r", "").replaceAll("\n", "");
		
		String header = request.getHeader("User-Agent");
		if (header.contains("MSIE") || header.contains("Trident") || header.contains("Chrome")) {
			fileName = URLEncoder.encode(fileName, "UTF-8").replace("\\", "%20");
			response.setHeader("Content-Disposition", "attachment;filename="+fileName+";");
		} else {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		}
		
		ServletOutputStream out = response.getOutputStream();
							out.flush();
		workbook.write(out);
		out.flush();
		
		workbook=null;
		out.close();
	}
	
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(XSSFWorkbook workbook, Map<String, Object> data, HttpServletRequest request,
			HttpServletResponse respone) throws Exception {
		
		String title = StringUtils.defaultString((String)data.get("title"), "sheet1");

		XSSFSheet sheet = workbook.createSheet(title);
		sheet.setDefaultColumnWidth((short)12);
		
		XSSFCell cell = null;
		         cell = getCell(sheet, 0, 0);

 		ArrayList<String> items = (ArrayList<String>) data.get("items"); 
		ArrayList<String> dataKey = (ArrayList<String>) data.get("dataKey");
		

 		CellRangeAddress merge = new CellRangeAddress(0, 0, 0, items.size()-1);
		sheet.addMergedRegion(merge);         
		setText(cell, title, titleStyle(workbook));
		

		// multi header or summary use log
		if (logger.isDebugEnabled()) {
			logger.debug("multiple header --> {}", data.get("groupHeader")==null?"no":"yes");
			logger.debug("summary data --> {}", data.get("excelfooterData")==null?"no":"yes");
		}
		
		// header 
		int rowStart = 2;
		if (data.get("groupHeader") == null) {
			for (int i=0; i<items.size(); i++) {
				setText(getCell(sheet, rowStart, i), items.get(i).toString(), itemStyle(workbook));
			}			
		} else { 
			List<Object> groupHeader = (List<Object>)data.get("groupHeader");
			List<HashMap<String, Object>> headerItem;
			int cnt=groupHeader.size();
			Integer[] mergeRow = new Integer[items.size()];
			int startCell=0;
			int endCell=0;
			

			for (int i=0; i<cnt; i++) {
				headerItem = (List<HashMap<String, Object>>)groupHeader.get(i);
				
				rowStart = rowStart+i;

				
				for (int j=0; j<headerItem.size(); j++) {
					startCell = dataKey.indexOf(headerItem.get(j).get("startColumnName").toString());
					endCell = Integer.parseInt(headerItem.get(j).get("numberOfColumns").toString());

					mergeCell(sheet, rowStart, rowStart, startCell, (startCell+endCell), itemStyle(workbook)); // cell �깮�꽦�썑 蹂��빀�빐�빞 �뒪���씪 臾몄젣 �빐寃� 媛��뒫�븿
					setText(getCell(sheet, rowStart, startCell), headerItem.get(j).get("titleText").toString(), itemStyle(workbook));
					
					CellRangeAddress mergeHeaders = new CellRangeAddress(rowStart, rowStart, startCell, (startCell+endCell)-1);
					sheet.addMergedRegion(mergeHeaders);
					
	
					// 蹂묓빀�빐�빞�븷 �쐞移� �꽕�젙 inner loop
					for (int m=0; m<items.size(); m++) {	
						if (i==0) {
							if (m>=startCell && m<=(startCell+endCell)-1) {
								mergeRow[m] = 0;
							} else if (mergeRow[m] == null) {
								mergeRow[m] = rowStart;
							}
						} else if ((m>=startCell && m<=(startCell+endCell)-1)
								   || (mergeRow[m]<1 && m>=startCell && m<=(startCell+endCell)-1)) {
							mergeRow[m] = rowStart+1;
						} else if (mergeRow[m]<1) {
							mergeRow[m] = rowStart;
						}
						
//						if (logger.isDebugEnabled()) {
//							logger.debug("i: {} 踰덉㎏, m: {} 踰덉㎏, startCell: {}, endCell: {}, string:{}, array:{}", i, m, startCell, endCell, items.get(m).toString(),Arrays.toString(mergeRow));
//						}
					}
				}
			}

			// header merge
			CellRangeAddress mergeHeaders;
			rowStart = rowStart+1;
			int setRow = 0;
			
			for (int i=0; i<items.size(); i++) {
				setRow = mergeRow[i];
				if (setRow == 0) {
					setRow = rowStart;
				}
				
//				if (logger.isDebugEnabled()) {
//					logger.debug("mergeHeaders i:{},  row: {}, setRow: {}, text: {}", i, rowStart, setRow, items.get(i).toString());
//				}
				mergeCell(sheet, setRow, rowStart, i, i, itemStyle(workbook)); // cell �깮�꽦�썑 蹂��빀�빐�빞 �뒪���씪 臾몄젣 �빐寃� 媛��뒫�븿				
				setText(getCell(sheet, setRow, i), items.get(i).toString(), itemStyle(workbook));
				
				if (setRow < rowStart) {
					mergeHeaders = new CellRangeAddress(setRow, rowStart, i, i);
					sheet.addMergedRegion(mergeHeaders);
				}
				setRow = rowStart;
			}	
		}
		
		List<HashMap<String, Object>> excelData = (List<HashMap<String, Object>>) data.get("excelData");		
		if (logger.isDebugEnabled()) {
			logger.debug("body data row : {}", excelData.size());
			logger.debug("init excel file");
		}
		
		// body
		String v = "";
		String key = "";
		BigDecimal rowNum; 
		for (int i=0; i<excelData.size(); i++) {
			HashMap<String, Object> mapData = excelData.get(i);
			for (int j=0; j<dataKey.size(); j++) {
				key = dataKey.get(j).toString();
				// data type �솗�씤
				if (mapData.get(key) instanceof BigDecimal) { 
					rowNum = (BigDecimal)mapData.get(key);
					v= StringUtils.defaultString(rowNum.toString(), StringUtils.EMPTY);
				
				} else {
					v = StringUtils.defaultString((String)mapData.get(key), StringUtils.EMPTY);
				}
				
				setText(getCell(sheet, (rowStart+1)+i, j), v, dataStyle(workbook));
			}
		}
		
		// summary
		if(data.get("excelfooterData") != null) {
			summaryData(workbook, sheet, data, excelData.size(), items.size());
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("created excel file");
		}
	}

		@SuppressWarnings("unchecked")
	protected void summaryData(XSSFWorkbook workbook, XSSFSheet sheet, Map<String, Object> data, int bodyCnt, int bodyItemCnt) {		
		HashMap<String, Object> summaryData = (HashMap<String, Object>)data.get("excelfooterData");
		ArrayList<String> summaryItems = (ArrayList<String>) data.get("summaryItems");  
		ArrayList<String> summaryKey = (ArrayList<String>) data.get("summaryKey");

		if (logger.isDebugEnabled()) {
			logger.debug("summaryItems: {}", summaryItems);
			logger.debug("summaryKey: {}", summaryKey);
		}	
		
//      lastRow find = (title:3) + (body:size) + (space:1)
		int lastRow = 3+bodyCnt+1;
		int col;
		int colCnt = summaryItems.size();
		int[] mergeCol = new int[colCnt];
		
		CellRangeAddress mergeSummary;
		for (int i=0; i<colCnt; i++) {
			mergeCol[i] = bodyItemCnt/colCnt;
			if (i==0) { 
				col=i;
			} else {    
				col = new Integer(mergeCol[i]*i).intValue();
			}
			
			if (col<0) {
				continue;
			}
			
			if(i == (colCnt-1)) {
				mergeCol[i] = mergeCol[i]+(bodyItemCnt%colCnt);
			}

			mergeCell(sheet, lastRow, lastRow, col, (col+mergeCol[i]), itemStyle(workbook)); 
			setText(getCell(sheet, lastRow, col), summaryItems.get(i).toString(), itemStyle(workbook));

			mergeSummary = new CellRangeAddress(lastRow, lastRow, col, (col+mergeCol[i])-1);
			sheet.addMergedRegion(mergeSummary);
		}
		
		
		lastRow = lastRow+1;
		String v;
		String key;
		BigDecimal rowNum;
		for (int i=0; i<summaryKey.size(); i++) {
			key = summaryKey.get(i).toString();
			if (summaryData.get(key) instanceof BigDecimal) { // rownum is BigDecimal,  sql�뿉�꽌 泥섎━�븯吏� �븡�쓣 寃쎌슦 �뿬湲곗꽌 �젙由� 
				rowNum = (BigDecimal)summaryData.get(key);
				v= StringUtils.defaultString(rowNum.toString(), StringUtils.EMPTY);				
			} else {
				v = StringUtils.defaultString((String)summaryData.get(key), StringUtils.EMPTY);
			}
			
			
			if (i==0) {                    
				col=i;
			} else if (i == (colCnt-1)) {  
				col = new Integer(mergeCol[i-1]*i).intValue();
			} else {                       
				col = new Integer(mergeCol[i]*i).intValue();
			}		
			
			if (col<0) {
				continue;
			}
			
			mergeCell(sheet, lastRow, lastRow, col, (col+mergeCol[i]), dataStyle(workbook)); // cell �깮�꽦�썑 蹂��빀�빐�빞 �뒪���씪 臾몄젣 �빐寃� 媛��뒫�븿
			setText(getCell(sheet, lastRow, col), v, dataStyle(workbook));
			
			CellRangeAddress mergeExcel = new CellRangeAddress(lastRow, lastRow, col, (col+mergeCol[i])-1);
			sheet.addMergedRegion(mergeExcel);
		}
	}

	protected XSSFCell getCell(XSSFSheet sheet, int row, int col) {
		XSSFRow addRow = sheet.getRow(row);
		if (addRow == null) {
			addRow = sheet.createRow(row);
		}
		
		XSSFCell addCell = addRow.getCell((short)col);
		if (addCell == null) {
			addCell = addRow.createCell((short) col);
		}
		
		return addCell;
	}
	
	protected void mergeCell(XSSFSheet sheet, int sRow, int eRow, int sCol, int eCol, CellStyle style) {
		XSSFRow createRow;
		XSSFCell createCell;
		for (int r=sRow; r==eRow; r++) {
			createRow = sheet.getRow(r);
			if (createRow == null) createRow = sheet.createRow(r);
			
			for (int c=sCol; c==eCol; c++) {
				createCell = createRow.getCell((short) c);
				if (createCell == null) createRow.createCell((short) c);
				
//				createCell.setCellStyle(style);
			}
		}
	}
	
	protected void setText(XSSFCell cell, String txt, CellStyle style) {
		cell.setCellType(XSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(txt);
		cell.setCellStyle(style);
	}
	
	/**
	 * title sytle 
	 * @Method : titleStyle
	 * @author USER
	 * @since 2020-09-03
	 * @Description : 
	 *
	 *
	 *  -------------------------------------------------
	 *
	 * @param wb
	 * @return
	 */
	private CellStyle titleStyle(XSSFWorkbook workbook) {
		CellStyle titleStyle = workbook.createCellStyle();
		          titleStyle.setWrapText(true); // 以꾨컮轅�
		          titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		          titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);		
	    Font font = workbook.createFont();
	         font.setFontHeightInPoints((short) 18);
	         font.setFontName("맑은고딕");
	         font.setColor(HSSFColor.BLACK.index);
	         font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	    
        titleStyle.setFont(font);
		
		return titleStyle;
	}

	/**
	 * item style
	 * @Method : itemStyle
	 * @author USER
	 * @since 2020-09-03
	 * @Description : 
	 *
	 *
	 *  -------------------------------------------------
	 *
	 * @param wb
	 * @return
	 */
	private CellStyle itemStyle(XSSFWorkbook workbook) {
		CellStyle itemStyle = workbook.createCellStyle();
				  itemStyle.setWrapText(true); // 以꾨컮轅�
				  itemStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				  itemStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				  itemStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				  itemStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				  itemStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				  itemStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				  itemStyle.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);	
				  itemStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);	
		Font font = workbook.createFont();
	         font.setFontHeightInPoints((short) 12);
	         font.setFontName("맑은고딕");
	         font.setColor(HSSFColor.BLACK.index);
	         font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);	    
        itemStyle.setFont(font);
		
		return itemStyle;
	}

	/**
	 * data style
	 * @Method : dataStyle
	 * @author USER
	 * @since 2020-09-03
	 * @Description : 
	 *
	 *
	 *  -------------------------------------------------
	 *
	 * @param wb
	 * @return
	 */
	private CellStyle dataStyle(XSSFWorkbook workbook) {
		CellStyle dataStyle = workbook.createCellStyle();
				  dataStyle.setWrapText(true); // 以꾨컮轅�
				  dataStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				  dataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				  dataStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
				  dataStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				  dataStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
				  dataStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);				  
	    Font font = workbook.createFont();
	         font.setFontHeightInPoints((short) 12);
	         font.setFontName("맑은고딕");
	         font.setColor(HSSFColor.BLACK.index);	    
        dataStyle.setFont(font);
		
		return dataStyle;
	}
}
