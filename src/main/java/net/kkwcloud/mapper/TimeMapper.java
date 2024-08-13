package net.kkwcloud.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	// Mybatis는 query문 처리를 xml + interface 로 한다.
	// interface에는 호출할 추상 method명 작성
	// xml파일에는 같은 이름으로 query를 만든다.
	
	
	
	
	
	public String getTime_xml(); // resources/net/kkwcloud/mapper/TimeMapper.xml 의 query를 실행한다.
	
	
	//xml이 필수는 아니다. mybatis가 알아서 추상method를 만들어서 적용시킨다.
	@Select("select sysdate from dual")
	public String getTime();
	
	
}//class end
