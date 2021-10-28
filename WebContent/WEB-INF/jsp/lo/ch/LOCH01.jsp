<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		
	<div class="popup_header">
		<h1>비밀번호 변경</h1>
		<button type="button" class="popup_close"><i class="xi-close"></i><span class="replace_text">팝업닫기</span></button>
	</div>
		
	<div class="popup_content">
		<div class="popup_body">
			<div class="board_A0_L">
				<table aria-describedby="table_summary">
					<caption id="table_summary">비밀번호 변경 테이블</caption>
					<colgroup>
						<col style="width:120px">
						<col style="width:">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">아이디</th>
							<td><p class="info" id="id"></p></td>
						</tr>
						<tr>
							<th scope="row">이전비밀번호</th>
							<td><input type="password" class="input_type01 w_100p" id="oPswd" name="oPswd" /></td>
						</tr>
						<tr>
							<th scope="row">신규비밀번호</th>
							<td><input type="password" class="input_type01 w_100p" id="nPswd" name="nPswd" /></td>
						</tr>
						<tr>
							<th scope="row">비밀번호확인</th>
							<td><input type="password" class="input_type01 w_100p" id="cPswd" name="cPswd" /></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="exp_box mt_10">
				<p class="exp alt">비밀번호는 영문, 숫자, 특수문자를 포함한 9~16자리이내이며 대소문자를 구별합니다.</p>
			 	<p class="exp alt mt_5">사용 가능한 특수문자 : &#126;&#33;&#64;&#35;&#36;&#37;&#94;&#38;&#42;&#40;&#41;&#45;&#61;&#43;&#95;&#96;&#47;&#124;&#92;&#91;&#93;&#63;&#46;&#39;</p>
		 	</div>
		</div>
		<div class="popup_footer">
			<div class="button a_r">
				<button type="button" class="btn btn_primary btn_size_n popup_close">
					<i class="xi-close"></i>취소
				</button>
				<button type="button" class="btn btn_secondary btn_size_n" id="save" name="save">
					<i class="xi-check"></i>변경
				</button>
			</div>
		</div>
	</div>