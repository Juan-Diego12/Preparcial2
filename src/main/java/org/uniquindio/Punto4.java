package org.uniquindio;

public class Punto4 {
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

    public static int decimalABinario(int numero) {
        if (numero == 0) return 0;

        Pila pila = new Pila();

        while (numero > 0) {
            int residuo = numero % 2;
            pila.push(residuo);
            numero = numero / 2;
        }

        int binario = 0;
        while (!pila.estaVacia()) {
            binario = binario * 10 + pila.pop();
        }

        return binario;
    }
    public static void main(String[] args) {
        int numero = 61;
        int binario = decimalABinario(numero);
        System.out.println(numero + "(10) = " + binario + "(2)");
    }
}
