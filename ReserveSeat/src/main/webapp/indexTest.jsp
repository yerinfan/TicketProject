<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%

Date d = new Date();
Calendar now = Calendar.getInstance();
int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
int hour = now.get(Calendar.HOUR_OF_DAY);
int minute = now.get(Calendar.MINUTE);

boolean isDisabled = false;

if ((dayOfWeek == Calendar.TUESDAY && hour >= 0) && (dayOfWeek == Calendar.TUESDAY && hour < 2)) {
    isDisabled = true;
}

//JSP 변수 설정
request.setAttribute("isDisabled", isDisabled);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>ReserveSeat</title>
    <link rel="stylesheet" href="/ReserveSeat/style.css">
</head>
    <script>
        // 버튼 클릭 시 알림 표시
        function showAlert() {
            alert("아직 예약 시간이 아닙니다.");
        }
    </script>
<body>
    <header>
        <h1>aisw 강의실 자리 예약 서비스</h1>
        <nav>
              <ul>
                <li>
                    <a href="/ReserveSeat/reserve/list.do" onclick="${isDisabled ? 'showAlert(); return false;' : ''}">
                        <button id="reserveSeatBtn" ${isDisabled ? "disabled" : ""}>자리 선점하기</button>
                    </a>
                </li>
            </ul>
        </nav>
    </header>
      현재시각:
   <%= d %>
 
</body>
</html>
