<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<style>
.xi-angle-left, .xi-angle-right {
	font-weight: 500;
	color: white;
}

.arrow {
	width: 52px;
	height: 52px;
	font-size: 20px;
	background-color: #1c355d;
}
</style>
<body>
<!-- wrap : start -->
	<!-- inner_contents : start -->
	<div class="inner_contents have_subtab">		
		<!-- row : start -->
		<div class="row">
			<!-- col : start -->
			<div class="col_pd col_4_5">
				<!-- title : start -->
				<div class="search_A2">
					<div class="sc_input">
						<dl>
							<dt>스킬유형</dt>
							<dd>
								<select id="schSkillType1" class="schSkillType">
									<option value="">--스킬유형--</option>
									<c:forEach items="${skillTypeList}" var="skillTypeList" varStatus="_status">
										<option value="${skillTypeList.skillType}">${skillTypeList.skillType}</option>
									</c:forEach>
								</select>
							</dd>
							<dt>스킬</dt>
							<dd>
								<select id="schSkill1" class="schSkill">
									<option value="">--스킬선택--</option>
								</select>
							</dd>
						</dl>
					</div>
					<div class="button mr_10">
						<button type="button" id="search1" class="btn btn_third btn_size_s schButton">
							<i class="xi-search"></i>조회
						</button>
					</div>
				</div>
				<!-- search : end -->
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid disable_paging mt_10" id="divGrid1">
					<table id="skillGrid1" aria-describedby="table_summary">
					</table>
				</div>
				<!-- table : end -->				
			</div>
			<!-- col : end -->
	
			
			<div class="col_pd col" style="align-items:center;justify-content:center">
				<button id="allLeft" class="arrow" onclick="allLeft()" disabled>
					<i class="xi-angle-left" style="margin-right:1px"></i><i class="xi-angle-left" style="margin-left:-11px"></i>
				</button>
				<button id="goLeft" class="arrow" style="margin-top:20px" onclick="goLeft()" disabled>
					<i class="xi-angle-left"></i></button>
				<button id="goRight" class="arrow" style="margin-top:20px" onclick="goRight()" disabled>
					<i class="xi-angle-right" style="margin-right:-2px;"></i></button>
				<button id="allRight" class="arrow" style="margin-top:20px" onclick="allRight()" disabled>
					<i class="xi-angle-right" style="margin-left:1px"></i><i class="xi-angle-right" style="margin-left:-10px"></i></button>
			</div>
	
			<!-- col : start -->
			<div class="col_pd col_4_5">
				<!-- title : start -->
				<div class="search_A2">
					<div class="sc_input">
						<dl>
							<dt>스킬유형</dt>
							<dd>
								<select id="schSkillType2" class="schSkillType">
									<option value="">--스킬유형--</option>
									<c:forEach items="${skillTypeList}" var="skillTypeList" varStatus="_status">
										<option value="${skillTypeList.skillType}">${skillTypeList.skillType}</option>
									</c:forEach>
								</select>
							</dd>
							<dt>스킬</dt>
							<dd>
								<select id="schSkill2" class="schSkill" name="schSkill2">
									<option value="">--스킬선택--</option>
								</select>
							</dd>
						</dl>
					</div>
					<div class="button mr_10">
						<button type="button" id="search2" class="btn btn_third btn_size_s schButton">
							<i class="xi-search"></i>조회
						</button>
					</div>
				</div>
				<!-- title : end -->
				<!-- table : start -->
				<div class="board_A0_L a_c type_grid disable_paging mt_10" id="divGrid2">
					<table id="skillGrid2" aria-describedby="table_summary">
					</table>
				</div>
				<!-- table : end -->		
			</div>
			<!-- col : end -->
		</div>
		<div class="button mt_10 a_r">
		<button type="button" class="btn btn_secondary btn_size_n" id="save">
			<i class="xi-check"></i>저장
		</button>
	</div>
	</div>
	<script type="text/javascript" src="<c:url value='/dwr/interface/USSU01_Service.js?timestamp=${nowDate}'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/us/su/USSU01.js?timestamp=${nowDate}'/>"></script>
</body>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
