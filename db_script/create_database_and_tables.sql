create database eleicao;
create user luiz@'%' identified by '123';
grant all on votacao.* to luiz@'%';

use eleicao;

create table usuario(titulo varchar(100), senha varchar(100), categoria varchar(10));
insert into usuario values("11111", "admin", "MESARIO");
insert into usuario values("22222", "admin", "ELEITOR");
insert into usuario values("00000", "admin", "CHEFE");

drop table votacao;
drop user luiz@'%';