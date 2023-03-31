package com.itwill.my_real_korea.service;

import java.util.List;

import com.itwill.my_real_korea.dto.TripBoard;
import com.itwill.my_real_korea.dto.TripBoardListPageMakerDto;

public interface TripBoardService2 {
	/*
	 * 게시글 추가
	 */
	int insertTripBoard(TripBoard tripBoard) throws Exception;
	
	/*
	 * 게시글 수정
	 */
	int updateTripBoard(TripBoard tripBoard) throws Exception;
	
	/*
	 * 게시글 삭제
	 */
	int deleteTripBoard(int tBoNo) throws Exception;
	
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	TripBoard selectByTbNo(int tBoNo) throws Exception;
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	List<TripBoard> selectByTbStatusList(int pageStart, int pageEnd, int tBoStatus) throws Exception;
	
	TripBoardListPageMakerDto selectByTbStatusList(int currentPage, int tBoStatus) throws Exception;
	
	/*
	 * 게시글 지역별로 보기
	 */
	List<TripBoard> selectByCityNoList(int pageStart, int pageEnd, int cityNo) throws Exception;
	
	TripBoardListPageMakerDto selectByCityNoList(int currentPage, int cityNo) throws Exception;
	
	/*
	 * 게시글 해시태그별로 보기
	 */
	List<TripBoard> selectByHashtagList(int pageStart, int pageEnd, String hashtag) throws Exception;
	
	TripBoardListPageMakerDto selectByHashtagList(int currentPage, String hashtag) throws Exception;
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	List<TripBoard> selectAllOrderByDate(int pageStart, int pageEnd) throws Exception;
	
	TripBoardListPageMakerDto selectAllOrderByDate(int currentPage) throws Exception;
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	List<TripBoard> selectAllOrderByReadCount(int pageStart, int pageEnd) throws Exception;
	
	TripBoardListPageMakerDto selectAllOrderByReadCount(int currentPage) throws Exception;

	/*
	 * 게시판 리스트(게시물 시작번호~끝번호) - 페이징 처리
	 */
	List<TripBoard> selectAllTb(int pageStart, int pageEnd) throws Exception;
	
	TripBoardListPageMakerDto selectAllTb(int currentPage) throws Exception;
	
	/*
	 * 게시글  총 개수
	 */
	int selectAllTbCount() throws Exception;
	
	/*
	 * 모집상태별 게시글 개수
	 */
	int selectStatusCount(int tBoStatus) throws Exception;
	
	/*
	 * 지역별 게시글 개수
	 */
	int selectCityNoCount(int cityNo) throws Exception;
	
	/*
	 * 해시태그별 게시글 개수
	 */
	int selectHashtagCount(String hashtag) throws Exception;

	/*
	 * 게시글 조회수 1 증가
	 */
	int increaseTbReadCount(int tBoNo) throws Exception;
	
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	List<TripBoard> selectSearchTbList(int pageStart, int pageEnd, String keyword) throws Exception;
	
	TripBoardListPageMakerDto selectSearchTbList(int currentPage, String keyword) throws Exception;
	
	/*
	 * 검색된 게시글 총 개수
	 */
	int selectTbSearchCount(String keyword) throws Exception;
}
