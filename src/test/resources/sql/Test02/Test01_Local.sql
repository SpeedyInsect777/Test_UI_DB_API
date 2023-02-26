create database Fleet;

show databases ;

use Fleet;

create table departments
(
    department_id int primary key ,
    employee_id int,
    department_name varchar(20)
);

create table employees
(employee_id int auto_increment primary key ,
first_name varchar(20),
last_name varchar(20),
department varchar(20) );

insert into employees
values (100,'Mike','Tyson','Driver');

insert into employees
values (101,'McCain','John','Mechanic');

select * from employees;

insert into employees
values (102,'Petro','Pilot','TruckStop');

use Fleet;

create table trip_report(
    trip_number int primary key auto_increment,
    trip_start date,
    shipper_city_state varchar(20),
    receiver_city_state varchar(20),
    trip_end date,
    rate long);

select *from trip_report;



