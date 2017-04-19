<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/admin/layout/header.jsp"></c:import>

<section class="content" id="content">
	<div class="clearfix main_area01">
		<div class="welcome_text">
			<h2 class="title01">Dashboard.</h2>
			<p><em>Welcome to WordPress!</em><br>We’ve assembled some links to get you started:</p>
		</div>
		<div class="cleafix site_info_area">
			<section class="site_info">
				<h2 class="title02">Total Balance.</h2>
				<p><span class="text01">$ 3,700</span><span class="text02">70%</span></p>
			</section> 
			<section class="site_info">
				<h2 class="title02">New Members.</h2>
				<p><span class="text01">24</span><span class="text02">14%</span></p>
			</section> 
			<section class="site_info">
				<h2 class="title02">New Orders</h2>
				<p><span class="text01">7</span><span class="text02">35%</span></p>
			</section> 
			<section class="site_info">
				<h2 class="title02">Delivered</h2>
				<p><span class="text01">85</span><span class="text02">17%</span></p>
			</section> 
		</div>
	</div>
	<div class="clearfix main_area02">
		<section class="unit_area recent_area">
			<div class="inner">
			<h2><span class="icon_calendal"></span>Recent Activity</h2>
			<div class="scroll_wrap">
				<div class="scroll_inner">
					<ul class="clear list_recent">
						<li>
							<a href="#">
								<span class="img"><img src="${IMG_PATH }/temp_img01.jpg" alt=""></span>
								<span class="text">Liala added a new comment to the public form.</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="img"><img src="${IMG_PATH }/temp_img01.jpg" alt=""></span>
								<span class="text">Liala removed Freddy from her friend without giving any reason.</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="img"><img src="${IMG_PATH }/temp_img01.jpg" alt=""></span>
								<span class="text">Liala added a new comment to the public form.</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<a href="" class="btn_all">see all</a>
			</div>
		</section>
		<section class="unit_area address_area">
			<div class="inner">
			<h2><span class="icon_graph"></span>Address Book</h2>
			<div class="scroll_wrap">
				<div class="scroll_inner">
				<ul class="clear list_address">
					<li><a href="" class="tit ellipsis">Wassim Awadallah Wassim Awadallah Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
					<li><a href="" class="tit ellipsis">Wassim Awadallah</a> <span class="btn"><a href="">Edit</a>.<a href="">Delete</a></span></li>
				</ul>
				</div>
			</div>
			<a href="" class="btn_all">see all</a>
			</div>
		</section>
		<section class="unit_area top_rated_area">
			<div class="inner">
			<h2><span class="icon_calendal"></span>Top Rated Products</h2>
			<div class="scroll_wrap">
				<div class="scroll_inner">
				<ul class="clear list_top_rated">
					<li>
						<a href="#" class="tit">
							<strong>T-Shirt</strong>
							<span class="ellipsis">We’ve assembled some links to get</span>
						</a>
						<a href="#" class="num"><span>7</span></a>
					</li>
					<li>
						<a href="#" class="tit">
							<strong>T-Shirt</strong>
							<span class="ellipsis">We’ve assembled some links to get</span>
						</a>
						<a href="#" class="num"><span>7</span></a>
					</li>
					<li>
						<a href="#" class="tit">
							<strong>T-Shirt</strong>
							<span class="ellipsis">We’ve assembled some links to get</span>
						</a>
						<a href="#" class="num"><span>7</span></a>
					</li>
					<li>
						<a href="#" class="tit">
							<strong>T-Shirt</strong>
							<span class="ellipsis">We’ve assembled some links to get</span>
						</a>
						<a href="#" class="num"><span>7</span></a>
					</li>
					<li>
						<a href="#" class="tit">
							<strong>T-Shirt</strong>
							<span class="ellipsis">We’ve assembled some links to get</span>
						</a>
						<a href="#" class="num"><span>7</span></a>
					</li>
				</ul>
				</div>
			</div>
			<a href="" class="btn_all">see all</a>
			</div>
		</section>
	</div>
	<div class="clearfix main_area03">
		<section class="unit_area notice_area">
			<div class="inner">
			<h2><span class="icon_calendal"></span>Alert Messages & Notifications</h2>
			<ul class="clear list_notice">
				<li class="icon_noitce">Liala added a new comment to the public form.<a href="#" class="btn_notice"></a></li>
				<li class="icon_check">Liala added a new comment to the public form.<a href="#" class="btn_check"></a></li>
				<li class="icon_close">Liala added a new comment to the public form.<a href="#" class="btn_close"></a></li>
			</ul>
			</div>
		</section>
		<section class="unit_area recent_area">
			<div class="inner">
			<h2><span class="icon_calendal"></span>Recent Signups</h2>
			<div class="scroll_wrap">
				<div class="scroll_inner">
				<ul class="clear list_recent">
					<li>
						<a href="#">
							<span class="img"><img src="${IMG_PATH }/temp_img01.jpg" alt=""></span>
							<span class="text">Liala added a new comment to the public form.</span>
						</a>
					</li>
					<li>
						<a href="#">
							<span class="img"><img src="${IMG_PATH }/temp_img01.jpg" alt=""></span>
							<span class="text">Liala removed Freddy from her friend without giving any reason.</span>
						</a>
					</li>
					<li>
						<a href="#">
							<span class="img"><img src="${IMG_PATH }/temp_img01.jpg" alt=""></span>
							<span class="text">Liala added a new comment to the public form.</span>
						</a>
					</li>
				</ul>
				</div>
			</div>
			<a href="" class="btn_all">see all</a>
			</div>
		</section>
	</div>
</section>

<c:import url="/admin/layout/footer.jsp"></c:import>