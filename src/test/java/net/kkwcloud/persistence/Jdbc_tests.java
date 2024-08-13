package net.kkwcloud.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Jdbc_tests { //1,2,5단계 테스트한다

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log.info("1단계 성공");
			
		}catch(Exception e) {
			fail("Jdbc_tests 1단계 실패");
			fail(e.getMessage());
		}
		
	}
	@Test
	public void testConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","book","book");
			log.info(con); //객체의 주소를 log에 기록한다
			log.info("2단계 성공");
		} catch (SQLException e) {
			fail("Jdbc_tests 2단계 실패");
			fail(e.getMessage());
		}
		
	}
	
}//class end
