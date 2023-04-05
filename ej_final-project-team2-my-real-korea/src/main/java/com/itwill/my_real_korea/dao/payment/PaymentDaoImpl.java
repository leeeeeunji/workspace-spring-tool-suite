package com.itwill.my_real_korea.dao.payment;

import com.itwill.my_real_korea.dto.Payment;
import com.itwill.my_real_korea.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentDaoImpl implements PaymentDao{

    private final PaymentMapper paymentMapper;

    @Autowired
    public PaymentDaoImpl(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    //결제 생성
    @Override
    public int insertPayment(Payment payment) {
        return paymentMapper.insertPayment(payment);
    }

    // 결제 보기
    @Override
    public List<Payment> selectAllUser(String userId) {
        return paymentMapper.selectAllUser(userId);
    }

    // 결제(예약) 상세보기
    @Override
    public List<Payment> selectPaymentNo(int pNo) {
        return paymentMapper.selectPaymentNo(pNo);
    }

    // 결제 수정
    @Override
    public int updatePayment(Payment payment) {
        return paymentMapper.updatePayment(payment);
    }

    //결제 삭제
    @Override
    public int deletePayment(int pNo) {
        return paymentMapper.deletePayment(pNo);
    }
}
