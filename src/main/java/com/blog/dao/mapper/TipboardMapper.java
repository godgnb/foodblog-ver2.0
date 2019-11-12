package com.blog.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.vo.TipBoardCommentVO;
import com.blog.vo.TipBoardVO;

public interface TipboardMapper {

	// insert할 레코드의 번호 생성 메소드
	public int NextTipNum();
	
	// 게시글 한개 등록하는 메소드
	public void insertboardTip(TipBoardVO tipboardVO);
	
	// 검색어로 검색된 행의 시작행번호부터 갯수만큼 가져오기(페이징)
	public List<TipBoardVO> getBoards(@Param("startRow") int startRow,@Param("pageSize") int pageSize,@Param("search") String search);
	
	// 검색어로 게시판(board) 테이블 레코드 개수 가져오기 메소드
	public int getBoardCount(String search);
	
	// 특정 레코드의 조회수를 1증가시키는 메소드
	public void updateReadCount(int num);
	
	// 게시글 한개를 가져오는 메소드
	public TipBoardVO getboardTip(int num);
	
	// 게시글 패스워드 비교 메소드
	public int isPasswdEqual(@Param("num") int num,@Param("passwd") String passwd);
	
	// 게시글 수정하기 메소드
	public void updateBoard(TipBoardVO tipBoardVO);
	
	// 게시글 삭제하기 메소드
	public void deleteBoard (int num);
	
	//=================== 게시글 댓글 작업 ================
	
	// insert할 게시물의 댓글번호 생성 메소드
	public int nextCommentNum();
	
	// 게시글에 댓글 한개 등록하는 메소드
	public void insertComment(TipBoardCommentVO tipboardcommentVO);
	
	// 게시글 댓글 출력하는 메소드
	public List<TipBoardCommentVO> getComments(@Param("num") int num,@Param("startRow") int startRow,@Param("pageSize") int pageSize);
	
	// 특정 레코드의 댓글수를 1증가시키는 메소드
	public void commCountUp(int num);
	
	// 특정 레코드의 댓글수를 1감소시키는 메소드
	public void commCountDown(int num);
	
	// 댓글 삭제하기 메소드
	public void deleteComment(int renum);
	
	// 댓글 한개를 가져오는 메소드
	public TipBoardCommentVO getComment(int reNum);
	
	// 댓글 수정하기 메소드
	public void editComment(TipBoardCommentVO tipBoardCommentVO);
	
	// 특정 게시글 댓글 개수 가져오기 메소드
	public int getCommentCount(int num);
	
	
} // TipboardMapper interface
