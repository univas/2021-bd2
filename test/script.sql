--script DDL para criar as tabelas do banco da biblioteca

CREATE TABLE Leitor (
	registro INTEGER NOT NULL,
	nome VARCHAR(30) NOT NULL,
	sexo VARCHAR(1) NOT NULL,
	CONSTRAINT leitor_pk PRIMARY KEY (registro)
);

CREATE TABLE Categoria (
	codigo INTEGER NOT NULL,
	nome VARCHAR(15) NOT NULL,
	CONSTRAINT categoria_pk PRIMARY KEY (codigo)
);

CREATE TABLE Livro (
	isbn INTEGER NOT NULL,
	titulo VARCHAR(40) NOT NULL,
	categoria_fk INTEGER,
	CONSTRAINT livro_pk PRIMARY KEY (isbn)
);

CREATE TABLE Emprestimo (
	codigo INTEGER NOT NULL,
	dataSaida DATE NOT NULL,
	dataDevolucao DATE,
	isbn_fk INTEGER NOT NULL,
	leitor_fk INTEGER NOT NULL,
	CONSTRAINT emprestimo_pk PRIMARY KEY (codigo)
);

CREATE TABLE Reserva (
	codigo INTEGER NOT NULL,
	dataReserva DATE NOT NULL,
	isbn_fk INTEGER NOT NULL,
	leitor_fk INTEGER NOT NULL,
	CONSTRAINT reserva_pk PRIMARY KEY (codigo)
);


ALTER TABLE Reserva ADD CONSTRAINT professor_reserva_fk
FOREIGN KEY (leitor_fk)
REFERENCES Leitor (registro);

ALTER TABLE Emprestimo ADD CONSTRAINT leitor_emprestimo_fk
FOREIGN KEY (leitor_fk)
REFERENCES Leitor (registro);

ALTER TABLE Livro ADD CONSTRAINT categoria_livro_fk
FOREIGN KEY (categoria_fk)
REFERENCES Categoria (codigo);

ALTER TABLE Reserva ADD CONSTRAINT livro_reserva_fk
FOREIGN KEY (isbn_fk)
REFERENCES Livro (isbn);

ALTER TABLE Emprestimo ADD CONSTRAINT livro_emprestimo_fk
FOREIGN KEY (isbn_fk)
REFERENCES Livro (isbn);
