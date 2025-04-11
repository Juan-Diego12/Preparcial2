package org.uniquindio;
public class Punto7 {

    static class Nodo {
        int valor;
        Nodo siguiente;

        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public static Nodo insertarDespuesDeSuma(Nodo cabeza) {
        int sumaTotal = sumar(cabeza);
        return insertarRecursivo(cabeza, 0, sumaTotal);
    }

    private static Nodo insertarRecursivo(Nodo actual, int sumaParcial, int sumaTotal) {
        if (actual == null) return null;

        sumaParcial += actual.valor;

        actual.siguiente = insertarRecursivo(actual.siguiente, sumaParcial, sumaTotal);

        if (sumaParcial == sumaTotal) {
            Nodo nodoSuma = new Nodo(sumaTotal);
            Nodo nodo2 = new Nodo(2);

            nodoSuma.siguiente = nodo2;
            nodo2.siguiente = actual.siguiente;
            actual.siguiente = nodoSuma;
        }

        return actual;
    }

    private static int sumar(Nodo nodo) {
        if (nodo == null) return 0;
        return nodo.valor + sumar(nodo.siguiente);
    }

    public static void imprimirLista(Nodo cabeza) {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Nodo cabeza = new Nodo(1);
        cabeza.siguiente = new Nodo(2);
        cabeza.siguiente.siguiente = new Nodo(3);

        System.out.print("Lista original: ");
        imprimirLista(cabeza);

        cabeza = insertarDespuesDeSuma(cabeza);

        System.out.print("Lista modificada: ");
        imprimirLista(cabeza);
    }
}
