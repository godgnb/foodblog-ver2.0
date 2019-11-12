package com.blog.dao;

import org.apache.ibatis.session.SqlSession;

import com.blog.dao.mapper.TipboardAttachMapper;
import com.blog.vo.TipBoardAttachVO;

public class TipBoardAttachDao {
	

	private static TipBoardAttachDao instance = new TipBoardAttachDao();
	
	public static TipBoardAttachDao getInstance() {
		return instance;
	}
	
	public TipBoardAttachDao() {
	}
	
	// 첨부파일 한개 등록하는 메소드
	public void insertAttach(TipBoardAttachVO tipBoardAttachVO) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			TipboardAttachMapper mapper = sqlSession.getMapper(TipboardAttachMapper.class);
			
			mapper.insertAttach(tipBoardAttachVO);
			
			sqlSession.commit();
		}
	} // insertAttach method
	
	
	// 글번호에 해당하는 첨부파일정보 가져오기
	public TipBoardAttachVO getAttach(int bno) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			TipboardAttachMapper mapper = sqlSession.getMapper(TipboardAttachMapper.class);
			
			TipBoardAttachVO tipBoardAttachVO = mapper.getAttach(bno);
			
			return tipBoardAttachVO;
		}
	} // getAttaches method
	
	
	// 파일 삭제하기 메소드 기준 bno
	public void deleteAttach(int bno) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			TipboardAttachMapper mapper = sqlSession.getMapper(TipboardAttachMapper.class);
			
			mapper.deleteAttachByBno(bno);
			
			sqlSession.commit();
		}
	} // deleteAttach method
	
	
	// 파일 삭제하기 메소드 호출 기준 uuid
	public void deleteAttach(String uuid) {
		// Connection 가져오기
		try (SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession()) {
			TipboardAttachMapper mapper = sqlSession.getMapper(TipboardAttachMapper.class);
			
			mapper.deleteAttachByUuid(uuid);
			
			sqlSession.commit();
		}
	} // deleteAttach method
	
} // TipBoardAttachDao class
