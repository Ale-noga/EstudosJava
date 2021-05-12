package com.NarutoProject.Naruto.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NarutoProject.Naruto.Model.Jutsu;

@Repository
public interface JutsuRepository extends JpaRepository<Jutsu, Long> {

	Optional<Jutsu> findAllByTipoContainingIgnoreCase(String tipo);

}
