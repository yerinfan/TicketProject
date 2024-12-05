package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class RegisterActionController implements Controller {
    private MemberService memberService;

    public RegisterActionController() {
        memberService = new MemberService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String nickname = request.getParameter("nickname");
        // 사용자 정보를 VO로 변환
        MemberVO newMember = new MemberVO(userId, name, password, email, nickname);

        // 회원 등록
        boolean isSuccess = memberService.registerMember(newMember);

        if (isSuccess) {
            request.setAttribute("message", "회원 등록이 완료되었습니다.");
            return "/ticket/member/loginForm.jsp"; // 로그인 페이지로 이동
        } else {
            request.setAttribute("message", "회원 등록에 실패하였습니다. 다시 시도해주세요.");
            return "/ticket/member/registerForm.jsp"; // 회원 등록 페이지로 이동
        }
    }
}
