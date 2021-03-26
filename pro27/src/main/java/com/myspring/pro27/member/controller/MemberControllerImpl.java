package com.myspring.pro27.member.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;

//모든 회원정보 조회 -> http://localhost:8080/pro27/member/listMembers.do

//@Controller애너테이션기호를 이용해  MemberControllerImpl클래스에 대해..
//id가 memberController인 빈을 자동 생성합니다.
@Controller("memberController")
public class MemberControllerImpl   implements MemberController {
	
	//LoggerFactory클래스를 이용해 Logger클래스의 객체를 가져옵니다.
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	
	
	//Autowired애너테이션 기호를 이용해 setter메소드를 사용하지 않고
	//id가 memberService인  빈을 자동 주입합니다.
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO ; 
	
	@RequestMapping(value="/member/*Form.do", method=RequestMethod.GET)
	//로그인창 요청시 매개변수 result가 전송되면 변수 result에 값을 저장
	//최초로 로그인창을 요청할 때는 매개변수 result가 전송되지 않으므로 무시
	private ModelAndView form(@RequestParam(value="result", required=false) String result,
			HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그아웃 요청시 세션영역에 저장된 로그인정보와 조회한 회원정보를 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("sid");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");

		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	//로그인창에서 전송된 id와 비밀번호를 MemberVO객체에 담아 매개변수로 전달
	//ModelAndView객체에 "member"라는 이름으로 응답할 데이터 저장
	public ModelAndView login(@ModelAttribute("member") MemberVO member, 
			//RedirectAttributes클래스를 이용해 로그인 실패시 다시 로그인창으로 리다이렉트하여 실패 메세지를 전달
			RedirectAttributes rAttr, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		//login메소드를 호출하면서 입력한 아이디와 비밀번호가 저장된 MemberVO객체 전달
		memberVO = memberService.login(member);
		
		//memberVO변수에 저장된 데이터가 있으면 세션영역을 이용해 로그인 상태를 true로 설정
		if(memberVO != null) {
			HttpSession session = request.getSession();
			//세션영역에 조회한 회원 정보를 저장
			session.setAttribute("member", memberVO);
			
			String id = member.getId();
			session.setAttribute("sid", id);
			mav.setViewName("redirect:/member/listMembers.do");
		}else {
			//로그인 실패 시 실패 메세지를 로그인창으로 전달
			rAttr.addAttribute("result", "loginFailed");
			//로그인 실패 시 다시 로그인창으로 재요청(리다이렉트 방식)
			mav.setViewName("redirect:/member/loginForm.do");
		}
		
		return mav;
	}
							
	@Override
	@RequestMapping(value="/member/listMembers.do" ,method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//member/listMembers
		String viewName = getViewName(request);
		
		//System.out.println(viewName);//member/listMembers
		//Logger클래스의 info()메소드로 로그메세지 info레벨의 정보를 출력
		logger.info("info레벨 :   viewName = " + viewName);
		logger.debug("debug레벨 : msg= " + viewName);
		
		
		List membersList = memberService.listMembers();
		
		ModelAndView mav = new ModelAndView(viewName); // viewName이 <definition>태그에 설정한 name속성값(뷰의경로)와 일치 해야 합니다.
		
		mav.addObject("membersList", membersList);
		
		return mav;//ModelAndView객체에 설정한 뷰이름 /member/listMembers 를  타일즈 리졸버로 반환 합니다.
	}

	@Override
	@RequestMapping(value="/member/addMember.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do" ,method = RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
//웹브라우저에서 URL요청명에서 뷰리졸버 설정 없이 해당 폴더에 쉽게 접근할수 있도록
//MemberControllerImpl클래스를 열어 getViewName()메소드를 수정합니다.
//요청 URL에서 응답 JSP파일을 얻는 getViewName()메소드를 호출할 경우 
//fileName.lastIndextOf("/",1)을 사용해 JSP가 지정된 폴더 이름에 해당하는 첫 번쨰 요청부터 가져옵니다
//(/memberlistMembers.do로 요청할 경우에는 첫번째 요청명이 포함된  member/listMembers를 가져옵니다.)
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
		}
		if (viewName.lastIndexOf("/") != -1) {
			//  /member/listMembers.do로 요청할 경우  member/listMembers를 파일이름으로 가져옵니다.
			viewName = viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
	}


}
