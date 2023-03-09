<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%
	try {
		String apiURL = "https://api.androidhive.info/contacts/";
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
		}
		String inputLine;
		StringBuffer resp = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			resp.append(inputLine);
		}
		br.close();
		System.out.println(resp.toString());
	
		response.reset();
		out.clearBuffer();
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		out.print(resp.toString());
	} catch (Exception e) {
		System.out.println(e);
	}
%>


