package Models;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    public class SistemaSaludMunicipal {
        private static int cantidadReactivos = 10;
        private static List<Persona> personas = new ArrayList<>();
        private static Map<Integer, RegistroTest> registros = new HashMap<>();
        
        public static void registrarPersona(String nombre, String apellido, int edad, String barrio, String DNI, String ocupacion) throws SinReactivosException {
            if (cantidadReactivos > 0) {
                if (buscarPersona(DNI) == null) {
                    personas.add(new Persona(nombre, apellido, edad, barrio, DNI, ocupacion));
                    cantidadReactivos--;
                    int numeroKit = generarNumeroKit();
                    registros.put(numeroKit, new RegistroTest(DNI, generarTemperatura()));
                    System.out.println("Persona registrada exitosamente. Número de kit asignado: " + numeroKit);
                } else {
                    throw new IllegalArgumentException("Ya existe una persona registrada con ese DNI.");
                }
            } else {
                throw new SinReactivosException();
            }
        }
        
        private static Persona buscarPersona(String DNI) {
            for (Persona persona : personas) {
                if (persona.getDNI().equals(DNI)) {
                    return persona;
                }
            }
            return null;
        }
        
        private static int generarNumeroKit() {
            return registros.size() + 1;
        }
        
        private static double generarTemperatura() {
            return 36 + Math.random() * 3;
        }
        
        
        public static void testear() {
            for (RegistroTest registro : registros.values()) {
                registro.setTemperatura(generarTemperatura());
            }
        }
        
        public static void aislar() {
            List<RegistroAislar> casosSospechosos = new ArrayList<>();
            for (Map.Entry<Integer, RegistroTest> entry : registros.entrySet()) {
                int numeroKit = entry.getKey();
                RegistroTest registro = entry.getValue();
                if (registro.getTemperatura() >= 38) {
                    String DNI = registro.getDNI();
                    String barrio = buscarPersona(DNI).getBarrio();
                    casosSospechosos.add(new RegistroAislar(numeroKit, barrio, generarTemperatura()));
                }
            }
            
            if (!casosSospechosos.isEmpty()) {
                try {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("urgente.dat"));
                    for (RegistroAislar registro : casosSospechosos) {
                        out.writeObject(registro);
                    }
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static List<Persona> getPersonasSanas() {
            List<Persona> personasSanas = new ArrayList<>();
            for (Persona persona : personas) {
                String DNI = persona.getDNI();
                RegistroTest registro = registros.get(buscarNumeroKit(DNI));
                if (registro.getTemperatura() < 38) {
                    personasSanas.add(persona);
                }
            }
            return personasSanas;
        }
        
        public static List<RegistroAislar> getCasosSospechosos() {
            List<RegistroAislar> casosSospechosos = new ArrayList<>();
            for (Map.Entry<Integer, RegistroTest> entry : registros.entrySet()) {
                int numeroKit = entry.getKey();
                RegistroTest registro = entry.getValue();
                if (registro.getTemperatura() >= 38) {
                    String DNI = registro.getDNI();
                    String barrio = buscarPersona(DNI).getBarrio();
                    casosSospechosos.add(new RegistroAislar(numeroKit, barrio, generarTemperatura()));
                }
            }
            return casosSospechosos;
        }
        
        private static int buscarNumeroKit(String DNI) {
            for (Map.Entry<Integer, RegistroTest> entry : registros.entrySet()) {
                int numeroKit = entry.getKey();
                RegistroTest registro = entry.getValue();
                if (registro.getDNI().equals(DNI)) {
                    return numeroKit;
                }
            }
            return -1;
        }
    }


