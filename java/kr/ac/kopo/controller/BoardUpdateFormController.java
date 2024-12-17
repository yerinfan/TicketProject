package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class BoardUpdateFormController implements Controller {
    private BoardService boardService;

    public BoardUpdateFormController() {
        boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        BoardVO board = boardService.selectByNo(no);
        request.setAttribute("board", board);
        return "/ticket/board/updateForm.jsp";
    }
}
