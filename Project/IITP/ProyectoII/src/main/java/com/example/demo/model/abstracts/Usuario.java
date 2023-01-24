package com.example.demo.model.abstracts;

import javax.persistence.*;
// =================================================================================================
//Esta anotacion le hace saber a la base de datos que las clases que hereden de esta van a tener los atributos
// en sus tablas respectivas
// =================================================================================================
@MappedSuperclass
public abstract class Usuario {
    // =================================================================================================
    //Atributos de una persona
    //La anotacion de column en cada atributo es para denotar su posicion en la base de datos
    // =================================================================================================
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cedula")
    private int cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "contrasena")
    private String contrasena;

    //Gets y setters
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    // =================================================================================================
    //Metodos extras
    //Obtiene el nombre y el apellido y los devuelve como un solo String
    // =================================================================================================
    public String getNombreCompleto(){
        return (this.getNombre() + " " + this.apellido);
    }
}
