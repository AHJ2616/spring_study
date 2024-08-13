package net.kkwcloud.sample;

import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

@Component //Spring 연결 -> webapp > spring > root-context.xml에서 context:conponent-scam에 패키지명 입력하기
@Data      //lombok 연결(setter,getter,toString() 등 생성)
public class Restaurant {

		//필드
	
	@Setter(onMethod_ = @Autowired) // setChef()를 컴파일 시 생성한다. @Autowired : 의존성 주입
	private Chef chef; //chef 인스턴스 생성
	
	private String restaurant_name;
	private Date open_time;
	private Date close_time;
	
	
	
	
	
}//class end
