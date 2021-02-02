<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 보기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
</head>
<body>
	<form action="./modify.do" method="post">
	<table class="table">
		<c:forEach var="detail" items="${detail}">
		<tr>
			<td>아이디</td>
			<td>${detail.id}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${detail.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="5" id="content" name="content" required>${detail.content}</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input class="btn-info btn btn-primary" type="submit" value="수정완료">
				<input class="btn-info btn btn-primary" type="button" value="돌아가기" onclick="back()">
				<input type="hidden" name=seq value="${detail.seq}">
			</td>
		</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>