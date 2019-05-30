create database eleicao;

use eleicao;

CREATE TABLE eleitor (
  titulo VARCHAR(100) NOT NULL,
  senha VARCHAR(45) NULL,
  nome VARCHAR(45) NOT NULL,
  nasc DATE NOT NULL,
  municipio VARCHAR(45) NOT NULL,
  categoria VARCHAR(45) NOT NULL,
  PRIMARY KEY (`titulo`));
  
insert into eleitor values("11111", "admin", "MESARIO");
insert into eleitor values("22222", "admin", "ELEITOR");
insert into eleitor values("00000", "admin", "CHEFE");

CREATE TABLE candidato (
  numero VARCHAR(45) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (`numero`));
  
insert into candidato values (13, 'Lula');
insert into candidato values (17, 'Bolsonaro');

CREATE TABLE voto (
    idvoto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    numero VARCHAR(45) NOT NULL,
    CONSTRAINT fk_numero FOREIGN KEY (numero)
        REFERENCES candidato (numero)
);

drop table voto;
desc voto;
select * from voto;
insert into voto values (1, "13");