<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>담당 직원 출력</title>
</head>
<body>
	<h2>* 담장직원 보기 *</h2>
	<table border="1">
		<tr><td>사번</td><td>직원명</td><td>부서명</td><td>직급</td></tr>
		<c:forEach var="j" items="${datase }">
			<tr>
				<td>${j.jikwon_no }</td>
				<td>${j.jikwon_name }</td>
				<td>${j.buser_name }</td>
				<td>${j.jikwon_jik }</td>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>