package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class BoardUpdateController implements Controller {
    private BoardService boardService;

    public BoardUpdateController() {
        boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardVO board = new BoardVO();
        board.setNo(no);
        board.setTitle(title);
        board.setContent(content);

        boardService.updateBoard(board);
        return "redirect:/board/list.do";
    }
}
