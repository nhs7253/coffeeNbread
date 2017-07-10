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
WHERE store_id = 's-1'
AND   trade_date = '2017-07-04'
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

SELECT TRUNC(AVG(reservation_order_count))	/*소수점 버림*/
FROM (SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
			  pd.product_id,
			  p.product_category
	  FROM	payment_details pd, product p
	  WHERE pd.store_id = 's-1'
	  AND	  p.product_category = '빵'
	  AND	  pd.trade_date <= (SELECT TRUNC(SYSDATE) + 1 FROM DUAL)
	  AND	  pd.trade_date >= (SELECT TRUNC(SYSDATE) - 6 FROM DUAL)
	  AND	  pd.product_id = p.product_id
	  GROUP BY pd.product_id, p.product_category
	  ORDER BY pd.product_id ASC)

SELECT ROUND(RATIO_TO_REPORT(TRUNC(AVG(reservation_order_count))) OVER(), 2) reservation_order_count, product_id /*비율계산*/
FROM (SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
			  pd.product_id,
			  p.product_category
	  FROM	payment_details pd, product p
	  WHERE pd.store_id = 's-1'
	  AND	  p.product_category = '빵'
	  AND	  pd.trade_date <= (SELECT TRUNC(SYSDATE) FROM DUAL)
	  AND	  pd.trade_date >= (SELECT MIN(trade_date)FROM payment_details)
	  AND	  pd.product_id = p.product_id
	  GROUP BY pd.product_id, p.product_category
	  ORDER BY pd.product_id ASC)
GROUP BY product_id
ORDER BY product_id
	  
SELECT MIN(trade_date)
FROM payment_details


SELECT ROUND(RATIO_TO_REPORT(TRUNC(AVG(reservation_order_count))) OVER(), 2) reservation_order_count, product_id
FROM (SELECT  SUM(pd.reservation_order_count + pd.product_trade_count) reservation_order_count,
			  pd.product_id,
			  p.product_category
	  FROM	payment_details pd, product p
	  WHERE pd.store_id = 's-1'
	  AND	  p.product_category = '빵'
	  AND	  pd.trade_date <= (SELECT TRUNC(SYSDATE) FROM DUAL)
	  AND	  pd.trade_date >= (SELECT MIN(trade_date)FROM payment_details)
	  AND	  pd.product_id = p.product_id
	  GROUP BY pd.product_id, p.product_category
	  ORDER BY pd.product_id ASC)
GROUP BY product_id
ORDER BY product_id


