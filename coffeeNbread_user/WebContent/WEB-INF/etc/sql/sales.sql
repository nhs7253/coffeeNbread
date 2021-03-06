SELECT  SUM(reservation_order_count + product_trade_count) total,
		product_id		
FROM	payment_details 
WHERE 	store_id = 's-1'
AND   	trade_date = '2016-08-03'
GROUP BY product_id
ORDER BY product_id ASC

/*
 * SYSDATE = 현재 년/월/일 시:분:초
 * TRUNC(SYSDATE) = 현재 년/월/일
 */
SELECT  TRUNC(SYSDATE) FROM DUAL /*오늘*/

SELECT TRUNC(SYSDATE) - 7 FROM DUAL	/*일주일전*/

SELECT TRUNC('2017-01-01') -7 FROM DUAL

SELECT ADD_MONTHS(TRUNC(SYSDATE), -1) FROM DUAL /*1개월전*/

SELECT ADD_MONTHS(TRUNC(SYSDATE), -3) FROM DUAL /*3개월전*/

SELECT ADD_MONTHS(TRUNC(SYSDATE), -6) FROM DUAL /*6개월전*/

SELECT ADD_MONTHS(TRUNC(SYSDATE), -12) FROM DUAL /*12개월전*/

SELECT  SUM(reservation_order_count + product_trade_count) reservation_order_count,
		product_id			
FROM	payment_details 
WHERE store_id = 's-100'
AND   trade_date = '2017-07-10'
GROUP BY product_id
ORDER BY product_id ASC

SELECT  SUM(reservation_order_count + product_trade_count) reservation_order_count,
		product_id
FROM	payment_details
WHERE store_id = 's-1'
AND	  trade_date <= TRUNC(SYSDATE)
AND	  trade_date >= (SELECT ADD_MONTHS(TRUNC(SYSDATE), -12) FROM DUAL)
GROUP BY product_id
ORDER BY product_id asc

SELECT * FROM payment_details


SELECT  SUM(reservation_order_count + product_trade_count) reservation_order_count,
		product_id
FROM	payment_details 
WHERE store_id = 's-1'
AND	  trade_date <= '2016-08-04'
AND	  trade_date >= '2016-08-02'
GROUP BY product_id
ORDER BY product_id ASC	


SELECT  SUM(reservation_order_count + product_trade_count) reservation_order_count,
		product_id
FROM	payment_details 
WHERE store_id = 's-1'
AND	  product_id = 'p-1'
AND	  sell_method = 'r'
GROUP BY product_id
ORDER BY product_id ASC	


SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
		pd.product_id,
		p.product_category
FROM	payment_details pd, product p
WHERE pd.store_id = 's-1'
AND	  p.product_category = '빵'
AND	  pd.product_id = p.product_id
GROUP BY pd.product_id, p.product_category
ORDER BY pd.product_id ASC

SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
		pd.product_id,
		p.product_name
FROM	payment_details pd, product p
WHERE pd.store_id = 's-1'
AND	  p.product_name = '제품1'
AND	  pd.product_id = p.product_id
GROUP BY pd.product_id, p.product_name
ORDER BY pd.product_id ASC	

SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
		pd.product_id,
		p.product_category
FROM	payment_details pd, product p
WHERE pd.store_id = 's-1'
AND	  p.product_category = '빵'
AND	  pd.trade_date = TRUNC(SYSDATE)
AND	  pd.product_id = p.product_id
GROUP BY pd.product_id, p.product_category
ORDER BY pd.product_id ASC	

SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
		pd.product_id,
		p.product_name
FROM	payment_details pd, product p
WHERE pd.store_id = 's-1'
AND	  p.product_name = '제품2'
AND	  pd.trade_date = TRUNC(SYSDATE)
AND	  pd.product_id = p.product_id
GROUP BY pd.product_id, p.product_name
ORDER BY pd.product_id ASC	

SELECT TO_CHAR(SYSDATE, 'DY') FROM DUAL	/*오늘 요일*/

SELECT TO_CHAR( TO_DATE('20170703','YYYYMMDD'), 'DY' ) FROM DUAL /*특정 날짜의 요일*/

SELECT TRUNC(AVG(reservation_order_count)), product_id	/*소수점 버림*/
FROM (SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
			  pd.product_id,
			  p.product_category
	  FROM	payment_details pd, product p
	  WHERE pd.store_id = 's-100'
	  AND	  pd.trade_date <= (SELECT TRUNC(SYSDATE) -1  FROM DUAL)
	  AND	  pd.trade_date >= (SELECT TRUNC(SYSDATE) - 6 FROM DUAL)
	  AND	  pd.product_id = p.product_id
	  GROUP BY pd.product_id, p.product_category
	  ORDER BY pd.product_id ASC)
GROUP BY product_id
ORDER BY product_id

SELECT ROUND(RATIO_TO_REPORT(TRUNC(AVG(reservation_order_count))) OVER(), 2) reservation_order_count, product_id /*비율계산*/
FROM (SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
			  pd.product_id,
			  p.product_category
	  FROM	payment_details pd, product p
	  WHERE pd.store_id = 's-100'
	  AND	  pd.trade_date <= (SELECT TRUNC(SYSDATE) -1 FROM DUAL)
	  AND	  pd.trade_date >= (SELECT MIN(trade_date)FROM payment_details)
	  AND	  pd.product_id = p.product_id
	  GROUP BY pd.product_id, p.product_category
	  ORDER BY pd.product_id ASC)
