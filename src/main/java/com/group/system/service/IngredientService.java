package com.group.system.service;

import java.util.List;

import com.group.system.exception.RestException;
import com.group.system.model.Ingredient;
import com.group.system.model.IngredientQuery;

public interface IngredientService {
	public Ingredient save(Ingredient ingredient);
	public Ingredient update(Ingredient ingredient);
	public Ingredient findById(Long id);
	public void delete(Long id) throws RestException;
	public List<Ingredient> findAll();
	public List<IngredientQuery> getTotalByName();
}
