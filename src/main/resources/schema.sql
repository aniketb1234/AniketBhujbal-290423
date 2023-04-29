CREATE TABLE customer (
	customer_Id BIGINT Primary key ,
	first_name varchar(100) not null,
	last_name varchar(100) not null
	
);

create table Customer_Mobile_Numbers(
	id BIGINT Primary key,
	Mobile_Number varchar(100) not null,
	customer_Id varchar(100) not null

);
ALTER TABLE Customer_Mobile_Numbers 
ADD CONSTRAINT fk_customer_id 
FOREIGN KEY (Customer_Id) REFERENCES customer(customer_Id);