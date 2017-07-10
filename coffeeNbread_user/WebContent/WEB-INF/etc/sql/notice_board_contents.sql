/* 공지사항 게시글 */
CREATE TABLE notice_board_contents (
	notice_board_no NUMBER PRIMARY KEY, /* 공지글번호 */
	notice_board_content CLOB NOT NULL, /* 공지내용 */
	notice_board_title VARCHAR2(300) NOT NULL, /* 공지제목 */
	notice_board_date DATE NOT NULL, /* 공지작성일시 */
	notice_board_hits NUMBER(6) NOT NULL /* 공지조회수 */
);
CREATE SEQUENCE notice_board_no_seq;


SELECT notice_board_no,
       notice_board_content,
       notice_board_title,
       notice_board_date,
       notice_board_hits
FROM notice_board_contents
ORDER BY notice_board_no DESC

SELECT notice_board_no,
       notice_board_content,
       notice_board_title,
       notice_board_date,
       notice_board_hits
			FROM(
					SELECT rownum rnum, 
	  					   notice_board_no,
       notice_board_content,
       notice_board_title,
       notice_board_date,
       notice_board_hits
					FROM(
						SELECT notice_board_no,
       notice_board_content,
       notice_board_title,
       notice_board_date,
       notice_board_hits
						FROM notice_board_contents
						ORDER BY notice_board_no DESC
					) 
					WHERE rownum <= 3
			)
			WHERE rnum >= 2



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


		SELECT COUNT(*)
			FROM(
					SELECT rownum rnum, 
						   
					FROM(
						SELECT store_visit_history_no,
							   
						FROM store_visit_history svh, store s 
						WHERE svh.store_id = s.store_id AND user_id = #{userId}
						ORDER BY store_visit_history_no DESC
					) 
					WHERE rownum <= #{endIndex}
			)
			WHERE rnum >= #{startIndex}
		

SELECT   
user_id, user_pw, user_name, user_birth, user_gender, user_email, 
user_phone, user_address, user_active_state      
FROM(      
SELECT rownum rnum, 
	   user_id, 
	   user_pw, 
	   user_name, 
	   user_birth, 
       user_gender, 
       user_email, 
       user_phone, 
       user_address, 
       user_active_state       
FROM(       
SELECT   user_id, user_pw, user_name, user_birth, 
         user_gender, user_email, user_phone, user_address, user_active_state         
         FROM general_user
         WHERE user_id LIKE 'DAO'              
         ORDER BY user_name      
         )     
         WHERE rownum <= 1    )    
         WHERE rnum >= 3
         
         

         SELECT COUNT(*) 
			FROM(
					SELECT rownum rnum, 
	  					   user_id, 
	  					   user_pw,  
	  					   user_name, 
	  					   user_birth, 
	  					   user_gender, 
	  					   user_email, 
	  					   user_phone, 
	  					   user_address, 
	  					   user_active_state  
					FROM(
						SELECT user_id, 
	  					       user_pw,  
	  					       user_name, 
	  					       user_birth, 
	  					       user_gender, 
	  					       user_email, 
	  					       user_phone, 
	  					       user_address, 
	  					       user_active_state 
						FROM general_user
							WHERE user_id LIKE 'u'
						ORDER BY user_name
					) 
					WHERE rownum <= 1
			)
			WHERE rnum >= 3


			SELECT COUNT(*) 
			FROM(
					SELECT rownum rnum, 
	  					   user_id, 
	  					   user_pw,  
	  					   user_name, 
	  					   user_birth, 
	  					   user_gender, 
	  					   user_email, 
	  					   user_phone, 
	  					   user_address, 
	  					   user_active_state  
					FROM(
						SELECT user_id, 
	  					       user_pw,  
	  					       user_name, 
	  					       user_birth, 
	  					       user_gender, 
	  					       user_email, 
	  					       user_phone, 
	  					       user_address, 
	  					       user_active_state 
						FROM general_user
							
						ORDER BY user_name
					) 
					WHERE rownum <= 1
			)
			WHERE rnum >= 3

			
			
			
			SELECT user_id, user_pw, user_name, user_birth, user_gender, user_email, user_phone, user_address, user_active_state
			FROM(
					SELECT rownum rnum, 
						   user_id, user_pw, user_name, user_birth, user_gender, user_email, user_phone, user_address, user_active_state
					FROM(
						SELECT user_id, user_pw, user_name, user_birth, user_gender, user_email, user_phone, user_address, user_active_state
						FROM general_user
								WHERE user_id LIKE '%u%'
						ORDER BY user_name
					) 
					WHERE rownum <= 1
			)
			WHERE rnum >= 30
			
			
			
			
			
			
			
			
			
			
			
			
SELECT       
notice_board_no,        
notice_board_content,        
notice_board_title,        
notice_board_date,        
notice_board_hits       
FROM(      
	SELECT rownum rnum,                   
			notice_board_no,        
			notice_board_content,        
			notice_board_title,        
			notice_board_date,        
			notice_board_hits        
			FROM(       
				SELECT       
				notice_board_no,        
				notice_board_content,        
				notice_board_title,        
				notice_board_date,        
				notice_board_hits         
				FROM notice_board_contents                
				1 = -1                 
				ORDER BY notice_board_no DESC      )       WHERE rownum <= ?    )    WHERE rnum >= ?

			
		
