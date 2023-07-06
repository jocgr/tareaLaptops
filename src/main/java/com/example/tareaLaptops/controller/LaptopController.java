package com.example.tareaLaptops.controller;


import com.example.tareaLaptops.entities.Laptop;
import com.example.tareaLaptops.repositories.LaptopRepository;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class LaptopController {
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    private LaptopRepository laptopRepository;
    public LaptopController(LaptopRepository laptopRepository) {this.laptopRepository= laptopRepository;}
    @GetMapping("/api/laptops")
    public List<Laptop>findAll(){
        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@ApiParam("clave primaria Tipo Long") @PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();


    }
    @PostMapping
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }
    @PutMapping("/laptops")
    public Laptop update(@RequestBody Laptop laptop){
        if (laptop.getId()==null){
            log.warn("Se está actualizando una computadora que no está en la base de datos.");

        }
        return laptopRepository.save(laptop);
    }

    @DeleteMapping("/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if(!laptopRepository.existsById(id)) {
            log.warn("no existe el dato a borrar ");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("laptops")

    public ResponseEntity<Laptop> deleteAll(){
        log.info("Ejecutando metodo borrar todo");

        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();



    }
}
