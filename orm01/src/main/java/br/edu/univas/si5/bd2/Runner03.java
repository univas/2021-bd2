package br.edu.univas.si5.bd2;

import java.util.Date;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner03 {

	public static void main(String[] args) {
		Funcionario fun = new Funcionario();
		fun.setNome("Jane");
		fun.setSexo("F");
		fun.setNascimento(new Date());

		// obter uma instância do EntityManager
		EntityManager em;
		em = HibernateUtil.getEntityManager();

		// persistir o objeto (dentro de uma transação)
		em.getTransaction().begin();// inicia a transação
		em.persist(fun);
		em.getTransaction().commit();// finaliza a transação
		
		System.out.println("Código gerado pela sequence: " + fun.getRegistro());
	}
}
