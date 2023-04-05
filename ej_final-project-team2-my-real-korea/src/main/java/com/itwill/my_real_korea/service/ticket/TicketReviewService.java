package com.itwill.my_real_korea.service.ticket;

import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.util.PageMakerDto;

public interface TicketReviewService {

    int insertTicketReview(TicketReview ticketReview);

    //티켓 리뷰 보기
    PageMakerDto<TicketReview> selectByTicketReview(int currentPage , int tiReviewNo) throws Exception;

    //내 리뷰 보기
    PageMakerDto<TicketReview> selectByTicketReviewUser(int currentPage , String userId) throws Exception;

    //리뷰 수정
    int updateTicketReview(TicketReview ticketReview);

    //리뷰 삭제
    int deleteTicketReview(int tiReviewNo);
}
