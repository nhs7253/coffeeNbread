/*
	CREATE USER CNB_manager IDENTIFIED BY manager;
	GRANT ALL PRIVILEGES TO CNB_manager; 
*/

--테이블 : 24, 시퀀스 : 9 - 총합 : 33 */     --7월 20일 최종 수정
/* 테이블 및 시퀀스 생성 */


/* 사용자 권한 */
CREATE TABLE user_authority (
	user_id VARCHAR2(30) PRIMARY KEY, /* 유저아이디 */
	user_authority VARCHAR2(50) NOT NULL /* 권한 */
);

/* 결제 종류 */
CREATE TABLE payment_optionlist (
	payment_id CHAR(1) PRIMARY KEY, /* 결제아이디 */
	payment_method VARCHAR2(50) NOT NULL /* 결제방법 */
);

/* 일반 사용자 */
CREATE TABLE general_user (
	user_id VARCHAR2(30) PRIMARY KEY, /* 유저아이디 */
	user_pw VARCHAR2(80) NOT NULL, /* 비밀번호 */
	user_name VARCHAR2(50) NOT NULL, /* 이름 */
	user_birth DATE NOT NULL, /* 생년월일 */
	user_gender VARCHAR2(50) NOT NULL, /* 성별 */
	user_email VARCHAR2(50) NOT NULL, /* 이메일 */
	user_phone VARCHAR2(50) NOT NULL, /* 전화번호 */
	user_address VARCHAR2(200) NOT NULL, /* 주소 */
	user_active_state CHAR(1) NOT NULL, /* 활동 상태 */
	store_id VARCHAR2(30) /* 매장아이디 */
);


/* 매장 */
CREATE TABLE store (
	store_id VARCHAR2(30) PRIMARY KEY, /* 매장아이디 */
	store_name VARCHAR2(50) NOT NULL, /* 매장이름 */
	store_intro CLOB, /* 매장소개 */
	store_phone VARCHAR2(50) NOT NULL, /* 전화번호 */
	store_address VARCHAR2(200) NOT NULL, /* 주소 */
	store_email VARCHAR2(50) NOT NULL, /* 이메일 */
	store_category VARCHAR2(200), /* 매장분류 */
	store_hits NUMBER NOT NULL, /* 조회수 */
	store_open DATE NOT NULL, /* 여는 시간 */
	store_close DATE NOT NULL, /* 닫는 시간 */
	store_permission CHAR(1) NOT NULL  /* 매장 허가여부  */
);

