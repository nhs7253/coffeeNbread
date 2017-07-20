/* 유저 */
SELECT *FROM GENERAL_USER
DELETE FROM GENERAL_USER
                            
/* 노현식 - 2017-07-03 수정 */  /* 비밀번호 1111 */
INSERT INTO GENERAL_USER VALUES('u-1','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','김형주',to_date('20170622', 'yyyy-mm-dd'),'남','khjsuccess6808@naver.com','01050166816','서울시 송파구 문정동','Y',null);
INSERT INTO GENERAL_USER VALUES('u-2','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','이진영',to_date('20170622', 'yyyy-mm-dd'),'여','jy@naver.com','01094080923','경기도 수원시 영통구','Y',null);
INSERT INTO GENERAL_USER VALUES('us','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','최민희',to_date('20170622', 'yyyy-mm-dd'),'여','minimini@naver.com','01099506219','경기도 고양시 일산 서구 ','Y','s-100');
INSERT INTO GENERAL_USER VALUES('admin','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','노현식',to_date('20160622', 'yyyy-mm-dd'),'남','hyungsik@naver.com','01037962472','경상남도 김해시 ','Y',null);

/* 권한 추가 
 * 관리자 - ROLE_CNB_ADMIN
 * 매점 - ROLE_CNB_STORE
 * 일반 유저 - ROLE_CNB_USER*/
select *from USER_AUTHORITY
delete from USER_AUTHORITY
INSERT INTO user_authority VALUES('u-1', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('u-2', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('us', 'ROLE_CNB_STORE');
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

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',4,'u-1','p-6','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',5,'u-1','p-7','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',1,'u-1','p-8','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',5,'u-2','p-6','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',6,'u-2','p-7','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160915', 'yyyy-mm-dd'),'r',15,'u-2','p-8','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                


INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',5,'u-1','p-3','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',5,'u-1','p-4','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',5,'u-2','p-5','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',8,'u-1','p-1','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',25,'u-1','p-2','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',5,'u-1','p-3','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',15,'u-2','p-4','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',5,'u-2','p-3','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',3,'u-2','p-1','s1',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                

INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170720', 'yyyy-mm-dd'),'r',25,'u-1','p11','s5',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170719', 'yyyy-mm-dd'),'r',15,'u-2','p11','s5',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170718', 'yyyy-mm-dd'),'r',9,'u-3','p11','s5',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170717', 'yyyy-mm-dd'),'r',7,'u-4','p11','s5',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20170716', 'yyyy-mm-dd'),'r',5,'u-1','p11','s5',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160915', 'yyyy-mm-dd'),'r',1,'u-2','p11','s5',0);  -- s-4 /  r(예약)만 가능 / 예약/ 카드                                


/* 예약 내역 - 결제내역에 있는 유저아이디와 매장아이디  제품아이디 참조해서 받아왔다는 가정하에 값 넣음.즉 원칙적으로는  결제내역 넣고 예약내역 넣는순서여야 함.  */
/* 예약 내역에는 날짜 뿐만 아니라 시간도 들어가있어야 하지 않나..? */  /* 결제 내역에있는 r -에 해당되는 내용만 가져와야 함 */



INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),4,to_date('20170604', 'yyyy-mm-dd'),to_date('20170605','yyyy-mm-dd'),'p-100','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),6,to_date('20170604', 'yyyy-mm-dd'),to_date('20170605','yyyy-mm-dd'),'p-101','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,to_date('20170704', 'yyyy-mm-dd'),to_date('20170712','yyyy-mm-dd'),'p-102','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,to_date('20170704', 'yyyy-mm-dd'),to_date('20170713','yyyy-mm-dd'),'p-103','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),7,to_date('20170706', 'yyyy-mm-dd'),to_date('20170714','yyyy-mm-dd'),'p-104','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),10,to_date('20170707', 'yyyy-mm-dd'),to_date('20170707','yyyy-mm-dd'),'p-105','s-103','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170710', 'yyyy-mm-dd'),4,to_date('20170712', 'yyyy-mm-dd'),to_date('20170713','yyyy-mm-dd'),'p-106','s-104','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170710', 'yyyy-mm-dd'),12,to_date('20170711', 'yyyy-mm-dd'),to_date('20170713','yyyy-mm-dd'),'p-107','s-104','u-1');

INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170720', 'yyyy-mm-dd'),10,null,to_date('20170720','yyyy-mm-dd'),'p-108','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170719', 'yyyy-mm-dd'),20,null,to_date('20170721','yyyy-mm-dd'),'p-109','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170719', 'yyyy-mm-dd'),15,null,to_date('20170722','yyyy-mm-dd'),'p-110','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170720', 'yyyy-mm-dd'),4,null,to_date('20170725','yyyy-mm-dd'),'p-111','s-102','u-1');



--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('201507041108', 'yyyy-MM-dd HH:mi'),15,null,to_date('201507041108', 'yyyy-MM-dd HH:mi'),'p-1','s1','u-1');
--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('201506042308', 'yyyy-MM-dd HH:mi'),6,null,to_date('201506042308', 'yyyy-MM-dd HH:mi'),'p-2','s1','u-1');
--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('201605040908', 'yyyy-MM-dd HH:mi'),2,null,to_date('201605040908', 'yyyy-MM-dd HH:mi'),'p-7','s1','u-1');
--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('201710040708', 'yyyy-MM-dd HH:mi'),7,null,to_date('201710040708', 'yyyy-MM-dd HH:mi'),'p-6','s1','u-1');
--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('201804041308', 'yyyy-MM-dd HH24:mi'),25,null,to_date('201804041308', 'yyyy-MM-dd HH24:mi'),'p-5','s1','u-2');
--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('201205041508', 'yyyy-MM-dd HH24:mi'),5,null,to_date('201205041508', 'yyyy-MM-dd HH24:mi'),'p-6','s1','u-2');
--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20181004', 'yyyy-mm-dd'),9,null,to_date('20170712','yyyy-mm-dd'),'p-7','s1','u-2');
--INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20110504', 'yyyy-mm-dd'),3,null,to_date('20170712','yyyy-mm-dd'),'p-8','s1','u-2');



