package com.itwill.ej_final_project.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.ej_final_project.dto.TripBoard;

@SpringBootApplication
@SpringBootTest
@MapperScan(basePackages = "com.itwill.ej_final_project.mapper")
class TripBoardDaoImplTest {

	@Autowired
	private TripBoardDao tripBoardDao;
	
	/*
	 * 게시글 추가
	 */
	//성공
	@Disabled
	@Test
	void testInsertTripBoard() throws Exception {
		int rowCount = tripBoardDao.insertTripBoard(new TripBoard(0, "테스트제목", "테스트내용", new Date(), 0, 1, 5, "테스트사진1.png", new Date(), new Date(), "무계획", "아무나다좋아", 2, "user1"));
		assertEquals(rowCount, 1);
	}
	
	/*
	 * 게시글 수정
	 */
	//성공
	@Disabled
	@Test
	void testUpdateTripBoard() throws Exception {
		int rowCount = tripBoardDao.updateTripBoard(new TripBoard(3, "제목수정", "내용수정", new Date(), 3, 0, 1, "수정사진1.png", new Date(), new Date(), "무계획", "아무나다좋아", 1, "user1"));
		assertEquals(rowCount, 1);
	}
	
	/*
	 * 게시글 삭제
	 */
	void testDeleteTripBoard() throws Exception {
		int rowCount = tripBoardDao.deleteTripBoard(1);
		assertEquals(rowCount, 1);
	}
	
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	//성공
	@Disabled
	@Test
	void testSelectByTbNo() throws Exception {
		assertNotNull(tripBoardDao.selectByTbNo(1));
		System.out.println(tripBoardDao.selectByTbNo(1));
	}
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	@Test
	void testSelectByTbStatusList() throws Exception {
		List<TripBoard> tripBoardList = tripBoardDao.selectByTbStatusList(0);
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시글 지역별로 보기
	 */
	//성공
	@Disabled
	@Test
	void testSelectByCityNoList() throws Exception {
		List<TripBoard> tripBoardList = tripBoardDao.selectByCityNoList(1);
		System.out.println(tripBoardList);
	}

	/*
	 * 게시글 해시태크별로 보기
	 */
	//성공
	@Disabled
	@Test
	void testSelectByHashtagList() throws Exception {
		List<TripBoard> tripBoardList = tripBoardDao.selectByHashtagList("인싸만");
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllOrderByDate() throws Exception {
		List<TripBoard> tripBoardList = tripBoardDao.selectAllOrderByDate();
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllOrderByReadCount() throws Exception {
		List<TripBoard> tripBoardList = tripBoardDao.selectAllOrderByReadCount();
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시판 리스트
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllTb() throws Exception {
		List<TripBoard> tripBoardList = tripBoardDao.selectAllTb();
		System.out.println(tripBoardList);
	}
	
	/*
	 * 게시글  총 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectAllTbCount() throws Exception {
		int rowCount = tripBoardDao.selectAllTbCount();
		assertEquals(rowCount, 3);
	}
	
	/*
	 * 모집상태별 게시글 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectStatusCount() throws Exception {
		int rowCount = tripBoardDao.selectStatusCount(0);
		assertEquals(rowCount, 3);
	}
	
	/*
	 * 지역별 게시글 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectCityNoCount() throws Exception {
		int rowCount = tripBoardDao.selectCityNoCount(1);
		assertEquals(rowCount, 1);
	}
	
	/*
	 * 해시태그별 게시글 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectHashtagCount() throws Exception {
		int rowCount = tripBoardDao.selectHashtagCount("인싸만");
		assertEquals(rowCount, 1);
	}
	
	
	/*
	 * 게시글 조회수 1 증가
	 */
	//성공
	@Disabled
	@Test
	void testIncreaseTbReadCount() throws Exception {
		int rowCount = tripBoardDao.increaseTbReadCount(3);
		assertEquals(rowCount, 1);
	}
	
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	//성공
	@Disabled
	@Test
	 void testSelectSearchTbList() throws Exception {
		 List<TripBoard> tripBoardList = tripBoardDao.selectSearchTbList("");
		 System.out.println(tripBoardList);
	 }
	
	
	/*
	 * 검색된 게시글 총 개수
	 */
	//성공
	@Disabled
	@Test
	void testSelectTbSearchCount() throws Exception {
		int rowCount = tripBoardDao.selectTbSearchCount("");
		assertEquals(rowCount, 3);
	}
	
}
