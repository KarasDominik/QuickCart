create table payment (
    id              uuid primary key,
    order_id        uuid not null,
    checkout_url    text not null
);