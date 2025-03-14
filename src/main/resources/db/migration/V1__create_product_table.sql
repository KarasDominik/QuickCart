CREATE TABLE product
(
    id          UUID PRIMARY KEY,
    name        TEXT           NOT NULL,
    description TEXT           NOT NULL,
    price       DECIMAL(10, 2) NOT NULL
);