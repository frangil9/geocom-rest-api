package com.group.system.service;

import java.util.List;

import com.group.system.exception.RestException;
import com.group.system.model.Recipe;

public interface RecipeService {
	public Recipe save(Recipe recipe);
	public Recipe update(Recipe recipe);
	public Recipe findById(Long id);
	public void delete(Long id) throws RestException;
	public List<Recipe> findAll();
}
