package com.myspring.pro27.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.vo.MemberVO;

//RedirectAttribute이용해 재요청시 로그인창으로 로그인 실패 메세지를 매개변수로 전달할 수 있음

public interface MemberController {
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView addMember(@ModelAttribute("info") MemberVO memberVO,HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView removeMember(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, HttpServletRequest request, HttpServletResponse response) throws Exception;
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
