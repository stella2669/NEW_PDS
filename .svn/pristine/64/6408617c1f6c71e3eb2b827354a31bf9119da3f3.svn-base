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
package com.llynx.cmn.util;

import java.util.Calendar;
import java.util.Locale;
import java.util.*;
import java.text.*;
import java.io.*;

/**
 * 	현재 시각 또는 'YYYYMMDD24HHMISS' 형태의 문자열을 이용하여
 * 	'YYYY/MM/DD 24HH:MI:SS' 형태의 문자열 변환
 *
 */

 
/**
 * @Class Name : DateTimeUtil.java
 * @Description : DateTimeUtil Class
 * @author user
 * @since 2020-07-28
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-07-28  user         최초생성
 *
 *</pre>
 */
public class DateTimeUtil {
	private static final String DATE_GUBUN = ".";
    private static DateTimeUtil dateTimeUtilIns = null;


public static String getCalsDate(int y,int z,String date_type) throws Exception{ 

    Calendar cal=Calendar.getInstance(Locale.KOREAN);
    TimeZone timezone=cal.getTimeZone();
    timezone=TimeZone.getTimeZone("Asia/Seoul");
    cal = Calendar.getInstance(timezone); 
    cal.add(y,z);
    java.util.Date currentTime=cal.getTime();
    SimpleDateFormat formatter=new SimpleDateFormat(date_type,Locale.KOREAN);
    String timestr=formatter.format(currentTime); 
    return timestr;
}
 
    
	/**
 * 현재년월일시간밀리세컨드 리턴 메소드
 * @return "yyyyMMddHHmmssSSS" 유형의 현재일 문자열
 */
	public static String getDetailDateString() {
		return getDetailDateString(new java.util.Date());
	}
	
	/**
	 * 현재년월일시간밀리세컨드 리턴 메소드
	 * @param dtDate 날짜형식의 문자열(시간포함)
	 * @return "yyyyMMddHHmmssSSS" 유형의 날짜 문자열
	 */
	public static String getDetailDateString(java.util.Date dtDate) {
		java.text.SimpleDateFormat oFormatter = new java.text.SimpleDateFormat ("yyyyMMddHHmmssSSS", java.util.Locale.KOREA);
		return oFormatter.format(dtDate);
	}

	/*****************************************************************************************
	 * 해당날짜의 요일을 계산한다. (년월일(6자리)을 지정하는데 지정되지 않으면 default 값을 사용한다. 2000.2)
	 * 예) getDayOfWeek("2000")     -> 토 (2000/1/1)
	 * getDayOfWeek("200002")   -> 화 (2000/2/1)
	 * getDayOfWeek("20000225") -> 금 (2000/2/25)
	 *****************************************************************************************/
	public static String getDayOfWeek(String date){
		
		if (date==null){
			return null;
		}

		int yyyy=0,MM=1,dd=1,day_of_week; // default

		String days[]={"일","월","화","수","목","금","토"};

//		try{
			yyyy=Integer.parseInt(date.substring(0,4));
			MM=Integer.parseInt(date.substring(4,6));
			dd=Integer.parseInt(date.substring(6,8));
//		}catch (Exception ex){
//			// do nothing
//		}

		Calendar cal=Calendar.getInstance();
		cal.set(yyyy,MM-1,dd);
		day_of_week=cal.get(Calendar.DAY_OF_WEEK); //1(일),2(월),3(화),4(수),5(목),6(금),7(토)
		
		if (day_of_week<0) {
			return days[1];
		}
		
		return days[day_of_week-1];
	}
	
	/*****************************************************************************************
	 * 해당날짜의 요일을 계산한다. (년월일(6자리)을 지정하는데 지정되지 않으면 default 값을 사용한다. 2000.2)
	 * 예) getDayOfWeek("2000")     -> 토 (2000/1/1)
	 * getDayOfWeek("200002")   -> 화 (2000/2/1)
	 * getDayOfWeek("20000225") -> 금 (2000/2/25)
	 *****************************************************************************************/
	public static String getDayOfWeekNew(String date){
		
		if (date==null){
			return null;
		}

		int yyyy=0,MM=1,dd=1,day_of_week; // default

//		try{
			yyyy=Integer.parseInt(date.substring(0,4));
			MM=Integer.parseInt(date.substring(4,6));
			dd=Integer.parseInt(date.substring(6,8));
//		}catch (Exception ex){
//			// do nothing
//		}

		Calendar cal=Calendar.getInstance();
		cal.set(yyyy,MM-1,dd);
		day_of_week=cal.get(Calendar.DAY_OF_WEEK); //1(일),2(월),3(화),4(수),5(목),6(금),7(토)

		return ""+(day_of_week-1);
	}


