package com.NarutoProject.Naruto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NarutoProject.Naruto.Model.Vila;

@Repository
public interface VilaRepository extends JpaRepository<Vila, Long> {

	Optional<Vila> findAllByNomeContainingIgnoreCase(String nome);

}
