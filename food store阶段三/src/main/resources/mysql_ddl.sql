drop DATABASE food_store;

create database food_store;

use food_store;

create TABLE food (
    id INT NOT NULL AUTO_INCREMENT,
    name CHAR(50) NOT NULL,
    cost DECIMAL(12,4) NOT NULL,
    src CHAR(150) NOT NULL,
    bargain BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);

insert into food(name, cost, src, bargain) values("Staple1", 10.0, "/images/staple-1.png", false);
insert into food(name, cost, src, bargain) values("Staple2", 12.0, "/images/staple-2.png", true);
insert into food(name, cost, src, bargain) values("Staple3", 12.5, "/images/drink-2.png", false);
insert into food(name, cost, src, bargain) values("Staple4", 14.0, "/images/staple-2.png", true);
insert into food(name, cost, src, bargain) values("Staple5", 25.0, "/images/set-1.png", true);

create TABLE user (
    id INT NOT NULL AUTO_INCREMENT,
    username CHAR(30) NOT NULL,
    password CHAR(30) NOT NULL,
    vip BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id)
);
insert into user(username, password, vip) values("admin", "321", true );

insert into user(username, password, vip) values("person", "123", FALSE );

insert into user(username, password, vip) values("god", "456", TRUE );

create TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    userId INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (userId) REFERENCES user(id)
);

insert into orders(userId) values(1);

create TABLE orderLine (
    foodId INT NOT NULL,
    amount INT NOT NULL,
    orderId INT NOT NULL,
    isCheaper BOOLEAN DEFAULT FALSE ,
    PRIMARY KEY (orderId, foodId),
    FOREIGN KEY (orderId) REFERENCES orders(id),
    FOREIGN KEY (foodId) REFERENCES food(id)
);

insert into orderLine(foodId, amount, orderId) values(1, 1, 1, FALSE );

insert into orderLine(foodId, amount, orderId) values(2, 2, 1, TRUE );

CREATE TABLE roles (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    role varchar(100) DEFAULT NULL,
    PRIMARY KEY (id)
);

insert into roles(role) values("customer" );

CREATE TABLE users_roles (
    user_id bigint(20) NOT NULL DEFAULT '0',
    role_id bigint(20) NOT NULL DEFAULT '0',
    PRIMARY KEY (user_id,role_id)
);

insert into users_roles(user_id, role_id) values(1, 1);
insert into users_roles(user_id, role_id) values(2, 1);
insert into users_roles(user_id, role_id) values(3, 1);

