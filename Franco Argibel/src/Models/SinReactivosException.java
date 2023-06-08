package Models;

public class SinReactivosException extends Exception {
    public SinReactivosException() {
        super("No hay reactivos disponibles");
    }
}
