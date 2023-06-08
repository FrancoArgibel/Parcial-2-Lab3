package Models;

import java.io.Serializable;

public class RegistroTest implements Serializable {
    private String DNI;
    private double temperatura;
    
    //Constructor

    public RegistroTest(String DNI, double temperatura) {
        this.DNI = DNI;
        this.temperatura = temperatura;
    }
    
    //Getters and Setters
    
    public String getDNI() {
        return DNI;
    }
    
    public double getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}