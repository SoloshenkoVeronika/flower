CREATE TABLE flower(
  id int(3) NOT NULL AUTO_INCREMENT,
  species varchar(60) NOT NULL,
  sort varchar(100) NOT NULL,
  color varchar(30) NOT NULL,
  length float(2) NOT NULL,
  amount  int(3) NOT NULL,
  price  float(2) NOT NULL,
  picture varchar(256) NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Blanche Moreau', 'Белый', 90, 50, 3.9, null);
INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Leonardo da Vinci', 'Розовый', 60, 30, 4, null);

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Роза', 'Мисс Пигги (Miss Piggy)', 'Розовый', 45, 50, 4.2, null);

INSERT INTO flower (species, sort, color, length, amount, price, picture)
VALUES ('Тюльпан', 'Christmas Dream', 'Розовый', 35, 60, 1.8, null);


CREATE TABLE `user` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(256) NOT NULL,
  `status` int(2)  NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE sender(
 id_s int(3) NOT NULL AUTO_INCREMENT,
 name   varchar(50) NOT NULL,
 surname varchar(256) NOT NULL,
 phone varchar(256)  NOT NULL,
 e_mail varchar(256)  NULL,
  PRIMARY KEY (id_s),
    UNIQUE KEY phone (phone)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE recipient(
 id_r int(3) NOT NULL AUTO_INCREMENT,
 name   varchar(50) NOT NULL,
 surname varchar(256) NOT NULL,
 phone varchar(256)  NOT NULL,
 PRIMARY KEY (id_r),
 UNIQUE KEY phone (phone)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE address(
 id_a int(3) NOT NULL AUTO_INCREMENT,
 city   varchar(50) NOT NULL,
 street varchar(256) NOT NULL,
 house int(3)  NOT NULL,
 corps int(3) NOT NULL,
 flat int(3) NOT NULL,
  PRIMARY KEY (id_a)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE payment (
 id_p int(3) NOT NULL AUTO_INCREMENT,
 namr_payment   varchar(50) NOT NULL,
  PRIMARY KEY (id_p)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE size(
id_sz  int(3) NOT NULL AUTO_INCREMENT,
length int(3) NOT NULL,
width int(3) NOT NULL,
diagonal int(3) NOT NULL,
volume int(3) NOT NULL,
 PRIMARY KEY (id_sz)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



CREATE TABLE bouquet(
  id INT(3) NOT NULL AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  composition VARCHAR(256) NOT NULL,
  length FLOAT(2) NOT NULL,
  diameter FLOAT(2) NOT NULL,
  weight FLOAT(2) NOT NULL,
  amount  INT(3) NOT NULL,
  price  FLOAT(2) NOT NULL,
  picture VARCHAR(256) NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE decoration(
  id int(3) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  amount  INT(3) NOT NULL,
  price  FLOAT(2) NOT NULL,
  picture VARCHAR(256) NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE composition(
  id INT(3) NOT NULL AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  composition VARCHAR(256) NOT NULL,
  pack VARCHAR(256) NOT NULL,
  amount  INT(3) NOT NULL,
  price  FLOAT(2) NOT NULL,
  picture VARCHAR(256) NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE pack(
  id INT(3) NOT NULL AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  amount  INT(3) NOT NULL,
  price  FLOAT(2) NOT NULL,
  picture VARCHAR(256) NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE order (
  id_o int(3) NOT NULL AUTO_INCREMENT,
  id_s int(3) NOT NULL,
  id_r int(3) NOT NULL,
  id_pr int(3) NOT NULL,
  id_a int(3) NOT NULL,
  id_p int(3) NOT NULL,
  data varchar(50) NOT NULL,
  postcard varchar(50)  NULL,
  addinforn varchar(50)  NULL,
  anonymity boolean NULL,
  cost float NOT NULL,
  PRIMARY KEY (id_o),
  CONSTRAINT user FOREIGN KEY (id_s) REFERENCES sender (id_s),
  CONSTRAINT user FOREIGN KEY (id_r) REFERENCES  recipient (id_r),
  CONSTRAINT user FOREIGN KEY (id_a) REFERENCES  address(id_a),
  CONSTRAINT user FOREIGN KEY (id_p) REFERENCES payment (id_p)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE product(
id_pr int(3) NOT NULL,
id_o int(3) NOT NULL,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;