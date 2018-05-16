-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema prueba
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema prueba
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `prueba` DEFAULT CHARACTER SET utf8 ;
USE `prueba` ;

-- -----------------------------------------------------
-- Table `prueba`.`recipe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`recipe` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `imagePath` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `prueba`.`ingredient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prueba`.`ingredient` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `recipe_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKj0s4ywmqqqw4h5iommigh5yja` (`recipe_id` ASC),
  CONSTRAINT `FKj0s4ywmqqqw4h5iommigh5yja`
    FOREIGN KEY (`recipe_id`)
    REFERENCES `prueba`.`recipe` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
