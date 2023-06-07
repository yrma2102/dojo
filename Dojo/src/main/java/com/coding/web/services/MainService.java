package com.coding.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coding.web.models.NuevaPregunta;
import com.coding.web.models.Preguntas;
import com.coding.web.models.Respuestas;
import com.coding.web.models.Tags;
import com.coding.web.repositories.IPreguntasRepository;
import com.coding.web.repositories.IRespuestasRepository;
import com.coding.web.repositories.ITagsRepository;

@Service
public class MainService {

	//Inyeccion Dependencias
	@Autowired
	private IPreguntasRepository preguntasRepo;
	@Autowired
	private ITagsRepository tagRepo;
	@Autowired
	private IRespuestasRepository respuestaRepo;
	
	
	//Servicios PREGUNTAS
	public void crearPregunta(NuevaPregunta nuevapregunta) {
		//obtener lista de tags;
		String[] lista_Tags = nuevapregunta.getTags().trim().split(",");
		//crear tag si no existe y agregarlos a la lista
		List<Tags> tags_q = new ArrayList<Tags>();
		for (String i : lista_Tags) {
			  Tags tag_old = tagRepo.getBySubject(i);
			 if(tag_old == null) {
				 tagRepo.save(new Tags(i));
				 tag_old = tagRepo.getBySubject(i);
			 }
			 tags_q.add(tag_old);
		}
		
		
		Preguntas pregunta = new Preguntas();
		pregunta.setPregunta(nuevapregunta.getPregunta());
		pregunta.setTags(tags_q);
		preguntasRepo.save(pregunta);
	}
	
	public List<Preguntas> allQuestions() {
		return preguntasRepo.findAll();
	}
	
	public Tags findTagBySubject(String subject) {
		return tagRepo.getBySubject(subject);
	}
	
	public Tags findTagByid(Long id) {
		return tagRepo.findById(id).orElse(null);
	}
	
	public Preguntas findPreguntaByid(Long id) {
		return preguntasRepo.findById(id).orElse(null);
	}
	
	public void crearRespuesta(Respuestas respuesta) {
		respuestaRepo.save(respuesta);
	}
	
}
