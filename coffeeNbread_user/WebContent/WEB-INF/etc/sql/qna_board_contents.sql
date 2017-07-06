/* QNA게시글 */
CREATE TABLE qna_board_contents (
	qna_board_no NUMBER PRIMARY KEY, /* 문의글번호 */
	qna_store_id VARCHAR2(30),  /* 매장 아이디 */
	qna_board_writer VARCHAR2(30) NOT NULL, /* 문의글작성자 */
	qna_board_title VARCHAR2(300) NOT NULL, /* 문의제목 */
	qna_board_content CLOB NOT NULL, /* 문의내용 */
	qna_board_date DATE NOT NULL, /* 문의작성일지 */
	qna_board_hits NUMBER(6) NOT NULL, /* 문의조회수 */
	qna_board_secret CHAR(1) NOT NULL /* 비밀글 */
	
);
CREATE SEQUENCE qna_board_no_seq;


INSERT INTO qna_board_contents VALUES(1, 's-1', 'u-1', '제목1', '내용1', '2017-01-01', '1', 'N');
INSERT INTO qna_board_contents VALUES(2, 's-1', 'u-1', '제목2', '내용3', '2017-02-02', '2', 'Y');
INSERT INTO qna_board_contents VALUES(3, NULL, 'u-1', '제목3', '내용3', '2017-03-03', '3', 'N');
INSERT INTO qna_board_contents VALUES(4, NULL, 'u-1', '제목4', '내용4', '2017-04-04', '4', 'Y');
SELECT * FROM qna_board_contents;


DELETE FROM qna_board_contents;

WHERE qna_board_title LIKE '%'||#{keyword}||'%' AND qnaStoreId IS NULL AND qnaBoardSecret = 'N'

         SELECT qna_board_no,
				qna_store_id,
				qna_board_writer,
				qna_board_title,
				qna_board_content,
				qna_board_date,
			    qna_board_hits,
				qna_board_secret  
			FROM(
					SELECT rownum rnum, 
	  					   qna_board_no,
						   qna_store_id,
						   qna_board_writer,
					       qna_board_title,
						   qna_board_content,
						   qna_board_date,
						   qna_board_hits,
						   qna_board_secret  
					FROM(
						SELECT qna_board_no,
							   qna_store_id,
							   qna_board_writer,
					           qna_board_title,
							   qna_board_content,
							   qna_board_date,
							   qna_board_hits,
							   qna_board_secret
						FROM qna_board_contents
						WHERE (qna_board_title LIKE '%'||'제목'||'%') OR (qna_board_content LIKE '%'||'제목'||'%') AND qna_store_id = 'qna-s-1'
						ORDER BY qna_board_no
					) 
					WHERE rownum <= 3
			)
			WHERE rnum >= 1
