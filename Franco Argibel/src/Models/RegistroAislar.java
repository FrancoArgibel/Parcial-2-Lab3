package Models;

import java.io.Serializable;

public class RegistroAislar implements Serializable {
    private int numeroKit;
    private String barrio;
    private double temperatura;
    
    //Constructor

    public RegistroAislar(int numeroKit, String barrio, double temperatura) {
        this.numeroKit = numeroKit;
        this.barrio = barrio;
        this.temperatura = temperatura;
    }

    //Getters and Setters
    
    public int getNumeroKit() {
        return numeroKit;
    }
    
    public String getBarrio() {
        return barrio;
    }

    public double getTemperatura() {
        return temperatura;
    }
}
