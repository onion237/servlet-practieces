<%@page import="com.douzone.guestbook.vo.GuestBookVo"%>
<%@page import="util.SimpleConnectionProvider"%>
<%@page import="com.douzone.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GuestBookDao dao = new GuestBookDao(new SimpleConnectionProvider());
	GuestBookVo vo = new GuestBookVo();
	Long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	vo.setNo(no);
	vo.setPassword(password);
	dao.delete(vo);
	response.sendRedirect("/guestbook01");
%>