CREATE SEQUENCE reservation_no_seq;
DROP SEQUENCE reservation_no_seq;
                                                     -- 2017-07-20 김형주 추가
----------------------------------------------------------------실 데이터-----------------------------------------------------------
/* 유저 */

INSERT INTO GENERAL_USER VALUES('u-1','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','김형주',to_date('20170622', 'yyyy-mm-dd'),'남','khjsuccess6808@naver.com','010-5016-6816','서울시 송파구 문정동','Y',null);
INSERT INTO GENERAL_USER VALUES('u-2','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','이진영',to_date('20170622', 'yyyy-mm-dd'),'여','jy@naver.com','010-1234-3242','경기도 고양시 일산 서구','Y',null);
INSERT INTO GENERAL_USER VALUES('us','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','최민희',to_date('20170622', 'yyyy-mm-dd'),'여','minimini@naver.com','010-3453-3423','경기도 수원시 영통구 ','Y','s-100');
INSERT INTO GENERAL_USER VALUES('admin','$2a$10$60vYdQzTq.zJ3JDn3HL5xOkLvSMtHX0givzaBXOPAeXQvJs6BOwCe','노현식',to_date('20160622', 'yyyy-mm-dd'),'남','hyungsik@naver.com','010-4564-2342','경상남도 김해시 ','Y',null);

/* 권한 추가 
 * 관리자 - ROLE_CNB_ADMIN
 * 매점 - ROLE_CNB_STORE
 * 일반 유저 - ROLE_CNB_USER*/

