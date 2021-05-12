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

import com.NarutoProject.Naruto.Model.Jutsu;
import com.NarutoProject.Naruto.Model.Ninjas;
import com.NarutoProject.Naruto.Repository.JutsuRepository;
import com.NarutoProject.Naruto.Service.NinjaJutsuService;

@RestController
@RequestMapping("/Jutsu")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JutsuController {

	@Autowired
	private JutsuRepository repository;
	
	@Autowired
	private NinjaJutsuService services;

	@GetMapping
	public ResponseEntity<List<Jutsu>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Jutsu> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<Jutsu> getAllByNome(@PathVariable String tipo) {
		return repository.findAllByTipoContainingIgnoreCase(tipo).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping("/{id_ninja}/novo")
	public ResponseEntity<Ninjas> post(@RequestBody Jutsu jutsu, @PathVariable(value = "id_ninja") Long idNinja) {
		Long idJutsu = services.novoJutsu(jutsu).getId();
		return new ResponseEntity<Ninjas>(services.novoJustuDominante(idJutsu, idNinja),HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Jutsu> put(@RequestBody Jutsu jutsu) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(jutsu));
	}

	@DeleteMapping
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
