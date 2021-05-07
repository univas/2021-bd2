package br.edu.univas.si5.bd2;

import br.edu.univas.si5.bd2.dao.CursoDAO;
import br.edu.univas.si5.bd2.model.Curso;

public class Runner01 {

	public static void main(String[] args) {
		Curso curso01 = new Curso(10, "Matemática");
		
		CursoDAO dao = new CursoDAO();
		dao.save(curso01);
		
		Curso curso02 = dao.findById(2);
		System.out.println(curso02);
	}

}
