--liquibase formatted sql

--changeset juliend:1

USE petclinic;

CREATE TABLE IF NOT EXISTS owners (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    city VARCHAR(30),
    address VARCHAR(55),
    telephone VARCHAR(30)
) engine=InnoDB;