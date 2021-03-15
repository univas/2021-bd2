
CREATE TABLE Aluno (
                matricula INTEGER NOT NULL,
                nome VARCHAR(50) NOT NULL,
                sexo VARCHAR(1) NOT NULL,
                cidade VARCHAR(50) NOT NULL,
                estado VARCHAR(2) NOT NULL,
                ativo BOOLEAN NOT NULL,
                peso INTEGER NOT NULL,
                idade INTEGER NOT NULL,
                CONSTRAINT Aluno_pk PRIMARY KEY (matricula)
);