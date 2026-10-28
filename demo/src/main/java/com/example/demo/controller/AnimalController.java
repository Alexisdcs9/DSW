package com.example.demo.controller;

import com.example.demo.model.Animal;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.AnimalService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {

    //Esto hay que importarlo porque quieres tener los metodos del animal service(se puede hacer con un autowired
    // o con un constructor)

    private AnimalService as;

    public AnimalController(AnimalService animalService) {
        as = animalService;
    }


    @GetMapping("/animales")
        public String listaAnimales (Model model){

        model.addAttribute("animales", as.listarAnimales());
        return  "animales/lista";

    }

    @GetMapping("/animales/details/{id}")
        public String animalDetails(@PathVariable int id, Model model ){

            Animal animal = as.buscarPorId(id);
            if(animal == null) {
                return "redirect:/animales";
            }
            model.addAttribute("animal", animal);
            return "animales/details";

    }

    @GetMapping("/animales/create")
        public String crearAnimal(Model model){
        Animal animal = new Animal();
        model.addAttribute("animal", animal);
        return "animales/create";
    }

    @PostMapping("/animales/create")
        public String guardarAnimales(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return "animales/create";
        }
            as.crearAnimal(animal);
            return "redirect:/animales";


    }




}
