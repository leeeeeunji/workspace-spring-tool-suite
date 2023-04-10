package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;
import com.itwill.my_real_korea.service.tripboard.TripBoardService;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiOperation;

@RestController
public class TripBoardRestController {
	
	@Autowired
	private TripBoardService tripBoardService;
	
	//게시글 모집상태별로 보기
	@ApiOperation(value = "동행게시판 모집상태별 리스트")
	@GetMapping(value = "/tripboard-search/{tBoStatus}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_tBoStatus_list(@RequestParam(required = false, defaultValue = "1") int pageNo,
														@PathVariable int tBoStatus) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			tripBoardList = tripBoardService.selectByTbStatusList(pageNo, tBoStatus);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";				
			}else {
				code = 2;
				msg = "해당 모집상태와 일치하는 게시글이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	//게시글 지역별로 보기
	@ApiOperation(value = "동행게시판 지역별 리스트")
	@GetMapping(value = "/tripboard-search/{cityNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_cityNo_list(@RequestParam(required = false, defaultValue = "1") int pageNo,
														@PathVariable int cityNo) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			tripBoardList = tripBoardService.selectByCityNoList(pageNo, cityNo);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";				
			}else {
				code = 2;
				msg = "해당 지역의 게시글이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	//게시글 해시태그별로 보기
	@ApiOperation(value = "동행게시판 해시태그별 리스트")
	@GetMapping(value = "/tripboard-search/{hashtag}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_hashtag_list(@RequestParam(required = false, defaultValue = "1") int pageNo,
														@PathVariable String hashtag) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			tripBoardList = tripBoardService.selectByHashtagList(pageNo, hashtag);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";				
			}else {
				code = 2;
				msg = "해당 해시태그와 일치하는 게시글이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	
	//게시판 리스트 정렬(게시글 작성 날짜 기준 내림차순)
	@ApiOperation(value = "동행게시판 리스트 최신순")
	@GetMapping(value = "/tripboard-date-desc", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_list_date_desc(@RequestParam(required = false, defaultValue = "1") int pageNo) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			tripBoardList = tripBoardService.selectAllOrderByDate(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	//게시판 리스트 정렬(조회수 기준 내림차순)
	@ApiOperation(value = "동행게시판 리스트 조회순")
	@GetMapping(value = "/tripboard-readcount-desc", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_list_readCount_desc(@RequestParam(required = false, defaultValue = "1") int pageNo) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			tripBoardList = tripBoardService.selectAllOrderByReadCount(pageNo);
			code = 1;
			msg = "성공";
		} catch (Exception e) {
			e.printStackTrace();
			code = 2;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	
	//키워드로 검색된 동행게시판 리스트
	@ApiOperation(value = "동행게시판 검색결과 리스트")
	@GetMapping(value = "/tripboard-search/{keyword}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_search_list(@RequestParam(required = false, defaultValue = "1") int pageNo,
														@PathVariable String keyword) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<TripBoard> tripBoardList = null;
		try {
			tripBoardList = tripBoardService.selectSearchTbList(pageNo, keyword);
			if(tripBoardList.getTotRecordCount() != 0 && tripBoardList != null) {
				code = 1;
				msg = "성공";				
			}else {
				code = 2;
				msg = "해당 키워드와 일치하는 게시글이 없습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", tripBoardList);
		return resultMap;
	}
	
	//게시글 추가
	@LoginCheck
	@ApiOperation(value = "동행게시판 게시글 추가")
	@PostMapping(value = "/tripboard", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_write_action(@RequestBody TripBoard tripBoard) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<TripBoard> data = new ArrayList<TripBoard>();
		
		try {
			tripBoardService.insertTripBoard(tripBoard);
			code = 1;
			msg = "성공";
			tripBoard = tripBoardService.selectByTbNo(tripBoard.getTBoNo());
			data.add(tripBoard);
		} catch (Exception e) {
			code = 2;
			msg = "동행게시판 글쓰기 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	
	//게시글 삭제
	@LoginCheck
	@ApiOperation(value = "동행게시판 게시글 삭제")
	@PostMapping(value = "/tripboard/{tBoNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_delete_action(@PathVariable(value = "tBoNo")int tBoNo) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<TripBoard> data = new ArrayList<TripBoard>();
		
		try {
			int rowCount = tripBoardService.deleteTripBoard(tBoNo);
			if(rowCount != 0) {
				code = 1;
				msg = "성공";				
			}else {
				code = 2;
				msg = "동행게시판 글쓰기 실패";
				
				TripBoard failTripBoard = tripBoardService.selectByTbNo(tBoNo);
				data.add(failTripBoard);
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	//게시글 수정
	@LoginCheck
	@ApiOperation(value = "동행게시판 게시글 수정")
	@PostMapping(value = "/tripboard/{tBoNo}", produces = "application/json;charset=UTF-8")
	public Map<String, Object> tripBoard_modify_action(@PathVariable(value = "tBoNo")int tBoNo,
														@RequestBody TripBoard tripBoard) {
		
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		List<TripBoard> data = new ArrayList<TripBoard>();
		
		try {
			TripBoard findTripBoard = tripBoardService.selectByTbNo(tBoNo);
			if(findTripBoard != null) {
				tripBoard.setTBoNo(tBoNo);
				tripBoardService.updateTripBoard(tripBoard);
				code = 1;
				msg = "성공";				
				data.add(tripBoard);
			}else {
				code = 2;
				msg = "동행게시판 글쓰기 실패";
			}
		} catch (Exception e) {
			e.printStackTrace();
			code = 3;
			msg = "관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
}
