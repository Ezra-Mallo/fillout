CREATE TABLE books (
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    isbn TEXT PRIMARY KEY NOT NULL,
    genre TEXT,
    publication_year INTEGER,
    price DECIMAL(10,2),
    stock_quantity INTEGER
);
