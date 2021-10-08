<%@page import="com.douzone.guestbook.vo.GuestBookVo"%>
<%@page import="util.SimpleConnectionProvider"%>
<%@page import="com.douzone.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	GuestBookDao dao = new GuestBookDao(new SimpleConnectionProvider());
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");
	GuestBookVo vo = new GuestBookVo();
	
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);
	
	dao.insert(vo);
	response.sendRedirect("/guestbook01");
%>