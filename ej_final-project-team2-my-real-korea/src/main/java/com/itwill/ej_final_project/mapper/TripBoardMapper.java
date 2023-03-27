package com.itwill.ej_final_project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ej_final_project.dto.TripBoard;

@Mapper
public interface TripBoardMapper {

	/*
	 * 동행게시판 게시글 추가(insert)
	 */
	int insertTripBoard(TripBoard tripBoard) throws Exception;
	/*
	 * 동행게시판 게시글 수정(update)
	 */
	int updateTripBoard(TripBoard tripBoard) throws Exception;
	
	/*
	 * 동행게시판 게시글 삭제(delete)
	 */
	int deleteTripBoard(int tbNo) throws Exception;
	
	/*
	 * 게시글 번호로 게시물 1개 보기(select)
	 */
	
	/*
	 * 동행게시판 리스트(게시물 시작번호~끝번호) - 페이징 처리(select List)
	 */
	
	/*
	 * 동행게시판 게시글 조회수 1 증가(count)
	 */
	
	/*
	 * 키워드로 검색된 동행게시판 리스트(select List)
	 */
	
	/*
	 * 검색된 게시글 총 개수(select)
	 */
}
