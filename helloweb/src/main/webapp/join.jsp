<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String email = request.getParameter("email");
String password = request.getParameter("password");
String birthYear = request.getParameter("birthYear");
String gender = request.getParameter("gender");
String[] hobbies = request.getParameterValues("hobby");
String profile = request.getParameter("profile");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	email :
	<%=email%><br /> password :
	<%=password%><br /> birthYear :
	<%=birthYear%><br /> gender :
	<%=gender%><br />

	hobbies : 
	<ul>
	<%
		if(hobbies != null){
			
			for(String hobby : hobbies){	
	%>
	<li><%=hobby %></li>
	<%
			}
		}
	%>
	</ul>
	
	<p>
	<%=profile.replaceAll("\n", "<br/>") %>
	한글테스트
	</p>
	
	profile : <%=profile %>
</body>
</html>