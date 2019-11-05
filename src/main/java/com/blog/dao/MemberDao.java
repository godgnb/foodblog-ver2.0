package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.blog.dao.DBManager;
import com.blog.dao.MemberDao;
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
		
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "SELECT COUNT(*) FROM jspdb.member WHERE id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			
			count = rs.getInt(1);
			if (count == 1) {
				isIdDupCheck = true;
			} else {
				isIdDupCheck = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
		
		return isIdDupCheck;
	} // isIdDupCheck
	
	
	// 회원가입 메소드
	public int insertMember(MemberVO vo) {
		
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "INSERT INTO jspdb.member (id, passwd, name, phone, email, reg_date)";
			sql += " VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			pstmt.setTimestamp(6, vo.getRegdate());
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return rowCount;
	} // insertMember
	
	
	// 해당 유저 비밀번호 확인 메소드
	public int userCheck(String id, String passwd) {
		int check = -1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="";
		
		try {
			con = DBManager.getConnection();
			sql = "SELECT passwd FROM jspdb.member WHERE id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (passwd.equals(rs.getString("passwd"))) {
					check = 1;
				} else {
					check = 0;
				}
			} else {
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return check;
	} // userCheck
	
	
	// 회원정보 불러오는 메소드 호출
	public MemberVO getMember(String id) {
		MemberVO memberVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "SELECT * FROM jspdb.member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				memberVO = new MemberVO();
				
				memberVO.setId(rs.getString("id"));
				memberVO.setPasswd(rs.getString("passwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setRegdate(rs.getTimestamp("reg_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return memberVO;
	} // getMember method
	
	
	// 회원정보 수정하기 메소드
	public int updateMember(MemberVO memberVO) {
		int rowCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "UPDATE jspdb.member SET name = ?, phone = ?, email = ? WHERE id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getName());
			pstmt.setString(2, memberVO.getPhone());
			pstmt.setString(3, memberVO.getEmail());
			pstmt.setString(4, memberVO.getId());
			
			rowCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		return rowCount;
	} // updateMember method
	
	
	// 회원정보 삭제하기 메소드
	public int deleteMember(String id) {
		int rowCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "DELETE FROM jspdb.member WHERE id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt);
		}
		
		return rowCount;
	} // deleteMember method
	
	
	// 전체회원 목록 가져오기 메소드
	public List<MemberVO> getMembers (int startRow, int pageSize, String search) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		int endRow = startRow + pageSize - 1;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * ");
		sb.append("FROM jspdb.member ");
		sb.append("WHERE not id = 'admin' ");
		if (!(search == null || search.equals(""))) {
			sb.append("and id LIKE ? ");
		}
		sb.append("ORDER BY reg_date ");
		sb.append("LIMIT ? OFFSET ? ");
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			if (!(search == null || search.equals(""))) {
				pstmt.setString(1, "%" + search + "%");
				pstmt.setInt(2, pageSize);
				pstmt.setInt(3, startRow-1);
			} else {
				pstmt.setInt(1, pageSize);
				pstmt.setInt(2, startRow-1);
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPasswd(rs.getString("passwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setRegdate(rs.getTimestamp("reg_date"));
				
				list.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return list;
	} // getMembers method
	
	
	// 전체 회원수 가져오기 메소드
	public int memberCount(String search) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		try {
			con = DBManager.getConnection();
			sql = "SELECT count(*) FROM jspdb.member WHERE NOT id = 'admin' ";
			if (!(search == null || search.equals(""))) {
				sql += "and id LIKE ? ";
			}
			
			pstmt = con.prepareStatement(sql);
			
			if (!(search == null || search.equals(""))) {
				pstmt.setString(1, "%" + search + "%");
			}
			rs = pstmt.executeQuery();
			
			rs.next();
			
			result = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		return result;
	}
	
	
} // MemberDao class
