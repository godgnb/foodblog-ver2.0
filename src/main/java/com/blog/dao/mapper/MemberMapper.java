package com.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.vo.MemberVO;

public interface MemberMapper {

	// 아이디 중복여부 확인 메소드
	public int isIdDupCheck(String id);
	
	// 회원가입 메소드
	public void insertMember(MemberVO memberVO);
	
	// 회원정보 불러오는 메소드 호출
	public MemberVO getMember(String id);
	
	// 회원정보 수정하기 메소드
	public void updateMember(MemberVO memberVO);
	
	// 회원정보 삭제하기 메소드
	public void deleteMember(String id);
	
	// 전체회원 목록 가져오기 메소드
	public List<MemberVO> getMembers(@Param("startRow") int startRow, @Param("pageSize") int pageSize, @Param("search") String search);
	
	// 전체 회원수 가져오기 메소드
	public int memberCount(String search);
	
	
	
} // MemberMapper interface
