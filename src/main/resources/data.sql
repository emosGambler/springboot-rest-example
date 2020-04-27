DROP TABLE IF EXISTS billionaires;

CREATE TABLE billionaires (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    career VARCHAR(250) DEFAULT NULL
);

INSERT INTO billionaires (first_name, last_name, career) VALUES
    ('Jacek', 'Placek', 'Billionaire QA'),
    ('Elu', 'Wina', 'Billionaire normal one'),
    ('Johny', 'Moss', 'Billionaire Poker player');