package com.blog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.blog.dao.mapper.MemberMapper;
import com.blog.vo.MemberVO;

public class MemberDao {

private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	public MemberDao() {
	}
	
	// 아이디 중복여부 확인 메소드
	public boolean isIdDupCheck(String id) {
		boolean isIdDupCheck = false;
		
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 아이디중복 확인
		int count = mapper.isIdDupCheck(id);
		if (count > 0) {
			isIdDupCheck = true;
		}
		// JDBC 자원 닫기
		sqlSession.close();
		
		return isIdDupCheck;
	} // isIdDupCheck
	
	
	// 회원가입 메소드
	public void insertMember(MemberVO memberVO) {
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 회원 가입(추가)
		mapper.insertMember(memberVO);
		// 커밋(JDBC수동커밋 사용할때)
		sqlSession.commit();
		// JDBC 자원 닫기
		sqlSession.close();
	} // insertMember
	
	
	// 회원정보 불러오는 메소드 호출
	public MemberVO getMember(String id) {
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 회원 정보 가져오기
		MemberVO memberVO = mapper.getMember(id);
		// JDBC 자원 닫기
		sqlSession.close();
		
		return memberVO;
	} // getMember method
	
	
	// 해당 유저 비밀번호 확인 메소드
	public int userCheck(String id, String passwd) {
		int check = -1;
		
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 회원 정보 가져오기
		MemberVO memberVO = mapper.getMember(id);
		if (memberVO != null) {
			if (passwd.equals(memberVO.getPasswd())) {
				check = 1;
			} else {
				check = 0;
			}
		} else {
			check = -1;
		}
		// JDBC 자원 닫기
		sqlSession.close();
		
		return check;
	} // userCheck
	
	
	// 회원정보 수정하기 메소드
	public void updateMember(MemberVO memberVO) {
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 회원 정보 수정
		mapper.updateMember(memberVO);
		// JDBC 자원 닫기
		sqlSession.close();
	} // updateMember method
	
	
	// 회원정보 삭제하기 메소드
	public void deleteMember(String id) {
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 회원 정보 수정
		mapper.deleteMember(id);
		// JDBC 자원 닫기
		sqlSession.close();
	} // deleteMember method
	
	
	// 전체회원 목록 가져오기 메소드
	public List<MemberVO> getMembers (int startRow, int pageSize, String search) {
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 전체 회원 목록 가져오기
		List<MemberVO> list = mapper.getMembers(startRow, pageSize, search);
		
		return list;
	} // getMembers method
	
	
	// 전체 회원수 가져오기 메소드
	public int memberCount(String search) {
		int result = 0;
		
		// Connection 가져오기
		SqlSession sqlSession = DBManager.getSqlSessionFactory().openSession();
		// 인터페이스를 구현한 Mapper 프록시 객체를 만들어서 리턴함
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		// 전체 회원수 가져오기
		result = mapper.memberCount(search);
		
		return result;
	}
	
	
} // MemberDao class
