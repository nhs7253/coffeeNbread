/* 사용자 권한 */
CREATE TABLE user_authority (
	user_id VARCHAR2(30) PRIMARY KEY, /* 유저아이디 */
	user_authority VARCHAR2(50) NOT NULL /* 권한 */
);


SELECT * FROM user_authority;

INSERT INTO user_authority VALUES('1', 'CNB_USER');
INSERT INTO user_authority VALUES('2', 'CNB_ADMIN');
INSERT INTO user_authority VALUES('3', 'CNB_USER');
INSERT INTO user_authority VALUES('4', 'CNB_STORE');

DELETE FROM user_authority WHERE user_id = '2' AND user_authority = 'CNB_ADMIN';

DELETE FROM user_authority WHERE user_id = '1';
DELETE FROM user_authority;

SELECT * FROM user_authority;

SELECT * 
FROM user_authority
WHERE user_id = '1';

UPDATE user_authority 
SET user_authority = 'CNB_STORE'
WHERE user_id = '1';

SELECT payment_no,
		store_name,
		product_name,
		sell_method,
		payment_option,
		reservation_order_count,
		product_price,
		trade_date,
		payment_method
		FROM(
		SELECT rownum rnum,
		payment_no,
		store_name,
		product_name,
		sell_method,
		payment_option,
		reservation_order_count,
		product_price,
		trade_date,
		payment_method
		FROM(
		SELECT
		pd.payment_no,
		s.store_name,
		p.product_name,
		pd.sell_method,
		pd.payment_option,
		pd.reservation_order_count,
		p.product_price,
		pd.trade_date,
		payment_method
		FROM payment_details pd, product p, store s, payment_optionList po
		where pd.product_id=p.product_id 
		and s.store_id = p.store_id
		and pd.payment_option = po.payment_id
		and pd.user_id = 'test'
		)
		WHERE rownum <= 5
		)
		WHERE rnum >= 1
