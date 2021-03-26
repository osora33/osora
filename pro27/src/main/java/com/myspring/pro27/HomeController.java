package com.myspring.pro27;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// /main.do로 요청시  컨트롤러에서  <definition>태그에서 설정한 뷰이름 main을 타일즈 뷰 리졸버로 반환 합니다.
		return "main";
		
	}
	
	
	/*
	  웹브라우저로부터  컨텍스트패스명/ 뒤로 들어오는 모든  URL요청에 관하여 home()메소가 호출되어 실행됨.
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		//브라우저에서 요청한 시각을 JSP페이지로 전달하기 위해.. model객체에 저장
		model.addAttribute("serverTime", formattedDate );
		//뷰리졸버로  JSP이름을 반환합니다.
		return "home";
	}
	*/
}
