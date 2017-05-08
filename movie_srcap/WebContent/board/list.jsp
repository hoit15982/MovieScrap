<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/header.jsp"></c:import>

<!-- content -->
<section class="content">
	<div class="content_area">
		<div class="section">
			<h2 class="title01">토론방</h2>
			<div class="board_list_area">
				<div class="clearfix board_list_top">
					<!-- search_area -->
					<form action="list.do" name="fboardSearch" method="get">
					<input type="hidden" name="bo_table" value="" />
					<div class="search_area">
						<select name="" id="" class="input-select" style="width:100px">
							<option value="">제목</option>
							<option value="">내용</option>
							<option value="">작성자</option>
						</select>
						<input type="text" size="20" name="stx" value="" placeholder="Search" />
						<input type="submit"class="btn01" value="Search" />
					</div>
					</form>
					<!-- //search_area -->
				</div>
				<!-- 정렬 -->
				<div class="sort_list">
					<a href="" class="btn02 on">최신글</a>
					<a href="" class="btn02">조회수</a>
				</div>
				<!-- //정렬 -->
				<form method="post" name="frm">
					<div class="board_list">
						<table>
							<colgroup>
								<col class="col_num" />
								<col class="col_title" />
								<col class="col_author" />
								<col class="col_date" />
								<col class="col_hit" />
							</colgroup>					
							<thead>
								<tr>
									<th class="m_area">No.</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
									<th scope="col">조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach begin="1" end="10" varStatus="theCount">
								<tr>
									<td>${(10-theCount.index)+1}</td>
									<td class="left">
										<a class="link" href="view.jsp">
										<span class="icon_reply">[답변]</span>
										제목제목제목${theCount.count }
										</a>
									</td>
									<td>작성자</td>
									<td>2012-12-11</td>
									<td>1</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- board_list_bottom -->
					<div class="clearfix board_list_bottom">
						<div class="button_area_right">
							<a href="write.jsp" class="btn01" >글쓰기</a>
						</div>
					</div>
					<!-- //board_list_bottom -->
				</form>
			</div>
			<div class="page_area">
				<a href="" class="page_prev">이전</a>
				<em>1</em>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="" class="page_next">다음</a>
			</div>
		</div>
	</div>
</section>
<!-- //content -->

<c:import url="../layout/footer.jsp"></c:import>