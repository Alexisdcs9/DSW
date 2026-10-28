package com.example.demo.model;

import jakarta.validation.constraints.*;

public class Animal {


    private int id ;

    @NotBlank
    @Size(min = 3, max = 15 , message = "El nombre tiene que tener entre 3 y 15 caracteres")
    private String nombre;


    @Min(value = 0, message = "No se admiten valores negativos")
    @Max(value = 600, message = "No puedes exceder el limite de 600")
    private int vidaMedia;


    private boolean extinto;

    public Animal() {

    }

    public Animal(int id, String nombre, int vidaMedia, boolean extinto) {
        this.id = id;
        this.nombre = nombre;
        this.vidaMedia = vidaMedia;
        this.extinto = extinto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaMedia() {
        return vidaMedia;
    }

    public void setVidaMedia(int vidaMedia) {
        this.vidaMedia = vidaMedia;
    }

    public boolean isExtinto() {
        return extinto;
    }

    public void setExtinto(boolean extinto) {
        this.extinto = extinto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }






}
