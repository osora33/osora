package com.myspring.pro27.board.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.board.service.BoardService;
import com.myspring.pro27.board.vo.BoardVO;

@Controller("BoardController")
public class BoardControllerImpl implements BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardControllerImpl.class);
	
	@Autowired
	private BoardService boardService;
	@Autowired
	BoardVO boardVO;
	
	@Override
	@RequestMapping(value="/board/listArticles.do", method=RequestMethod.GET)
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);
		
		List boardList = boardService.listArticles();
		
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("boardList", boardList);
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		mav.addObject("id", id);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/content.do", method=RequestMethod.GET)
	public ModelAndView viewArticle(@RequestParam(value="num", required=false) String articleno,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);
		
		BoardVO vo = new BoardVO();
		vo = boardService.viewContent(articleno);
		
		System.out.println("sql 결과 : " + vo);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("vo", vo);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/update.do", method=RequestMethod.GET)
	public ModelAndView updateArticle(@RequestParam(value="num", required=false) String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);
		
		BoardVO vo = new BoardVO();
		vo = boardService.viewContent(articleno);
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("vo", vo);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/update2.do", method=RequestMethod.POST)
	public ModelAndView updateArticle2(@ModelAttribute BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);
		
		boardService.updateArticle(vo);
		
		String contextPath = request.getContextPath();
		PrintWriter pw = response.getWriter();
		pw.println("<script> alert('수정 완료되었습니다'); location.href='"+contextPath+"/board/listArticles.do'</script>");
		pw.flush();
		
		return null;
	}
	
	@Override
	@RequestMapping(value="/board/write.do", method=RequestMethod.GET)
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);
		
		ModelAndView mav = new ModelAndView(viewName);
		
		return mav;
	}
	
	@Override
	@RequestMapping(value="/board/write2.do", method=RequestMethod.POST)
	public ModelAndView write2(@ModelAttribute BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sid");
		vo.setId(id);
		
		boardService.write(vo);
		
		String contextPath = request.getContextPath();
		PrintWriter pw = response.getWriter();
		pw.println("<script> alert('저장되었습니다'); location.href='"+contextPath+"/board/listArticles.do'</script>");
		pw.flush();
		
		return null;
	}
	
	@Override
	@RequestMapping(value="/board/delete.do", method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("num") String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);
		
		boardService.deleteArticle(articleno);
		
		String contextPath = request.getContextPath();
		PrintWriter pw = response.getWriter();
		pw.println("<script> alert('삭제되었습니다'); location.href='"+contextPath+"/board/listArticles.do'</script>");
		pw.flush();
		
		return null;
	}
	
	@Override
	@RequestMapping(value="/board/search.do", method=RequestMethod.GET)
	public ModelAndView search(@RequestParam("search") String search, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String viewName = getViewName(request);
		
		logger.info("info레벨 : viewName = " + viewName);
		logger.debug("debug레벨 : msg = " + viewName);
		
		List searchList = boardService.searchArticles(search);
		
		ModelAndView mav = new ModelAndView(viewName);
		
		mav.addObject("searchList", searchList);
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		mav.addObject("id", id);
		mav.addObject("search", search);
		
		return mav;
	}
	
	private String getViewName(HttpServletRequest request) throws Exception{
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if(uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}
		
		int begin = 0;
		if(!(contextPath == null || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}
		
		int end;
		if(uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		}else if(uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		}else {
			end = uri.length();
		}
		
		String viewName = uri.substring(begin, end);
		if(viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		
		if(viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/", 1), viewName.length());
		}
		return viewName;
	}
}