	/*****************************************************************************************
	 * 오늘의 요일을 계산한다.
	******************************************************************************************/
	public static String getDayOfWeek() throws Exception{
		return getDayOfWeek(getDate("yyyyMMdd"));
	}

	
	/*****************************************************************************************
	 * 두 시간의 차이를 분으로 계산한다.
	 * 예)
	 * getMinuteDiff("20000302","20000303") --> 3600
	 * getMinuteDiff("2000030210","2000030211") --> 60
	 * getMinuteDiff("200003021020","200003021021") --> 1
	 * getMinuteDiff("20000302102000","20000302102130") --> 1
	 * 처음 파라메터가 작은 날짜인데 만약 더 큰날짜를 처음으로 주면 음수를리턴.
	 ******************************************************************************************/
	public int getMinuteDiff(String s_start,String s_end) throws Exception{		
		long l_start,l_end,l_gap;
		int i_start_year=0,i_start_month=1,i_start_day=1,i_start_hour=0,i_start_min=0,i_start_sec=0;
		int i_end_year=0,i_end_month=1,i_end_day=1,i_end_hour=0,i_end_min=0,i_end_sec=0;

		try{
//			try{
				i_start_year = Integer.parseInt(s_start.substring(0,4));
				// month 는 Calendar에서 0 base 으로 작동하므로 1 을 빼준다.
				i_start_month= Integer.parseInt(s_start.substring(4,6)); 
				i_start_day  = Integer.parseInt(s_start.substring(6,8));
				i_start_hour = Integer.parseInt(s_start.substring(8,10));
				i_start_min  = Integer.parseInt(s_start.substring(10,12));
				i_start_sec  = Integer.parseInt(s_start.substring(12,14));
//			}catch (IndexOutOfBoundsException ex){
//				// ignore
//			}
//			try{
				i_end_year = Integer.parseInt(s_end.substring(0,4));
				 // month 는 Calendar 에서0 base 으로 작동하므로 1 을 빼준다.
				i_end_month= Integer.parseInt(s_end.substring(4,6));
				i_end_day  = Integer.parseInt(s_end.substring(6,8));
				i_end_hour = Integer.parseInt(s_end.substring(8,10));
				i_end_min  = Integer.parseInt(s_end.substring(10,12));
				i_end_sec  = Integer.parseInt(s_end.substring(12,14));
//			}catch (IndexOutOfBoundsException ex){
//				// ignore
//			}
		} catch (IndexOutOfBoundsException ex){
			throw new Exception("JspCybus.getMinuteDiff("+s_start+","+s_end+")\r\n"+ex.getMessage());
		} catch (Exception ex){
			throw new Exception("JspCybus.getMinuteDiff("+s_start+","+s_end+")\r\n"+ex.getMessage());
		}

		Calendar cal=Calendar.getInstance();

		cal.set(i_start_year,i_start_month-1,i_start_day,i_start_hour,i_start_min,i_start_sec);
		l_start=cal.getTime().getTime();

		cal.set(i_end_year,i_end_month-1,i_end_day,i_end_hour,i_end_min,i_end_sec);
		l_end=cal.getTime().getTime();

		l_gap=l_end-l_start;
		
		return (int)(l_gap/(1000*60));
	}

	/*****************************************************************************************
	 * 년,월,일,시,분등과 관련된 HTML <option> 을 출력한다.
	 ******************************************************************************************/
	public static String getDateOptions(int start, int end){
		return getDateOptions(start,end,-1);
	}	
	/*****************************************************************************************
	 * 년,월,일,시,분등과 관련된 HTML <option> 을 출력한다.
	 * default 값을 주면 그 값이 선택되게 한다.
	 ******************************************************************************************/
	@SuppressWarnings("static-access")
	public static String getDateOptions(int start, int end, int nDefault){
		
		String result = "";
		
		for (int i=start ; i <= end ; i ++){
			if (i < 100){
				String temp = "";
				temp = temp.valueOf(i + 100);
				temp = temp.substring(1);
				if (i == nDefault){
					result += "<option value=\""+temp+"\" selected>"+temp;
				}else{
					result += "<option value=\""+temp+"\">"+temp;
				}
			}else{
				if (i == nDefault){
					result += "<option value=\""+i+"\" selected>"+i;
				}else{
					result += "<option value=\""+i+"\">"+i;
				}
			}
		}
		return result;
	}


