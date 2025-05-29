package atividadeEnum;

import java.sql.Date;

public class Matricula {

	private Date dataMatricual;
	private Turma turma;
	private Status status;
	private Aluno aluno;
	private Disciplina disciplina;
	
	public Matricula(Turma turma, Aluno aluno, Disciplina disciplina) {
		super();
		this.dataMatricual = new Date(0);
		this.turma = turma;
		this.status = Status.MATRICULADO;
		this.aluno = aluno;
		this.disciplina = disciplina;
		
		aluno.adicionarMatricula(this);
	}
	
	public Date getDataMatricual() {
		return dataMatricual;
	}
	public Turma getTurma() {
		return turma;
	}
	public Status getStatus() {
		return status;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void confirmar() {
		if(status == Status.MATRICULADO || status == Status.TRANCADO) {
			status = Status.CURSANDO;
		}
	}
	
	public void trancar() {
		if(status == Status.CURSANDO) {
			status = Status.TRANCADO;
		}
	}
	
	public void aprovar() {
		if(status == Status.CURSANDO) {
			status = Status.CONCLUIDO;
		}
	}
	
	public void reprovar() {
		if(status == Status.CURSANDO) {
			status = Status.REPROVADO;
		}
	}

	@Override
	public String toString() {
		return "Matricula [dataMatricual=" + dataMatricual + ", turma=" + turma + ", status=" + status + ", aluno="
				+ aluno + ", disciplina=" + disciplina + "]";
	}
	
	
}
