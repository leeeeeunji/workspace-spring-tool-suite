package com.itwill.ej_final_project.dao;

import java.util.List;

import com.itwill.ej_final_project.dto.TripBoardComment;

public interface TripBoardCommentDao {
	/*
	 * 댓글 추가
	 */
	int insertTripBoardComment(TripBoardComment tripBoardComment) throws Exception;
	
	/*
	 * 댓글 수정
	 */
	int updateTripBoardComment(TripBoardComment tripBoardComment) throws Exception;
	
	/*
	 * 댓글 삭제
	 */
	int deleteTripBoardComment(int tCoNo) throws Exception;
	
	/*
	 * 댓글 1개 보기
	 */
	TripBoardComment selectByNo(int tCoNo) throws Exception;
	
	/*
	 * 댓글 리스트
	 */
	List<TripBoardComment> selectAll() throws Exception;
	
	/*
	 * 댓글 총 개수
	 */
	int selectAllCount() throws Exception;
	
}
