/*
* File Name : DateUtil.java
* Author: ZZ18769
* Date: 2010. 2. 22.
* Company: Paladin Technology Inc.
* Description: OOO를 OO하는 OO 클래스
* Modification Information
* 수정일 수정자 수정내용
* ------------ ----------- ---------------------------
* 2010. 2. 22. ZZ18769 최초작성
*
* Copyright 2010  KPIC TCM All Rights reserved.
*/

package com.llynx.cmn.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

/**
 * OO으로 제공되는 OO OO.
 * 실제 코딩시 이 Template의 코딩 스타일을 참조해야 함.
 *
 * @author ZZ18769
 * @since 2010. 2. 22.
 * @version 1.0
 * @see (필요시)
 */
public class DateUtil {
    
    public static  Date getCurrentDate() {
        try{
            TimeZone tz = new SimpleTimeZone( 9 * 60 * 60 * 1000, "KST" );
            TimeZone.setDefault(tz);
        }catch(Exception e){}
        return new Date();
    }

    /**
     * 
     * 현재 일자를 원하는 format 으로 변경하여 문자열로 리턴<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 5. 19.
     * 
     * @param date_format 날짜 반환 유형
     * yyyy - 년도
     * MM - 월
     * dd - 일
     * HH - 시간
     * mm - 분
     * ss - 초
     * @return 문자열
     */    
    public static String getTodayString(String date_format)
    {
        String dateStr = "";
        try{
            Date date=getCurrentDate();
            SimpleDateFormat sdf = new SimpleDateFormat(date_format, Locale.KOREAN);
            dateStr = sdf.format(date);
        }catch(Exception e){}
        return dateStr;
    }

    /**
     * 
     * 현재 일자를 YYYYMMDD 형식으로 리턴<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 11. 22.
     * 
     * @param date_format 날짜 반환 유형
     * yyyy - 년도
     * MM - 월
     * dd - 일
     * HH - 시간
     * mm - 분
     * ss - 초
     * @return 문자열
     */    
    public static String getTodayString2()
    {
        SimpleTimeZone kst = new SimpleTimeZone(0x1ee6280, "KST");
        Calendar cal = Calendar.getInstance(kst);
        String y = "" + cal.get(1);
        String m;
        if(cal.get(2) + 1 < 10)
            m = "0" + (cal.get(2) + 1);
        else
            m = "" + (cal.get(2) + 1);
        String d;
        if(cal.get(5) < 10)
            d = "0" + cal.get(5);
        else
            d = "" + cal.get(5);
        return y + m + d;
    }    

