package com.itwill.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BasicAuthenticationTest {

	@LocalServerPort
	int port;
	RestTemplate client = new RestTemplate();

	private String greetingUrl() {
		return "http://localhost:" + port + "/greeting";
	}

	@DisplayName("1. 인증 실패")
	@Test
	void test_1() {
		String message = client.getForObject(greetingUrl(), String.class);
		System.out.println(message);
	}

	@DisplayName("2. 인증 성공")
	@Test
	void test_2() {
		System.out.println(">>>" + Base64.getEncoder().encodeToString("user1:1111".getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("user1:1111".getBytes()));

		HttpEntity entity = new HttpEntity(null, headers);

		ResponseEntity<String> responseEntity = 
				client.exchange(greetingUrl(), HttpMethod.GET, entity, String.class);
		System.out.println(">>>> " +responseEntity.getBody());
		
	}

	@DisplayName("3. 인증성공2 ")
	@Test
	void test_3() {
		TestRestTemplate testRestTemplate= new TestRestTemplate("user1","1111");
		String response = testRestTemplate.getForObject(greetingUrl(), String.class);
		System.out.println(">>> "+response);
	}

	@DisplayName("4. POST 인증")
	@Test
	void test_4() {
		TestRestTemplate testRestTemplate= new TestRestTemplate("user1","1111");
		ResponseEntity<String> responseEntity = 
				testRestTemplate.postForEntity(greetingUrl(), "guard",String.class);
		System.out.println(">>> "+responseEntity.getBody());
	}

}
