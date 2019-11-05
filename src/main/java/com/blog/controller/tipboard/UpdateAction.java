package com.blog.controller.tipboard;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.controller.Action;
import com.blog.controller.ActionForward;
import com.blog.dao.TipBoardAttachDao;
import com.blog.dao.TipBoardDao;
import com.blog.vo.TipBoardAttachVO;
import com.blog.vo.TipBoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UpdateAction");
		
		ActionForward forward = new ActionForward();
		
		// 로그인 안한 사용자면 글목록으로 이동시키기
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("id");
		
		if (id == null) {
			 forward.setPath("tipboardForm.do");
			 forward.setRedirect(true);
			 return forward;
		}
		
		//=============== 파일 업로드수행 =================
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
		
		
		//=============== 게시글 수정 처리 시작 =================
		// 파라미터값 가져오기
		String pageNum = multi.getParameter("pageNum");
		
		// 자바빈 객체 생성
		TipBoardVO tipBoardVO = new TipBoardVO();
		
		tipBoardVO.setNum(Integer.parseInt(multi.getParameter("num")));
		tipBoardVO.setId(multi.getParameter("id"));
		tipBoardVO.setSubject(multi.getParameter("subject"));
		tipBoardVO.setContent(multi.getParameter("content"));
		
		// TipBoardDao 객체 준비
		TipBoardDao tipBoardDao = TipBoardDao.getInstance();
		
		
		// 게시글 수정하는 메소드 호출
		tipBoardDao.updateBoard(tipBoardVO);
		
		
		//=============== 첨부파일 DB처리 시작 =================
		// TipBoardAttachDao 객체 준비
		TipBoardAttachDao tipBoardAttachDao = TipBoardAttachDao.getInstance();
		
		// 업로드한 원본 파일이름
		String originalFileName = multi.getOriginalFileName("newimage");
		System.out.println("originalFileName: " + originalFileName);

		// 실제로 업로드된 파일이름
		String realFileName = multi.getFilesystemName("newimage");
		System.out.println("realFileName: " + realFileName);

		// 파일업로드 확인
		if (realFileName != null) { // 업로드 함
			// 자바빈 TipBoardAttachVO 객체 생성
			TipBoardAttachVO tipBoardAttachVO = new TipBoardAttachVO();
			
			UUID uuid = UUID.randomUUID();
			tipBoardAttachVO.setUuid(uuid.toString());
			tipBoardAttachVO.setFilename(realFileName);
			tipBoardAttachVO.setBno(tipBoardVO.getNum());
			
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
			// 첨부파일정보 한개 등록하는 메소드 호출
			tipBoardAttachDao.insertAttach(tipBoardAttachVO);
		}
		
		
		//=============== 삭제파일 삭제작업 시작 =================
		// 삭제할 파일정보 파라미터 가져오기
		String[] delFile = multi.getParameterValues("delFile");
		if (delFile != null) {
			for (String str : delFile) {
				String[] strArr = str.split("_");
				String uuid = strArr[0];
				String delFilename = strArr[1];
				System.out.println("uuid : " + uuid);
				System.out.println("delFilename : " + delFilename);
				
				// 파일 삭제하기
				File file = new File(realPath, delFilename);
				if (file.exists()) {
					file.delete();
				}
				
				// uuid레코드 삭제 메소드 호출
				tipBoardAttachDao.deleteAttach(uuid);
			}
		}
 		
		
		// 페이지 이동
		forward.setPath("tipboardForm.do?pageNum=" + pageNum);
		forward.setRedirect(true);
		return forward;
	}

}
