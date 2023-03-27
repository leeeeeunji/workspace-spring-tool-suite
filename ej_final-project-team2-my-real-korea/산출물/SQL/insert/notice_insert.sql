desc notice;
desc user_info;

-- 회원 user_info insert(Parent key)
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('kms1','1111','김1','별명1','010-1111-1111','kms1@korea.com','1991-01-01','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('kms2','2222','김2','별명2','010-2222-2222','kms2@korea.com','1992-02-02','강남구',0);
insert into user_info(user_id,password,name,nickname,phone,email,birth,address,gender) values('kms3','3333','김3','별명3','010-3333-3333','kms3@korea.com','1993-03-03','강남구',0);

-- 공지사항 notice insert
insert into notice(n_no,n_title,n_content,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항1','공지사항내용1','img.png','kms1'); 
insert into notice(n_no,n_title,n_content,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항2','공지사항내용2','img.png','kms2'); 
insert into notice(n_no,n_title,n_content,n_img,user_id) values (notice_n_no_seq.nextval,'공지사항3','공지사항내용3','img.png','kms3'); 


