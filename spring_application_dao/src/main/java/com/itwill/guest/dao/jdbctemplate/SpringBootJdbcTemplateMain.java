package com.itwill.guest.dao.jdbctemplate;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("A. JdbcTemplate : " + jdbcTemplate);
		System.out.println("B. JdbcTemplate DataSource : " + jdbcTemplate.getDataSource()); // = HikariDataSource
		//System.out.println("C. JdbcTemplate DataSource Connection : " + jdbctemplate.getDataSource().getConnection());
		
		System.out.println("1. JdbcTemplate 객체 얻기");
		/*************************************************************************
		 * select -> queryForObject 반환 타입[String, Wrapper, DTO(Guest. User)]
		 *************************************************************************/
		/*
		 * queryForObject[반환타입 DTO]
		 */
		String selectDtoSql = "select * from guest where guest_no=?";
		Object[] paramArray1 = {263};
		Object[] paramArray2 = new Object[]{263};
		
		/*
		<< BeanPropertyRowMapper 클래스 >>
			- ResultSet객체로부터 데이터를 컬럼 이름으로 get하여 Guest객체 생성 후,
			테이블 컬럼의 이름과 동일한 Guest객체의 property(멤버변수)에 대입(Injection)해주는 클래스
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper = new BeanPropertyRowMapper<Guest>(Guest.class);
		
		Guest guest = jdbcTemplate.queryForObject(selectDtoSql, 
												new Object[]{281}, 
												new int[]{Types.INTEGER},
												guestBeanPropertyRowMapper);
		
		System.out.println("queryForObject[Guest] : " + guest);
		
		/******************************************
		 * queryForObject[반환타입 String Wrapper]
		 ******************************************/
		String selectStringSql = "select guest_name from guest where guest_no=?";
		String guest_name = jdbcTemplate.queryForObject(selectStringSql, 
														new Object[] {244}, 
														new int[] {Types.INTEGER},
														String.class);
		
		System.out.println("-> queryForObject[String] : " + guest_name);
		
		
		/************************************************
		 * select -> query 반환타입[List<Dto>]
		 ************************************************/
		/*
		 * query[반환타입 List<Guest>]
		 */
		String selectDtoListSql = "select * from guest";
		List<Guest> guestList = jdbcTemplate.query(selectDtoListSql, guestBeanPropertyRowMapper);
		System.out.println("-> query[List<Guest>] : " + guestList);
		
		
		/*********************************************************
		 * select -> queryForList 반환타입[List<String, Wrapper>]
		 *********************************************************/
		String selectStringListSql = "select guest_name from guest";
		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql, String.class);
		System.out.println("-> queryForList[List<String>] : " + guest_nameList);
		
		
		/*********************************************************
		 * select -> queryForMap 반환타입[Map<String, Object>]
		 *********************************************************/
		String selectMapSql = "select * from guest where guest_no=?";
		Map rowMap = jdbcTemplate.queryForMap(selectMapSql, new Object[] {264}, new int[] {Types.INTEGER});
		System.out.println("-> queryForMap 반환타입[Map<Stirng, Object>] : " + rowMap);
		
		
		String selectMapListSql = "select * from guest";
		List rowMapList = jdbcTemplate.queryForList(selectMapListSql);
		System.out.println("-> queryForList 반환타입[List<Map<Stirng, Object>>] : " + rowMapList);
		
		
		
		/****************************************************************
		 * DML(update, delete, insert) -> update 반환타입[rowCount(int)]
		 ****************************************************************/
		String insertSql = "insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount = jdbcTemplate.update(insertSql, "조인성", "aa@naver.com", "www.aa.com", "케이크", "딸기");
		System.out.println("insert rowCount : " + rowCount);
		String updateSql = "update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		rowCount = jdbcTemplate.update(updateSql, "김인성", "bb@naver.com", "www.bb.com", "케익", "생크림", 200);
		System.out.println("update rowCount : " + rowCount);		
		String deleteSql = "delete from guest where guest_no=?";
		rowCount = jdbcTemplate.update(deleteSql, 290);
		System.out.println("delete rowCount : " + rowCount);
	}

}
