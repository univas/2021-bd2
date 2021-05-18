package br.edu.univas.si5.bd2;

import java.util.List;

import br.edu.univas.si5.bd2.dao.CursoDAO;
import br.edu.univas.si5.bd2.model.Curso;

public class Runner01 {

	public static void main(String[] args) {
		Curso curso01 = new Curso(10, "Matemática");
		
		CursoDAO dao = new CursoDAO();
		dao.save(curso01);
		
		Curso curso02 = dao.findById(2);
		System.out.println(curso02);
		
		Curso curso03 = new Curso(10, "Fisioterapia");
		dao.update(curso03);
		
		dao.delete(10);
		
		List<Curso> cursos = dao.findAll();
		for (Curso curso : cursos) {
			System.out.println(curso);
		}
	}

}
