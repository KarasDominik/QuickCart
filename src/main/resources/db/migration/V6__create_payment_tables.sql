create table payment_ordered_product (
    id uuid primary key,
    payment_id uuid not null,
    product_id uuid not null,
    quantity int not null
);

create table payment (
    id uuid primary key,
    order_id uuid not null
);