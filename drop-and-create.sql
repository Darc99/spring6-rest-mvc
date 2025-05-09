drop table if exists beer cascade ;
drop table if exists customer cascade ;
create table beer (beer_style tinyint not null check (beer_style between 0 and 9), price numeric(38,2) not null, quantity_on_hand integer, version integer, created_at timestamp(6), updated_at timestamp(6), id varchar(36) not null, beer_name varchar(50) not null, upc varchar(255) not null, primary key (id));
create table customer (version integer, created_date timestamp(6), modified_date timestamp(6), customer_id varchar(36) not null, customer_name varchar(255), email varchar(255), primary key (customer_id));
