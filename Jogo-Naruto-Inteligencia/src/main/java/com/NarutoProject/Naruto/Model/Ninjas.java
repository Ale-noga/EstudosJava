package com.NarutoProject.Naruto.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ninjas")
public class Ninjas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 2, message = "Error Size (min = 2)")
	private String nome;

	@NotNull
	private Long level;

	@NotNull
	private Long atk;

	@NotNull
	private Long def;

	@NotNull
	private Long intel;

	@ManyToOne
	@JsonIgnoreProperties("ninjas")
	private Vila vila;

	@ManyToMany(mappedBy = "ninjas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("ninjas")
	private List<Jutsu> jutsu = new ArrayList<>();
	
	@ManyToMany(mappedBy = "ninjas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("ninjas")
	private List<Categoria> categoria = new ArrayList<>();

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

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getAtk() {
		return atk;
	}

	public void setAtk(Long atk) {
		this.atk = atk;
	}

	public Long getDef() {
		return def;
	}

	public void setDef(Long def) {
		this.def = def;
	}

	public Long getIntel() {
		return intel;
	}

	public void setIntel(Long intel) {
		this.intel = intel;
	}

	public Vila getVila() {
		return vila;
	}

	public void setVila(Vila vila) {
		this.vila = vila;
	}

	public List<Jutsu> getJutsu() {
		return jutsu;
	}

	public void setJutsu(List<Jutsu> jutsu) {
		this.jutsu = jutsu;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	
}
