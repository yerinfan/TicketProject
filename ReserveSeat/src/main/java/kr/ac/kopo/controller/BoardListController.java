package kr.ac.kopo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class BoardListController implements Controller {

	private BoardService boardService;

	public BoardListController() {
		boardService = new BoardService();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    List<BoardVO> boardList = boardService.searchAllBoard();

	    if (boardList == null || boardList.isEmpty()) {
	        System.out.println("boardList is null or empty");
	    } else {
	        System.out.println("boardList size: " + boardList.size());
	    }

	    request.setAttribute("boardList", boardList);
	    return "/ticket/board/list.jsp";
	}

}
