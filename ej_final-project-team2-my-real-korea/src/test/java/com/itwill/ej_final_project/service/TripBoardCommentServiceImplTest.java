package com.itwill.ej_final_project.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.ej_final_project.dto.TripBoardComment;
import com.itwill.ej_final_project.service.TripBoardCommentService;

//@SpringBootApplication
//@SpringBootTest
//@ComponentScan(basePackages = {"com.itwill.ej_final_project"})
class TripBoardCommentServiceImplTest {
	
	@Autowired
	private TripBoardCommentService tripBoardCommentService;
	
	void testInsertTripBoardComment() throws Exception {
		int rowCount = this.tripBoardCommentService.insertTripBoardComment(new TripBoardComment(0, "추가추가", new Date(), 1, "user3" ));
		assertEquals(rowCount, 1);
	}
	
	void testUpdateTripBoardComment() throws Exception {
		TripBoardComment tripBoardComment = new TripBoardComment(2, "service수정", new Date(), 0, "user3");
		assertEquals(tripBoardCommentService.updateTripBoardComment(tripBoardComment), 1);
	}
	
	
	void testDeleteTripBoardComment() throws Exception {
		int rowCount = tripBoardCommentService.deleteTripBoardComment(8);
		assertEquals(rowCount, 1);
	}
	
	@Test
	void testSelectByNo() throws Exception {
		TripBoardComment tripBoardComment = tripBoardCommentService.selectByNo(1);
		System.out.println(tripBoardComment);
	}
	
	@Test
	void testSelectAll() throws Exception {
		List<TripBoardComment> tripBoardCommentList = tripBoardCommentService.selectAll();
		System.out.println(tripBoardCommentList);
	}
	
	@Test
	void testSelectAllCount() throws Exception {
		System.out.println(tripBoardCommentService.selectAllCount());
	}
	

}
