/* 공지사항 게시글 */
CREATE TABLE notice_board_contents (
	notice_board_no NUMBER PRIMARY KEY, /* 공지글번호 */
	notice_board_content CLOB NOT NULL, /* 공지내용 */
	notice_board_title VARCHAR2(300) NOT NULL, /* 공지제목 */
	notice_board_date DATE NOT NULL, /* 공지작성일시 */
	notice_board_hits NUMBER(6) NOT NULL /* 공지조회수 */
);
CREATE SEQUENCE notice_board_no_seq;

DROP TABLE notice_board_contents;

SELECT * FROM notice_board_contents;

INSERT INTO notice_board_contents VALUES (
											0,
											'안녕하세요',
											'안녕',
											TO_DATE('2017/06/27'),
											1 )