package com.itwill.my_real_korea.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.my_real_korea.dto.wishlist.Wishlist;
import com.itwill.my_real_korea.service.wishlist.WishlistService;

@Controller
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;
	
	// 위시리스트 리스트 + 티켓상품 + 투어상품 전체 보기 (위시리스트 첫화면) 
	@LoginCheck
	@GetMapping(value = "/wishlist")
	public String wishlist(HttpSession session, Model model) {
		
		String userId = (String)session.getAttribute("sUserId");
		if (userId != null) {
			List<Wishlist> wishlistList = wishlistService.selectAllWithTicketAndTour(userId);
			model.addAttribute("wishlistList", wishlistList);
			model.addAttribute("userId", userId);
		} else {
			return "user_login_form";
		}
		
		
		return "wishlist";
	}
	
}
