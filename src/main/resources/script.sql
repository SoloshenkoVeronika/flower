

USE flowers
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
height int(3) NOT NULL,
width int(3) NOT NULL,
diagonal int(3) NOT NULL,
volume int(3) NOT NULL,
 PRIMARY KEY (id_sz)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE flower(
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE bouquet(
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE composition(
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE gift(
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