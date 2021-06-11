package br.edu.univas.si5.bd2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.si5.bd2.model.Cargo;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner08 {

	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();
		
		float salario = 7000f;
		String ql = "select c from Cargo c where c.salario > :filtro_salario";
		
		TypedQuery<Cargo> query = em.createQuery(ql, Cargo.class);
		query.setParameter("filtro_salario", salario); //seta o filtro de salário

		List<Cargo> cargos = query.getResultList();
		System.out.println("Cargos: " + cargos); // imprimir os cargos
	}

}
