SET NAMES utf8;
CREATE DATABASE IF NOT EXISTS flowers DEFAULT CHARACTER SET utf8;
USE flowers;

DROP TABLE IF EXISTS composition_order;
DROP TABLE IF EXISTS bouquet_order;
DROP TABLE IF EXISTS flower_order;
DROP TABLE IF EXISTS decoration_customer_bouquet;
DROP TABLE IF EXISTS flower_customer_bouquet;
DROP TABLE IF EXISTS customer_bouquet_order;
DROP TABLE IF EXISTS customer_bouquet;

DROP TABLE IF EXISTS `order_`;
DROP TABLE IF EXISTS composition;
DROP TABLE IF EXISTS bouquet;
DROP TABLE IF EXISTS pack;
DROP TABLE IF EXISTS decoration;
DROP TABLE IF EXISTS flower;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS recipient;
DROP TABLE IF EXISTS sender;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS user (
	id INT(3) NOT NULL AUTO_INCREMENT,
	login VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL,
	status INT(2) NULL,

	PRIMARY KEY (id),
	UNIQUE KEY login (login)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS sender (
	id INT(3) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NULL,
	second_name VARCHAR(50) NULL,
	phone VARCHAR(20) NULL,
	email VARCHAR(50) NULL,

	PRIMARY KEY (id),
	UNIQUE KEY phone (phone)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS recipient (
	id INT(3) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NULL,
	second_name VARCHAR(50) NULL,
	phone VARCHAR(20) NULL,

	PRIMARY KEY (id),
	UNIQUE KEY phone (phone)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS address (
	id INT(3) NOT NULL AUTO_INCREMENT,
	city VARCHAR(50) NOT NULL,
	street VARCHAR(50) NOT NULL,
	house INT(3) NOT NULL,
	block INT(3) NOT NULL,
	flat INT(3) NOT NULL,

	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS flower (
	id INT(3) NOT NULL AUTO_INCREMENT,
	species VARCHAR(60) NOT NULL,
	sort VARCHAR(100) NOT NULL,
	color VARCHAR(30) NOT NULL,
	length DOUBLE(10,2) NOT NULL,
	amount INT(3) NOT NULL,
	price DOUBLE(10,2) NOT NULL,
	picture VARCHAR(256) NULL,

	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS decoration (
	id INT(3) NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	amount INT(3) NOT NULL,
	price DOUBLE(10,2) NOT NULL,
	picture VARCHAR(256) NULL,

	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS pack (
	id INT(3) NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	amount INT(3) NOT NULL,
	price DOUBLE(10,2) NOT NULL,
	picture VARCHAR(256) NULL,

	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS bouquet (
	id INT(3) NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	composition VARCHAR(256) NOT NULL,
	height DOUBLE(10,2) NOT NULL,
	diameter DOUBLE(10,2) NOT NULL,
	weight DOUBLE(10,2) NOT NULL,
	amount INT(3) NOT NULL,
	price DOUBLE(10,2) NOT NULL,
	picture VARCHAR(256) NULL,

	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS composition (
	id INT(3) NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	composition VARCHAR(256) NOT NULL,
	pack VARCHAR(100) NOT NULL,
	amount INT(3) NOT NULL,
	price DOUBLE(10,2) NOT NULL,
	picture VARCHAR(256) NULL,

	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS customer_bouquet (
	id INT(3) NOT NULL AUTO_INCREMENT,
	pack_id INT(3) NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (pack_id) REFERENCES pack (id)
		ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS flower_customer_bouquet (
	id INT(3) NOT NULL AUTO_INCREMENT,
	flower_id INT NULL,
	customer_bouquet_id INT NULL,
	quantity INT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (flower_id) REFERENCES flower (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (customer_bouquet_id) REFERENCES customer_bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS decoration_customer_bouquet (
	id INT(3) NOT NULL AUTO_INCREMENT,
	decoration_id INT NULL,
	customer_bouquet_id INT NULL,
	quantity INT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (decoration_id) REFERENCES decoration (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (customer_bouquet_id) REFERENCES customer_bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `order_` (
	id INT(3) NOT NULL AUTO_INCREMENT,
	user_id INT(3) NULL,
	sender_id INT(3) NULL,
	recipient_id INT(3) NULL,
	address_id INT(3) NULL,

	date DATETIME NOT NULL,
	postcard VARCHAR(80) NULL,
	additional_inf VARCHAR(180) NULL,
	payment VARCHAR(30) NOT NULL,
	cost DOUBLE(10,2) NOT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (user_id) REFERENCES user (id)
		ON DELETE SET NULL ON UPDATE CASCADE,

	FOREIGN KEY (sender_id) REFERENCES sender (id)
		ON DELETE SET NULL ON UPDATE CASCADE,

	FOREIGN KEY (recipient_id) REFERENCES recipient (id)
		ON DELETE SET NULL ON UPDATE CASCADE,

	FOREIGN KEY (address_id) REFERENCES address(id)
		ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS flower_order (
	id INT(3) NOT NULL AUTO_INCREMENT,
	flower_id INT NULL,
	order_id INT NULL,
	quantity INT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (flower_id) REFERENCES flower (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order_` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS bouquet_order (
	id INT(3) NOT NULL AUTO_INCREMENT,
	bouquet_id INT NULL,
	order_id INT NULL,
	quantity INT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (bouquet_id) REFERENCES bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order_` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS composition_order (
	id INT(3) NOT NULL AUTO_INCREMENT,
	composition_id INT NULL,
	order_id INT NULL,
	quantity INT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (composition_id) REFERENCES composition (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order_` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS customer_bouquet_order (
	id INT(3) NOT NULL AUTO_INCREMENT,
	customer_bouquet_id INT NULL,
	order_id INT NULL,
	quantity INT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (customer_bouquet_id) REFERENCES customer_bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order_` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
	DEFAULT CHARACTER SET = utf8;




INSERT INTO user (login, password, status)
VALUES ('admin', 'admin', 1);

INSERT INTO user (login, password, status)
VALUES ('user', 'user', 0);

INSERT INTO sender (first_name, second_name, phone, email)
VALUES ('Иван', 'Иванов', '+375 29 333-22-11', 'ivan@mail.ru');

INSERT INTO recipient (first_name, second_name, phone)
VALUES ('Людмила', 'Иванова', '+375 29 333-22-22');

INSERT INTO address (city, street, house, block, flat)
VALUES ('Минск', 'ул. Якуба Колоса', 56, 0, 4);



INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Лилия', ' Cogoleto', 'Розовый', 90, 40, 6.9, 'lily_cogoleto.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Лилия', ' Mapira', 'Бордовый', 95, 40, 7.5, 'lily_mapira.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Лилия', ' Corsage', 'Нежно-розовый', 80, 60, 6.5, 'lily_corsage.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Red Naomi', 'Красный', 80, 50, 4.5, 'rose_red_naomi.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Aqua', 'Розовый', 50, 80, 3.6, 'rose_aqua.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Avalanche', 'Белый', 50, 60, 2.9, 'rose_avalanche.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', ' Sweet Avalanche', 'Нежно розовый', 50, 50, 4.4, 'rose_sweet_avalanche.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Jumilia', 'Белый', 70, 60, 4.2, 'rose_jumilia.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Wow', 'Оранжевый', 70, 50, 4.4, 'rose_wow.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Talea', 'Нежно бежевый', 50, 70, 2.5, 'rose_talea.jpg');

/*INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Freedom', 'Красный', 60, 70, 4.6, 'freedom_flower.jpg');*/

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Penny lane', 'Жёлтый', 50, 60, 2.9, 'rose_penny_lane.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', ' Senorita ', 'Нежно розовый', 70, 60, 4, 'rose_senorita.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Тюльпан', ' Christmas Dream', 'Розовый', 40, 60, 2.1, 'tulip_christmas_dream.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Тюльпан', 'Alibi', 'Фиолетовый', 30, 70, 2.3, 'tulip_alibi.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Тюльпан', 'Furand', 'Красный', 35, 50, 2.3, 'tulip_furand.jpg');

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Тюльпан', 'Strong Gold', 'Жёлтый', 45, 60, 1.9, 'tulip_strong_gold.jpg');




INSERT INTO decoration (name, amount, price, picture)
VALUES ('Веточка вербная (зелёная), 80 см', 200, 2.4, 'vetka5.jpg');

INSERT INTO decoration (name, amount, price, picture)
VALUES ('Веточка вербная (белая), 80 см', 200, 2.2, 'vetka1.jpg');

INSERT INTO decoration (name, amount, price, picture)
VALUES ('Ветка сакуры, 82 см', 200, 12.3, 'vetka3.jpg ');

INSERT INTO decoration (name, amount, price, picture)
VALUES ('Рускус, 70 см', 200, 8.6, 'vetka4.jpg');

INSERT INTO decoration (name, amount, price, picture)
VALUES ('Веточка искусственная, 52 см', 200, 3.8, 'vetka2.jpg ');

INSERT INTO decoration (name, amount, price, picture)
VALUES ('Искусственный красный цветок, 40 см', 100, 4.9, 'cvetok3.jpg');

INSERT INTO decoration (name, amount, price, picture)
VALUES ('Искусственный розовый цветок, 50 см', 100, 4.9, 'cvetok5.jpg');



INSERT INTO pack (name, amount, price, picture)
VALUES ('Бумага флористическая двусторонняя, 50 см', 100, 2, 'pack1.jpg');

INSERT INTO pack (name, amount, price, picture)
VALUES ('Плёнка, 70 см', 200, 3.2, 'plenka3.jpg');

INSERT INTO pack (name, amount, price, picture)
VALUES ('Коробка круглая, высота – 45 см', 200, 5.9, 'korobka2.jpg');

INSERT INTO pack (name, amount, price, picture)
VALUES ('Сизал, 60 см', 200, 3.5, 'sizal1.jpg');

INSERT INTO pack (name, amount, price, picture)
VALUES ('Коробка квадратная, высота – 30 см', 180, 5.1, 'korobka1.jpg');

INSERT INTO pack (name, amount, price, picture)
VALUES ('Корзина, ширина – 50 см', 100, 6.8, 'korzina2.jpg');

INSERT INTO pack (name, amount, price, picture)
VALUES ('Органза, 60 см', 100, 3, 'organza1.jpg');



INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Яркий букет из тюльпанов', '71 тюльпан, жёлтая и красная лента',
				50, 50, 550, 30, 69.7, 'bouquet_bright.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Нежный букет из тюльпанов', '25 тюльпанов, бежевый сизаль, белая атласная лента',
				35, 40, 400, 50, 22.4, 'bouquet_delicate.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Букет из роз Avalanche', '30 роз Avalanche, ветки рускуса, белая лента',
				60, 40, 500, 30, 44.99, 'bouquet_avalanche.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Букет из роз Red Naomi', '50 роз Red Naomi, красная лента',
				70, 50, 600, 25, 67.5, 'bouquet_red_naomi.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Букет из роз Jumilia', '45 роз Jumilia, розовая лента',
				50, 50, 450, 35, 55.3, 'bouquet_jumilia.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Букет из роз Senorita', '35 роз Senorita, розовая лента',
				50, 40, 450, 30, 32.99, 'bouquet_senorita.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Букет из тюльпанов Christmas Dream ', '40 тюльпанов Christmas Dream, белая лента',
				50, 40, 450, 50, 39.99, 'bouquet_christmas_dream.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Букет из тюльпанов White Dream', '25 тюльпанов White Dream, белая лента',
				45, 30, 380, 50, 23.5, 'bouquet_white_dream.jpg');

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES ('Букет с лилиями и ирисами', '7 лилий, 5 ирисов, 3 розы, декоративные украшения, розовый сизаль, белая атласная лента',
				45, 40, 500, 20, 65.99, 'bouquet_lily_iris.jpg');



INSERT INTO composition (name, composition, pack, amount, price, picture)
VALUES ('Нежное утро', '40 тюльпанов Christmas Dream, широкая розовая атласная лента',
				'Круглая фиолетовая коробка', 20, 38.99, ' composition_tulip.jpg');

INSERT INTO composition (name, composition, pack, amount, price, picture)
VALUES ('Сюрприз', '9 роз, 3 тюльпана, декоративные украшения, розовая атласная лента',
				'Квадратная коробка', 40, 18.99, ' composition_tulip_rose.jpg');

INSERT INTO composition (name, composition, pack, amount, price, picture)
VALUES ('Живая композиция', '2 герберы, 3 розы, декоративные украшения, широкая розовая атласная лента',
				'Плетёная корзина', 20, 50.2, ' composition_gerbera_rose.jpg');

INSERT INTO composition (name, composition, pack, amount, price, picture)
VALUES ('Сказка', '20 роз Senorita, 12 ромашек, ветки рускуса, мелкие цветы',
				'Круглая фиолетовая коробка в горошек', 10, 48.89, ' composition_rose_chamomile.jpg');




INSERT INTO customer_bouquet (pack_id)
VALUES (1);

INSERT INTO flower_customer_bouquet (flower_id, customer_bouquet_id, quantity)
VALUES (1, 1, 2);

INSERT INTO flower_customer_bouquet (flower_id, customer_bouquet_id, quantity)
VALUES (3, 1, 3);

INSERT INTO decoration_customer_bouquet (decoration_id, customer_bouquet_id, quantity)
VALUES (1, 1, 1);

INSERT INTO `order_` (user_id, sender_id, recipient_id, address_id,
											date, postcard, additional_inf, payment, cost)
VALUES (1, 1, 1, 1, '2018-04-20 16:42:17', 'С днём рождения от любящего мужа!', null, 'Наличные', 97);

INSERT INTO flower_order (flower_id, order_id, quantity)
VALUES (3, 1, 3);

INSERT INTO bouquet_order (bouquet_id, order_id, quantity)
VALUES (1, 1, 1);

INSERT INTO composition_order (composition_id, order_id, quantity)
VALUES (1, 1, 2);

INSERT INTO customer_bouquet_order (customer_bouquet_id, order_id, quantity)
VALUES (1, 1, 1);


/*
INSERT INTO user (login, password, status)
VALUES (, , );

INSERT INTO sender (first_name, second_name, phone, email)
VALUES (, , , );

INSERT INTO recipient (first_name, second_name, phone)
VALUES (, , );

INSERT INTO address (city, street, house, block, flat)
VALUES (, , , , );

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES (, , , , , , );

INSERT INTO decoration (name, amount, price, picture)
VALUES (, , , );

INSERT INTO pack (name, amount, price, picture)
VALUES (, , , );

INSERT INTO bouquet (name, composition, height, diameter, weight, amount, price, picture)
VALUES (, , , , , , , );

INSERT INTO composition (name, composition, pack, amount, price, picture)
VALUES (, , , , , );

INSERT INTO customer_bouquet (pack_id)
VALUES ();

INSERT INTO flower_customer_bouquet (flower_id, customer_bouquet_id, quantity)
VALUES (, , );

INSERT INTO decoration_customer_bouquet (decoration_id, customer_bouquet_id, quantity)
VALUES (, , );

INSERT INTO `order_` (user_id, sender_id, recipient_id, address_id,
	date, postcard, additional_inf, payment, cost)
VALUES (, , , , , , , , );

INSERT INTO flower_order (flower_id, order_id, quantity)
VALUES (, , );

INSERT INTO bouquet_order (bouquet_id, order_id, quantity)
VALUES (, , );

INSERT INTO composition_order (composition_id, order_id, quantity)
VALUES (, , );

INSERT INTO customer_bouquet_order (customer_bouquet_id, order_id, quantity)
VALUES (, , );
*/