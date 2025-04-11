package org.uniquindio;

public class Punto5 {

    // Nodo para la pila
    static class Nodo {
        char dato;
        Nodo siguiente;

        public Nodo(char dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Pila de caracteres
    static class Pila {
        Nodo cima;

        public void push(char dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.siguiente = cima;
            cima = nuevo;
        }

        public char pop() {
            if (cima == null) throw new RuntimeException("Pila vacía");
            char dato = cima.dato;
            cima = cima.siguiente;
            return dato;
        }

        public char peek() {
            if (cima == null) throw new RuntimeException("Pila vacía");
            return cima.dato;
        }

        public boolean estaVacia() {
            return cima == null;
        }
    }

    // Método para verificar si los símbolos están balanceados
    public static boolean estaBalanceado(String expresion) {
        Pila pila = new Pila();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si es apertura, lo metemos en la pila
            if (c == '(' || c == '[' || c == '{') {
                pila.push(c);
            }

            // Si es cierre, verificamos con el tope de la pila
            if (c == ')' || c == ']' || c == '}') {
                if (pila.estaVacia()) return false;

                char tope = pila.pop();

                if ((c == ')' && tope != '(') ||
                        (c == ']' && tope != '[') ||
                        (c == '}' && tope != '{')) {
                    return false;
                }
            }
        }

        // Si la pila está vacía al final, está balanceado
        return pila.estaVacia();
    }

    // Prueba
    public static void main(String[] args) {
        String expresion1 = "(6-7)/4]";
        String expresion2 = "[(1+2)*4]+5";

        System.out.println(expresion1 + " → " + estaBalanceado(expresion1)); // false
        System.out.println(expresion2 + " → " + estaBalanceado(expresion2)); // true
    }
}
