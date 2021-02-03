<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아임포트 API</title>
</head>
<!-- 아이포트 라이브러리 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script type="text/javascript" src="./js/iamport.js"></script>
<body>
<form action="">
	<input type="text" id="name" name="name" value="홍길동">
	<input type="text" id="email" name="email" value="importTest1234@gmail.com">
	<input type="text" id="tel" name="tel" value="010-1234-5678">
	<input type="button" value="결제하기" onclick="pay()">
</form>
</body>
</html>