	/*****************************************************************************************
	 * 일짜 차이의 일수, 월 차이의 달수 구함
	 *
	 * 예) datediff("d", "20010101", "20000501");	일의 차
	 * 예) datediff("m", "20010101", "20000501");	달의 차
	 ******************************************************************************************/
	public static int dateDiff(String flag, String firstdate, String lastdate) throws Exception{
		int returnValue = 0;
		long temp = 0;
		int year=0,month=0,day=0,year1=0,month1=0,day1=0;
		int year2 = 0, month2 = 0;
		
//		try{
			year  = Integer.parseInt(firstdate.substring(0,4));
			month = Integer.parseInt(firstdate.substring(4,6));
			day   = Integer.parseInt(firstdate.substring(6,8));
			
			year1  = Integer.parseInt(lastdate.substring(0,4));
			month1 = Integer.parseInt(lastdate.substring(4,6));
			day1   = Integer.parseInt(lastdate.substring(6,8));

			if (flag.equals("d")) {		// 일자의 차이
				TimeZone tz = TimeZone.getTimeZone("Asia/Seoul");
				Calendar cal=Calendar.getInstance(tz);

				cal.set((year-1900),(month-1),day);

				Calendar cal2=Calendar.getInstance(tz);
				cal2.set((year1-1900),(month1-1),day1);

				java.util.Date temp1 = cal.getTime();
				java.util.Date temp2 = cal2.getTime();

				temp = temp2.getTime() - temp1.getTime();

				if ( ( temp % 10 ) < 5 ){				//  1의 자리에서 반올림하는 로직
					temp = temp - ( temp % 10 );
				}else{
					temp = temp + ( 10 - ( temp % 10 ) );
				}

				returnValue = (int)( temp / ( 1000 * 60 * 60 * 24 ) );	//  millisecond를... "일" ( Day )로.. 변환
			}else{			// 월의 차이
				year2  = (year - year1) * 12;
				month2 = month - month1;
				returnValue = year2 + month2;
			}
//		}catch (Exception ex){	}

		return returnValue;
	}
	

	/*****************************************************
	 * 날짜의 "-" 항목을 제거한다.
	*****************************************************/
	public String checkDate(String c_Date,String type){
		 String str = c_Date;
		 StringTokenizer st = new StringTokenizer(str, type, false);
		 str = "";
		 while(st.hasMoreTokens()) {
			 str += st.nextToken();
		 }

		 return str;
	}

	/* 예정일자 (다음달 10일 계산 로직) */
	public String Mon10(String rday){
		String sReturn = "";
		int year=0,month=0,day=0;
		
		//System.out.println("rday "+rday);
//		try {
			year  = Integer.parseInt(rday.substring(0,4));
			month = Integer.parseInt(rday.substring(4,6));
			day   = 10;
			if(month == 12){
				year = year +1;
				month = 1;
				sReturn = ""+year+"0"+month+""+day;
			}else{				
				month = month +1;
				//System.out.println("month "+month);
				if(month <10){
					sReturn = ""+year+"0"+month+""+day;
				}else{
					sReturn = ""+year+""+month+""+day;
				}
			}
			//sReturn = ""+year+""+month+""+day;			
//		}
//		catch (Exception ex)
//		{
//		}

		//System.out.println("sReturn "+sReturn);
		return sReturn;
	}

	
    public static DateTimeUtil getInstance(){  
	    if(dateTimeUtilIns == null) {
	        dateTimeUtilIns = new DateTimeUtil();
	     }
	
	     return dateTimeUtilIns;
    }

	/**
	 * 현재 시간을 돌려준다. - HH:MI:SS 
	 */
//	public static String getTimeText(int type, String szTime)
//	{
//		if(szTime != null && szTime.length() != 6) return ""; 
//		
//		
//		if(szTime != null && szTime.length() == 6){			
//			String hour = StringUtil.substring(szTime,0, 2);
//			String minute = StringUtil.substring(szTime, 2, 4);
//			String second = StringUtil.substring(szTime,4, 6);  
//		
//			switch(type) {
//		        case 1:
//		            return hour + TIME_GUBUN + minute + TIME_GUBUN+ second;
//		        case 2:
//		            return  hour + TIME_GUBUN + minute;
//		        case 3:    
//		            return  hour;
//	       }
//		}	
//
//		return "";
//	}

	/**
	 * 현재 시간을 돌려준다. - HHMISS 
	 */
	public static String getTime(){
		String hour, min, sec;

 		Calendar cal = Calendar.getInstance(Locale.getDefault());

 		StringBuffer buf = new StringBuffer();

 		hour = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
 		if(hour.length() == 1) hour = "0" + hour;

 		min = Integer.toString(cal.get(Calendar.MINUTE));
 		if(min.length() == 1) min = "0" + min;

 		sec = Integer.toString(cal.get(Calendar.SECOND));
 		if(sec.length() == 1) sec = "0" + sec;

 		buf.append(hour);
 		buf.append(min);
 		buf.append(sec);

		return buf.toString();
	}

