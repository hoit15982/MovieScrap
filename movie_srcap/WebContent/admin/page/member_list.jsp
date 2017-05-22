<%@page import="java.util.List"%>
<%@page import="net.admin.db.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/header.jsp"></c:import>
<%
	List member = (List)request.getAttribute("memberList");
%>
<div class="content" id="content">
	<div class="content_top">
		<h2>멤버관리</h2>
		<p>회원을 관리할 수 있습니다.</p>
	</div>
	<div class="content_inner">
		<div class="search_area">
			<form action="memberSearch.ad"method="post" name="searchBox" id="searchBox">
				<select name="search" class="input-select">
					<option value="mb_id">아이디</option>
					<option value="mb_name">이름</option>
					<option value="mb_ph">전화번호</option>
					<option value="mb_email">이메일</option>
					<option value="mb_stat">상태</option>
				</select> <input type="text" name="searchKeyword" id="stx"
					placeholder="검색어를 입력하세요" /> <input type="submit" value="검색"
					class="btn01" />
			</form>
		</div>
		<div class="board_list">
			<table>
				<colgroup>
					<col width="50" />
					<col width="120" />
					<col width="80" />
					<col width="90" />
					<col width="120" />
					<col width="120" />
					<col width="200" />
					<col width="200" />
					<col width="150" />
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>생일</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>이메일</th>
						<th>가입일</th>
						<th>상태</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < member.size(); i++) {
							AdminBean ml = (AdminBean) member.get(i);
					%>
					<tr>
						<td><%=ml.getNum()%></td>
						<td><%=ml.getMB_ID() %></td>
						<td><%=ml.getMB_NAME() %></td>
						<td><%=ml.getMB_BIRTH().substring(0, 10) %></td>
						<td><%=ml.getMB_GENDER() %></td>
						<td><%=ml.getMB_PH() %></td>
						<td><%=ml.getMB_EMAIL() %></td>
						<td><%=ml.getMB_REGDATE().substring(0, 10) %></td>
						<td><%=ml.getMB_STAT() %></td>
						<td><a href="#">관리</a></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<c:import url="../layout/footer.jsp"></c:import>