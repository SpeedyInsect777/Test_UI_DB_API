use Fleet;

create table trip_report(
                            trip_number int primary key auto_increment,
                            trip_start date,
                            shipper_city_state varchar(20),
                            receiver_city_state varchar(20),
                            trip_end date,
                            rate long);

select *from trip_report;

use Fleet;



