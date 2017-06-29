/* 매장 방문 기록 */
CREATE TABLE store_visit_history (
	store_visit_history_no NUMBER PRIMARY KEY, /* 매장 방문 기록 번호 */
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE
);
CREATE SEQUENCE store_visit_history_no_seq;


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


