<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/header.jsp"></c:import>

<script>
	function search(data){
		$.ajax({
			type : "post",
			url : "./test.jsp",
			dataType : "json",
			async : false,
			data : {
				"stx" : data
			},
			success : function(data){
				$("#content").empty();
				var items = data.items;
				var leng = items.length;
				var count = 5;
				
				var output = "";
				output += "<ul class='clear'>";
				for (var i = 0; i < count; i++) {
					var director = items[i].director.replace(/\|/g,", ");
					director = director.substring(0, director.lastIndexOf(", "));
					var actor = items[i].actor.replace(/\|/g,", ");
					actor = actor.substring(0,actor.lastIndexOf(", "));
					var image = items[i].image;

					/* no image 처리 */
					if(image == "") {
						output += "<li><div class='img'><a href='${PATH }/movie/movie_view.jsp'>" +
							"<img src='../public/images/common/no_img.png' alt='NO IMAGE' /></a></div>";
					} else if(image != null) {
						output += "<li><div class='img'><a href='${PATH }/movie/movie_view.jsp'>"
							+"<img src="+items[i].image+" /></a></div>";
					}
					
					/* subtitle 처리 */
					if(items[i].subtitle != null){
						output += "<div class='info'><dl><dt>"+items[i].title+"</dt>";
					} else {
						output += "<div class='info'><dl><dt>"+items[i].title+" ("+items[i].subtitle+")"+"</dt>";
					}
					
					/* 받아오지 않는것 처리 */
					if(director != "") { output += "<dd>"+"감독 : "+director+"</dd>"; }
					if(actor != "") { output += "<dd>"+"배우 : "+actor+"</dd>"; }
					if(items[i].pubDate != null) { output += "<dd>"+"개봉년도 : "+items[i].pubDate+"</dd>"; }
					if(items[i].userRating != null) { output += "<dd>"+"평점 : "+items[i].userRating+"</dd>"; }
					
					
					output += "<dd class='movie_btn'><a href='${PATH }/movie/movie_view.jsp'>자세히보기</a>";
					output += "<a href='#'>스크랩하기</a><a href='#'>토론하기</a>";
					output += "</dl></div></li>";
				}
				output += "</ul>";
				$("#content").append(output);
				$("#orderby").show();
			} 
		});
	}

	$(document).keypress(function(event) {
		if (event.keyCode == '13') {
			var data = $("#stx").val();
			search(data);
			return false;
		}
	});
	$(function() {
		$("#btnsearch").click(function() {
			var data = $("#stx").val();
			console.log(data);
			search(data);
		});
	});
</script>
<!-- content -->
<section class="content">
	<div class="content_area">
		<div class="section movie_area">
			<h2 class="title01">영화 정보</h2>
			
			<!-- 검색 -->
			<label class="tit" for="stx">검색할 영화제목을 입력해주세요.</label>
			<input type="text" name="stx" id="stx" value="" size="40" />
			<a id="btnsearch" class="btn01">영화검색</a>
			
			
			<!-- 오름차순, 내림차순 -->
				<div class="sort_list" id="orderby" style="display:none">
					<a href="" class="btn02 on">개봉순</a>
					<a href="" class="btn02">영화순</a>
					<a href="" class="btn02">평점순</a>
					<a href="" class="btn02">스크랩순</a>
				</div>

			<!-- 영화본문 jQuery 로 뿌려줄 곳 -->
			<div id="content" class="movie_list">
				
			</div>
			
			
			
			<!-- 페이징 처리 -->
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