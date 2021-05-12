package com.NarutoProject.Naruto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NarutoProject.Naruto.Model.Categoria;
import com.NarutoProject.Naruto.Model.Ninjas;
import com.NarutoProject.Naruto.Repository.NinjasRepository;
import com.NarutoProject.Naruto.Service.NinjaJutsuService;

@RestController
@RequestMapping("/Ninjas")
@CrossOrigin("*")
public class NinjasController {

	@Autowired
	private NinjasRepository repository;

	@Autowired
	private NinjaJutsuService services;

	@GetMapping
	public ResponseEntity<List<Ninjas>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Ninjas> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Ninjas> getByNome(@PathVariable String nome) {
		return repository.findAllByNomeContainingIgnoreCase(nome).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Ninjas> post(@RequestBody Ninjas ninjas) {
		Long idNinja = services.novoNinja(ninjas).getId();
		Long posicao = services.posicaoNinja(ninjas.getLevel());
		return new ResponseEntity<Ninjas>(services.novoNinjaCategoria(idNinja, posicao), HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<Ninjas> put(@RequestBody Ninjas ninjas) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(ninjas));

	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
