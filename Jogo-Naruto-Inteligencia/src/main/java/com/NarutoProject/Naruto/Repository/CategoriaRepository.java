package com.NarutoProject.Naruto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NarutoProject.Naruto.Model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	Optional<Categoria> findAllByPosicaoContainingIgnoreCase(String posicao);
	
}
