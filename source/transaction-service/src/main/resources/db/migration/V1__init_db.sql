CREATE TABLE "transaction"
(
    id             bigserial primary key,
    user_id   bigserial,
    transaction_id varchar(10),
    amount         decimal,
    status        varchar(20),
    purchase_time timestamp,
    created_date   timestamp default now(),
    updated_date   timestamp default now(),
    constraint unique_uk_1 UNIQUE (transaction_id)
);

CREATE OR REPLACE FUNCTION update_modified_column()
RETURNS TRIGGER AS $$
BEGIN
  NEW.updated_date = NOW();
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_transaction_history_modified_time
    BEFORE UPDATE
    ON "transaction"
    FOR EACH ROW EXECUTE PROCEDURE update_modified_column();
