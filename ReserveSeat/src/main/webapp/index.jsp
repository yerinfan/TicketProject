<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String reserveStatus = "ENABLED"; // 기본값 (DB에서 가져와야 함)
try {
	java.sql.Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username",
	"password");
	java.sql.Statement stmt = conn.createStatement();
	java.sql.ResultSet rs = stmt.executeQuery("SELECT reserve_status FROM system_status WHERE id = 1");
	if (rs.next()) {
		reserveStatus = rs.getString("reserve_status");
	}
	conn.close();
} catch (Exception e) {
	e.printStackTrace();
}

boolean isDisabled = "DISABLED".equals(reserveStatus);
%>
<!DOCTYPE html>
<html lang="ko">
<link rel="stylesheet" href="/ReserveSeat/style.css">
<head>

<meta charset="UTF-8">
<title>ReserveSeat</title>

</head>

    <script>
        // 서버에서 전달받은 남은 시간
        let hours = ${hours};
        let minutes = ${minutes};

        function updateCountdown() {
            if (minutes === 0 && hours === 0) {
                document.getElementById("countdown").innerHTML = "활성화되었습니다!";
                return;
            }

            if (minutes === 0) {
                hours--;
                minutes = 59;
            } else {
                minutes--;
            }

            document.getElementById("countdown").innerHTML = `${hours}시간 ${minutes}분 남았습니다.`;
            setTimeout(updateCountdown, 60000); // 1분마다 업데이트
        }

        window.onload = updateCountdown;
    </script>
<body>
	<header>
		<h1>aisw 강의실 자리 예약 서비스</h1>
		
		<nav>
			<ul>
				<c:choose>
					<c:when test="${not empty sessionScope.user}">

						<span class="user-name">${sessionScope.user.nickname}님,
							환영합니다!</span>
						<a href="/ReserveSeat/logout.do">
							<button class="logout-btn">로그아웃</button>
						</a>

						<li><a href="/ReserveSeat/reserve/list.do">
								<button id="reserveSeatBtn" ${isDisabled ? "disabled" : ""}>자리
									선점하기</button>
						</a></li>
						<li><a href="/ReserveSeat/board/list.do">교환 게시판</a></li>
						<li><a href="/ReserveSeat/mypage.do">마이페이지</a></li>
					</c:when>
					<c:otherwise>
						<!-- 로그인되지 않은 경우 -->
						<li><a href="/ReserveSeat/login.do">로그인</a></li>
						<li><a href="/ReserveSeat/regist.do">회원 등록</a></li>
						<li><a href="/ReserveSeat/reserve/list.do">
								<button id="reserveSeatBtn" ${isDisabled ? "disabled" : ""}>자리
									선점하기</button>
						</a></li>
						<li><a href="/ReserveSeat/board/list.do">교환 게시판</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</header>

 <h1>자리 선점 활성화까지 남은 시간</h1>
    <p id="countdown">
        ${hours}시간 ${minutes}분 남았습니다.
    </p>

	<div class="container">
		<section class="section" id="section-3">
			<div id="map" style="width: 50%; height: 500px; margin: auto"></div>
			<code id="snippet" class="snippet"></code>
		</section>
		<script type="text/javascript"
			src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=vlnlaty5bo"></script>
		<script id="code">
			var map = new naver.maps.Map('map', {
				center : new naver.maps.LatLng(37.458731, 127.153807), //지도의 초기 중심 좌표
				zoom : 17, //지도의 초기 줌 레벨
				minZoom : 8, //지도의 최소 줌 레벨
				zoomControl : true, //줌 컨트롤의 표시 여부
				zoomControlOptions : { //줌 컨트롤의 옵션
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