    /**
     * 
     * 입력한 일자를 원하는 format 으로 변경하여 문자열로 리턴<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 5. 19.
     * 
     * @param date_format 날짜 반환 유형
     * yyyy - 년도
     * MM - 월
     * dd - 일
     * HH - 시간
     * mm - 분
     * ss - 초
     * @return 문자열
     */    
    public static String getDateString(Date dt, String date_format)
    {
        String dateStr = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(date_format, Locale.KOREAN);
            dateStr = sdf.format(dt);
        }catch(Exception e){}
        return dateStr;
    }

    /**
     * 입력한 일자를 원하는 format 으로 변경하여 문자열로 리턴<br>
     * 
     * @param dt
     * @param date_format
     * @param locale java.util.Locale 참조
     * @return
     * 
     * @author Park Young Chun
     * @version 1.0 2006-04-10
     */
    public static String getDateString(Date dt, String date_format, Locale locale)
    {
        String dateStr = "";
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(date_format, locale);
            dateStr = sdf.format(dt);
        }catch(Exception e){}
        return dateStr;
    }    
   /**
    * 
    * 
    * JDBC용 특정 시점의 DATE를 리턴한다.<br>
    * 
    * @author Park Young Chun
    * @version 1.0
    * @createdate 2004. 6. 2.
    * @modifydate 2004. 6. 2.
    * 
    * @param dt 변환하고자 하는 날짜.
    * @return yyyy-MM-dd hh:mm:ss 형태의 날짜시간만 리턴
    */
    public static java.sql.Timestamp getSqlDateTime(java.util.Date dt) 
    {
        java.util.Date d = null;
        if(dt == null){
            d = new java.util.Date();
        }else{
            d = dt;
        }
        return new java.sql.Timestamp(d.getTime());
    }

    /**
     * 
     * 
     * JDBC용 특정 시점의 DATE를 리턴한다.!<br>
     *
     * @author Park Young Chun
     * @version 1.0
     * @createdate 2004. 6. 2.
     * @modifydate 2004. 6. 2.
     * 
     * @param dt
     * @return yyyy-mm-dd 포멧의 날짜만 리턴.
     */
    public static java.sql.Date getSqlDate(java.util.Date dt) 
    {
        java.util.Date d = null;
        if(dt == null){
            d = new java.util.Date();
        }else{
            d = dt;
        }
        return new java.sql.Date(d.getTime());  
    }

    /**
     * 
     * 
     * JDBC용 특정 시점의 시간을 리턴한다.!<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @createdate 2004. 6. 2.
     * @modifydate 2004. 6. 2.
     * 
     * @param dt
     * @return hh:mm:ss 포멧의 시간만 리턴.
     */
    public static java.sql.Time getSqlTime(java.util.Date dt) 
    {
        java.util.Date d = null;
        if(dt == null){
            d = new java.util.Date();
        }else{
            d = dt;
        }
        return new java.sql.Time(d.getTime());
    }

    /**
     * 
     * 
     * 입력받은 String오브젝트를 특정한 포멧 형식의 Date 형으로 만들어 리턴 <br>
     * 예) stringToDate("2001-06-01", "yyyy-'-'MM'-'dd")<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 6. 7.
     * 
     * @param d
     * @param format
     * @return
     */
    public static String stringToDateString(String d, String format)
    {
        java.util.Date ch = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            ch = sdf.parse(d);
        } catch(Exception dfdf) { }
        return getDateString(ch, format);
    }

    /**
     * 
     * 
     * 입력받은 String오브젝트를 특정한 포멧 형식의 Date 형으로 만들어 리턴 <br>
     * 예) stringToDate("2001-06-01", "yyyy-'-'MM'-'dd")<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 6. 7.
     * 
     * @param d
     * @param format
     * @return
     */
    public static String stringToDateString(String d, String oldformat, String newformat)
    {
        java.util.Date ch = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(oldformat);
            ch = sdf.parse(d);
        } catch(Exception dfdf) { }
        return getDateString(ch, newformat);
    }
    
    
    
    /**
     * 
     * 주어진 날짜 문자열을 java.util.Date 형으로 반환한다.<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 6. 10.
     * 
     * @param d
     * @return
     */
    public static java.util.Date getDate(String d)
    {
        java.util.Date ch = null;
        try
        {
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.KOREA);
            ch = df.parse(d);
        } catch(Exception dfdf) { }
        return ch;
    }
    
    /**
     * 
     * 주어진 문자열을 java.util.Date 형으로 반환한다.<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 7. 2.
     * 
     * @param d
     * @param format
     * @return
     */
    public static java.util.Date getDate (String d, String format)
    {
        java.util.Date ch = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.KOREAN);
            ch = sdf.parse(d);
        } catch(Exception dfdf) { }
        return ch;
    }
    
    /**
     * 주어진 문자열을 java.util.Date 형을 반환한다.
     * 
     * @param d
     * @param format
     * @param locale java.util.Locale 을 참조.
     * @return
     * 
     * @author Park Young Chun
     * @version 1.0 2006-04-10
     */
    public static java.util.Date getDate (String d, String format, Locale locale)
    {
        java.util.Date ch = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
            ch = sdf.parse(d);
        } catch(Exception dfdf) { }
        return ch;
    }
    
    /**
     * 
     * 오늘 날짜가 두 날짜 사이에 존재하는지 확인한다.<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 6. 10.
     * 
     * @param first
     * @param second
     * @return
     */
    public static boolean betweenDate(String first, String second, String format){
        boolean flag = false;
        java.util.Date start = null;
        java.util.Date end = null;
        java.util.Date current = null;
        
        try{            
            start = getDate(first, format);
            end = getDate(second, format);
            current = getDate(getTodayString(format), format);
        }catch(Exception pe){
            return false;               
        }
        
        if((start.before(current) && end.after(current)) || start.equals(current) || end.equals(current)) 
            flag= true;
        
        return flag;
    }
    
    /**
     * 
     * 주어진 날짜에 일자를 더한 날짜를 구한다.<br>
     * 
     * @author Park Young Chun
     * @version 1.0
     * @modifydate 2004. 11. 26.
     * 
     * @param date
     * @param amount
     * @return
     */
    public static Date add (Date date, int amount) {
        Calendar c = Calendar.getInstance (Locale.KOREAN);
        c.setTime(date);
        
        c.add(Calendar.DATE, amount);
        return c.getTime();
    }
    
     /**
      * 해당 주의 일요일부터 토요일까지의 날짜를 리턴
      * 
      * @param year
      * @param month
      * @param date
      * @return
      */
    public static String[] getWeek(int year, int month, int date) {
        Format format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar g = new GregorianCalendar(year, month-1 , date);
        g.add(Calendar.HOUR,1);
        int dayOfWeek =  g.get(Calendar.DAY_OF_WEEK);
        String[] week = new String[7];
        // dayOfWeek : sunday = 1, Saturday = 7;
        week[0] = getFullDate(g, 1-dayOfWeek, format);
        week[1] = getFullDate(g, 1, format);
        week[2] = getFullDate(g, 1, format);
        week[3] = getFullDate(g, 1, format);
        week[4] = getFullDate(g, 1, format);
        week[5] = getFullDate(g, 1, format);
        week[6] = getFullDate(g, 1, format);
   
        return week;
    }
    
    private static String getFullDate(Calendar g, int i, Format format) {
        g.add(Calendar.DATE, i);

        return format.format(g.getTime());
    }
    
    /**
     * 날짜문자열을 날짜표시타입으로 변환한다. <BR>
     * (예) 19981210 --> 1998-12-10  delimeter(-)        <BR>
     *     19981210 --> 1998/12/10  delimeter(/)        <BR>
     *     19981210 --> 1998.12.10  delimeter(.)        <BR>
     * @param    nowDate String 날짜문자열 구분작 존재하지 않는 숫자로만 구성된 날짜 (yyyymmdd)
     *          delimeter String 년,월,일을 구분하기 위한 구분자. ('/','-','.' 등등)
     * @return   변경된 날짜 문자열.(구분자가 첨가된 날짜 형태) (yyyy-mm-dd)
     */
	public static String StringToDate(String nowDate, String delimeter)
	{
		String temp   = null;
        String fac_no = null;

        if (nowDate == null || nowDate.length() == 0 ){
        	fac_no = "";
        }else if (nowDate.length() == 6)
        {
	     	temp   = nowDate.substring(0, 4);
	      	fac_no = temp + "." ;
	      	temp   = nowDate.substring(4, 6);
	        fac_no = fac_no + temp;
        }else if (nowDate.length() == 8)
        {
	     	temp   = nowDate.substring(0, 4);
	      	fac_no = temp + delimeter ;
	      	temp   = nowDate.substring(4, 6);
	        fac_no = fac_no + temp + delimeter;
	        temp   = nowDate.substring(6, 8);
	        fac_no = fac_no + temp;
        }else if (nowDate.length() == 14)
        {
	     	temp   = nowDate.substring(0, 4);
	      	fac_no = temp + delimeter ;
	      	temp   = nowDate.substring(4, 6);
	        fac_no = fac_no + temp + delimeter;
	        temp   = nowDate.substring(6, 8);
	        fac_no = fac_no + temp+ " ";
	        temp   = nowDate.substring(8, 10);
	        fac_no = fac_no + temp + ":";
	        temp   = nowDate.substring(10, 12);
	        fac_no = fac_no + temp + ":";
	        temp   = nowDate.substring(12, 14);
	        fac_no = fac_no + temp;
        }else
        {
        	fac_no ="";
        }
        return fac_no;
     }   
}