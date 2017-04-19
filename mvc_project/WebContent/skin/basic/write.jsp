<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../../layout/header.jsp"></c:import>
<!-- content -->
<section class="content">
	<div class="content_area about_area clearfix">
		<div class="section">
			<c:choose>
			<c:when test="${update }">
			<h2 class="title01">${optionVo.op_name } 수정</h2>
			</c:when>
			<c:when test="${reply }">
			<h2 class="title01">${optionVo.op_name } 답변</h2>
			</c:when>
			<c:otherwise>
			<h2 class="title01">${optionVo.op_name } 작성</h2>
			</c:otherwise>
			</c:choose>
			<form method="post" name="frm" action="writeOk.do">
				<input type="hidden" name="bo_table" value="${optionVo.op_table }" />
				<c:choose>
				<c:when test="${update }">
				<input type="hidden" name="command" value="update" />
				<input type="hidden" name="bo_idx" value="${bVo.bo_idx }" />
				</c:when>
				<c:when test="${reply }">
				<input type="hidden" name="command" value="reply" />
				<input type="hidden" name="bo_ref" value="${parent_bVo.bo_ref }" />
				<input type="hidden" name="bo_level" value="${parent_bVo.bo_level+1 }"/>
				</c:when>
				<c:otherwise>
				<input type="hidden" name="command" value="write" />
				</c:otherwise>
				</c:choose>
				<div class="board_write_area">
					<!-- 제목 -->
					<div class="clearfix board_write_top">
						<c:choose>
						<c:when test="${reply}">
						<input type="text" name="bo_subject" value="RE : ${parent_bVo.bo_subject }" placeholder="Post Title">
						</c:when>
						<c:otherwise>
						<input type="text" name="bo_subject" value="${bVo.bo_subject }" placeholder="Post Title" />
						</c:otherwise>
						</c:choose>
					</div>
					<!-- //제목 -->
					<!-- 기타설정 -->
					<div class="board_write_chk">
						<ul class="clear list01">
							<c:if test="${optionVo.op_is_secret == 1 }">
							<li><span class="tit">비밀글</span>
								<span class="con">
								<span class="chk_area"><label for="bo_is_secret">비밀글<input type="checkbox" id="bo_is_secret" name="bo_is_secret" value="1" <c:if test="${bVo.bo_is_secret == 1 }">checked</c:if> /></label></span>
								</span>
							</li>
							</c:if>
							<li><span class="tit">작성자</span>
								<span class="con">
								<c:choose>
								<c:when test="${ ss_mb_id != '' }">${mVo.mb_name }</c:when>
								<c:otherwise><input type="text" name="bo_writer" size="500" /></c:otherwise>
								</c:choose>
							</span></li>
							<c:if test="${ ss_mb_id == '' }">
							<li><span class="tit">비밀번호</span>
								<span class="con">
								<input type="password" name="bo_pass"  placeholder="비밀번호" size="500" />
								</span>
							</li>
							</c:if>
						</ul>
					</div>
					<!-- //기타설정 -->
					<!-- board_write -->
					<div class="board_write">
						<textarea name="bo_content" id="bo_content" width="100%" height="300px">${bVo.bo_content }</textarea>
					</div>
					<!-- //board_write -->
					<!-- board_file -->
					<div class="board_file">
						<input type="hidden" name="file_count" value="2" id="file_count" />
						<div class="btn_file"><a href="javascript:addFile(4);" class="btn01">Add File</a></div>
						<ul class="clear" id="file_list">
							<li><span class="num">1.</span><input type="file" name="bo_file" value="File Search"  onChange="fn_previewImg(this, 'preImg1')" /><span class="prevImg"><img id="preImg1" /></span></li>
							<li><span class="num">2.</span><input type="file" name="bo_file" value="File Search" onChange="fn_previewImg(this, 'preImg2')" /><span class="prevImg"><img id="preImg2" /></span></li>
						</ul>
					</div>
					<!-- //board_file -->
					<div class="board_write_chk">
						<ul class="clear list01">
							<li><span class="tit">태그입력</span>
								<span class="con"><input type="text" class="" placeholder="태그입력" size="500"></span>
							</li>
						</ul>
					</div>
				</div>
				<!-- 버튼 -->
				<div class="clearfix board_write_bottom">
					<div class="button_area_left">
						<a href="list.do?bo_table=${optionVo.op_table }" class="btn01">목록</a>
					</div>
					<div class="button_area_right">
						<c:choose>
						<c:when test="${update }">			
						<input type="submit" class="btn02" value="수정" />
						</c:when>
						<c:when test="${reply }">
						<input type="submit" class="btn02" value="답변" />
						</c:when>					
						<c:otherwise>
						<input type="submit" class="btn02" value="등록" />
						</c:otherwise>
						</c:choose>
					</div>
				</div>
				<!-- //버튼 -->
			</form>
		</div>
	</div>
</section>
<c:import url="../../layout/footer.jsp"></c:import>
