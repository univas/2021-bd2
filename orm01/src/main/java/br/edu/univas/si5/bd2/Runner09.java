package br.edu.univas.si5.bd2;

import java.util.Date;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.model.Usuario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner09 {

	public static void main(String[] args) {
		
		// criar um objeto Usuario
		Usuario user = new Usuario();
		user.setActive(true);
		user.setPassword("pass");
		user.setUsername("jane");
		
		// criar um objeto Funcionario
		Funcionario fun = new Funcionario();
		fun.setNome("Jane");
		fun.setSexo("F");
		fun.setNascimento(new Date());

		// setar o usuário dentro do funcionário
		fun.setUsuario(user);

		// obter uma instância do EntityManager
		EntityManager em;
		em = HibernateUtil.getEntityManager();

		em.getTransaction().begin();// inicia a transação
		// persistir o objeto Usuario
		em.persist(user);
		// persistir o objeto Funcionario
		em.persist(fun);
		em.getTransaction().commit();// finaliza a transação
		
		System.out.println("Código gerado pela sequence: " + fun.getRegistro());
	}
}