	/**
	 * 현재 년월일을 돌려준다. - YYYY.MM.DD
	 * TYPE 1 : YYYY.MM.DD
	 * TYPE 2 : YY.MM.DD
	 * TYPE 3 : MM.DD
	 * TYPE 4 : YYYY.MM
	 * TYPE 5 : YYYY
	 */
	public static String getDateText(int type, String szdate){
	    return getDateText(type, szdate,DATE_GUBUN);
	}
	@SuppressWarnings("unused")
	public static String getDateText(int type, String szdate,String delimeter)
	{
		String reDate = "";
		
		if(szdate != null && szdate.length() != 8) return ""; 
		
		
		if(szdate != null && szdate.length() == 8){			
			String year = szdate.substring(0, 4);
			String month = szdate.substring(4, 6);
			String day = szdate.substring(6, 8);
		
			switch(type) {
		        case 1:
		            return  year + delimeter + month + delimeter + day;
		        case 2:
		            return  year.substring(2, 4) + delimeter + month + delimeter + day;
		        case 3:    
		            return month + delimeter + day;
		        case 4:
		            return  year + delimeter + month;
		        case 5:
		            return year;
	       }
		}	
		
		return "";
	}
	
	/**
	 * 특정형태의 날자 타입을 돌려준다.
	 * TYPE 0 : YYYY.MM.DD HH:MI:SS
	 * TYPE 1 : YYYY.MM.DD
	 * TYPE 2 : YY.MM.DD
	 * TYPE 3 : MM.DD
	 * TYPE 4 : YYYY.MM
	 * TYPE 5 : YYYY
	 * TYPE 6 : MM.DD HH:MI
	 * TYPE 7 : HH:MI
     * @param type
	 * @param dateTime
	 * @return
	 */
//	public static String getDateType(int type, String date){
//	    return getDateType(type, date, DATE_GUBUN);
//	}
	
//	public static String getDateType(int type, String date, String delimeter)
//	{
//		if (date == null) {
//			return "";
//		}
//
//		if(date.length() == 12) date += "01";
//	    else if(date.length() == 10) date += "0101";
//        else if(date.length() == 8) date += "010101";
//        else if(date.length() == 6) date += "01010101";
//        else if(date.length() == 4) date += "0101010101";
//
//        switch(type) {
//	        case 0:
//	            return getDateText(1,StringUtil.substring(date, 0, 8), delimeter) + " " + getTimeText(1,StringUtil.substring(date, 8, 14));
//	        case 1:
//	            return getDateText(1,StringUtil.substring(date, 0, 8), delimeter);
//	        case 2:
//	            return getDateText(2,StringUtil.substring(date, 0, 8), delimeter);
//	        case 3:
//	            return getDateText(3,StringUtil.substring(date, 0, 8), delimeter);
//	        case 4:
//	            return getDateText(4,StringUtil.substring(date, 0, 8), delimeter);
//	        case 5:
//	            return getDateText(5,StringUtil.substring(date, 0, 8), delimeter);
//	        case 6:
//	            return getDateText(3,StringUtil.substring(date, 0, 8), delimeter) + " " + getTimeText(2,StringUtil.substring(date, 8, 14));
//	        case 7:
//	            return getTimeText(2,StringUtil.substring(date, 8, 14));
//        }
//        
//        return "";
//	}

    /**
     * 현재 년도를 돌려준다.
     * @return
     */
	public static String getYear(){
	    String ym = getYearMonth();
	    
	    return ym.substring(0,4);
	} 

	/**
	 * 현재 달을 돌려준다.
	 * @return
	 */
	public static String getMonth(){
	    String ym = getYearMonth();
	    
	    return ym.substring(4,6);
	}
	
	/**
	 * 현재 년월을 돌려준다 - YYYYMM 
	 */
	public static String getYearMonth(){
		String month;

 		Calendar cal = Calendar.getInstance(Locale.getDefault());

 		StringBuffer buf = new StringBuffer();

 		buf.append(Integer.toString(cal.get(Calendar.YEAR)));
 		month = Integer.toString(cal.get(Calendar.MONTH)+1);
 		if(month.length() == 1) month = "0" + month;
 		
 		buf.append(month);
 		
		return buf.toString();
	}
	
	   public static String getDate()
	    {
	        Calendar cal = Calendar.getInstance(Locale.getDefault());
	        StringBuffer buf = new StringBuffer();
	        buf.append(Integer.toString(cal.get(1)));
	        String month = Integer.toString(cal.get(2) + 1);
	        if(month.length() == 1)
	            month = "0" + month;
	        String day = Integer.toString(cal.get(5));
	        if(day.length() == 1)
	            day = "0" + day;
	        buf.append(month);
	        buf.append(day);
	        return buf.toString();
	    }

