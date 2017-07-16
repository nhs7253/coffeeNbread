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


		select
		sbp.store_id,
		s.store_name,
		p.product_price,
		pp.product_picture,
		p.product_category,
		p.product_name,
		p.product_id,
		sbp.product_count
		from store s, product p, product_picture pp, shopping_basket_product sbp
		where s.store_id(+)=p.store_id
		and pp.product_id(+)=p.product_id
		and sbp.product_id(+)=p.product_id
		and sbp.user_id ='u-1'
		and sbp.store_id='s-10000000'
		
		
		
		장바구니-  p-18 u-1 s-100000
		        p-19
		        p-21
		and sbp.store_id='s-10000000'
		
		
		SELECT *
		FROM shopping_basket_product
		WHERE store_id='s-10000000'