-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema granja
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `granja` ;

-- -----------------------------------------------------
-- Schema granja
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `granja` DEFAULT CHARACTER SET utf8 ;
USE `granja` ;

-- -----------------------------------------------------
-- Table `granja`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `granja`.`cliente` ;

CREATE TABLE IF NOT EXISTS `granja`.`cliente` (
  `id_cliente` VARCHAR(15) NOT NULL,
  `nombres` VARCHAR(60) NOT NULL,
  `apellidos` VARCHAR(60) NOT NULL,
  `direccion` VARCHAR(100) NULL,
  `telefono` VARCHAR(20) NULL,
  PRIMARY KEY (`id_cliente`)
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `granja`.`alimentacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `granja`.`alimentacion` ;

CREATE TABLE IF NOT EXISTS `granja`.`alimentacion` (
  `id_alimentacion` VARCHAR(15) NOT NULL,
  `descripcion` VARCHAR(60) NOT NULL,
  `dosis` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id_alimentacion`)
  )
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `granja`.`raza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `granja`.`raza` ;

CREATE TABLE IF NOT EXISTS `granja`.`raza` (
  `id_raza` VARCHAR(15) NOT NULL,
  `descripcion` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id_raza`)
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `granja`.`porcino`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `granja`.`porcino` ;

CREATE TABLE IF NOT EXISTS `granja`.`porcino` (
  `id_porcino` INT NOT NULL AUTO_INCREMENT,
  `id_raza` VARCHAR(15) NOT NULL,
  `id_cliente` VARCHAR(15) NOT NULL,
  `id_alimentacion` VARCHAR(15) NOT NULL,
  `edad` TINYINT NOT NULL,
  `peso` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`id_porcino`),
  CONSTRAINT `fk_PORCINO_RAZA`
    FOREIGN KEY (`id_raza`)
    REFERENCES `granja`.`raza` (`id_raza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PORCINO_CLIENTE`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `granja`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PORCINO_ALIMENTO`
    FOREIGN KEY (`id_alimentacion`)
    REFERENCES `granja`.`alimentacion` (`id_alimentacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;