	/*****************************************************************************************
	 * 날짜를 다양한 형태로 리턴한다.
	 * 예)
	 *     getDate("yyyyMMdd");
	 *     getDate("yyyyMMddHHmmss");
	 *     getDate("yyyy/MM/dd HH:mm:ss");
	 *     getDate("yyyy/MM/dd");
	 *     getDate("HHmm");
	 *****************************************************************************************/
	public static String getDate(String type) throws Exception{
		if (type == null) return "";
		if (type.equals("")) return "";
		
		String s="";
		
//		try{
			/* 소스의 명확성을 위해 기존의 "1","2".. 방식을 탈피, 무조건 type 을 명시하도록 함. (by mskang)
			if(type.equals("1"))
			    s = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
			else if(type.equals("2"))
			    s = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			else if(type.equals("3"))
			    s = (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date());
			else if(type.equals("4"))
			    s = (new SimpleDateFormat("yyyy/MM/dd")).format(new Date());
			else if(type.equals("5"))
			    s = (new SimpleDateFormat("HHmm")).format(new Date());
			else*/
			
			s = new SimpleDateFormat(type).format(new Date());
//		}catch (Exception ex){
//			throw new Exception("JspCybus.getDate(\""+type+"\")\r\n"+ex.getMessage());
//		}
		return s;
	}
	   
	   
	   public static String getAddDate( int amount )
	    {
	        Calendar cal = Calendar.getInstance(Locale.getDefault());
	        		 cal.add(Calendar.DATE, amount);
	        StringBuffer buf = new StringBuffer();
	        buf.append(Integer.toString(cal.get(1)));
	        String month = Integer.toString(cal.get(2) + 1);
	        if(month.length() == 1)
	            month = "0" + month;
	        String day = Integer.toString(cal.get(5));
	        if(day.length() == 1)
	            day = "0" + day;
	        buf.append(month);
	        buf.append(day);
	        return buf.toString();
	    }	   
       
	   /**
	    * TimeMillis값을 Date형식으로 바꾸어 준다.
	    * @param time
	    * @return
	    */
	   public static String getTimeMillisDate(long time){
		return getTimeMillisDate(time, DATE_GUBUN);
       }

	   public static String getTimeMillisDate(long time, String delimeter){
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(time);
   
			return getDate(cal, delimeter);
	   }
	   
		/**
		 * 해당 날짜의 년월일을 돌려준다. - YYYYMMDD
		 * @param cal - 해당날짜의 Calendar 객체 
		 */
		public static String getDate(Calendar cal, String delimeter){
			String month, day;

	 		StringBuffer buf = new StringBuffer();

	 		buf.append(Integer.toString(cal.get(Calendar.YEAR)));
	 		if(!delimeter.equals("")) buf.append(delimeter);
	 		month = Integer.toString(cal.get(Calendar.MONTH)+1);
	 		if(month.length() == 1) month = "0" + month;
	 		day = Integer.toString(cal.get(Calendar.DATE));
	 		if(day.length() == 1) day = "0" + day;

	 		buf.append(month);
	 		if(!delimeter.equals("")) buf.append(delimeter);
	 		buf.append(day);
	 		
			return buf.toString();
		}
        
        /**
         *  2006.03.22 추가 (ajelier)
        *   날짜 포맷, 지정한 구분자로 날짜 포멧을 만들어준다
        *   @param 날짜(ex,20020202101010)
        *   @retutn  날짜(ex,2002/02/02,2002.02.02,2002-02-02)
        */
        public static String getDateFormat(String m_sDate, String gubun){
            if ( m_sDate == null )
                return "";
            else if ( m_sDate.length() < 8 )
                return m_sDate;
            else
                return m_sDate.substring(0,4) + gubun + m_sDate.substring(4,6) + gubun + m_sDate.substring(6,8);
        }
        
