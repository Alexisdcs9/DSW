package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AnimalService;

@Controller
@RequestMapping
public class AnimalController {

    //Esto hay que importarlo porque quieres tener los metodos del animal service(se puede hacer con un autowired
    // o con un constructor)

    private AnimalService animalService = new AnimalService();


    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/animales")
        public String listaAnimales (Model model){

        model.addAttribute("animales", animalService.listarAnimales());
        return  "animales/lista";
    }




}
