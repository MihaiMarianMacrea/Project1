create table country (
    id bigint primary key,
    name varchar(50)
);

create sequence country_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;

create table city(
    id bigint primary key,
    name varchar (50),
    population bigint,
    country_id bigint
);

create sequence city_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;

create table company (
    id bigint primary key,
    name varchar (50),
    description varchar (1000),
    revenues bigint,
    is_active boolean,
    incorporation_date timestamp,
    city_id bigint
);

create sequence company_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;

create table employee (
    id bigint primary key,
    name varchar (50),
    age int,
    email varchar(50),
    salary int,
    is_active boolean,
    company_id bigint
);

CREATE SEQUENCE employee_id_seq START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