        /**
         *  2006.03.22 추가 (ajelier)
        *   날짜 포맷, 지정한 구분자로 날짜 포멧을 만들어준다
        *   @param 날짜(ex,20020202101010)
        *   @retutn  날짜(ex,2002/02/02,2002.02.02,2002-02-02)
        */
        public static String getDateFormatEng(String m_sDate, String gubun){
            if ( m_sDate == null )
                return "";
            else if ( m_sDate.length() < 8 )
                return m_sDate;
            else
                return m_sDate.substring(6,8)+gubun + m_sDate.substring(4,6)+gubun +  m_sDate.substring(0,4);
        }


/*********************************************************
	 * 원하는 날짜의 월 구하기. 한달 뒤 날짜 구하기
	 * param value : String type 현재 날짜(혹은 입력한 날짜)
							(yyyy-mm-dd)
	 * param value : int type 원하는 날짜(월 기준,,,) 차이 
						한달전 : -1, 두달전 : -2.....,
						한달후 : +1, 두달후 +2......,
	 
	* return value : String type wdate
	*********************************************************/
	public String wDate(String c_Date, int w)
	{
		String wdate="";
		 java.util.Calendar calen = java.util.Calendar.getInstance();
		
		 c_Date = c_Date.replaceAll("-", "");
		 c_Date = c_Date.replaceAll("/", "");
		 
//		try{
			calen.set(Integer.parseInt(c_Date.substring(0,4)),Integer.parseInt(c_Date.substring(4,6))-1,Integer.parseInt(c_Date.substring(6,8)));

			calen.add(Calendar.MONTH,w );

			String year = String.valueOf(calen.get(java.util.Calendar.YEAR)); 
			String month = String.valueOf(calen.get(java.util.Calendar.MONTH) + 1); 
			String day = String.valueOf(calen.get(java.util.Calendar.DATE)); 

			if(Integer.parseInt(month)<10){
				month="0"+month;
			}
			if(Integer.parseInt(day)<10){
				day="0"+day;
			}

			wdate=year+"-"+month+"-"+day;

//		}catch(Exception ex){
//			System.out.println(ex.getMessage());
//		}
		 return wdate;
	}
	
	/*********************************************************
	 * 원하는 날짜의 날짜의 몇칠전 일자 구하기
	 * param value : String type 현재 날짜(혹은 입력한 날짜)
							(yyyy-mm-dd)
	 * param value : int type 원하는 날짜(월 기준,,,) 차이 
						
	 
	* return value : String type wdate
	*********************************************************/
	public String getwDate(String c_Date, int w)
	{
		String wdate="";
		 java.util.Calendar calen = java.util.Calendar.getInstance();
		
//		try{
			calen.set(Integer.parseInt(c_Date.substring(0,4)),Integer.parseInt(c_Date.substring(5,7))-1,Integer.parseInt(c_Date.substring(8,10)));

			calen.add(Calendar.DATE,w );

			String year = String.valueOf(calen.get(java.util.Calendar.YEAR)); 
			String month = String.valueOf(calen.get(java.util.Calendar.MONTH) + 1); 
			String day = String.valueOf(calen.get(java.util.Calendar.DATE)); 

			if(Integer.parseInt(month)<10){
				month="0"+month;
			}
			if(Integer.parseInt(day)<10){
				day="0"+day;
			}

			wdate=year+"-"+month+"-"+day;

//		}catch(Exception ex){
//			System.out.println(ex.getMessage());
//		}
		 return wdate;
	}

	/******************************************************************************************
	 * (0 = Sunday, 1 = Monday, 2 =  Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday)
	 * 특정일(yyyyMMdd) 에서 주어진 일자만큼 더한 날짜를 계산한다.
	 ******************************************************************************************/
	@SuppressWarnings("static-access")
	public static String getRelativeDate(String date, int rday) throws Exception{
		if (date == null){
			return null;
		}
		
		if (date.length() < 8 ){
			return ""; // 최소 8 자리
		}
		
		String time = "";
		
//		try{
			TimeZone kst = TimeZone.getTimeZone("JST");
			TimeZone.setDefault(kst);			
			Calendar cal = Calendar.getInstance(kst); // 현재
			
			int yyyy = Integer.parseInt(date.substring(0,4));
			int mm = Integer.parseInt(date.substring(4,6));
			int dd = Integer.parseInt(date.substring(6,8));
			
			cal.set(yyyy,mm-1,dd);   // 카렌더를 주어진 date 로 세팅하고
			cal.add (cal.DATE, rday); // 그 날자에서 주어진 rday 만큼 더한다.
		
			time = new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
//		}catch (Exception ex){
//			throw new Exception("JspCybus.getRelativeDate(\""+date+"\","+rday+")\r\n"+ex.getMessage());
//		}
		return time;
	}

