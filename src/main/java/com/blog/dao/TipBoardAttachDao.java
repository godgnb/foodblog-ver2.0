package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.DBManager;
import com.blog.dao.TipBoardAttachDao;
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
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql  = "INSERT INTO tipboardattach (uuid, filename, filetype, bno) ";
			sql += "VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tipBoardAttachVO.getUuid());
			pstmt.setString(2, tipBoardAttachVO.getFilename());
			pstmt.setString(3, tipBoardAttachVO.getFiletype());
			pstmt.setInt(4, tipBoardAttachVO.getBno());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}

	} // insertAttach method
	
	
	// 글번호에 해당하는 첨부파일정보 가져오기
	public TipBoardAttachVO getAttach(int bno) {
		TipBoardAttachVO tipBoardAttachVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "SELECT * FROM tipboardattach WHERE bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				tipBoardAttachVO = new TipBoardAttachVO();
				tipBoardAttachVO.setBno(rs.getInt("bno"));
				tipBoardAttachVO.setUuid(rs.getString("uuid"));
				tipBoardAttachVO.setFilename(rs.getString("filename"));
				tipBoardAttachVO.setFiletype(rs.getString("filetype"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return tipBoardAttachVO;
	} // getAttaches method
	
	
	// 파일 삭제하기 메소드 기준 bno
	public void deleteAttach(int bno) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "DELETE FROM tipboardattach WHERE bno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
	} // deleteAttach method
	
	
	// 파일 삭제하기 메소드 호출 기준 uuid
	public void deleteAttach(String uuid) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "DELETE FROM tipboardattach WHERE uuid = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uuid);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
	} // deleteAttach method
	
} // TipBoardAttachDao class
