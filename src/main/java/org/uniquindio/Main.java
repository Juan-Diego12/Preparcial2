package org.uniquindio;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

class ListaSimple {
    Nodo cabeza;

    public void agregar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    public void imprimir() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }
}
class Pila {
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
class Utilidades {

    public static ListaSimple invertirListaConPila(ListaSimple lista) {
        Pila pila = new Pila();
        Nodo actual = lista.cabeza;
        while (actual != null) {
            pila.push(actual.dato);
            actual = actual.siguiente;
        }
        ListaSimple listaInvertida = new ListaSimple();
        while (!pila.estaVacia()) {
            listaInvertida.agregar(pila.pop());
        }

        return listaInvertida;
    }
}
public class Main {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);

        System.out.print("Original: ");
        lista.imprimir();

        ListaSimple invertida = Utilidades.invertirListaConPila(lista);

        System.out.print("Invertida: ");
        invertida.imprimir();
    }
}

