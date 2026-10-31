
package com.mycompany.conjuntos;

import javax.swing.JOptionPane;

public class Vectores {

    private int[] vector;
    private int cantidad;

    public Vectores() {
        this.vector = new int[100];
        this.cantidad = 0;
    }

    // SUBMENU

    public void submenu() {

        Vectores L1 = new Vectores();
        Vectores L2 = new Vectores();

        L1.insertar(5);
        L1.insertar(9);
        L1.insertar(14);
        L1.insertar(2);
        L1.insertar(1);
        L1.insertar(10);
        L1.insertar(25);
        L1.insertar(11);
        L1.insertar(7);
        L1.insertar(8);

        Vectores U = new Vectores();

        U.insertar(8);
        U.insertar(9);
        U.insertar(10);
        U.insertar(11);
        U.insertar(12);
        U.insertar(13);
        U.insertar(14);
        U.insertar(15);
        U.insertar(16);
        U.insertar(17);

        int opcion;

        do {

            String texto = JOptionPane.showInputDialog(
                    null,
                    "--- Conjunto con Vectores ---\n\n"
                    + "CONJUNTO A " + mostrar(L1) + "\n"
                    + "1. AGREGAR CONJUNTO B\n"
                    + "2. UNION\n"
                    + "3. INTERSECCION\n"
                    + "4. DIFERENCIA\n"
                    + "5. DIFERENCIA SIMETRICA\n"
                    + "6. COMPLEMENTO\n"
                    + "7. PERTENENCIA\n"
                    + "8. SUBCONJUNTO\n"
                    + "9. IGUALDAD\n"
                    + "10. CONJUNTOS DISJUNTOS\n"
                    + "0. SALIR\n\n"
                    + "Elige una opción:",
                    "Vectores",
                    JOptionPane.QUESTION_MESSAGE);

            if (texto == null) {
                break;
            }

            try {
                opcion = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Escribe solo números");
                opcion = -1;
                continue;
            }

            switch (opcion) {

                case 1:

                    String cantidadTexto = JOptionPane.showInputDialog(
                            "¿Cuántos elementos tendrá el conjunto B?");

                    if (cantidadTexto == null) {
                        break;
                    }

                    try {
                        int n = Integer.parseInt(cantidadTexto);

                        if (n < 0) {
                            JOptionPane.showMessageDialog(null,
                                    "La cantidad no puede ser negativa");
                            break;
                        }

                        for (int i = 1; i <= n; i++) {

                            String datoTexto = JOptionPane.showInputDialog(
                                    "Elemento " + i + ":");

                            if (datoTexto == null) {
                                break;
                            }

                            try {
                                int dato = Integer.parseInt(datoTexto);
                                L2.insertar(dato);

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null,
                                        "Escribe un número entero");
                                i--;
                            }
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Escribe una cantidad válida");
                    }

                    break;

                case 2:

                    Vectores u = L1.union(L2);

                    JOptionPane.showMessageDialog(null,
                            "A ∪ B = " + mostrar(u));

                    break;

                case 3:

                    JOptionPane.showMessageDialog(null,
                            "A ∩ B = " + mostrar(L1.interseccion(L2)));

                    break;

                case 4:

                    JOptionPane.showMessageDialog(null,
                            "A - B = " + mostrar(L1.diferencia(L2)));

                    break;

                case 5:

                    JOptionPane.showMessageDialog(null,
                            "A Δ B = " + mostrar(L1.diferenciaSimetrica(L2)));

                    break;

                case 6:

                    JOptionPane.showMessageDialog(null,
                            "A' = " + mostrar(L1.complemento(U)));

                    break;

                case 7:

                    String buscarTexto = JOptionPane.showInputDialog(
                            "¿Qué elemento buscas?");

                    if (buscarTexto == null) {
                        break;
                    }

                    try {
                        int x = Integer.parseInt(buscarTexto);

                        if (L1.pertenece(x)) {
                            JOptionPane.showMessageDialog(null,
                                    x + " pertenece al conjunto A");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    x + " NO pertenece al conjunto A");
                        }

                        if (L2.pertenece(x)) {
                            JOptionPane.showMessageDialog(null,
                                    x + " pertenece al conjunto B");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    x + " NO pertenece al conjunto B");
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Escribe un número entero");
                    }

                    break;

                case 8:

                    if (L1.esSubconjunto(L2)) {
                        JOptionPane.showMessageDialog(null,
                                "A es subconjunto de B");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "A NO es subconjunto de B");
                    }

                    break;

                case 9:

                    if (L1.esIgual(L2)) {
                        JOptionPane.showMessageDialog(null,
                                "A y B son iguales");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "A y B NO son iguales");
                    }

