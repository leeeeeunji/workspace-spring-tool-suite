package com.itwill.my_real_korea.service.ticket;

import com.itwill.my_real_korea.dao.ticket.TicketReviewDao;
import com.itwill.my_real_korea.dto.ticket.TicketReview;
import com.itwill.my_real_korea.util.PageMaker;
import com.itwill.my_real_korea.util.PageMakerDto;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class TicketReviewServiceImpl implements TicketReviewService{

    private final TicketReviewDao ticketReviewDao;

    @Autowired
    public TicketReviewServiceImpl(TicketReviewDao ticketReviewDao) {
        this.ticketReviewDao = ticketReviewDao;
    }


    @Override
    public int insertTicketReview(TicketReview ticketReview) {
        return ticketReviewDao.insertTicketReview(ticketReview);
    }

    @Override
    public PageMakerDto<TicketReview> selectByTicketReview(int currentPage, int tiReviewNo) throws Exception {
        int totReviewCount = ticketReviewDao.selectAllReviewCount();
        PageMaker pageMaker = new PageMaker(totReviewCount, currentPage);
        List<TicketReview> ticketReviewList
                = ticketReviewDao.selectByTicketReview(pageMaker.getPageBegin(), pageMaker.getPageEnd(), tiReviewNo);
        return new PageMakerDto<TicketReview>(ticketReviewList,pageMaker,totReviewCount);
    }

    @Override
    public PageMakerDto<TicketReview> selectByTicketReviewUser(int currentPage, String userId) throws Exception {
        int totReviewCount = ticketReviewDao.selectAllReviewCount();
        PageMaker pageMaker = new PageMaker(totReviewCount, currentPage);
        List<TicketReview> ticketReviewUserList
                = ticketReviewDao.selectByTicketReviewUser(pageMaker.getPageBegin(),pageMaker.getPageEnd(),userId);
        return new PageMakerDto<TicketReview>(ticketReviewUserList, pageMaker, totReviewCount);
    }

    @Override
    public int updateTicketReview(TicketReview ticketReview) {
        return ticketReviewDao.updateTicketReview(ticketReview);
    }

    @Override
    public int deleteTicketReview(int tiReviewNo) {
        return ticketReviewDao.deleteTicketReview(tiReviewNo);
    }
}
