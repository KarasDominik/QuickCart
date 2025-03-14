CREATE TABLE stock_level (
    id          UUID                PRIMARY KEY,
    product_id  UUID    NOT NULL    UNIQUE,
    quantity    INT     NOT NULL
);
