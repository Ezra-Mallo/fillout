CREATE TABLE customers (
    id INTEGER PRIMARY KEY,
    first_name TEXT,
    last_name TEXT,
    company TEXT,
    country TEXT,
    subscription_start DATE
);

.mode csv
.import customers.csv customers
