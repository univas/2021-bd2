package br.edu.univas.si5.bd2;

import javax.persistence.EntityManager;

import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.model.Usuario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner10 {

	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();

		// buscar um funcionario (usar o find)
		Integer funPk = 14;
		Funcionario fun = em.find(Funcionario.class, funPk);

		// imprime o funcionario
		System.out.println(fun);

		// buscar um usuário do funcionario consultado anteriormente ***
		Usuario user = fun.getUsuario();
		// imprime o usuário
		System.out.println(user);
	} 
	
	public static void mainUm(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();

		// buscar um usuário - usar o find
		String userPk = "jane";
		Usuario user = em.find(Usuario.class, userPk);

		// imprime o usuário
		System.out.println(user);

		// buscar um funcionario do usuário consultado anteriormente ***
		Funcionario fun = user.getFuncionario();
		// imprime o funcionario
		System.out.println(fun);
	}

}
