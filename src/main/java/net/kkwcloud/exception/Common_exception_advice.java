package net.kkwcloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice //Controller + 추가 기능 -> servlet-context.xml에 scan 코드를 넣어줘야 한다
@Log4j2 //로그처리
public class Common_exception_advice {
	//AOP(관심사의 분리)를 이용하여 예외처리를 관리한다.
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex,Model model) {
		log.error("except() 실행 : "+ex.getMessage()); //예외처리 메시지 log에 출력
		model.addAttribute("exception", ex); //예외처리를 model에 저장
		log.error(model); // log로 model 출력
		
		return "error_page"; // WEB-INF/spring/views/error_page.jsp에 model을 통해 Exception 정보 전송
	}
	
	@ExceptionHandler(NoHandlerFoundException.class) //404오류 발생 예외 처리
	@ResponseStatus(HttpStatus.NOT_FOUND) //404 상태 코드
	public String handle404(NoHandlerFoundException e) {
		
		
		
		return "error_page_404";
	}
	
	
}//class end
