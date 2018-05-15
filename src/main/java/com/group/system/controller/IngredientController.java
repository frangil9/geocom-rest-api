package com.group.system.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.system.model.Ingredient;
import com.group.system.model.IngredientQuery;
import com.group.system.service.IngredientService;

@RestController
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;

	@GetMapping("/ingredients")
	public ResponseEntity<List<Ingredient>> findAllIngredients(){
		List<Ingredient> ingredients = this.ingredientService.findAll();
		return new ResponseEntity<List<Ingredient>>(ingredients, HttpStatus.OK);
	}
	
	@GetMapping("/ingredients/total")
	public ResponseEntity<List<IngredientQuery>> getTotalByName(){
		List<IngredientQuery> totals = this.ingredientService.getTotalByName();
		return new ResponseEntity<List<IngredientQuery>>(totals, HttpStatus.OK);
	}
}

