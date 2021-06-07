package br.edu.univas.si5.bd2;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Cargo;
import br.edu.univas.si5.bd2.model.Department;
import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner04 {

	public static void main(String[] args) {

		EntityManager em = HibernateUtil.getEntityManager();
		
		Cargo objCargo = em.find(Cargo.class, 7); // busca cargo com pk 1
		System.out.println("Cargo: " + objCargo);
		
		Department objDep = em.find(Department.class, 2);// busca dep com pk 1
		System.out.println("Departamento: " + objDep);
		
		Funcionario objFun = em.find(Funcionario.class, 10);// busca func com pk 1
		if (objFun == null) {
			System.out.println("Não há funcionário com código 1. objFun is null.");
		} else {
			System.out.println("Funcionario: " + objFun);
		}
	}
}
