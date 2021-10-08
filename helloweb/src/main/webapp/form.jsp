<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입</h1>
	<form action="/helloweb/join.jsp" method="post">
		이메일 : <input type='text' name='email' value='' placeholder="myemail@gmail.com" />
		<br/><br/>
		패스워드 : <input type='password' name='password' value='' />
		<br/><br/>
		<select name='birthYear'>
			<option value='1995'>1995</option>
			<option value='1996'>1996</option>
			<option value='1997'>1997</option>
		</select>
		<br/><br/>
		성별 :
		여 <input type='radio' name='gender' value='f'/>
		남 <input type='radio' name='gender' value='m'/>
		<br/><br/>
		취미 :
		코딩 <input type='checkbox' name='hobby' value='coding'/>
		음주 <input type='checkbox' name='hobby' value='drinking'/>
		요리 <input type='checkbox' name='hobby' value='cooking'/>
		수영 <input type='checkbox' name='hobby' value='swimming'/>
		
		
		<br/><br/>
		자기소개:
		<textarea name='profile'></textarea>
		<input type='submit' value='회원가입'>
	</form>
</body>
</html>