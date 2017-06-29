/* 매장 방문 기록 */
CREATE TABLE store_visit_history (
	store_visit_history_no NUMBER PRIMARY KEY, /* 매장 방문 기록 번호 */
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE
);
CREATE SEQUENCE store_visit_history_no_seq;


SELECT * FROM store_visit_history;

INSERT INTO store_visit_history VALUES(0, 'u-1', 's-1');
INSERT INTO store_visit_history VALUES(100, 'u-1', 's-2');
INSERT INTO store_visit_history VALUES(101, 'u-1', 's-3');
INSERT INTO store_visit_history VALUES(102, 'u-1', 's-4');

INSERT INTO store_visit_history VALUES(103, 'u-2', 's-1');
INSERT INTO store_visit_history VALUES(104, 'u-2', 's-2');
INSERT INTO store_visit_history VALUES(105, 'u-2', 's-3');
INSERT INTO store_visit_history VALUES(106, 'u-2', 's-4');

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

		SELECT store_visit_history_no,
			   user_id, 
			   s.store_id, 
			   store_name, 
			   store_intro, 
			   store_phone, 
			   store_address, 
			   store_email, 
			   store_hits, 
			   store_open, 
			   store_close, 
			   store_permission
		FROM store_visit_history svh, store s
		WHERE svh.store_id = s.store_id AND user_id = 'u-1'
		ORDER BY store_visit_history_no DESC

		SELECT store_visit_history_no,
			   user_id, 
			   s.store_id, 
			   store_name, 
			   store_intro, 
			   store_phone, 
			   store_address, 
			   store_email, 
			   store_hits, 
			   store_open, 
			   store_close, 
			   store_permission
		FROM store_visit_history svh, store s
		WHERE svh.store_id = s.store_id AND user_id = #{value}
		ORDER BY store_visit_history_no DESC

		
		SELECT COUNT(*)
		FROM store_visit_history svh, store s
		WHERE svh.store_id = s.store_id AND user_id = #{value}
		
		SELECT COUNT(*)
		FROM store_visit_history svh, store s
		WHERE svh.store_id = s.store_id AND user_id = 'u-1'
		
		
			
			SELECT store_visit_history_no,
				   user_id, 
				   store_id, 
				   store_name, 
				   store_intro, 
				   store_phone, 
				   store_address, 
				   store_email, 
				   store_hits, 
				   store_open, 
				   store_close, 
				   store_permission
			FROM(
					SELECT rownum rnum, 
						   store_visit_history_no,
						   user_id, 
						   store_id, 
						   store_name, 
						   store_intro, 
						   store_phone, 
						   store_address, 
						   store_email, 
						   store_hits, 
						   store_open, 
						   store_close, 
						   store_permission
					FROM(
						SELECT store_visit_history_no,
							   user_id, 
							   s.store_id, 
							   store_name, 
							   store_intro, 
							   store_phone, 
							   store_address, 
							   store_email, 
							   store_hits, 
							   store_open, 
							   store_close, 
							   store_permission
						FROM store_visit_history svh, store s 
						WHERE svh.store_id = s.store_id AND user_id = #{userId}
						ORDER BY store_visit_history_no DESC
					) 
					WHERE rownum <= #{endIndex}
			)
			WHERE rnum >= #{startIndex}
			
			
			SELECT store_visit_history_no,
				   user_id, 
				   store_id, 
				   store_name, 
				   store_intro, 
				   store_phone, 
				   store_address, 
				   store_email, 
				   store_hits, 
				   store_open, 
				   store_close, 
				   store_permission
			FROM(
					SELECT rownum rnum, 
						   store_visit_history_no,
						   user_id, 
						   store_id, 
						   store_name, 
						   store_intro, 
						   store_phone, 
						   store_address, 
						   store_email, 
						   store_hits, 
						   store_open, 
						   store_close, 
						   store_permission
					FROM(
						SELECT store_visit_history_no,
							   user_id, 
							   s.store_id, 
							   store_name, 
							   store_intro, 
							   store_phone, 
							   store_address, 
							   store_email, 
							   store_hits, 
							   store_open, 
							   store_close, 
							   store_permission
						FROM store_visit_history svh, store s 
						WHERE svh.store_id = s.store_id AND user_id = 'u-1'
						ORDER BY store_visit_history_no DESC
					) 
					WHERE rownum <= '3'
			)
			WHERE rnum >= '2'
			
			SELECT COUNT(*)
			FROM(
					SELECT rownum rnum, 
						   store_visit_history_no,
						   user_id, 
						   store_id, 
						   store_name, 
						   store_intro, 
						   store_phone, 
						   store_address, 
						   store_email, 
						   store_hits, 
						   store_open, 
						   store_close, 
						   store_permission
					FROM(
						SELECT store_visit_history_no,
							   user_id, 
							   s.store_id, 
							   store_name, 
							   store_intro, 
							   store_phone, 
							   store_address, 
							   store_email, 
							   store_hits, 
							   store_open, 
							   store_close, 
							   store_permission
						FROM store_visit_history svh, store s 
						WHERE svh.store_id = s.store_id AND user_id = 'u-1'
						ORDER BY store_visit_history_no DESC
					) 
					WHERE rownum <= '3'
			)
			WHERE rnum >= '2'

