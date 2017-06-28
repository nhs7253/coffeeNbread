/* 제품증감폭 */
CREATE TABLE product_gap(
    identify_code CHAR(1) NOT NULL,
    product_gap VARCHAR2(50) NOT NULL,
    product_id VARCHAR2(30) NOT NULL,
    store_id VARCHAR2(30) NOT NULL,
    PRIMARY KEY(identify_code, product_gap, product_id, store_id)
);

DROP TABLE product_gap;

DELETE FROM product_gap;

SELECT * FROM product_gap;

SELECT * FROM product;