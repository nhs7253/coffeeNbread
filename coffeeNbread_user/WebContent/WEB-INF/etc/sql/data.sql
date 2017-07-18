/* 유저 */
SELECT *FROM GENERAL_USER
DELETE FROM GENERAL_USER

/* 노현식 - 2017-07-03 수정 */  /* 비밀번호 1111 */
INSERT INTO GENERAL_USER VALUES('u-1','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','user1',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);
INSERT INTO GENERAL_USER VALUES('u-2','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','user2',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);
INSERT INTO GENERAL_USER VALUES('u-3','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','user3',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);
INSERT INTO GENERAL_USER VALUES('u-4','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','user4',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y',null);
INSERT INTO GENERAL_USER VALUES('u-5','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','user5',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y','s-1');

/* 권한 추가 
 * 관리자 - ROLE_CNB_ADMIN
 * 매점 - ROLE_CNB_STORE
 * 일반 유저 - ROLE_CNB_USER*/

INSERT INTO user_authority VALUES('u-1', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('u-2', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('u-3', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('u-4', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('u-5', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('admin', 'ROLE_CNB_ADMIN');

/* 매장 */
SELECT *FROM STORE
DELETE FROM STORE
/* 노현식 - 2017-07-10 수정 */ 
INSERT INTO STORE VALUES('s-1','매장1','매장소개글1','010-0000-0000','매장주소1','매장1@email.com', '빵',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-2','매장2','매장소개글2','010-0000-0000','매장주소2','매장2@email.com', '커피',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-3','매장3','매장소개글3','010-0000-0000','매장주소3','매장3@email.com', '커피, 빵',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-4','매장4','매장소개글4','010-0000-0000','매장주소4','매장4@email.com', '빵, 커피',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-5','매장5','매장소개글5','010-0000-0000','매장주소5','매장5@email.com', '커피',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-6','매장6','매장소개글6','010-0000-0000','매장주소6','매장6@email.com', '빵',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-7','매장7','매장소개글7','010-0000-0000','매장주소7','매장7@email.com', '빵, 커피, 쿠키',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');


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

 * 관리자 - ROLE_CNB_ADMIN
 * 매점 - ROLE_CNB_STORE
 * 일반 유저 - ROLE_CNB_USER

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

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',4,'u-1','b1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',2,'u-1','c1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',1,'u-1','b3','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',10,'u-1','b4','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170710', 'yyyy-mm-dd'),'r',20,'u-1','c2','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170710', 'yyyy-mm-dd'),'r',20,'u-1','b5','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170706', 'yyyy-mm-dd'),'r',5,'u-1','ck1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160906', 'yyyy-mm-dd'),'f',10,'u-10','p-1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170625', 'yyyy-mm-dd'),'r',20,'u-10','p-3','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170506', 'yyyy-mm-dd'),'r',15,'u-10','p-1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170306', 'yyyy-mm-dd'),'f',0,'u-10','p-1','s-1',5);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170306', 'yyyy-mm-dd'),'f',0,'u-10','p-3','s-1',20);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160810', 'yyyy-mm-dd'),'f',0,'u-10','p-4','s-1',5);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160910', 'yyyy-mm-dd'),'r',5,'u-10','p-1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20161110', 'yyyy-mm-dd'),'r',5,'u-10','p-1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170210', 'yyyy-mm-dd'),'r',5,'u-10','p-3','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170404', 'yyyy-mm-dd'),'r',5,'u-10','p-4','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',5,'u-10','p-1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',5,'u-10','p-2','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',5,'u-10','p-3','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',5,'u-10','p-4','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',5,'u-10','p-5','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160915', 'yyyy-mm-dd'),'r',5,'u-10','p-5','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                


INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',5,'u-10','p-3','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',5,'u-10','p-4','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',5,'u-10','p-5','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',8,'u-10','p-1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',25,'u-10','p-2','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',5,'u-10','p-4','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',15,'u-10','p-2','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',5,'u-10','p-3','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',3,'u-10','p-1','s-1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                

/* 예약 내역 - 결제내역에 있는 유저아이디와 매장아이디  제품아이디 참조해서 받아왔다는 가정하에 값 넣음.즉 원칙적으로는  결제내역 넣고 예약내역 넣는순서여야 함.  */
/* 예약 내역에는 날짜 뿐만 아니라 시간도 들어가있어야 하지 않나..? */  /* 결제 내역에있는 r -에 해당되는 내용만 가져와야 함 */

SELECT *FROM RESERVATION_DETAILS
DELETE FROM RESERVATION_DETAILS

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-12','s-4','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160803', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-3','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160804', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-2','s-1','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160804', 'yyyy-mm-dd'),4,to_date('20160803', 'yyyy-mm-dd'),to_date('20160804','yyyy-mm-dd'),'p-1','s-1','u-1');

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),4,null,to_date('20170804','yyyy-mm-dd'),'c2','s-1','u-11');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),4,null,to_date('20170804','yyyy-mm-dd'),'ck1','s-1','u-11');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,null,to_date('20170712','yyyy-mm-dd'),'b1','s-1','u-11');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,null,to_date('20170712','yyyy-mm-dd'),'b3','s-1','u-11');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),4,null,to_date('20170711','yyyy-mm-dd'),'p-1','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),4,null,to_date('20170711','yyyy-mm-dd'),'p-2','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170710', 'yyyy-mm-dd'),4,null,to_date('20170713','yyyy-mm-dd'),'p-3','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170710', 'yyyy-mm-dd'),4,null,to_date('20170713','yyyy-mm-dd'),'p-4','s-1','u-10');

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160906', 'yyyy-mm-dd'),10,null,to_date('20170712','yyyy-mm-dd'),'p-1','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170625', 'yyyy-mm-dd'),20,null,to_date('20170712','yyyy-mm-dd'),'p-3','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170506', 'yyyy-mm-dd'),15,null,to_date('20170717','yyyy-mm-dd'),'p-1','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170612', 'yyyy-mm-dd'),4,null,to_date('20170717','yyyy-mm-dd'),'p-5','s-1','u-10');

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20160910', 'yyyy-mm-dd'),5,null,to_date('20170715','yyyy-mm-dd'),'p-1','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20161110', 'yyyy-mm-dd'),5,null,to_date('20170714','yyyy-mm-dd'),'p-1','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170210', 'yyyy-mm-dd'),5,null,to_date('20170713','yyyy-mm-dd'),'p-3','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170404', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170504', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20150504', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20150104', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20130504', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20140504', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20120204', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20130604', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20181004', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20110504', 'yyyy-mm-dd'),5,null,to_date('20170712','yyyy-mm-dd'),'p-4','s-1','u-10');



