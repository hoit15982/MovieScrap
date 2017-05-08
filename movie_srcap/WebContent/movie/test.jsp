<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("UTF-8");
	String key = "";
	
	String clientId = "6HVikB3DMDZr3CEHdBi1";// 애플리케이션 클라이언트 아이디값";
	String clientSecret = "pBS1QUbrV5";// 애플리케이션 클라이언트 시크릿값";
	System.out.println(request.getParameter("stx"));
	
	if(request.getParameter("stx") != null){
		key =  request.getParameter("stx");
	}
	
	try {
		String text = URLEncoder.encode(key, "UTF-8");
		/* String text = URLEncoder.encode("영화", "UTF-8"); */
		String apiURL = "https://openapi.naver.com/v1/search/movie.json?query="+text; // json
		
		/* System.out.println(apiURL); */
		URL url = new URL(apiURL);
		/* System.out.println(url); */
		
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		String inputLine;
		StringBuffer rs = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			rs.append(inputLine);
		}
		br.close();
		out.print(rs.toString());
	} catch (Exception e) {
		System.out.println(e);
	}
%>
