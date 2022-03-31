DROP TABLE IF EXISTS orders;

DROP TABLE IF EXISTS users;

DROP TABLE IF EXISTS products;

CREATE TABLE users
(
    id  SERIAL NOT NULL,
    username character varying(255),
    email character varying(255),
    address character varying(255),
    CONSTRAINT users_id_pk PRIMARY KEY (id)
);

CREATE TABLE products
(
    id       SERIAL NOT NULL,
    name     character varying(255),
    quantity numeric,
    price    numeric,
    CONSTRAINT products_id_pk PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id           SERIAL NOT NULL,
    user_name    character varying(255),
    product_name character varying(255),
    quantity     numeric,
    CONSTRAINT orders_id_pk
        PRIMARY KEY (id)
);
INSERT INTO users(username, email, address)
VALUES ('Bob1','bob1@gmail.com','Prime Street 1');
INSERT INTO users(username, email, address)
VALUES ('Tim','tim95@gmail.com','Central Street 10');
INSERT INTO users(username, email, address)
VALUES ('Neil21','neill@gmail.com','Nison Street 5');
INSERT INTO users(username, email, address)
VALUES ('Garr13','gareth3@gmail.com','Forest Street 4');
INSERT INTO users(username, email, address)
VALUES ('Finn','fin145@gmail.com','Free Street 1');
INSERT INTO users(username, email, address)
VALUES ('Betty14','betty14@gmail.com','Elton Street 15');
INSERT INTO users(username, email, address)
VALUES ('BernieA','bernie111@gmail.com','Alcav Street 4');
INSERT INTO users(username, email, address)
VALUES ('Gerr56','gerom33@gmail.com','Oleeh Street 3');
INSERT INTO users(username, email, address)
VALUES ('Helyy3','helly3@gmail.com','Kole Street 1');
INSERT INTO users(username, email, address)
VALUES ('Tom','tom13@gmail.com','Eldom Street 144');
INSERT INTO products(name, quantity, price)
VALUES ('Coke 0.33L', 500, 3);
INSERT INTO products(name, quantity, price)
VALUES ('Water Bottle 1L', 1000, 2);
INSERT INTO products(name, quantity, price)
VALUES ('Canned Ham', 300, 5);
INSERT INTO products(name, quantity, price)
VALUES ('Tomatoes 1KG', 80, 3);
INSERT INTO products(name, quantity, price)
VALUES ('Spaghetti Box', 150, 5);
INSERT INTO products(name, quantity, price)
VALUES ('Logitech Keyboard', 50, 50);
INSERT INTO products(name, quantity, price)
VALUES ('Radio', 30, 25);
INSERT INTO products(name, quantity, price)
VALUES ('JBL Bluetooth Speaker', 70, 40);
INSERT INTO products(name, quantity, price)
VALUES ('Razer PC Mouse', 100, 45);
INSERT INTO products(name, quantity, price)
VALUES ('Samsung Galaxy S20', 200, 350);
INSERT INTO products(name, quantity, price)
VALUES ('Apple iPhone 12 Pro', 250, 600);
INSERT INTO products(name, quantity, price)
VALUES ('Huawei P30', 100, 250);
INSERT INTO products(name, quantity, price)
VALUES ('Razer Headphones', 100, 60);
INSERT INTO products(name, quantity, price)
VALUES ('Monster Energy Drink 0.5L', 300, 7);
INSERT INTO orders(user_name, product_name, quantity)
VALUES ('Betty14','Coke 0.33L',5);
INSERT INTO orders(user_name, product_name, quantity)
VALUES ('Tom','Samsung Galaxy S20',1);
INSERT INTO orders(user_name, product_name, quantity)
VALUES ('Helyy3','Logitech Keyboard',2);
INSERT INTO orders(user_name, product_name, quantity)
VALUES ('Finn','Coke 0.33L',5);
INSERT INTO orders(user_name, product_name, quantity)
VALUES ('Finn','Canned Ham',3);
INSERT INTO orders(user_name, product_name, quantity)
VALUES ('Finn','Razer PC Mouse',1);