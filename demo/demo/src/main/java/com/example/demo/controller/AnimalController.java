package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.AnimalService;

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




}
