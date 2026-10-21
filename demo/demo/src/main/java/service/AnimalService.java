package service;
import model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> animales = new ArrayList<>();

    private int contador = 1;

    public AnimalService() {
        crearAnimal("Perro", 15, false);
        crearAnimal("Mosca", 5, true);
        crearAnimal("Ballena", 30, false);
    }

    public void crearAnimal(String nombre, Integer vidaMedia, Boolean extinto) {
        Animal animal = new Animal(contador,nombre,vidaMedia,extinto);
        animales.add(animal);
        contador++;
    }

    public void crearAnimal(Animal animal){

        animal.setId(contador);
        animales.add(animal);
        contador++;

    }

    public List<Animal> listarAnimales() {

        return animales;
    }

    public Animal buscarPorId(int id) {

        for (int i = 0; i < animales.size(); i++) {

            Animal animal = animales.get(i);

            if (animal.getId() == id ){

                return animal;

            }

        }

        return null;
        
    }


        //Aqui desconocemos el id del animal por eso usamos .getId()
        public Animal editAnimal(Animal animal) {

            Animal animalEncontrado = buscarPorId(animal.getId());

            if (animalEncontrado != null) {
                animalEncontrado.setNombre(animal.getNombre());
                animalEncontrado.setVidaMedia(animal.getVidaMedia());
                animalEncontrado.setExtinto(animal.isExtinto());
            }

            return animalEncontrado;
        }


        //Aqui usamos el id directamente porque ya conocemos el id del animal que queremos borrar
    public boolean deleteAnimal(int id) {
        Animal animalEncontrado = buscarPorId(id);

        if (animalEncontrado != null) {
            return animales.remove(animalEncontrado);
        }

        return false;
    }


    }

