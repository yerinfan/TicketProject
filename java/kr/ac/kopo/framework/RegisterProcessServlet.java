package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class RegisterProcessServlet extends HttpServlet {

    private MemberDAO memberDAO = new MemberDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");

        MemberVO member = new MemberVO(userId, name, email, nickname);

        try {
            memberDAO.insertMember(member);
            request.getSession().setAttribute("user", member);
            response.sendRedirect("/ReserveSeat/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/ReserveSeat/member/register.jsp?error=exception");
        }
    }
}