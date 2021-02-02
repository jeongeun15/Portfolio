<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글 작성</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.min.css"/>
</head>
<body>
	<a href="./boardList.do">뒤로가기</a>
	<form action="./wirte.do" method="post">
		<table class="table table-bordered form-group">
			<tr>
				<td>아이디</td>
				<td>제목</td>
				<td>내용</td>
			</tr>
			<tr>
				<td>
					<p>${sessionScope.mem.id}</p>
				</td>
				<td>
					<input type="text" id="title" name="title" required>
				</td>
				<td>
					<textarea rows="5" id="content" name="content" required></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input class="btn btn-primary active" type="submit" value="새글저장">
					<input class="btn btn-primary active" type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>