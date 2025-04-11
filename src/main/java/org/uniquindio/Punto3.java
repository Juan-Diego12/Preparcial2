package org.uniquindio;

public class Punto3 {

    // Clase Persona
    static class Persona {
        String nombre;
        int edad;
        char sexo; // 'M' para hombre, 'F' para mujer

        public Persona(String nombre, int edad, char sexo) {
            this.nombre = nombre;
            this.edad = edad;
            this.sexo = sexo;
        }

        public String toString() {
            return nombre + " (" + edad + ", " + sexo + ")";
        }
    }

    // Nodo con Persona
    static class Nodo {
        Persona persona;
        Nodo siguiente;

        public Nodo(Persona persona) {
            this.persona = persona;
            this.siguiente = null;
        }
    }

    // Cola de Personas
    static class Cola {
        Nodo frente, fin;

        public void encolar(Persona p) {
            Nodo nuevo = new Nodo(p);
            if (frente == null) {
                frente = fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
        }

        public Persona desencolar() {
            if (frente == null) throw new RuntimeException("Cola vacía");
            Persona p = frente.persona;
            frente = frente.siguiente;
            if (frente == null) fin = null;
            return p;
        }

        public boolean estaVacia() {
            return frente == null;
        }

        public void imprimir() {
            Nodo actual = frente;
            while (actual != null) {
                System.out.println(actual.persona);
                actual = actual.siguiente;
            }
        }
    }

    // Método que elimina hombres entre 30 y 50 años de la cola
    public static void filtrarCola(Cola cola) {
        Cola temporal = new Cola();

        while (!cola.estaVacia()) {
            Persona p = cola.desencolar();
            if (!(p.sexo == 'M' && p.edad >= 30 && p.edad <= 50)) {
                temporal.encolar(p);
            }
        }

        // Restaurar la cola original con los elementos filtrados
        while (!temporal.estaVacia()) {
            cola.encolar(temporal.desencolar());
        }
    }

    // Prueba
    public static void main(String[] args) {
        Cola cola = new Cola();
        cola.encolar(new Persona("Carlos", 35, 'M'));
        cola.encolar(new Persona("Ana", 28, 'F'));
        cola.encolar(new Persona("Luis", 45, 'M'));
        cola.encolar(new Persona("María", 33, 'F'));
        cola.encolar(new Persona("Pedro", 52, 'M'));
        cola.encolar(new Persona("Lucía", 41, 'F'));

        System.out.println("Cola original:");
        cola.imprimir();

        filtrarCola(cola);

        System.out.println("\nCola filtrada (sin hombres entre 30 y 50):");
        cola.imprimir();
    }
}
