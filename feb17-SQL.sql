create table product (product_id INT primary key ,
					   product_name VARCHAR(15),
					   product_desc VARCHAR (25),
 					   price NUMERIC(7,2);
 
INSERT INTO product (product_name, product_desc, price , product_category)
VALUES ('Monitor', 'Best monitor ', 1250.99 , 'Electronics'),
('Keyboard', 'Best keyboard ', 350.99 , 'Electronics'),
		('Paper', 'Best paper ', 125.99 , 'Books and Stationaries')
  

ALTER TABLE product ALTER COLUMN product_desc TYPE VARCHAR(100);

SELECT * FROM product;
UPDATE product
SET price = 10000
WHERE product_id = 12;

write a query to fetch count of product in each category

Select product_category , count(*) as number_of_products from product 
group by product_category
having count(*) > 2;

sort based on count in ascending

SELECT product_category , COUNT(*) as number_of_products FROM product 
GROUP BY product_category
HAVING COUNT(*) > 2
ORDER BY number_of_products;

--write a query to fetch product having second highest price
SELECT * 
FROM product 
WHERE price =  ( SELECT  MAX(price)  
				  FROM product
				  WHERE price < (SELECT MAX(price) FROM product));

UPDATE price of all electronics items so that the new price is 10% less than the original price
UPDATE product SET price = price - (price * 1/10)
WHERE product_category = 'Electronics';

delete the products whose price is less than the average price of all the products

DELETE FROM  product where price < ( SELECT AVG(PRICE) FROM product);

delete the products category wise whose price is less than average price in that specufuc category

DELETE FROM product p1
WHERE p1.price < (SELECT AVG(price)
				FROM product p2
				WHERE p1.product_category = p2.product_category);

select avg(price) , product_category
				from product group by product_category;

CREATE TABLE orders ( o_id SERIAL PRIMARY KEY, order_date DATE,
    order_type VARCHAR(25),
    product_id INTEGER REFERENCES product(product_id) ON DELETE CASCADE
);
select * from orders ;
INSERT INTO orders (order_date, order_type, product_id)
VALUES
    ('2026-02-17', 'New', 5),
    ('2026-02-18', 'Repeat', 10),
    ('2026-02-19', 'New', 15),
    ('2026-02-20', 'Repeat', 5),
    ('2026-02-21', 'New', 10);

select * from orders;

SELECT *
FROM product
	WHERE product_id = (SELECT product_id 
	FROM orders 
	GROUP BY product_id 
	ORDER BY COUNT(*) DESC
	LIMIT 1);

DELETE FROM product where product_id = 5;

