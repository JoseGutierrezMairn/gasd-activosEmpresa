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
  `id_persona` int(11) DEFAULT NULL,
  `id_area` int(11) DEFAULT NULL,
  `serial_activo` int(11) NOT NULL,
  PRIMARY KEY (`serial_activo`),
  KEY `responsable_area_fk` (`id_area`),
  KEY `responsable_persona_fk` (`id_persona`),
  CONSTRAINT `responsable_activo_fk` FOREIGN KEY (`serial_activo`) REFERENCES `activo` (`serial`),
  CONSTRAINT `responsable_area_fk` FOREIGN KEY (`id_area`) REFERENCES `area` (`id_area`),
  CONSTRAINT `responsable_persona_fk` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`)
)


CREATE TABLE `area` (
  `id_area` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` int(11) NOT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `AREA_UK` (`id_area`,`ciudad`),
  KEY `FK_AREA_CIUDAD` (`ciudad`),
  CONSTRAINT `FK_AREA_CIUDAD` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`id_ciudad`)
)



/* TRIGGERS */
CREATE or replace TRIGGER add_responsable 
   before  INSERT
   ON  activos_empresa.responsable 
   for each row
begin
	declare msg varchar(128);
	if (new.id_persona is not null and new.id_area is not null ) then 
		set msg ="No se puede asignar el mismo activo a una persona y un area al mismo tiempo";
        signal sqlstate '45000' set message_text = msg;
	end if;
end;


CREATE or replace TRIGGER update_responsable 
   before  update
   ON  activos_empresa.responsable 
   for each row
begin
	declare msg varchar(128);
	if (new.id_persona is not null and new.id_area is not null ) then 
		set msg ="No se puede asignar el mismo activo a una persona y un area al mismo tiempo";
        signal sqlstate '45000' set message_text = msg;
	end if;
end;

