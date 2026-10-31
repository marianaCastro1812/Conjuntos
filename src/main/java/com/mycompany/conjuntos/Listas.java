
package com.mycompany.conjuntos;
import javax.swing.JOptionPane;
/**
 *
 * @author Mari♥
 */
public class Listas {
    private Nodo cabeza;   // apunta al primer nodo
    private Listas listaA;
  

    public Listas() {
       this.cabeza=null;
    }

    public Nodo getCabeza() { return cabeza; }
    public void setCabeza(Nodo cabeza) { this.cabeza = cabeza; }

    public boolean esVacia() {
        return this.cabeza == null;
    }

    

    public void submenu() {
        Listas L1= new Listas();   
        Listas L2 = new Listas();
        int opcion;
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
        Listas U = new Listas();
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
        do {
            String texto = JOptionPane.showInputDialog(
                    null,
                    "--- Conjunto con Lista ---\n\n"
                   + "CONJUNTO A " + mostrar(L1) + "\n " 
                  + "1. AGREGAR CONJUNTO B \n "
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
                    "Lista",
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
                     int n = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos elementos tendrá el conjunto B?"));
    for (int i = 1; i <= n; i++) {
        int dato = Integer.parseInt(JOptionPane.showInputDialog("Elemento " + i + ":"));
        L2.insertar(dato);
    }
                    
                    break;
                case 2:
                    Listas u = L1.union(L2);
                    JOptionPane.showMessageDialog(null, mostrar(u));
                    break;
                case 3:
                    
                    JOptionPane.showMessageDialog(null, mostrar(L1.interseccion(L2)));
                    break;
                     case 4:
                    
                     JOptionPane.showMessageDialog(null, mostrar(L1.diferencia(L2)));
                    break;
                     case 5:
                    
                    JOptionPane.showMessageDialog(null, mostrar(L1.diferenciaSimetrica(L2)));
                    break;
                     case 6:
                    
                     JOptionPane.showMessageDialog(null, "A' = " + mostrar(L1.complemento(U)));
                    break;
                     case 7:
                    
                         int x = Integer.parseInt(JOptionPane.showInputDialog("¿Qué elemento buscas?"));
                         if (L1.pertenece(x)) {
                             JOptionPane.showMessageDialog(null, x + " pertenece al conjunto A");
                         } else {
                             JOptionPane.showMessageDialog(null, x + " NO pertenece al conjunto A");
                         }
                         if (L2.pertenece(x)) {
                             JOptionPane.showMessageDialog(null, x + " pertenece al conjunto A");
                         } else {
                             JOptionPane.showMessageDialog(null, x + " NO pertenece al conjunto A");
                         }
                    break;
                     case 8:
                    
                         if (L1.esSubconjunto(L2)) {
                             JOptionPane.showMessageDialog(null, "A es subconjunto de B");
                         } else {
                             JOptionPane.showMessageDialog(null, "A NO es subconjunto de B");
                         }
                    break;
                     case 9:
             
                         if (L1.esIgual(L2)) {
                             JOptionPane.showMessageDialog(null, "A y B son iguales");
                         } else {
                             JOptionPane.showMessageDialog(null, "A y B NO son iguales");
                         }
                    break;
                     case 10:
                         if (L1.sonDisjuntos(L2)) {
                             JOptionPane.showMessageDialog(null, "A y B son disjuntos: no tienen elementos en común");
                         } else {
                             JOptionPane.showMessageDialog(null, "A y B NO son disjuntos: tienen elementos en común");
                         }
                         break;
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);
    }
    public boolean buscar(int dato) {
        Nodo p = this.cabeza;
        while (p != null) {
            if (p.getDato() == dato) {
                return true;
            }
            p = p.getLiga();
        }
        return false;
    }

    // Inserta al final, sin repetidos
    public void insertar(int dato) {
        if (this.buscar(dato)) {
            JOptionPane.showMessageDialog(null, "El elemento ya existe en el conjunto");
            return;
        }

        Nodo nuevo = new Nodo(dato);

        if (this.esVacia()) {
            this.cabeza = nuevo;
        } else {
            Nodo p = this.cabeza;
            while (p.getLiga() != null) {
                p = p.getLiga();
            }
            p.setLiga(nuevo);
        }
    }
    public String mostrar(Listas Lista) {
    if (Lista.esVacia()) {
        return "{ }";
    }

    String texto = "{ ";
    Nodo p = Lista.cabeza;
    while (p != null) {
        texto += p.getDato();
        if (p.getLiga() != null) {
            texto += ", ";
        }
        p = p.getLiga();
    }
    texto += " }";

    return texto;
}
    
   public Listas union(Listas otra){
   
    Listas resultado = new Listas();

    // 1. Copiar todos los de esta lista (A)
    Nodo p = this.cabeza;
    while (p != null) {
        resultado.insertar(p.getDato());
        p = p.getLiga();
    }

    // 2. Agregar los de la otra lista (B) que no estén ya
    p = otra.getCabeza();
    while (p != null) {
        if (!resultado.buscar(p.getDato())) {
            resultado.insertar(p.getDato());
        }
        p = p.getLiga();
    }

    return resultado;
}
   public Listas interseccion(Listas otra) {
    Listas resultado = new Listas();

    Nodo p = this.cabeza;
    while (p != null) {
        if (otra.buscar(p.getDato())) {
            resultado.insertar(p.getDato());
        }
        p = p.getLiga();
    }

    return resultado;
}

// Diferencia A - B: elementos que están en A pero NO en B
public Listas diferencia(Listas otra) {
    Listas resultado = new Listas();

    Nodo p = this.cabeza;
    while (p != null) {
        if (!otra.buscar(p.getDato())) {
            resultado.insertar(p.getDato());
        }
        p = p.getLiga();
    }

    return resultado;
}

// Diferencia simétrica: elementos que están en uno solo de los dos
// (A - B) ∪ (B - A)
public Listas diferenciaSimetrica(Listas otra) {
    Listas aMenosB = this.diferencia(otra);
    Listas bMenosA = otra.diferencia(this);

    return aMenosB.union(bMenosA);
}
       
   
public Listas complemento(Listas universal) {
    Listas resultado = new Listas();

    Nodo p = universal.cabeza;
    while (p != null) {
        if (!this.buscar(p.getDato())) {
            resultado.insertar(p.getDato());
        }
        p = p.getLiga();
    }

    return resultado;
}

// Pertenencia: el elemento está en el conjunto
// (ya la tienes: es el método buscar)
public boolean pertenece(int dato) {
    return this.buscar(dato);
}

// Subconjunto: todos los elementos de A están en B
public boolean esSubconjunto(Listas otra) {
    Nodo p = this.cabeza;
    while (p != null) {
        if (!otra.buscar(p.getDato())) {
            return false;   // encontró uno que no está en B
        }
        p = p.getLiga();
    }
    return true;
}

// Igualdad: A es subconjunto de B y B es subconjunto de A
public boolean esIgual(Listas otra) {
    return this.esSubconjunto(otra) && otra.esSubconjunto(this);
}

// Disjuntos: no tienen ningún elemento en común
public boolean sonDisjuntos(Listas otra) {
    Nodo p = this.cabeza;
    while (p != null) {
        if (otra.buscar(p.getDato())) {
            return false;   // encontró uno en común
        }
        p = p.getLiga();
    }
    return true;
}}

   