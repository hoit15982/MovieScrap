<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/header.jsp"></c:import>

<!-- content -->
<section class="content">
	<div class="content_area">
		<div class="section">
			<h2 class="title01">토론방</h2>
			<div class="board_view_area">
				<form method="post" name="frm">
					<h3 class="board_view_title">제목제목제목1</h3>
					<!-- 게시판정보 -->
					<div class="board_view_top">
						<span class="info">- Date : 2013-11-23 </span>
						<span class="info">- Writer : 김남형</span>
						<span class="info">- Hit : 3</span>
					</div>
					<!-- //게시판정보 -->
					<!-- 첨부파일 -->
					<div class="board_view_file">
						<h3 class="tit">첨부파일</h3>
						<ul class="clear">
							<li><a href="">첨부파일1111</a></li>
						</ul>
					</div>
					<!-- //첨부파일 -->
					<!-- board_write -->
					<div class="board_view">
						<div class="view_content">내용내용</div>
					</div>
					<!-- //board_write -->
					<!-- board_write_bottom -->
					<div class="clearfix board_view_bottom">
						<div class="button_area_left">
							<a href="" class="btn02">수정</a>
							<a href="" class="btn02">답변</a>
						</div>
						<div class="button_area_right">
							<a href="" class="btn01">목록</a>
						</div>
					</div>
					<!-- //board_write_bottom -->
				</form>
			</div>
		</div>
	</div>
</section>
<!-- //content -->

<c:import url="../layout/footer.jsp"></c:import>