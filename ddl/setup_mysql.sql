/*
 * DDL to create a database called "registration" in a mysql server with a table called "users"
 * @author: Anurag Kapur
 */

/* Create database */
CREATE DATABASE registration;

/* Use database */
USE registration

/* Create table */
CREATE TABLE users
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    firstname   VARCHAR(50),
    surname     VARCHAR(50)
);


