package br.edu.univas.si5.bd2;

import java.util.Set;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Cargo;
import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner13 {

	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();

		// buscar o cargo
		Integer cargoPk = 5;
		Cargo cargo = em.find(Cargo.class, cargoPk);
		if (cargo != null) {
			// imprimir o cargo
			System.out.println(cargo);

			// obter os funcionários daquele cargo
			Set<Funcionario> funs = cargo.getFuncionarios();

			// imprimir os funcionários
			for (Funcionario fun : funs) {
				System.out.println(fun);
			}
		} else {
			System.out.println("Cargo " + cargoPk + " não encontrado.");
		}
	}
}
