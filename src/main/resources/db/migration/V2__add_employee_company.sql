create table employee_company (
    id bigint primary key,
    employee_id bigint,
    company_id bigint
);
create sequence employee_company_id_seq start with 1 increment by 1 no minvalue no maxvalue cache 1;
