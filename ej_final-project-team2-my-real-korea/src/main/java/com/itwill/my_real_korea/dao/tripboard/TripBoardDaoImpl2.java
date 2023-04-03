package com.itwill.my_real_korea.dao.tripboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.mapper.TripBoardMapper2;

@Repository
public class TripBoardDaoImpl2 implements TripBoardDao2{
	
	@Autowired
	private TripBoardMapper2 tripBoardMapper;
	
	public TripBoardDaoImpl2() {
		System.out.println("TripBoardDaoImpl 기본 생성자 호출");
	}
	public TripBoardMapper2 getTripBoardMapper() {
		return tripBoardMapper;
	}
	public void setTripBoardMapper(TripBoardMapper2 tripBoardMapper) {
		this.tripBoardMapper = tripBoardMapper;
	}
	
	@Override
	public int insertTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardMapper.insertTripBoard(tripBoard);
	}
	
	@Override
	public int updateTripBoard(TripBoard tripBoard) throws Exception {
		return tripBoardMapper.updateTripBoard(tripBoard);
	}
	
	@Override
	public int deleteTripBoard(int tBoNo) throws Exception {
		return tripBoardMapper.deleteTripBoard(tBoNo);
	}
	
	@Override
	public TripBoard selectByTbNo(int tBoNo) throws Exception {
		return tripBoardMapper.selectByTbNo(tBoNo);
	}
	
	@Override
	public List<TripBoard> selectByTbStatusList(int pageBegin, int pageEnd, int tBoStatus) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("tbStatus", tBoStatus);
		
		return tripBoardMapper.selectByTbStatusList(pageMap);
	}
	
	@Override
	public List<TripBoard> selectByCityNoList(int pageBegin, int pageEnd, int cityNo) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("cityNo", cityNo);
		
		return tripBoardMapper.selectByCityNoList(pageMap);
	}
	
	@Override
	public List<TripBoard> selectByHashtagList(int pageBegin, int pageEnd, String hashtag) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("tbHashtag", hashtag);
		
		return tripBoardMapper.selectByHashtagList(pageMap);
	}
	
	@Override
	public List<TripBoard> selectAllOrderByDate(int pageBegin, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		
		return tripBoardMapper.selectAllOrderByDate(pageMap);
	}
	
	@Override
	public List<TripBoard> selectAllOrderByReadCount(int pageBegin, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		
		return tripBoardMapper.selectAllOrderByReadCount(pageMap);
	}
	
	@Override
	public List<TripBoard> selectAllTb(int pageBegin, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		
		return tripBoardMapper.selectAllTb(pageMap);
	}
	
	@Override
	public int selectAllTbCount() throws Exception {
		return tripBoardMapper.selectAllTbCount();
	}
	
	@Override
	public int selectStatusCount(int tBoStatus) throws Exception {
		return tripBoardMapper.selectStatusCount(tBoStatus);
	}
	
	@Override
	public int selectCityNoCount(int cityNo) throws Exception {
		return tripBoardMapper.selectCityNoCount(cityNo);
	}
	
	@Override
	public int selectHashtagCount(String hashtag) throws Exception {
		return tripBoardMapper.selectHashtagCount(hashtag);
	}
	
	@Override
	public int increaseTbReadCount(int tBoNo) throws Exception {
		return tripBoardMapper.increaseTbReadCount(tBoNo);
	}
	
	@Override
	public List<TripBoard> selectSearchTbList(int pageBegin, int pageEnd, String keyword) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		pageMap.put("tbKeyword", keyword);
		
		return tripBoardMapper.selectSearchTbList(pageMap);
	}
	
	@Override
	public int selectTbSearchCount(String keyword) throws Exception {
		return tripBoardMapper.selectTbSearchCount(keyword);
	}
	
	
	
}
