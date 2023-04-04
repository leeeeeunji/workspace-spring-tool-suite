package com.itwill.my_real_korea.service.tripboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.tripboard.TripBoardDao;
import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;

@Service
public class TripBoardServiceImpl implements TripBoardService {
	@Autowired
	private TripBoardDao tripBoardDao;
	
	public TripBoardServiceImpl() {
		System.out.println(">>> TripBoardServiceImpl 기본 생성자 호출");
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
	public int deleteTripBoard(int tBoNo) throws Exception {
		return tripBoardDao.deleteTripBoard(tBoNo);
	}
	/*
	 * 게시글 번호로 게시글 1개 보기
	 */
	@Override
	public TripBoard selectByTbNo(int tBoNo) throws Exception {
		return tripBoardDao.selectByTbNo(tBoNo);
	}
	
	/*
	 * 게시글 모집상태별로 보기
	 */
	@Override
	public PageMakerDto<TripBoard> selectByTbStatusList(int currentPage, int tBoStatus) throws Exception {
		//전체 글의 수
		int totalTripBoardCount = tripBoardDao.selectStatusCount(tBoStatus);
		// paging 계산 (PageMaker)
		PageMaker pageMaker = new PageMaker(totalTripBoardCount, currentPage);
		// 게시글 데이터 얻기
		List<TripBoard> tripBoardList = tripBoardDao.selectByTbStatusList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), tBoStatus);
		PageMakerDto<TripBoard> pageMakerTripBoardList = new PageMakerDto<TripBoard>(tripBoardList, pageMaker, totalTripBoardCount);
		return pageMakerTripBoardList;
	}
	
	/*
	 * 게시글 지역별로 보기
	 */
	@Override
	public PageMakerDto<TripBoard> selectByCityNoList(int currentPage, int cityNo) throws Exception {
		//전체 글의 수
		int totalTripBoardCount = tripBoardDao.selectCityNoCount(cityNo);
		// paging 계산 (PageMaker)
		PageMaker pageMaker = new PageMaker(totalTripBoardCount, currentPage);
		// 게시글 데이터 얻기
		List<TripBoard> tripBoardList = tripBoardDao.selectByCityNoList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), cityNo);
		PageMakerDto<TripBoard> pageMakerTripBoardList = new PageMakerDto<TripBoard>(tripBoardList, pageMaker, totalTripBoardCount);
		return pageMakerTripBoardList;
	}
	
	/*
	 * 게시글 해시태그별로 보기
	 */
	@Override
	public PageMakerDto<TripBoard> selectByHashtagList(int currentPage, String hashtag) throws Exception {
		//전체 글의 수
		int totalTripBoardCount = tripBoardDao.selectHashtagCount(hashtag);
		// paging 계산 (PageMaker)
		PageMaker pageMaker = new PageMaker(totalTripBoardCount, currentPage);
		// 게시글 데이터 얻기
		List<TripBoard> tripBoardList = tripBoardDao.selectByHashtagList(pageMaker.getPageBegin(), pageMaker.getPageEnd(), hashtag);
		PageMakerDto<TripBoard> pageMakerTripBoardList = new PageMakerDto<TripBoard>(tripBoardList, pageMaker, totalTripBoardCount);
		return pageMakerTripBoardList;
	}
	
	/*
	 * 게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	 */
	@Override
	public PageMakerDto<TripBoard> selectAllOrderByDate(int currentPage) throws Exception {
		//전체 글의 수
		int totalTripBoardCount = tripBoardDao.selectAllTbCount();
		// paging 계산 (PageMaker)
		PageMaker pageMaker = new PageMaker(totalTripBoardCount, currentPage);
		// 게시글 데이터 얻기
		List<TripBoard> tripBoardList = tripBoardDao.selectAllOrderByDate(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<TripBoard> pageMakerTripBoardList = new PageMakerDto<TripBoard>(tripBoardList, pageMaker, totalTripBoardCount);
		return pageMakerTripBoardList;
	}
	
	/*
	 * 게시판 리스트 정렬(조회수 기준 내림차순)
	 */
	@Override
	public PageMakerDto<TripBoard> selectAllOrderByReadCount(int currentPage) throws Exception {
		//전체 글의 수
		int totalTripBoardCount = tripBoardDao.selectAllTbCount();
		// paging 계산 (PageMaker)
		PageMaker pageMaker = new PageMaker(totalTripBoardCount, currentPage);
		// 게시글 데이터 얻기
		List<TripBoard> tripBoardList = tripBoardDao.selectAllOrderByReadCount(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<TripBoard> pageMakerTripBoardList = new PageMakerDto<TripBoard>(tripBoardList, pageMaker, totalTripBoardCount);
		return pageMakerTripBoardList;
	}
	
	/*
	 * 게시판 리스트
	 */
	@Override
	public PageMakerDto<TripBoard> selectAllTb(int currentPage) throws Exception {
		//전체 글의 수
		int totalTripBoardCount = tripBoardDao.selectAllTbCount();
		//paging 계산(PageMaker)
		PageMaker pageMaker = new PageMaker(totalTripBoardCount, currentPage);
		//게시글 데이터 얻기
		List<TripBoard> tripBoardList = tripBoardDao.selectAllTb(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		PageMakerDto<TripBoard> pageMakerBoardList = new PageMakerDto<TripBoard>(tripBoardList, pageMaker, totalTripBoardCount);
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
	public int increaseTbReadCount(int tBoNo) throws Exception {
		return tripBoardDao.increaseTbReadCount(tBoNo);
	}
	/*
	 * 키워드로 검색된 동행게시판 리스트
	 */
	@Override
	public PageMakerDto<TripBoard> selectSearchTbList(int currentPage, String keyword) throws Exception {
		//전체 글의 수
		int totalTripBoardCount = tripBoardDao.selectTbSearchCount(keyword);
		// paging 계산 (PageMaker)
		PageMaker pageMaker = new PageMaker(totalTripBoardCount, currentPage);
		// 게시글 데이터 얻기
		List<TripBoard> tripBoardList = tripBoardDao.selectSearchTbList(pageMaker.getPageBegin(), pageMaker.getPageEnd(),keyword);
		PageMakerDto<TripBoard> pageMakerTripBoardList = new PageMakerDto<TripBoard>(tripBoardList, pageMaker, totalTripBoardCount);
		return pageMakerTripBoardList;
	}
	
	/*
	 * 검색된 게시글 총 개수
	 */
	@Override
	public int selectTbSearchCount(String tbKeyword) throws Exception {
		return tripBoardDao.selectTbSearchCount(tbKeyword);
	}
	
}
