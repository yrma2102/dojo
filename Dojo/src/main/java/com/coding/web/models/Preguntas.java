package com.coding.web.models;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "preguntas")
public class Preguntas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Por favor ingresa la pregunta")
	@Column(length = 65535, columnDefinition = "text")
	private String pregunta;
	
//	@Lob
//	private String pregunta_dos;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	
	// Relacion muchos a muchos entidad Tags
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="tags_questions",
	joinColumns= @JoinColumn(name="question_id"),
	inverseJoinColumns = @JoinColumn(name="tag_id"))
	private List<Tags> tags;
	
	//Relacion uno a muchos entidad Respuestas
	@OneToMany(mappedBy="pregunta", fetch=FetchType.LAZY)
	private List<Respuestas> respuestas;
	
	

	// Constructor
	public Preguntas() {

	}
	
	//GETTTERS Y SETTERS

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public List<Respuestas> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuestas> respuestas) {
		this.respuestas = respuestas;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PostPersist
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