/* 제품 */
CREATE TABLE product (
	product_id VARCHAR2(30) PRIMARY KEY, /* 제품아이디 */
	store_id VARCHAR2(30), /* 매장아이디 */
	product_name VARCHAR2(50) NOT NULL, /* 제품이름 */
	product_price NUMBER(6) NOT NULL, /* 제품가격 */
	product_category VARCHAR2(50) NOT NULL, /* 제품종류 */
	product_detail CLOB NOT NULL, /* 제품상세설명 */
	selling_option CHAR(1) NOT NULL, /* 판매여부 */
	today_product_count NUMBER NOT NULL, /* 금일 제품 개수 */
	recommend_product_count NUMBER NOT NULL, /* 추천 제품 개수 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE SET NULL

);




/* 매장 방문 기록 */
CREATE TABLE store_visit_history (
	store_visit_history_no NUMBER PRIMARY KEY, /* 매장 방문 기록 번호 */
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE
);
CREATE SEQUENCE store_visit_history_no_seq;

/* 사용자 선호 매장 */
CREATE TABLE user_preference_store (
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	preference_hits NUMBER NOT NULL, /* 조회수 */
	PRIMARY KEY(user_id, store_id),
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE
);

/* 공지사항 게시글 */
CREATE TABLE notice_board_contents (
	notice_board_no NUMBER PRIMARY KEY, /* 공지글번호 */
	notice_board_content CLOB NOT NULL, /* 공지내용 */
	notice_board_title VARCHAR2(300) NOT NULL, /* 공지제목 */
	notice_board_date DATE NOT NULL, /* 공지작성일시 */
	notice_board_hits NUMBER(6) NOT NULL /* 공지조회수 */
);
CREATE SEQUENCE notice_board_no_seq;

/* 레시피 게시글 */
/* 유저 탈퇴시에도 레시피는 남으나 매장이 없어지면 해당 레시피 글들도 삭제 */   /* 매장아이디 not null에서 null로 수정- 유저가 매장이 가지고 있는 게시판에 등록하는게 아니라 그냥 등록할수 있게 하기위해 */
CREATE TABLE recipe_board_contents (
	recipe_board_no NUMBER PRIMARY KEY, /* 레시피 글번호 */
	recipe_board_content CLOB NOT NULL, /* 레시피 글내용 */
	recipe_board_title VARCHAR2(300) NOT NULL, /* 레시피 글제목 */
	recipe_board_date DATE NOT NULL, /* 레시피 글작성일시 */
	recipe_board_hits NUMBER(6) NOT NULL, /* 레시피 글조회수 */
	recipe_board_picture VARCHAR2(300) NOT NULL, /* 레시피 사진 */
	recommend_count NUMBER NOT NULL, /* 추천수 */
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30),/* 매장아이디 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id)
);
CREATE SEQUENCE recipe_board_no_seq;

/* QNA게시글 */
CREATE TABLE qna_board_contents (
	qna_board_no NUMBER PRIMARY KEY, /* 문의글번호 */
	qna_store_id VARCHAR2(30),  /* 매장 아이디 */
	qna_board_writer VARCHAR2(30) NOT NULL, /* 문의글작성자 */
	qna_board_title VARCHAR2(300) NOT NULL, /* 문의제목 */
	qna_board_content CLOB NOT NULL, /* 문의내용 */
	qna_board_date DATE NOT NULL, /* 문의작성일지 */
	qna_board_hits NUMBER(6) NOT NULL, /* 문의조회수 */
	qna_board_secret CHAR(1) NOT NULL /* 비밀글 */
	
);
CREATE SEQUENCE qna_board_no_seq;

/* 게시판 댓글 */
/* 문의글이나 레시피 글 중 하나에만 달림으로 둘다 널을 허용 */
/* 문의글은 삭제가 되지 않을 예정이나, 혹시 삭제가 된다면(테스트 등의 경우로) 같이 삭제 되도록 함 */
CREATE TABLE board_reply (
	reply_no NUMBER PRIMARY KEY, /* 댓글번호 */
	reply_content CLOB NOT NULL, /* 댓글내용 */
	reply_name VARCHAR2(30) NOT NULL, /* 댓글작성자 */
	reply_regdate DATE NOT NULL, /* 댓글작성일 */
	qna_board_no NUMBER, /* 문의글번호 */
	recipe_board_no NUMBER, /* 레시피 글번호 */
	FOREIGN KEY(recipe_board_no) REFERENCES recipe_board_contents(recipe_board_no) ON DELETE CASCADE,
	FOREIGN KEY(qna_board_no) REFERENCES qna_board_contents(qna_board_no) ON DELETE CASCADE
);
CREATE SEQUENCE reply_no_seq;


/* 결제 내역 */
CREATE TABLE payment_details (
	payment_no NUMBER PRIMARY KEY, /* 결제 번호 */
	payment_option CHAR(1) NOT NULL, /* 결제수단 */
	trade_date DATE NOT NULL, /* 거래날짜 */
	sell_method CHAR(1) NOT NULL, /* 판매방식 */
	reservation_order_count NUMBER(4) NOT NULL, /* 주문판매량 */
	user_id VARCHAR2(30), /* 유저아이디 */
	product_id VARCHAR2(30) NOT NULL, /* 제품아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */   -- 매장아이디 NOT NULL로 변경 - 2017-07-13
	product_trade_count NUMBER(4) NOT NULL, /* 거래제품개수 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE SET NULL,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id),
	FOREIGN KEY(product_id) REFERENCES product(product_id)
);
CREATE SEQUENCE payment_no_seq;

/* 예약 내역 */
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
CREATE SEQUENCE reservation_no_seq;

/* 매장분류 */
CREATE TABLE store_category (
	store_category_no NUMBER PRIMARY KEY, /* 매장분류번호 */
	store_category VARCHAR2(200) NOT NULL, /* 매장분류 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);
CREATE SEQUENCE store_category_no_seq;

/* 장바구니 물품 */
CREATE TABLE shopping_basket_product (
	product_id VARCHAR2(30) NOT NULL, /* 제품아이디 */
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	product_count NUMBER(4) NOT NULL, /* 제품개수 */
	product_store_id VARCHAR2(30) NOT NULL, /* 제품 매장 아이디 */
	PRIMARY KEY(user_id, product_id, store_id,product_store_id),
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE,
	FOREIGN KEY(product_id) REFERENCES product(product_id) ON DELETE CASCADE,
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(product_store_id) REFERENCES store(store_id) ON DELETE CASCADE

);

/* 매장 즐겨찾기 */
CREATE TABLE store_bookmark (
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	PRIMARY KEY(user_id, store_id),
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE,
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);


/* 매장위치 */
CREATE TABLE store_position (
	store_id VARCHAR2(30) PRIMARY KEY, /* 매장아이디 */
	X VARCHAR2(50) NOT NULL, /* X좌표 */
	Y VARCHAR2(50) NOT NULL, /* Y좌표 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);

/* 즐겨찾는 카드번호 */
CREATE TABLE bookmark_card_num (
	card_num VARCHAR2(100) PRIMARY KEY, /* 카드번호 */
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디*/
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE
);

/* 제품증감폭 */
CREATE TABLE product_gap(
    identify_code CHAR(1) NOT NULL,
    product_gap VARCHAR2(50) NOT NULL,
    product_id VARCHAR2(30) NOT NULL,
    store_id VARCHAR2(30) NOT NULL,
    PRIMARY KEY(identify_code, product_gap, product_id, store_id)
);

/* 매장 사진  */
CREATE TABLE store_picture (
	store_picture VARCHAR2(300) PRIMARY KEY,  /* 매장 사진 */
	store_id NOT NULL,  /* 매장 아이디  */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);

/* 제품 사진  */
CREATE TABLE product_picture (
	product_picture VARCHAR2(300) PRIMARY KEY, /* 제품 사진 */
	product_id NOT NULL, /* 제품 아이디 */
	store_id NOT NULL,  /* 매장 아이디  */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
    FOREIGN KEY(product_id) REFERENCES product(product_id) ON DELETE CASCADE

);


/* 옵션카테고리 */
CREATE TABLE option_category (
   option_id NUMBER NOT NULL, /* 옵션아이디 */
   store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
   option_category VARCHAR2(100) NOT NULL, /* 옵션종류 */
   PRIMARY KEY(option_id, store_id),
   FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);
CREATE SEQUENCE option_id_seq;

/* 옵션 상세 */
CREATE TABLE option_detail (
   store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
   product_id VARCHAR2(30) NOT NULL, /* 제품아이디 */
   option_id NUMBER NOT NULL, /* 옵션아이디 */
   option_category_detail VARCHAR2(100) NOT NULL, /* 옵션 */
   PRIMARY KEY(store_id, product_id, option_id),
   FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
   FOREIGN KEY(product_id) REFERENCES product(product_id) ON DELETE CASCADE,
   FOREIGN KEY(option_id, store_id) REFERENCES option_category(option_id, store_id) ON DELETE CASCADE
);

/* 매장 결제 종류 */
CREATE TABLE store_payment_optionlist (
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디  */
	payment_id CHAR(1) NOT NULL, /* 결제아이디 */
	PRIMARY KEY(store_id, payment_id),
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(payment_id) REFERENCES payment_OptionList(payment_id) ON DELETE CASCADE
);



/* 관리자 */
SELECT * FROM admin;
/* 사용자 권한 */
SELECT * FROM user_authority;
/* 결제 종류 */
SELECT * FROM payment_optionlist;
/* 일반 사용자 */
SELECT * FROM general_user;
/* 매장 */
SELECT * FROM store;
/* 제품 */
SELECT * FROM product;

/* 매장 방문 기록 */
SELECT * FROM store_visit_history;
/* 사용자 선호 매장 */
SELECT * FROM user_preference_store;
/* 공지사항 게시글 */
SELECT * FROM notice_board_contents;
/* 레시피 게시글 */
SELECT * FROM recipe_board_contents;
/* QNA게시글 */
SELECT * FROM qna_board_contents;
/* 게시판 댓글 */
SELECT * FROM board_reply;

/* 결제 내역 */
SELECT * FROM payment_details;
/* 예약 내역 */
SELECT * FROM reservation_details;
/* 매장분류 */
SELECT * FROM store_category;
/* 장바구니 물품 */
SELECT * FROM shopping_basket_product;
/* 매장 즐겨찾기 */
SELECT * FROM store_bookmark;
/* 매장 좌표 */
SELECT * FROM store_position;
/* 즐겨찾는 카드번호 */
SELECT * FROM bookmark_card_num;
/* 제품증감폭 */
SELECT * FROM product_gap;
/* 매장 사진  */
SELECT * FROM store_picture;
/* 제품 사진  */
SELECT * FROM product_picture;

/* 옵션카테고리 */
SELECT * FROM option_category;
/* 옵션 상세 */
SELECT * FROM option_detail;
/* 제품 결제 내역 */
SELECT * FROM store_payment_optionlist;

/* 공지사항 게시글 시퀀스 */
SELECT notice_board_no_seq.nextval FROM dual;
/* 레시피 게시글 시퀀스 */
SELECT recipe_board_no_seq.nextval FROM dual;
/* QNA게시글 시퀀스 */
SELECT qna_board_no_seq.nextval FROM dual;
/* 게시판 댓글 시퀀스 */
SELECT reply_no_seq.nextval FROM dual;
/* 결제 내역 시퀀스 */
SELECT payment_no_seq.nextval FROM dual;
/* 예약 내역 시퀀스 */
SELECT reservation_no_seq.nextval FROM dual;
/* 매장분류 시퀀스 */
SELECT store_category_no_seq.nextval FROM dual;

/* 옵션카테고리 */
SELECT option_id_seq.nextval FROM dual;
/* 매장 방문 기록 */
SELECT store_visit_history_no_seq.nextval FROM dual;

/* 삭제 */


/* 매장 결제 종류 */
DROP TABLE store_payment_optionlist;
/* 옵션 상세 */
DROP TABLE option_detail;
/* 옵션카테고리 */
DROP TABLE option_category;

/* 매장 사진  */
DROP TABLE store_picture;
/* 제품 사진  */
DROP TABLE product_picture;
/* 제품증감폭 */
DROP TABLE product_gap;
/* 즐겨찾는 카드번호 */
DROP TABLE bookmark_card_num;
/* 매장 좌표 */
DROP TABLE store_position;
/* 매장 즐겨찾기 */
DROP TABLE store_bookmark;
/* 장바구니 물품 */
DROP TABLE shopping_basket_product;
/* 매장분류 */
DROP TABLE store_category;
/* 예약 내역 */
DROP TABLE reservation_details;
/* 결제 내역 */
DROP TABLE payment_details;

/* 게시판 댓글 */
DROP TABLE board_reply;
/* QNA게시글 */
DROP TABLE qna_board_contents;
/* 레시피 게시글 */
DROP TABLE recipe_board_contents;
/* 공지사항 게시글 */
DROP TABLE notice_board_contents;
/* 사용자 선호 매장 */
DROP TABLE user_preference_store;
/* 매장 방문 기록 */
DROP TABLE store_visit_history;

/* 제품 */
DROP TABLE product;
/* 매장 */
DROP TABLE store;
/* 일반 사용자 */
DROP TABLE general_user;
/* 결제 종류 */
DROP TABLE payment_optionlist;
/* 사용자 권한 */
DROP TABLE user_authority;


/* 공지사항 게시글 */
DROP SEQUENCE notice_board_no_seq;
/* 레시피 게시글 */
DROP SEQUENCE recipe_board_no_seq;
/* QNA게시글 */
DROP SEQUENCE qna_board_no_seq;
/* 게시판 댓글 */
DROP SEQUENCE reply_no_seq;
/* 결제 내역 */
DROP SEQUENCE payment_no_seq;
/* 예약 내역 */
DROP SEQUENCE reservation_no_seq;
/* 매장분류 */
DROP SEQUENCE store_category_no_seq;

/* 옵션카테고리 */
DROP SEQUENCE option_id_seq;
/* 매장 방문 기록 */
DROP SEQUENCE store_visit_history_no_seq;


