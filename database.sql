CREATE DATABASE quadra_solidaria;

USE quadra_solidaria;

CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO usuarios(username, password)
VALUES ('admin', '123456');