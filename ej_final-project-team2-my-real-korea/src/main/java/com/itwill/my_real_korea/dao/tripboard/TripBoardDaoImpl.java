package com.itwill.my_real_korea.dao.tripboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.mapper.TripBoardMapper;

@Repository
public class TripBoardDaoImpl implements TripBoardDao{
	
	@Autowired
	private TripBoardMapper tripBoardMapper;
	
	public TripBoardDaoImpl() {
		System.out.println("TripBoardDaoImpl 기본 생성자 호출");
	}
	
	/*
	 * 게시글 추가
	 */
	@Override
	public int insertTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardMapper.insertTripBoard(tripBoard);
	}
	
	/*
	 * 게시글 수정
	 */
	@Override
	public int updateTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardMapper.updateTripBoard(tripBoard);
	}
	
	/*
	 * 게시글 삭제
	 */
	@Override
	public int deleteTripBoard(int tBoNo) throws Exception {
		return tripBoardMapper.deleteTripBoard(tBoNo);
	}
	
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	@Override
	public TripBoard selectByTbNo(int tBoNo) throws Exception {
		return tripBoardMapper.selectByTbNo(tBoNo);
	}
	
	/*
	 * 게시글 모집상태별로 보기 - 페이징 처리
	 */
	@Override
	public List<TripBoard> selectByTbStatusList(int pageStart, int pageEnd, int tBoStatus) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("tBoStatus", tBoStatus);
		return tripBoardMapper.selectByTbStatusList(pageMap);
	}
	
	/*
	 * 게시글 지역별로 보기 - 페이징 처리
	 */
	@Override
	public List<TripBoard> selectByCityNoList(int pageStart, int pageEnd, int cityNo) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("cityNo", cityNo);
		return tripBoardMapper.selectByCityNoList(pageMap);
	}
	
	/*
	 * 게시글 해시태크별로 보기 - 페이징 처리
	 */
	@Override
	public List<TripBoard> selectByHashtagList(int pageStart, int pageEnd, String hashtag) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("hashtag", hashtag);
		return tripBoardMapper.selectByHashtagList(pageMap);
	}
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순) - 페이징 처리
	 */
	@Override
	public List<TripBoard> selectAllOrderByDate(int pageStart, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		return tripBoardMapper.selectAllOrderByDate(pageMap);
	}
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순) - 페이징 처리
	 */
	@Override
	public List<TripBoard> selectAllOrderByReadCount(int pageStart, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		return tripBoardMapper.selectAllOrderByReadCount(pageMap);
	}
	
	/*
	 * 게시판 리스트(게시글 시작번호, 게시글 끝번호) - 페이징 처리
	 */
	@Override
	public List<TripBoard> selectAllTb(int pageStart, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		return tripBoardMapper.selectAllTb(pageMap);
	}
	
	/*
	 * 게시글  총 개수
	 */
	@Override
	public int selectAllTbCount() throws Exception {
		return tripBoardMapper.selectAllTbCount();
	}
	
	/*
	 * 모집상태별 게시글 개수
	 */
	@Override
	public int selectStatusCount(int tBoStatus) throws Exception {
		return tripBoardMapper.selectStatusCount(tBoStatus);
	}
	
	/*
	 * 지역별 게시글 개수
	 */
	@Override
	public int selectCityNoCount(int cityNo) throws Exception {
		return tripBoardMapper.selectCityNoCount(cityNo);
	}
	
	/*
	 * 해시태그별 게시글 개수
	 */
	@Override
	public int selectHashtagCount(String hashtag) throws Exception {
		return tripBoardMapper.selectHashtagCount(hashtag);
	}
	
	/*
	 * 게시글 조회수 1 증가
	 */
	@Override
	public int increaseTbReadCount(int tBoNo) throws Exception {
		return tripBoardMapper.increaseTbReadCount(tBoNo);
	}
	
	/*
	 * 키워드로 검색된 동행게시판 리스트 - 페이징 처리
	 */
	@Override
	public List<TripBoard> selectSearchTbList(int pageStart, int pageEnd, String keyword) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageStart", pageStart);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("keyword", keyword);
		return tripBoardMapper.selectSearchTbList(pageMap);
	}
	
	/*
	 * 검색된 게시글 총 개수
	 */
	@Override
	public int selectTbSearchCount(String keyword) throws Exception {
		return tripBoardMapper.selectTbSearchCount(keyword);
	}
	
}
