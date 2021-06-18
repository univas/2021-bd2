package br.edu.univas.si5.bd2;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Cargo;
import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner12 {

	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();

		// buscar o funcionário - usar find
		Integer funFk = 14;
		Funcionario fun = em.find(Funcionario.class, funFk);
		if (fun != null) {
			// testar com fetch default
			// imprimir o funcionário
			System.out.println(fun);

			// obter/buscar o cargo deste funcionário
			Cargo cargo = fun.getCargo();
			// imprimir o cargo
			System.out.println(cargo);
		} else {
			System.out.println("Funcionario " + funFk + " não encontrado.");
		}
	}
}
