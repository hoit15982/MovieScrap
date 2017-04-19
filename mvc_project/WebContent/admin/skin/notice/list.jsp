<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/adm/layout/header.jsp"></c:import>

<h2>${optionVo.op_name } 목록</h2>

<table border="1">
	<thead>
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList }" var="bVo">
		<tr>
			<td>${bVo.bo_idx }</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		</c:forEach>
		<c:if test="${totalCount == 0 }">
		<tr>
			<td colspan="5">게시물이 없습니다.</td>
		</tr>
		</c:if>
	</thead>
</table>

<c:import url="/adm/layout/footer.jsp"></c:import>
