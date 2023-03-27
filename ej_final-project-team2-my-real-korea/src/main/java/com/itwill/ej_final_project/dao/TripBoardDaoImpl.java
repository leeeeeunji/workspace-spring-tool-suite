package com.itwill.ej_final_project.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ej_final_project.dto.TripBoard;
import com.itwill.ej_final_project.mapper.TripBoardMapper;

@Repository
public class TripBoardDaoImpl implements TripBoardDao{
	
	@Autowired
	private TripBoardMapper tripBoardMapper;
	
	public TripBoardDaoImpl() {
		System.out.println("TripBoardDaoImpl 기본 생성자 호출");
	}
	public TripBoardMapper getTripBoardMapper() {
		return tripBoardMapper;
	}
	public void setTripBoardMapper(TripBoardMapper tripBoardMapper) {
		System.out.println(">>> tripBoardDaoImpl() :setTripBoardMapper() 호출 ");
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
	public int deleteTripBoard(int tbNo) throws Exception {
		return tripBoardMapper.deleteTripBoard(tbNo);
	}
	
	@Override
	public TripBoard selectByTbNo(int tbNo) throws Exception {
		return tripBoardMapper.selectByTbNo(tbNo);
	}
	
	@Override
	public TripBoard selectByTbStatus(int tbStatus) throws Exception {
		return tripBoardMapper.selectByTbStatus(tbStatus);
	}
	
	@Override
	public TripBoard selectByCityNo(int cityNo) throws Exception {
		return tripBoardMapper.selectByCityNo(cityNo);
	}
	
	@Override
	public TripBoard selectByHashtag(int tbHashtag) throws Exception {
		return tripBoardMapper.selectByHashtag(tbHashtag);
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
		
		return tripBoardMapper.selectAllOrderByDate(pageMap);
	}
	
	@Override
	public List<TripBoard> selectAllTb(int pageBegin, int pageEnd) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		
		return tripBoardMapper.selectAllOrderByDate(pageMap);
	}
	
	@Override
	public int increaseTbReadCount(int tbNo) throws Exception {
		return tripBoardMapper.increaseTbReadCount(tbNo);
	}
	
	@Override
	public List<TripBoard> selectSearchTbList(int pageBegin, int pageEnd, String tbKeyword) throws Exception {
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("pageBegin", pageBegin);
		pageMap.put("pageEnd", pageEnd);
		
		return tripBoardMapper.selectSearchTbList(pageMap);
	}
	
	@Override
	public int selectTbSearchCount(String tbKeyword) throws Exception {
		return tripBoardMapper.selectTbSearchCount(tbKeyword);
	}
	
	
	
}
