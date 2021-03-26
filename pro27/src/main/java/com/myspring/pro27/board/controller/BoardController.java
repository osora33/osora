package com.myspring.pro27.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.board.vo.BoardVO;

public interface BoardController {
	public ModelAndView listArticles(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView viewArticle(@RequestParam("num") String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateArticle(@RequestParam("num") String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView updateArticle2(@ModelAttribute BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView write(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView write2(@ModelAttribute BoardVO vo, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView delete(@RequestParam("num") String articleno, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView search(@RequestParam("search") String search, HttpServletRequest request, HttpServletResponse response) throws Exception;
}
