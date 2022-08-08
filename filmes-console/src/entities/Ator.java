package entities;

import java.util.Objects;

public class Ator {

	private String nome;
	
	public Ator(String nome) {
		this.nome = nome;
	}
	
	public Ator(Ator ator) {
		this.nome = ator.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ator other = (Ator) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Ator: " + nome + "\n";
	}
	
}
