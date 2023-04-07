package com.itwill.my_real_korea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.my_real_korea.dto.tripboard.TripBoard;

@RestController
public class TripBoardRestController {
	
	@Autowired
	private TripBoard tripBoard;
	
	
}
