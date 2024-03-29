package com.cofee.cofeeapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CofeeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CofeeappApplication.class, args);
	}

}

/**
 * Coffee
 */
class Coffee {

	private final String id;
	private  String name;
	
	

	public Coffee(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

@RestController
@RequestMapping("/coffees")
class RestApiCoffeeController {
	
	private List<Coffee> coffees = new ArrayList<>();
	
	public RestApiCoffeeController(){
		coffees.addAll(List.of(
			new Coffee("Nescafe"),
			new Coffee("Cafe Touba"),
			new Coffee("Cafe Expresso"),
			new Coffee("Cafe creme")
		));
	}
	@GetMapping
	Iterable<Coffee> getCoffees(){
		return coffees;
	}

	@GetMapping("/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id){
		for(Coffee c: coffees){
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}
		return Optional.empty();
	}

	@PostMapping
	Coffee postCofee (@RequestBody Coffee coffee){
		coffees.add(coffee);
		return coffee;
	}

	
}