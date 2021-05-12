package com.NarutoProject.Naruto.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "vila")
public class Vila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 2, message = "Error Size (min = 2)")
	private String nome;

	@NotNull
	@Size(min = 2, message = "Error Size (min = 2)")
	private String pais;

	@OneToMany(mappedBy = "vila", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("vila")
	private List<Ninjas> ninjas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Ninjas> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninjas> ninjas) {
		this.ninjas = ninjas;
	}

}
