package controllers;

import java.util.List;

import dto.FilmeDto;
import services.FilmeService;

public class FilmeController {
	
	private FilmeService fs;
	
	public FilmeController() {
		this.fs = new FilmeService();
	}
	
	public boolean addFilme(FilmeDto filmeDto) {
		
		if(!filmeDto.validate())
			return false;
		
		return fs.addFilme(filmeDto);		
	}
	
	public List<FilmeDto> listaFilmesPorNome(){
		return fs.listaFilmesPorNome();
	}
	
	public List<FilmeDto> listaFilmesPorDiretor(String diretor){
		return fs.listaFilmesPorDiretor(diretor);
	}
	
	public List<FilmeDto> listaFilmesPorAtor(String ator){
		return fs.listaFilmesPorAtor(ator);
	}
	
	public List<FilmeDto> listaFilmesPorNota(float nota){
		return fs.listaFilmesPorNota(nota);
	}
	
	public List<String> listaAtores(){
		return fs.listaAtores();
	}
	
	public List<String> listaDiretores() {
		return fs.listaDiretores();
	}
	
	
}
