/* 매장 좌표 */
CREATE TABLE store_position (
	store_id VARCHAR2(30) PRIMARY KEY, /* 매장아이디 */
	X VARCHAR2(50) NOT NULL, /* X좌표 */
	Y VARCHAR2(50) NOT NULL, /* Y좌표 */
	FOREIGN KEY(store_id) REFERENCES store(store_id) ON DELETE CASCADE
);

DROP TABLE store_position


SELECT * FROM store_position;

INSERT INTO store_position VALUES('s-1', '213123', '3242343');


DELETE FROM store_position WHERE store_id = 's-1'


SELECT * 
FROM store_position
WHERE store_id = '1';

UPDATE store_position 
SET X = '000000', Y = '000000000'
WHERE store_id = 's-1';

SELECT s.store_id, X, Y, store_name, store_intro, store_phone, store_address, store_email, store_hits, store_open, store_close, store_permission
FROM store_position sp, store s
WHERE sp.store_id = s.store_id AND sp.store_id = 's-1'

