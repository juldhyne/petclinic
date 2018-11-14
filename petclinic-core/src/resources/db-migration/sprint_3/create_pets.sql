--liquibase formatted sql

--changeset juliend:3

USE petclinic;

CREATE TABLE IF NOT EXISTS pets (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birthdate VARCHAR(30),
    owner_id INT(4) UNSIGNED NOT NULL,
    type VARCHAR(30),
    FOREIGN KEY(owner_id) REFERENCES owners(id)
) engine=InnoDB;