DROP TABLE IF EXISTS users;

CREATE SEQUENCE user_seq;

CREATE TABLE users (id INT PRIMARY KEY DEFAULT NEXTVAL ('user_seq'), name VARCHAR, city VARCHAR);

INSERT INTO users (name, city) VALUES ('Jarvis', 'Boston');