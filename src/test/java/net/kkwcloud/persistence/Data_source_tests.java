package net.kkwcloud.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.kkwcloud.mapper.TimeMapper;

@RunWith(SpringJUnit4ClassRunner.class)  //Run as > test 가능 하게 만들어 준다.(메서드 별로 test가 가능하다)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") //참조 파일
@Log4j2 // log출력
public class Data_source_tests {
	
	@Setter(onMethod_ = @Autowired)
	private DataSource datasource;
	
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@Test 
	public void test_mybotis() {//동적 query문 처리하는 sql mapping
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			Connection con = sqlSession.getConnection();
			log.info(sqlSession); //org.apache.ibatis.session.defaults.DefaultSqlSession@6482eef
			log.info(con); //HikariProxyConnection@533698361 wrapping oracle.jdbc.driver.T4CConnection@28952dea
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}//method end
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper time_mapper;
	
	@Test 
	public void get_time() {
		log.info(time_mapper.getClass().getName());
		//Class의 이름을 log에 출력
		// net.kkwcloud.persistence.Data_source_tests(get_time51) - com.sun.proxy.$Proxy38
		log.info(time_mapper.getTime());
		//select query가 있는 method
		//net.kkwcloud.persistence.Data_source_tests(get_time53) - 2024-08-13 15:58:57
		
	}//method end
	
	@Test 
	public void test_connection() {
		Connection connection;
		try {
			connection = datasource.getConnection();
			log.info(connection);
			
			//HikariProxyConnection@118504112 wrapping oracle.jdbc.driver.T4CConnection@4d7e7435
		} catch (SQLException e) {
			fail(e.getMessage()); //실패 처리 로그
		}

		
	}//method end

	@Test 
	public void test_getTime_xml() {
		log.info(time_mapper.getTime_xml());
		log.info(time_mapper.getClass().getName());
	}//method end
	
	//log4jdbc 적용 후 결과
	/*
	 * |--------------------| 
	 * |sysdate | 
	 * |--------------------| |
	 * 2024-08-13 16:42:21
	 * | |--------------------|
	 */
	
}
