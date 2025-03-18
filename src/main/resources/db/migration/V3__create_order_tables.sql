CREATE TABLE "order" (
    id          UUID PRIMARY KEY,
    created_at  TIMESTAMP NOT NULL,
    status      TEXT NOT NULL
);

CREATE TABLE ordered_product (
    id          UUID PRIMARY KEY,
    order_id    UUID NOT NULL,
    product_id  UUID NOT NULL,
    quantity    INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES "order"(id)
);