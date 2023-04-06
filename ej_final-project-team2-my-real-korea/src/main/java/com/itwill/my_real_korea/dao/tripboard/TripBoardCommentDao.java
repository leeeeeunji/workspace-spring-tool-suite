package com.itwill.my_real_korea.dao.tripboard;

import java.util.List;

import com.itwill.my_real_korea.dto.tripboard.TripBoardComment;

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
	 * N번 게시글의 댓글 전체 보기
	 */
	List<TripBoardComment> selectAllByTBoNo(int tBoNo) throws Exception;
	
	/*
	 * 댓글 총 개수
	 */
	int selectAllCount() throws Exception;
	
}
