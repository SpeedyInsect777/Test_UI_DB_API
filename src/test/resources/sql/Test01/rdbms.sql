select *from employees;

create table test_table (test_id int, first_name varchar(15),last_name varchar(15));

insert into test_table (test_id ) values (101);

update test_table set first_name='Rick', last_name = 'Martin' where test_id=101;

insert into test_table (FIRST_NAME) values ('Mike');

insert into test_table (LAST_NAME) values ('Tyson');

select * from test_table;

insert into test_table(test_id, first_name, last_name) VALUES (103,'Bob','Fridman');

select * from test_table;

select first_name from test_table;

-- update test_table set first_name = 'Johny', last_name = 'Barbaros' where


