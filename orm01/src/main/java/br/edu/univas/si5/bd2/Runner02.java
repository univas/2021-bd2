package br.edu.univas.si5.bd2;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Department;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner02 {

	public static void main(String[] args) {
		Department dep = new Department();
		//vendas.setCode(???);//não pode setar o código, pq o campo é auto-incremento
		dep.setName("Expedição");
		
		//obter uma instância do EntityManager
		EntityManager em;
		em = HibernateUtil.getEntityManager();
		
		//persistir o objeto (dentro de uma transação)
		em.getTransaction().begin();//inicia a transação
		em.persist(dep);
		em.getTransaction().commit();//finaliza a transação
		
		System.out.println("Código gerado pelo auto-incremento: " + dep.getCode());
	}
}
