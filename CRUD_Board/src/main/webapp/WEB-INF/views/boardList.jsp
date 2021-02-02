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
<script type="text/javascript">
	// 전체 글 선택
	function checkAll(chk) {
		var chkval = document.getElementsByName("chkVal");
		for (var i = 0; i < chkval.length; i++) {
			chkval[i].checked = chk;
		}
	}

	// 선택 글 삭제
	function chkbox() {
		var chkval = document.getElementsByName("chkVal");
		var n = 0;
		for (var i = 0; i < chkval.length; i++) {
			if (chkval[i].checked) {
				n++;
			}
		}
		if (n > 0) {
			document.getElementById('frm').action = "./multiDel.do"
		} else {
			alert("한 개 이상의 삭제 값을 선택하세요.");
			return false;
		}
	}

	// 글쓰기
	function writeForm() {
		location.href = "./writeForm.do";
	}
</script>
</head>
<body>
	<a href="./logout.do">로그아웃</a>
	<form action="#" method="post" id="frm" name="frm" onsubmit="return chkbox();">
		<table class="table table-hover">
			<thead>
				<tr class="info">
					<th><input type="checkbox" onclick="checkAll(this.checked)"></th>
					<th>연번</th>
					<th>아이디</th>
					<th>제목</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(list) eq 0}">
					<tr>
						<td colspan="5" style="text-align:center; color: red; font-size: 1.3em ">
							작성된 글이 없습니다.
						</td>
					</tr>
				</c:if>
				
				<c:forEach var="list" items="${list}" varStatus="vs">
				<c:if test="${list.delflag eq 'N'}">
					<tr>
						<td><input type="checkbox" name="chkVal" value="${list.seq}"></td>
						<td>${vs.count}</td>
						<td>${list.id}</td>
						<td>	<!-- useBean 사용해서 댓글 처리 -->
							<jsp:useBean id="reply" class="com.min.edu.usebean.Reply" scope="page"/>
							<jsp:setProperty property="depth" name="reply" value="${list.depth}"/>
							<jsp:getProperty property="photo" name="reply"/>
							<a href="./detailView.do?seq=${list.seq}">${list.title}</a>
						</td>
						<td>
							<fmt:parseDate var="patternDate" value="${list.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate value="${patternDate}" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
				</c:if>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="5" style="text-align: center;">
						<input class="btn-info btn btn-primary" type="submit" value="다중삭제">
						<input class="btn-info btn btn-primary" type="button" value="새글입력" onclick="writeForm()">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>