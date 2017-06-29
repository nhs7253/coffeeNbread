/* 유저 */
SELECT *FROM GENERAL_USER
DELETE FROM GENERAL_USER
INSERT INTO GENERAL_USER VALUES('u-1','pw-1','user1',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');
INSERT INTO GENERAL_USER VALUES('u-2','pw-2','user2',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');
INSERT INTO GENERAL_USER VALUES('u-3','pw-3','user3',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');
INSERT INTO GENERAL_USER VALUES('u-4','pw-4','user4',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');


/* 매장 */
SELECT *FROM STORE
DELETE FROM STORE

INSERT INTO STORE VALUES('s-1','매장1','매장소개글1','010-0000-0000','매장주소1','매장1@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-2','매장2','매장소개글2','010-0000-0000','매장주소2','매장2@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-3','매장3','매장소개글3','010-0000-0000','매장주소3','매장3@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-4','매장4','매장소개글4','010-0000-0000','매장주소4','매장4@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-5','매장5','매장소개글5','010-0000-0000','매장주소5','매장5@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-6','매장6','매장소개글6','010-0000-0000','매장주소6','매장6@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-7','매장7','매장소개글7','010-0000-0000','매장주소7','매장7@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');


/* 제품 */
SELECT*FROM PRODUCT
DELETE FROM PRODUCT


INSERT INTO PRODUCT VALUES('p-1','s-1','제품1',5000,'빵','제품설명글1','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-2','s-1','제품2',5000,'빵','제품설명글2','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-3','s-1','제품3',5000,'빵','제품설명글3','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-4','s-1','제품4',5000,'빵','제품설명글4','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-5','s-1','제품5',5000,'빵','제품설명글5','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-6','s-1','제품6',5000,'빵','제품설명글6','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-7','s-2','제품7',5000,'빵','제품설명글7','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-8','s-2','제품8',5000,'빵','제품설명글8','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-9','s-3','제품9',5000,'빵','제품설명글9','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-10','s-3','제품10',5000,'빵','제품설명글10','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-11','s-3','제품11',5000,'빵','제품설명글11','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-12','s-4','제품12',5000,'빵','제품설명글12','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-13','s-4','제품13',5000,'빵','제품설명글13','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-14','s-5','제품14',5000,'빵','제품설명글14','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-15','s-6','제품15',5000,'빵','제품설명글15','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-16','s-6','제품16',5000,'빵','제품설명글16','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-17','s-6','제품17',5000,'빵','제품설명글17','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-18','s-7','제품18',5000,'빵','제품설명글18','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-19','s-7','제품19',5000,'빵','제품설명글19','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-20','s-1','제품20',5000,'빵','제품설명글20','Y',500,1000);



/* 장바구니 물품 */
select*from SHOPPING_BASKET_PRODUCT
delete from SHOPPING_BASKET_PRODUCT


INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-1','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-2','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-3','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-4','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-5','u-1','s-2',4,'s-2');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-6','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-7','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-8','u-1','s-3',4,'s-3');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-20','u-2','s-1',4,'s-3');


/* 제품 사진 */
select*from PRODUCT_PICTURE
delete from PRODUCT_PICTURE

INSERT INTO PRODUCT_PICTURE values('제품사진1','p-1','s-1');
INSERT INTO PRODUCT_PICTURE values('제품사진2','p-2','s-1');
INSERT INTO PRODUCT_PICTURE values('제품사진3','p-3','s-1');
INSERT INTO PRODUCT_PICTURE values('제품사진4','p-4','s-1');
INSERT INTO PRODUCT_PICTURE values('제품사진5','p-5','s-1');
INSERT INTO PRODUCT_PICTURE values('제품사진6','p-6','s-1');
INSERT INTO PRODUCT_PICTURE values('제품사진7','p-7','s-2');
INSERT INTO PRODUCT_PICTURE values('제품사진8','p-8','s-2');
INSERT INTO PRODUCT_PICTURE values('제품사진9','p-9','s-3');
INSERT INTO PRODUCT_PICTURE values('제품사진10','p-10','s-3');
INSERT INTO PRODUCT_PICTURE values('제품사진20','p-20','s-1');


/* 결제 내역 */
select*from PAYMENT_DETAILS
delete from PAYMENT_DETAILS


INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-1','s-1',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-2','s-1',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-3','s-1',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-4','s-1',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-5','s-2',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-8','s-3',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-7','s-1',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-2','p-20','s-1',0);                               




/* 예약 내역 - 결제내역에 있는 유저아이디와 매장아이디  제품아이디 참조해서 받아왔다는 가정하에 값 넣음.즉 원칙적으로는  결제내역 넣고 예약내역 넣는순서여야 함.  */
/* 예약 내역에는 날짜 뿐만 아니라 시간도 들어가있어야 하지 않나..? */
SELECT *FROM RESERVATION_DETAILS
DELETE FROM RESERVATION_DETAILS

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('201608030800', 'yyyy-mm-dd HH24:mi'),4,to_date('201608030800', 'yyyy-mm-dd HH24:mi'),to_date('201608041300', 'yyyy-mm-dd HH24:mi'),'p-1','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-2','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-3','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-4','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-5','s-2','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-8','s-3','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-7','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-20','s-1','u-2');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160804', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-20','s-1','u-2');



