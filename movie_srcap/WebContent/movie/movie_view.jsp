<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/header.jsp"></c:import>

<!-- content -->
<section class="content">
	<div class="content_area">
		<div class="section movie_area">
			<h2 class="title01">이웃집 토토로</h2>
			<p class="text01">となりの トトロ, My Neighbor Totoro, 1988</p>
			<div class="movie_detail_top clearfix">
				<div class="movie_img">
					<img src="${IMG_PATH }/poster/poster (1).jpg" alt="" />
				</div>
				<ul class="clear list01 movie_detail_area">
					<li><span class="tit">개요</span>
						<span class="con">애니메이션, 가족, 판타지</span>				
					</li>
					<li><span class="tit">감독</span>
						<span class="con">미야자키하야오</span>
					</li>
					<li><span class="tit">출연</span>
						<span class="con">히다카 노리코(사츠키 목소리), 사카모토 치카(메이 목소리)</span>
					</li>
					<li><span class="tit">등급</span>
						<span class="con">전체관람가</span>
					</li>
				</ul>
			</div>


			<div class="btn_area_center movie_btn">
				<a href="">스크랩하기 <span>2,300</span></a>
				<a href="">리뷰하기</a>
				<a href="">토론하기</a>
			</div>
			<div class="movie_img_list slider_list">
				<h2 class="title02">영화이미지</h2>
				<div class="viewer">
					<ul class="clear clearfix">
						<li><a href="#"><img src="${IMG_PATH }/poster/mv_img01.jpg" alt="" /></a></li>
						<li><a href="#"><img src="${IMG_PATH }/poster/mv_img02.jpg" alt="" /></a></li>
						<li><a href="#"><img src="${IMG_PATH }/poster/mv_img03.jpg" alt="" /></a></li>
						<li><a href="#"><img src="${IMG_PATH }/poster/mv_img04.jpg" alt="" /></a></li>
						<li><a href="#"><img src="${IMG_PATH }/poster/mv_img05.jpg" alt="" /></a></li>
						<li><a href="#"><img src="${IMG_PATH }/poster/mv_img01.jpg" alt="" /></a></li>
					</ul>
				</div>
				<div class="slider_nav"></div>
			</div>
			<!-- movie_content -->
			<div class="movie_content">
				<div class="tab">
					<div class="tab_area_wrap tab">
						<ul class="clearfix clear tab_title">
							<li><a href="#tab_main">주요정보</a></li>
							<li><a href="#tab_actor">배우제작진</a></li>
							<li><a href="#tab_video">동영상</a></li>
						</ul>
					
						<div class="tab_content" id="tab_main">
						나의 이웃은 토토로 ?! 행복이 기적처럼 쏟아진다! 올 여름 가장 아름다운 휴가계획! 순수의 숲으로 떠난다.
1955년 일본의 아름다운 시골 마을. 상냥하고 의젓한 11살 사츠키와 장난꾸러기에 호기심 많은 4살의 메이 는 사이좋은 자매로 아빠와 함께 도시를 떠나 시골로 이사온다. 자상한 아빠 쿠사카베타츠오는 도쿄에서 대학 연구원이며, 입원 중이지만 따뜻한 미소를 잃지 않는 엄마가 있다. 곧 퇴원하실 엄마를 공기가 맑은 곳에서 맞이하기 위해서다. 숲 한복판에 금방이라도 쓰러질 것처럼 낡은 집을 보며 자매는 새로운 환경에 대한 호기심으로 잔뜩 들뜬다.
 사츠키가 학교에 간 뒤, 혼자 숲에서 놀고 있던 메이는 눈 앞을 지나가는 조그맣고 이상한 동물을 발견한다. 그리고 뒤를 쫓아 숲속으로 들어가는데... 미로처럼 꼬불꼬불한 길을 따라가다 큰 나무 밑둥으로 떨어지는 메이. 그곳에서 메이는 도토리 나무의 요정인 토토로를 만난다. 메이는 사츠키가 돌아오지마자 토토로를 만난 것을 자랑하지만 사츠키는 믿지 않는다. 그러나 비가 몹시 쏟아지던 날, 정류장에서 우산을 들고 아빠를 기다리다가 사츠키도 토토로를 만나게 된다.
 비를 맞는 토토로에게 우산을 빌려주자 토토로는 답례로 도토리 씨앗을 건넨다. 토토로와의 만남으로 행복감에 부풀어있는 사츠키와 메이. 그러나 그때 병원에서 어머니의 퇴원이 연기되었다는 전보가 온다. 불안해하는 메이는 혼자 엄마를 찾아 병원으로 떠났다가 길을 잃는다. 온 동네를 뒤졌지만 메이는 흔적조차 없고 저수지에선 어린 여자아이의 샌달이 발견된다. 사츠키는 메이를 찾기 위해 애타게 토토로를 부르는데.
						</div>
						<div class="tab_content" id="tab_actor">
						</div>
						<div class="tab_content" id="tab_video">
						
						</div>	
					</div>									
				</div>
			</div>
			<!-- //movie_content -->
		</div>
	</div>
</section>
<!-- //content -->

<c:import url="../layout/footer.jsp"></c:import>