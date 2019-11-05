package com.blog.controller.tipboard;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardAttachDao;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardAttachVO;
import com.blog.vo.TipBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WriteAction");
		
		// COS 라이브러리를 이용해서 파일업로드

		// 업로드할 경로
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/upload");
		System.out.println("realpath: " + realPath);

		// 최대 업로드 파일크기
		int maxSize = 1024 * 1024 * 10;

		MultipartRequest multi = new MultipartRequest(
		 		request, realPath, maxSize, "utf-8",
		 		new DefaultFileRenamePolicy());
		
		
		//========= 게시판 글 등록 ==============
		
		// 자바빈 TipBoardVO 객체 생성
		TipBoardVO tipboardVO = new TipBoardVO();

		// 파라미터 찾아서 자바빈에 저장
		tipboardVO.setId(multi.getParameter("id"));
		tipboardVO.setPasswd(multi.getParameter("passwd"));
		tipboardVO.setSubject(multi.getParameter("subject"));
		tipboardVO.setContent(multi.getParameter("content"));

		tipboardVO.setRegDate(new Timestamp(System.currentTimeMillis()));
		tipboardVO.setIp(request.getRemoteAddr());

		// TipBoardDao 객체 준비
		TipBoardDao tipListDao = TipBoardDao.getInstance();

		// 게시글 번호 생성하는 메소드 호출
		int num = tipListDao.NextTipNum();

		tipboardVO.setNum(num);
		tipboardVO.setReadcount(0);
		tipboardVO.setCommcount(0);

		// 게시글 한개 등록하는 메소드 호출 insertboardTip(tipboardVO)
		tipListDao.insertboardTip(tipboardVO);
		
		
		// ========= 첨부파일 등록 ==============
		
		// 업로드한 원본 파일이름
		String originalFileName = multi.getOriginalFileName("imgfile");
		System.out.println("originalFileName: " + originalFileName);

		// 실제로 업로드된 파일이름
		String realFileName = multi.getFilesystemName("imgfile");
		System.out.println("realFileName: " + realFileName);

		// 파일업로드 확인
		if (realFileName != null) { // 업로드 함
			// 자바빈 TipBoardAttachVO 객체 생성
			TipBoardAttachVO tipBoardAttachVO = new TipBoardAttachVO();
			
			UUID uuid = UUID.randomUUID();
			tipBoardAttachVO.setUuid(uuid.toString());
			tipBoardAttachVO.setFilename(realFileName);
			tipBoardAttachVO.setBno(num);
			
			// 이미지 파일 여부 확인
			File file = new File(realPath, realFileName);
			String contentType = Files.probeContentType(file.toPath());
			boolean isImage = contentType.startsWith("image");
			if (isImage) {
				System.out.println("성공");
				tipBoardAttachVO.setFiletype("I"); // Image
			} else {
				System.out.println("실패");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('이미지파일만 등록가능합니다.');");
				out.println("history.back()';");
				out.println("</script>");
				out.close();
			}
			
			// TipBoardAttachDAO 객체 준비
			TipBoardAttachDao tipBoardAttachDao = TipBoardAttachDao.getInstance();
			
			// 첨부파일 한개 등록하는 메소드 호출
			tipBoardAttachDao.insertAttach(tipBoardAttachVO);
		
		}
		
		ActionForward forward = new ActionForward();
		forward.setPath("tipboardForm.do");
		forward.setRedirect(true);
		return forward;
	}

}
