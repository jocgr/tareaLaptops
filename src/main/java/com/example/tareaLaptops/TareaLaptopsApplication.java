package com.example.tareaLaptops;

import com.example.tareaLaptops.entities.Laptop;
import com.example.tareaLaptops.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TareaLaptopsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TareaLaptopsApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null, "Dell", "gris", 15.19);
		Laptop laptop2 = new Laptop(null, "HP", "Negro", 13.80);
		Laptop laptop3 = new Laptop(null, "Acer", "Gris", 1.5);
		repository.save(laptop1);
		repository.save(laptop2);
		repository.save(laptop3);
	}

}
