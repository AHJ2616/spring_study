package net.kkwcloud.www;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */

@Data  //lombok
@Controller // 컨트롤러
@Log4j2     //log로 콘솔 출력(파일로 로그 영구 보관 가능)
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)  // http://localhost:포트/ 요청시 get으로 반응하는 method
	public String home(Locale locale, Model model) { //model : 스프의 메모리 영역
		
		log.info("Log4j2........................");
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // Model 영역에 데이터 저장
		
		return "home"; //src/main/webapp/views/home.jsp로 보낸다
	}
	
}
