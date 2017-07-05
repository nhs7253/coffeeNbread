/* 유저 */
SELECT *FROM GENERAL_USER
DELETE FROM GENERAL_USER

/* 노현식 - 2017-07-03 수정 */  
INSERT INTO GENERAL_USER VALUES('u-1','pw-1','user1',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);
INSERT INTO GENERAL_USER VALUES('u-2','pw-2','user2',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);
INSERT INTO GENERAL_USER VALUES('u-3','pw-3','user3',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);
INSERT INTO GENERAL_USER VALUES('u-4','pw-4','user4',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);


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
INSERT INTO PRODUCT VALUES('p-6','s-1','제품6',5000,'빵','제품설명글6','Y',500,1000); --s-1- > p-6까지
INSERT INTO PRODUCT VALUES('p-7','s-2','제품7',5000,'빵','제품설명글7','Y',500,1000); 
INSERT INTO PRODUCT VALUES('p-8','s-2','제품8',5000,'빵','제품설명글8','Y',500,1000);--s-2- > p-8까지
INSERT INTO PRODUCT VALUES('p-9','s-3','제품9',5000,'빵','제품설명글9','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-10','s-3','제품10',5000,'빵','제품설명글10','Y',500,1000); 
INSERT INTO PRODUCT VALUES('p-11','s-3','제품11',5000,'빵','제품설명글11','Y',500,1000); --s-3-> p-10까지
INSERT INTO PRODUCT VALUES('p-12','s-4','제품12',5000,'빵','제품설명글12','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-13','s-4','제품13',5000,'빵','제품설명글13','Y',500,1000); --s-4-> p-13까지
INSERT INTO PRODUCT VALUES('p-14','s-5','제품14',5000,'빵','제품설명글14','Y',500,1000); --s-5-> p-14까지
INSERT INTO PRODUCT VALUES('p-15','s-6','제품15',5000,'빵','제품설명글15','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-16','s-6','제품16',5000,'빵','제품설명글16','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-17','s-6','제품17',5000,'빵','제품설명글17','Y',500,1000); --s-6-> p-17까지
INSERT INTO PRODUCT VALUES('p-18','s-7','제품18',5000,'빵','제품설명글18','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-19','s-7','제품19',5000,'빵','제품설명글19','Y',500,1000); --s-7-> p-19까지
/* 김형주 - 2017-07-01 수정 */
INSERT INTO PRODUCT VALUES('p-20','s-7','제품20',5000,'빵','제품설명글20','Y',500,1000); 
/* 김형주 - 2017-07-01 추가 */
INSERT INTO PRODUCT VALUES('p-21','s-7','제품21',5000,'빵','제품설명글20','Y',500,1000);--s-7 -> p-21까지



/* 장바구니 물품 */
select*from SHOPPING_BASKET_PRODUCT
delete from SHOPPING_BASKET_PRODUCT


INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-1','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-2','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-3','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-4','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-5','u-1','s-1',4,'s-1');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-7','u-1','s-2',4,'s-2');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-8','u-1','s-2',4,'s-2');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-9','u-1','s-3',4,'s-3');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-10','u-1','s-3',4,'s-3');
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-12','u-1','s-4',4,'s-4');  -- 여기까지가  결제내역에 들어가는 내용이랑 같은부분  


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

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-1','s-1',0);   -- s-1 /r,f모두 가능 /예약/ 카드                            
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-2','s-1',0);   -- s-1   -> 같은유저가 여러제품살경우 어떻게 나올지 보여주기위함.
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-3','s-1',0);   -- s-1 /r,f모두 가능 /예약/카드                            
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'p',to_date('20160803', 'yyyy-mm-dd'),'f',4,'u-1','p-4','s-1',0);   --s-1 / r,f모두 가능/현장/현금                           
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',4,'u-1','p-5','s-1',0);  -- s-1 / r,f모두 가능/현장/카드  
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-7','s-2',0);  -- s-2 / r,f모두 가능/ 예약/카드  
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'p',to_date('20160803', 'yyyy-mm-dd'),'f',4,'u-1','p-8','s-2',0);  -- s-2 / r,f 모두 가능 /현장/현금                                   
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',4,'u-1','p-9','s-3',0); --  s-3  / f(현장)만 가능/ 카드
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'p',to_date('20160803', 'yyyy-mm-dd'),'f',4,'u-1','p-10','s-3',0);  -- s-3 / f(현장)만 가능  /현장
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-12','s-4',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              




