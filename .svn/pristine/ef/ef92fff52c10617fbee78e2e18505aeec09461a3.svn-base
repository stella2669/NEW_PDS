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

import java.util.Map;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * @Class Name : PagingVO.java
 * @Description : PagingVO Class
 * @author MOON KI PYOUNG
 * @since 2020-08-24
 * @version 1.0
 * @see<pre>
 * @Modification Information
 * @
 * @  수정일           수정자               수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2020-08-24  MOON KI PYOUNG         최초생성
 * @ 2020-09-17  felix.kim         주석추가
 *
 *</pre>
 */
@DataTransferObject
public class PagingVO {

	/** 페이지크기 */
	private int pageSize;
	
	/** 페이지번호 */
	private int pageNo;
	
	/** 전체건수 */
	private int totalCount;
	
	/** 전체페이지수 */
	private int totalPage;

	/**
	 * 
	 */
	public PagingVO(int pageNo, int pageSize, int totalCount) {
		// TODO Auto-generated constructor stub
		this.pageNo = pageNo;

		if (totalCount == 0) {
			this.pageNo = 0;
		}
		if (pageNo == 0 && totalCount > 0) {
			this.pageNo = 1;
		}

		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @return the firstRowIndex
	 */
	public int getFirstRowIndex() {
		if (this.pageNo == 0) {
			return 0;
		} else {
			return new Integer((pageNo - 1) * getPageSize() + 1);
		}
	}

	/**
	 * @return the lastRowIndex
	 */
	public int getLastRowIndex() {
		int lastRowIndex = new Integer(pageNo * getPageSize());
		if (lastRowIndex > totalCount)
			lastRowIndex = totalCount;
		return lastRowIndex;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		// int listSize = getListSize();
		this.totalPage = this.totalCount / getPageSize();
		if (this.totalCount % getPageSize() > 0) {
			this.totalPage++;
		}
		return this.totalPage;
	}

	public Map<String, Object> getSrchMap(Map<String, Object> map) {
		map.put("firstRowIndex", this.getFirstRowIndex());
		map.put("lastRowIndex", this.getLastRowIndex());
		map.put("pageNo", this.getPageNo());
		map.put("pageSize", this.getPageSize());
		map.put("totalPage", this.getTotalPage());
		map.put("totalCount", this.getTotalCount());
		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("{ ");
		sb.append("pageNo: " + this.getPageNo());
		sb.append(", ");
		sb.append("pageSize: " + this.getPageSize());
		sb.append(", ");
		sb.append("firstRowIndex: " + this.getFirstRowIndex());
		sb.append(", ");
		sb.append("lastRowIndex: " + this.getLastRowIndex());
		sb.append(", ");
		sb.append("totalPage: " + this.getTotalPage());
		sb.append(" }");
		return sb.toString();
	}

	// public static void main(String[] args) {
	//// PagingVO paging = new PagingVO(24, 30);
	// System.out.println(paging.toString());
	//
	// }
}
