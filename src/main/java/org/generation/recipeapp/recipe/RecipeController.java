package org.generation.recipeapp.recipe;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/recipe")
public class RecipeController {
  private final RecipeService recipeService;

  @GetMapping
  List<Recipe> getAll() {
    return recipeService.getAll();
  }

  @GetMapping("/{id}")
  Recipe getRecipe(@PathVariable Long id) {
    return recipeService.getRecipe(id);
  }

  @GetMapping("/course")
  List<Recipe> getByCourseType(@RequestParam String course) {
    return recipeService.getByCourseType(course);
  }

  @DeleteMapping("/{id}")
  void deleteRecipe(@PathVariable Long id) {
    recipeService.deleteRecipe(id);
  }

  @PostMapping
  void addRecipe(@RequestBody Recipe recipe) {
    recipeService.addRecipe(recipe);
  }

  @PutMapping("/{id}")
  void updateRecipe(@PathVariable Long id,
      @RequestParam String name) {
    recipeService.updateRecipe(id, name);
  }
}
