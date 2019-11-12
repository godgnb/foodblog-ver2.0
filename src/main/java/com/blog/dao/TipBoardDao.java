package com.blog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.blog.dao.mapper.TipboardMapper;
import com.blog.vo.TipBoardCommentVO;
import com.blog.vo.TipBoardVO;

public class TipBoardDao {

	private static TipBoardDao instance = new TipBoardDao();
	
	public static TipBoardDao getInstance() {
		return instance;
	}
	
	public TipBoardDao() {
	}
	
	
	// insert할 레코드의 번호 생성 메소드
	public int NextTipNum() {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			int bnum = mapper.NextTipNum();
			
			return bnum;
		}
	} // NextTipNum method
	
	
	// 게시글 한개 등록하는 메소드
	public void insertboardTip(TipBoardVO tipboardVO) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.insertboardTip(tipboardVO);
			sqlSession.commit();
		}
	} // insertboardTip method
	
	
	// 검색어로 검색된 행의 시작행번호부터 갯수만큼 가져오기(페이징)
	public List<TipBoardVO> getBoards(int startRow, int pageSize, String search) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			List<TipBoardVO> list = mapper.getBoards(startRow, pageSize, search);
			
			return list;
		}
	} // getBoards method
	
	
	// 검색어로 게시판(board) 테이블 레코드 개수 가져오기 메소드
	public int getBoardCount(String search) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			int count = mapper.getBoardCount(search);
			
			return count;
		}
	} // getBoardCount method
	
	
	// 특정 레코드의 조회수를 1증가시키는 메소드
	public void updateReadCount(int num) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.updateReadCount(num);
			
			sqlSession.commit();
		}
	} // updateReadCount method
	
	
	// 게시글 한개를 가져오는 메소드
	public TipBoardVO getboardTip(int num) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			TipBoardVO tipBoardVO = mapper.getboardTip(num);
			
			return tipBoardVO;
		}
	} // getboardTip method
	
	
	// 게시글 패스워드 비교 메소드
	public boolean isPasswdEqual(int num, String passwd) {
		boolean isPasswdEqual = false;
		
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			int count = mapper.isPasswdEqual(num, passwd);
			if (count == 1) {
				isPasswdEqual = true;
			} else {
				isPasswdEqual = false;
			}
		}
		return isPasswdEqual;
	} // isPasswdEqual method
	
	
	// 게시글 수정하기 메소드
	public void updateBoard(TipBoardVO tipBoardVO) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.updateBoard(tipBoardVO);
			
			sqlSession.commit();
		}
	} // UpdateBoard method
	
	
	// 게시글 삭제하기 메소드
	public void deleteBoard (int num) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.deleteBoard(num);
			
			sqlSession.commit();
		}
	} // deleteBoard method
	
	
	//=================== 게시글 댓글 작업 ================
	
	// insert할 게시물의 댓글번호 생성 메소드
	public int nextCommentNum() {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			int bnum = mapper.nextCommentNum();
			
			return bnum;
		}
	} // nextCommentNum method
	
	
	// 게시글에 댓글 한개 등록하는 메소드
	public void insertComment(TipBoardCommentVO tipboardcommentVO) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.insertComment(tipboardcommentVO);
			
			sqlSession.commit();
		}
	} // insertComment method
	

	// 게시글 댓글 출력하는 메소드
	public List<TipBoardCommentVO> getComments(int num, int startRow, int pageSize) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			List<TipBoardCommentVO> list = mapper.getComments(num, startRow, pageSize);
			
			return list;
		}
	} // getComments method

	
	// 특정 레코드의 댓글수를 1증가시키는 메소드
	public void commCountUp(int num) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.commCountUp(num);
			
			sqlSession.commit();
		}
	} // commCountUp method
	
	
	// 특정 레코드의 댓글수를 1감소시키는 메소드
	public void commCountDown(int num) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.commCountDown(num);
			
			sqlSession.commit();
		}
	} // commCountDown method
	
	// 댓글 삭제하기 메소드
	public void deleteComment(int renum) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.deleteComment(renum);
			
			sqlSession.commit();
		}
	} // deleteComment method
	
	
	// 댓글 한개를 가져오는 메소드
	public TipBoardCommentVO getComment(int reNum) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			TipBoardCommentVO tipBoardCommentVO = mapper.getComment(reNum);
			
			return tipBoardCommentVO;
		}
	} // getComment method
	
	
	// 댓글 수정하기 메소드
	public void editComment(TipBoardCommentVO tipBoardCommentVO) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			mapper.editComment(tipBoardCommentVO);
			
			sqlSession.commit();
		}
	} // UpdateBoard method
	
	
	// 특정 게시글 댓글 개수 가져오기 메소드
	public int getCommentCount(int num) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
			TipboardMapper mapper = sqlSession.getMapper(TipboardMapper.class);
			
			int count = mapper.getCommentCount(num);
			
			return count;
		}
	} // getCommentCount method
	
} // TipBoardDao class
