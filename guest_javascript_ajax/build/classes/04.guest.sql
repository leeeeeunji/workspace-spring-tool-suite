drop table GUEST;
create table GUEST(
        guest_no number(10) primary key,
		guest_name varchar2(100) not null,
		guest_date date not null,
		guest_email varchar2(100),
		guest_homepage varchar2(100),
		guest_title varchar2(255) not null,
		guest_content varchar2(4000) not null);

drop sequence guest_no_seq;
create sequence guest_no_seq  increment by 1 start with 1;

insert into GUEST values(guest_no_seq.nextval , '김경가', sysdate, 'guard1@naver.com', 'http://www.naver.com', '방명록 사용법1', '방명록처럼 사용하시면 됩니다1');
insert into GUEST values(guest_no_seq.nextval , '김경나', sysdate, 'guard2@naver.com', 'http://www.daum.net', '방명록 사용법2', '방명록처럼 사용하시면 됩니다2');
insert into GUEST values(guest_no_seq.nextval , '김경다', sysdate, 'guard3@naver.com', 'http://www.google.com', '방명록 사용법3', '방명록처럼 사용하시면 됩니다3');
insert into GUEST values(guest_no_seq.nextval , '김경라', sysdate, 'guard4@naver.com', 'http://www.nate3.com', '방명록 사용법4', '방명록처럼 사용하시면 됩니다4');
insert into GUEST values(guest_no_seq.nextval , '김경마', sysdate, 'guard5@naver.com', 'http://www.nate4.com', '방명록 사용법5', '방명록처럼 사용하시면 됩니다5');
insert into GUEST values(guest_no_seq.nextval , '김경바', sysdate, 'guard6@naver.com', 'http://www.nate5.com', '방명록 사용법6', '방명록처럼 사용하시면 됩니다6');
insert into GUEST values(guest_no_seq.nextval , '김경사', sysdate, 'guard7@naver.com', 'http://www.nate6.com', '방명록 사용법7', '방명록처럼 사용하시면 됩니다7');
insert into GUEST values(guest_no_seq.nextval , '김경아', sysdate, 'guard8@naver.com', 'http://www.nate7.com', '방명록 사용법8', '방명록처럼 사용하시면 됩니다8');
insert into GUEST values(guest_no_seq.nextval , '김경자', sysdate, 'guard9@naver.com', 'http://www.nate8.com', '방명록 사용법9', '방명록처럼 사용하시면 됩니다9');
insert into GUEST values(guest_no_seq.nextval , '김경차', sysdate, 'guard10@naver.com', 'http://www.nate9.com', '방명록 사용법10', '방명록처럼 사용하시면 됩니다10');

commit;
