SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Deporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Deporte` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Deporte` (
  `idDeporte` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`idDeporte`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Equipo` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Equipo` (
  `idEquipo` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `deporte` INT NOT NULL ,
  PRIMARY KEY (`idEquipo`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) ,
  INDEX `fk_Equipo_Deporte_idx` (`deporte` ASC) ,
  CONSTRAINT `fk_Equipo_Deporte`
    FOREIGN KEY (`deporte` )
    REFERENCES `mydb`.`Deporte` (`idDeporte` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jugador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Jugador` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Jugador` (
  `Equipo_idEquipo` INT NOT NULL ,
  `idJugador` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `firstSurname` VARCHAR(45) NOT NULL ,
  `secondSurname` VARCHAR(45) NULL ,
  `idStudentCard` VARCHAR(45) NOT NULL ,
  INDEX `fk_Jugador_Equipo1_idx` (`Equipo_idEquipo` ASC) ,
  PRIMARY KEY (`idJugador`) ,
  UNIQUE INDEX `idStudentCard_UNIQUE` (`idStudentCard` ASC) ,
  CONSTRAINT `fk_Jugador_Equipo1`
    FOREIGN KEY (`Equipo_idEquipo` )
    REFERENCES `mydb`.`Equipo` (`idEquipo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
