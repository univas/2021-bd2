--Script para ser usado nos exercícios de agrupamento

--Definição da tabela PESSOA:

CREATE TABLE Pessoa (
                cpf INTEGER NOT NULL,
                nome VARCHAR(50) NOT NULL,
                idade INTEGER NOT NULL,
                sexo VARCHAR(1) NOT NULL,
                peso INTEGER NOT NULL,
                estado VARCHAR(2) NOT NULL,
                cidade VARCHAR(50) NOT NULL,
                ativo BOOLEAN NOT NULL,
                CONSTRAINT Pessoa_pk PRIMARY KEY (cpf)
);
