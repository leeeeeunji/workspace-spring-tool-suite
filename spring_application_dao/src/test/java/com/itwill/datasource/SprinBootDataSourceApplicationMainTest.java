package com.itwill.datasource;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class SprinBootDataSourceApplicationMainTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	void contextLoad() {
		
	}
	@Test
	void dataSource() throws Exception {
		System.out.println("1.DataSource" + dataSource);
		System.out.println("2.Connection" + dataSource.getConnection());
	}

}
