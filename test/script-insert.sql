--comandos DDL para popular o banco da biblioteca

INSERT INTO categoria (codigo,nome) VALUES (1,'categoria 1');
INSERT INTO categoria (codigo,nome) VALUES (2,'categoria 2');
INSERT INTO categoria (codigo,nome) VALUES (3,'categoria 3');

INSERT INTO livro (isbn,titulo,categoria_fk) VALUES (1,'livro 1',1);
INSERT INTO livro (isbn,titulo,categoria_fk) VALUES (2,'livro 2',2);
INSERT INTO livro (isbn,titulo,categoria_fk) VALUES (3,'livro 3',1);
INSERT INTO livro (isbn,titulo,categoria_fk) VALUES (4,'livro 4',2);
INSERT INTO livro (isbn,titulo,categoria_fk) VALUES (5,'livro 5',1);

INSERT INTO leitor (registro,nome,sexo) VALUES (1,'leitor 1','F');
INSERT INTO leitor (registro,nome,sexo) VALUES (2,'leitor 2','M');
INSERT INTO leitor (registro,nome,sexo) VALUES (3,'leitor 3','F');
INSERT INTO leitor (registro,nome,sexo) VALUES (4,'leitor 4','M');
INSERT INTO leitor (registro,nome,sexo) VALUES (5,'leitor 5','F');

INSERT INTO reserva (codigo,datareserva,isbn_fk,leitor_fk) VALUES (1,'2020-07-01',1,1);
INSERT INTO reserva (codigo,datareserva,isbn_fk,leitor_fk) VALUES (2,'2020-07-03',2,2);
INSERT INTO reserva (codigo,datareserva,isbn_fk,leitor_fk) VALUES (3,'2020-07-05',3,3);
INSERT INTO reserva (codigo,datareserva,isbn_fk,leitor_fk) VALUES (4,'2020-07-06',4,4);

INSERT INTO emprestimo (codigo,datasaida,datadevolucao,isbn_fk,leitor_fk) VALUES (1,'2020-07-02',null,1,1);
INSERT INTO emprestimo (codigo,datasaida,datadevolucao,isbn_fk,leitor_fk) VALUES (2,'2020-07-03',null,2,2);
INSERT INTO emprestimo (codigo,datasaida,datadevolucao,isbn_fk,leitor_fk) VALUES (3,'2020-07-06','2020-07-06',3,3);

