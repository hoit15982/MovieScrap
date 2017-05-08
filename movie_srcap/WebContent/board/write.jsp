<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/header.jsp"></c:import>

<!-- content -->
<section class="content">
	<div class="content_area">
		<div class="section">
			<h2 class="title01">토론방 작성</h2>
			<form method="post" name="frm" action="" enctype="multipart/form-data" onSubmit="return frmSubmit(this);">
				<div class="board_write_area">
					<!-- 제목 -->
					<div class="clearfix board_write_top">
						<input type="text" name="bo_subject" value="" placeholder="Post Title" />
					</div>
					<!-- //제목 -->
					<!-- 기타설정 -->
					<div class="board_write_chk">
						<ul class="clear list01">
							<li><span class="tit">작성자</span><span class="con"><input type="text" name="bo_writer" size="500" value="" /></span></li>
							<li><span class="tit">비밀번호</span>
								<span class="con">
								<input type="password" name="bo_pass" placeholder="비밀번호" size="500" />
								</span>
							</li>
						</ul>
					</div>
					<!-- //기타설정 -->
					<!-- board_write -->
					<div class="board_write">
						<textarea name="bo_content" id="bo_content" width="100%" height="300px">내용</textarea>
					</div>
					<!-- //board_write -->
					<!-- board_file -->
					<div class="board_file">
						<div class="btn_file"><a href="" class="btn01">첨부파일</a></div>
						<ul class="clear" id="file_list">
							<li>
							<input type="file" name="bo_file1" value="" />
							</li>
						</ul>
					</div>
					<!-- //board_file -->
				</div>
				<!-- 버튼 -->
				<div class="clearfix board_write_bottom">
					<div class="button_area_left">
						<a href="list.jsp" class="btn02">목록</a>
					</div>
					<div class="button_area_right">
						<input type="submit" class="btn01" value="등록" />
					</div>
				</div>
				<!-- //버튼 -->
			</form>
		</div>
	</div>
</section>
<!-- //content -->

<c:import url="../layout/footer.jsp"></c:import>