GROUP BY product_id
ORDER BY product_id
	  
SELECT ROUND(RATIO_TO_REPORT(TRUNC(AVG(reservation_order_count))) OVER(), 2) reservation_order_count, product_id
				FROM (SELECT SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
			 				 pd.product_id,
			 				 p.product_category
	 				  FROM	payment_details pd, product p
	  				  WHERE pd.store_id = 's-100'
					  AND	  pd.trade_date <= (SELECT TRUNC(SYSDATE) -1 FROM DUAL)
					  AND	  pd.trade_date >= (SELECT TRUNC(SYSDATE) - 6 FROM DUAL)
					  AND	  pd.product_id = p.product_id
	 				  GROUP BY pd.product_id, p.product_category
	 				  ORDER BY pd.product_id ASC)
	 			GROUP BY product_id
	 			ORDER BY product_id

SELECT MIN(trade_date)
FROM payment_details

		DELETE FROM reservation_details
		WHERE  store_id = 's-1'
		AND	   reservation_no = 1

		SELECT reservation_time
		FROM	reservation_details
		WHERE store_id = 's-1'
		AND	  reservation_no = 2


		SELECT 	reservation_time,
			    reservation_confirm,
			    product_hope_time,
			    user_id
		FROM (
			SELECT  rownum reservation_no,
					reservation_time,
					reservation_confirm,
					product_hope_time,
					user_id
			FROM(
					SELECT  rownum rnum,
							reservation_time,
							reservation_confirm,
							product_hope_time,
							user_id
					FROM(
							SELECT  r.reservation_time,
									r.reservation_confirm,
									r.product_hope_time,
									u.user_id,
									u.user_name,
									u.user_email,
									u.user_phone
							FROM	reservation_details r, general_user u
							WHERE 	r.store_id = 's-1'
							AND		r.user_id = u.user_id
							GROUP BY r.reservation_time,
									r.reservation_confirm,
									r.product_hope_time,
									u.user_id,
									u.user_name,
									u.user_email,
									u.user_phone
							ORDER BY r.reservation_time ASC
					) 
			)
			)
		WHERE reservation_no = 3
		
		SELECT SUM(reservation_order_count + product_trade_count) reservation_order_count, product_id
		FROM payment_details
		WHERE store_id = 's-1'
		AND trade_date = '2017-07-15'
		AND product_id = 'p-1'
		GROUP BY product_id
		ORDER BY product_id ASC		

		
		
		SELECT SUM(reservation_order_count + product_trade_count) reservation_order_count
		FROM payment_details
		WHERE store_id = 's-1'
		AND trade_date = '2017-07-15'
		AND product_id = 'p-1'
		
		SELECT COUNT(product_id)
				FROM product
				WHERE product_category LIKE '빵'
				AND	  store_id = 's-1'
				
				

				SELECT  SUM(reservation_order_count + product_trade_count) reservation_order_count,
						product_id
				FROM	payment_details 
				WHERE store_id = 's1'
				AND	  trade_date <= (SELECT TRUNC(SYSDATE) + 1 FROM DUAL)
				AND	  trade_date >= (SELECT ADD_MONTHS(TRUNC(SYSDATE), -1) FROM DUAL)
				GROUP BY product_id
				ORDER BY product_id ASC		
				
				
				SELECT  reservation_no,
						reservation_time,
						reservation_count,
						reservation_confirm,
						product_hope_time,
						product_id,
						store_id,
						user_id
				FROM	reservation_details
				WHERE	store_id = 's1'
				AND 	to_char(reservation_time, 'yyyy-MM-dd HH:mi')  = '2017-07-18 11:09'
				AND 	user_id = 'u-2'
				
				
				
				SELECT to_char('2017-07-18 20:42:11', 'yyyy-MM-dd HH24:mi')
				FROM	reservation_details
				
				
				SELECT  reservation_no,
						reservation_time,
						reservation_count,
						reservation_confirm,
						product_hope_time,
						product_id,
						store_id,
						user_id
				FROM	reservation_details
				WHERE	store_id = 's1'
				AND 	to_char(reservation_time, 'yyyy-MM-dd HH24:mi') = '2017-07-18 20:42'
				AND 	user_id = 'u-1'
				
				("s1", "2017-07-18 20:42", "u-1"));

				
				
				
		SELECT recipe_board_no,
		recipe_board_content,
		recipe_board_title,
		recipe_board_date,
		recipe_board_hits,
		recipe_board_picture,
		recommend_count,
		user_id,
		store_id,
		store_name
		FROM(
		SELECT rownum rnum,
		recipe_board_no,
		recipe_board_content,
		recipe_board_title,
		recipe_board_date,
		recipe_board_hits,
		recipe_board_picture,
		recommend_count,
		user_id,
		store_id,
		store_name
		FROM(
		select rbc.recipe_board_no,
		rbc.recipe_board_content,
		rbc.recipe_board_title,
		rbc.recipe_board_date,
		rbc.recipe_board_hits,
		rbc.recipe_board_picture,
		rbc.recommend_count,
		rbc.user_id,
		s.store_id,
		s.store_name
		FROM recipe_board_contents rbc, store s
		WHERE rbc.store_id=s.store_id(+)))
