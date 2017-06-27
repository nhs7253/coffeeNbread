/* 예약 내역 */
CREATE TABLE reservation_details (
	reservation_no NUMBER PRIMARY KEY, /* 예약번호 */
	reservation_time DATE NOT NULL, /* 예약시간 */
	reservation_count NUMBER(3) NOT NULL, /* 예약개수 */
	reservation_confirm DATE NOT NULL, /* 예약확인유무 */
	product_hope_time DATE NULL,/*제품수령희망시간*/
	product_id VARCHAR2(30) NOT NULL, /* 제품아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	user_id VARCHAR2(30), /* 유저아이디 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE,
	FOREIGN KEY(product_id) REFERENCES product(product_id) ON DELETE CASCADE
);
CREATE SEQUENCE reservation_no_seq;

DROP TABLE reservation_details;

SELECT * FROM reservation_details;

INSERT INTO general_user VALUES('u-0', '1111', '최민희', '2017-06-27', '여', 'm@m.com', '010-0000-0000', '일산', 'Y');
INSERT INTO general_user VALUES('u-1', '1111', '최민희', TO_DATE('2017/06/27 14:30:00','yyyy/mm/dd hh24:mi:ss'), '여', 'm@m.com', '010-0000-0000', '일산', 'Y');