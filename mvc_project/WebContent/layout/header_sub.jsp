<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/common.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<!--[if IE 7]><html lang="ko" class="ie7"><![endif]-->
	<!--[if IE 8]><html lang="ko" class="ie8"><![endif]-->
	<title>${config.cf_title_info}</title>
	<link rel="stylesheet" type="text/css" href="${CSS_PATH }/style.css?v=<%=System.currentTimeMillis() %>" />
	<script type="text/javascript" src="${JS_PATH }/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${JS_PATH }/jquery-ui.js"></script>
	<script type="text/javascript" src="${JS_PATH }/TimelineMax.min.js"></script>
	<script type="text/javascript" src="${JS_PATH }/TweenMax.min.js"></script>
	<script type="text/javascript" src="${JS_PATH }/raphael.js"></script>
	<script type="text/javascript" src="${JS_PATH }/common.js"></script>
	<script type="text/javascript" src="${JS_PATH }/ux.js"></script>
</head>
<body>