INSERT INTO user_authority VALUES('u-1', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('u-2', 'ROLE_CNB_USER');
INSERT INTO user_authority VALUES('us', 'ROLE_CNB_STORE');
INSERT INTO user_authority VALUES('admin', 'ROLE_CNB_ADMIN');

/* 매장 등록시 - 매장사진, 매장좌표 */
select*from store
delete from store
INSERT INTO STORE VALUES('s-100','판교 이디아','저희 매장을 방문해 주셔서 진심으로 감사드립니다.저희 매장은 다른 매장과 다르게 매일 신선한재료로 여러분들을 맞이하고있습니다. 아침마다 추천메뉴바뀌니 많은 관심부탁드립니다.'
                          , '062-372-4755','판교동 625에 위치한 판교 이디아점입니다.','PEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'Y');
                          
INSERT INTO STORE VALUES('s-101','판교 스타벅스','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 판교체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','판교 삼평동 분당내곡로 150','Munjung@email.com',
                          '빵,커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'Y');                          
                                         
                          
INSERT INTO STORE VALUES('s-102','판교 엔젤리너스','판교에서 제일맛있는 카페체인점으로 자부합니다.매주월요일마다 할인행사하고있습니다. 사이트를 참조하시면 더욱더 자세한내용을 얻으실수 있습니다.','051-314-3100',
                         '판교 삼평동 대왕판교로 660 유스페이스 1B-221호','BusanAngel@email.com','빵,커피',400,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'Y');                          
                          
INSERT INTO STORE VALUES('s-103','판교 할리스','저희 매장을 방문해 주셔서 진심으로 감사드립니다.영등포역 근처에 위치하고있어 아침 9시부터 11시까지는 사람들이 붐비므로 참고하시길 바랍니다.최근 조회수가 제일 많은 매장으로 뽑히기도 했는데요. 그만큼 저희만의 특색있는 메뉴가 있으므로 참고하시기바랍니다.'
                          , '070-4159-8897','서울 영등포구 경인로 847에 위치한 영등포 할리스점입니다.','hollys@email.com','빵',10340,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009051000','yyyy-mm-dd hh24:mi'),'Y');                          
                    
                          

INSERT INTO STORE VALUES('s-105','판교 코피아','ㅇ'
                          , '062-372-4755','삼평동 691-1 1층 코피아','GwangjuEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'Y');
                          
INSERT INTO STORE VALUES('s-106','판교 파리바게트','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 문정체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','판교 백현동 578-5','Munjung@email.com',
                          '빵,커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');                          
                         
                         
                          
INSERT INTO STORE VALUES('s-107','판교 뚜레주르','부산에서 제일맛있는 카페체인점으로 자부합니다.매주월요일마다 할인행사하고있습니다. 사이트를 참조하시면 더욱더 자세한내용을 얻으실수 있습니다.','051-314-3100',
                         '판교 삼평동 741','BusanAngel@email.com','빵,커피',400,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'Y');                          
                          
INSERT INTO STORE VALUES('s-108','판교 그래비티 ','저희 매장을 방문해 주셔서 진심으로 감사드립니다.영등포역 근처에 위치하고있어 아침 9시부터 11시까지는 사람들이 붐비므로 참고하시길 바랍니다.최근 조회수가 제일 많은 매장으로 뽑히기도 했는데요. 그만큼 저희만의 특색있는 메뉴가 있으므로 참고하시기바랍니다.'
                          , '070-4159-8897','판교 삼평동 산29-16','hollys@email.com','빵',10340,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'Y');                          
                    
                          
INSERT INTO STORE VALUES('s-109','판교 요거프레소','저희 매장을 방문해주셔서 감사합니다.판교테크노벨리에 위치해서 아침9시부터 11시까지는 직장인들이 많이 붐빕니다.그리고 저희 매출의 1등은 청포도에이드가 베스트에요',
                            '031-724-2520','경기 성남시 분당구 대왕판교로 660 ,삼평동 670 유스페이스1 1층 146호','theliter@email.com', '빵',500,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');

INSERT INTO STORE VALUES('s-110','판교 서브웨이','저희 매장을 방문해주셔서 감사합니다.판교테크노벨리에 위치해서 아침9시부터 11시까지는 직장인들이 많이 붐빕니다.그리고 저희 매출의 1등은 청포도에이드가 베스트에요',
                            '031-724-2520','삼평동 판교역로 192번길 14-2','theliter@email.com', '빵',500,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'Y');

INSERT INTO STORE VALUES('s-111','판교 빵커요','저희 매장을 방문해 주셔서 진심으로 감사드립니다.저희 매장은 다른 매장과 다르게 매일 신선한재료로 여러분들을 맞이하고있습니다. 아침마다 추천메뉴바뀌니 많은 관심부탁드립니다.'
                          , '062-372-4755','삼평동 판교역로 192번길 16','GwangjuEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052000','yyyy-mm-dd hh24:mi'),'Y');
                          
INSERT INTO STORE VALUES('s-112','판교 커피후','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 문정체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','판교역로 145라 스트리트 2동 2층','Munjung@email.com',
                          '커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');                          
                                                                        
                          
INSERT INTO STORE VALUES('s-113','판교 디초콜릿','부산에서 제일맛있는 카페체인점으로 자부합니다.매주월요일마다 할인행사하고있습니다. 사이트를 참조하시면 더욱더 자세한내용을 얻으실수 있습니다.','051-314-3100',
                         '동판교로 177번길 25','BusanAngel@email.com','빵,커피',400,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052300','yyyy-mm-dd hh24:mi'),'N');                          
                          
INSERT INTO STORE VALUES('s-114','판교 라디오','저희 매장을 방문해 주셔서 진심으로 감사드립니다.영등포역 근처에 위치하고있어 아침 9시부터 11시까지는 사람들이 붐비므로 참고하시길 바랍니다.최근 조회수가 제일 많은 매장으로 뽑히기도 했는데요. 그만큼 저희만의 특색있는 메뉴가 있으므로 참고하시기바랍니다.'
                          , '070-4159-8897','판교동 서판교로 44번길 17-5','hollys@email.com','타르트,커피',10340,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');                          
                                                                                                               
/*  즐겨 찾는 카드 번호  */


INSERT INTO BOOKMARK_CARD_NUM VALUES('1004-333-22202','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('1002-333-33044','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('1008-322-49584','u-1');
INSERT INTO BOOKMARK_CARD_NUM VALUES('1084-333-22293','u-1');


/*매장사진*/

INSERT INTO STORE_PICTURE VALUES ('store_image/판교이디아.jpg','s-100');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교스타벅스.jpg', 's-101');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교엔젤리너스.jpg', 's-102');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교할리스.jpg',  's-103');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교코피아.jpg', 's-105');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교파리바게트.jpg','s-106');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교뚜레주르.jpg', 's-107');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교그래비티.jpg', 's-108');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교요거프레소.jpg',  's-109');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교서브웨이.jpg', 's-110');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교빵커요.jpg', 's-111');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교커피후.jpg','s-112');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교디초콜릿.jpg', 's-113');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교라디오.jpg', 's-114');

/*좌표*/
INSERT INTO STORE_POSITION VALUES('s-100','37.40259704259263','127.10579376528828');
INSERT INTO STORE_POSITION VALUES('s-101','37.40213705665957','127.10631265336175');
INSERT INTO STORE_POSITION VALUES('s-102','37.40272015725536','127.10912576307398');
INSERT INTO STORE_POSITION VALUES('s-103','37.40070301355638','127.10788049604447');
INSERT INTO STORE_POSITION VALUES('s-105','37.4000970162332','127.11038687919142');
INSERT INTO STORE_POSITION VALUES('s-106','37.39922518638413','127.10804778459772');
INSERT INTO STORE_POSITION VALUES('s-107','37.400402141869456','127.10170226130225');
INSERT INTO STORE_POSITION VALUES('s-108','37.40185144273942','127.10325152413141');
INSERT INTO STORE_POSITION VALUES('s-109','37.40184434485916','127.10103785313645');
INSERT INTO STORE_POSITION VALUES('s-110','37.397730429162955','127.09654878172046');
INSERT INTO STORE_POSITION VALUES('s-111','37.39405205248971','127.10942940022333');
INSERT INTO STORE_POSITION VALUES('s-112','37.39337410060103','127.11176604876441');
INSERT INTO STORE_POSITION VALUES('s-113','37.39220266678481','127.1118772369645 ');
INSERT INTO STORE_POSITION VALUES('s-114','37.40019044433842','127.11631633513423');


/* 제품 */
/*product*/
--DELETE FROM PRODUCT

INSERT INTO PRODUCT VALUES('p-80','s-100','검정깨고구마',1500,'빵','고소~한 검정깨와 고구마의 만남!!!!!아주 환상적입니다~~~~','Y',15,1000);
INSERT INTO PRODUCT VALUES('p-81','s-100','돌체라떼',2500,'커피','제품설명글2','Y',20,1000);
INSERT INTO PRODUCT VALUES('p-82','s-100','마늘바게트',35000,'빵','제품설명글3','Y',50,1000);
INSERT INTO PRODUCT VALUES('p-83','s-100','소보루빵',1000,'빵','제품설명글4','Y',30,1000);
INSERT INTO PRODUCT VALUES('p-84','s-100','아메리카노',1500,'커피','제품설명글5','Y',80,1000);
INSERT INTO PRODUCT VALUES('p-85','s-100','카페라떼',2000,'커피','제품설명글6','Y',60,1000); 
INSERT INTO PRODUCT VALUES('p-86','s-100','슈크림빵',2000,'빵','제품설명글7','Y',18,1000); 
INSERT INTO PRODUCT VALUES('p-87','s-100','앙금빵',2500,'빵','제품설명글8','Y',53,1000);
INSERT INTO PRODUCT VALUES('p-88','s-100','앙버터',5000,'빵','제품설명글9','Y',25,1000);
INSERT INTO PRODUCT VALUES('p-89','s-100','양파빵',4000,'빵','제품설명글10','Y',45,1000); 
INSERT INTO PRODUCT VALUES('p-90','s-100','엘리게이터',4000,'빵','제품설명글11','Y',27,1000); 
INSERT INTO PRODUCT VALUES('p-91','s-100','초코크림빵',3000,'빵','제품설명글12','Y',29,1000);
INSERT INTO PRODUCT VALUES('p-92','s-100','찹쌀꽈배기',2500,'빵','제품설명글13','Y',42,1000); 
INSERT INTO PRODUCT VALUES('p-93','s-100','치즈치아바타',4500,'빵','제품설명글14','Y',41,1000); 
INSERT INTO PRODUCT VALUES('p-94','s-100','크레페',3500,'빵','제품설명글15','Y',52,1000);
INSERT INTO PRODUCT VALUES('p-95','s-100','크로와상',3500,'빵','제품설명글16','Y',17,1000);
INSERT INTO PRODUCT VALUES('p-96','s-100','크로켓',900,'빵','제품설명글17','Y',52,1000); 
INSERT INTO PRODUCT VALUES('p-97','s-100','호밀빵',3000,'빵','제품설명글18','Y',42,1000);
INSERT INTO PRODUCT VALUES('p-98','s-100','커피콩빵',3000,'빵','제품설명글19','Y',41,1000); 

INSERT INTO PRODUCT VALUES('p-100','s-101','호두찹쌀',1500,'빵','입에 착착 달라붙습니다.!!!!아주 환상적입니다~~~~','Y',15,1000);
INSERT INTO PRODUCT VALUES('p-101','s-101','프레즈',2500,'빵','제품설명글2','Y',20,1000);
INSERT INTO PRODUCT VALUES('p-102','s-101','피스타치오',35000,'빵','제품설명글3','Y',50,1000);
INSERT INTO PRODUCT VALUES('p-103','s-102','통아몬드쿠키',1000,'쿠키','제품설명글4','Y',30,1000);
INSERT INTO PRODUCT VALUES('p-104','s-102','팥앙금파이',1500,'빵','제품설명글5','Y',80,1000);
INSERT INTO PRODUCT VALUES('p-105','s-103','월넛쿠키칩',2000,'쿠키','제품설명글6','Y',60,1000); 

/*PRODUCT PICTURE*/
--delete from PRODUCT_PICTURE;
INSERT INTO PRODUCT_PICTURE values('product_image/검정깨고구마.jpg','p-80','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/돌체라떼.jpg','p-81','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/마늘바게트.jpg','p-82','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/소보루빵.jpg','p-83','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/아메리카노.jpg','p-84','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/카페라떼.jpg','p-85','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/슈크림빵.jpg','p-86','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/앙금빵.jpg','p-87','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/앙버터.jpg','p-88','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/양파빵.jpg','p-89','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/엘리게이터.jpg','p-90','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/초코크림빵.jpg','p-91','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/찹쌀꽈배기.jpg','p-92','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/치즈치아바타.jpg','p-93','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/크레페.jpg','p-94','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/크로와상.jpg','p-95','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/크로켓.jpg','p-96','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/호밀빵.jpg','p-97','s-100');
INSERT INTO PRODUCT_PICTURE values('product_image/커피콩빵.jpg','p-98','s-100');
/* -- 사진 더 추가해야 될듯- 결제 내역에 넣기 위해--*/
INSERT INTO PRODUCT_PICTURE values('product_image/호두찹쌀.jpg','p-100','s-101');
INSERT INTO PRODUCT_PICTURE values('product_image/프레즈.jpg ','p-101','s-101');
INSERT INTO PRODUCT_PICTURE values('product_image/피스타치오.jpg','p-102','s-101');
INSERT INTO PRODUCT_PICTURE values('product_image/통아몬드쿠키.jpg','p-103','s-102');
INSERT INTO PRODUCT_PICTURE values('product_image/팥앙금파이.jpg','p-104','s-102');
INSERT INTO PRODUCT_PICTURE values('product_image/월넛쿠키칩.jpg','p-105','s-103');


/* 공지사항 */
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'서버상의 오류로 인하여 2017년 07월 22일 부득이하게 서버점검 할 예정이오니 이용에 불편함을끼쳐드려 죄송합니다.빠른시일내에 복구하겠습니다.','2017년 07월 22일 서버점검 예정이오니 양해부탁드립니다.',TO_DATE('2016-06-24', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'문정 스타벅스체인점이 내부공사로 인하여 2017년 07월 22일부터 29일까지 이용을 할수 없다고 합니다.','스타벅스 문정점 내부공사로 인하여 07월 22일~07월 29일까지 휴무',TO_DATE('2016-06-28', 'yyyy-mm-dd'),5);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'1.협약된 매장과 서버운영자간의 더 나은 소통을 위해 문자전송서비스 추가,2.회원이 매장에 레시피 게시판에 사진 여러장 넣을수 있는 기능 추가 ','2017년 말에 서버 업데이트 예정',TO_DATE('2016-06-30', 'yyyy-mm-dd'),10);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'최근에 탈퇴한 회원정보는 관리자가 갖고있는지에 관하여 많은 회원분들이 문의를 하였었는데요.저희는 회원이 탈퇴한 순간 정보를 바로지워지므로 걱정안하셔도 됩니다.','탈퇴한 회원 정보와 관련된 공지사항',TO_DATE('2017-02-28', 'yyyy-mm-dd'),50);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'판교 더리터점과 논의 끝에 기존가격유지하겠다고 하였으니 걱정안하셔도 됩니다.','판교 더리터점에서 아이스 아메리카노가격 관련 공지사항',TO_DATE('2017-03-02', 'yyyy-mm-dd'),42);

INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'서버상의 오류로 인하여 2017년 07월 22일 부득이하게 서버점검 할 예정이오니 이용에 불편함을끼쳐드려 죄송합니다.빠른시일내에 복구하겠습니다.','2017년 9월부로 협약매장의 가입승인기준이 업데이트 됩니다.',TO_DATE('2017-05-22', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'문정 스타벅스체인점이 내부공사로 인하여 2017년 07월 22일부터 29일까지 이용을 할수 없다고 합니다.','2017년 11월부로 서버 오류 점검',TO_DATE('2017-06-28', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'1.협약된 매장과 서버운영자간의 더 나은 소통을 위해 문자전송서비스 추가,2.회원이 매장에 레시피 게시판에 사진 여러장 넣을수 있는 기능 추가 ','판교이디아점 임시 휴업',TO_DATE('2017-08-24', 'yyyy-mm-dd'),10);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'최근에 탈퇴한 회원정보는 관리자가 갖고있는지에 관하여 많은 회원분들이 문의를 하였었는데요.저희는 회원이 탈퇴한 순간 정보를 바로지워지므로 걱정안하셔도 됩니다.','물가 상승으로 인한 전반적인 가격 상승 ',TO_DATE('2017-10-30', 'yyyy-mm-dd'),50);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'판교 더리터점과 논의 끝에 기존가격유지하겠다고 하였으니 걱정안하셔도 됩니다.','판교 더리터점에서 아이스 아메리카노가격 관련 공지사항',TO_DATE('2017-11-02', 'yyyy-mm-dd'),5);

INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'서버상의 오류로 인하여 2017년 07월 22일 부득이하게 서버점검 할 예정이오니 이용에 불편함을끼쳐드려 죄송합니다.빠른시일내에 복구하겠습니다.','매장별 이벤트를 매월 1일에 실시합니다. 많은 참여바랍니다.',TO_DATE('2017-11-22', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'문정 스타벅스체인점이 내부공사로 인하여 2017년 07월 22일부터 29일까지 이용을 할수 없다고 합니다.','모든 협약 매장들에게 공지 . 필독!11',TO_DATE('2017-11-30', 'yyyy-mm-dd'),37);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'1.협약된 매장과 서버운영자간의 더 나은 소통을 위해 문자전송서비스 추가,2.회원이 매장에 레시피 게시판에 사진 여러장 넣을수 있는 기능 추가 ','판교 스타벅스 이벤트 실시!',TO_DATE('2017-12-02', 'yyyy-mm-dd'),13);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'최근에 탈퇴한 회원정보는 관리자가 갖고있는지에 관하여 많은 회원분들이 문의를 하였었는데요.저희는 회원이 탈퇴한 순간 정보를 바로지워지므로 걱정안하셔도 됩니다.','2017년 6월 24일부로 관리자 교체 ',TO_DATE('2017-12-20', 'yyyy-mm-dd'),21);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'판교 더리터점과 논의 끝에 기존가격유지하겠다고 하였으니 걱정안하셔도 됩니다.','판교 빵커요점 2018년 1월부로  신축공사로 인한 임시휴업',TO_DATE('2017-12-24', 'yyyy-mm-dd'),44);




/* payment_optionList */
INSERT INTO PAYMENT_OPTIONLIST VALUES('c','신용카드');
INSERT INTO PAYMENT_OPTIONLIST VALUES('j','제휴신용카드');
INSERT INTO PAYMENT_OPTIONLIST VALUES('k','카카오페이');
INSERT INTO PAYMENT_OPTIONLIST VALUES('p','현금');
INSERT INTO PAYMENT_OPTIONLIST VALUES('o','OkCashBag 포인트결제');
INSERT INTO PAYMENT_OPTIONLIST VALUES('s','syrup Pay');
INSERT INTO PAYMENT_OPTIONLIST VALUES('r','실시간계좌이체');
INSERT INTO PAYMENT_OPTIONLIST VALUES('m','문화상품권');
INSERT INTO PAYMENT_OPTIONLIST VALUES('h','휴대폰결제');

/* 매장 결제목록리스트 */
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','c');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','j');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','k');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','o');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','s');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','r');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','m');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-100','h');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-101','c');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-101','j');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-102','o');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-102','s');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-103','c');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-103','j');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-103','k');                     
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-105','c');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-105','p');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-105','m');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-106','c');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-106','r');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-106','o');                         

/* 예약내역 */
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),4,to_date('20170604', 'yyyy-mm-dd'),to_date('20170605','yyyy-mm-dd'),'p-100','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),6,to_date('20170604', 'yyyy-mm-dd'),to_date('20170605','yyyy-mm-dd'),'p-101','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,to_date('20170704', 'yyyy-mm-dd'),to_date('20170712','yyyy-mm-dd'),'p-102','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,to_date('20170704', 'yyyy-mm-dd'),to_date('20170713','yyyy-mm-dd'),'p-103','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),7,to_date('20170706', 'yyyy-mm-dd'),to_date('20170714','yyyy-mm-dd'),'p-104','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),10,to_date('20170707', 'yyyy-mm-dd'),to_date('20170707','yyyy-mm-dd'),'p-105','s-103','u-1');


/* 제품 증감폭 */            
INSERT INTO PRODUCT_GAP VALUES('K','0','p-80','s-100');
INSERT INTO PRODUCT_GAP VALUES('D','0','p-81','s-100');
INSERT INTO PRODUCT_GAP VALUES('D','0.03','p-82','s-100');
INSERT INTO PRODUCT_GAP VALUES('K','0.01','p-83','s-100');
INSERT INTO PRODUCT_GAP VALUES('U','0.05','p-84','s-100');


