package EscolaDeIdiomas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AlunoTest {
	
	Aluno aluno;
	
	@BeforeEach
	public void init()
	{
		aluno = new Aluno("placeholder","142", 4);
		
	}
	@Test
	public void testeCriacaoAluno()
	{
		assertNotEquals(null, aluno);
	}
	@Test
	public void testeCadastrarFalta() {
		aluno.cadastrarFalta();
		assertEquals(95,aluno.getFrequencia());
	}
	@Test
	public void testeFrequenciaNegativa() {
		for(int i = 1; i<=21; i++) {
			aluno.cadastrarFalta();
		}
		assertEquals(0,aluno.getFrequencia());
	}
	@Test
	public void testeAvaliarAtividades() {
		aluno.avaliarAtividade(1,15);

		assertEquals(15,aluno.getAtividades()[1]);
	}
	@Test
	public void testeLimiteNota() {
		aluno.avaliarAtividade(1,-50);
		
		assertEquals(0, aluno.getAtividades()[1]);
	}
	public void testeReceberMedia() {
		aluno.avaliarAtividade(1,50);
		aluno.avaliarAtividade(2,30);
		aluno.avaliarAtividade(3,100);
		aluno.avaliarAtividade(4,60);
		
		assertEquals(60,aluno.getMedia());
	}
	public void testeCalculoDeAprovacao() {
		aluno.avaliarAtividade(1,50);
		aluno.avaliarAtividade(2,30);
		aluno.avaliarAtividade(3,100);
		aluno.avaliarAtividade(4,60);
		
		assertTrue(aluno.isAprovado());
	}
	public void testeReprovacaoPorMedia() {
		aluno.avaliarAtividade(1,10);
		aluno.avaliarAtividade(2,20);
		aluno.avaliarAtividade(3,30);
		aluno.avaliarAtividade(4,60);
		
		assertFalse(aluno.isAprovado());
	}
	public void testeReprovacaoPorFrequencia() {
		for(int i = 1; i <= 6; i++) {
			aluno.cadastrarFalta();
		}
		assertFalse(aluno.isAprovado());
	}
}