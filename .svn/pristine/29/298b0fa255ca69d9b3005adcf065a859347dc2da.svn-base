/*
* File Name : StringUtil.java
* Author: ZZ18769
* Date: 2010. 1. 28.
* Company: Paladin Technology Inc.
* Description: Util 기능 구현하는 클래스
* Modification Information
* 수정일 수정자 수정내용
* ------------ ----------- ---------------------------
* 2010. 1. 28. ZZ18769 최초작성
*
* Copyright 2010  KPIC TCM All Rights reserved.
*/

package com.llynx.cmn.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.regexp.RE;

/**
 * String 객체 관련 Util
 *
 * @author ybLee
 * @since 2021. 01. 20
 * @version 1.0
 * @see
 */
@SuppressWarnings({"unchecked","unused"})
public class StringUtil {

	public static String[] strip(String[] array) {
		String[] info = null;
		try {
			info = new String[array.length];
			for(int i=0; i<info.length; i++){
				info[i] = strip(array[i]);
			}
		} catch (Exception e) {
			return array;
		}
		return info;
	}
	public static String stripBlank(String orgMessage) {
		String s = null;
		try {
		    s = ((String)orgMessage).replaceAll( "&", "&amp;" );
		} catch (Exception e) {
			return orgMessage;
		}
	    return s;
	}

	public static String strip(String orgMessage) {



		//System.out.println("______strip______checkXSS_log___value== "+orgMessage);



		String s = null;
		try {
		    s = ((String)orgMessage).replaceAll( "&", "&amp;" );
		    s = s.replaceAll( "<", "&lt;" );
		    s = s.replaceAll( ">", "&gt;" );
		} catch (Exception e) {
			return orgMessage;
		}
	    return s;
	}

	// 코로스사이트 스크립트 체크	2015-12-08 적용
	public static String checkXSS(String value) {


		//System.out.println("____________checkXSS_log___value== "+value);

		if (("".equals(value)) || (value == null)) {
	        return value;
	    }
		value = value.replaceAll("&", "&#38;");
		value = value.replaceAll("<", "&lt");
		value = value.replaceAll(">", "&gt");
		value = value.replaceAll("#", "&#35;");
		value = value.replaceAll("\'", "&#39;");
		value = value.replaceAll("\"", "&#34;");

		return value;
	}

	public static String stripSQL(String sql) {
		String s = null;
		try {
		    s =  sql.replaceAll( "&", "&amp;" );
		    s = s.replaceAll( "--", "- -" );
		    s = s.replaceAll( ";", "" );
		} catch (Exception e) {
			return sql;
		}
	    return s;
	}
	public static String stripSQLValue(String sql) {
		String s = null;
		try {
		    s =  sql.replaceAll( "&", "&amp;" );
		    s = s.replaceAll( "--", "- -" );
		    s = s.replaceAll( ";", "" );
		} catch (Exception e) {
			return sql;
		}
	    return s;
	}
	public static String stripFilename(String filename) {

		String s = null;
		try {
		    s =  stripDot(filename);
		    s = s.replaceAll( "/", "" );
		} catch (Exception e) {
			return filename;
		}
	    return s;

	}
    static String stripDot(String s) {
		StringBuffer buf = new StringBuffer();
		try {
			char[] s2 = s.toCharArray();
			boolean begin = false;
			for(int i=0; i<s2.length; i++) {
				if((i+1)<s2.length && s2[i] == '.' && s2[i+1] =='.') {
					i++;
					continue;
				}
				buf.append(s2[i]);
			}
		} catch (Exception e) {
			return s;
		}
		return buf.toString();
	}
    public static String stripChar(String str) {
    	StringBuffer b = new StringBuffer();
    	try {
    		char[] cs = str.toCharArray();
    		for(char c : cs) {
    			if(c == '\r' || c=='\n')
    				continue;

    			b.append(c);
    		}

    	} catch (Exception e) {
    		return str;
    	}
    	return b.toString();
    }
	public static String stripFilepath(String path){
		String s = null;
		try {
			s =  stripDot(path);
		} catch (Exception e) {
			return path;
		}
	    return s;
	}
	public static String replace(String s, String s1, String s2) {
		if (s == null)
			return s;
		StringBuffer stringbuffer = new StringBuffer("");
		int i = s1.length();
		int j = s.length();
		int k;
		int l;
		for (l = 0; (k = s.indexOf(s1, l)) >= 0; l = k + i) {
			stringbuffer.append(s.substring(l, k));
			stringbuffer.append(s2);
		}

		if (l < j)
			stringbuffer.append(s.substring(l, j));
		return stringbuffer.toString();
	}

