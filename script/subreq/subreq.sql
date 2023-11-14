CREATE TABLE req.customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);
CREATE TABLE req.orders(
    id serial primary key,
    amount int,
    customer_id int references req.customers(id)
);

insert into req.customers ( first_name, last_name, age, country  ) values ( 'Иванов', 'Иван', 30, 'Россия' );
insert into req.customers ( first_name, last_name, age, country  ) values ( 'Петров', 'Петр', 40, 'Россия' );

insert into req.orders ( amount, customer_id ) values ( 5000, 1 );
insert into req.orders ( amount, customer_id ) values ( 6000, 1 );

 SELECT *
	from req.customers as cust
	where id  not in ( select customer_id from req.orders where customer_id = cust.id );