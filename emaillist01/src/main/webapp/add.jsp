<%@page import="com.douzone.emaillist.vo.EmaillistVo"%>
<%@page import="util.SimpleConnectionProvider"%>
<%@page import="com.douzone.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmaillistDao dao = new EmaillistDao(new SimpleConnectionProvider());
	EmaillistVo vo = new EmaillistVo();
	request.setCharacterEncoding("utf-8");
	vo.setFirstName(request.getParameter("fn"));
	vo.setLastName(request.getParameter("ln"));
	vo.setEmail(request.getParameter("email"));
	dao.insert(vo);
	response.sendRedirect("/emaillist01");
%>
