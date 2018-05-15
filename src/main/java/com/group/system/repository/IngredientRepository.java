package com.group.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group.system.model.Ingredient;
import com.group.system.model.IngredientQuery;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>{
	
	@Query(value = "select new com.group.system.model.IngredientQuery(sum(s.amount), s.name) from Ingredient s group by s.name")
	List<IngredientQuery> calculateTotalByName();

}
