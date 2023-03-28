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
	public List<TripBoard> selectByTbStatusList(int tBoStatus) throws Exception {
		
		return tripBoardMapper.selectByTbStatusList(tBoStatus);
	}
	
	@Override
	public List<TripBoard> selectByCityNoList(int cityNo) throws Exception {
		
		return tripBoardMapper.selectByCityNoList(cityNo);
	}
	
	@Override
	public List<TripBoard> selectByHashtagList(String hashtag) throws Exception {
		
		return tripBoardMapper.selectByHashtagList(hashtag);
	}
	
	@Override
	public List<TripBoard> selectAllOrderByDate() throws Exception {
		
		return tripBoardMapper.selectAllOrderByDate();
	}
	
	@Override
	public List<TripBoard> selectAllOrderByReadCount() throws Exception {
		
		return tripBoardMapper.selectAllOrderByReadCount();
	}
	
	@Override
	public List<TripBoard> selectAllTb() throws Exception {
		
		return tripBoardMapper.selectAllTb();
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
	public List<TripBoard> selectSearchTbList(String keyword) throws Exception {
		
		return tripBoardMapper.selectSearchTbList(keyword);
	}
	
	@Override
	public int selectTbSearchCount(String keyword) throws Exception {
		return tripBoardMapper.selectTbSearchCount(keyword);
	}
	
	
	
}
