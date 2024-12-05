<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
<style>
body {
	font-family: Arial, sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background-color: #f4f4f4;
}

.register-container {
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	width: 400px;
	text-align: center;
}

h2 {
	margin-bottom: 20px;
}

table {
	margin: 0 auto;
	width: 100%;
}

table th, table td {
	text-align: left;
	padding: 10px;
}

table th {
	width: 30%;
}

table input[type="text"], table input[type="password"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
}

.button-group {
	margin-top: 20px;
	display: flex;
	justify-content: space-between;
}

.button {
	padding: 10px 20px;
	background-color: #007BFF;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	text-decoration: none;
}

.button:hover {
	background-color: #0056b3;
}

.button.cancel {
	background-color: #ff4d4d;
}

.button.cancel:hover {
	background-color: #d11a1a;
}
</style>
</head>
<body>
	<div class="register-container">
		<h2>회원 등록</h2>
		<form action="/ReserveSeat/registerAction.do" method="post">
			<table>
				<tr>
					<th>이메일</th>
					<td><input type="text" name="email"
						value="<%=request.getAttribute("email")%>" readonly></td>
				</tr>
				<tr>
					<th>학번</th>
					<td><input type="text" name="userId" required /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" required /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password" required /></td>
				</tr>
				<tr>
					<th>닉네임</th>
					<td><input type="text" name="nickname"
						value="<%=request.getAttribute("nickname")%>" readonly></td>
				</tr>
			</table>
			<div class="button-group">
				<button type="submit" class="button">가입하기</button>
				<a href="/ReserveSeat/login.do" class="button cancel">취소</a>
			</div>
		</form>
	</div>
</body>
</html>
