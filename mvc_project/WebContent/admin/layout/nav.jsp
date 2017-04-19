<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- nav_main_area -->
<nav class="nav_main_area bg_black30">
	<h2 class="skip">메인메뉴</h2>
	<ul class="clear">
		<li><a href="${PATH }/adm/main">HOME</a></li>
		<li><a href="${PATH }/adm/member/">회원관리</a></li>
		<li><a href="${PATH }/adm/boardOption/">게시판관리</a></li>
		<li><a href="${PATH }/adm/board/list.do?bo_table=notice">게시판</a>
			<ul class="clear bg_black90">
				<li><a href="${PATH }/adm/board/list.do?bo_table=notice">공지사항</a></li>
				<li><a href="gallery.list.html">Gallery</a></li>
				<li><a href="board.setting.list.html">Setting</a></li>
			</ul>
		</li>
		<li><a href="${PATH }/adm/config/">환경설정</a>
			<ul class="clear bg_black90">
				<li><a href="${PATH }/adm/config/">환경설정</a></li>
				<li><a href="${PATH }/adm/menu/">Menu</a></li>
				<li><a href="${PATH }/adm/popup/">Popup</a></li>
			</ul>
		</li>
	</ul>
</nav>
<!-- //nav_main_area -->
