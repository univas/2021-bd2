package br.edu.univas.si5.bd2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.univas.si5.bd2.model.Funcionario;
import br.edu.univas.si5.bd2.utils.HibernateUtil;

public class Runner14 {

	public static void main(String[] args) {
		
		EntityManager em = HibernateUtil.getEntityManager();
		//Consulta para trazer todos os funcionários ativos
		//SQL nativa
		//select f.* from Funcionario f join Usuario u on u.username = f.usuario_fk where u.active = true
		
		//montar uma consulta orientada a objeto, usando as nossas classes/objetos
		//nossa consulta agora não será nativa
		
		String ql = "select f from Funcionario f where f.usuario.active = true";
		
		TypedQuery<Funcionario> query = em.createQuery(ql, Funcionario.class);
		List<Funcionario> list = query.getResultList();
		
		System.out.println(list);
	}
}
