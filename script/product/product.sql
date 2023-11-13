create table product.type (
    id serial primary key,
    name text
);
create table product.product (
    id serial primary key,
    name text,
    type_id int references product.type(id),
    expired_date TIMESTAMP,
    price decimal
);


insert into product.type ( name ) values ( 'СЫР' );
insert into product.type ( name ) values ( 'МОЛОКО' );
 insert into product.type ( name ) values ( 'МОРОЖЕНОЕ' )

insert into product.product ( name, type_id, price, expired_date  ) values ( 'Молоко', 2, 100, '2023-11-15 00:00:00' );
insert into product.product ( name,type_id, price, expired_date  ) values ( 'Сыр плавленный', 1, 65, '2023-01-01 00:00:00' );
insert into product.product ( name,type_id, price, expired_date  ) values ( 'Сыр моцарелла', 1, 300, '2023-11-16 00:00:00' );
insert into product.product ( name, type_id, price, expired_date  ) values ( 'наше мороженое', 3, 70, '2024-01-01 00:00:00' );




-- 1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT product.id, product.name, type_id, expired_date, price
	FROM product.product
	INNER join product."type" on "type".id = product.type_id
	where product."type".name = 'СЫР';


-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
SELECT id, name, type_id, expired_date, price
	FROM product.product
	where product.name like '%мороженое%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых уже истек
SELECT id, name, type_id, expired_date, price
	FROM product.product
	where expired_date < NOW();

-- 4. Написать запрос, который выводит самый дорогой продукт.
--  Запрос должен быть универсальный и находить все продукты с максимальной ценой.
SELECT product.id, product.name, type_id, expired_date, price
	FROM product.product
	 order by price DESC LIMIT 1;
-- 4.1 если будет несколько различных продуктов с одинаковой максимальной ценой
SELECT product.id, product.name, type_id, expired_date, price
	FROM product.product
	WHERE price = (SELECT MAX(price) FROM product.product WHERE id = product.product.id);

-- 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
--  В виде имя_типа, количество
SELECT product."type".name, count(product.product.id)
	FROM product."type"
	left join product.product on product.product.type_id = product."type".id
	group by product."type".name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT product.product.id, product.product.name, type_id, expired_date, price
	FROM product.product
	INNER join product."type" on product.product.type_id = product."type".id
	where product."type".name in ( 'СЫР', 'МОЛОКО');

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
-- Под количеством подразумевается количество продуктов определенного типа.
-- Например, если есть тип "СЫР" и продукты "Сыр плавленный" и "Сыр моцарелла", которые ему принадлежат,
--то количество продуктов типа "СЫР" будет 2.
SELECT product."type".name, count(product.product.id) as sum
	FROM product.product
	INNER join product."type" on product.product.type_id = product."type".id
	group by product."type".name
	having count(product.product.id) < 10;

-- 8. Вывести все продукты и их тип.
SELECT product.product.id, product.product.name, product."type".name as type_name,  type_id, expired_date, price
	FROM product.product
	INNER join product."type" on product.product.type_id = product."type".id;