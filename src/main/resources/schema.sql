-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS students_dd;

CREATE TABLE students_dd
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    email      VARCHAR(255) NOT NULL,
    address    VARCHAR(255) NOT NULL,
    phone      CHAR(13)     NOT NULL,
    birth_date DATE         NOT NULL
);