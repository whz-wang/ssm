<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>查询用户列表</h1>
<form action="${pageContext.request.contextPath }/user/findUsers" method="post">
	用户名称：<input type="text" name="userName" value=""/>
	<input type="submit" name="查询"/> 
</form>

<c:forEach var="user" items="${userList}">
	<div>
		id: ${user.id } ---
		用户编码: ${user.userCode } ---
		用户名称: ${user.userName } ---
		用户密码: ${user.userPassword } ---
		用户生日: ${user.birthday } ---
		用户地址: ${user.address } ---
	</div>
</c:forEach>
</body>
</html>