	/**
	 * 주어진 값을 오른쪽에서 부터 len만큼 잘라서 반환
	 *
	 * @param s
	 *            소스 스트링
	 * @param len
	 *            자를 길이
	 *
	 * @return 주어진 스트링을 len만큼 오른쪽에서 자른 값
	 */
	public static String cutStringByByte(String str, int length) {
		if (str.equals("") || str.getBytes().length <= length) {
			return str;
		}

		int i = 0;
		String tmp = "";
		String ret = "";
		tmp = str.substring(0, 1);

		byte[] ar = tmp.getBytes();

		i += ar.length;

		while (i <= length) {
			ret += tmp;

			str = str.substring(1);
			tmp = str.substring(0, 1);
			ar = tmp.getBytes();
			i += ar.length;
		}
		return ret;
	}

	/**
	 * 주어진 값을 오른쪽에서 부터 length 만큼 잘른후 add 를 더한 문자열을 반환
	 *
	 * @param str
	 * @param length
	 * @param add
	 * @return
	 * @create 2009. 01. 08
	 */
	public static String cutStringByByte(String str, int length, String add) {
		if (add == null) {
			add = "...";
		}

		String cuttedString = cutStringByByte(str, length);
		if (str.length() != cuttedString.length()) {
			cuttedString = cuttedString + "...";
		}

		return cuttedString;
	}

	/**
	 * 입력값을 문자열로 변환
	 *
	 * @param parameter
	 * @param defValue
	 * @return
	 * @create 2009. 01. 08
	 */
	public static String defaultToString(Object parameter, String defValue) {
		if (parameter == null || "".equals(parameter))
			return defValue;
		else
			return defaultToString(String.valueOf(parameter), defValue);
	}

	/**
	 * 입력값을 문자열로 변환
	 *
	 * @param parameter
	 * @param defValue
	 * @return
	 * @create 2009. 01. 08
	 */
	public static String defaultToString(String parameter, String defValue) {
		if (parameter == null || "".equals(parameter))
			return defValue;
		else
			return parameter.trim();
	}

	/**
	 * 입력값을 int 형으로 변환
	 *
	 * @param parameter
	 * @param defValue
	 * @return
	 * @create 2009. 01. 08
	 */
	public static int convertToInt(Object parameter, int defValue) {
		if (parameter == null || "".equals(parameter))
			return defValue;
		else
			return convertToInt(String.valueOf(parameter), defValue);
	}

	/**
	 * 입력값을 int 형으로 변환
	 *
	 * @param parameter
	 * @param defValue
	 * @return
	 * @create 2009. 01. 08
	 */
	public static int convertToInt(String parameter, int defValue) {
		String param = parameter;
		if (param == null || "".equals(param))
			return defValue;
		else {
			try {
				return Integer.parseInt(param.trim());
			} catch (NumberFormatException nfe) {
				return defValue;
			}
		}
	}

	/**
	 * 입력값을 double 형으로 변환
	 *
	 * @param parameter
	 * @param defValue
	 * @return
	 * @create 2009. 01. 08
	 */
    public static double convertToDouble(Object parameter, double defValue) {
        if (parameter == null || "".equals(parameter))
            return defValue;
        else
            return convertToDouble(String.valueOf(parameter), defValue);
    }

    /**
     * 입력값을 double 형으로 변환
     *
     * @param parameter
     * @param defValue
     * @return
     * @create 2009. 01. 08
     */
    public static double convertToDouble(String parameter, double defValue) {
        String param = parameter;
        if (param == null || "".equals(param))
            return defValue;
        else {
            try {
                return Double.parseDouble(param.trim());
            } catch (NumberFormatException nfe) {
                return defValue;
            }
        }
    }

    /**
     * 입력값을 long 형으로 변환
     *
     * @param parameter
     * @param defValue
     * @return
     * @create 2009. 01. 08
     */
    public static long convertToLong(Object parameter, long defValue) {
        if (parameter == null || "".equals(parameter))
            return defValue;
        else
            return convertToLong(String.valueOf(parameter), defValue);
    }

