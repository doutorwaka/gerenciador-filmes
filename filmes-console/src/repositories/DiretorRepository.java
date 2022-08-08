package repositories;

import java.util.HashSet;
import java.util.Iterator;

import entities.Diretor;

public class DiretorRepository {

private HashSet<Diretor> diretores;
	
	public DiretorRepository() {
		this.diretores = new HashSet<Diretor>();
	}
	
	public boolean addDiretor(Diretor diretor) {
		return this.diretores.add(diretor);
	}
	
	public boolean removeDiretor(Diretor diretor) {
		return this.diretores.remove(diretor);
	}
	
	public HashSet<Diretor> getDiretores(){
		return new HashSet<Diretor>(diretores);
	}
	
	public Diretor getDiretor(String nome) {		
		Diretor diretor = null;
		
		Iterator<Diretor> iterator = diretores.iterator();
		
		for(Diretor d = null; iterator.hasNext(); d = iterator.next()) {
			
			if(d.getNome().equals(nome)) {
				diretor = new Diretor(d);
				break;
			}
			
		}
		
		return diretor;			
	}
}
