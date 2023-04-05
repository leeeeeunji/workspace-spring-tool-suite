package com.itwill.my_real_korea.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.my_real_korea.dao.payment.PaymentDao;
import com.itwill.my_real_korea.dto.Payment;

@Service
public class PaymentServiceImpl implements PaymentService{

	
	private final PaymentDao paymentDao;
	
	@Autowired
	public PaymentServiceImpl(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}
	
	@Override
	public int insertPayment(Payment payment) {
		return paymentDao.insertPayment(payment);
	}

	@Override
	public List<Payment> selectAllUser(String userId) {
		return paymentDao.selectAllUser(userId);
	}

	@Override
	public List<Payment> selectPaymentNo(int pNo) {
		return paymentDao.selectPaymentNo(pNo);
	}

	@Override
	public int updatePayment(Payment payment) {
		return paymentDao.updatePayment(payment);
	}

	@Override
	public int deletePayment(int pNo) {
		return paymentDao.deletePayment(pNo);
	}

}
