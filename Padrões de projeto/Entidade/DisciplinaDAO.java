package Entidade;
import java.util.List;
public interface DisciplinaDAO {
	void insert(Disciplina obj);
    void update(Disciplina obj);
    void deleteById(int id);
    Disciplina findById(int id);
    List<Disciplina> findAll();
}
