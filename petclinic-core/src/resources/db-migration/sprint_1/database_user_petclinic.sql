--liquibase formatted sql

--changeset tricarico:1

CREATE DATABASE IF NOT EXISTS petclinic CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER IF NOT EXISTS 'petclinic'@'%' IDENTIFIED BY 'petclinic';
GRANT SELECT, INSERT, UPDATE, DELETE ON petclinic.* to 'petclinic'@'%';
