package EscolaDeIdiomas;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TurmaTest {
	Turma turma;
	
	@BeforeEach
	public void init()
	{
		turma = new Turma(1,4,2,4);
		
	}
	@Test
	public void testeCriacaoDeTurma()
	{
		assertNotEquals(null, turma);
	}
	@Test
	public void testeContabilizandoQuantidade() {
		turma.cadastrarAlunoNaTurma("Thiago");
		assertEquals(1,turma.getQuantidadeDeAlunos());
		
	}
	@Test
	public void testeGerarMediaTurma() {
		turma.cadastrarAlunoNaTurma("Thiago");
		
		turma.alunos[0].avaliarAtividade(1,20);
		turma.alunos[0].avaliarAtividade(2,10);
		turma.alunos[0].avaliarAtividade(3,15);//16,25
		turma.alunos[0].avaliarAtividade(4,20);
		
		assertEquals(13.5,turma.getMediaNota());
	}
	@Test
	public void testeGerarMediaFrequenciaTurma() {
		turma.cadastrarAlunoNaTurma("Thiago");//frequencia = 85
		turma.cadastrarAlunoNaTurma("Marcio");//frequencia = 90
		turma.cadastrarAlunoNaTurma("Camila");//frequencia = 95
		
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[2].cadastrarFalta();
		
		
		assertEquals(90,turma.getMediaFrequencia());
	}
	@Test
	public void testeDescobrirMelhorMediaFrequencia() {
		turma.cadastrarAlunoNaTurma("Thiago");//frequencia = 85
		turma.cadastrarAlunoNaTurma("Marcio");//frequencia = 90
		turma.cadastrarAlunoNaTurma("Camila");//frequencia = 95
		
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[0].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[1].cadastrarFalta();
		turma.alunos[2].cadastrarFalta();
		
		turma.alunos[0].avaliarAtividade(1,20);
		turma.alunos[0].avaliarAtividade(2,10);
		turma.alunos[0].avaliarAtividade(3,15);//16,25
		turma.alunos[0].avaliarAtividade(4,20);
		
		turma.alunos[1].avaliarAtividade(1,10);
		turma.alunos[1].avaliarAtividade(2,10);
		turma.alunos[1].avaliarAtividade(3,05);//11,25
		turma.alunos[1].avaliarAtividade(4,20);
		
		turma.alunos[2].avaliarAtividade(1,20);
		turma.alunos[2].avaliarAtividade(2,18);
		turma.alunos[2].avaliarAtividade(3,20);//16,25
		turma.alunos[2].avaliarAtividade(4,07);
		
		
		assertEquals("Camila",turma.getMelhorAluno());
	}
	@Test
	public void ordenandoPorOrdemAlfabetica() {
		turma.cadastrarAlunoNaTurma("Thiago");
		turma.cadastrarAlunoNaTurma("Marcio");
		turma.cadastrarAlunoNaTurma("Camila");
		
		turma.gerarRelatorioDaTurma();
		
		assertEquals("Camila",turma.alunos[0].getNome());
		assertEquals("Marcio",turma.alunos[1].getNome());
		assertEquals("Thiago",turma.alunos[2].getNome());
	}
	
}