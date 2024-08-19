<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" import= "java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지 처리</title>
</head>
<body>
	<h2>예외처리 지원</h2>
	<p>
	<c:out value="${exception.getMessage()}" ></c:out>
	</p>
	<ul>
	<c:forEach items="${exception.getStackTrace()}" var="stack"></c:forEach>
	<li>
	<c:out value="${stack}"></c:out>
	</li>
	</ul>
	
</body>
</html>