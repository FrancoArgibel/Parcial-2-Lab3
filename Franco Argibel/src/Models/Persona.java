package Models;

import java.io.Serializable;



public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private int edad;
    private String barrio;
    private String DNI;
    private String ocupacion;

    //Constructor
    
    public Persona(String nombre, String apellido, int edad, String barrio, String DNI, String ocupacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.barrio = barrio;
        this.DNI = DNI;
        this.ocupacion = ocupacion;
    }
    
    //Getters and Setters

    public String getDNI() {
        return DNI;
    }
    
    public String getBarrio() {
        return barrio;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
}   
