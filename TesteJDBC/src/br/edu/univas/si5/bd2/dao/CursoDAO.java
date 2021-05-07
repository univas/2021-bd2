package br.edu.univas.si5.bd2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.univas.si5.bd2.model.Curso;

public class CursoDAO {

	// informações para conectar no banco
	private String url = "jdbc:postgresql://localhost/bd2"; // usar o padrão do JDBC para o Postgres
	private String user = "bd2";
	private String pass = "aluno12";

	public void save(Curso curso) {

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String insert = "insert into curso (sigla, nome) values (?, ?)";

			PreparedStatement st = conn.prepareStatement(insert);
			st.setInt(1, curso.getSigla()); // o índice começa com 1
			st.setString(2, curso.getNome());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Curso curso) {
		//similar ao insert
		//TODO: implementar e testar o update
	}

	public void delete(Curso curso) {
		//similar ao insert
		//TODO: implementar e testar o delete
	}

	public Curso findById(int sigla) {
		
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String select = "select nome from curso where sigla = ?";

			PreparedStatement st = conn.prepareStatement(select);
			st.setInt(1, sigla); // o índice começa com 1
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				Curso curso = new Curso();
				curso.setSigla(sigla);
				curso.setNome(rs.getString("nome"));
				return curso;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
