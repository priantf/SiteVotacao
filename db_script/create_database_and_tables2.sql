create database eleicao;
use eleicao;
CREATE TABLE `eleicao`.`uf` (
  `id_uf` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id_uf`)  COMMENT '');

insert into uf values (1, "SP");

CREATE TABLE `eleicao`.`municipio` (
  `id_municipio` INT NOT NULL COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `uf` INT NULL COMMENT '',
  PRIMARY KEY (`id_municipio`)  COMMENT '',
  INDEX `id_uf_idx` (`uf` ASC)  COMMENT '',
  CONSTRAINT `id_uf`
    FOREIGN KEY (`uf`)
    REFERENCES `eleicao`.`uf` (`id_uf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

insert into municipio values (1, "Sao Jose dos Campos", 1);

CREATE TABLE `eleicao`.`eleitor` (
  `titulo` VARCHAR(45) NOT NULL COMMENT '',
  `senha` VARCHAR(45) NULL COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `nasc` VARCHAR(45) NULL COMMENT '',
  `municipio` INT NULL COMMENT '',
  `emissao_titulo` VARCHAR(45) NULL COMMENT '',
  `zona` VARCHAR(45) NULL COMMENT '',
  `secao` VARCHAR(45) NULL COMMENT '',
  `categoria` VARCHAR(45) NULL COMMENT '',
  `liberacao` INT NULL COMMENT '',
  `ja_votou` INT NULL COMMENT '',
  PRIMARY KEY (`titulo`)  COMMENT '',
  INDEX `fk_municipio_idx` (`municipio` ASC)  COMMENT '',
  CONSTRAINT `fk_municipio`
    FOREIGN KEY (`municipio`)
    REFERENCES `eleicao`.`municipio` (`id_municipio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

insert into eleitor values("00000", "admin", "Luiz", "12/11/1998", 1, "21/10/2015", "10", "10", "ELEITOR", 0, 0);
insert into eleitor values("11111", "admin", "Cristiano Ronaldo", "12/11/1998", 1, "21/10/2015", "10", "10", "MESARIO", 0, 0);
insert into eleitor values("22222", "admin", "Messi", "12/11/1998", 1, "21/10/2015", "10", "10", "CHEFE", 0, 0);

UPDATE eleitor e SET e.liberacao = 0 WHERE e.titulo = "00000";
select * from eleitor;
CREATE TABLE `eleicao`.`candidato` (
  `numero` INT NOT NULL COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `partido` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`numero`)  COMMENT '');

insert into candidato values(53, "Joaozinho Jose", "PPPP");
insert into candidato values(14, "Fernando Fernandes", "PQP");

CREATE TABLE `eleicao`.`voto` (
  `idvoto` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `numero` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idvoto`)  COMMENT '');

drop table voto;
insert into voto values(null, 53);
insert into voto values(null, 53);
insert into voto values(null, 53);
insert into voto values(null, 53);
insert into voto values(null, 53);
insert into voto values(null, 53);
insert into voto values(null, 14);
insert into voto values(null, 14);
insert into voto values(null, 14);
insert into voto values(null, 14);

select count(numero) from voto where numero=14;
select * from voto;
