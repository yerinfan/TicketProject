package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardReplyFormController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String noParam = request.getParameter("no");
        if (noParam == null || noParam.isEmpty()) {
            throw new IllegalArgumentException("게시글 번호(no)가 전달되지 않았습니다.");
        }
        int no = Integer.parseInt(noParam); // 게시글 번호
        System.out.println("부모 게시글 번호: " + no);
        
        request.setAttribute("whoseNo", no);
        return "/ticket/board/replyForm.jsp";
    }
}