    /**
     * 입력값을 long 형으로 변환
     *
     * @param parameter
     * @param defValue
     * @return
     * @create 2009. 01. 08
     */
    public static long convertToLong(String parameter, long defValue) {
        String param = parameter;
        if (param == null || "".equals(param))
            return defValue;
        else {
            try {
                return Long.parseLong(param.trim());
            } catch (NumberFormatException nfe) {
                return defValue;
            }
        }
    }

    /**
     * 입력값을 float 형으로 변환
     *
     * @param parameter
     * @param defValue
     * @return
     * @create 2009. 01. 08
     */
    public static float convertToFloat(Object parameter, float defValue) {
        if (parameter == null || "".equals(parameter))
            return defValue;
        else
            return convertToFloat(String.valueOf(parameter), defValue);
    }

    /**
     * 입력값을 float 형으로 변환
     *
     * @param parameter
     * @param defValue
     * @return
     * @create 2009. 01. 08
     */
    public static float convertToFloat(String parameter, float defValue) {
        String param = parameter;
        if (param == null || "".equals(param))
            return defValue;
        else {
            try {
                return Float.parseFloat(param.trim());
            } catch (NumberFormatException nfe) {
                return defValue;
            }
        }
    }


    /**
     * 입력값을 int 형으로 변환
     *
     * @param parameter
     * @return param
     * @create 2009. 01. 08
     */
    public static String convertToInt(String parameter) {
        String param = "";
        int defValue = 0;
        if (param == null || "".equals(param))
            param = "";
        else {
            try {
            	defValue = Integer.parseInt(param.trim());
            	param = String.valueOf(defValue);
            } catch (NumberFormatException nfe) {
            	param = parameter;
            }
        }
        return param;
    }
    /**
     * 입력값을 float 형으로 변환
     *
     * @param parameter
     * @return param
     * @create 2009. 01. 08
     */
    public static String convertToFloat(String parameter) {
        String param = "";
        Float defValue = null;
        if (param == null || "".equals(param))
            param = "";
        else {
            try {
            	defValue = Float.parseFloat(param.trim());
            	param = String.valueOf(defValue);
            } catch (NumberFormatException nfe) {
            	param = parameter;
            }
        }
        return param;
    }
    /**
     * 입력값을 double 형으로 변환
     *
     * @param parameter
     * @return param
     * @create 2009. 01. 08
     */
    public static String convertToDouble(String parameter) {
        String param = "";
        double defValue = 0;
        if (param == null || "".equals(param))
            param = "";
        else {
            try {
            	defValue = Double.parseDouble(param.trim());
            	param = String.valueOf(defValue);
            } catch (NumberFormatException nfe) {
            	param = parameter;
            }
        }
        return param;
    }
    /**
     * 입력값을 Long 형으로 변환
     *
     * @param parameter
     * @return param
     * @create 2009. 01. 08
     */
    public static String convertToLong(String parameter) {
        String param = "";
        long defValue = 0;
        if (parameter == null || "".equals(parameter))
            param = "";
        else {
            try {
            	defValue = Long.parseLong(parameter.trim());
            	param = String.valueOf(defValue);
            } catch (NumberFormatException nfe) {
            	param = parameter;
            }
        }
        return param;
    }

    /**
     * RegExp 를 이용하여 변환
     *
     * @param regExpStr
     * @param param
     * @param text
     * @return
     * @create 2009. 01. 08
     */
	@SuppressWarnings("rawtypes")
	public static String replaceRegExp(String regExpStr, Map param, String text) {
		// TODO - % 단어를 특수문자로 사용하고 있음. 이걸 공통으로 쓸수 있게끔.. 처리해야한다.
		RE re = new RE(regExpStr);
		while (re.match(text)) {
			String key = re.getParen(0);
			key = key.substring(1, key.length() - 1);
			text = re.subst(text, String.valueOf(param.get(key)), RE.REPLACE_FIRSTONLY);
		}

		return text;
	}

	/**
	 * 주어진 문자를 한글자씩 끊어 연산한다.
	 *
	 * @param regEx 한문자씩 구분할 수 있는 배열값
	 * @param text
	 * @return
	 *
	 * @author ycpark
	 * @date 2007. 07. 09
	 */
	public static String replaceAll(String regEx, String text) {
		String txt = StringUtil.defaultToString(text, "");
		if (txt.equals("")) {
			return text;
		}

		String[] regs = StringUtil.splitChar(regEx);
		for (int i = 0; i < regs.length; i++) {
			String exp = "\\" + regs[i];
			txt = txt.replaceAll(exp, txt);
		}
		return txt;
	}

