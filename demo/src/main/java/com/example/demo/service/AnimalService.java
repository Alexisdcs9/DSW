

package com.example.demo.service;

import com.example.demo.model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalService {

    private List<Animal> animales = new ArrayList<>();

    private int contador = 1;

    public AnimalService() {
        crearAnimal(new Animal(0, "Perro", 15, false));
        crearAnimal(new Animal(0, "Mosca", 5, true));
        crearAnimal(new Animal(0, "Ballena", 30, false));
    }

    // Recibe un animal sin id (viene del formulario), le asigna el id del contador y lo devuelve
    public Animal crearAnimal(Animal animal) {
        animal.setId(contador);
        animales.add(animal);
        contador++;
        return animal;
    }

    public List<Animal> listarAnimales() {
        return animales;
    }

    public Animal buscarPorId(int id) {
        for (Animal animal : animales) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    // Aqui desconocemos el id del animal por eso usamos .getId()
    public Animal editAnimal(Animal animal) {
        Animal animalEncontrado = buscarPorId(animal.getId());

        if (animalEncontrado != null) {
            animalEncontrado.setNombre(animal.getNombre());
            animalEncontrado.setVidaMedia(animal.getVidaMedia());
            animalEncontrado.setExtinto(animal.isExtinto());
        }

        return animalEncontrado;
    }

    // Aqui usamos el id directamente porque ya conocemos el id del animal que queremos borrar
    public boolean deleteAnimal(int id) {
        Animal animalEncontrado = buscarPorId(id);

        if (animalEncontrado != null) {
            return animales.remove(animalEncontrado);
        }

        return false;
    }

}