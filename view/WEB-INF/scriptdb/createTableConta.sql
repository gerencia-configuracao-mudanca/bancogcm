CREATE TABLE conta3
(

id_conta int,
ag int not null,
cc varchar(30),
valor int not null,
PRIMARY KEY (cc),
FOREIGN KEY (id_conta) REFERENCES usuarios3(id_usuario)
);