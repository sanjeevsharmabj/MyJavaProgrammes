DROP DATABASE covidprds;

CREATE DATABASE covidprds;

use covidprds;

CREATE TABLE products(
prodId INT PRIMARY KEY,
prodName VARCHAR(10) NOT NULL,
prodDesc VARCHAR(30) 
price DECIMAL NOT NULL,

);

INSERT  INTO products(prodId,prodName,prodDesc,price)
VALUES
(1,"Face Mask",10.0,"Mask for Face Mask"),
(2,"HandGloves",20.0,"Gloves for Hands"),
(3,"Revital",50.0,"Immunity Booster");