/* 예약 내역 - 결제내역에 있는 유저아이디와 매장아이디  제품아이디 참조해서 받아왔다는 가정하에 값 넣음.즉 원칙적으로는  결제내역 넣고 예약내역 넣는순서여야 함.  */
/* 예약 내역에는 날짜 뿐만 아니라 시간도 들어가있어야 하지 않나..? */  /* 결제 내역에있는 r -에 해당되는 내용만 가져와야 함 */

SELECT *FROM RESERVATION_DETAILS
DELETE FROM RESERVATION_DETAILS

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-12','s-4','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-3','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160804', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-2','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160804', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-1','s-1','u-1');



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
DELETE FROM PRODUCT_GAP

INSERT INTO PRODUCT_GAP VALUES('D', '1', 'p-1', 's-1');
INSERT INTO PRODUCT_GAP VALUES('K', '2', 'p-2', 's-1');
INSERT INTO PRODUCT_GAP VALUES('U', '3', 'p-7', 's-2');
INSERT INTO PRODUCT_GAP VALUES('D', '4', 'p-8', 's-2');
INSERT INTO PRODUCT_GAP VALUES('U', '5', 'p-9', 's-3');
INSERT INTO PRODUCT_GAP VALUES('K', '0', 'p-20', 's-1');
INSERT INTO PRODUCT_GAP VALUES('K', '0', 'p-4', 's-1');


/* 매장 사진 */
SELECT * FROM STORE_PICTURE;
DELETE FROM STORE_PICTURE;

INSERT INTO STORE_PICTURE VALUES ('매장사진1', 's-1');
INSERT INTO STORE_PICTURE VALUES ('매장사진2', 's-1');
INSERT INTO STORE_PICTURE VALUES ('매장사진3', 's-1');
INSERT INTO STORE_PICTURE VALUES ('매장사진4', 's-2');
INSERT INTO STORE_PICTURE VALUES ('매장사진5', 's-2');
INSERT INTO STORE_PICTURE VALUES ('매장사진6', 's-3');

/* 매장 이벤트 */
SELECT * FROM STORE_EVENT;
DELETE FROM STORE_EVENT;

INSERT INTO STORE_EVENT VALUES(event_no_seq.nextval, 's-1', '이벤트1', 'Y', TO_DATE('2017-06-26', 'yyyy-mm-dd'), TO_DATE('2017-06-28', 'yyyy-mm-dd'), '이벤트1입니다', 'N', 0, 'N', '이벤트사진1', 'N');
INSERT INTO STORE_EVENT VALUES(event_no_seq.nextval, 's-2', '이벤트2', 'Y', TO_DATE('2017-06-26', 'yyyy-mm-dd'), TO_DATE('2017-06-28', 'yyyy-mm-dd'), '이벤트2입니다', 'N', 0, 'N', '이벤트사진2', 'N');
INSERT INTO STORE_EVENT VALUES(event_no_seq.nextval, 's-3', '이벤트3', 'Y', TO_DATE('2017-06-26', 'yyyy-mm-dd'), TO_DATE('2017-06-28', 'yyyy-mm-dd'), '이벤트3입니다', 'N', 0, 'N', '이벤트사진3', 'N');
INSERT INTO STORE_EVENT VALUES(event_no_seq.nextval, 's-1', '이벤트4', 'Y', TO_DATE('2017-06-26', 'yyyy-mm-dd'), TO_DATE('2017-06-28', 'yyyy-mm-dd'), '이벤트4입니다', 'N', 0, 'N', '이벤트사진4', 'N');
INSERT INTO STORE_EVENT VALUES(event_no_seq.nextval, 's-3', '이벤트5', 'Y', TO_DATE('2017-06-26', 'yyyy-mm-dd'), TO_DATE('2017-06-28', 'yyyy-mm-dd'), '이벤트5입니다', 'N', 0, 'N', '이벤트사진5', 'N');


