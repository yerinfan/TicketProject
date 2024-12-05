package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;
import kr.ac.kopo.vo.MemberVO;

public class BoardInsertController implements Controller {

	private BoardService boardService;

	public BoardInsertController() {
		boardService = new BoardService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        MemberVO user = (MemberVO) session.getAttribute("user");
        
		// 클라이언트로부터 전달받은 데이터
		String title = request.getParameter("title");
		String writer = user.getNickname();
		String content = request.getParameter("content");

		// BoardVO 객체에 데이터 설정
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);

		// 게시글 등록
		boardService.insertBoard(board);

		// 등록 성공 시 목록으로 리다이렉트
		return "redirect:/board/list.do";
	}
}
