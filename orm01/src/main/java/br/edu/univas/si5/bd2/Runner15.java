package br.edu.univas.si5.bd2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.si5.bd2.model.Cargo;
import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner15 {

	public static void main(String[] args) {
		EntityManager em = HibernateUtil.getEntityManager();
		//parte 1
		//consultar os funcionarios ativos do cargo QA
		//precisa inserir pelo menos um funcionario ativo QA
		
		String cargoName = "QA";
		String ql = "select f from Funcionario f where f.usuario.active = true AND f.cargo.nome = :nome_cargo";
		TypedQuery<Funcionario> query = em.createQuery(ql, Funcionario.class);
		query.setParameter("nome_cargo", cargoName);
		List<Funcionario> funcionarios = query.getResultList();
		
		System.out.println(funcionarios);
		
		//parte 2
		//consultar os cargos que possuem funcionários ativos
		//String qlCargos = "select c from Cargo c where c.funcionarios.usuario.active = true";//não navega do lado 1 para muitos
		String qlCargos = "select distinct f.cargo from Funcionario f where f.usuario.active = true";
		TypedQuery<Cargo> queryCargo = em.createQuery(qlCargos, Cargo.class);
		List<Cargo> cargos = queryCargo.getResultList();
		System.out.println(cargos);
	}

}
