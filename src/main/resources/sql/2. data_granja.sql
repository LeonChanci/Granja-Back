-- TRUNCATE TABLES
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `granja`.`cliente`;
TRUNCATE `granja`.`raza`;
TRUNCATE `granja`.`alimentacion`;
TRUNCATE `granja`.`porcino`;
SET FOREIGN_KEY_CHECKS = 1;

-- INSERT CLIENTES
INSERT INTO `granja`.`cliente` (`id_cliente`, `nombres`, `apellidos`, `direccion`, `telefono`)
VALUES
("863264988","Drake","Theory","P.O. Box 136, 4534 Lacinia St.","(826) 607-2278"),
("617684636","Alexa","Morgan","Ap #732-8087 Dui. Road","(830) 212-2247"),
("474771564","Johanna","Reigns","925-3988 Purus. St.","(801) 370-4041"),
("394022487","Becky","Alford","P.O. Box 341, 7572 Odio Rd.","(559) 398-7689"),
("885583622","Brock","Alford","9063 Aliquam, Road","(732) 218-4844"),
("531254932","Clarke","Wyatt","461-4278 Dignissim Av.","(443) 263-8555"),
("762085429","Cody","Rollins","177-1125 Consequat Ave","(740) 271-3631"),
("363677933","Bianca","Neal","Ap #937-4424 Vestibulum. Street","(792) 406-8858"),
("192758012","Drew","Watson","705-6031 Aliquam Street","(362) 881-5943"),
("110410415","Mercedes","Balor","Ap #720-1833 Curabitur Av.","(688) 944-6619"),
("262132898","Karl","Austin","241-9121 Fames St.","(559) 596-3381"),
("644337170","Sami","Rollins","Ap #308-4700 Mollis Av.","(508) 518-2967"),
("782668115","Charlotte","Riddle","Ap #696-6846 Ullamcorper Avenue","(744) 344-7768"),
("182120056","Matthew","Heyman","Ap #268-1749 Id St.","(185) 738-9267"),
("303265780","Shelton","Owens","Ap #206-5413 Vivamus St.","(821) 880-6661");

-- INSERT RAZA
INSERT INTO `granja`.`raza` (`id_raza`, `descripcion`)
VALUES
("1","York"),
("2","Hamp"),
("3","Duroc");

-- INSERT ALIMENTACIÓN
INSERT INTO `granja`.`alimentacion` (`id_alimentacion`, `descripcion`, `dosis`)
VALUES
("1","manzana, naranja, mandarina","3 veces al día"),
("2","uvas, papaya, banano","6 veces al día"),
("3","aguamasa, papa, yuca","9 veces al día"),
("4","platano, mango, mandarina","10 veces al día"),
("5","sandia, zanahoria, blocoli","2 veces al día");

-- INSERT PORCINOS
INSERT INTO `granja`.`porcino` (`id_porcino`, `id_raza`, `id_cliente`, `id_alimentacion`, `edad`, `peso`)
VALUES
(1,"1","303265780","1",2,19.95),
(2,"2","617684636","2",1,22.15),
(3,"3","474771564","3",3,34.75),
(4,"1","394022487","4",0,45.65),
(5,"2","885583622","5",2,16.3),
(6,"3","531254932","1",1,23.22),
(7,"1","762085429","2",1,14.76),
(8,"2","363677933","3",1,13.43),
(9,"3","192758012","4",0,11.0),
(10,"1","110410415","5",5,58.9);