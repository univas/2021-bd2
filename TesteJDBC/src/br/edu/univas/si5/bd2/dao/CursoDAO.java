package br.edu.univas.si5.bd2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.univas.si5.bd2.model.Curso;

public class CursoDAO {

	// informa√ß√µes para conectar no banco
	private String url = "jdbc:postgresql://localhost/bd2"; // usar o padr√£o do JDBC para o Postgres
	private String user = "bd2"; // boa pr·tica: o usu·rio senha n„o se coloca fixo no cÛdigo
	private String pass = "aluno12"; // e nem faz commit de usu·rio e senha.

	public void save(Curso curso) {

		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String insert = "insert into curso (sigla, nome) values (?, ?)";

			PreparedStatement st = conn.prepareStatement(insert);
			st.setInt(1, curso.getSigla()); // o √≠ndice come√ßa com 1
			st.setString(2, curso.getNome());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Curso curso) {
		//similar ao insert
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String update = "update curso set nome = ? where sigla = ?";

			PreparedStatement st = conn.prepareStatement(update);
			st.setString(1, curso.getNome());
			st.setInt(2, curso.getSigla());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int sigla) {
		//similar ao insert
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String delete = "delete from curso where sigla = ?";

			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, sigla);

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Curso findById(int sigla) {
		
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {

			String select = "select nome from curso where sigla = ?";

			PreparedStatement st = conn.prepareStatement(select);
			st.setInt(1, sigla); // o √≠ndice come√ßa com 1
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

	public List<Curso> findAll() {
		
		String select = "select sigla, nome from curso";
		List<Curso> cursos = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, user, pass);) {
			
			PreparedStatement st = conn.prepareStatement(select);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) { //navega nas tupla (linhas) do resultado do select
				//cria um objeto curso
				Curso curso = new Curso();
				
				//busca as infomaÁıes do curso e seta no objeto
				curso.setSigla(rs.getInt("sigla"));
				curso.setNome(rs.getString("nome"));
				//adiciona o curso na lista
				cursos.add(curso);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}
}