/* 이벤트 제품 */
SELECT * FROM event_product;
DELETE FROM event_product;


/* 결제 종류 */
SELECT *FROM PAYMENT_OPTIONLIST;
DELETE FROM PAYMENT_OPTIONLIST;

INSERT INTO EVENT_PRODUCT VALUES('p-1', 's-1', 4);
INSERT INTO EVENT_PRODUCT VALUES('p-3', 's-1', 4);
INSERT INTO EVENT_PRODUCT VALUES('p-11', 's-3', 6);
INSERT INTO EVENT_PRODUCT VALUES('p-7', 's-2', 7);
INSERT INTO EVENT_PRODUCT VALUES('p-2', 's-1', 3);


INSERT INTO PAYMENT_OPTIONLIST VALUES('c','카드');
INSERT INTO PAYMENT_OPTIONLIST VALUES('p','현금');

/* 매장 결제 종류 */   -- 예약만 가능한 매장만   'c' 로 넣어야 함. 
SELECT *FROM STORE_PAYMENT_OPTIONLIST;
DELETE FROM STORE_PAYMENT_OPTIONLIST;

INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-1','c');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-1','p');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-2','c');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-2','p');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-3','c');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-3','p');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-4','c');
<<<<<<< HEAD
=======

delete  from recipe_board_contents
>>>>>>> branch 'master' of https://github.com/nhs7253/coffeeNbread.git



INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글1', '레시피제목1', TO_DATE('2017-06-26', 'yyyy-mm-dd'),2,'레시피사진',2,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글2', '레시피제목2', TO_DATE('2017-06-27', 'yyyy-mm-dd'),3,'레시피사진',3,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글3', '레시피제목3', TO_DATE('2017-06-28', 'yyyy-mm-dd'),4,'레시피사진',4,'u-1','s-7');

INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글4', '레시피제목4', TO_DATE('2017-06-29', 'yyyy-mm-dd'),5,'레시피사진',5,'u-1','s-6');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글5', '레시피제목5', TO_DATE('2017-06-30', 'yyyy-mm-dd'),6,'레시피사진',6,'u-1','s-6');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글6', '레시피제목6', TO_DATE('2017-06-31', 'yyyy-mm-dd'),7,'레시피사진',7,'u-1','s-6');

INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글7', '레시피제목7', TO_DATE('2017-07-01', 'yyyy-mm-dd'),8,'레시피사진',8,'u-2','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글8', '레시피제목8', TO_DATE('2017-07-02', 'yyyy-mm-dd'),9,'레시피사진',9,'u-2','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글9', '레시피제목9', TO_DATE('2017-07-03', 'yyyy-mm-dd'),10,'레시피사진',10,'u-2','s-7');

INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글10', '레시피제목10', TO_DATE('2017-07-04', 'yyyy-mm-dd'),11,'레시피사진',11,'u-3','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글10', '레시피제목11', TO_DATE('2017-07-05', 'yyyy-mm-dd'),12,'레시피사진',12,'u-3','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글12', '레시피제목12', TO_DATE('2017-07-06', 'yyyy-mm-dd'),13,'레시피사진',13,'u-3','s-7');

INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글14', '레시피제목14', TO_DATE('2017-07-06', 'yyyy-mm-dd'),14,'레시피사진',14,'','');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글15', '레시피제목15', TO_DATE('2017-07-06', 'yyyy-mm-dd'),15,'레시피사진',15,'','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-07-06', 'yyyy-mm-dd'),16,'레시피사진',15,'u-1','');



/*  레시피 게시판 추가  - 김형주 2017-07-05 */
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글12', '레시피제목12', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글13', '레시피제목13', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글14', '레시피제목14', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글15', '레시피제목15', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글17', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글18', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글16', '레시피제목16', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');
/* 테스트용  받으셔도 되고 안받으셔도 됩니다.*/
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글17', 'tttt', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-1','s-7');


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
