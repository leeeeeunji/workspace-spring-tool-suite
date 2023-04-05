package com.itwill.my_real_korea.controller;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.ticket.TicketImgService;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.util.PageMakerDto;
import groovyjarjarpicocli.CommandLine;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TicketController {

    TicketService ticketService;
    CityService cityService;
    TicketImgService ticketImgService;

    //test 중
    @Autowired
    public TicketController(TicketService ticketService, CityService cityService, TicketImgService ticketImgService) {
        this.ticketService = ticketService;
        this.cityService = cityService;
        this.ticketImgService = ticketImgService;
    }

    //티켓 리스트 - 페이지
    @RequestMapping(value = "/ticket")
    public String tickeList(@RequestParam(required = false, defaultValue = "1") int currentPage, Model model) {

        try {
            PageMakerDto<Ticket> ticketList = ticketService.selectAllTicket(currentPage);
            model.addAttribute("ticketList", ticketList);
            model.addAttribute("currnetPage", currentPage);
        } catch (Exception e) {
            e.printStackTrace();
            return "해당 상품이 존재하지 않습니다."; //
        }
        return "ticket";
    }

    //티켓 -- 상세보기 ? session에 어쩌구
    @GetMapping(value = "/ticketDetail")
    public String ticketDetail(@PathVariable(value = "tiNo") int tiNo, Model model) {

        try {
            Ticket ticket = (Ticket) ticketService.selectByTicketNoCityWithImg(tiNo);
            System.out.println("ticket");
            model.addAttribute("ticket", ticket);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ticketDetail"; //
    }

    // 비 로그인, 티켓 예약 페이지 요청 시 로그인 폼 -> (@LoginCheck HttpServletRequest request)
    // 로그인 , 티켓 예약 페이지로 forwarding -> 예약 페이지는 rest (수량 변경 등)
    // 결제 -> 페이지 결제 완료시 -> 메인이나 결제내역으로 redirect
}
