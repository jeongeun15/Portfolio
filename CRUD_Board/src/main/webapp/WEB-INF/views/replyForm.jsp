<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
</head>
<body>
	<form action="./reply.do" method="post">
		<c:forEach var="detail" items="${detail}">
			<table class="table">
				<tr>
					<th>아이디:</th>
					<td>${mem.id}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" required>
					</td>
				</tr>
				<tr>
					<th>내용<br>(원본)</th>
					<td>
						<textarea rows="5" cols="50" id="txtArea" name="content" required>원본글&gt;&nbsp;${detail.content}</textarea></td>
				</tr>
				<tr>
					<th>작성일</th>
					<td>
						<c:set var="now" value="<%=new java.util.Date()%>"/>
						<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일"/> 
					</td>
				</tr>
				<tr>
					<th colspan="2" style="text-align: center;">
						<input class="btn btn-primary btn-sm btn-block" type="submit" value="답글입력">
						<input class="btn btn-primary btn-sm btn-block" type="reset" value="입력초기화">
						<input type="hidden" name="seq" value="${detail.seq}">
					</th>
				</tr>
			</table>
		</c:forEach>
	</form>
</body>
</html>