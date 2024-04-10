/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
public class ListaSimpleCircular {

    NodoLSC cabeza;
    NodoLSC ultimo;

//i. InsertaDesayunos
    public void Insertar(Desayunos elemento) {
        if (cabeza == null) {
            cabeza = new NodoLSC(elemento);
            ultimo = cabeza;
            ultimo.setSiguiente(cabeza);

        } else {
            if (elemento.getIdDesayuno() < cabeza.getDato().getIdDesayuno()) {
                NodoLSC auxiliar = new NodoLSC(elemento);
                auxiliar.setSiguiente(cabeza);
                cabeza = auxiliar;
                ultimo.setSiguiente(cabeza);
            } else {
                if (ultimo.getDato().getIdDesayuno() < elemento.getIdDesayuno()) {
                    NodoLSC auxiliar = new NodoLSC(elemento);
                    ultimo.setSiguiente(auxiliar);
                    ultimo = auxiliar;
                    ultimo.setSiguiente(cabeza);
                } else {
                    NodoLSC auxiliar = cabeza;
                    while (auxiliar.getSiguiente().getDato().getIdDesayuno() < elemento.getIdDesayuno()) {
                        auxiliar = auxiliar.getSiguiente();
                    }
                    NodoLSC temporal = new NodoLSC(elemento);
                    temporal.setSiguiente(auxiliar.getSiguiente());
                    auxiliar.setSiguiente(temporal);
                }
            }
        }

    }
    //iii.Modifica el desayuno

    public void Modifica(Desayunos o) {
        if (cabeza != null) {
            if (o.getIdDesayuno() >= cabeza.getDato().getIdDesayuno() && o.getIdDesayuno() <= ultimo.getDato().getIdDesayuno()) {
                NodoLSC aux = cabeza;
                while (aux != ultimo && aux.getDato().getIdDesayuno() < o.getIdDesayuno()) {
                    aux = aux.getSiguiente();
                }

                if (aux.getDato().getIdDesayuno() == o.getIdDesayuno()) {
                    aux.getDato().setDescripcion(o.getDescripcion());
                }
            }
        }

    }

    public void ModificaDos(Desayunos o) {
        if (cabeza != null) {
            if (o.getIdDesayuno() >= cabeza.getDato().getIdDesayuno() && o.getIdDesayuno() <= ultimo.getDato().getIdDesayuno()) {
                NodoLSC aux = cabeza;
                while (aux != ultimo && aux.getDato().getIdDesayuno() < o.getIdDesayuno()) {
                    aux = aux.getSiguiente();
                }

                if (aux.getDato().getIdDesayuno() == o.getIdDesayuno()) {
                    String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del desayuno");
                    int nuevoTipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo tipo de desayuno"));
                    int nuevasCalorias = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de calorias del desayuno"));

                    aux.getDato().setDescripcion(nuevaDescripcion);
                    aux.getDato().setTipo(nuevoTipo);
                    aux.getDato().setCalorias(nuevasCalorias);

                    JOptionPane.showMessageDialog(null, "Desayuno modificado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "Desayuno no encontrado");
                }
            }
        }
    }

//ii. Imprimir Desayunos
    @Override
    public String toString() {
        String respuesta = "Lista circular: \n";
        NodoLSC auxiliar = cabeza;

        if (auxiliar != null) {
            respuesta += auxiliar.toString();
            auxiliar = auxiliar.getSiguiente();
            while (auxiliar != cabeza) {
                respuesta += auxiliar.toString() + "\n";
                auxiliar = auxiliar.getSiguiente();

            }
        } else {
            respuesta += "Vacía";
        }
        return respuesta;
    }

//iv. Crear un método que permita obtener la lista de los desayunos que
//tienen menos de cierta cantidad de calorías: El usuario ingresa la
//cantidad de calorías y se le muestra la lista con los desayunos que
//tienen menos de esa cantidad. 
    public void ConsultaCalorias(int calorias) {

        if (cabeza != null) {

            NodoLSC aux = cabeza;
            String resultados = "Desayunos con menos de " + calorias + " calorías:\n";

            do {
                if (aux.getDato().getCalorias() < calorias) {
                    System.out.println(aux.getDato());
                }
                aux = aux.getSiguiente();
            } while (aux != cabeza);
            JOptionPane.showMessageDialog(null, resultados);

        }//Problema se hace dirigido a la cabeza
    }
}