	public static String replaceAll(String regEx, Object text) {
		return StringUtil.replaceAll(regEx, StringUtil.defaultToString(text, ""));
	}

	/**
	 * 입력된 문자를 한자씩 끊어 배열로 저장한다.
	 *
	 * @param reg
	 * @return
	 *
	 * @author ycpark
	 * @date 2007. 07. 09
	 */
	@SuppressWarnings("rawtypes")
	public static String[] splitChar(String reg) {
		List list = new ArrayList();

		for (int i = 0; i < reg.length(); i++) {
			String ch = String.valueOf(reg.charAt(i));
			if (!list.contains(ch))
				list.add(String.valueOf(reg.charAt(i)));
		}

		return (String[]) list.toArray(new String[0]);
	}

	/**
	 * 입력된 문자중에 숫자만을 문자로 반환한다.
	 *
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String getOnlyNumericCharacters(Object obj, String defaultValue) {

		if (obj == null)
			return defaultValue;

		String param = defaultToString(obj, defaultValue).trim();
		return param.replaceAll("[a-z]*[A-Z]*\\W*", "");
	}

	/**
	 * charterset 을 변환한다.
	 *
	 * @param str
	 * @param from
	 * @param to
	 * @return
	 * @create 2009. 01. 08
	 */
    public static String changeCharterset(String str, String from, String to)
    {
        String new_str = null;
        try
        {
            if(str != null)
                new_str = new String(str.getBytes(from), to);
            else
                new_str = "";
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) { }
        return new_str;
    }

	static final RE reg_NL = new RE("(\015\012)|(\015)|(\012)");
    static RE reg_HTML_1 = new RE("&");
    static RE reg_HTML_2 = new RE("\"");
    static RE reg_HTML_3 = new RE("'");
    static RE reg_HTML_4 = new RE("<");
    static RE reg_HTML_5 = new RE(">");

    /**
     * 주어진 문자를 HTML 에서 사용할 수 있도록 변환
     *
     * @param txt 원본 문서
     * @param def 기본값
     * @return
     * @create 2009. 01. 08
     */
    public static String HtmlSpecialChars(String txt, String def ){
        if (txt != null) {
	        txt = reg_HTML_1.subst(txt,"&amp;");
	        txt = reg_HTML_2.subst(txt,"&quot;");
	        txt = reg_HTML_3.subst(txt,"&#039;");
	        txt = reg_HTML_4.subst(txt,"&lt;");
	        txt = reg_HTML_5.subst(txt,"&gt;");
	        return txt;
        } else {
            return def;
        }
    }

    /**
     * 주어진 문자를 HTML 에서 사용할 수 있도록 변환
     *
     * @param txt 원본 문서
     * @return
     * @create 2009. 01. 08
     */
    public static String HtmlSpecialChars(String txt ){
        return HtmlSpecialChars(txt, null);
    }

	/**
	  * ',' 를 3자리 마다 삽입한다. 숫자일 경우
	  * 123456 -> 123,456
	  * 작성 날짜: (00-10-19 오전 2:02:15)
	  * @return java.lang.String
	  * @param str java.lang.String
	  */
    private java.text.DecimalFormat commaDF = new java.text.DecimalFormat("###,##0");

	public String putComma(String w) {
		double d = 0;
		try {
			d = Double.valueOf(w).doubleValue();
		}
		catch (Exception e) {
			d = 0;
		}
		return putComma(d);
	}
	public String putComma(double w) {
		return commaDF.format(Double.parseDouble(this.Rounddn(w, 0)));
	}

	/**
	* 지정자리에서 버림을 한다
	* 작성 날짜: (00-02-02 오후 9:52:11)
	* @return java.lang.String
	*/
	public String Rounddn(double dbValue, int index) {
		String strDouble = Double.toString(dbValue);

		if (strDouble.substring(strDouble.indexOf('.') + 1).length() <= index)
			return strDouble;

		try {
			BigDecimal rounder = new BigDecimal(dbValue).setScale(index, java.math.BigDecimal.ROUND_DOWN);
			return toDecimal(rounder.doubleValue(), index);
		}
		catch (Exception e) {
			return String.valueOf(dbValue);
		}
	}

