<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객자료</title>
</head>
<body>
	<h2>* 고객자료보기 (@MVC : 전통적인 방법) *</h2>
	<table border="1">
		<tr><th>고객번호</th><th>고객명</th><th>고객전화</th></tr>
		<c:forEach var="g" items="${datas }">
			<tr>
				<td>${g.gogek_no }</td>
				<td><a href="jikwondb?no=${g.gogek_damsano }">${g.gogek_name }</a></td>
				<td>${g.gogek_tel }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>