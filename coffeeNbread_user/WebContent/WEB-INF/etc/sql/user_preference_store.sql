/* 사용자 선호 매장 */
CREATE TABLE user_preference_store (
	user_id VARCHAR2(30) NOT NULL, /* 유저아이디 */
	store_id VARCHAR2(30) NOT NULL, /* 매장아이디 */
	preference_hits NUMBER NOT NULL, /* 조회수 */
	PRIMARY KEY(user_id, store_id),
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES general_user(user_id) ON DELETE CASCADE
);

SELECT * FROM user_preference_store 
WHERE user_id = 'u-1' ORDER BY preference_hits DESC;

SELECT * FROM user_preference_store;

SELECT * FROM user_preference_store
WHERE user_id = 'u-4'

INSERT INTO user_preference_store VALUES('u-1', 's-1', 0);
INSERT INTO user_preference_store VALUES('u-1', 's-2', 1);
INSERT INTO user_preference_store VALUES('u-1', 's-3', 2);

INSERT INTO user_preference_store VALUES('u-4', 's-7', 0);

INSERT INTO user_preference_store VALUES('u-2', 's-1', 0);

DELETE FROM user_preference_store WHERE user_id = 'u-1'

DELETE FROM user_preference_store WHERE user_id = 'u-4'

UPDATE user_preference_store 
SET preference_hits = preference_hits + 1
WHERE user_id = 'u-1' AND store_id = 's-1';

UPDATE user_preference_store 
SET preference_hits = (SELECT preference_hits FROM user_preference_store WHERE user_id = 'u-1' AND store_id = 's-1') + 1
WHERE user_id = 'u-1' AND store_id = 's-1';


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


					SELECT rownum rnum, 
						   user_id, 
						   store_id,
						   preference_hits,
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
						SELECT user_id, 
							   s.store_id, 
							   preference_hits,
							   store_name, 
							   store_intro, 
							   store_phone, 
							   store_address, 
							   store_email, 
							   store_hits, 
							   store_open, 
							   store_close, 
							   store_permission
						FROM user_preference_store ups, store s 
						WHERE ups.store_id = s.store_id AND user_id = 'u-4'
						ORDER BY preference_hits DESC
					)
					WHERE rownum <= '5'
					
					
					SELECT rownum rnum, 
				   user_id, 
				   store_id, 
				   preference_hits,
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
				   SELECT user_id, 
						  s.store_id, 
						  preference_hits,
						  store_name, 
						  store_intro, 
						  store_phone, 
						  store_address, 
						  store_email, 
						  store_hits, 
						  store_open, 
						  store_close, 
						  store_permission
					FROM user_preference_store ups, store s 
					WHERE ups.store_id = s.store_id AND user_id = 'u-4'
					ORDER BY preference_hits DESC
			) 
			WHERE rownum <= '5'
					
					
			
			SELECT rownum rnum,         
			user_id,         
			store_id,        
			preference_hits,       
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
			  SELECT user_id,       
			  s.store_id,    
		     preference_hits,     
		     store_name,     
		     store_intro,       
		     store_phone,        
		     store_address,        
		     store_email,      
		     store_hits,        
		     store_open,        
		     store_close,        
		     store_permission    
		     FROM user_preference_store ups, store s  
		     WHERE ups.store_id = s.store_id AND user_id = 'u-4'  
		     ORDER BY preference_hits DESC    )   
		     WHERE rownum <= '5'
					
		     
		     
		     
		     SELECT count(*)
			FROM(
				   SELECT user_id, 
						  s.store_id, 
						  preference_hits,
						  store_name, 
						  store_intro, 
						  store_phone, 
						  store_address, 
						  store_email, 
						  store_hits, 
						  store_open, 
						  store_close, 
						  store_permission
					FROM user_preference_store ups, store s 
					WHERE ups.store_id = s.store_id AND user_id = 'u-4'
					ORDER BY preference_hits DESC
			) 
			WHERE rownum <= '5'

