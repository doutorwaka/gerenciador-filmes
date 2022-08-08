package entities;

import java.util.Objects;

public class Diretor {
	
	private String nome;

	public Diretor(String nome) {
		this.nome = nome;
	}
	
	public Diretor(Diretor diretor) {
		this.nome = diretor.getNome();
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
		Diretor other = (Diretor) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Diretor: " + nome + "\n";
	}

}
