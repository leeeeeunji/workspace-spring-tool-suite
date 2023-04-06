package com.itwill.my_real_korea.service.tripboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tripboard.TripBoardCommentDao;
import com.itwill.my_real_korea.dto.tripboard.TripBoardComment;

@Service
public class TripBoardCommentServiceImpl implements TripBoardCommentService {
	@Autowired
	private TripBoardCommentDao tripBoardCommentDao;
	
	public TripBoardCommentServiceImpl() {
		System.out.println(">>> TripBoardCommentServiceImpl 기본 생성자 호출");
	}
	
	/*
	 * 댓글 추가
	 */
	@Override
	public int insertTripBoardComment(TripBoardComment tripBoardComment) throws Exception {
		return tripBoardCommentDao.insertTripBoardComment(tripBoardComment);
	}
	
	/*
	 * 댓글 수정
	 */
	@Override
	public int updateTripBoardComment(TripBoardComment tripBoardComment) throws Exception {
		return tripBoardCommentDao.updateTripBoardComment(tripBoardComment);
	}
	
	/*
	 * 댓글 삭제
	 */
	@Override
	public int deleteTripBoardComment(int tCoNo) throws Exception {
		return tripBoardCommentDao.deleteTripBoardComment(tCoNo);
	}
	
	/*
	 * 댓글 1개 보기
	 */
	@Override
	public TripBoardComment selectByNo(int tCoNo) throws Exception {
		return tripBoardCommentDao.selectByNo(tCoNo);
	}
	
	/*
	 * N번 게시글의 댓글 전체 보기
	 */
	@Override
	public List<TripBoardComment> selectAllByTBoNo(int tBoNo) throws Exception {
		return tripBoardCommentDao.selectAllByTBoNo(tBoNo);
	}
	
	/*
	 * 댓글 총 개수
	 */
	@Override
	public int selectAllCount() throws Exception {
		return tripBoardCommentDao.selectAllCount();
	}
	
	
}
