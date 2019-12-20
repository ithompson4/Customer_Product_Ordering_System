create database productsormDB;
use productsormDB;

create table supplier(
	supplierid integer primary key AUTO_INCREMENT,
	companyname varchar(80),
	country varchar(80)
);

create table product(
	productid integer primary key AUTO_INCREMENT,
	productname varchar(80),
	productcategory varchar(80)
);

create table employee(
	employeeid integer primary key AUTO_INCREMENT,
	employeelastname varchar(80),
	mgrlastname varchar(80)
);

create table customer(
	customerid integer primary key AUTO_INCREMENT,
	companyname varchar(80),
	city varchar(80),
	country varchar(80)
);

create table ttime(
	timeid integer primary key AUTO_INCREMENT,
	tdate timestamp
);


create table orders_fact(
	productid integer,
	customerid integer,
	employeeid integer,
	timeid integer,
	supplierid integer,
	price decimal(8,2),
	quantity integer,
	PRIMARY KEY (productid,	customerid,	employeeid,	supplierid),

	CONSTRAINT fk_11 FOREIGN KEY (productid) REFERENCES product(productid),
	CONSTRAINT fk_21 FOREIGN KEY (customerid) REFERENCES customer(customerid),
	CONSTRAINT fk_31 FOREIGN KEY (employeeid) REFERENCES employee(employeeid),
	CONSTRAINT fk_41 FOREIGN KEY (timeid) REFERENCES ttime(timeid),
	CONSTRAINT fk_51 FOREIGN KEY (supplierid) REFERENCES supplier(supplierid)
);