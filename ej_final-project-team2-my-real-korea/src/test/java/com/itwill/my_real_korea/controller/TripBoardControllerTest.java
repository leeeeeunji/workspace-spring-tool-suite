package com.itwill.my_real_korea.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.service.tripboard.TripBoardService;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class TripBoardControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TripBoardService tripBoardService;
	
	@Disabled
	@Test
	void testTripBoard_list() throws Exception {
		//임의 list 생성
		PageMakerDto<TripBoard> tripBoardList = new PageMakerDto<TripBoard>();
		
		List<TripBoard> tripBoards = new ArrayList<TripBoard>();
		tripBoards.add(new TripBoard(1, "1", "1", null, 0, 0, 1, "1.png", null, null, "1", "1", new City(1, "서울", 1, 1), "1"));
		tripBoards.add(new TripBoard(2, "2", "2", null, 0, 0, 2, "2.png", null, null, "2", "2", new City(1, "서울", 1, 1), "2"));
		
		//tripBoardList에 tripBoards붙이기
		tripBoardList.setItemList(tripBoards);
		tripBoardList.setPageMaker(new PageMaker(1, 10));
		tripBoardList.setTotRecordCount(2);
		
		//selectAllTb()메소드 실행 시, tripBoardList가 return된다고 가정
		given(tripBoardService.selectAllTb(1)).willReturn(tripBoardList);
		
		mockMvc.perform(get("/tripboard-list")) // get 방식으로 요청
		.andExpect(status().isOk()) // HTTP 상태코드가 200 OK
		.andExpect(model().attributeExists("tripBoardList")) // model 에 setAttribute 한 값이 있는지
		.andExpect(model().attributeExists("pageNo")) // model 에 setAttribute 한 값이 있는지
		.andExpect(view().name("tripboard-list")) // notice-list 뷰를 반환하는지
		.andDo(print()); // 콘솔에 요청과 응답을 출력
		
		verify(tripBoardService).selectAllTb(1); // 메소드 호출되는지 검증
	}
	
	//@Test
	void testTripBoard_detail() throws Exception {
		// 임의로 tripBoard 만들기
		TripBoard tripBoard = new TripBoard(1, "1", "1", null, 0, 0, 1, "1.png", null, null, "1", "1", new City(1, "서울", 1, 1), "1");
		
		// selectByTbNo(1) 메소드 실행시 tripBoard 가 return 된다고 가정
		given(tripBoardService.selectByTbNo(1)).willReturn(tripBoard);
		
		mockMvc.perform(get("/tripboard-detail").param("tBoNo", "1"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("tripBoard"))
		.andExpect(model().attributeExists("tBoNo"))
		.andExpect(view().name("tripboard-detail"))
		.andDo(print());
		
		verify(tripBoardService).selectByTbNo(1);
	}
	
	//@Test
	void testTripBoard_write_form() throws Exception {
		mockMvc.perform(get("/tripboard-write-form"))
		.andExpect(status().isOk())
		.andExpect(view().name("tripboard-write-form"))
		.andDo(print());
	}
	
	//@Test
	void testTripBoard_modify_form() throws Exception {
		mockMvc.perform(get("/notice-modify-form"))
		.andExpect(status().isOk())
		.andExpect(view().name("tripboard-modify-form"))
		.andDo(print());
	}
}
