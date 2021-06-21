package br.edu.univas.si5.bd2;

import java.util.Date;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Cargo;
import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.model.Usuario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner11 {

	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();

		// buscar o cargo
		Integer cargoPk = 7; // QA
		Cargo cargo = em.find(Cargo.class, cargoPk);
		if (cargo != null) {

			// criar um objeto usuário / ou buscar um usuário existente
			// criar um objeto Usuario
			Usuario user = new Usuario();
			user.setActive(true);
			user.setPassword("pass");
			user.setUsername("joaquim");

			// criar um objeto Funcionario
			Funcionario fun = new Funcionario();
			fun.setNome("Joaquim");
			fun.setSexo("M");
			fun.setNascimento(new Date());

			// setar o usuário dentro do funcionário
			fun.setUsuario(user);
			
			// setar o cargo dentro do funcionário
			fun.setCargo(cargo);
			
			// dentro de apenas uma transaction
			em.getTransaction().begin();
			// persistir o usuário e
			em.persist(user);
			// persistir o funcionario
			em.persist(fun);
			em.getTransaction().commit();
		}
	}
}
