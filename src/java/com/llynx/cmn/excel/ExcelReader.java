package com.llynx.cmn.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.llynx.cmn.util.StringUtils;


public class ExcelReader {
	
	private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);
	
	public static List<Map<String,Object>> excelRead(Map<String,Object> fileMap) {
		String filePath = fileMap.get("filePath").toString();
		String sysFileNm = fileMap.get("sysFileNm").toString();
		String oriFileNm = fileMap.get("oriFileNm").toString();
		
		// 추출한 고객 데이터를 넣을 리스트
		List<Map<String,Object>> custDataList = new ArrayList<Map<String,Object>>();
				
		try { 
			// 엑셀파일 객체
			File sysFile = new File(filePath+"/"+sysFileNm); 
			File file = new File(oriFileNm);			
			sysFile.renameTo(file);
			
			// 파일 is
			FileInputStream tempFile = new FileInputStream(file);
			
			// 엑셀 객체 타입에 따라 핸들링
			Workbook workbook = null;
			if (file.getAbsolutePath().endsWith("xlsx")) { 
				workbook = new XSSFWorkbook(tempFile); 
			} else if (file.getAbsolutePath().endsWith("xls")) { 
				workbook = new HSSFWorkbook(tempFile); 
			}
			
			
			int rowindex=0; 
			int columnindex=0; 
			
			//시트 수 (첫번째에만 존재하므로 0을 준다) 
			//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다 
			Sheet sheet = workbook.getSheetAt(0); 
			
			//행의 수 
			int rows = sheet.getPhysicalNumberOfRows(); 
			
			loop:
			for(rowindex=0;rowindex<rows;rowindex++){ 
				//행을읽는다 
				Row row = sheet.getRow(rowindex); 
				
				// 한 row의 고객 데이터를 담을 Map
				Map<String,Object> custData = new HashMap<String,Object>();
				
				if(row !=null){ 
					
					//셀의 수 					
					int cells = row.getPhysicalNumberOfCells(); 
					
					for(columnindex=0; columnindex<=cells; columnindex++){ 
						
						//셀값을 읽는다 
						Cell cell=row.getCell(columnindex); 
						
						String value=""; 
						
						//셀이 빈값일경우를 위한 널체크 
						if(cell==null){ 
							continue; 
						}else{ //타입별로 내용 읽기
							switch (cell.getCellType()){ 
								case Cell.CELL_TYPE_FORMULA: value=cell.getCellFormula(); 
								break; 
								case Cell.CELL_TYPE_NUMERIC: value=(int)cell.getNumericCellValue()+""; 
								break; 
								case Cell.CELL_TYPE_STRING: value=cell.getStringCellValue()+""; 
								break; 
								case Cell.CELL_TYPE_BLANK: value=cell.getBooleanCellValue()+""; 
								break; 
								case Cell.CELL_TYPE_ERROR: value=cell.getErrorCellValue()+""; 
								break; 
							} 
						} 
						
						if(columnindex==0) {
							if(!(StringUtils.removeCharAll(value,"-")).equals("")&&!(StringUtils.removeCharAll(value,"-")).equals("false")) {
								custData.put("custKey", StringUtils.removeCharAll(value,"-"));
								// 첫 컬럼은 key값넣기
								custData.put("custdata01" , StringUtils.removeCharAll(value,"-"));
							}else {
								break loop;
							}
						} else {
							String dataIndex="";
							if(columnindex+1<10) {
								dataIndex = "0"+ (columnindex+1);
							}else {
								dataIndex = "" + (columnindex+1);
							}							
							custData.put("custdata"+dataIndex , StringUtils.removeCharAll(value,"-"));							
						}
					}
					
					// 0은 헤더
					if(rowindex>0) {
						// 고객정보 Map을 List에 Add
						custDataList.add(custData);						
					}
				} 
			}
		}catch(Exception e) { 
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
		return custDataList;		
	}	
}