CREATE SEQUENCE reservation_no_seq;
DROP SEQUENCE reservation_no_seq;


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

INSERT INTO PRODUCT_GAP VALUES('K', '0', 'p-3', 's-1');
INSERT INTO PRODUCT_GAP VALUES('K', '0', 'p-4', 's-1');
INSERT INTO PRODUCT_GAP VALUES('U', '3', 'p-7', 's-2');
INSERT INTO PRODUCT_GAP VALUES('D', '4', 'p-8', 's-2');
INSERT INTO PRODUCT_GAP VALUES('U', '5', 'p-9', 's-3');
INSERT INTO PRODUCT_GAP VALUES('K', '0', 'p-20', 's-1');
INSERT INTO PRODUCT_GAP VALUES('K', '0', 'p-5', 's-1');


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

INSERT INTO STORE_PAYMENT_OPTIONlIST VALUES('s-1','c')
INSERT INTO STORE_PAYMENT_OPTIONlIST VALUES('s-1','p')

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



delete  from recipe_board_contents





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
/* u-2가 작성한 레시판 게시글들 */
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글20', '레시피제목20', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-2','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글21', '레시피제목21', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-2','s-7');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글22', '레시피제목22', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-2','s-6');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '레시피글23', '레시피제목23', TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'레시피사진',10,'u-2','s-6');


/* qna board 목록 */		
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, '문의글작성자1', '문의글제목1', '내용 1',10, TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, '문의글작성자2', '문의글제목2', '내용 2',10, TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, '문의글작성자3', '문의글제목3', '내용 3',10, TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, '문의글작성자4', '문의글제목4', '내용4',10, TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, '문의글작성자5', '문의글제목5', '내용 5',10, TO_DATE('2017-06-26', 'yyyy-mm-dd'),10,'Y');

/* 댓글 목록  */

  -- 레시피 게시판에있는거 댓글
INSERT INTO board_reply VALUES(reply_no_seq.nextval, '댓글 1', 'user-1', TO_DATE('2017-06-26', 'yyyy-mm-dd'),'',1);
INSERT INTO board_reply VALUES(reply_no_seq.nextval, '댓글 1', 'user-1', TO_DATE('2017-06-26', 'yyyy-mm-dd'),1,'');
 --Qna 게시판에 있는 댓글
INSERT INTO board_reply VALUES(reply_no_seq.nextval, '댓글 1', 'user-1', TO_DATE('2017-06-26', 'yyyy-mm-dd'),'',2);
INSERT INTO board_reply VALUES(reply_no_seq.nextval, '댓글 1', 'user-1', TO_DATE('2017-06-26', 'yyyy-mm-dd'),2,'');


--payment_optionlist
INSERT INTO payment_optionlist VALUES('1','카드');
INSERT INTO payment_optionlist VALUES('2','현금');
INSERT INTO payment_optionlist VALUES('3','카카오페이');


INSERT INTO PAYMENT_OPTIONlIST VALUES('c','카드');
INSERT INTO PAYMENT_OPTIONlIST VALUES('p','현금');
INSERT INTO PAYMENT_OPTIONlIST VALUES('o','카카오페이');

