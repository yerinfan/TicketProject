package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class BoardReplyController implements Controller {
    private BoardService boardService;

    public BoardReplyController() {
        boardService = new BoardService();
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String whoseNoParam = request.getParameter("whoseNo");
    	if (whoseNoParam == null || whoseNoParam.isEmpty()) {
    	    throw new IllegalArgumentException("부모 게시글 번호(whoseNo)가 전달되지 않았습니다.");
    	}

    	int whoseNo = Integer.parseInt(whoseNoParam);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String writer = request.getParameter("writer");

        BoardVO board = new BoardVO();
        board.setWhoseNo(whoseNo);
        board.setTitle(title);
        board.setContent(content);
        board.setWriter(writer);

        boardService.replyBoard(board);
        return "redirect:/board/list.do";
    }
}
