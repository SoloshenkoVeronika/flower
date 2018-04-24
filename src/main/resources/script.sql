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

DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS composition;
DROP TABLE IF EXISTS bouquet;
DROP TABLE IF EXISTS pack;
DROP TABLE IF EXISTS decoration;
DROP TABLE IF EXISTS flower;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS recipient;
DROP TABLE IF EXISTS sender;
DROP TABLE IF EXISTS user;

DROP TABLE IF EXISTS size;
DROP TABLE IF EXISTS product;

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
	first_name VARCHAR(50) NOT NULL,
	second_name VARCHAR(50) NOT NULL,
	phone VARCHAR(20) NOT NULL,
	email VARCHAR(50) NULL,
  
	PRIMARY KEY (id),
	UNIQUE KEY phone (phone)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS recipient (
	id INT(3) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	second_name VARCHAR(50) NOT NULL,
	phone VARCHAR(20) NOT NULL,
  
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

/*CREATE TABLE IF NOT EXISTS payment(
	id INT(3) NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
  
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;*/


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
	pack VARCHAR(40) NOT NULL,
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
    flower_id INT NULL,
    customer_bouquet_id INT NULL,
    
    FOREIGN KEY (flower_id) REFERENCES flower (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (customer_bouquet_id) REFERENCES customer_bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS decoration_customer_bouquet (
    decoration_id INT NULL,
    customer_bouquet_id INT NULL,
    
    FOREIGN KEY (decoration_id) REFERENCES decoration (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (customer_bouquet_id) REFERENCES customer_bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `order` (
	id INT(3) NOT NULL AUTO_INCREMENT,
    user_id INT(3) NULL,
	sender_id INT(3) NULL,
	recipient_id INT(3) NULL,
	address_id INT(3) NULL,
	
	payment INT(3) NOT NULL,
	date VARCHAR(50) NOT NULL,
	postcard VARCHAR(80) NULL,
	additional_inf VARCHAR(180) NULL,
	/*anonymity BOOLEAN NULL,*/
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
    flower_id INT NULL,
    order_id INT NULL,
    
    FOREIGN KEY (flower_id) REFERENCES flower (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS bouquet_order (
    bouquet_id INT NULL,
    order_id INT NULL,
    
    FOREIGN KEY (bouquet_id) REFERENCES bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS composition_order (
    composition_id INT NULL,
    order_id INT NULL,
    
    FOREIGN KEY (composition_id) REFERENCES composition (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS customer_bouquet_order (
    customer_bouquet_id INT NULL,
    order_id INT NULL,
    
    FOREIGN KEY (customer_bouquet_id) REFERENCES customer_bouquet (id)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (order_id) REFERENCES `order` (id)
		ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Blanche Moreau', 'Белый', 90, 50, 3.9, null);

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Freedom', 'Красный', 90, 50, 3.9, null);

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Leonardo da Vinci', 'Розовый', 60, 30, 4, null);

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Мисс Пигги (Miss Piggy)', 'Розовый', 45, 50, 4.2, null);

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Тюльпан', 'Christmas Dream', 'Розовый', 35, 60, 1.8, null);

/*
CREATE TABLE IF NOT EXISTS size(
	id_sz INT(3) NOT NULL AUTO_INCREMENT,
	height INT(3) NOT NULL,
	width INT(3) NOT NULL,
	diagonal INT(3) NOT NULL,
	volume INT(3) NOT NULL,
  
	PRIMARY KEY (id_sz)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;*/

/*
CREATE TABLE IF NOT EXISTS product(
id_pr INT(3) NOT NULL,
id_o INT(3) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
*/