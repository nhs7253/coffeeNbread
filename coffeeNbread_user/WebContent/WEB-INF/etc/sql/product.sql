/* 매장 */
CREATE TABLE store (
	store_id VARCHAR2(30) PRIMARY KEY, /* 매장아이디 */
	store_name VARCHAR2(50) NOT NULL, /* 매장이름 */
	store_intro CLOB, /* 매장소개 */
	store_phone VARCHAR2(50) NOT NULL, /* 전화번호 */
	store_address VARCHAR2(200) NOT NULL, /* 주소 */
	store_email VARCHAR2(50) NOT NULL, /* 이메일 */
	store_picture VARCHAR2(300), /* 매장사진 */
	store_hits NUMBER NOT NULL, /* 조회수 */
	store_open DATE NOT NULL, /* 여는 시간 */
	store_close DATE NOT NULL, /* 닫는 시간 */
	store_permission CHAR(1) NOT NULL  /* 매장 허가여부  */
);

/* 제품 */
CREATE TABLE product (
	product_id VARCHAR2(30) PRIMARY KEY, /* 제품아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	product_name VARCHAR2(50) NOT NULL, /* 제품이름 */
	product_picture VARCHAR2(300) NOT NULL, /* 제품사진 */
	product_price NUMBER(6) NOT NULL, /* 제품가격 */
	product_category VARCHAR2(50) NOT NULL, /* 제품종류 */
	product_detail CLOB NOT NULL, /* 제품상세설명 */
	selling_option CHAR(1) NOT NULL, /* 판매여부 */
	today_product_count NUMBER NOT NULL, /* 금일 제품 개수 */
	recommend_product_count NUMBER NOT NULL, /* 추천 제품 개수 */
	FOREIGN KEY(store_id) REFERENCES store(store_id)
);

INSERT INTO store VALUES('m-1', '매장1', '매장1', '031-1111-2222', '일산', 'm1@m.com', '사진', 1, '2001-11-11', '2001-11-11', 'Y');
INSERT INTO product VALUES('p-1', 'm-1', '단팥빵', '사진', 2000, '빵', '단팥빵빵', 'Y', 30, 10);


SELECT * FROM store;
SELECT * FROM product;

DELETE FROM store;
DELETE FROM product;

DELETE FROM product WHERE store_id = 'm-1' AND product_id = 'p-1';