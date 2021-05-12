package com.NarutoProject.Naruto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NarutoProject.Naruto.Model.Ninjas;

@Repository
public interface NinjasRepository extends JpaRepository<Ninjas, Long> {

	Optional<Ninjas> findAllByNomeContainingIgnoreCase(String nome);

}
