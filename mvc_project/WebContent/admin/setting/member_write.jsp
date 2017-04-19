<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/adm/layout/header.jsp"></c:import>
<section class="content" id="content">
	<div class="title_text">
		<h2 class="title01">Member. Write</h2>
		<p>
			<c:choose>
			<c:when test="${update }">회원 정보 수정</c:when>
			<c:otherwise>회원정보 입력</c:otherwise>
		</c:choose>			
		</p>
	</div>
	
	<form action="writeOk.do" method="post">
		<c:choose>
			<c:when test="${update }">
			<input type="hidden" name="command" value="update" />
			<input type="hidden" name="mb_idx" value="${member.mb_idx }"/>
			</c:when>
			<c:otherwise>
			<input type="hidden" name="command" value="write" />
			</c:otherwise>
		</c:choose>	
		<div class="board_write_area">
			<!-- board_write -->
			<div class="board_write">
				<h3 class="board_title">기본</h3>
				<table>
					<colgroup>
						<col class="col_subject" />
						<col class="col_content" />
						<col class="col_subject" />
						<col class="col_content" />
					</colgroup>
					<tr>
						<th scope="row"><label for="mb_id" class="chk_must">아이디</label></th>
						<td>
							<input type="text" readonly="readonly" value="${member.mb_id }" name="mb_id" placeholder="아이디" id="me_id" />
						</td>
						<th scope="row"><label for="mb_pass" class="chk_must">패스워드</label></th>
						<td>
							<input type="password" value="" name="mb_pass" />
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="mb_name" class="chk_must">이름</label></th>
						<td>
							<input type="text" readonly="readonly" value="${member.mb_name }" name="mb_name" placeholder="이름" id="me_name" />
						</td>
						<th scope="row"><label for="mb_level" class="chk_must">권한</label></th>
						<td>
							<select name="mb_level" id="mb_level" class="input-select" size="7">
								<c:forEach begin="0" end="10" var="level">
								<option value="${level }" <c:if test="${member.mb_level == level }">selected</c:if> >${level }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="mb_email" class="chk_must">이메일</label></th>
						<td>
							<input type="text" value="${member.mb_email }" name="mb_email" placeholder="이메일" id="me_email" size="400" />
							
						</td>
						<th scope="row"><label for="">인증확인/수신</label></th>
						<td>
							인증확인 <span class="chk_area"><label><input type="checkbox" value="" name="me_email_confirm" /></label></span> 
							/ 이메일수신  <span class="chk_area"><label><input type="checkbox" value="" name="me_email_chk" /></label></span>
							/ SMS수신  <span class="chk_area"><label><input type="checkbox" value="" name="me_sms_chk" /></label></span>
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="mb_hp" class="chk_must">휴대폰</label></th>
						<td><input type="text" name="mb_hp" value="${member.mb_hp }" /></td>
						
						<th scope="row"><label for="mb_tel">전화번호</label></th>
						<td><input type="text" name="mb_tel" value="${member.mb_tel }" /></td>
					</tr>
					<tr>
						<th scope="row"><label for="me_addr1">주소</label></th>
						<td colspan="3">
							<p>
								<input type="text" size="6" name="mb_zip" value="${member.mb_zip }" />
								<a href="#" class="btn02">우편번호찾기</a>
							</p>
							<p>
								<input type="text" size="400" value="${member.mb_addr1 }" name="mb_addr1"  title="기본주소" placeholder="기본주소" />
							</p>
							<p>
								<input type="text" size="400" value="${member.mb_addr2 }" name="mb_addr2"  title="상세주소" placeholder="상세주소" />
							</p>
							<p>
								<input type="text" size="400" value="" name="me_addr4"  title="참고항목" placeholder="참고항목" />
							</p>
						</td>
					</tr>
					<tr>
						<th scope="row">가입일자</th>
						<td>${member.mb_regdate }</td>
						<th scope="row">최근접속일</th>
						<td>${member.mb_lastest }</td>
					</tr>
					<tr>
						<th scope="row">탈퇴일</th>
						<td>${member.mb_lastest }</td>
						<th scope="row">회원 강제 설정</th>
						<td>
							<a href="" class="btn01">탈퇴</a>
							<a href="" class="btn01">영구삭제</a>
						</td>
					</tr>
				</table>
				<h3 class="board_title">추가설정</h3>
				<table>
					<colgroup>
						<col class="col_subject" />
						<col class="col_content" />
					</colgroup>
					<tr>
						<th scope="row"><label for="">추가1</label></th>
						<td>
							<input type="text" size="400" value="" name="" id="" /> 
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="">추가1</label></th>
						<td>
							<input type="text" size="400" value="" name="" id="" /> 
						</td>
					</tr>
					<tr>
						<th scope="row"><label for="">추가1</label></th>
						<td>
							<input type="text" size="400" value="" name="" id="" /> 
						</td>
					</tr>
				</table>
				<p>${message }</p>
			</div>
			<!-- //board_write -->
			<!-- board_write_bottom -->
			<div class="clearfix board_write_bottom">
				<div class="button_area_left">
					<a href="list.do" class="btn01">List</a>
				</div>
				<div class="button_area_right">
					<c:choose>
					<c:when test="${update }">
					<input type="submit" class="btn02" value="Save" />
					</c:when>
					<c:otherwise>
					<input type="submit" class="btn02"  value="Write" />
					</c:otherwise>
					</c:choose>
				</div>
			</div>
			<!-- //board_write_bottom -->
		</div>
	</form>
</section>

<c:import url="/adm/layout/footer.jsp"></c:import>