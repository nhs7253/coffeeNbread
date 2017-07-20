/* 유저 */
SELECT *FROM GENERAL_USER
DELETE FROM GENERAL_USER

/* 노현식 - 2017-07-03 수정 */  /* 비밀번호 1111 */
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

CREATE TABLE reservation_details (
	reservation_no NUMBER PRIMARY KEY, /* 예약번호 */
	reservation_time DATE NOT NULL, /* 예약시간 */
	reservation_count NUMBER(3) NOT NULL, /* 예약개수 */
	reservation_confirm DATE  NULL, /* 예약확인유무   -null허용으로 수정(07-03) */
	product_hope_time DATE NULL,/*제품수령희망시간*/
	product_id VARCHAR2(30) NOT NULL, /* 제품아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	user_id VARCHAR2(30), /* 유저아이디 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE,
	FOREIGN KEY(product_id) REFERENCES product(product_id) ON DELETE CASCADE
);


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
INSERT INTO STORE VALUES('s-100','광주이디아','저희 매장을 방문해 주셔서 진심으로 감사드립니다.저희 매장은 다른 매장과 다르게 매일 신선한재료로 여러분들을 맞이하고있습니다. 아침마다 추천메뉴바뀌니 많은 관심부탁드립니다.'
                          , '062-372-4755','광주 서구 운천로 263에 위치한 광주이디아점입니다.','GwangjuEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');
                          
INSERT INTO STORE VALUES('s-101','문정스타벅스','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 문정체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','서울특별시 송파구 가락2동 동남로 141','Munjung@email.com',
                          '빵,커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');                          
                                                        -- 2017-07-17 김형주 추가
----------------------------------------------------------------실 데이터-----------------------------------------------------------

/* 매장 등록시 - 매장사진, 매장좌표 */
<<<<<<< HEAD
INSERT INTO STORE VALUES('s-100','판교 이디아','저희 매장을 방문해 주셔서 진심으로 감사드립니다.저희 매장은 다른 매장과 다르게 매일 신선한재료로 여러분들을 맞이하고있습니다. 아침마다 추천메뉴바뀌니 많은 관심부탁드립니다.'
                          , '062-372-4755','판교동 625에 위치한 판교 이디아점입니다.','PEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');
                          
INSERT INTO STORE VALUES('s-101','판교 스타벅스','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 판교체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','판교 삼평동 분당내곡로 150','Munjung@email.com',
                          '빵,커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');                          
                                         
                          
INSERT INTO STORE VALUES('s-102','판교 엔젤리너스','판교에서 제일맛있는 카페체인점으로 자부합니다.매주월요일마다 할인행사하고있습니다. 사이트를 참조하시면 더욱더 자세한내용을 얻으실수 있습니다.','051-314-3100',
                         '판교 삼평동 대왕판교로 660 유스페이스 1B-221호','BusanAngel@email.com','빵,커피',400,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');                          
                          
INSERT INTO STORE VALUES('s-103','판교 할리스','저희 매장을 방문해 주셔서 진심으로 감사드립니다.영등포역 근처에 위치하고있어 아침 9시부터 11시까지는 사람들이 붐비므로 참고하시길 바랍니다.최근 조회수가 제일 많은 매장으로 뽑히기도 했는데요. 그만큼 저희만의 특색있는 메뉴가 있으므로 참고하시기바랍니다.'
                          , '070-4159-8897','서울 영등포구 경인로 847에 위치한 영등포 할리스점입니다.','hollys@email.com','빵',10340,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009051000','yyyy-mm-dd hh24:mi'),'N');                          
                    
                          
INSERT INTO STORE VALUES('s-104','판교 더리터점','저희 매장을 방문해주셔서 감사합니다.판교테크노벨리에 위치해서 아침9시부터 11시까지는 직장인들이 많이 붐빕니다.그리고 저희 매출의 1등은 청포도에이드가 베스트에요',
                            '031-724-2520','경기 성남시 분당구 대왕판교로 660 ,삼평동 670 유스페이스1 1층 146호','theliter@email.com', '빵,커피',500,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');

INSERT INTO STORE VALUES('s-105','판교 코피아','ㅇ'
                          , '062-372-4755','삼평동 691-1 1층 코피아','GwangjuEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');
                          
INSERT INTO STORE VALUES('s-106','판교 파리바게트','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 문정체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','판교 백현동 578-5','Munjung@email.com',
                          '빵,커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');                          
                         
                          
                          
INSERT INTO STORE VALUES('s-107','판교 뚜레주르','부산에서 제일맛있는 카페체인점으로 자부합니다.매주월요일마다 할인행사하고있습니다. 사이트를 참조하시면 더욱더 자세한내용을 얻으실수 있습니다.','051-314-3100',
                         '판교 삼평동 741','BusanAngel@email.com','빵,커피',400,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');                          
                          
INSERT INTO STORE VALUES('s-108','판교 그래비티 ','저희 매장을 방문해 주셔서 진심으로 감사드립니다.영등포역 근처에 위치하고있어 아침 9시부터 11시까지는 사람들이 붐비므로 참고하시길 바랍니다.최근 조회수가 제일 많은 매장으로 뽑히기도 했는데요. 그만큼 저희만의 특색있는 메뉴가 있으므로 참고하시기바랍니다.'
                          , '070-4159-8897','판교 삼평동 산29-16','hollys@email.com','빵',10340,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');                          
                    
                          
INSERT INTO STORE VALUES('s-109','판교 요거프레소','저희 매장을 방문해주셔서 감사합니다.판교테크노벨리에 위치해서 아침9시부터 11시까지는 직장인들이 많이 붐빕니다.그리고 저희 매출의 1등은 청포도에이드가 베스트에요',
                            '031-724-2520','경기 성남시 분당구 대왕판교로 660 ,삼평동 670 유스페이스1 1층 146호','theliter@email.com', '빵',500,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');

INSERT INTO STORE VALUES('s-110','판교 서브웨이','저희 매장을 방문해주셔서 감사합니다.판교테크노벨리에 위치해서 아침9시부터 11시까지는 직장인들이 많이 붐빕니다.그리고 저희 매출의 1등은 청포도에이드가 베스트에요',
                            '031-724-2520','삼평동 판교역로 192번길 14-2','theliter@email.com', '빵',500,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');

INSERT INTO STORE VALUES('s-111','판교 빵커요','저희 매장을 방문해 주셔서 진심으로 감사드립니다.저희 매장은 다른 매장과 다르게 매일 신선한재료로 여러분들을 맞이하고있습니다. 아침마다 추천메뉴바뀌니 많은 관심부탁드립니다.'
                          , '062-372-4755','삼평동 판교역로 192번길 16','GwangjuEdiya@email.com','빵,커피',504,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052000','yyyy-mm-dd hh24:mi'),'N');
                          
INSERT INTO STORE VALUES('s-112','판교 커피후','시애틀에 본사를 두고 있고 간단한 스낵과 무료 Wi-Fi를 제공하는 유명 커피 체인점입니다.저희 문정체인점은 매월스페셜메뉴가있으니 많은관심 부탁드립니다.','02-758-8860','판교역로 145라 스트리트 2동 2층','Munjung@email.com',
                          '커피',809,to_date('198009050800','yyyy-mm-dd hh24:mi'),to_date('198009052200','yyyy-mm-dd hh24:mi'),'N');                          
                                                                        
                          
INSERT INTO STORE VALUES('s-113','판교 디초콜릿','부산에서 제일맛있는 카페체인점으로 자부합니다.매주월요일마다 할인행사하고있습니다. 사이트를 참조하시면 더욱더 자세한내용을 얻으실수 있습니다.','051-314-3100',
                         '동판교로 177번길 25','BusanAngel@email.com','빵,커피',400,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052300','yyyy-mm-dd hh24:mi'),'N');                          
                          
INSERT INTO STORE VALUES('s-114','판교 라디오','저희 매장을 방문해 주셔서 진심으로 감사드립니다.영등포역 근처에 위치하고있어 아침 9시부터 11시까지는 사람들이 붐비므로 참고하시길 바랍니다.최근 조회수가 제일 많은 매장으로 뽑히기도 했는데요. 그만큼 저희만의 특색있는 메뉴가 있으므로 참고하시기바랍니다.'
                          , '070-4159-8897','판교동 서판교로 44번길 17-5','hollys@email.com','타르트,커피',10340,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052100','yyyy-mm-dd hh24:mi'),'N');                          
                    
                          
INSERT INTO STORE VALUES('s-115','판교 파스쿠찌','저희 매장을 방문해주셔서 감사합니다.판교테크노벨리에 위치해서 아침9시부터 11시까지는 직장인들이 많이 붐빕니다.그리고 저희 매출의 1등은 청포도에이드가 베스트에요',
                            '031-724-2520','경기 성남시 분당구 대왕판교로 606번길 10 알파 리움 1단지 2층','theliter@email.com', '빵',500,to_date('198009050900','yyyy-mm-dd hh24:mi'),to_date('198009052000','yyyy-mm-dd hh24:mi'),'N');
        


                            
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
                            
/* 매장 사진 */
/*매장사진*/

DELETE FROM STORE_PICTURE;

INSERT INTO STORE_PICTURE VALUES ('store_image/판교이디아.jpg','s-100');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교스타벅스.jpg', 's-101');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교엔젤리너스.jpg', 's-102');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교할리스.jpg',  's-103');
INSERT INTO STORE_PICTURE VALUES ('store_image/판교더리터점.jpg', 's-104');
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
INSERT INTO STORE_PICTURE VALUES ('store_image/판교 파스쿠찌.jpg','s-115');

/*좌표*/
delete from store_position
INSERT INTO STORE_POSITION VALUES('s-100','37.40259704259263','127.10579376528828');
INSERT INTO STORE_POSITION VALUES('s-101','37.40213705665957','127.10631265336175');
INSERT INTO STORE_POSITION VALUES('s-102','37.40272015725536','127.10912576307398');
INSERT INTO STORE_POSITION VALUES('s-103','37.40070301355638','127.10788049604447');
INSERT INTO STORE_POSITION VALUES('s-104','37.40209731129592','127.11035593064082');
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
/* 진영이꺼에 이어서 추가 */ -- 7월 20일
 delete from product
INSERT INTO PRODUCT VALUES('p-100','s-101','검정깨고구마',1500,'빵','고소~한 검정깨와 고구마의 만남!!!!!아주 환상적입니다~~~~','Y',15,1000);
INSERT INTO PRODUCT VALUES('p-101','s-101','돌체라떼',2500,'커피','제품설명글2','Y',20,1000);
INSERT INTO PRODUCT VALUES('p-102','s-101','마늘바게트',35000,'빵','제품설명글3','Y',50,1000);
INSERT INTO PRODUCT VALUES('p-103','s-102','소보루빵',1000,'빵','제품설명글4','Y',30,1000);
INSERT INTO PRODUCT VALUES('p-104','s-102','아메리카노',1500,'커피','제품설명글5','Y',80,1000);
INSERT INTO PRODUCT VALUES('p-105','s-103','카페라떼',2000,'커피','제품설명글6','Y',60,1000); 
INSERT INTO PRODUCT VALUES('p-106','s-104','슈크림빵',2000,'빵','제품설명글7','Y',18,1000); 
INSERT INTO PRODUCT VALUES('p-107','s-104','앙금빵',2500,'빵','제품설명글8','Y',53,1000);
INSERT INTO PRODUCT VALUES('p-108','s-101','앙버터',5000,'빵','제품설명글9','Y',25,1000);
INSERT INTO PRODUCT VALUES('p-109','s-102','양파빵',4000,'빵','제품설명글10','Y',45,1000); 
INSERT INTO PRODUCT VALUES('p-110','s-102','엘리게이터',4000,'빵','제품설명글11','Y',27,1000); 
INSERT INTO PRODUCT VALUES('p-111','s-101','초코크림빵',3000,'빵','제품설명글12','Y',29,1000);
INSERT INTO PRODUCT VALUES('p-112','s-101','찹쌀꽈배기',2500,'빵','제품설명글13','Y',42,1000); 
INSERT INTO PRODUCT VALUES('p-113','s-101','치즈치아바타',4500,'빵','제품설명글14','Y',41,1000); 
INSERT INTO PRODUCT VALUES('p-114','s-101','크레페',3500,'빵','제품설명글15','Y',52,1000);
INSERT INTO PRODUCT VALUES('p-115','s-101','크로와상',3500,'빵','제품설명글16','Y',17,1000);
INSERT INTO PRODUCT VALUES('p-116','s-101','크로켓',900,'빵','제품설명글17','Y',52,1000); 
INSERT INTO PRODUCT VALUES('p-117','s-101','호밀빵',3000,'빵','제품설명글18','Y',42,1000);
INSERT INTO PRODUCT VALUES('p-118','s-101','커피콩빵',3000,'빵','제품설명글19','Y',41,1000); 
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
select *from product_picture
--INSERT INTO PRODUCT_PICTURE values('product_image/검정깨고구마.jpg','p-100','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/돌체라떼.jpg ','p-101','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/마늘바게트.jpg','p-102','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/소보루빵.jpg','p-103','s-102');
--INSERT INTO PRODUCT_PICTURE values('product_image/아메리카노.jpg','p-104','s-102');
--INSERT INTO PRODUCT_PICTURE values('product_image/카페라떼.jpg','p-105','s-103');
--INSERT INTO PRODUCT_PICTURE values('product_image/슈크림빵.jpg','p-106','s-104');
--INSERT INTO PRODUCT_PICTURE values('product_image/앙금빵.jpg','p-107','s-104');
--INSERT INTO PRODUCT_PICTURE values('product_image/앙버터.jpg','p-108','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/양파빵.jpg','p-109','s-102');
--INSERT INTO PRODUCT_PICTURE values('product_image/엘리게이터.jpg','p-110','s-102');
--INSERT INTO PRODUCT_PICTURE values('product_image/초코크림빵.jpg','p-111','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/찹쌀꽈배기.jpg','p-112','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/치즈치아바타.jpg','p-113','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/크레페.jpg','p-114','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/크로와상.jpg','p-115','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/크로켓.jpg','p-116','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/호밀빵.jpg','p-117','s-101');
--INSERT INTO PRODUCT_PICTURE values('product_image/커피콩빵.jpg','p-118','s-101');


/* 공지사항 */
delete from NOTICE_BOARD_CONTENTS
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'서버상의 오류로 인하여 2017년 07월 22일 부득이하게 서버점검 할 예정이오니 이용에 불편함을끼쳐드려 죄송합니다.빠른시일내에 복구하겠습니다.','2017년 07월 22일 서버점검 예정이오니 양해부탁드립니다.',TO_DATE('2017-06-24', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'문정 스타벅스체인점이 내부공사로 인하여 2017년 07월 22일부터 29일까지 이용을 할수 없다고 합니다.','스타벅스 문정점 내부공사로 인하여 07월 22일~07월 29일까지 휴무',TO_DATE('2017-06-28', 'yyyy-mm-dd'),5);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'1.협약된 매장과 서버운영자간의 더 나은 소통을 위해 문자전송서비스 추가,2.회원이 매장에 레시피 게시판에 사진 여러장 넣을수 있는 기능 추가 ','2017년 말에 서버 업데이트 예정',TO_DATE('2017-07-30', 'yyyy-mm-dd'),10);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'최근에 탈퇴한 회원정보는 관리자가 갖고있는지에 관하여 많은 회원분들이 문의를 하였었는데요.저희는 회원이 탈퇴한 순간 정보를 바로지워지므로 걱정안하셔도 됩니다.','탈퇴한 회원 정보와 관련된 공지사항',TO_DATE('2017-09-30', 'yyyy-mm-dd'),50);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'판교 더리터점과 논의 끝에 기존가격유지하겠다고 하였으니 걱정안하셔도 됩니다.','판교 더리터점에서 아이스 아메리카노가격 관련 공지사항',TO_DATE('2017-06-28', 'yyyy-mm-dd'),42);

INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'서버상의 오류로 인하여 2017년 07월 22일 부득이하게 서버점검 할 예정이오니 이용에 불편함을끼쳐드려 죄송합니다.빠른시일내에 복구하겠습니다.','2017년 9월부로 협약매장의 가입승인기준이 업데이트 됩니다.',TO_DATE('2017-05-22', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'문정 스타벅스체인점이 내부공사로 인하여 2017년 07월 22일부터 29일까지 이용을 할수 없다고 합니다.','2017년 11월부로 서버 오류 점검',TO_DATE('2017-06-28', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'1.협약된 매장과 서버운영자간의 더 나은 소통을 위해 문자전송서비스 추가,2.회원이 매장에 레시피 게시판에 사진 여러장 넣을수 있는 기능 추가 ','판교이디아점 임시 휴업',TO_DATE('2017-08-24', 'yyyy-mm-dd'),10);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'최근에 탈퇴한 회원정보는 관리자가 갖고있는지에 관하여 많은 회원분들이 문의를 하였었는데요.저희는 회원이 탈퇴한 순간 정보를 바로지워지므로 걱정안하셔도 됩니다.','물가 상승으로 인한 전반적인 가격 상승 ',TO_DATE('2017-10-30', 'yyyy-mm-dd'),50);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'판교 더리터점과 논의 끝에 기존가격유지하겠다고 하였으니 걱정안하셔도 됩니다.','판교 더리터점에서 아이스 아메리카노가격 관련 공지사항',TO_DATE('2017-08-01', 'yyyy-mm-dd'),5);

INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'서버상의 오류로 인하여 2017년 07월 22일 부득이하게 서버점검 할 예정이오니 이용에 불편함을끼쳐드려 죄송합니다.빠른시일내에 복구하겠습니다.','매장별 이벤트를 매월 1일에 실시합니다. 많은 참여바랍니다.',TO_DATE('2017-11-22', 'yyyy-mm-dd'),9);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'문정 스타벅스체인점이 내부공사로 인하여 2017년 07월 22일부터 29일까지 이용을 할수 없다고 합니다.','모든 협약 매장들에게 공지 . 필독!11',TO_DATE('2017-10-28', 'yyyy-mm-dd'),37);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'1.협약된 매장과 서버운영자간의 더 나은 소통을 위해 문자전송서비스 추가,2.회원이 매장에 레시피 게시판에 사진 여러장 넣을수 있는 기능 추가 ','판교 스타벅스 이벤트 실시!',TO_DATE('2017-08-24', 'yyyy-mm-dd'),13);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'최근에 탈퇴한 회원정보는 관리자가 갖고있는지에 관하여 많은 회원분들이 문의를 하였었는데요.저희는 회원이 탈퇴한 순간 정보를 바로지워지므로 걱정안하셔도 됩니다.','2017년 6월 24일부로 관리자 교체 ',TO_DATE('2017-10-30', 'yyyy-mm-dd'),21);
INSERT INTO notice_board_contents VALUES (notice_board_no_seq.nextval,'판교 더리터점과 논의 끝에 기존가격유지하겠다고 하였으니 걱정안하셔도 됩니다.','판교 빵커요점 2018년 1월부로  신축공사로 인한 임시휴업',TO_DATE('2017-06-01', 'yyyy-mm-dd'),44);




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
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-104','h');
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-104','c');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-104','r');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-104','k');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-105','c');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-105','p');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-105','m');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-106','c');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-106','r');                         
INSERT INTO STORE_PAYMENT_OPTIONLIST VALUES('s-106','o');                         

