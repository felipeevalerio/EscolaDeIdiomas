package EscolaDeIdiomas;

public class Aluno{
	
	private String nome;
	
	private float atividades[];
	private float media;
	
	private boolean aprovado;
	
	private String codigoDaTurma;
	
	private int frequencia;
	private int numeroDeAtividades;
	private int notaMaximaAtividade;

	private final int VALOR_MINIMO_PARA_APROVACAO = 60;
	private final int FREQUENCIA_MINIMA_PARA_APROVACAO = 75;
	private final int VALOR_MAXIMO_NOTA = 100;
	
	Aluno(String nome, String codigoDaTurma, int numeroDeAtividades){
		this.nome = nome;
		this.aprovado = false;
		this.codigoDaTurma = codigoDaTurma;
		this.frequencia = 100;
		this.numeroDeAtividades = numeroDeAtividades;
		this.atividades = new float[numeroDeAtividades];
		this.notaMaximaAtividade = VALOR_MAXIMO_NOTA / numeroDeAtividades;
		this.media = 0;
	}
	
	public void cadastrarFalta() {
		if (frequencia > 0) {
			this.frequencia -= 5;
			atualizarAprovacao();
		}
	}

	public void avaliarAtividade(int numeroDaAtividade, float nota) {
		if (verificarSeNotaEValida(nota)) {
			setValorAtividade(numeroDaAtividade, nota);
		}
	}

	private boolean verificarSeNotaEValida(float nota) {
		return nota >= 0 && nota < notaMaximaAtividade;
	}

	private void setValorAtividade(int numeroDaAtividade, float valor) {
		atividades[numeroDaAtividade - 1] = valor;
	}

	public String getNome(){
		return nome;
	}

	public int getFrequencia(){
		return frequencia;
	}

	public String getCodigoDaTurma() {
		return codigoDaTurma;
	}

	public float[] getAtividades() {
		return atividades;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}

	private void atualizarMedia() {
		float somaDasAtividades = 0;
		
		for (int i = 0; i < numeroDeAtividades; i++) {
			somaDasAtividades += atividades[i];
		}
		
		this.media = somaDasAtividades / numeroDeAtividades;
		atualizarAprovacao();
	}

	public boolean isAprovado() {
		return aprovado;
	}
	
	private void setAprovado(boolean aprovacao) {
		this.aprovado = aprovacao;
	}
	
	public String printAlunoAprovado() {
		return isAprovado() ? "Aprovado" : "Não Aprovado";
	}

	private void atualizarAprovacao() {
		boolean alunoEstaAprovado = media >= VALOR_MINIMO_PARA_APROVACAO && 
									frequencia >= FREQUENCIA_MINIMA_PARA_APROVACAO;

		setAprovado(alunoEstaAprovado);
	}	
}