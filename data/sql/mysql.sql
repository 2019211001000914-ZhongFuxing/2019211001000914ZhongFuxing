create database userdb;
create table Usertable
(
username VARCHAR(20) NOT NULL UNIQUE ,
password CHAR(32) NOT NULL,
email  VARCHAR(50) NOT NULL,
age  char(8) NOT NULL,
sex CHAR(32) NOT NULL,)
