SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `sportteamsmng` ;
CREATE SCHEMA IF NOT EXISTS `sportteamsmng` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `sportteamsmng` ;

-- -----------------------------------------------------
-- Table `sportteamsmng`.`Sport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sportteamsmng`.`Sport` ;

CREATE TABLE IF NOT EXISTS `sportteamsmng`.`Sport` (
  `idSport` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pointsPerWin` INT UNSIGNED NOT NULL DEFAULT 2,
  `pointsPerTie` INT UNSIGNED NOT NULL DEFAULT 1,
  `pointsPerDefeat` INT UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`idSport`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sportteamsmng`.`Team`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sportteamsmng`.`Team` ;

CREATE TABLE IF NOT EXISTS `sportteamsmng`.`Team` (
  `idTeam` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `matchesPlayed` INT UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `matchesWon` INT UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `matchesTied` INT UNSIGNED ZEROFILL NOT NULL DEFAULT 0,
  `sport` INT NOT NULL,
  PRIMARY KEY (`idTeam`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC),
  INDEX `fk_Equipo_Deporte_idx` (`sport` ASC),
  CONSTRAINT `fk_Equipo_Deporte`
    FOREIGN KEY (`sport`)
    REFERENCES `sportteamsmng`.`Sport` (`idSport`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
