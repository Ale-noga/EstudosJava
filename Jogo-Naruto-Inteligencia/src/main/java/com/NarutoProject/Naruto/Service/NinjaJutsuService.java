package com.NarutoProject.Naruto.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NarutoProject.Naruto.Model.Categoria;
import com.NarutoProject.Naruto.Model.Jutsu;
import com.NarutoProject.Naruto.Model.Ninjas;
import com.NarutoProject.Naruto.Repository.CategoriaRepository;
import com.NarutoProject.Naruto.Repository.JutsuRepository;
import com.NarutoProject.Naruto.Repository.NinjasRepository;

@Service
public class NinjaJutsuService {
	
	@Autowired
	private NinjasRepository repositoryNinja;
	@Autowired
	private JutsuRepository repositoryJutsu;
	@Autowired
	private CategoriaRepository repositoryCategoria;
	
	public Ninjas novoNinjaCategoria(Long idNinja, Long idCategoria) {
		Optional<Ninjas> ninjas = repositoryNinja.findById(idNinja);
		Optional<Categoria> categoria = repositoryCategoria.findById(idCategoria);

			if(ninjas.isPresent()&&categoria.isPresent()) {
			ninjas.get().getCategoria().add(categoria.get());
			repositoryNinja.save(ninjas.get());
			categoria.get().getNinjas().add(ninjas.get());
			repositoryCategoria.save(categoria.get());
		}
		
		return repositoryNinja.findById(idNinja).get();
	}
	
	public Ninjas novoJustuDominante(Long idNinja, Long idJutsu) {
		Optional<Ninjas> ninjas = repositoryNinja.findById(idNinja);
		Optional<Jutsu> jutsu = repositoryJutsu.findById(idJutsu);
		
		if(ninjas.isPresent()&&jutsu.isPresent()) {
			jutsu.get().getNinjas().add(ninjas.get());
			repositoryJutsu.save(jutsu.get());
		}
		
		return repositoryNinja.findById(idNinja).get();
		
	}
	
	
	public Long posicaoNinja(Long level) {
		Long posicao = (long) 0;
		if(level>=0&&level<25) {
			posicao = (long) 1;
		}
		if(level>=25&&level<40) {
			posicao = (long) 2;
		}
		if(level>=40&&level<60) {
			posicao = (long) 3;
		}
		if(level>=60&&level<75) {
			posicao = (long) 4;
		}
		if(level>=75) {
			posicao = (long) 5;
		}
		
		return posicao;
		
	}
	

	public Ninjas novoNinja(Ninjas ninjas) {
		return repositoryNinja.save(ninjas);
	}
	
	
	public Jutsu novoJutsu(Jutsu jutsu) {
		return repositoryJutsu.save(jutsu);
	}
	
	
	
		
}
