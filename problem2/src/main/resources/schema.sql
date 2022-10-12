CREATE DATABASE rental_system;

use rental_system;

CREATE TABLE video (
    serial_number varchar(20) PRIMARY KEY,
    name varchar(255),
    price int
);

CREATE TABLE book_on_tape (
    serial_number varchar(20) PRIMARY KEY,
    name varchar(255),
    price int
);

CREATE TABLE furniture (
    serial_number varchar(20) PRIMARY KEY,
    name varchar(255),
    price int
);