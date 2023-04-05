package com.itwill.my_real_korea.dto;

import java.util.Date;

import com.itwill.my_real_korea.dto.ticket.Ticket;
import com.itwill.my_real_korea.dto.tour.Tour;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {

    private int pNo;
    private int pPrice;
    private int pQty;
    private Date pDate;
    private Date pStartDate;
    private String pMsg;
    private int pPoint;
    private int pMethod;

    private Tour tour;
    private Ticket ticket;
    private String userId;


}
