package entities;

import java.util.HashSet;

public class Filme {
	
	private String nome;
	private Diretor diretor;
	private HashSet<Ator> elenco;
	private float nota;
	
	public Filme(String nome, Diretor diretor, HashSet<Ator> elenco, float nota) {
		super();
		this.nome = nome;
		this.diretor = diretor;
		this.elenco = new HashSet<Ator>(elenco);
		this.nota = nota;
	}
	
	public Filme(Filme filme) {
		this.nome = filme.getNome();
		this.diretor = new Diretor(filme.getDiretor());
		this.elenco = filme.getElenco();
		this.nota = filme.getNota();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public HashSet<Ator> getElenco() {
		return new HashSet<Ator>(this.elenco);
	}

	public void setElenco(HashSet<Ator> elenco) {
		this.elenco = new HashSet<Ator>(elenco);
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
}
