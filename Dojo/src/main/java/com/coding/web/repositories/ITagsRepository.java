package com.coding.web.repositories;

import org.springframework.data.repository.CrudRepository;

import com.coding.web.models.Tags;

public interface ITagsRepository  extends CrudRepository<Tags, Long> {
	Tags getBySubject(String subject);
}
