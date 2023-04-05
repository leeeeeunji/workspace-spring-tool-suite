package com.itwill.my_real_korea.dao.ticket;

import java.util.List;

import com.itwill.my_real_korea.dto.ticket.TicketReview;

public interface TicketReviewDao {

    //티켓 리뷰 작성
    int insertTicketReview(TicketReview ticketReview);

    //티켓 리뷰 보기
    List<TicketReview> selectByTicketReview(int pageStart, int pageEnd, int tiReviewNo);

    //내 리뷰 보기
    List<TicketReview> selectByTicketReviewUser(int pageStart, int pageEnd, String userId);

    //리뷰 수정
    int updateTicketReview(TicketReview ticketReview);

    //리뷰 삭제
    int deleteTicketReview(int tiReviewNo);

    //리뷰 글 수 보기
    int selectAllReviewCount() throws Exception;
    

}
