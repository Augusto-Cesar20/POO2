package Entidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DB.DB;

public class CursoDAOImp implements CursoDAO {

	@Override
	public void insert(Curso obj) throws SQLException  {
		// TODO Auto-generated method stub
		Connection cnx = DB.getConexao();
		PreparedStatement pst = null;
		String sql = "INSERT INTO curso (nomeCurso) VALUES (?)";

		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, obj.getNomeCurso());

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			pst.close();
		}
	}

	@Override
	public void update(Curso obj) throws SQLException {
		// TODO Auto-generated method stub
		Connection cnx = DB.getConexao();
		PreparedStatement pst = null;
		String sql = "UPDATE curso " + "   SET nomeCurso = ?" + "   WHERE id = ?";
		try {
			pst = cnx.prepareStatement(sql);
			pst.setString(1, obj.getNomeCurso());
			pst.setInt(2, obj.getIdCurso());
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			pst.close();
		}
	}

	@Override
	public void deleteById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection cnx = DB.getConexao();
		PreparedStatement pst = null;
		String sql = "DELETE FROM curso WHERE id = ?";

		try {
			pst = cnx.prepareStatement(sql);
			pst.setInt(1, id);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			pst.close();
		}
	}

	@Override
	public Curso findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection cnx = DB.getConexao();
		List<Curso> cursos = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;

		try {

			st = cnx.createStatement();
			rs = st.executeQuery("SELECT * FROM curso");
			while (rs.next()) {
				Curso c = new Curso(rs.getInt("idCurso"), rs.getString("nomeCurso"));
				cursos.add(c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
		}
		
		return cursos;
	}

}
