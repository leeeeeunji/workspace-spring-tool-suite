package com.itwill.guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	
	public GuestController() {
		System.out.println(">>>GuestController");
	}
	@RequestMapping("/thymeleaf_test")
	public String thymeleaf_test() {
		String forwardPath = "thymeleaf_test";
		return forwardPath;
	}
	@RequestMapping("/guest_main")
	public String guest_main() {
		String forwardPath = "guest_main";
		return forwardPath;
	}
	@RequestMapping("/guest_list")
	public String guest_list(Model model) throws Exception{
		String forwardPath = "";
		List<Guest> guestList=guestService.selectAll();
		model.addAttribute("guestList", guestList);
		forwardPath="guest_list";
		return forwardPath;
	}
	/*
	 * parameter에 guest_no 가 존재하지않으면
	 */
	@RequestMapping(value = "/guest_view",params = "!guest_no")
	public String guest_view() {
		return "redirect:guest_main";	
	}
	/*
	 * parameter에 guest_no 가 존재하면
	 */
	@RequestMapping(value = "/guest_view",params = "guest_no")
	public String guest_view(@RequestParam int guest_no,Model model) throws Exception{
		Guest guest=guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		return "guest_view";
	}
	/*
	 * parameter에 guest_no 가 존재하지않으면
	 */
	@PostMapping(value="/guest_modify_form",params = "!guest_no")
	public String guest_modify_form() {
		return "redirect:guest_main";
	}
	/*
	 * parameter에 guest_no 가 존재하면
	 */
	@PostMapping(value="/guest_modify_form",params = "guest_no")
	public String guest_modify_form(@RequestParam int guest_no,Model model) throws Exception{
		Guest guest = guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		return "guest_modify_form";
	}
	
	@PostMapping(value="/guest_modify_action")
	public String guest_modify_form(@ModelAttribute Guest guest,RedirectAttributes redirectAttributes) throws Exception{
		guestService.updateGuest(guest);
		redirectAttributes.addAttribute("guest_no", guest.getGuest_no());
		return "redirect:guest_view";
	}
	
	
	
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		return "guest_write_form";
	}
	@PostMapping("/guest_write_action")
	public String guest_write_action(@ModelAttribute Guest guest,
									RedirectAttributes redirectAttributes)throws Exception {
		int guest_no = guestService.insertGuest(guest);
		redirectAttributes.addAttribute("guest_no",guest_no);
		return "redirect:guest_view";
	}
	
	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam int guest_no) throws Exception{
		guestService.deleteGuest(guest_no);
		return "redirect:guest_list";
	}
	
	@GetMapping(value = {"guest_modify_form",
						"guest_modify_action",
						"guest_write_action",
						"guest_remove_action"})
	public String guest_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	
	@ExceptionHandler(Exception.class)
	public String guest_exception_handler(Exception e) {
		return "guest_error";
	}

}













