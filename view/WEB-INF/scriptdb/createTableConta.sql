CREATE TABLE conta3
(

id_conta int,
ag int not null,
cc varchar(30),
bonus float,
tipo float,
valor float not null,
PRIMARY KEY (cc,tipo),
FOREIGN KEY (id_conta) REFERENCES usuarios3(id_usuario)
);