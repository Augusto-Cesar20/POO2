package atividadeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aluno {
	
	private String cpf;
	private String nome;
	private List<Matricula> matriculas;
	
	public Aluno(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.matriculas = new ArrayList<>();
	}

	public void adicionarMatricula(Matricula matricula) {
		if(matricula != null && !matriculas.contains(matricula)) {
			matriculas.add(matricula);
		}
	}
	
	public void removerMatricula(Matricula matricula) {
		if(matricula != null && matriculas.contains(matricula)) {
			matriculas.remove(matricula);
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(nome, other.nome);
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	
	public void listarMatriculas() {
		if(matriculas.isEmpty()) {
			System.out.println("Aluno não tem matricula!");
		} else {
			System.out.println("Aluno: " + nome);
			for(Matricula m : matriculas) {
				System.out.println(m.toString());
			}
		}
	}

	@Override
	public String toString() {
		return "Aluno [cpf=" + cpf + ", nome=" + nome + ", matriculas=" + matriculas + "]";
	}
}
