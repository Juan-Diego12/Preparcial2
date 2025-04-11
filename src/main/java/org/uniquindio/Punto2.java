package org.uniquindio;

public class Punto2 {
    static class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    static class Pila {
        Nodo cima;

        public void push(int dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = cima;
            cima = nuevo;
        }
        public int pop() {
            if (cima == null) throw new RuntimeException("Pila vacía");
            int dato = cima.dato;
            cima = cima.siguiente;
            return dato;
        }

        public boolean estaVacia() {
            return cima == null;
        }
    }
    static class Cola {
        Nodo frente, fin;

        public void encolar(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (frente == null) {
                frente = fin = nuevo;
            } else {
                fin.siguiente = nuevo;
                fin = nuevo;
            }
        }

        public void imprimir() {
            Nodo actual = frente;
            while (actual != null) {
                System.out.print(actual.dato + " <- ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }
    public static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static Cola primosEnCola(Pila pila) {
        Cola cola = new Cola();

        while (!pila.estaVacia()) {
            int num = pila.pop();
            if (esPrimo(num)) {
                cola.encolar(num);
            }
        }

        return cola;
    }
    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.push(10);
        pila.push(7);
        pila.push(4);
        pila.push(3);
        pila.push(11);
        pila.push(8);

        Cola colaResultado = primosEnCola(pila);

        System.out.print("Cola: ");
        colaResultado.imprimir();
    }
}
