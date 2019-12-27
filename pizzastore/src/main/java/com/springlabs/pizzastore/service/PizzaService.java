package com.springlabs.pizzastore.service;

import java.util.List;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaCategory;

public interface PizzaService {
	
	/**
     * List all Pizzas from repository
     *
     * @return
     */
    List<Pizza> findAllPizzas();

    /**
     * Save a pizza to the repository
     *
     * @param base base to save
     */
    Pizza savePizza(final Pizza pizza);
    
    /**
     * Find all details about one pizza
     * 
     * @param pizzaId
     */
    Pizza getPizza(final long pizzaId);

    /**
     * List all Pizza categories
     * @return
     */
	List<PizzaCategory> findAllPizzaCategories();

	/**
	 * Find one single Category from Id
	 * @param categoryId
	 * @return
	 */
	PizzaCategory getPizzaCategory(long categoryId);

}
