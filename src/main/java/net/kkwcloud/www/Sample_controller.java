package net.kkwcloud.www;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;
import net.kkwcloud.domain.SampleDTO;
import net.kkwcloud.domain.SampleDTO_list;
import net.kkwcloud.domain.TodoDTO;

@Controller //servlet-context.xml의 코드가 읽는다.
@RequestMapping("/sample/*") // url이 생성된다.(localhost:80/sample/*)
@Log4j2
public class Sample_controller {
	
	
	/*
	 * @InitBinder //String -> Data 형변환 public void init_binder(WebDataBinder
	 * binder) { SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 * binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf,
	 * false)); }//method end
	 */
	
	
	
	// localhost/sample/ex06?title=study&due_date=2024-08-09&check=true
	@GetMapping("/ex06")
	public String ex06(TodoDTO tdto) {
		log.info("todo : " + tdto);
		return "ex06";
	}
	
	
	@RequestMapping("") // localhost/sample 요청시 실행되게 한다 
	//method return 이 void 면 경로와 같은 url.jsp파일을 찾는다. String으로 return을 하면 리턴에 있는 이름.jsp파일을 찾는다.
	public void basic() {
	log.info("Sample_controller.basic() 실행");		
	}
	
	// localhost/sample/basic2 -> views/sample/basic2.jsp를 연결
	@RequestMapping(value="/basic2", method= {RequestMethod.GET, RequestMethod.POST}) 
	public void basic_get2() {
		log.info("Sample_controller.basic_get2() 실행/ get+post방식의 호출");
	}
	
	// localhost/sample/basic -> views/sample/basic.jsp를 연결
	@GetMapping("/basic") 
	public void basic_get() {
		log.info("Sample_controller.basic_get() 실행 / get방식의 호출");
	}
	
	// localhost/sample/basic3 -> views/sample/basic3.jsp를 연결
	@PostMapping("/basic3")
	public void basic_post() {
		log.info("Sample_controller.basic_post() 실행 / post방식의 호출");
	}
	
	//localhost/sample/ex01(GetMapping의 주소) -> views/sample/ex01.jsp를 연결(return의 주소)
	@GetMapping("/ex01")
	public String ex01(SampleDTO sdto) {
		log.info("Sample_controller.ex01(SampleDTO sdto) 실행"+ sdto);
		return "ex01"; 
	}
	
	//localhost/sample/ex02(GetMapping의 주소) -> views/sample/ex02.jsp를 연결(return의 주소)
	//@RequestParam : 파라미터로 사용된 변수를 원하는 타입의 변수명에 저장시켜준다. 
	//(get에서는 String으로 받아서 int로 저장할 수 있다)
	@GetMapping("/ex02")
	public String ex02(@RequestParam("id") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex02";
	}
	
	//리스트 , 배열 처리
	//localhost/sample/ex03 (GetMapping의 주소) -> views/sample/ex03_list.jsp를 연결(return의 주소)
	@GetMapping("/ex03") //url명
	public String ex03_list(@RequestParam("index") ArrayList<String> ids) {
		//localhost/sample/ex03?index=111&index=222&index=333 를 get으로 받아서 Arraylist ids에 3개가 저장된다.
		log.info("ids : "+ ids);
		return "ex03_list"; // veiws에 연결될 .jsp명
	}
	
	//localhost/sample/ex04 (GetMapping의 주소) -> views/sample/ex04_array.jsp를 연결(return의 주소)
	@GetMapping("/ex04")
	public String ex04_array(@RequestParam("index") String[] ids) {
		log.info("ids : " + ids); //주소
		
		return "ex04_array";//views에 연결될 .jsp명
	}
	
	//localhost/sample/ex05 (GetMapping의 주소) -> views/sample/ex05_bean.jsp를 연결(return의 주소)
	@GetMapping("/ex05")
	public String ex05_bean(SampleDTO_list lists) {// ArrayList를 파라미터로 받는다
		//localhost/sample/ex05?lists[0].name=kkk&lists[0].age=50
		return "ex05_bean";
	}
	
}//class end
