/* 일반 사용자 */
CREATE TABLE general_user (
	user_id VARCHAR2(30) PRIMARY KEY, /* 유저아이디 */
	user_pw VARCHAR2(50) NOT NULL, /* 비밀번호 */
	user_name VARCHAR2(50) NOT NULL, /* 이름 */
	user_birth DATE NOT NULL, /* 생년월일 */
	user_gender VARCHAR2(50) NOT NULL, /* 성별 */
	user_email VARCHAR2(50) NOT NULL, /* 이메일 */
	user_phone VARCHAR2(50) NOT NULL, /* 전화번호 */
	user_address VARCHAR2(200) NOT NULL, /* 주소 */
	user_active_state CHAR(1) NOT NULL /* 활동 상태 */
);


INSERT INTO general_user VALUES('1', '1111', '유저1', '2000-01-11', '남자', 'm1@m.com', '010-1111-1111', '판교', 'Y');
INSERT INTO general_user VALUES('2', '2222', '유저2', '2000-02-21', '남자', 'm2@m.com', '010-2222-2222', '서울', 'Y');

SELECT * FROM general_user;
DELETE FROM general_user WHERE user_id = '1';
DELETE FROM general_user;

UPDATE general_user 
SET user_pw = '3333',
	user_name = '유저3',
	user_birth = '2000-03-31',
	user_gender = '남자',
	user_email = 'm3@m.com',
	user_phone = '010-3333-3333',
	user_address = '경기',
	user_active_state = 'N'
WHERE user_id = '2';

UPDATE general_user    
SET user_active_state = 'N'  
WHERE user_id = '1'
