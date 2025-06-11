package Entidade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDaoImp implements DisciplinaDAO {

    private Connection conn;

    public DisciplinaDaoImp() {
        conn = DB.getConexao(); // Usa a classe DB do diagrama
    }

    @Override
    public void insert(Disciplina obj) {
        String sql = "INSERT INTO disciplina (nomedisciplina, cargahoraria) VALUES (?, ?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, obj.getNomeDisciplina());
            st.setInt(2, obj.getCargaHoraria());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Disciplina obj) {
        String sql = "UPDATE disciplina SET nomedisciplina = ?, cargahoraria = ? WHERE iddisciplina = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, obj.getNomeDisciplina());
            st.setInt(2, obj.getCargaHoraria());
            st.setInt(3, obj.getIdDisciplina());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM disciplina WHERE iddisciplina = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Disciplina findById(int id) {
        String sql = "SELECT * FROM disciplina WHERE iddisciplina = ?";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Disciplina(
                    rs.getInt("iddisciplina"),
                    rs.getString("nomedisciplina"),
                    rs.getInt("cargahoraria")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Disciplina> findAll() {
        List<Disciplina> list = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Disciplina d = new Disciplina(
                    rs.getInt("iddisciplina"),
                    rs.getString("nomedisciplina"),
                    rs.getInt("cargahoraria")
                );
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
