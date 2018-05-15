package com.group.system.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.system.exception.RestException;
import com.group.system.model.Ingredient;
import com.group.system.model.IngredientQuery;
import com.group.system.repository.IngredientRepository;
import com.group.system.service.IngredientService;

@Service
public class IngredientSeerviceImpl implements IngredientService{

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Transactional
	@Override
	public Ingredient save(Ingredient ingredient) {		
		return this.ingredientRepository.save(ingredient);
	}

	@Transactional
	@Override
	public Ingredient update(Ingredient ingredient) {		
		return this.ingredientRepository.save(ingredient);
	}

	@Override
	public Ingredient findById(Long id) {		
		return this.ingredientRepository.findOne(id);
	}
	
	@Transactional
	@Override
	public void delete(Long id) throws RestException {		
		Ingredient ingredient = this.ingredientRepository.findOne(id);
		if(ingredient == null){
			throw new RestException("El id "+id+" no fue encontrado");
		}
		this.ingredientRepository.delete(ingredient);
	}

	@Override
	public List<Ingredient> findAll() {
		return this.ingredientRepository.findAll();
	}

	@Override
	public List<IngredientQuery> getTotalByName() {		
		return this.ingredientRepository.calculateTotalByName();
	}

}