	/**
	 * 지수를 정수로 변환..
	 * 계산결과 소수점 이하 버림
	 * 작성 날짜: (2000-05-02 오후 6:36:32)
	 * @return java.lang.String
	 * @param strTemp java.lang.String
	 * @exception java.io.IOException 예외 설명.
	 */
	public String toDecimal(double dbValue, int nCount) {
		try {
			StringBuffer sbTemp = new StringBuffer();
			if (nCount > 0) {
				sbTemp.append(".");
				for (int i = 0; i < nCount; i++) {
					sbTemp.append("#");
				}
			}
			else {
				sbTemp.append("0");
			}
			java.text.DecimalFormat dF = new java.text.DecimalFormat(sbTemp.toString());
			return dF.format(dbValue);
		}
		catch (Exception e) {
			return String.valueOf(dbValue);
		}
	}

	/**
	 * null 값을 Blank 으로 변환한다.  2014-01-03 적용
	*/
	public static String nullToBlank(String tmpStr)
	{
		String innerTmpStr = tmpStr;
		if(innerTmpStr == null)
		{
			innerTmpStr = "";
		}
		else if(innerTmpStr.equalsIgnoreCase("null"))
		{
			innerTmpStr = "";
		}

		return innerTmpStr;
	}

	/**
	 * null 값을 변경String 으로 변환한다.  2014-01-03 적용
	*/
	public static String  nullToStr(String tmpStr, String changeStr)
	{
		String innerTmpStr = tmpStr;
		if(innerTmpStr == null)
		{
			innerTmpStr = changeStr;
		}
		else if(innerTmpStr.equalsIgnoreCase("null"))
		{
			innerTmpStr = changeStr;
		}
		else if(innerTmpStr.equalsIgnoreCase(""))
		{
			innerTmpStr = changeStr;
		}

		return innerTmpStr;
	}

	/**
	 * NULL => "" 작성 날짜: (2002-10-02 오전 1:37:26)
	 *
	 * @return java.lang.String
	 */
	public static String getNullTrans(String sData) {
		return getNullTrans(sData, "");
	}

	/**
	 * NULL => "" 작성 날짜: (2002-10-02 오전 1:37:26)
	 *
	 * @return java.lang.String
	 */
	public static String getNullTrans(String sData, String sTrans) {
		String tmp_sTrans = null;
		String tmp_sData = null;
		tmp_sTrans = sTrans;
		tmp_sData = sData;

		if (tmp_sTrans == null)
			tmp_sTrans = "";
		if (tmp_sData == null || tmp_sData.equals("") || tmp_sData.equals("null"))
			tmp_sData = tmp_sTrans;
		return tmp_sData;
	}

	public static String convertRate(String str){
		String result = "0";
		String tmp = str;
		int len=0;
		try{
			if(tmp != null && !tmp.equals("") && !tmp.equals("0"))
				len = tmp.length();
			if(len > 0)
			{
				//if(!str.substring((len-1),len).equals("0"))
					tmp = convertInt(str.substring(0,(len-1))) + "." + str.substring((len-1),len);
				//else
				//	tmp = Integer.toString( convertInt(str.substring(0,(len-1))) );
				//System.out.println("tmp==>"+tmp);
			}
			result = tmp;
		}catch(Exception e){
			result = "0";
		}
		return result;
	}

	public static int convertInt(String str){
		int tmp=0;
		if(str != null && !str.equals("")){
			tmp = Integer.parseInt(str.trim());
		}
		return tmp;
	}

	// LMS 발송등에서 인용부호 필요.
	public static String ReXSS(String value) {

		if (("".equals(value)) || (value == null)) {
	        return value;
	    }
		value = value.replaceAll("&#38;"	,"&");
		value = value.replaceAll("&lt"		,"<");
		value = value.replaceAll("&gt"		,">");
		value = value.replaceAll("&#35;"	,"#");
		value = value.replaceAll("&#39;"	,"\'");
		value = value.replaceAll("&#34;"	,"\"");

		return value;
	}

	public String secToTime(double value) {
		int timeS = (int) value%60;
		int timeM = (int) value/60;
		int timeH = (int) value/60/60;

		String timeFormatStr = "";

		if(timeH<10) {
			timeFormatStr += "0"+timeH+":";
		}else {
			timeFormatStr += timeH+":";
		}

		if(timeM<10) {
			timeFormatStr += "0"+timeM+":";
		}else {
			timeFormatStr += timeM+":";
		}

		if(timeS<10) {
			timeFormatStr += "0"+timeS;
		}else {
			timeFormatStr += timeS;
		}

		return timeFormatStr;
	}
}

