CREATE SCHEMA IF NOT EXISTS food;
set search_path to food;

CREATE TABLE IF NOT EXISTS cuisine(
    cuisine VARCHAR(127) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS country(
    country VARCHAR(127) NOT NULL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS city(
    id SERIAL PRIMARY KEY,
    city VARCHAR(127) NOT NULL,
    country VARCHAR(127) NOT NULL REFERENCES country(country) ON UPDATE CASCADE ON DELETE CASCADE,
    UNIQUE(city, country)
);

CREATE TABLE IF NOT EXISTS restaurant(
    id SERIAL PRIMARY KEY,
    name VARCHAR(127) NOT NULL,
    address VARCHAR(127) NOT NULL,
    city_id SERIAL NOT NULL REFERENCES city(id) ON UPDATE CASCADE ON DELETE CASCADE,
    average_users_rating REAL,
    phone_numbers VARCHAR(127)
);

CREATE TABLE IF NOT EXISTS restaurant_cuisine(
    restaurant_id SERIAL NOT NULL REFERENCES restaurant(id) ON UPDATE CASCADE ON DELETE CASCADE,
    cuisine VARCHAR(127) NOT NULL REFERENCES cuisine(cuisine) ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (restaurant_id, cuisine)
);

CREATE TABLE IF NOT EXISTS dish(
    id SERIAL PRIMARY KEY,
    dish VARCHAR(127) NOT NULL,
    price REAL NOT NULL
);

CREATE TABLE IF NOT EXISTS mark_food
(
    id                    SERIAL PRIMARY KEY,
    restaurant_id         INTEGER not null references restaurant(id) ON UPDATE CASCADE ON DELETE CASCADE,
    mark                  DECIMAL not null
);

ALTER TABLE mark_food
    ALTER COLUMN mark TYPE FLOAT USING (mark::float);

