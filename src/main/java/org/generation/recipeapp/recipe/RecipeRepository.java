package org.generation.recipeapp.recipe;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

  @Query("SELECT r FROM Recipe r WHERE r.course = ?1")
  List<Recipe> findByCourseType(String type);

}
