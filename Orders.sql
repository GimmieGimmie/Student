CREATE DATABASE db1;
USE db1;

CREATE TABLE Product(

productID INT primary key,
price INT NOT NULL,
productName VARCHAR (30) NOT NULL

);

CREATE TABLE Customer(

customerID INT primary key,
customerName VARCHAR (30) NOT NULL,
email VARCHAR (30) NOT NULL

);

CREATE TABLE Orders(
orderID INT primary key,
orderName VARCHAR (30) NOT NULL,
orderedDate DATE NOT NULL,
productID_FK INT,
customerID_FK INT,
FOREIGN KEY (productID_FK) REFERENCES Product(productID),
FOREIGN KEY(customerID_FK) REFERENCES Customer(customerID)
);

select * from Orders;