package com.itwill.my_real_korea.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.dto.tour.Tour;
import com.itwill.my_real_korea.dto.tour.TourImg;
import com.itwill.my_real_korea.dto.tour.TourReserve;
import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.tour.TourImgService;
import com.itwill.my_real_korea.service.tour.TourReserveService;
import com.itwill.my_real_korea.service.tour.TourReviewService;
import com.itwill.my_real_korea.service.tour.TourService;
import com.itwill.my_real_korea.util.PageMakerDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
public class TourRestController {
	private TourService tourService;
	private TourImgService tourImgService;
	private CityService cityService;
	private TourReserveService tourReserveService;
	private TourReviewService tourReviewService;

	@Autowired
	public TourRestController(TourService tourService, TourImgService tourImgService, CityService cityService, TourReserveService tourReserveService,TourReviewService tourReviewService) {
		this.tourService=tourService;
		this.tourImgService=tourImgService;
		this.cityService=cityService;
		this.tourReserveService=tourReserveService;
		this.tourReviewService=tourReviewService;
	}
	//1. 투어상세보기 액션 -> 투어 예약 페이지 전환1
	@PostMapping(value="/tourDetail_action", produces="application/json;charset=UTF-8")
	public Map<String,Object> tourDetail_action(HttpSession session){
		Map<String, Object> resultMap =new HashMap<>();
		return resultMap;
	}
	//3. 투어상품 예약하기 액션
//		@LoginCheck
	@ApiOperation(value="투어상품 예약")
	@PostMapping(value="/tourReserve", produces="application/json;charset=UTF-8")
	public Map<String, Object> tourReserve_action(@PathVariable int toNo,@RequestBody TourReserve tourReserve){
		//투어 상세 페이지 -> 투어예약 페이지 : 투어번호 받아와야 함
		Map<String, Object> resultMap = new HashMap<>();
		int code=1;
		String msg="성공";
		List<TourReserve> data=new ArrayList<>();
		try {
			tourReserveService.insertTourReserve(tourReserve);
			code=1;
			msg="성공";
			//투어 넘버 붙이는 법,,?
			tourReserve = tourReserveService.findTourReserveWithTourByToRsNo(tourReserve.getToRsNo());
			tourReserve.setTour(tourService.findTourWithCityByToNo(toNo));
			data.add(tourReserve);
		}catch (Exception e) {
			e.printStackTrace();

		}
		return resultMap;
	}

	//5. 투어상품 예약하기 액션



	//작성중 --> 투어상품 추가하기
//		@AdminCheck
//		@LoginCheck
	@ApiOperation(value="투어상품 추가")
	@PostMapping(value="/tourCreate", produces="application/json;charset=UTF-8")
	public Map<String, Object> tour_create(@RequestBody Tour tour /*,@RequestBody(required = false) List<TourImg> tourImgList*/) throws Exception{
		Map<String, Object> resultMap=new HashMap<>();
		int code=1;
		String msg="성공";
		List<Tour> data=new ArrayList<>();

		try {
			tourService.insertTour(tour);
//				List<TourImg> tourImgListWithToNo=new ArrayList<>();
//				for (TourImg tourImg : tourImgList) {
//					tourImg.setToNo(tour.getToNo());
//					tourImgService.insertTourImg(tourImg);
			//tourImgListWithToNo.add(tourImg);
//				}
//				tour=tourService.findTourWithCityByToNo(tour.getToNo());
			data.add(tour);
		}catch (Exception e) {
			e.printStackTrace();
			code=2;
			msg="투어상품 추가 실패";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);

		return resultMap;
	}
}

/*	
	//1. 투어상품 전체 리스트 보기
	@ApiOperation(value="투어상품리스트")
	@GetMapping(value = "/tour", produces="application/json;charset=UTF-8")
	public Map<String, Object> tour_list(@RequestParam(required = false, defaultValue = "1") int currentPage,
										 @RequestParam(required = false, defaultValue = "") String keyword, 
										 @RequestParam(required = false, defaultValue = "0") int cityNo, 
										 @RequestParam(required = false, defaultValue = "0") int toType, 
										 @RequestParam(required = false, defaultValue = "") String sortOrder){
		Map<String, Object> resultMap = new HashMap<>();
		int code = 1;
		String msg = "성공";
		PageMakerDto<Tour> data = null;
		try {
			data=tourService.findAll(currentPage,keyword, cityNo, toType, sortOrder);
			code=1;
			msg="성공";
		}catch (Exception e) {
			e.printStackTrace();
			code=2;
			msg="관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
	//2. 투어상품 상세보기
	@ApiOperation(value="투어상품 상세보기")
	@ApiImplicitParam(name="toNo", value="투어상품 번호")
	@GetMapping(value="/tour/{toNo}", produces="application/json;charset=UTF-8")
	public Map<String, Object> tour_detail(@PathVariable int toNo) throws Exception{
			
		Map<String,Object> resultMap=new HashMap<>();
		int code=1;
		String msg="성공";
		List<Tour> data=new ArrayList<>();
		try {
			Tour tour=tourService.findTourWithCityByToNo(toNo);
			if(tour!=null) {
				List<TourImg> tourImgList=tourImgService.findTourImgList(toNo);
				tour.setTourImgList(tourImgList);
				code=1;
				data.add(tour);
			} else {
				code=2;
				msg="해당 투어 제품은 존재하지 않습니다.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			code=3;
			msg="관리자에게 문의하세요.";
		}
		resultMap.put("code", code);
		resultMap.put("msg", msg);
		resultMap.put("data", data);

		return resultMap;
	}
 */	