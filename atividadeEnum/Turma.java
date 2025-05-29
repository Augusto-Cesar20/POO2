package atividadeEnum;

import java.util.Objects;

public class Turma {
	
	private int id;
	private String nome;

	public Turma(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", nome=" + nome + "]";
	}
}
