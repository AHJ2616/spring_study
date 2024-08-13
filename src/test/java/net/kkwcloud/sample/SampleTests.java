package net.kkwcloud.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;

//테스트 코드에 필수 3가지
@RunWith(SpringJUnit4ClassRunner.class)  //Run as > test 가능 하게 만들어 준다.(메서드 별로 test가 가능하다)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml") //참조 파일
@Log4j2 // log출력
public class SampleTests {
	
	@Setter(onMethod_ = @Autowired)
	private Restaurant restaurant; //인스턴스 생성

	@Test // 메서드별로 테스트가 가능해진다(메서드 명 블럭설정 후 Run as -> junit
    public void test_exist() {
		assertNotNull(restaurant); // assertNotNull : junit 값이 null인지 확인해준다.
		
		log.info(restaurant);
		log.info("-----------");
		log.info(restaurant.getChef());
		
	}	
	
	
}//class end
