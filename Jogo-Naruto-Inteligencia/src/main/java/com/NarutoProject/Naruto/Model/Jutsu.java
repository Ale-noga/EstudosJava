package com.NarutoProject.Naruto.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "jutsu")
public class Jutsu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 2, message = "Error Size (min = 2)")
	private String tipo;

	@NotNull
	@Size(min = 2, message = "Error Size (min = 2)")
	private String descricao;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "jutsu_dominante", joinColumns = @JoinColumn(name = "jutsu_id"), inverseJoinColumns = @JoinColumn(name = "ninjas_id"))
	@JsonIgnoreProperties("jutsu")
	private List<Ninjas> ninjas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Ninjas> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninjas> ninjas) {
		this.ninjas = ninjas;
	}

}
