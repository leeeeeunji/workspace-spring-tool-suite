package com.itwill.my_real_korea.mapper;

import com.itwill.my_real_korea.dto.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    //결제 생성
    int insertPayment (Payment payment);

    // 내 결제 전체 보기
    List<Payment> selectAllUser(String userId);
    // 결제 상세 보기
    List<Payment> selectPaymentNo(int pNo);

    //결제 수정
    int updatePayment(Payment payment);

    //결제 삭제
    int deletePayment(int pNo);

}
