
<%@page import="com.main.dto.MemberVO"%>
<%@page import="com.main.dao.MemberDAO"%>
<%@page import="com.main.dto.ConfigVO"%>
<%@page import="com.main.dao.ConfigDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	//경로설정
	String path = request.getContextPath();
	application.setAttribute("PATH", path );
	application.setAttribute("JS_PATH", path +"/public/js");
	application.setAttribute("CSS_PATH", path +"/public/css");
	application.setAttribute("IMG_PATH", path +"/public/images");
	
	ConfigDAO cDao = ConfigDAO.getInstance();
	ConfigVO cVo = cDao.getConfig();
	
	String requestURL = request.getRequestURL().toString();
	String contextPath = request.getContextPath();
	String URL = requestURL.substring(0,requestURL.indexOf(contextPath)+contextPath.length());
	application.setAttribute("URL", URL);
	
	//프로젝트 기본정보 설정
	application.setAttribute("config", cVo);
	
	//세션 로그인 여부
	if( session.getAttribute("ss_mb_id") != null ){
		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.getMember((String)session.getAttribute("ss_mb_id"));
	}else{
		//로그아웃 여부 세션
		session.setAttribute("ss_is_login", false);		
	}

%>

