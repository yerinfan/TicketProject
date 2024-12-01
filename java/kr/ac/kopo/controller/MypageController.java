package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.dao.ClassDAO;
import kr.ac.kopo.vo.ClassVO;
import kr.ac.kopo.vo.MemberVO;

public class MypageController implements Controller {
    private ClassDAO classDAO;

    public MypageController() {
        classDAO = new ClassDAO();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user"); // 세션에서 MemberVO 가져오기
        System.out.println(user);
        
        if (user == null) {
            request.setAttribute("errorMessage", "로그인이 필요합니다.");
            return "/ticket/member/loginForm.jsp"; // 로그인 페이지로 리다이렉트
        }

        String userId = user.getUserId(); // MemberVO에서 userId 추출
        System.out.println("현재 로그인된 userId: " + userId);

        // 사용자 예약 정보 조회
        List<ClassVO> reservedSeats = classDAO.getReservedSeats(userId);
        request.setAttribute("reservedSeats", reservedSeats);

        return "/ticket/member/myPage.jsp"; // 마이페이지로 이동
    }
}
