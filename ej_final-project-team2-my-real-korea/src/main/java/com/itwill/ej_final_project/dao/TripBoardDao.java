package com.itwill.ej_final_project.dao;

import java.util.List;
import java.util.Map;

import com.itwill.ej_final_project.dto.TripBoard;

public interface TripBoardDao {
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
	int deleteTripBoard(int tbNo) throws Exception;
	
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	TripBoard selectByTbNo(int tbNo) throws Exception;
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	TripBoard selectByTbStatus(int tbStatus) throws Exception;

	/*
	 * 게시글 지역별로 보기
	 */
	TripBoard selectByCityNo(int cityNo) throws Exception;
	
	/*
	 * 게시글 해시태그별로 보기
	 */
	TripBoard selectByHashtag(int tbHashtag) throws Exception;
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	List<TripBoard> selectAllOrderByDate(int pageBegin, int pageEnd) throws Exception;
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	List<TripBoard> selectAllOrderByReadCount(int pageBegin, int pageEnd) throws Exception;

	/*
	 * 게시판 리스트(게시물 시작번호~끝번호) - 페이징 처리
	 */
	List<TripBoard> selectAllTb(int pageBegin, int pageEnd) throws Exception;

	/*
	 * 게시글 조회수 1 증가
	 */
	int increaseTbReadCount(int tbNo) throws Exception;
	
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	List<TripBoard> selectSearchTbList(int pageBegin, int pageEnd, String tbKeyword) throws Exception;
	
	/*
	 * 검색된 게시글 총 개수
	 */
	int selectTbSearchCount(String tbKeyword) throws Exception;
}
