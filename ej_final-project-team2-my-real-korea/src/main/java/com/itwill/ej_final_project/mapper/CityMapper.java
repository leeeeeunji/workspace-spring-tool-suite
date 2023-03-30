package com.itwill.ej_final_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ej_final_project.dto.City;
@Mapper
public interface CityMapper {
	//1. 시티 새로 추가
	int insertCity(City city) throws Exception;
	//2. 시티번호로 시티 찾기
	City selectByCityNo(int cityNo) throws Exception;
	//3. 시티 리스트 전체 출력
	List<City> selectAllCity() throws Exception;
}
