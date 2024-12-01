package kr.ac.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.mybatis.MyConfig;
import kr.ac.kopo.vo.BoardVO;

public class BoardDAO {
	
	private SqlSession session;

	public BoardDAO() {
		session = new MyConfig().getInstance();
	}
	
	// 전체게시글 조회
	public List<BoardVO> selectAll() throws Exception {
		return session.selectList("kr.ac.kopo.dao.BoardDAO.selectAll");
	}
	
	// 게시글 번호로 상세 조회
	public BoardVO selectByNo(int no) throws Exception {
		   BoardVO boardVO = session.selectOne("kr.ac.kopo.dao.BoardDAO.selectByNo", no);
		    if (boardVO == null) {
		        System.out.println("조회된 게시글이 없습니다.");
		    } else {
		        System.out.println("조회된 게시글: " + boardVO);
		    }
		    return boardVO;
	}
	
	// 게시글 등록
	public void insert(BoardVO board) throws Exception {
		session.insert("kr.ac.kopo.dao.BoardDAO.insertBoard", board);
		session.commit(); // 데이터베이스 변경 사항 반영
	}
	
	// 수정
	public void update(BoardVO board) throws Exception {
	    session.update("kr.ac.kopo.dao.BoardDAO.updateBoard", board);
	    session.commit();
	}

	// 삭제
	public void delete(int no) throws Exception {
	    session.delete("kr.ac.kopo.dao.BoardDAO.deleteBoard", no);
	    session.commit();
	}

	// 답글 작성
	public void insertReply(BoardVO board) throws Exception {
	    session.insert("kr.ac.kopo.dao.BoardDAO.insertReply", board);
	    session.commit();
	}

	

}