--general_user
                                                        -- 2017-07-17 김형주 추가
----------------------------------------------------------------실 데이터-----------------------------------------------------------

/* 매장 등록시 - 매장사진, 매장좌표 */

INSERT INTO STORE VALUES('s-100','광주이디아','저희 매장을 방문해 주셔서 진심으로 감사드립니다.저희 매장은 다른 매장과 다르게 매일 신선한재료로 여러분들을 맞이하고있습니다. 아침마다 추천메뉴바뀌니 많은 관심부탁드립니다.'
                          , '062-372-4755','광주 서구 운천로 263에 위치한 광주이디아점입니다.','GwangjuEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');
                          
INSERT INTO STORE VALUES('s-101','문정스타벅스','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 문정체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','서울특별시 송파구 가락2동 동남로 141','Munjung@email.com',
                          '빵,커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');                          

                          
                          
                          
                          
INSERT INTO STORE VALUES('s-102','부산엔젤리너스','부산에서 제일맛있는 카페체인점으로 자부합니다.매주월요일마다 할인행사하고있습니다. 사이트를 참조하시면 더욱더 자세한내용을 얻으실수 있습니다.','051-314-3100',
                         '부산 사상구 주례로10번길 110입니다.','BusanAngel@email.com','빵,커피',400,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009051000','yyyy-mm-dd hh24:mi'),'N');                          
                          
INSERT INTO STORE VALUES('s-103','영등포 할리스점','저희 매장을 방문해 주셔서 진심으로 감사드립니다.영등포역 근처에 위치하고있어 아침 9시부터 11시까지는 사람들이 붐비므로 참고하시길 바랍니다.최근 조회수가 제일 많은 매장으로 뽑히기도 했는데요. 그만큼 저희만의 특색있는 메뉴가 있으므로 참고하시기바랍니다.'
                          , '070-4159-8897','서울 영등포구 경인로 847에 위치한 영등포 할리스점입니다.','hollys@email.com','빵',10340,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009051000','yyyy-mm-dd hh24:mi'),'N');                          
                    
                          
INSERT INTO STORE VALUES('s-104','판교 더리터점','저희 매장을 방문해주셔서 감사합니다.판교테크노벨리에 위치해서 아침9시부터 11시까지는 직장인들이 많이 붐빕니다.그리고 저희 매출의 1등은 청포도에이드가 베스트에요',
                            '031-724-2520','경기 성남시 분당구 대왕판교로 660 ,삼평동 670 유스페이스1 1층 146호','theliter@email.com', '빵',500,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009051000','yyyy-mm-dd hh24:mi'),'N');


                            
   


/* 매장 사진 */

INSERT INTO STORE_PICTURE VALUES ('up_image/store_image/광주이디아','s-100');
INSERT INTO STORE_PICTURE VALUES ('up_image/store_image/모노마포', 's-101');
INSERT INTO STORE_PICTURE VALUES ('up_image/store_image/부산백화점', 's-102');
INSERT INTO STORE_PICTURE VALUES ('up_image/store_image/부산카페',  's-103');
INSERT INTO STORE_PICTURE VALUES ('up_image/store_image/엔젤리너스', 's-104');
INSERT INTO STORE_PICTURE VALUES ('up_image/store_image/카페베네', 's-105');



/* 공지사항 */

INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'서버상의 오류로 인하여 2017년 07월 22일 부득이하게 서버점검 할 예정이오니 이용에 불편함을끼쳐드려 죄송합니다.빠른시일내에 복구하겠습니다.','2017년 07월 22일 서버점검 예정이오니 양해부탁드립니다.',TO_DATE('2017-06-24', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'문정 스타벅스체인점이 내부공사로 인하여 2017년 07월 22일부터 29일까지 이용을 할수 없다고 합니다.','스타벅스 문정점 내부공사로 인하여 07월 22일~07월 29일까지 휴무',TO_DATE('2017-06-28', 'yyyy-mm-dd'),5);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'1.협약된 매장과 서버운영자간의 더 나은 소통을 위해 문자전송서비스 추가,2.회원이 매장에 레시피 게시판에 사진 여러장 넣을수 있는 기능 추가 ','2017년 말에 서버 업데이트 예정',TO_DATE('2017-07-30', 'yyyy-mm-dd'),10);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'최근에 탈퇴한 회원정보는 관리자가 갖고있는지에 관하여 많은 회원분들이 문의를 하였었는데요.저희는 회원이 탈퇴한 순간 정보를 바로지워지므로 걱정안하셔도 됩니다.','탈퇴한 회원 정보와 관련된 공지사항',TO_DATE('2017-09-30', 'yyyy-mm-dd'),50);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'판교 더리터점과 논의 끝에 기존가격유지하겠다고 하였으니 걱정안하셔도 됩니다.','판교 더리터점에서 아이스 아메리카노가격 관련 공지사항',TO_DATE('2017-06-28', 'yyyy-mm-dd'),5);








