<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%
Date d = new Date();
Calendar now = Calendar.getInstance();
int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
int hour = now.get(Calendar.HOUR_OF_DAY);
int minute = now.get(Calendar.MINUTE);

boolean isDisabled = false;

if ((dayOfWeek == Calendar.FRIDAY && hour >= 12) && (dayOfWeek == Calendar.SATURDAY && hour < 2)) {
	isDisabled = true;
}

// JSP 변수 설정
request.setAttribute("isDisabled", isDisabled);
%>

<!DOCTYPE html>
<html lang="ko">
<link rel="stylesheet" href="/ReserveSeat/style.css">
<head>
<meta charset="UTF-8">
<title>ReserveSeat</title>
</head>
<script>
	// 버튼 클릭 시 알림 표시
	function showAlert(message) {
		alert(message);
	}
</script>

<body>
	<header>
		<h1>aisw 강의실 자리 예약 서비스</h1>

		<nav>
			<ul>
				<c:choose>
					<c:when test="${not empty sessionScope.user}">
						<span class="user-name">${sessionScope.user.nickname}님, 환영합니다!</span>
						<a href="/ReserveSeat/logout.do">
							<button class="logout-btn">로그아웃</button>
						</a>
						<li>
							<a href="/ReserveSeat/board/list.do">교환 게시판</a>
						</li>
						<li>
							<a href="/ReserveSeat/mypage.do">마이페이지</a>
						</li>
					</c:when>
					<c:otherwise>
						<!-- 로그인되지 않은 경우 -->
						<li>
							<a href="/ReserveSeat/login.do">로그인</a>
						</li>
						<li>
							<a href="/ReserveSeat/regist.do">회원 등록</a>
						</li>
						<li>
							<a href="#" onclick="showAlert('로그인이 필요합니다. 로그인 페이지로 이동합니다.'); window.location.href='/ReserveSeat/login.do'; return false;">
								교환 게시판
							</a>
						</li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>
	<div class="center-container">
		<c:if test="${isDisabled}">
			<p id="countdown">
				현재시각: <%=d%>
			</p>
			<br>
			<p>매주 토요일 오후 2시에 열립니다.</p>
		</c:if>
		<a href="/ReserveSeat/reserve/list.do"
			<c:if test="${empty sessionScope.user}">
				onclick="showAlert('로그인이 필요합니다. 로그인 페이지로 이동합니다.'); window.location.href='/ReserveSeat/login.do'; return false;"
			</c:if>
			<c:if test="${isDisabled}">
				onclick="showAlert('아직 예약 시간이 아닙니다.'); return false;"
			</c:if>
		>
			<button id="reserveSeatBtn" <c:if test="${isDisabled}">disabled</c:if>>
				자리 선점하기
			</button>
		</a>
	</div>
	<div class="container">
		<section class="section" id="section-3">
			<div id="map" style="width: 50%; height: 500px; margin: auto"></div>
			<code id="snippet" class="snippet"></code>
		</section>
		<script type="text/javascript"
			src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vlnlaty5bo"></script>
		<script id="code">
			var map = new naver.maps.Map('map', {
				center : new naver.maps.LatLng(37.458731, 127.153807), // 지도의 초기 중심 좌표
				zoom : 17, // 지도의 초기 줌 레벨
				minZoom : 8, // 지도의 최소 줌 레벨
				zoomControl : true, // 줌 컨트롤의 표시 여부
				zoomControlOptions : { // 줌 컨트롤의 옵션
					position : naver.maps.Position.TOP_RIGHT
				}
			});
			var marker = new naver.maps.Marker({
				position : new naver.maps.LatLng(37.458731, 127.153807),
				map : map
			});
		</script>
	</div>
</body>
</html>
