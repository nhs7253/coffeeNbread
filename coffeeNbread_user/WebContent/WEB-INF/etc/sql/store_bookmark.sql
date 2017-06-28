/* 매장 즐겨찾기 */
CREATE TABLE store_bookmark (
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	PRIMARY KEY(user_id, store_id),
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE,
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);




DELETE FROM user_authority WHERE user_id = '2' AND user_authority = 'CNB_ADMIN';

DELETE FROM user_authority WHERE user_id = '1';
DELETE FROM user_authority;

DELETE FROM	store_bookmark
WHERE user_id = '1' and 
store_id = '1'

SELECT * FROM user_authority;

SELECT * 
FROM store_bookmark
WHERE user_id = 'u-1';

UPDATE store_bookmark 
SET store_id = 's-2'
WHERE user_id = 'u-2';

INSERT INTO store_bookmark VALUES('u-1', 's-1');
INSERT INTO store_bookmark VALUES('u-1', 's-2');
INSERT INTO store_bookmark VALUES('u-2', 's-1');

DELETE FROM store_bookmark WHERE user_id = 'u-1';

DELETE FROM store_bookmark WHERE user_id = 'u-3';
DELETE FROM store_bookmark WHERE user_id = 'u-4';



	store_id VARCHAR2(30) PRIMARY KEY, /* 매장아이디 */
	store_name VARCHAR2(50) NOT NULL, /* 매장이름 */
	store_intro CLOB, /* 매장소개 */
	store_phone VARCHAR2(50) NOT NULL, /* 전화번호 */
	store_address VARCHAR2(200) NOT NULL, /* 주소 */
	store_email VARCHAR2(50) NOT NULL, /* 이메일 */
	store_hits NUMBER NOT NULL, /* 조회수 */
	store_open DATE NOT NULL, /* 여는 시간 */
	store_close DATE NOT NULL, /* 닫는 시간 */
	store_permission CHAR(1) NOT NULL  /* 매장 허가여부  */



SELECT user_id, s.store_id, store_name, store_intro, store_phone, store_address, store_email, store_hits, store_open, store_close, store_permission
FROM store_bookmark sb, store s
WHERE sb.store_id = s.store_id AND user_id = 'u-2'

/* 유저 */
SELECT *FROM GENERAL_USER
DELETE FROM GENERAL_USER
INSERT INTO GENERAL_USER VALUES('u-1','pw-1','user1',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');
INSERT INTO GENERAL_USER VALUES('u-2','pw-2','user2',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');
INSERT INTO GENERAL_USER VALUES('u-3','pw-3','user3',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');
INSERT INTO GENERAL_USER VALUES('u-4','pw-4','user4',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');

INSERT INTO GENERAL_USER VALUES('u-5','$2a$10$8sqmTtoKTZ2/aWW06ZH6mOIZQ2mkdANEL.Emg25kxHGtziuV5.oP2','user5',to_date('20160803', 'yyyy-mm-dd'),'남','user2@naver.com','010-0000-0000','주소2','Y');

INSERT INTO user_authority VALUES('u-5', 'CNB_USER');




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
INSERT INTO PRODUCT VALUES('p-17','s-6','제품17',5000,'빵','제품설명글16','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-18','s-7','제품18',5000,'빵','제품설명글16','Y',500,1000);
INSERT INTO PRODUCT VALUES('p-19','s-7','제품19',5000,'빵','제품설명글16','Y',500,1000);



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
INSERT INTO SHOPPING_BASKET_PRODUCT VALUES('p-1','u-1','s-1',4,'s-1')


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


