import Models.SistemaSaludMunicipal;
import Models.SinReactivosException;

import java.util.Scanner;

import Models.Persona;
import Models.RegistroAislar;

public class Main {

    public static void main(String[] args) {
        int cantidadReactivos = 10;
        try {
            SistemaSaludMunicipal.registrarPersona("Juan", "Perez", 30, "Barrio A", "12345678", "Empleado");
            SistemaSaludMunicipal.registrarPersona("Maria", "Gomez", 40, "Barrio B", "98765432", "Estudiante");
            SistemaSaludMunicipal.registrarPersona("Pedro", "Lopez", 25, "Barrio A", "87654321", "Profesional");
            SistemaSaludMunicipal.registrarPersona("Juan", "Lopez", 20, "Barrio D", "87654322", "Profesional");
            SistemaSaludMunicipal.registrarPersona("Pepe", "Lopez", 21, "Barrio D", "87654323", "Profesional");
            SistemaSaludMunicipal.registrarPersona("Paco", "Lopez", 22, "Barrio D", "87654324", "Profesional");
            SistemaSaludMunicipal.registrarPersona("Mati", "Lopez", 23, "Barrio D", "87654325", "Profesional");
            SistemaSaludMunicipal.registrarPersona("Jose", "Lopez", 24, "Barrio D", "87654326", "Profesional");
            SistemaSaludMunicipal.registrarPersona("Joaco", "Lopez", 26, "Barrio D", "8765437", "Profesional");
            SistemaSaludMunicipal.registrarPersona("Jero", "Lopez", 27, "Barrio D", "87654335", "Profesional");

            //SistemaSaludMunicipal.registrarPersona("Joaco", "Lopez", 26, "Barrio D", "8765437", "Profesional"); // Se puede utilizar para corroborar el control de DNI.
            SistemaSaludMunicipal.registrarPersona("Joaco", "Lopez", 26, "Barrio D", "8765455", "Profesional"); // Se puede utilizar para corroborar el control de reactivos.
            SistemaSaludMunicipal.testear();
            
            SistemaSaludMunicipal.aislar();
        } catch (SinReactivosException e) {
            System.out.println(e.getMessage());
            System.out.print("Ingrese la nueva cantidad de reactivos disponibles: ");
            cantidadReactivos = scanner.nextInt();
            scanner.nextLine();
        }

        // Mostrar personas sanas
        System.out.println("Personas sanas:");
            for (Persona persona : SistemaSaludMunicipal.getPersonasSanas()) {
                System.out.println("Nombre: " + persona.getNombre() + " " + persona.getApellido());
                System.out.println("Edad: " + persona.getEdad());
                System.out.println("Barrio: " + persona.getBarrio());
                System.out.println("DNI: " + persona.getDNI());
                System.out.println("Ocupación: " + persona.getOcupacion());
                System.out.println("------------------------");
            }

        // Mostrar personas aisladas
        System.out.println("Personas aisladas:");
        for (RegistroAislar registro : SistemaSaludMunicipal.getCasosSospechosos()) {
            System.out.println("Número de kit: " + registro.getNumeroKit());
            System.out.println("Temperatura: " + registro.getTemperatura());
            System.out.println("Barrio: " + registro.getBarrio());
            System.out.println("------------------------");
        }
    }
}

