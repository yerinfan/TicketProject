package kr.ac.kopo.framework;

import java.io.IOException;
import java.util.Calendar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/timeUntilActivation")
public class TimeUntilActivationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar now = Calendar.getInstance();

        // 활성화 시간 (토요일 오후 2시)
        Calendar activationTime = (Calendar) now.clone();
        activationTime.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        activationTime.set(Calendar.HOUR_OF_DAY, 14);
        activationTime.set(Calendar.MINUTE, 0);
        activationTime.set(Calendar.SECOND, 0);
        activationTime.set(Calendar.MILLISECOND, 0);

        // 현재 시간이 활성화 시간 이후면 다음 주 활성화 시간으로 이동
        if (now.after(activationTime)) {
            activationTime.add(Calendar.WEEK_OF_YEAR, 1);
        }

        long diffMillis = activationTime.getTimeInMillis() - now.getTimeInMillis();
        long hours = diffMillis / (1000 * 60 * 60);
        long minutes = (diffMillis / (1000 * 60)) % 60;

        // 남은 시간 JSP로 전달
        request.setAttribute("hours", hours);
        request.setAttribute("minutes", minutes);
        request.getRequestDispatcher("/timeDisplay.jsp").forward(request, response);
    }
}