/*  즐겨 찾는 카드 번호  */
SELECT *FROM BOOKMARK_CARD_NUM
DELETE FROM BOOKMARK_CARD_NUM

INSERT INTO BOOKMARK_CARD_NUM VALUES('card-1','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('card-2','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('card-3','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('card-4','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('card-5','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('card-6','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('card-7','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('card-8','u-1');


/* 공지사항 */
SELECT * FROM NOTICE_BOARD_CONTENTS;
DELETE FROM NOTICE_BOARD_CONTENTS;

DROP SEQUENCE notice_board_no_seq;
CREATE SEQUENCE notice_board_no_seq;

INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'공지1','1',TO_DATE('2017-06-24', 'yyyy-mm-dd'),1);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'공지2','2',TO_DATE('2017-06-25', 'yyyy-mm-dd'),2);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'공지3','3',TO_DATE('2017-06-26', 'yyyy-mm-dd'),3);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'공지4','4',TO_DATE('2017-06-27', 'yyyy-mm-dd'),4);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'공지5','5',TO_DATE('2017-06-28', 'yyyy-mm-dd'),5);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'공지6','6',TO_DATE('2017-06-29', 'yyyy-mm-dd'),6);


/* 제품 증감폭 */
SELECT * FROM PRODUCT_GAP;
DELETE FROM PRODUCT_GAP;

INSERT INTO PRODUCT_GAP VALUES('D', '1', 'p-1', 's-1');
INSERT INTO PRODUCT_GAP VALUES('K', '2', 'p-2', 's-1');
INSERT INTO PRODUCT_GAP VALUES('U', '3', 'p-7', 's-2');
INSERT INTO PRODUCT_GAP VALUES('D', '4', 'p-8', 's-2');
INSERT INTO PRODUCT_GAP VALUES('U', '5', 'p-9', 's-3');


/* 매장 사진 */
SELECT * FROM STORE_PICTURE;
DELETE FROM STORE_PICTURE;

INSERT INTO STORE_PICTURE VALUES ('매장사진1', 's-1');
INSERT INTO STORE_PICTURE VALUES ('매장사진2', 's-1');
INSERT INTO STORE_PICTURE VALUES ('매장사진3', 's-1');
INSERT INTO STORE_PICTURE VALUES ('매장사진4', 's-2');
INSERT INTO STORE_PICTURE VALUES ('매장사진5', 's-2');
INSERT INTO STORE_PICTURE VALUES ('매장사진6', 's-3');

/* 이벤트 제품 */
SELECT * FROM event_product;
DELETE FROM event_product;