	/**  
	*	두 시간의 차이를 초로 계산한다.
	*	예)
	*	getSecondDiff("20000302102000","20000302102130") --> 60
	*
	*	처음 파라메터가 작은 날짜인데 만약 더 큰날짜를 처음으로 주면 음수를리턴.
	*/
	public int getSecondDiff(String s_start,String s_end) throws Exception{
		long l_start,l_end,l_gap;

		int i_start_year=0,i_start_month=1,i_start_day=1,i_start_hour=0,i_start_min=0,i_start_sec=0;
		int i_end_year=0,i_end_month=1,i_end_day=1,i_end_hour=0,i_end_min=0,i_end_sec=0;

//		try
//		{
//			try
//			{
				i_start_year = Integer.parseInt(s_start.substring(0,4));
				i_start_month= Integer.parseInt(s_start.substring(4,6)); // month 는 Calendar에서 0 base 으로 작동하므로 1 을 빼준다.
				i_start_day  = Integer.parseInt(s_start.substring(6,8));
				i_start_hour = Integer.parseInt(s_start.substring(8,10));
				i_start_min  = Integer.parseInt(s_start.substring(10,12));
				i_start_sec  = Integer.parseInt(s_start.substring(12,14));
//			}
//			catch (IndexOutOfBoundsException ex)
//			{
//				// ignore
//			}
//
//			try
//			{
				i_end_year = Integer.parseInt(s_end.substring(0,4));
				i_end_month= Integer.parseInt(s_end.substring(4,6)); // month 는 Calendar 에서0 base 으로 작동하므로 1 을 빼준다.
				i_end_day  = Integer.parseInt(s_end.substring(6,8));
				i_end_hour = Integer.parseInt(s_end.substring(8,10));
				i_end_min  = Integer.parseInt(s_end.substring(10,12));
				i_end_sec  = Integer.parseInt(s_end.substring(12,14));
//			}
//			catch (IndexOutOfBoundsException ex)
//			{
//				// ignore
//			}
//		}
//		catch (Exception ex)
//		{
//			throw new Exception("JspCybus.getMinuteDiff("+s_start+","+s_end+")\r\n"+ex.getMessage());
//		}

		Calendar cal=Calendar.getInstance();

		cal.set(i_start_year,i_start_month-1,i_start_day,i_start_hour,i_start_min,i_start_sec);
		l_start=cal.getTime().getTime();

		cal.set(i_end_year,i_end_month-1,i_end_day,i_end_hour,i_end_min,i_end_sec);
		l_end=cal.getTime().getTime();

		l_gap=l_end-l_start;

		return (int)(l_gap/1000);
	}

	/**  
	*	두 시간의 차이를 시분초로 계산한다.
	*	예)
	*	getSecondDiff("20000302102000","20000302102130") --> 60
	*
	*	처음 파라메터가 작은 날짜인데 만약 더 큰날짜를 처음으로 주면 음수를리턴.
	*/
	public String getTimeDiff(String s_start,String s_end) throws Exception{

		//System.out.println("s_starts_starts_starts_starts_start:"+s_start);
		//System.out.println("s_ends_ends_ends_ends_ends_ends_end:"+s_end);

		long l_start,l_end,l_gap;
		String time = "";

		int i_start_year=0,i_start_month=1,i_start_day=1,i_start_hour=0,i_start_min=0,i_start_sec=0;
		int i_end_year=0,i_end_month=1,i_end_day=1,i_end_hour=0,i_end_min=0,i_end_sec=0;

//		try
//		{
//			try
//			{
				i_start_year = Integer.parseInt(s_start.substring(0,4));
				i_start_month= Integer.parseInt(s_start.substring(4,6)); // month 는 Calendar에서 0 base 으로 작동하므로 1 을 빼준다.
				i_start_day  = Integer.parseInt(s_start.substring(6,8));
				i_start_hour = Integer.parseInt(s_start.substring(8,10));
				i_start_min  = Integer.parseInt(s_start.substring(10,12));
				i_start_sec  = Integer.parseInt(s_start.substring(12,14));
//			}
//			catch (IndexOutOfBoundsException ex)
//			{
//				// ignore
//			}
//
//			try
//			{
				i_end_year = Integer.parseInt(s_end.substring(0,4));
				i_end_month= Integer.parseInt(s_end.substring(4,6)); // month 는 Calendar 에서0 base 으로 작동하므로 1 을 빼준다.
				i_end_day  = Integer.parseInt(s_end.substring(6,8));
				i_end_hour = Integer.parseInt(s_end.substring(8,10));
				i_end_min  = Integer.parseInt(s_end.substring(10,12));
				i_end_sec  = Integer.parseInt(s_end.substring(12,14));
//			}
//			catch (IndexOutOfBoundsException ex)
//			{
//				// ignore
//			}
//		}
//		catch (Exception ex)
//		{
//			throw new Exception("JspCybus.getTimeDiff("+s_start+","+s_end+")\r\n"+ex.getMessage());
//		}

		Calendar cal=Calendar.getInstance();

		cal.set(i_start_year,i_start_month-1,i_start_day,i_start_hour,i_start_min,i_start_sec);
		l_start=cal.getTime().getTime();

		cal.set(i_end_year,i_end_month-1,i_end_day,i_end_hour,i_end_min,i_end_sec);
		l_end=cal.getTime().getTime();

		l_gap=l_end-l_start;
		if(l_gap == 0) {
			time = "0초";
			return time;
		}

		int consultTime = (int)(l_gap/1000);

		int si = consultTime/3600;	//시간 셋팅
		int bun = (consultTime - si * 3600 )/ 60; //분 셋팅
		int cho = consultTime - (si * 3600 + bun * 60);

		//System.out.println("시간 : "+si);
		//System.out.println("분  : "+bun);
		//System.out.println("초 : "+cho);

		if(si != 0 ) {
			time = time + si+ ":";
		}
		if(bun != 0 ) {
			time = time + bun+":";
		}
		if(cho !=0) {
			time = time + cho+ ":";
		}
		
		return time;
	}

