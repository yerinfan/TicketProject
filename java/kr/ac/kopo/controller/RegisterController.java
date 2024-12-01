package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class RegisterController implements Controller {

    private MemberDAO memberDAO;

    public RegisterController() {
        memberDAO = new MemberDAO();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 폼 데이터 수집
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");

        // VO 생성
        MemberVO member = new MemberVO();
        member.setUserID(userId);
        member.setName(name);
        member.setEmail(email);
        member.setNickname(nickname);

        // DB 저장
        boolean success = memberDAO.insertMember2(member);
        if (success) {
            request.setAttribute("message", "회원 가입 성공!");
            request.getSession().setAttribute("user", member);
            return "/index.jsp";
        } else {
            request.setAttribute("message", "회원 가입 실패. 다시 시도해주세요.");
            return "/ticket/member/register.jsp";
        }
    }
}
