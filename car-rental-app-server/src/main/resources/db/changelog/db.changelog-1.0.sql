--liquibase formatted sql

--changeset soroka andrei:1
CREATE TABLE IF NOT EXISTS roles
(
    id     INTEGER PRIMARY KEY,
    "type" VARCHAR(32) UNIQUE NOT NULL
);
-- rollback DROP TABLE roles

--changeset soroka andrei:2
CREATE TABLE IF NOT EXISTS users
(
    id              BIGINT PRIMARY KEY,
    username        VARCHAR(64) UNIQUE  NOT NULL,
    "password"      VARCHAR(128)        NOT NULL,
    email           VARCHAR(128) UNIQUE NOT NULL,
    firstname       VARCHAR(64)         NOT NULL,
    lastname        VARCHAR(64)         NOT NULL,
    phone           VARCHAR(64)         NOT NULL,
    birth_date      DATE                NOT NULL,
    driving_license VARCHAR(64)         NOT NULL
);
--rollback DROP TABLE users

--changeset soroka andrei:3
CREATE TABLE IF NOT EXISTS user_role
(
    role_id INTEGER NOT NULL REFERENCES roles (id) ON DELETE CASCADE,
    user_id BIGINT  NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    PRIMARY KEY (role_id, user_id)
);
--rollback DROP TABLE user_role

--changeset soroka andrei:4
CREATE TABLE IF NOT EXISTS brand
(
    id     INTEGER PRIMARY KEY,
    "name" VARCHAR(64) UNIQUE NOT NULL
);
--rollback DROP TABLE brand

--changeset soroka andrei:5
CREATE TABLE IF NOT EXISTS equipment
(
    id             INTEGER PRIMARY KEY,
    equipment_code CHAR(3) UNIQUE NOT NULL,
    description    VARCHAR(128)   NOT NULL
);
--rollback DROP TABLE equipment

--changeset soroka andrei:6
CREATE TABLE IF NOT EXISTS car_status
(
    id          INTEGER PRIMARY KEY,
    status_code CHAR(3) UNIQUE NOT NULL,
    description VARCHAR(128)   NOT NULL
);
--rollback DROP TABLE car_status

--changeset soroka andrei:7
CREATE TABLE IF NOT EXISTS order_status
(
    id          INTEGER PRIMARY KEY,
    status_code CHAR(3) UNIQUE NOT NULL,
    description VARCHAR(128)   NOT NULL
);
--rollback DROP TABLE order_status

--changeset soroka andrei:8
CREATE TABLE IF NOT EXISTS "location"
(
    id      INTEGER PRIMARY KEY,
    country VARCHAR(64)  NOT NULL,
    city    VARCHAR(64)  NOT NULL,
    address VARCHAR(128) NOT NULL,
    email   VARCHAR(64)  NOT NULL,
    phone   VARCHAR(32)  NOT NULL
);
--rollback DROP TABLE location

--changeset soroka andrei:9
CREATE TABLE IF NOT EXISTS car
(
    id              INTEGER PRIMARY KEY,
    registration_no VARCHAR(32) UNIQUE NOT NULL,
    brand_id        INTEGER REFERENCES brand (id),
    model           VARCHAR(64)        NOT NULL,
    daily_fee       DECIMAL(6, 2)      NOT NULL,
    location_id     INTEGER REFERENCES "location" (id),
    status_id       INTEGER REFERENCES car_status (id),
    best_offer      BOOLEAN            NOT NULL
);
--rollback DROP TABLE car

--changeset soroka andrei:10
CREATE TABLE IF NOT EXISTS car_equipment
(
    id           BIGINT PRIMARY KEY,
    car_id       INTEGER NOT NULL REFERENCES car (id) ON DELETE CASCADE,
    equipment_id INTEGER NOT NULL REFERENCES equipment (id) ON DELETE CASCADE
);
--rollback DROP TABLE car_equipment

--changeset soroka andrei:11
CREATE TABLE IF NOT EXISTS car_parameter
(
    car_id          INTEGER PRIMARY KEY REFERENCES car (id) ON DELETE CASCADE,
    body_type       VARCHAR(32)  NOT NULL,
    production_year INTEGER      NOT NULL,
    fuel_type       VARCHAR(32)  NOT NULL,
    power           INTEGER      NOT NULL,
    transmission    VARCHAR(32)  NOT NULL,
    wheel_drive     INTEGER      NOT NULL,
    number_of_doors INTEGER      NOT NULL,
    number_of_seats INTEGER      NOT NULL,
    color           VARCHAR(32)  NOT NULL,
    image           VARCHAR(128) NOT NULL,
    description     TEXT
);
--rollback DROP TABLE car_parameter

--changeset soroka andrei:12
CREATE TABLE IF NOT EXISTS "comment"
(
    id         BIGINT PRIMARY KEY,
    user_id    BIGINT                      NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    "content"  TEXT                        NOT NULL,
    car_id     INTEGER REFERENCES car (id),
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    rating     INTEGER                     NOT NULL
);
--rollback DROP TABLE "comment"

--changeset soroka andrei:13
CREATE TABLE IF NOT EXISTS star
(
    id     BIGINT PRIMARY KEY,
    car_id INTEGER NOT NULL REFERENCES car (id) ON DELETE CASCADE,
    stars  INTEGER NOT NULL
);
--rollback DROP TABLE star

--changeset soroka andrei:14
CREATE TABLE IF NOT EXISTS "order"
(
    id              BIGINT PRIMARY KEY,
    user_id         BIGINT                      NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    car_id          INTEGER                     NOT NULL REFERENCES car (id),
    location_id     INTEGER                     NOT NULL REFERENCES "location" (id),
    receipt_date    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    return_date     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    order_status_id INTEGER,
    total_cost      DECIMAL(6, 2)               NOT NULL
);
--rollback DROP TABLE "order"


