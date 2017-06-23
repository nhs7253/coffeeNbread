/* 일반 사용자 */
CREATE TABLE general_user (
	user_id VARCHAR2(30) PRIMARY KEY, /* 유저아이디 */
	user_pw VARCHAR2(50) NOT NULL, /* 비밀번호 */
	user_name VARCHAR2(50) NOT NULL, /* 이름 */
	user_birth DATE NOT NULL, /* 생년월일 */
	user_gender VARCHAR2(50) NOT NULL, /* 성별 */
	user_email VARCHAR2(50) NOT NULL, /* 이메일 */
	user_phone VARCHAR2(50) NOT NULL, /* 전화번호 */
	user_address VARCHAR2(200) NOT NULL /* 주소 */
);

