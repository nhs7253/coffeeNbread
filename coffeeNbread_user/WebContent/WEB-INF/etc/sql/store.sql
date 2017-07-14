/* 매장 */
CREATE TABLE store (
	store_id VARCHAR2(30) PRIMARY KEY, /* 매장아이디 */
	store_name VARCHAR2(50) NOT NULL, /* 매장이름 */
	store_intro CLOB, /* 매장소개 */
	store_phone VARCHAR2(50) NOT NULL, /* 전화번호 */
	store_address VARCHAR2(200) NOT NULL, /* 주소 */
	store_email VARCHAR2(50) NOT NULL, /* 이메일 */
	store_category VARCHAR2(200), /* 매장분류 */
	store_hits NUMBER NOT NULL, /* 조회수 */
	store_open DATE NOT NULL, /* 여는 시간 */
	store_close DATE NOT NULL, /* 닫는 시간 */
	store_permission CHAR(1) NOT NULL  /* 매장 허가여부  */
);

alter table payment_details modify user_id  null;
alter table payment_details modify STORE_ID  NOT null;

/* 매장 */
SELECT *FROM STORE
DELETE FROM STORE

INSERT INTO STORE VALUES('s-1','매장1','매장소개글1','010-0000-0000','매장주소1','매장1@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-2','매장2','매장소개글2','010-0000-0000','매장주소2','매장2@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-3','매장3','매장소개글3','010-0000-0000','매장주소3','매장3@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-4','매장4','매장소개글4','010-0000-0000','매장주소4','매장4@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-5','매장5','매장소개글5','010-0000-0000','매장주소5','매장5@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-6','매장6','매장소개글6','010-0000-0000','매장주소6','매장6@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');
INSERT INTO STORE VALUES('s-7','매장7','매장소개글7','010-0000-0000','매장주소7','매장7@email.com',1000,to_date('20160803', 'yyyy-mm-dd'),to_date('20160903', 'yyyy-mm-dd'),'Y');

SELECT  s.store_id,
				s.store_name,
				s.store_intro,
				s.store_phone,
				s.store_address,
				s.store_email,
				s.store_hits,
				s.store_open,
				s.store_close,
				sp.store_picture
		FROM store s,store_picture sp
		WHERE s.store_id = sp.store_id(+)
		AND s.store_id='s-2'





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

			
			SELECT  s.store_id,
				s.store_name,
				s.store_intro,
				s.store_phone,
				s.store_address,
				s.store_email,
				s.store_category,
				s.store_hits,
				s.store_open,
				s.store_close,
				s.store_permission,
				sp.store_picture,
				oc.option_id,
				oc.option_category,
				spo.payment_id,
				po.payment_method
		FROM store s,store_picture sp, option_category oc, store_payment_optionlist spo , payment_optionlist po
		WHERE s.store_id = sp.store_id(+) 
		AND s.store_id = oc.store_id(+)
		AND s.store_id = spo.store_id(+)
		AND spo.payment_id = po.payment_id(+)
		AND s.store_id='wejfio'
		
		
		
		
		
		<id column="product_id" property="productId"/>
 		<result column="store_id" property="storeId"/>
 		<result column="product_name" property="productName"/>
		<result column="product_price" property="productPrice"/>
		<result column="product_category" property="productCategory"/>
		<result column="product_detail" property="productDetail"/>
		<result column="selling_option" property="sellingOption"/>
		<result column="today_product_count" property="todayProductCount"/>
		<result column="recommend_product_count" property="recommendProductCount"/>
		
		
		<resultMap type="com.cnb.vo.ProductPicture" id="productPicture-resultmap">
		<id column="product_picture" property="productPicture"/>
		<result column="product_id" property="productId"/>
		<result column="store_id" property="storeId"/>
	</resultMap>
	 
	SELECT p.product_id,
		   p.store_id,
		   product_name,
		   product_price,
		   product_category,
		   product_detail,
		   selling_option,
		   today_product_count,
		   recommend_product_count,
		   product_picture
	FROM product p, product_picture pp 
	WHERE p.product_id = pp.product_id AND p.store_id = 's-4'
	ORDER BY product_name
	
	
	
	SELECT *
	FROM product p, product_picture pp 
	WHERE p.product_id = pp.product_id AND p.store_id = 's-4'
	ORDER BY product_name