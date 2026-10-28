package com.example.demo.model;

import jakarta.validation.constraints.*;

public class Animal {


    private int id ;

    @NotBlank
    @Size(min = 3, max = 15 , message = "El nombre tiene que tener entre 3 y 15 caracteres")
    private String nombre;

    @PositiveOrZero
    @Min(0)
    @Max(600)
    private int vidaMedia;

    @NotBlank(message = "Debes indicar Si o No")
    private Boolean extinto;

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
