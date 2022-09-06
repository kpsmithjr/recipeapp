package org.generation.recipeapp.recipe;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RecipeService {
  private final RecipeRepository recipeRepository;

  public List<Recipe> getAll() {
    return recipeRepository.findAll();
  }

  public Recipe getRecipe(Long id) {
    Optional<Recipe> recipe = recipeRepository.findById(id);
    
    if (!recipe.isPresent()) {
      throw new IllegalStateException("A recipe with id " + id + " could not be found");
    }

    return recipe.get();
  }

  public List<Recipe> getByCourseType(String type) {
    return recipeRepository.findByCourseType(type);
    // return null;
  }

  public void deleteRecipe(Long id) {
    boolean exists = recipeRepository.existsById(id);

    if (!exists) {
      throw new IllegalStateException("Recipe with id " + id + " does not exist");      
    }

    recipeRepository.deleteById(id);
  }

  public void addRecipe(Recipe recipe) {
    recipeRepository.save(recipe);
  }

  @Transactional
  public void updateRecipe(Long id, String name) {
    Recipe recipe = recipeRepository.findById(id)
      .orElseThrow(()-> new IllegalStateException("Recipe with id " + id + " does not exist"));

    if (name != null &&
       name.length() > 0 &&
       !name.equals(recipe.getName())) {
      recipe.setName(name);
    }
  }

}
