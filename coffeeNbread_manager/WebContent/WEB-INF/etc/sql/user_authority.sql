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


