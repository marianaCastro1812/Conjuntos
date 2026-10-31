

package com.mycompany.conjuntos;

import javax.swing.JOptionPane;

public class Conjuntos {

    public static void main(String[] args) {

        int opcion;

        do {
            String texto = JOptionPane.showInputDialog(
                    null,
                    "--- GESTIÓN DE CONJUNTOS ---\n\n"
                    + "1. Conjuntos en Listas\n"
                    + "2. Conjuntos en Vectores\n"
                    + "0. Salir\n\n"
                    + "Elige una opción:",
                    "Conjuntos",
                    JOptionPane.QUESTION_MESSAGE);

            if (texto == null) {
                break;
            }

            try {
                opcion = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escribe solo números");
                opcion = -1;
                continue;
            }

            switch (opcion) {
                case 1:
                    Listas objetoLista = new Listas();
                    objetoLista.submenu();
                    break;

                case 2:
                    Vectores objetoVector = new Vectores();
                    objetoVector.submenu();
                    break;

                case 0:
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }

        } while (opcion != 0);
    }
}

