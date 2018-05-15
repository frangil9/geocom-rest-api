package com.group.system.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.system.exception.ErrorMessage;
import com.group.system.exception.RestException;
import com.group.system.model.Recipe;
import com.group.system.service.RecipeService;

@RestController
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping("/recipes")
	public ResponseEntity<List<Recipe>> findAllRecipes(){
		List<Recipe> recipes = this.recipeService.findAll();
		return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);		
	}
	
	@GetMapping("/recipes/{id}")
	public ResponseEntity<Recipe> findById(@PathVariable("id") long id){
		Recipe recipe = this.recipeService.findById(id);
		if(recipe == null){
			return new ResponseEntity(new ErrorMessage("El recipe con id "+id+" no fue encontrado"), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
	}
	
	@PostMapping("/recipes")
	public ResponseEntity<Recipe> saveRecipe(@RequestBody Recipe recipe){
		Recipe recipeSave = this.recipeService.save(recipe);
		return new ResponseEntity<Recipe>(recipeSave, HttpStatus.OK); 
	}
	
	@PutMapping("/recipes")
	public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe){
		Recipe reciped = this.recipeService.findById(recipe.getId());
		if(reciped == null){
			return new ResponseEntity(new ErrorMessage("El recipe con id "+recipe.getId()+" no fue encontrado"), 
					HttpStatus.NOT_FOUND);
		}
		reciped.setName(recipe.getName());
		reciped.setDescription(recipe.getDescription());
		reciped.setImagePath(recipe.getImagePath());
		Recipe recipeUpdate = this.recipeService.update(recipe);
		return new ResponseEntity<Recipe>(recipeUpdate, HttpStatus.OK); 
	}	
	
	@DeleteMapping("/recipes/{id}")
	public ResponseEntity<Void> deleteRecipe(@PathVariable("id") long id){
		try {
			this.recipeService.delete(id);
		} catch (RestException e) {
			return new ResponseEntity(new ErrorMessage(e.getMessage()), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
