<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<script type="text/javascript">
	// 로그인
	window.onload = function(){
		document.getElementById("login").onclick = function(){
			var id= document.getElementsByName('id')[0];	// name="id" 첫번째 요소
			var pw = document.getElementsByName('pw')[0];	// name="pw" 첫번째 요소
			if (id.value=="" || pw.value=="") {
				alert("아이디 또는 비밀번호를 입력해주세요.");
			}else{
				document.loginForm.submit();
			}
		}
	}

	// 회원가입
	function registForm(){
		location.href = "./registForm.do";
	}
</script>
</head>
<body>
	<div id="container">
		<form name="loginForm" action="./login.do" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" id="login" value="로그인">
						<input type="button" value="회원가입" onclick="registForm()">
					</td>
				</tr>
			</table>
		</form>
	</div>
<a href="./memberList.do">회원 목록 보기</a>
</body>
</html>