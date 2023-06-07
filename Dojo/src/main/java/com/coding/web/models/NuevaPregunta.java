package com.coding.web.models;

import jakarta.validation.constraints.NotEmpty;

public class NuevaPregunta {
	@NotEmpty
	private String pregunta;
	@NotEmpty
	 private String tags;
	 
	 
	 public NuevaPregunta() {
		 
	 }
	 
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	 
}
