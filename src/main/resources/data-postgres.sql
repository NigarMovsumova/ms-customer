CREATE TABLE IF NOT EXISTS customers (
    i SERIAL PRIMARY KEY,
    name VARCHAR(32),
    surname VARCHAR(32)
);

INSERT INTO customers(name, surname)
VALUES
('Ayxan', 'Agazade'),
('Nigar', 'Movsumova'),
('Elvin', 'Makhmudov'),
('Zaur', 'Aliyev');

