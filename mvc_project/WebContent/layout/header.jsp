<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="${URL }/layout/header_sub.jsp"></c:import>
<!-- header -->
<header id="header" class="header">
	<div class="inner">
		<div class="logo"><h1><a href="${PATH }/index.do">${config.cf_title }</a></h1></div>
		<section class="global_area">
			<h2 class="skip">메뉴</h2>
			<ul class="clearfix clear">
			<c:choose>
			<c:when test="${empty ss_mb_id}">
			<li><a href="${PATH }/pf/member/login">LOGIN</a></li>
			<li><a href="${PATH }/pf/member/join">JOIN</a></li>
			</c:when>
			<c:otherwise>
			<li>${mVo.mb_name }(${mVo.mb_id })</li>
			<li><a href="${PATH }/pf/member/logout">LOGOUT</a></li>
			<li><a href="${PATH }/pf/member/member_update">MYPAGE</a></li>
			</c:otherwise>
			</c:choose>
			</ul>
		</section>
		<!-- myinfo_area -->
		<section class="myinfo_area">
			<h2 class="skip">나의 정보</h2>
			<a href="#" class="btn_myinfo">My infomaition</a>
			<ul class="clear">
				<li><span class="icon_phone">전화번호</span>010.3050.1240</li>
				<li><span class="icon_mail">메일</span>leeminji25@naver.com</li>
				<li><span class="icon_career">직업 </span>web publisher & front-end developer</li>
			</ul>						
		</section>
		<!-- //myinfo_area -->
		<!-- gnb_area -->
		<nav class="gnb_area">
			<h2 class="skip">메인메뉴</h2>
			
			<ul class="clear">
				<c:forEach items="${menuList }" var="menuVo">
				<li><a href="${PATH }${menuVo.me_link }" class=<c:if test="${current_path == menuVo.me_link}">'on'</c:if>>${menuVo.me_name }</a></li>
				</c:forEach>
			</ul>
		</nav>
		<!-- //gnb_area -->
		<!-- filter_area -->
		<section class="filter_area">
			<h3 class="text01"><span>Filter</span> <span class="icon_filter"></span></h3>
			<ul class="clear">
				<li><a href="">All Works</a></li>
				<li><a href="">web design</a></li>
				<li><a href="">illustration</a></li>
				<li><a href="">photography</a></li>
				<li><a href="">wallpapers</a></li>
				<li><a href="">brochures</a></li>
			</ul>
		</section>
		<!-- //filter_area -->
		<!-- sns_area -->
		<section class="sns_area">
			<h3 class="skip">소셜네트워크</h3>
			<ul class="clear clearfix">
				<li><a href="" class="icon_facebook">facebook</a></li>
				<li><a href="" class="icon_google">google+</a></li>
			</ul>
		</section>
		<!-- //sns_area -->
		<!-- footer -->
		<footer class="copyright">
			<address>${config.cf_title } ${config.cf_addr } ${config.cf_tel }</address>
			<address>${config.cf_title } ＠ 2017 All Rights Reserved</address>
		</footer>
		<!-- //footer -->		
	</div>
	<span class="deco_shadow"></span>
</header>
<!-- //header -->
<hr />
<!-- container -->
<div class="container_wrap">
<section id="containter" class="container">