--delete FROM PAYMENT_DETAILS;

/*검정깨 유지*/

INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170710', 'yyyy-mm-dd'),'r',5,'u-1','p-80','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170711', 'yyyy-mm-dd'),'r',8,'u-1','p-80','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170712', 'yyyy-mm-dd'),'f',0,'u-1','p-80','s-100',10);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',10,'u-1','p-80','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170714', 'yyyy-mm-dd'),'r',10,'u-1','p-80','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',9,'u-1','p-80','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170716', 'yyyy-mm-dd'),'r',11,'u-1','p-80','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170717', 'yyyy-mm-dd'),'f',0,'u-1','p-80','s-100',12);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170718', 'yyyy-mm-dd'),'f',0,'u-1','p-80','s-100',13);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170719', 'yyyy-mm-dd'),'f',0,'u-1','p-80','s-100',10);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170720', 'yyyy-mm-dd'),'f',0,'u-1','p-80','s-100',11);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170721', 'yyyy-mm-dd'),'f',0,'u-1','p-80','s-100',10);

/*돌체라떼 하락*/
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170710', 'yyyy-mm-dd'),'r',2,'u-1','p-81','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170711', 'yyyy-mm-dd'),'r',2,'u-1','p-81','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170712', 'yyyy-mm-dd'),'r',5,'u-1','p-81','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',10,'u-1','p-81','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170714', 'yyyy-mm-dd'),'r',13,'u-1','p-81','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',8,'u-1','p-81','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170716', 'yyyy-mm-dd'),'r',11,'u-1','p-81','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170717', 'yyyy-mm-dd'),'f',0,'u-1','p-81','s-100',8);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170718', 'yyyy-mm-dd'),'f',0,'u-1','p-81','s-100',5);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170719', 'yyyy-mm-dd'),'f',0,'u-1','p-81','s-100',3);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170720', 'yyyy-mm-dd'),'f',0,'u-1','p-81','s-100',3);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170721', 'yyyy-mm-dd'),'f',0,'u-1','p-81','s-100',1);

/*마늘 바게트 하락*/
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170710', 'yyyy-mm-dd'),'r',6,'u-1','p-82','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170711', 'yyyy-mm-dd'),'r',7,'u-1','p-82','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170712', 'yyyy-mm-dd'),'f',0,'u-1','p-82','s-100',10);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',10,'u-1','p-82','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170714', 'yyyy-mm-dd'),'r',11,'u-1','p-82','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',8,'u-1','p-82','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170716', 'yyyy-mm-dd'),'r',6,'u-1','p-82','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170717', 'yyyy-mm-dd'),'f',0,'u-1','p-82','s-100',4);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170718', 'yyyy-mm-dd'),'f',0,'u-1','p-82','s-100',3);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170719', 'yyyy-mm-dd'),'f',0,'u-1','p-82','s-100',7);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170720', 'yyyy-mm-dd'),'f',0,'u-1','p-82','s-100',3);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170721', 'yyyy-mm-dd'),'f',0,'u-1','p-82','s-100',2);


/*소보루 유지*/
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170710', 'yyyy-mm-dd'),'r',15,'u-1','p-83','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170711', 'yyyy-mm-dd'),'r',13,'u-1','p-83','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170712', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',10);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170713', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',12);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170714', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',15);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170715', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',13);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170716', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',15);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170717', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',14);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170718', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',13);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170719', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',15);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170720', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',10);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170721', 'yyyy-mm-dd'),'f',0,'u-1','p-83','s-100',10);

/*아메리카노상승*/
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170710', 'yyyy-mm-dd'),'r',3,'u-1','p-84','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170711', 'yyyy-mm-dd'),'r',7,'u-1','p-84','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170712', 'yyyy-mm-dd'),'f',0,'u-1','p-84','s-100',10);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170713', 'yyyy-mm-dd'),'r',5,'u-1','p-84','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170714', 'yyyy-mm-dd'),'r',10,'u-1','p-84','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170715', 'yyyy-mm-dd'),'r',20,'u-1','p-84','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170716', 'yyyy-mm-dd'),'r',10,'u-1','p-84','s-100',0);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'c',to_date('20170717', 'yyyy-mm-dd'),'f',0,'u-1','p-84','s-100',14);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170718', 'yyyy-mm-dd'),'f',0,'u-1','p-84','s-100',20);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170719', 'yyyy-mm-dd'),'f',0,'u-1','p-84','s-100',30);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170720', 'yyyy-mm-dd'),'f',0,'u-1','p-84','s-100',35);
INSERT INTO PAYMENT_DETAILS VALUES(payment_no_seq.nextval,'p',to_date('20170721', 'yyyy-mm-dd'),'f',0,'u-1','p-84','s-100',36);



