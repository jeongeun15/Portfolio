<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	// id 중복체크
	$(document).ready(function(){
		$('#id').keyup(function(){
			var idLength = $(this).val().length;
	        var id = '';
	        id = $(this).val();
			if(idLength >= 5){
				jQuery.ajax({
					type : "POST",
					url : "./idCheck.do",
					data : "id="+$(this).val(),
					success : function(map){
						if(map.isc == 'true'){
							$('#chkval').val('0');
							$('#result').html('사용 불가능한 아이디입니다.');
							$('#result').css('color', 'red');
						}else{
							$('#chkval').val('1');
							$('#result').html('사용 가능한 아이디입니다.');
							$('#result').css('color', 'green');
						}
					},
					error:function(error){
						console.log(error);
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<h2>회원가입</h2>
	<form action="./regist.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="id" name="id" placeholder="아이디 입력">
					<input type="hidden" id="chkval" value="1">
				</td>
				<td>
					<span id="result"></span>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td colspan="2">
					<input type="password" name="pw" placeholder="비밀번호 입력">
				</td>
			</tr>
			<tr>
				<td>성명</td>
				<td colspan="2">
					<input type="text" name="name" placeholder="성명 입력">
				</td>
			</tr>
			<tr style="text-align: center;">
				<td colspan="3">
					<input type="submit" value="회원 가입">
					<input type="reset" value="값 초기화">
					<input type="button" value="돌아가기" onclick="javascript:history.back(-1)">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>