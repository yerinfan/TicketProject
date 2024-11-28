package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class BoardDetailController implements Controller {

	private BoardService boardService;

	public BoardDetailController() {
		boardService = new BoardService();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDetailController 호출");
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("요청된 게시글 번호: " + no);
		
		BoardVO board = boardService.selectByNo(no);
		System.out.println("조회된 게시글: " + board);
		
		// 상세 정보를 request에 저장
		request.setAttribute("board", board);
		
		System.out.println("Request Attributes: " + request.getAttribute("board"));

		// 상세 페이지로 이동
		return "/ticket/board/detail.jsp";
	}

}