/* 레시피 게시판 */
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '자바칩 프라푸치노 + 헤이즐넛 시럽 2펌프 + 휘핑 위에 카라멜 드리즐을 뿌려줘야 해요! ',
                                                                         '더위사냥프라푸치노', TO_DATE('2017-07-03', 'yyyy-mm-dd'),20,'/recipe_image/더위사냥_실사.jpg',20,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '초코크림 프라푸치노 + 헤이즐넛 시럽 1펌프 추가 + 휘핑크림 위에 초코 드리즐+ 자바칩 갈지 않은 것을 뿌려주면 끝~~ ',
                                                                         '고디바 프라푸치노', TO_DATE('2017-07-05', 'yyyy-mm-dd'),30,'/recipe_image/고디바_실사.jpg',30,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '그린티 프라푸치노 + 샷추가 + 자바칩 반만 간 걸 추가 + 휘핑크림 위에 초코 드리즐+ 자바칩 나머지 통으로 얹어주면 되욧 ',
                                                                         '슈렉 프라푸치노', TO_DATE('2017-07-07', 'yyyy-mm-dd'),40,'/recipe_image/슈렉_실사.jpg',40,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '딸기 크림 프라푸치노 + 자바칩 갈아서 추가 + 휘핑크림 위에 초코 드리즐을 뿌려주면 돼지바를 먹는 기분이에요~',
                                                                         '돼지바 프라푸치노', TO_DATE('2017-07-11', 'yyyy-mm-dd'),60,'/recipe_image/돼지바_실사.jpg',60,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '바닐라 크림파이 프라푸치노는 바나나 덕후들이 사랑하는 바로 그 메뉴다. 바닐라 크림파이 프라푸치노는 먼저 바닐라빈 프라푸치노를 주문한 다음, 바닐라 시럽 1 펌프와 헤이즐넛 시럽 1펌프를 넣고 바나나를 추가해 갈아달아고 하면 된다. 바닐라빈 프라푸치노가 없을 경우 바닐라크림 프라푸치노를 주문하면 된다. 하지만 바나나가 들어간 커스텀 메뉴는 아쉽게도 한국 스타벅스에서는 불가능 하다는 사실. 해외여행을 갈 기회가 생긴다면 영어로 주문법을 외워가서 도전해보는건 어떨까?',
                                                                         '비어버터 프라푸치노', TO_DATE('2017-07-13', 'yyyy-mm-dd'),70,'/recipe_image/비어버터_실사.jpg',70,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '오레오 과자든, 오레오 아이스크림이든, 오레오라면 죽고 못하는 이들이 즐겨 찾는 메뉴가 바로 스타벅스의 오레오 프라푸치노다. 바닐라크림 프라푸치노에 자바칩을 2번 추가하고, 에스프레소 휘핑을 올리면, 오레오의 우유와 초코칩이 뒤섞인 달달한 그 맛을 시원한 음료로 즐길 수 있다.',
                                                                         '쿠앤크프라푸치노', TO_DATE('2017-07-15', 'yyyy-mm-dd'),80,'/recipe_image/쿠앤크_실사.jpg',80,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '본래 스타벅스 메뉴에 돌체라떼가 있지만, 돌체라떼를 보다 더 맛있게 먹기 위한 커스텀 레시피가 인기다. 돌체라떼를 맛있게 먹으려면 일단 아이스로 주문한 다음, 일반 우유와 에스프레소휩을 추가하면 된다. 더 달게 먹고 싶다면 연유를 추가하는 것도 좋다. 이 음료는 배변활동을 활발하게 해준다고 해서 일명 관장라떼라고도 불린다.',
                                                                         '돌체라떼 커스텀', TO_DATE('2017-07-17', 'yyyy-mm-dd'),90,'/recipe_image/돌체라떼.PNG',90,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '프라푸치노가 주를 이루는 인기 커스텀 메뉴 중 당당히 자리를 하고 있는 것이 더블샷이다. 두터운 매니아층을 갖고 있는 이 메뉴는 더블샷에 에스프레소 더블샷과 시럽을 얼음과 함께 넣어달라고 하면 된다. 시럽은 커피, 바닐라, 캐러멜, 헤이즐넛 중에 선택하면 된다. 시럽을 얼음과 함께 넣고 흔들어서 만드는데, 나올 땐 얼음은 빼로 음료만 작은 컵에 담겨 나온다.',
                                                                         '페레로로쉐프라푸치노', TO_DATE('2017-07-17', 'yyyy-mm-dd'),100,'/recipe_image/페레로로쉐_실사.jpg',100,'u-1','s-101');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '터키2장 + 햄1장 + 로스트비프 1장 + 치즈2장 빵은 허니오트 소스는 바베큐+스위트칠리를 넣으면 완성입니다~ 가격은 5300원 정도에요',
                                                                         '서브웨이클럽', TO_DATE('2017-07-19', 'yyyy-mm-dd'),101,'/recipe_image/서브웨이클럽.jpg',101,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '계란 + 베이컨 + 치즈 빵은 플랫 브래드 소스는 렌치+스윗어니언을 넣으면 완성입니다',
                                                                         '에그마요', TO_DATE('2017-07-16', 'yyyy-mm-dd'),120,'/recipe_image/에그.jpg',120,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '저의 비엘티 꿀 조합입니다 허니 오트에 야채는 다넣고 소스를 달달한 스위트 어니언과 홀스 레디 쉬를 넣었어요~ 이렇게 먹음 매콤하고 달달해요',
                                                                         '비엘티', TO_DATE('2017-06-24', 'yyyy-mm-dd'),110,'/recipe_image/비엘티.jpg',110,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '서브웨이 멜티는 사우스 웻트랑 렌지드레싱으로 고소하고 매콤해요 저는 항상 야채를 다 넣어달라고 하고 많이 넣어 달라고 합니다 여러분도 해보세요',
                                                                         '멜티', TO_DATE('2017-06-22', 'yyyy-mm-dd'),130,'/recipe_image/멜티.jpg',130,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '서브웨이 이탈리안 꿀조합은 플랫브래드 + 야채는 취향존중 + 마요네즈 + 스위트칠리 + 랜치드레싱을 넣으면 완성!',
                                                                         '스파이시 이탈리안', TO_DATE('2017-06-22', 'yyyy-mm-dd'),140,'/recipe_image/스파이시.jpg',140,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '하하 시그니처 써브 베스트 조합 : 비엠티빵은 오레가노를 선택 핫칠리+할라피뇨추가! ,제노바 살라미, 페퍼로니햄, 에그마요가 듬뿍 올라감 정말 맛있음',
                                                                         '하하 시그니처 써브', TO_DATE('2017-06-17', 'yyyy-mm-dd'),160,'/recipe_image/하하.jpg',160,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '돼지고기 맛이지만 소스에 따라 맛이 바뀜 사우스웨스트 소스를 뿌리면 멕시코 바비큐 먹는 기분! 바비큐 소스와 마요네즈를 섞어서 뿌려 먹으면 전통 바베큐 돼지고기 맛이 나요~ 한번 먹어봐요',
                                                                         '폴드 포크 세트', TO_DATE('2017-06-15', 'yyyy-mm-dd'),180,'/recipe_image/폴드.jpg',180,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '핫칠리 + 마요네즈 + 렌치드레싱으로 소스 뿌려보세요 이게 젤 괜찮은듯 ',
                                                                         '스파이시 이탈리안', TO_DATE('2017-06-13', 'yyyy-mm-dd'),190,'/recipe_image/스파이시2.jpg',190,'u-1','s-110');
