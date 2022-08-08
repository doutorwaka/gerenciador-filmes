package dto;

import java.util.HashSet;

import entities.Ator;
import entities.Filme;

public class FilmeDto {
	
	private String nome;
	private String diretor;
	private String elenco[];
	private float nota;
	
	public FilmeDto(String nome, String diretor, String elenco[], float nota) {
		this.nome = nome;
		this.diretor = diretor;		
		this.nota = nota;
		
		this.elenco = new String[elenco.length];
		
		for(int i = 0; i < elenco.length; i++) {
			this.elenco[i] = elenco[i];
		}
	}
	
	public FilmeDto(FilmeDto filme) {
		this(filme.getNome(), filme.getDiretor(), 
				filme.getElenco(), filme.getNota());
	}
	
	public FilmeDto(Filme filme) {
		
		this.nome = filme.getNome();
		this.diretor = filme.getDiretor().getNome();
		this.nota = filme.getNota();
		
		HashSet<Ator> atores = filme.getElenco();
		
		String atoresNomes[] = new String[atores.size()];
		
		int i = 0;
		
		for(Ator a : atores) {
			atoresNomes[i] = a.getNome();
			i++;
		}
		
		this.elenco = atoresNomes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public String[] getElenco() {		
		String elenco[] = new String[this.elenco.length];
		
		for(int i = 0; i < this.elenco.length; i++)
			elenco[i] = this.elenco[i];
		
		return elenco;
	}

	public void setElenco(String elenco[]) {
		this.elenco = new String[elenco.length];
		
		for(int i = 0; i < elenco.length; i++)
			this.elenco[i] = elenco[i];
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}
	
	public String toString() {
		String s = "";
		
		s += "  Nome: " + this.nome + "\n";
		s += "  Diretor: " + this.diretor + "\n";
		s += "  Elenco: \n";
		
		for(String e : this.elenco) {
			s += "    " + e + "\n";
		}
		
		s += "  Nota: " + this.nota + "\n";
		
		return s;
	}
	
	public boolean validate() {
		
		if(this.nome == "" || this.nome == null)
			return false;
		else if(this.diretor == "" || this.diretor == null)
			return false;
		else if(this.elenco == null || this.elenco.length == 0)
			return false;
		else if(this.nota < 0)
			return false;
		
		return true;
	}
}

