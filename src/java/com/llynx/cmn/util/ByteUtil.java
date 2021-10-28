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

/**
 * @Class Name : ByteUtil.java
 * @Description : ByteUtil Class
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
public class ByteUtil {
	 
	/** 
	 * <pre>
	 * byte배열을 길이만큼 잘라서 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	formIdx		시작 인덱스
	 * @param	toIdx		끝 인덱스
	 * @return 	null이면 ""
	 */ 
	public static byte[] subBytes(byte[] src, int formIdx, int toIdx) throws Exception{

		if(src == null || src.length <= 0 || toIdx < formIdx){
			return new byte[0];
		}
		
		if(toIdx <= 0){
			toIdx = src.length;
		}
		
		byte returnVal[] = new byte[toIdx - formIdx];
		
//		try{

			for(int i = 0 ; i < toIdx-formIdx ; i++){
				returnVal[i] = src[formIdx+i];
			}
//		
//		}catch(Exception e){
//			throw e;
//		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 숫자로 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static int byte2int(byte[] src) throws Exception{
		
		int returnVal = 0;
		
//		try{
			returnVal = Integer.parseInt(new String(src).trim());
//		}catch(NumberFormatException e){
//			returnVal = 0;
//		}
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 long으로 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static long byte2long(byte[] src) throws Exception{
		
		long returnVal = 0;
		
//		try{
			returnVal = Long.parseLong(new String(src).trim());
//		}catch(NumberFormatException e){
//			returnVal = 0;
//		}
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * 숫자로 받아 byte배열을 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static byte[] int2byte(int src) throws Exception{
		
		byte[] returnVal = null;
		
//		try{
			returnVal = (""+src).getBytes();
//		}catch(Exception e){
//			throw e;
//		}
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 숫자로 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static byte[] int2byte(int src, int length) throws Exception{
		
		byte[] returnVal = null;
		
//		try{
			returnVal = (""+src).getBytes();
			returnVal = padLeft(returnVal, "0", length);
//		}catch(NumberFormatException e){
//			throw e;
//		}
		return returnVal;
	}
	/** 
	 * <pre>
	 * byte배열받아 숫자로 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static byte[] long2byte(long src, int length) throws Exception{
		
		byte[] returnVal = null;
		
//		try{
			returnVal = (""+src).getBytes();
			returnVal = padLeft(returnVal, "0", length);
//		}catch(NumberFormatException e){
//			throw e;
//		}
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 숫자로 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static byte[] double2byte(double src, int length) throws Exception{
		
		byte[] returnVal = null;
		
//		try{
			returnVal = (""+src).getBytes();
			returnVal = padLeft(returnVal, "0", length);
//		}catch(NumberFormatException e){
//			throw e;
//		}
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 숫자로 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static String byte2Str(byte[] src) throws Exception{
		
		String returnVal = "";
		
		returnVal = new String(src).trim();
			
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 숫자로 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static byte[] str2byte(String src, int length) throws Exception{
		
		return padRight(src.getBytes(), " ", length);
	}
	
	/** 
	 * <pre>
	 * byte배열받아 NULL로 채워져 있으면 공란을 넣는다.
	 * </pre>
	 * @param	src			byte[]
	 * @return 	Exception 발생시 0
	 */ 
	public static byte[] checkNull(byte[] src) throws Exception{
		
		if(src == null || src.length == 0){
			return "".getBytes();
		}
				
		byte[] returnVal = new byte[src.length];

		byte whiteSpace = " ".getBytes()[0];
		
		for(int i = 0 ; i < src.length ; i++){
			returnVal[i] = (src[i] == 0X00) ? whiteSpace  : src[i];
		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 길이가 totLen이 될때까지 공란을 채워 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	totLen		리턴될 값
	 * @return 	byte[]
	 */ 
	public static byte[] padLeft(byte[] src, String ch, int totLen) throws Exception{
		
		if(src == null){
			throw new NullPointerException();
		}
		if(totLen < src.length){
			throw new ArrayIndexOutOfBoundsException();
		}else if(totLen == src.length){
			return src;
		}
		
		if(ch == null || ch.getBytes().length > 1){
			ch = " ";
		}
		
		byte[] returnVal = new byte[totLen];
		
		int i = 0;
		
//		try{

			for(; i < totLen - src.length; i++){
				returnVal[i] = ch.getBytes()[0];
			}
			
			for(int j = 0 ; j < src.length; j++){
				returnVal[j+i] = src[j];
			}
			
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * 길이가 totLen인 byte[]에 ch값을 채워 리턴한다.
	 * </pre>
	 * @param	ch			String
	 * @param	totLen		리턴될 값
	 * @return 	byte[]
	 */ 
	public static byte[] padAll(String ch, int totLen) throws Exception{

		if(ch == null || ch.getBytes().length != 1){
			ch = " ";
		}
		
		int len = new Integer(totLen).intValue();
		if (len<0) {
			return new byte[0];
		}
		
		byte[] returnVal = new byte[totLen];
		
//		try{

			for(int i = 0 ; i < totLen; i++){
				returnVal[i] = ch.getBytes()[0];
			}
			
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 길이가 totLen이 될때까지 공란을 채워 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	totLen		리턴될 값
	 * @return 	byte[]
	 */ 
	public static byte[] padRight(byte[] src, String ch, int totLen) throws Exception{
		
		if(src == null){
			src = new byte[0];
		}
		
		if(totLen == src.length){
			return src;
		}
		
		if(totLen < src.length){
			return subBytes(src, 0, totLen);
		}
		
		if(ch == null || ch.getBytes().length > 1){
			ch = " ";
		}
		
		byte[] returnVal = new byte[totLen];
		
		int i = 0;
		
//		try{

			for(i = 0 ; i < src.length; i++){
				returnVal[i] = src[i];
			}
			
			for(; i < totLen; i++){
				returnVal[i] = ch.getBytes()[0];
			}
			
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 sub byte배열을 끼워넣는다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	sub			byte[]
	 * @param	idx			src에서 sub를 넣어야할 위치의 인덱스
	 * @return 	byte[]
	 */ 
	public static byte[] replace(byte[] src, byte[] sub, int idx) throws Exception{
		
		if(src == null || sub == null || src.length == 0 || sub.length == 0){
			return src;
		}
		if(idx > src.length || sub.length+idx > src.length){
			return src;
		}
		
		byte[] returnVal = new byte[src.length];
		
		int i = 0;
		
//		try{
			
			for(; i < idx; i++){
				returnVal[i] = src[i];
			}
			for(int j = 0; j < sub.length; i++, j++){
				returnVal[i] = sub[j];
			}
			for(; i < src.length; i++){
				returnVal[i] = src[i];
			}
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 sub byte배열을 붙여서 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	sub			byte[]
	 * @param	idx			src에서 sub를 넣어야할 위치의 인덱스
	 * @return 	byte[]
	 */ 
	public static byte[] add(byte[] src, byte[] sub) throws Exception{
		
		byte[] returnVal = new byte[src.length+sub.length];

		int i = 0;
		int j = 0;
		
//		try{
			
			for(; i < src.length; i++){
				returnVal[i] = src[i];
			}
			for(j = 0; j < sub.length; i++, j++){
				returnVal[i] = sub[j];
			}
			
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		return returnVal;
	}
	/** 
	 * <pre>
	 * byte배열받아 sub byte배열을 붙여서 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	sub			byte[]
	 * @param	sub2		byte[]
	 * @param	idx			src에서 sub를 넣어야할 위치의 인덱스
	 * @return 	byte[]
	 */ 
	public static byte[] add(byte[] src, byte[] sub, byte[] sub2) throws Exception{
		
		byte[] returnVal = new byte[src.length+sub.length+sub2.length];
		
		int i = 0;
		int j = 0;
		
//		try{
			for(; i < src.length; i++){
				returnVal[i] = src[i];
			}
			for(j = 0; j < sub.length; i++, j++){
				returnVal[i] = sub[j];
			}
			for(j = 0 ; j < sub2.length; i++, j++){
				returnVal[i] = sub2[j];
			}
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 sub byte배열을 붙여서 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	sub			byte[]
	 * @param	sub2		byte[]
	 * @param	idx			src에서 sub를 넣어야할 위치의 인덱스
	 * @return 	byte[]
	 */ 
	public static byte[] add(byte[] src, byte[] sub, byte[] sub2, byte[] sub3) throws Exception{
		
		byte[] returnVal = new byte[src.length+sub.length+sub2.length+sub3.length];
		
		int i = 0;
		int j = 0;
		
//		try{
			for(; i < src.length; i++){
				returnVal[i] = src[i];
			}
			for(j = 0; j < sub.length; i++, j++){
				returnVal[i] = sub[j];
			}
			for(j = 0 ; j < sub2.length; i++, j++){
				returnVal[i] = sub2[j];
			}
			for(j = 0 ; j < sub3.length; i++, j++){
				returnVal[i] = sub3[j];
			}
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * byte배열받아 sub byte배열을 붙여서 리턴한다.
	 * </pre>
	 * @param	src			byte[]
	 * @param	sub			byte[]
	 * @param	sub2		byte[]
	 * @param	idx			src에서 sub를 넣어야할 위치의 인덱스
	 * @return 	byte[]
	 */ 
	public static byte[] add(byte[] src, byte[] sub, byte[] sub2, byte[] sub3, byte[] sub4) throws Exception{
		
		byte[] returnVal = new byte[src.length+sub.length+sub2.length+sub3.length+sub4.length];
		
		int i = 0;
		int j = 0;
		
//		try{
			for(; i < src.length; i++){
				returnVal[i] = src[i];
			}
			for(j = 0; j < sub.length; i++, j++){
				returnVal[i] = sub[j];
			}
			for(j = 0 ; j < sub2.length; i++, j++){
				returnVal[i] = sub2[j];
			}
			for(j = 0 ; j < sub3.length; i++, j++){
				returnVal[i] = sub3[j];
			}
			for(j = 0 ; j < sub4.length; i++, j++){
				returnVal[i] = sub4[j];
			}
//		}catch(ArrayIndexOutOfBoundsException e){
//			throw e;
//		}
		
		return returnVal;
	}
	
	/** 
	 * <pre>
	 * 비교값을 받아 boolean값으로 리턴한다.
	 * </pre>
	 * @param	int arg0	파라미터덜을 비교할 방법을 정의한 코드
	 * @param	byte[] arg1
	 * @param	byte[] arg2
	 * @param	byte[] arg3
	 * @return 	boolean
	 */ 
	public static boolean compareForLong(int arg0, byte[] arg1, byte[] arg2) throws Exception{
		return compareForLong(arg0, arg1, arg2, null);
	}
	public static boolean compareForLong(int arg0, byte[] arg1, byte[] arg2, byte[] arg3) throws Exception{
		
		boolean returnVal = false;

//		try{
			switch(arg0){
			case 0 : 
				returnVal = (byte2long(arg1) == byte2long(arg2)) ? true : false; 
				break;
			case 1 : 
				returnVal = (byte2long(arg1) > byte2long(arg2)) ? true : false; 
				break;
			case 2 : 
				returnVal = (byte2long(arg1) < byte2long(arg2)) ? true : false; 
				break;
			case 3 : 
				returnVal = (byte2long(arg1) <= byte2long(arg2)) ? true : false; 
				break;
			case 4 : 
				returnVal = (byte2long(arg1) >= byte2long(arg2)) ? true : false; 
				break;
			case 5 : 
				returnVal = (byte2long(arg1) <= byte2long(arg2) && byte2long(arg2) <= byte2long(arg3)) ? true : false; 
				break;			
			}
//		}catch(Exception e){
//			throw e;
//		}
		return returnVal;
	}
}
