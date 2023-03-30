package com.itwill.ej_final_project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ej_final_project.dao.TripBoardDao2;
import com.itwill.ej_final_project.dto.TripBoard;
import com.itwill.ej_final_project.dto.TripBoardListPageMakerDto;
import com.itwill.ej_final_project.util.PageMaker;

@Service
public class TripBoardServiceImpl2 implements TripBoardService2 {
	@Autowired
	private TripBoardDao2 tripBoardDao;
	
	public TripBoardServiceImpl2() {
		System.out.println(">>> TripBoardServiceImpl 기본 생성자 호출");
	}
	
	public TripBoardDao2 getTripBoardDao() {
		return tripBoardDao;
	}
	
	public void setTripBoardDao(TripBoardDao2 tripBoardDao) {
		System.out.println(">>> setTripBoardDao 호출");
		this.tripBoardDao  = tripBoardDao;
	}
	
	/*
	 * 게시글 추가
	 */
	@Override
	public int insertTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardDao.insertTripBoard(tripBoard);
	}
	/*
	 * 게시글 수정
	 */
	@Override
	public int updateTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardDao.updateTripBoard(tripBoard);
	}
	/*
	 * 게시글 삭제
	 */
	@Override
	public int deleteTripBoard(int tbNo) throws Exception {
		return tripBoardDao.deleteTripBoard(tbNo);
	}
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	@Override
	public TripBoard selectByTbNo(int tbNo) throws Exception {
		return tripBoardDao.selectByTbNo(tbNo);
	}
	/*
	 * 게시글 모집상태별로 보기
	 */
	@Override
	public TripBoardListPageMakerDto selectByTbStatusList(int currentPage, int tbStatus) throws Exception {
		int selectStatusCount = tripBoardDao.selectStatusCount(tbStatus);
		PageMaker pageMaker = new PageMaker(selectStatusCount, currentPage);
		List<TripBoard> tripBoardList = tripBoardDao.selectByTbStatusList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), tbStatus);
		TripBoardListPageMakerDto pageMakerBoardList = new TripBoardListPageMakerDto();
		pageMakerBoardList.writingList = tripBoardList;
		pageMakerBoardList.pageMaker = pageMaker;
		
		return pageMakerBoardList;
	}
	/*
	 * 게시글 지역별로 보기
	 */
	@Override
	public TripBoardListPageMakerDto selectByCityNoList(int currentPage, int cityNo) throws Exception {
		int selectCityNoCount = tripBoardDao.selectCityNoCount(cityNo);
		PageMaker pageMaker = new PageMaker(selectCityNoCount, currentPage);
		List<TripBoard> tripBoardList = tripBoardDao.selectByTbStatusList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), cityNo);
		TripBoardListPageMakerDto pageMakerBoardList = new TripBoardListPageMakerDto();
		pageMakerBoardList.writingList = tripBoardList;
		pageMakerBoardList.pageMaker = pageMaker;
		
		return pageMakerBoardList;
	}
	/*
	 * 게시글 해시태그별로 보기
	 */
	@Override
	public TripBoardListPageMakerDto selectByHashtagList(int currentPage, String tbHashtag) throws Exception {
		int selectHashtagCount = tripBoardDao.selectHashtagCount(tbHashtag);
		PageMaker pageMaker = new PageMaker(selectHashtagCount, currentPage);
		List<TripBoard> tripBoardList = tripBoardDao.selectByHashtagList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), tbHashtag);
		TripBoardListPageMakerDto pageMakerBoardList = new TripBoardListPageMakerDto();
		pageMakerBoardList.writingList = tripBoardList;
		pageMakerBoardList.pageMaker = pageMaker;
		
		return pageMakerBoardList;
	}
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	@Override
	public TripBoardListPageMakerDto selectAllOrderByDate(int currentPage) throws Exception {
		int totalRecordCount = tripBoardDao.selectAllTbCount();
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		List<TripBoard> tripBoardList = tripBoardDao.selectAllTb(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		TripBoardListPageMakerDto pageMakerBoardList = new TripBoardListPageMakerDto();
		pageMakerBoardList.writingList = tripBoardList;
		pageMakerBoardList.pageMaker = pageMaker;
		
		return pageMakerBoardList;
	}
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	@Override
	public TripBoardListPageMakerDto selectAllOrderByReadCount(int currentPage) throws Exception {
		int totalRecordCount = tripBoardDao.selectAllTbCount();
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		List<TripBoard> tripBoardList = tripBoardDao.selectAllTb(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		TripBoardListPageMakerDto pageMakerBoardList = new TripBoardListPageMakerDto();
		pageMakerBoardList.writingList = tripBoardList;
		pageMakerBoardList.pageMaker = pageMaker;
		
		return pageMakerBoardList;
	}
	/*
	 * 게시판 리스트
	 */
	@Override
	public TripBoardListPageMakerDto selectAllTb(int currentPage) throws Exception {
		int totalRecordCount = tripBoardDao.selectAllTbCount();
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		List<TripBoard> tripBoardList = tripBoardDao.selectAllTb(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		TripBoardListPageMakerDto pageMakerBoardList = new TripBoardListPageMakerDto();
		pageMakerBoardList.writingList = tripBoardList;
		pageMakerBoardList.pageMaker = pageMaker;
		
		return pageMakerBoardList;
	}
	
	/*
	 * 게시글  총 개수
	 */
	@Override
	public int selectAllTbCount() throws Exception {
		return tripBoardDao.selectAllTbCount();
	}
	/*
	 * 모집상태별 게시글 개수
	 */
	@Override
	public int selectStatusCount(int tbStatus) throws Exception {
		return tripBoardDao.selectStatusCount(tbStatus);
	}
	/*
	 * 지역별 게시글 개수
	 */
	@Override
	public int selectCityNoCount(int cityNo) throws Exception {
		return tripBoardDao.selectCityNoCount(cityNo);
	}
	/*
	 * 해시태그별 게시글 개수
	 */
	@Override
	public int selectHashtagCount(String tbHashtag) throws Exception {
		return tripBoardDao.selectHashtagCount(tbHashtag);
	}
	
	/*
	 * 게시글 조회수 1 증가
	 */
	@Override
	public int increaseTbReadCount(int tbNo) throws Exception {
		return tripBoardDao.increaseTbReadCount(tbNo);
	}
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	@Override
	public TripBoardListPageMakerDto selectSearchTbList(int currentPage, String tbKeyword) throws Exception {
		int totalRecordCount = tripBoardDao.selectTbSearchCount(tbKeyword);
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		List<TripBoard> tripBoardList = tripBoardDao.selectSearchTbList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), tbKeyword);
		TripBoardListPageMakerDto pageMakerBoardList = new TripBoardListPageMakerDto();
		pageMakerBoardList.writingList = tripBoardList;
		pageMakerBoardList.pageMaker = pageMaker;
		
		return pageMakerBoardList;
	}
	/*
	 * 검색된 게시글 총 개수
	 */
	@Override
	public int selectTbSearchCount(String tbKeyword) throws Exception {
		return tripBoardDao.selectTbSearchCount(tbKeyword);
	}

	@Override
	public List<TripBoard> selectByTbStatusList(int pageStart, int pageEnd, int tBoStatus) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBoard> selectByCityNoList(int pageStart, int pageEnd, int cityNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBoard> selectByHashtagList(int pageStart, int pageEnd, String hashtag) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBoard> selectAllOrderByDate(int pageStart, int pageEnd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBoard> selectAllOrderByReadCount(int pageStart, int pageEnd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBoard> selectAllTb(int pageStart, int pageEnd) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TripBoard> selectSearchTbList(int pageStart, int pageEnd, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
