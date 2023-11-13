create table user_1093.roles (
    id serial primary key,
    name text
);
create table user_1093.rules (
    id serial primary key,
    name text
);

create table user_1093.role_rules (
    id serial primary key,
    role_id int references user_1093.roles(id),
    rule_id int references user_1093.rules(id)
);

create table user_1093.users (
    id serial primary key,
    name text,
	role_id int references user_1093.roles(id)
);
create table user_1093.states (
    id serial primary key,
    name text
);
create table user_1093.categories (
    id serial primary key,
    name text
);

create table user_1093.items (
    id serial primary key,
    name text,
	category_id int references user_1093.categories(id),
	state_id int references user_1093.states(id),
    user_id int references user_1093.users(id)
);

create table user_1093.comments (
    id serial primary key,
	item_id int references user_1093.items(id),
    full_text text
);
create table user_1093.attachs (
    id serial primary key,
	item_id int references user_1093.items(id),
    attach text
);
