package repositories;

import java.util.HashSet;

import entities.Filme;

public class FilmeRepository {

	private HashSet<Filme> filmes;
	
	public FilmeRepository() {
		this.filmes = new HashSet<Filme>();
	}
	
	public boolean addFilme(Filme filme) {	
		return this.filmes.add(filme);
	}
	
	public boolean removeFilme(Filme filme) {
		return this.filmes.remove(filme);
	}
	
	public HashSet<Filme> getFilmes(){
		return new HashSet<Filme>(this.filmes);
	}
}
