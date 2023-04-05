package com.itwill.my_real_korea.controller;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.service.city.CityService;
import com.itwill.my_real_korea.service.ticket.TicketImgService;
import com.itwill.my_real_korea.service.ticket.TicketService;
import com.itwill.my_real_korea.util.PageMakerDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TicketRestController {

    private final TicketService ticketService;
    private final CityService cityService;
    private final TicketImgService ticketImgService;

    @Autowired
    public TicketRestController(TicketService ticketService, CityService cityService, TicketImgService ticketImgService) {
        this.ticketService = ticketService;
        this.cityService = cityService;
        this.ticketImgService = ticketImgService;
    }

    //키워드, 지역별 - 필터 + 가격순, 날짜별 정렬 - 화면에 어떻게 넘길 지 생각하기 ㅠ
    @ApiOperation(value = "티켓-필터-정렬")
    @GetMapping(value = "/ticketList", produces = "application/json;charset=UTF-8")
    public Map<String, Object> ticketList(@RequestParam int currentPage,
                                          String keyword, int cityNo, String sortOrder) {
        Map<String, Object> ticketMap = new HashMap<>();
        int code = 1;
        String msg = "성공";
        PageMakerDto<Ticket> ticketList = null;
        try {
            /*
                필터링 ->  tiNoDESC : 최신 순 / tiPriASC, tiPriDESC : 가격 순
             */
            ticketList = ticketService.selectByTicketAllSort(currentPage, keyword, cityNo, sortOrder);
            if (ticketList.getTotRecordCount() != 0 && ticketList != null) {
                code = 1;
                msg = "성공";
            } else {
                code = 2;
                msg = "검색 조건에 해당하는 티켓이 없습니다.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            code = 3;
            msg = "오류";
        }

        ticketMap.put("code", code);
        ticketMap.put("msg", msg);
        ticketMap.put("ticketList", ticketList);

        return ticketMap;
    }


}
