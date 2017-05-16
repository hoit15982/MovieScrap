<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String key = "아이언맨";
	String apikey = "DE611070AD8C97B8FAE32AFB839EF9CA3E764F776407F406616C6FF56A2";// 애플리케이션 클라이언트 아이디값";

	try {
		/* String text = URLEncoder.encode(apikey, "UTF-8");
		String text2 = URLEncoder.encode(key, "UTF-8"); */
		StringBuilder urlBuilder = new StringBuilder("http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json.jsp?");
		urlBuilder.append(URLEncoder.encode("collection","utf-8")+"="+URLEncoder.encode("kmdb_new", "utf-8"));
		urlBuilder.append("&"+URLEncoder.encode("ServiceKey", "utf-8")+"="+URLEncoder.encode("DE611070AD8C97B8FAE32AFB839EF9CA3E764F776407F406616C6FF56A2", "utf-8"));
		urlBuilder.append("&"+URLEncoder.encode("title", "utf-8")+"="+URLEncoder.encode("아이언맨","utf-8"));
		
	
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + con.getResponseCode());
		
		int responseCode = con.getResponseCode();
		
		BufferedReader rd;
		if (responseCode == 200) { // 정상 호출
			rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			rd = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line.trim());
		}
		rd.close();
		out.print(sb.toString());
		con.disconnect();
	} catch (Exception e) {
		System.out.println(e);
	}
%>
