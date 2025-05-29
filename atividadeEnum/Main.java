package atividadeEnum;

public class Main {

	public static void main(String[] args) {
		
		Turma t1 = new Turma(1, "2023.1");
		Turma t2 = new Turma(1, "2024.1");
		
		Disciplina d1 = new Disciplina ("POO 1", 72);
		Disciplina d2 = new Disciplina ("POO 2", 72);
		
		Aluno a1 = new Aluno("1", "Augusto");
		Aluno a2 = new Aluno("2", "Fulano");
		
		Matricula m1 = new Matricula(t1, a1, d1);
		
		a1.listarMatriculas();
	}
}
