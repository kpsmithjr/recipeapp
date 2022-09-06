package org.generation.recipeapp.recipe;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {
  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String course;
  @Column(nullable = false)
  private int servings;
  @Column(nullable = false)
  private float prepTime;
  @Column(nullable = false)
  private float cookTime;


  public Recipe(String name, String course, int servings, float prepTime, float cookTime) {
    this.name = name;
    this.course = course;
    this.servings = servings;
    this.prepTime = prepTime;
    this.cookTime = cookTime;
  } 

}
