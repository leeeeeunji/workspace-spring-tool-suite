package com.itwill.my_real_korea.service.user;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {

	//의존성 주입을 통해서 필요한 객체를 가져온다.
    private final JavaMailSender emailSender;
    // 타임리프를사용하기 위한 객체를 의존성 주입으로 가져온다
    private final SpringTemplateEngine templateEngine;
    private String authNum; //랜덤 인증 코드

    //랜덤 인증 코드 생성
    //6자리 숫자
    public void createCode() {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        for(int i=0;i<6;i++) {
            key.append(random.nextInt(10));
        }

        authNum = key.toString();
    }
    
    public String sendEmail(String toEmail) throws MessagingException, UnsupportedEncodingException {
        createCode(); // 인증 코드 생성

        //메일 전송에 필요한 정보 설정 (인증번호 입력하는 방식)
        String setFrom = "myrealkorea.auth@gmail.com";
        String title = "My Real Korea 회원가입 인증";

        MimeMessage emailForm = emailSender.createMimeMessage();
        emailForm.addRecipients(MimeMessage.RecipientType.TO, toEmail);	//수신자 설정
        emailForm.setSubject(title);	//제목 설정
        emailForm.setFrom(setFrom);		//발신자 설정
        emailForm.setText(setContext(authNum), "utf-8", "html");

        emailSender.send(emailForm);
        return authNum; // 인증 코드 반환
    }
        
        
        //메일 전송에 필요한 정보 설정 (링크 클릭으로 인증하는 방식)
////        String setFrom = "myrealkorea.auth@gmail.com";
////        String title = "My Real Korea 회원가입 인증 번호";
//        
////        MimeMessage emailForm = emailSender.createMimeMessage();
//        String mailContent = "<h1>[이메일 인증]</h1><br><p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>"
//                            + "<a href='http://localhost:80/final-project-team2-my-real-korea/user_mail_auth?email=" 
//                            + toEmail + "&authKey=" + authNum + "' target='_blenk'>이메일 인증 확인</a>";
//
//        try {
//        	emailForm.setSubject(title); // 제목 설정
//        	emailForm.setText(mailContent, "utf-8", "html");
//        	emailForm.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(toEmail));
//            emailSender.send(emailForm);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        
//        

    //타임리프를 이용한 context 설정
    public String setContext(String code) {
        Context context = new Context();
        context.setVariable("code", code);
        return templateEngine.process("user_mail", context); //mail.html
    }

}
