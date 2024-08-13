package net.kkwcloud.sample;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getter,setter,toString() 생성
@Component //스프링 연결
//@AllArgsConstructor : lombok에서 모든값을 받는 생성자가 만들어진다.
public class Chef {

	private String name; //chef 이름
	private int age; //chef 나이
	private Date reg_date; //chef 등록일
	
}//class end
