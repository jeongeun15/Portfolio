<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
</head>
<body>
	<form action="#" method="post" id="frm" name="frm" onsubmit="return chkbox();">
		<table class="table table-hover">
			<thead>
				<tr class="info">
					<th>연번</th>
					<th>아이디</th>
					<th>이름</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(list) eq 0}">
					<tr>
						<td colspan="5" style="text-align:center; color: red; font-size: 1.3em ">
							등록된 회원이 없습니다.
						</td>
					</tr>
				</c:if>
				
				<c:forEach var="list" items="${list}" varStatus="vs">
				<c:if test="${list.delflag eq 'N'}">
					<tr>
						<td>${vs.count}</td>
						<td>${list.id}</td>
						<td>${list.name}</td>
						<td>
							<fmt:parseDate var="patternDate" value="${list.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${patternDate}" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
				</c:if>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>