package com.itwill.my_real_korea.dao.tour;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tour.TourReview;
import com.itwill.my_real_korea.mapper.TourReviewMapper;

@Repository
public class TourReviewDaoImpl implements TourReviewDao {
	@Autowired
	private TourReviewMapper tourReviewMapper;
	
	public TourReviewDaoImpl() {
		System.out.println("TourReviewDaoImp 기본생성자 호출");
	}

	@Override
	public int insertTourReview(TourReview tourRiview) throws Exception {
		//투어상품 후기 추가
		return tourReviewMapper.insertTourReview(tourRiview);
	}

	@Override
	public List<TourReview> selectByToNo(int toNo) throws Exception {
		//투어상품번호로 후기 전체보기
		return tourReviewMapper.selectByToNo(toNo);
	}

	@Override
	public int updateTourReview(TourReview tourReview) throws Exception {
		//투어후기 수정
		return tourReviewMapper.updateTourReview(tourReview);
	}

	@Override
	public int deleteTourReview(int toReviewNo) throws Exception {
		//투어후기번호로 후기 삭제
		return tourReviewMapper.deleteTourReview(toReviewNo);
	}

	@Override
	public List<TourReview> selectByUserId(String userId) throws Exception {
		//사용자가 작성한 후기 전체보기
		return tourReviewMapper.selectByUserId(userId);
	}

	@Override
	public int findCountByToNo(int toNo) throws Exception {
		//투어상품번호로 찾은 투어 후기 갯수
		return tourReviewMapper.findCountByToNo(toNo);
	}

	@Override
	public int findCountByUserId(String userId) throws Exception {
		//사용자가 작성한 후기 갯수 
		return tourReviewMapper.findCountByUserId(userId);
	}
	
}
