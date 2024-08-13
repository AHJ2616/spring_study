package net.kkwcloud.sample;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Component
@ToString
@Getter
@Log4j2
//@AllArgsConstructor //필드의 모든 값을 넣는 생성자 만들기
//@NoArgsConstructor //기본생성자
@RequiredArgsConstructor
public class Hotel {
	
	@NonNull
	private Chef chef;
	private String name;
	private Date age;
	
	

	
	
}//class end
