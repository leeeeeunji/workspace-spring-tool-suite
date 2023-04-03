package com.itwill.my_real_korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.my_real_korea.dto.tripboard.City;
@Mapper
public interface CityMapper {
	//1. 시티 새로 추가
	int insertCity(City city) throws Exception;
	//2. 시티번호로 시티 찾기
	City selectByCityNo(int cityNo) throws Exception;
	//3. 시티 리스트 전체 출력
	List<City> selectAllCity() throws Exception;
}
