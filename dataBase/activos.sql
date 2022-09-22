CREATE TABLE `activo` (
  `serial` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `num_int_inventario` int(11) NOT NULL,
  `peso` float NOT NULL,
  `alto` float NOT NULL,
  `ancho` float NOT NULL,
  `valor_compra` int(11) NOT NULL,
  `fecha_compra` date DEFAULT NULL,
  PRIMARY KEY (`serial`),
  UNIQUE KEY `ACTIVO_UK` (`num_int_inventario`)
)

CREATE TABLE `ciudad` (
  `id_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_ciudad`),
  UNIQUE KEY `CIUDAD_UK` (`nombre`)
)

CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id_persona`)
)

CREATE TABLE `responsable` (
  `id_responsable` int(11) NOT NULL,
  `activo` int(11) NOT NULL,
  PRIMARY KEY (`id_responsable`,`activo`)
)


CREATE TABLE `area` (
  `id_area` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` int(11) NOT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `AREA_UK` (`id_area`,`ciudad`),
  KEY `FK_AREA_CIUDAD` (`ciudad`),
  CONSTRAINT `FK_AREA_CIUDAD` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`id_ciudad`)
)



/* POBLAR TABLAS */

insert into activos_empresa.persona (id_persona, nombre) values 
(1523464691, "Andres Jose Gutierrez Marin"),
(1523464692, "Fabian Melo Garcia"),
(1523464693, "Camilo Saenz ");


insert into activos_empresa.area (ciudad) values
(3),
(1),
(2);