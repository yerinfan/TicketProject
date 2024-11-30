package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class RegistController implements Controller {
	
	 private MemberService memberService;

	    public RegistController() {
	        memberService = new MemberService();
	    }

	    @Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	        // 파라미터 유효성 검사
	        String userIdParam = request.getParameter("user_id");
	        String name = request.getParameter("name");
	        String password = request.getParameter("password");
	        String nickname = request.getParameter("nickname");
//	        System.out.println("1");
	        if (userIdParam == null || userIdParam.isEmpty() ||
	            name == null || name.isEmpty() ||
	            password == null || password.isEmpty() ||
	            nickname == null || nickname.isEmpty()) {
	            request.setAttribute("message", "모든 필드를 입력해주세요.");
	            return "/ticket/member/regist.jsp";
	        }
//	        System.out.println("2");
	        // 파라미터 변환 및 VO 객체 생성
	        String userId;
	        try {
	            userId = userIdParam;
	        } catch (NumberFormatException e) {
	            request.setAttribute("message", "유효하지 않은 사용자 ID입니다.");
	            return "/ticket/member/regist.jsp";
	        }
//	        System.out.println("3");
	        MemberVO member = new MemberVO(userId, name, password, nickname);

	        // DB에 회원 정보 저장
//	        System.out.println("4");
	        boolean success = memberService.registerMember(member);
//	        System.out.println("5");
	        // 성공 여부에 따라 페이지 이동
	        if (success) {
	        	System.out.println("회원 등록 성공");
	            request.setAttribute("message", "회원 가입 성공!");
	            return "/ticket/member/loginForm.jsp"; // 로그인 페이지로 이동
	        } else {
	        	System.out.println("회원 등록 실패");
	            request.setAttribute("message", "회원 가입 실패. 다시 시도해주세요.");
	            return "/ticket/member/regist.jsp"; // 회원가입 페이지로 다시 이동
	        }
	    }


}
