--insert tour
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'서울',1,1);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'경기',2,2);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'강원',3,3);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'부산',4,4);
insert into city(city_no,city_name,latitude,longitude) values(city_city_no_seq.nextval,'대전',5,5);

--insert tourImg
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'a',1);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'b',2);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'c',3);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'d',4);
insert into tour_img(to_img_no,to_img_url,to_no) values(TOUR_IMG_TO_IMG_NO_SEQ.nextval,'e',3);

--insert tourReserve
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-03-27',2,'테스트1',1,'admin');
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-02-27',2,'테스트2',2,'user2');
insert into tour_reserve(to_rs_no,to_rs_desc,to_rs_start_day,to_rs_person,to_rs_msg,to_no,user_id) values(TOUR_RESERVE_TO_RS_NO_SEQ.nextval,'예약설명','2023-01-27',2,'테스트3',3,'admin');


--insert tourReview
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰1','테스트1',null,3,1,'admin');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰2','테스트2',null,5,2,'user2');
insert into tour_review(to_review_no,to_review_date,to_review_title,to_review_content,to_review_img,to_review_star,to_no,user_id) values(TOUR_REVIEW_TO_REVIEW_NO_SEQ.nextval,sysdate,'리뷰3','테스트3',null,4,3,'admin');

--insert tourWishlist
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,1,'admin',1);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,4,'admin',1);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,2,'user1',2);
insert into tour_wishlist(to_wish_no,to_no,user_id,wish_no) values(TOUR_WISHLIST_TO_WISH_NO_SEQ.nextval,1,'user2',3);

