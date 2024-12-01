package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO;

public class BoardService {
    private BoardDAO boardDao;

    public BoardService() {
        System.out.println("BoardDAO 생성");
        boardDao = new BoardDAO();
    }

    // 전체 게시글 조회
    public List<BoardVO> searchAllBoard() throws Exception {
        return boardDao.selectAll();
    }

    // 게시글 상세 조회
    public BoardVO selectByNo(int no) throws Exception {
        return boardDao.selectByNo(no);
    }

    // 게시글 등록
    public void insertBoard(BoardVO board) throws Exception {
        boardDao.insert(board);
    }

    // 게시글 수정
    public void updateBoard(BoardVO board) throws Exception {
        boardDao.update(board);
    }

    // 게시글 삭제
    public void deleteBoard(int no) throws Exception {
        boardDao.delete(no);
    }

    // 답변 게시글 등록
    public void replyBoard(BoardVO replyBoard) throws Exception {
        boardDao.insert(replyBoard); // 답변 글도 새 글로 등록
    }
}
