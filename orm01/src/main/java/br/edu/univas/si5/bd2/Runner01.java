package br.edu.univas.si5.bd2;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Cargo;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner01 {

	public static void main(String[] args) {
		
		//cria um objeto de teste
		Cargo cargo = new Cargo();
		cargo.setCodigo(7);
		cargo.setNome("QA");
		cargo.setSalario(5000f);
		
		//obter uma instância do EntityManager
		EntityManager em;
		em = HibernateUtil.getEntityManager();
		
		//persistir o objeto (dentro de uma transação)
		em.getTransaction().begin();//inicia a transação
		em.persist(cargo);
		em.getTransaction().commit();//finaliza a transação
	}
}
