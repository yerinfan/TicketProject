<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<link rel="stylesheet" href="/ReserveSeat/style.css">
<head>
<meta charset="UTF-8">
<title>ReserveSeat</title>
</head>
<body>
	<header>
		<h1>aisw 강의실 자리 예약 서비스</h1>
		<nav>
			<ul>
				<c:choose>
					<c:when test="${not empty sessionScope.user}">
	
                            <span class="user-name">${sessionScope.user.name}님, 환영합니다!</span>
                            <a href="/ReserveSeat/logout.do">
                                <button class="logout-btn">로그아웃</button>
                            </a>
 
                        <li><a href="/ReserveSeat/reserve/list.do">자리 선점하기</a></li>
                        <li><a href="/ReserveSeat/board/list.do">교환 게시판</a></li>
                        <li><a href="/ReserveSeat/mypage.do">마이페이지</a></li>
					</c:when>
					<c:otherwise>
						<!-- 로그인되지 않은 경우 -->
						<li><a href="/ReserveSeat/login.do">로그인</a></li>
						<li><a href="/ReserveSeat/regist.do">회원 등록</a></li>
						<li><a href="/ReserveSeat/reserve/list.do">자리 선점하기</a></li>
						<li><a href="/ReserveSeat/board/list.do">교환 게시판</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>
</body>
</html>
