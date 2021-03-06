CREATE TABLE CARGO (
CODIGO INTEGER NOT NULL ,
NOME VARCHAR (30) NOT NULL ,
SALARIO FLOAT NOT NULL ,
PRIMARY KEY (CODIGO)
);

ALTER TABLE CARGO RENAME TO POSITION ;

ALTER TABLE POSITION RENAME COLUMN CODIGO TO CODE ;
ALTER TABLE POSITION RENAME COLUMN NOME TO NAME ;
ALTER TABLE POSITION RENAME COLUMN SALARIO TO WAGE ;

CREATE TABLE DEPARTMENT (
CODE SERIAL NOT NULL ,
NAME VARCHAR (30) NOT NULL ,
PRIMARY KEY (CODE)
);

CREATE SEQUENCE SEQ_FUNCIONARIO START WITH 1 ;

CREATE TABLE FUNCIONARIO (
REGISTRO INTEGER NOT NULL ,
NOME VARCHAR (30) NOT NULL ,
SEXO VARCHAR (1) NOT NULL ,
PRIMARY KEY (REGISTRO)
);

ALTER TABLE FUNCIONARIO ADD COLUMN NASCIMENTO TIMESTAMP NULL ;


--mapeamento 1:1
CREATE TABLE USUARIO (
USERNAME VARCHAR (30) NOT NULL ,
PASSWORD VARCHAR (30) NOT NULL ,
ACTIVE BOOLEAN NOT NULL ,
PRIMARY KEY ( USERNAME )
);

DELETE FROM FUNCIONARIO ; -- para facilitar a criação da FK
ALTER TABLE FUNCIONARIO ADD COLUMN USUARIO_FK VARCHAR ( 30 ) NOT NULL ;

ALTER TABLE FUNCIONARIO ADD CONSTRAINT FUNCIONARIO_USUARIO_FK
FOREIGN KEY ( USUARIO_FK ) REFERENCES USUARIO ( USERNAME ) ;



DELETE FROM FUNCIONARIO ; -- para facilitar a cria çã o da FK

ALTER TABLE FUNCIONARIO ADD COLUMN CARGO_FK INTEGER NOT NULL ;

ALTER TABLE FUNCIONARIO ADD CONSTRAINT FUNCIONARIO_CARGO_FK
FOREIGN KEY ( CARGO_FK ) REFERENCES POSITION ( CODE ) ;


