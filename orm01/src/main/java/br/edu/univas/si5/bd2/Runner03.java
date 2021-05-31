package br.edu.univas.si5.bd2;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner03 {

	public static void main(String[] args) {
		Funcionario fun = new Funcionario();
		fun.setNome("Júlia");
		fun.setSexo("F");

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
