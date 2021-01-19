CREATE DATABASE QUERYDB;

CREATE TABLE query_form (
        ID INT NOT NULL AUTO_INCREMENT,
        EMAIL VARCHAR(255) NOT NULL,
        TOPIC VARCHAR(60) NOT NULL,
        MESSAGE VARCHAR(2000) NOT NULL,
        CREATED_TIMESTAMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        PRIMARY KEY (ID)
);

CREATE USER 'user' IDENTIFIED BY 'password';

GRANT INSERT,SELECT ON query_form TO 'user';

GRANT UPDATE,SELECT ON hibernate_sequence TO 'user';

