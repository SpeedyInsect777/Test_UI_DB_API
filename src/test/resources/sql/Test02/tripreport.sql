create database MyFleet;
use MyFleet;
create table trip_report
(
    trip_number         int primary key auto_increment,
    trip_start          date,
    shipper_city_state  varchar(20),
    receiver_city_state varchar(20),
    trip_end            date,
    rate                long
);
select *
from trip_report;
use MyFleet;
insert into trip_report
(trip_number, trip_start, shipper_city_state, receiver_city_state, trip_end, rate)
values (100, '2023-02-26', 'Chicago, IL', 'Columbus,OH', '2023-02-27', 1000);
select *
from trip_report;
update trip_report
set trip_number =101
where trip_number = 100;

select *
from trip_report;

insert into trip_report
(trip_number, trip_start, shipper_city_state, receiver_city_state, trip_end, rate)
values (102, '2023-02-20', 'Columbus, OH', 'Alsip, IL', '2023-02-21', 950);

alter table trip_report
    modify column rate decimal;

update trip_report
set rate = 1000.65
where rate = 1000.065;

alter table trip_report
    modify column rate decimal(8, 2);

select *
from trip_report;

alter table trip_report
    add column employees_id integer unsigned not null;

alter table trip_report
    add primary key (employees_id);

SELECT column_name
FROM information_schema.key_column_usage
WHERE constraint_name = 'PRIMARY'
  AND table_name = 'trip_report';

use MyFleet;

create table employees
(
    name          varchar(20),
    lastname      varchar(20),
    employees_id  integer not null,
    department_id integer not null primary key
);

update employees
set employees_id = (select employees_id from trip_report where employees_id);

select employees_id
from trip_report;

select *
from employees;

insert into employees (name, lastname, employees_id, department_id)
values ('Mike','Tyson',100,101);

select *
from employees;

alter table employees add column employeess_id integer default 0;

alter table employees drop column employees_id;

alter table employees drop column employeess_id;

update employees set department_id = 100 where department_id=101;

insert into employees (department_id) select employees_id from trip_report;

select *from employees;
select *from trip_report;

alter table trip_report drop column employees_id;

update trip_report set employee_id = 200 where shipper_city_state like 'Columbus%';

update trip_report set employee_id =201 where shipper_city_state like '%IL%';

SELECT column_name
FROM information_schema.key_column_usage
WHERE constraint_name = 'PRIMARY'
  AND table_name = 'trip_report';

alter table trip_report
    add primary key (employee_id)