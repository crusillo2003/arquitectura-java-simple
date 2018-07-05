CREATE DATABASE ejemplo_java_1;

USE ejemplo_java_1;

CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador interno del usuario',
  `alias` varchar(30) NOT NULL COMMENT 'alias o nickname del usuario',
  `correo` varchar(100) NOT NULL COMMENT 'correo electronico del usuario',
  `contrasenya` varchar(100) NOT NULL COMMENT 'contraseña del usuario cifrada',
  `registro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'fecha de creacion',
  `acceso` datetime DEFAULT NULL COMMENT 'fecha de ultimo acceso',
  `modificacion` datetime DEFAULT NULL COMMENT 'fecha de modificacion como alias, correo o contraseña',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Usuarios_UN_ALIAS` (`alias`),
  UNIQUE KEY `Usuarios_UN_CORREO` (`correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci ;

INSERT INTO ejemplo_java_1.Usuarios (alias,correo,contrasenya) VALUES('rulo','r2@gmail.com',PASSWORD('rulo321'));


CREATE USER 'rafex'@'%' ;
UPDATE mysql.user SET Password=PASSWORD('rafex123') WHERE User='rafex' AND Host='%' ;
GRANT Insert ON ejemplo_java_1.Usuarios TO 'rafex'@'%' ;
GRANT Delete ON ejemplo_java_1.Usuarios TO 'rafex'@'%' ;
GRANT Select ON ejemplo_java_1.Usuarios TO 'rafex'@'%' ;
GRANT Trigger ON ejemplo_java_1.Usuarios TO 'rafex'@'%' ;
GRANT Update ON ejemplo_java_1.Usuarios TO 'rafex'@'%' ;
FLUSH PRIVILEGES;
