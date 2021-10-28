package com.llynx.cmn.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class StringUtils {

	/**
	 * 줄넘김을 <br/> 태그로 처리하여 뷰 페이지 내에서 입력한 것과 동일하게 보게 한다.
	 */
	public static String htmlNewLine(String input) {
		
	    StringReader stringReader = new StringReader(input);
	    BufferedReader reader = new BufferedReader(stringReader);
	    StringBuffer ret = new StringBuffer(input.length() + 200);
        String line = null;
        try {
		    while ((line = reader.readLine()) != null) {
		               ret.append(line).append("<br/>");
		    }
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return ret.toString();		
	
	}

    /**
     * 
     * 8859_1 을 KSC5601 문자셋으로 변경한다.<br>
     * 
     * @author ycpark
     * @version 1.0
     * @modifydate 2004. 5. 19.
     * 
     * @param en 8859_1 문자
     * @return KSC5601 문자
     */    
    public static String toKSC(String en) 
    {
        String new_str = null;      
        try {
            if(en != null){
                new_str = new String (en.getBytes("8859_1"), "KSC5601");
            }else{
                new_str = "";
            }
        } catch (UnsupportedEncodingException e) {}
        return new_str;
    }

    /**
     * 한글을 포함하고 있는지 검사한다.
     * 
     * @param c
     * @return
     * 
     * @author ycpark
     * @version 1.0 2006. 6. 12.
     */
    public static boolean isKorean(char c) {
        if ( 44032 <= c && c <= 55203 ) return true;
        return false;
    }
    
    /**
     * 주어진 문장이 한글인 경우 변환한다.
     * 
     * @param str
     * @return
     * 
     * @author ycpark
     * @version 1.0 2006. 6. 12.
     */
    public static String absToKSC(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        char[] chArr = toKSC(str).toCharArray();
        boolean isKorean = false;
        for (int i=0; i < chArr.length; i++ ) {
            isKorean = isKorean(chArr[i]);
            if (isKorean) break;
        }
        if (isKorean) {
            str = toKSC(str);
        }
        
        return str;
    }

    /**
     * 현재날짜를 YYYY-MM-DD HH:MM:SS 형식으로 만들어 리턴 <br>
     * 
     * @author : park young chun
     * @email  : ycpark@paladintech.co.kr
     */
    public static String getTime(){
    	String ch = null;
    	try{
    		TimeZone tz = new SimpleTimeZone( 9 * 60 * 60 * 1000, "KST" );
    		TimeZone.setDefault(tz);
    		Date d = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd' 'HH':'mm':'ss");
    		ch = sdf.format(d);
    	}catch(Exception dfdf){}
    	return ch;
    }

    public static String getDate()
    {
    	String ch = null;
    	try
    	{
    		TimeZone tz = new SimpleTimeZone( 9 * 60 * 60 * 1000, "KST" );
    		TimeZone.setDefault(tz);
    		Date d = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy'-'MM'-'dd");
    		ch = sdf.format(d);
    	} catch(Exception dfdf) { }
    	return ch;
    }    
    
    /**
     * 현재날짜를 YYYYMMDD 형식으로 만들어 리턴 <br>
     *
     * @author : park young chun
     * @email  : ycpark@paladintech.co.kr
     */  
    public static String getDate3()
    {
    	String ch = null;
    	try
    	{
    		TimeZone tz = new SimpleTimeZone( 9 * 60 * 60 * 1000, "KST" );
    		TimeZone.setDefault(tz);
    		Date d = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    		ch = sdf.format(d);
    	} catch(Exception dfdf) { }
    	return ch;
    }

  	/**
	* 현재 날짜에서n으로 이동한 날짜 YYYYMMDD로 return.<br>
	* 
	* @author : park young chun
	* @email  : ycpark@paladintech.co.kr
	*/
	public static String getDate2(int n)
	{
		SimpleTimeZone kst = new SimpleTimeZone(9 *	60 * 60	 * 1000, "KST");
		Calendar cal = Calendar.getInstance(kst);
		cal.add(Calendar.DATE, n);
		String y,m,d;
		
		y =	""+cal.get(Calendar.YEAR);
		
		if((cal.get(Calendar.MONTH)+1) < 10)
			m =	"0"+(cal.get(Calendar.MONTH)+1);
		else m = ""+(cal.get(Calendar.MONTH)+1);
		
		if(cal.get(Calendar.DATE) <	10)
			d =	"0"+ cal.get(Calendar.DATE);
		else d = ""+cal.get(Calendar.DATE);
		
    return y+m+d;
	}

    /**
     * 현재 날짜를 타입에 따라 년, 월,일 만을 리턴 <br>
     *
     * @author : ycpark
     * @email : ycpark@paladintech.co.kr
     */  
    public static String getDate(int type)
    {
    	String ch = getDate();
    	String format = null;		
    	switch(type){
    		case 1:
    			format = ch.substring(0,4);
    			break;
    		case 2:
    			format = ch.substring(5,7);
    			break;
    		case 4:
    			format = ch.substring(0,4)+ch.substring(5,7)+ch.substring(8,10);
    			break;
    			
    		default:
    			format = ch.substring(8,10);
    			break;
    	}
    	return format;
    }	
    
    /**
     * 외국 날짜 포맷방식
     * @author : ycpark
     * @return
     */
    public static String getAbroadDate(){
    	SimpleDateFormat sf = new SimpleDateFormat("dd MMM yyyy", new Locale("en","US"));
    	Date today = new Date();
    	String now = sf.format(today);		
    	return now;
    }    
	
    /**
    * 디버깅시 Servlet 에서는 PrintWriter 를 넣어서 쉽게 디버깅을 할 수 있었지만 <br>
    * JSP 에서 처럼 PrintWriter가 없을때 디버깅을 쉽게 하기 위하여 메세지를 문자열로 만들어 리턴하게 하였음.<br>
    *
    * @author : park young chun 
    * @email : ycpark@paladintech.co.kr
    */
    public static String getStackTrace(Throwable e) {
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        java.io.PrintWriter writer = new java.io.PrintWriter(bos);
        e.printStackTrace(writer);
        writer.flush();
        return bos.toString();
    }
    
    public static String removeCharAll(String str, String removeChar) {
    	return str.trim().replace(removeChar, "");
    }
    
    public static String mapToQueryString(Map<String,Object> map) {
		String queryString = "?";
		for(String mapKey : map.keySet()) {
			queryString += mapKey +"="+URLEncoder.encode(map.get(mapKey).toString())+"&";
		}
		queryString = queryString.substring(0, queryString.length()-1);
		return queryString;
	}
}
