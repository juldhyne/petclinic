--liquibase formatted sql

--changeset juliend:5

USE petclinic;

CREATE TABLE IF NOT EXISTS visits (
    id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id INT(4) UNSIGNED NOT NULL,
    date VARCHAR(30),
    description VARCHAR(30),
    FOREIGN KEY(pet_id) REFERENCES pets(id)
) engine=InnoDB;