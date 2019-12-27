package com.springlabs.pizzastore.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.springlabs.pizzastore.domain.Pizza;
import com.springlabs.pizzastore.domain.PizzaCategory;
import com.springlabs.pizzastore.service.PizzaService;



@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	PizzaService pizzaService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/all")
    public ModelAndView getAllPizzas(ModelAndView modelAndView) {
		logger.info("Pizza controller");
		List<Pizza> pizzaList = pizzaService.findAllPizzas();
		if(pizzaList.isEmpty()) {
			//TODO: error page redirection
		}
		modelAndView.addObject("pizzas", pizzaList);
		modelAndView.setViewName("pizza/pizzaList");
		return modelAndView;
    }
	
	@GetMapping("/{pizzaId}")
    public ModelAndView getAllPizzas(@PathVariable final Long pizzaId, ModelAndView modelAndView) {
		logger.info("Pizza controller");
		Pizza pizza = pizzaService.getPizza(pizzaId);
		if(pizza==null) {
			//TODO: error page redirection
		}
		modelAndView.addObject("pizza", pizza);
		modelAndView.setViewName("pizza/pizza");
		return modelAndView;
    }
	
	
	@PostMapping("/save")
    public RedirectView savePizza(@RequestParam String pizza_name, @RequestParam String pizza_desc, @RequestParam String pizza_price, @RequestParam String pizza_cat) {
		logger.info("Pizza controller");
		PizzaCategory existing_pizzaCategory = pizzaService.getPizzaCategory(Long.parseLong(pizza_cat));
		Pizza pizzaSaved = pizzaService.savePizza(new Pizza(pizza_name, pizza_desc, pizza_price, existing_pizzaCategory));
		logger.info("Pizza saved: " + pizzaSaved);
		return new RedirectView("/pizza/all");
    }
}	