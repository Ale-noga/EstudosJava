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

import com.NarutoProject.Naruto.Model.Vila;
import com.NarutoProject.Naruto.Repository.VilaRepository;

@RestController
@RequestMapping("/Vila")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VilaController {

	@Autowired
	private VilaRepository repository;

	@GetMapping
	public ResponseEntity<List<Vila>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Vila> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Vila> getByNome(@PathVariable String nome) {
		return repository.findAllByNomeContainingIgnoreCase(nome).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping
	public ResponseEntity<Vila> post(@RequestBody Vila vila) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(vila));
	}

	@PutMapping
	public ResponseEntity<Vila> put(@RequestBody Vila vila) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(vila));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
