
insert into user_1093.rules (name) values ( 'create');
insert into user_1093.rules (name) values ( 'delete');
insert into user_1093.rules (name) values ( 'update');


insert into user_1093.roles (name) values ( 'admin');
insert into user_1093.roles (name) values ( 'user');

insert into user_1093.role_rules (role_id, rule_id) values ( 1, 1 );
insert into user_1093.role_rules (role_id, rule_id) values ( 1, 2 );
insert into user_1093.role_rules (role_id, rule_id) values ( 1, 3 );
insert into user_1093.role_rules (role_id, rule_id) values ( 2, 1 );

insert into user_1093.users ( name, role_id) values ( 'test_user', 1 );


insert into user_1093.states ( name) values ( 'создано' );
insert into user_1093.states ( name ) values ( 'в работе' );
insert into user_1093.states ( name ) values ( 'исполнено' );

insert into user_1093.categories ( name ) values ( 'поддержка' );
insert into user_1093.categories ( name ) values ( 'исправление багов' );

insert into user_1093.items ( name, category_id, state_id, user_id  ) values ( 'тестовая заявка', 1,1,1 );
insert into user_1093.comments ( item_id, full_text ) values ( 1, 'тестовая заявка' );
