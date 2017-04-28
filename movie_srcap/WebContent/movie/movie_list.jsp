<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/header.jsp"></c:import>

<!-- content -->
<section class="content">
	<div class="content_area">
		<div class="section movie_area">
			<h2 class="title01">영화 정보</h2>
			<form action="">
				<label class="tit" for="stx">검색할 영화제목을 입력해주세요.</label>
				<input type="text" name="stx" id="stx" value="" size="40" />
				<input type="submit" value="영화검색" class="btn01" />
			</form>
			
			<div class="sort_list">
				<a href="" class="btn02 on">개봉순</a>
				<a href="" class="btn02">영화순</a>
				<a href="" class="btn02">평점순</a>
				<a href="" class="btn02">스크랩순</a>
			</div>
			<div class="movie_list">
			
			<ul class="clear">
				<li>
					<div class="img"><a href="${PATH }/movie/movie_view.jsp"><img src="${IMG_PATH }/poster/poster (1).jpg" alt="" /></a></div>
					<div class="info">
						<dl>
							<dt>센과 치히로의 행방불명 (千と千尋の神隠し)</dt>
							<dd>감독 : 미야자키 하야오</dd>
							<dd>배우 : 히이라기 루미, 이리노 미유</dd>
							<dd class="movie_btn">
								<a href="${PATH }/movie/movie_view.jsp">자세히보기</a>
								<a href="#">스크랩하기</a>
								<a href="#">토론하기</a>
							</dd>
						</dl>
					</div>
				</li>
				<li>
					<div class="img"><a href="${PATH }/movie/movie_view.jsp"><img src="${IMG_PATH }/poster/poster (2).jpg" alt="" /></a></div>
					<div class="info">
						<dl>
							<dt>추억의 마니 (思い出のマーニー)</dt>
							<dd>감독 : 미야자키 하야오</dd>
							<dd>배우 : 히이라기 루미, 이리노 미유</dd>
							<dd class="movie_btn">
								<a href="${PATH }/movie/movie_view.jsp">자세히보기</a>
								<a href="#">스크랩하기</a>
								<a href="#">토론하기</a>
							</dd>
						</dl>
					</div>
				</li>	
				<li>
					<div class="img"><a href="${PATH }/movie/movie_view.jsp"><img src="${IMG_PATH }/poster/poster (4).jpg" alt="" /></a></div>
					<div class="info">
						<dl>
							<dt>이웃집 토토로 (となりの トトロ)</dt>
							<dd>감독 : 미야자키 하야오</dd>
							<dd>배우 : 히이라기 루미, 이리노 미유</dd>
							<dd class="movie_btn">
								<a href="${PATH }/movie/movie_view.jsp">자세히보기</a>
								<a href="#">스크랩하기</a>
								<a href="#">토론하기</a>
							</dd>
						</dl>
					</div>
				</li>							
			</ul>
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