                    break;

                case 10:

                    if (L1.sonDisjuntos(L2)) {
                        JOptionPane.showMessageDialog(null,
                                "A y B son disjuntos: no tienen elementos en común");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "A y B NO son disjuntos: tienen elementos en común");
                    }

                    break;

                case 0:
                    break;

                default:

                    JOptionPane.showMessageDialog(null,
                            "Opción no válida");
            }

        } while (opcion != 0);
    }

    
    public boolean esVacia() {
        return this.cantidad == 0;
    }

    public boolean buscar(int dato) {

        for (int i = 0; i < this.cantidad; i++) {
            if (this.vector[i] == dato) {
                return true;
            }
        }

        return false;
    }

    public void ampliar() {

        int[] nuevo = new int[this.vector.length * 2];

        for (int i = 0; i < this.cantidad; i++) {
            nuevo[i] = this.vector[i];
        }

        this.vector = nuevo;
    }

    public void insertar(int dato) {

        if (this.buscar(dato)) {
            JOptionPane.showMessageDialog(null,
                    "El elemento ya existe en el conjunto");
            return;
        }

        if (this.cantidad == this.vector.length) {
            this.ampliar();
        }

        this.vector[this.cantidad] = dato;
        this.cantidad++;
    }

    public String mostrar(Vectores conjunto) {

        if (conjunto.esVacia()) {
            return "{ }";
        }

        String texto = "{ ";

        for (int i = 0; i < conjunto.cantidad; i++) {

            texto += conjunto.vector[i];

            if (i < conjunto.cantidad - 1) {
                texto += ", ";
            }
        }

        texto += " }";

        return texto;
    }

    public Vectores union(Vectores otra) {

        Vectores resultado = new Vectores();

        for (int i = 0; i < this.cantidad; i++) {
            resultado.insertar(this.vector[i]);
        }

        for (int i = 0; i < otra.cantidad; i++) {
            if (!resultado.buscar(otra.vector[i])) {
                resultado.insertar(otra.vector[i]);
            }
        }

        return resultado;
    }

    public Vectores interseccion(Vectores otra) {

        Vectores resultado = new Vectores();

        for (int i = 0; i < this.cantidad; i++) {
            if (otra.buscar(this.vector[i])) {
                resultado.insertar(this.vector[i]);
            }
        }

        return resultado;
    }

    public Vectores diferencia(Vectores otra) {

        Vectores resultado = new Vectores();

        for (int i = 0; i < this.cantidad; i++) {
            if (!otra.buscar(this.vector[i])) {
                resultado.insertar(this.vector[i]);
            }
        }

        return resultado;
    }

    public Vectores diferenciaSimetrica(Vectores otra) {

        Vectores aMenosB = this.diferencia(otra);
        Vectores bMenosA = otra.diferencia(this);

        return aMenosB.union(bMenosA);
    }

    public Vectores complemento(Vectores universal) {

        Vectores resultado = new Vectores();

        for (int i = 0; i < universal.cantidad; i++) {
            if (!this.buscar(universal.vector[i])) {
                resultado.insertar(universal.vector[i]);
            }
        }

        return resultado;
    }

    public boolean pertenece(int dato) {
        return this.buscar(dato);
    }


    public boolean esSubconjunto(Vectores otra) {

        for (int i = 0; i < this.cantidad; i++) {
            if (!otra.buscar(this.vector[i])) {
                return false;
            }
        }

        return true;
    }

    
    public boolean esIgual(Vectores otra) {

        return this.esSubconjunto(otra)
                && otra.esSubconjunto(this);
    }

    public boolean sonDisjuntos(Vectores otra) {

        for (int i = 0; i < this.cantidad; i++) {
            if (otra.buscar(this.vector[i])) {
                return false;
            }
        }

        return true;
    }
}