		/**  
	*	초를 시/분/초로 변환한다
	*	예)
	*	getSecondDiff("03") --> 03
	*
	*	처음 파라메터가 초일경우 시분초로 변환한다.
	*/
	public String getTimeDiff(String s_start) throws Exception{

		int l_start = 0;
		String time = "";
		
		StringTokenizer st = new StringTokenizer(s_start, ".");
		while (st.hasMoreTokens())
		{
		 s_start = st.nextToken();
		 break;
		}

		l_start = Integer.parseInt(s_start);

		if(l_start == 0) {
			time = "0";
		}

		int si = l_start/3600;	//시간 셋팅
		int bun = (l_start - si * 3600 )/ 60; //분 셋팅
		int cho = l_start - (si * 3600 + bun * 60);

		if(si != 0 ) {
			if(si < 10) time = time + "0"+si+ ":";
			else time = time + si+ ":";
		}
		else
		{
			if(l_start == 0) time = time + "0:";
			else time = time + "00:";
		}

		if(bun != 0 ) {
			if(bun < 10) time = time + "0"+bun+":";
			else time = time + bun+":";
		}
		else time = time + "00:";

		if(cho !=0) {
			if(cho < 10) time = time + "0"+cho;
			else time = time + cho;
		}
		else time = time + "00";
		
		return time;
	}



	public String  enDate(){

		Date date;
		SimpleDateFormat formatter;
		String pattern = "MMMMMMMMMMMM.dd.yyyy";
		String result;

		formatter = new SimpleDateFormat(pattern, new Locale("",""));
		date = new Date();
		result = formatter.format(date);
		//System.out.println("result : " + result);

		return result;

	}

	public String en(String ko) throws UnsupportedEncodingException {
		String new_str = null;
//		try {
			new_str= new String(ko.getBytes("KSC5601"), "8859_1");
//		} catch(UnsupportedEncodingException ex) {
//			logger.err
//		}
		return new_str;
	}

	public String ko(String en) throws UnsupportedEncodingException {
		String new_str = null;
//		try {
			new_str= new String(en.getBytes("8859_1"), "KSC5601");
//		} catch(UnsupportedEncodingException ex) { }
		return new_str;
	}
	
	//=======================================================================
	// 현재날자 가져오기
	public synchronized final static String getToDay(int format)
	{
		String dataFrCh = "";
		java.util.Date now = new java.util.Date();
		SimpleDateFormat vans = null;
		
		switch (format)
		{
			case 1:				// ex)2007-01-30
				vans = new SimpleDateFormat("yyyy-MM-dd");
				break;
			
			case 2:				// ex)20070130
				vans = new SimpleDateFormat("yyyyMMdd");
				break;
			
			case 3:				// ex)2007/01/30
				vans = new SimpleDateFormat("yyyy/MM/dd");
				break;
			
			case 4:				// ex)2007.01.30
				vans = new SimpleDateFormat("yyyy.MM.dd");
				break;

			default:
				break;
		}
		if (vans != null) {
			dataFrCh = vans.format(now);
		}
		return dataFrCh;
	}
	//=======================================================================	
	//=======================================================================
	// 현재시간 가져오기
	public synchronized final static String getToDayTime(int format)
	{
		String dataFrCh = "";
		java.util.Date now = new java.util.Date();
		SimpleDateFormat vans = null;
		
		switch (format)
		{
			case 1:				// ex)10:10:11
				vans = new SimpleDateFormat("HH:mm:ss");
				break;
	
			case 2:				// ex)101011
				vans = new SimpleDateFormat("HHmmss");
				break;
			
			default:
				break;
		}
		if (vans != null) {
			dataFrCh = vans.format(now);
		}
		return dataFrCh;
	}		
}
