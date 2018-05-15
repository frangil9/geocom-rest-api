package com.group.system.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.system.exception.RestException;
import com.group.system.model.Recipe;
import com.group.system.repository.RecipeRepository;
import com.group.system.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Transactional
	@Override
	public Recipe save(Recipe recipe) {		
		return this.recipeRepository.save(recipe);
	}

	@Transactional
	@Override
	public Recipe update(Recipe recipe) {		
		return this.recipeRepository.save(recipe);
	}

	@Override
	public Recipe findById(Long id) {		
		return this.recipeRepository.findOne(id);
	}

	@Transactional
	@Override
	public void delete(Long id) throws RestException {		
		Recipe recipe = this.recipeRepository.findOne(id);
		if(recipe == null){
			throw new RestException("El recipe con id "+id+" no fue encontrado");
		}
		this.recipeRepository.delete(recipe);
	}

	@Override
	public List<Recipe> findAll() {
		return this.recipeRepository.findAll();
	}

}