/* 예약내역 */
delete from reservation_details
select  *from RESERVATION_DETAILS
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),4,to_date('20170604', 'yyyy-mm-dd'),to_date('20170605','yyyy-mm-dd'),'p-100','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170604', 'yyyy-mm-dd'),6,to_date('20170604', 'yyyy-mm-dd'),to_date('20170605','yyyy-mm-dd'),'p-101','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,to_date('20170704', 'yyyy-mm-dd'),to_date('20170712','yyyy-mm-dd'),'p-102','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170703', 'yyyy-mm-dd'),4,to_date('20170704', 'yyyy-mm-dd'),to_date('20170713','yyyy-mm-dd'),'p-103','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),7,to_date('20170706', 'yyyy-mm-dd'),to_date('20170714','yyyy-mm-dd'),'p-104','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170705', 'yyyy-mm-dd'),10,to_date('20170707', 'yyyy-mm-dd'),to_date('20170707','yyyy-mm-dd'),'p-105','s-103','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170710', 'yyyy-mm-dd'),4,to_date('20170712', 'yyyy-mm-dd'),to_date('20170713','yyyy-mm-dd'),'p-106','s-104','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170710', 'yyyy-mm-dd'),12,to_date('20170711', 'yyyy-mm-dd'),to_date('20170713','yyyy-mm-dd'),'p-107','s-104','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170720', 'yyyy-mm-dd'),10,null,to_date('20170720','yyyy-mm-dd'),'p-108','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170719', 'yyyy-mm-dd'),20,null,to_date('20170721','yyyy-mm-dd'),'p-109','s-101','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170719', 'yyyy-mm-dd'),15,null,to_date('20170722','yyyy-mm-dd'),'p-110','s-102','u-1');
INSERT INTO RESERVATION_DETAILS VALUES(reservation_no_seq.nextval,to_date('20170720', 'yyyy-mm-dd'),4,null,to_date('20170725','yyyy-mm-dd'),'p-111','s-102','u-1');

/*결제 내역 */
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-100','s-101',0);              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',6,'u-1','p-101','s-101',0);   
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-102','s-101',0);                               
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'p',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-103','s-102',0);                            
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',7,'u-1','p-104','s-102',0);  
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',10,'u-1','p-105','s-103',0);    
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'p',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-106','s-104',0);                                     
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',12,'u-1','p-107','s-104',0); 
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'p',to_date('20160803', 'yyyy-mm-dd'),'r',10,'u-1','p-108','s-101',0);  
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',20,'u-1','p-109','s-101',0);                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',15,'u-1','p-110','s-102',0);                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'r',4,'u-1','p-111','s-101',11);                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',0,'u-1','p-112','s-101',6);                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',0,'u-1','p-113','s-101',8);       
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',0,'u-1','p-114','s-101',7);                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',0,'u-1','p-115','s-101',3);                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',0,'u-1','p-116','s-101',6);                              
INSERT INTO PAYMENT_DETAILS values(payment_no_seq.nextval,'c',to_date('20160803', 'yyyy-mm-dd'),'f',0,'u-1','p-117','s-101',11);                              


