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
<script type="text/javascript">
	// 해당 글 삭제
	function del(seq) {
		var con = confirm("선택된 글을 삭제하시겠습니까?");
		if (con) {
			location.href = "./del.do?seq="+seq;
		} else {
			alert("삭제가 취소 되었습니다.");
		}
	}

	// 해달 글 수정
	function modify(seq) {
		location.href = "./modifyForm.do?seq="+seq;
	}

	// 해당 글 답글달기
	function reply(seq) {
		location.href = "./replyForm.do?seq="+seq;
	}
</script>
</head>
<body>
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
			<td>${detail.content}</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${detail.regdate}</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input class="btn-primary" type="button" value="완전삭제" onclick="del(${detail.seq})">
				<input class="btn-success" type="button" value="글수정" onclick="modify(${detail.seq})">
				<input class="btn-info" type="button" value="답글작성" onclick="reply(${detail.seq})">
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>