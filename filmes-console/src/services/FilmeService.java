package services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import dto.FilmeDto;
import entities.Ator;
import entities.Diretor;
import entities.Filme;
import repositories.AtorRepository;
import repositories.DiretorRepository;
import repositories.FilmeRepository;

public class FilmeService {
	
	private FilmeRepository fr;
	private AtorRepository ar;
	private DiretorRepository dr;
	
	public FilmeService() {
		this.fr = new FilmeRepository();
		this.ar = new AtorRepository();
		this.dr = new DiretorRepository();
	}
	
	public boolean addFilme(String nome, String diretor, 
			String[] elenco, float nota) {
		
		// Adicione diretor na lista de diretores
		this.addDiretor(diretor);
		
		HashSet<Ator> atores = new HashSet<Ator>();
		
		// Adiciona atores na lista de atores e tambem
		// na lista a ser incluida no objeto filme
		for(int i = 0; i < elenco.length; i++) {
			this.addAtor( elenco[i] );
			atores.add( new Ator(elenco[i]) );
		}
		
		Filme filme = new Filme(nome, new Diretor(diretor), atores, nota);
		
		return fr.addFilme(filme);
	}
	
	public boolean addFilme(FilmeDto filmeDto) {
		return this.addFilme(filmeDto.getNome(), filmeDto.getDiretor(),
				filmeDto.getElenco(), filmeDto.getNota());
	}
	
	public List<FilmeDto> listaFilmesPorNome(){
		List<Filme> filmesFiltrados = new ArrayList<Filme>(
				this.fr.getFilmes() );
		
		filmesFiltrados.sort((o1, o2) -> {
				return o1.getNome().compareTo(o2.getNome());
		});
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	public List<FilmeDto> listaFilmesPorDiretor(String diretor){
		
		ArrayList<Filme> filmesFiltrados = new ArrayList<Filme>();
		
		HashSet<Filme> filmes = this.fr.getFilmes();
		
		Iterator<Filme> i = filmes.iterator();
		
		while(i.hasNext()) {
			Filme f = i.next();
			
			if(f.getDiretor().getNome().equals(diretor)) {
				filmesFiltrados.add(new Filme(f));
			}
		}
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	public List<FilmeDto> listaFilmesPorAtor(String ator){
		
		ArrayList<Filme> filmesFiltrados = new ArrayList<Filme>();
		
		HashSet<Filme> filmes = this.fr.getFilmes();
		
		Iterator<Filme> i = filmes.iterator();
		
		while(i.hasNext()) {
			Filme f = i.next();
			
			Iterator<Ator> j = f.getElenco().iterator();
			
			while(j.hasNext()) {				
				Ator a = j.next();
				
				if(a.getNome().equals(ator)) {
					filmesFiltrados.add(new Filme(f));
					break;
				}				
			}
		}
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	public List<FilmeDto> listaFilmesPorNota(float nota){
		ArrayList<Filme> filmesFiltrados = new ArrayList<Filme>();
		
		HashSet<Filme> filmes = this.fr.getFilmes();
		
		for(Filme f : filmes) {
			if(f.getNota() >= nota)
				filmesFiltrados.add(f);
		}
		
		return converteListaFilmeParaDto(filmesFiltrados);
	}
	
	private List<FilmeDto> converteListaFilmeParaDto(List<Filme> filmes){
		List<FilmeDto> filmesDto = new ArrayList<FilmeDto>();
		
		for(Filme f : filmes) {
			filmesDto.add(new FilmeDto(f));
		}
		
		return filmesDto;		
	}
	
	public boolean addAtor(String nome) {
		return this.ar.addAtor(new Ator(nome));
	}
	
	public boolean removeAtor(String nome) {
		return this.ar.removeAtor(new Ator(nome));
	}
	
	public Ator getAtor(String nome) {
		return ar.getAtor(nome);
	}
	
	public ArrayList<String> listaAtores(){
		HashSet<Ator> atoresArray = this.ar.getAtores();	
		
		ArrayList<String> atores = new ArrayList<>();
		
		for(Ator a : atoresArray)
			atores.add(a.getNome());
		
		return atores;
	}
	
	public boolean addDiretor(String nome) {
		return this.dr.addDiretor(new Diretor(nome));
	}
	
	public boolean removeDiretor(String nome) {
		return this.dr.removeDiretor(new Diretor(nome));
	}
	
	public ArrayList<String> listaDiretores(){
		
		HashSet<Diretor> diretoresArray = this.dr.getDiretores();
		
		ArrayList<String> diretores = new ArrayList<String>();
		
		for(Diretor d : diretoresArray)
			diretores.add(d.getNome());
		
		return diretores;
	}
}
