package EscolaDeIdiomas;

public class Main{
	public static void main(String[] args){
		Turma turma = new Turma(1,2,4, 4);

		turma.cadastrarAlunoNaTurma("Thiago b");
		Aluno a = turma.getAluno("Thiago b");
		System.out.println(a.getNome());
		turma.cadastrarAlunoNaTurma("Camila d");
		turma.cadastrarAlunoNaTurma("Jorge  j");
		turma.cadastrarAlunoNaTurma("Thiago a");
		
		turma.gerarRelatorioDaTurma();
	}
}
