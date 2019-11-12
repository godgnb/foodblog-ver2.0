package com.blog.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.blog.vo.TipBoardAttachVO;

public interface TipboardAttachMapper {

	// 첨부파일 한개 등록하는 메소드
	public void insertAttach(TipBoardAttachVO tipBoardAttachVO);
	
	// 글번호에 해당하는 첨부파일정보 가져오기
	@Select("SELECT * FROM tipboardattach WHERE bno = #{bno}")
	public TipBoardAttachVO getAttach(int bno);
	
	// 파일 삭제하기 메소드 기준 bno
	@Delete("DELETE FROM tipboardattach WHERE bno = #{bno}")
	public void deleteAttachByBno(int bno);
	
	// 파일 삭제하기 메소드 호출 기준 uuid
	@Delete("DELETE FROM tipboardattach WHERE uuid = #{uuid}")
	public void deleteAttachByUuid(String uuid);
	
	
	
	
} // TipboardAttachMapper interface
