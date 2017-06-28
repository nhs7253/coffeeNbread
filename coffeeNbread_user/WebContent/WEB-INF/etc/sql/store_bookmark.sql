/* 매장 좌표 */
CREATE TABLE store_position (
	store_id VARCHAR2(30) PRIMARY KEY, /* 매장아이디 */
	X VARCHAR2(50) NOT NULL, /* X좌표 */
	Y VARCHAR2(50) NOT NULL, /* Y좌표 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
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


