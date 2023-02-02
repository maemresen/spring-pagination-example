DROP TABLE IF EXISTS chapter;
DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    id   bigint       NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NULL
);

CREATE TABLE chapter
(
    id      bigint       NOT null primary KEY auto_increment,
    name    VARCHAR(255) NULL,
    `read`  TINYINT(1)   NULL,
    book_id bigint       NULL,
    CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES db.book (id)
);

INSERT INTO book (id, name) VALUES (1, 'Book1');
INSERT INTO book (id, name) VALUES (2, 'Book2');
INSERT INTO book (id, name) VALUES (3, 'Book3');

INSERT INTO chapter (name, `read`, book_id) VALUES ('Book1-Chapter0', 0, 1);
INSERT INTO chapter (name, `read`, book_id) VALUES ('Book2-Chapter0', 0, 2);
INSERT INTO chapter (name, `read`, book_id) VALUES ('Book2-Chapter1', 0, 2);
INSERT INTO chapter (name, `read`, book_id) VALUES ('Book3-Chapter0', 0, 3);
INSERT INTO chapter (name, `read`, book_id) VALUES ('Book3-Chapter1', 0, 3);
INSERT INTO chapter (name, `read`, book_id) VALUES ('Book3-Chapter2', 0, 3);
