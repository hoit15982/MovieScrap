<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/header.jsp"></c:import>
<!-- content -->
<section class="content">
	
	<div class="content_area about_area clearfix">
		<div class="section01">
			<h2 class="title01">ABOUT</h2>
			<!-- who_area -->
			<div class="who_area">
				<div class="img">
					<img src="${IMG_PATH }/content/about_img01.png" alt="캐릭터이미지" />
				</div>
				<h3 class="title01">Who I Am</h3>
				<p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. </p>
				<ul class="clear who_myinfo">
					<li><span class="icon_phone">전화번호</span> 010.3050.1240</li>
					<li><span class="icon_mail">메일</span> leeminji25@naver.com</li>
					<li><span class="icon_career">직업 </span> web publisher & front-end developer</li>
				</ul>
			</div>
			<!-- //who_area -->
			<!-- education_area -->
			<div class="education_area">
				<h3 class="title01">Education</h3>
				<dl class="clear list01">
					<dt><span  class="icon_date"></span> 2009-2012</dt>
					<dd>
						<div class="icon_education">
							Lorem Ipsum is simply dummy text of the printing
						</div>
					</dd>
				</dl>
				<dl class="clear list01">
					<dt><span  class="icon_date"></span> 2009-2012</dt>
					<dd>
						<div class="icon_education">
							Lorem Ipsum is simply dummy text 
							<span class="add_info">Lorem Ipsum is simply </span>
						</div>
					</dd>
					<dd>
						<div class="icon_education">
							Lorem Ipsum is simply dummy text of the printing
						</div>
					</dd>
				</dl>
			</div>
			<!-- //education_area -->
		</div>
		<div class="section02">
			<!-- work_area -->
			<div class="work_area">
				<h3 class="title01">Work Experience</h3>
				<dl class="clear list01">
					<dt><span class="icon_date"></span> 2009-2012</dt>
					<dd>
						<div class="icon_education">
							Lorem Ipsum is simply dummy text of the printing
						</div>
					</dd>
				</dl>
				<dl class="clear list01">
					<dt><span class="icon_date"></span> 2009-2012</dt>
					<dd>
						<div class="icon_education">
							Lorem Ipsum is simply dummy text of the printing
							<span class="add_info">Lorem Ipsum is simply </span>
						</div>
					</dd>
					<dd>
						<div class="icon_education">
							Lorem Ipsum is simply 
							<span class="add_info">Lorem Ipsum is simply </span>
						</div>
					</dd>
				</dl>
			</div>
			<!-- //work_area -->
			<!-- myskill_area -->
			<div class="myskill_area">
				<h3 class="title01">My Skills</h3>
				<div class="skill_list">
					<ul class="clear">
						<li>
							<span class="tit">Website design</span>
							<span class="percent">85%</span>
							<span class="gage" style="width:85%"></span>
						</li>
						<li>
							<span class="tit">Website Development</span>
							<span class="percent">80%</span>
							<span class="gage" style="width:80%"></span>
						</li>
						<li>
							<span class="tit">Front end</span>
							<span class="percent">95%</span>
							<span class="gage" style="width:95%"></span>
						</li>
						<li>
							<span class="tit">Back end</span>
							<span class="percent">70%</span>
							<span class="gage" style="width:70%"></span>
						</li>
					</ul>
				</div>
			</div>
			<!-- //myskill_area -->
		</div>
	</div>
</section>
<!-- //content -->
<c:import url="../layout/footer.jsp"></c:import>