INSERT INTO recipe_board_contents VALUES(recipe_board_no_seq.nextval, '스위트어니언+바베큐+ 렌치드레싱 소스 뿌리면 단짠단짠을 맛볼수 있는 치킨데리야끼가 될거에요~ 시도해봐요',
                                                                         '치킨데리야끼 이탈리안', TO_DATE('2017-06-11', 'yyyy-mm-dd'),200,'/recipe_image/치킨데리야끼.jpg',200,'u-1','s-110');


/* qna board 목록 */		

INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '김영수', '빵커요 커피빵', '커피빵 언제쯤 예약 가능한가요?', TO_DATE('2017-06-29', 'yyyy-mm-dd'),1,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '한송이', '판교점 더리터', '판교역 더리터 개점시간이 언제인가요?', TO_DATE('2017-06-30', 'yyyy-mm-dd'),5,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '이태곤', '목동점 파리바게트', '주말에도 가게 여시나요????', TO_DATE('2017-07-01', 'yyyy-mm-dd'),10,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '이수민', '오리역 스타벅스 커스텀', '혹시 커스텀 메뉴도 주문가능한가요?',TO_DATE('2017-07-02', 'yyyy-mm-dd'),15,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '서지혜', '커피원두', '커피원두의 유통기한은 어떻게 됩니까?', TO_DATE('2017-07-03', 'yyyy-mm-dd'),20,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '이유리', '이디야는 음료 리필', '이디야는 음료 리필 가능한가요?', TO_DATE('2017-06-26', 'yyyy-mm-dd'),25,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '이진수', '베이커리', '베이커리에서 파는 빵의 칼로리는 어떻게 확인가능 한가요?', TO_DATE('2017-06-26', 'yyyy-mm-dd'),30,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '신주희', '유통기한문제', '유통기한은 어떻게 설정하고 관리하나요?', TO_DATE('2017-06-21', 'yyyy-mm-dd'),35,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '신세희', '커피및 음료', '커피및 음료의 칼로리 함량을 알수 있습니까?', TO_DATE('2017-06-20', 'yyyy-mm-dd'),40,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '이희진', '매장흡연', '매장에서 흡연시설 이용하는 곳이 있습니까?', TO_DATE('2017-06-11', 'yyyy-mm-dd'),50,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '김지수', '무선 인터넷', '매장내에 무선 인터넷을 무료로 이용가능한가요?', TO_DATE('2017-06-25', 'yyyy-mm-dd'),60,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '김사랑', '제휴카드', '제휴하고 있는 통신사나 카드나 신용카드가 있나요?',TO_DATE('2017-06-15', 'yyyy-mm-dd'),70,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '홍선표', '상품권', '해당 매장에서 결제가능한 상품권은 어떤것이 있을까요?', TO_DATE('2017-05-10', 'yyyy-mm-dd'),80,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '한형석', '원두', '커피원두를 따로 구매할수 있습니까?', TO_DATE('2017-05-09', 'yyyy-mm-dd'),90,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '박주영', '텀블러', '텀블러를 사이트에서 구매할수 있을까요?', TO_DATE('2017-04-20', 'yyyy-mm-dd'),100,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval,'s-100', '맹한주', '머그', '머그컵을 사이트에서 구매할 수 있을까요?', TO_DATE('2017-07-18', 'yyyy-mm-dd'),110,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-101','이진영', '쿠폰문제', '해당 매장에서 쿠폰도 발행해 주나요?', TO_DATE('2017-07-16', 'yyyy-mm-dd'),120,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-101','노현식', '현금영수증', '해당 매장에서 현금영수증 발행이 가능한가요?', TO_DATE('2017-07-14', 'yyyy-mm-dd'),130,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-101','최민희', '밤식빵', '밤식빵 최대 몇개까지 예약가능한가요?', TO_DATE('2017-07-11', 'yyyy-mm-dd'),140,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-101','김영현', '폐점시간', '빵이맛있는집 폐점시간이 언제인가요?', TO_DATE('2017-07-06', 'yyyy-mm-dd'),150,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-100','백진현', '쓰레기통', '판교이디아점 쓰레기통 늘리는건 어떤가요?', TO_DATE('2017-07-06', 'yyyy-mm-dd'),150,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-102','장규현', '서버점검시간', '서버접속이 안되는데  언제쯤 점검 끝나나요?', TO_DATE('2017-07-06', 'yyyy-mm-dd'),150,'N');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-102','조새롬', '포인트사용', '포인트사용을 언제까지 쓸수있가요?', TO_DATE('2017-07-06', 'yyyy-mm-dd'),150,'Y');
INSERT INTO qna_board_contents VALUES(qna_board_no_seq.nextval, 's-102','이진우', '폐점시간', '빵이맛있는집 폐점시간이 언제인가요?', TO_DATE('2017-07-06', 'yyyy-mm-dd'),150,'Y');
