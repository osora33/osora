package com.myspring.pro27.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.board.vo.BoardVO;
import com.myspring.pro27.board.vo.RippleVO;

public interface BoardController {
	public ModelAndView listArticles(@RequestParam(defaultValue= "1") int page, @RequestParam(defaultValue = "1") int range, 
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewArticle(@RequestParam("num") String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateArticle(@RequestParam("num") String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateArticle2(@ModelAttribute BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView write2(@ModelAttribute BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delete(@RequestParam("num") String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView search(@RequestParam("search") String search, 
			@RequestParam(defaultValue="1") int page, @RequestParam(defaultValue = "1") int range,
			HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView ripple(@ModelAttribute RippleVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView uripple(@ModelAttribute RippleVO vo, @RequestParam("articleno") int articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView deleter(@RequestParam("rno") int rno, @RequestParam("num") int articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
