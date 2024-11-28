package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.BoardService;

public class BoardDeleteController implements Controller {
    private BoardService boardService;

    public BoardDeleteController() {
        boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String noParam = request.getParameter("no");

        // 파라미터 검증
        if (noParam == null || noParam.trim().isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 게시글 번호입니다.");
        }
        
        try {
            int no = Integer.parseInt(noParam);
            boardService.deleteBoard(no); // 게시글 삭제
            System.out.println("삭제된 게시글 번호: " + no);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("게시글 번호는 숫자여야 합니다.", e);
        }
        
        return "redirect:/board/list.do";
    }
}
