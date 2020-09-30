DROP DATABASE coronaKitDB;

CREATE DATABASE coronaKitDB;

use coronaKitDB;

CREATE TABLE products(
pid INT PRIMARY KEY,
pname VARCHAR(30) NOT NULL,
pcost DECIMAL NOT NULL,
pdesc VARCHAR(100)
);

INSERT  INTO products(pid,pname,pcost,pdesc)
VALUES
(1,"Face Mask",10.0,"Protective Face Mask"),
(2,"Sanitizers",20.0,"Protective Sanitizers"),
(3,"Medicine",50.0,"Immunity Booster Medicine"),
(4,"Hand Gloves",35.0,"Hand Gloves"),
(5,"Head Caps",25.0,"Protective Head Caps");