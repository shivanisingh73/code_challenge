Part 1:

SELECT *
FROM authors
ORDER BY date_of_birth
LIMIT 10;

SELECT SUM(sale_items.item_price * sale_items.quantity) AS total_sales
FROM authors
JOIN books ON authors.id = books.author_id
JOIN sale_items ON books.id = sale_items.book_id
WHERE authors.name = 'Lorelai Gilmore';

SELECT authors.name, SUM(sale_items.item_price * sale_items.quantity) AS total_revenue
FROM authors
JOIN books ON authors.id = books.author_id
JOIN sale_items ON books.id = sale_items.book_id
GROUP BY authors.name
ORDER BY total_revenue DESC
LIMIT 10;

