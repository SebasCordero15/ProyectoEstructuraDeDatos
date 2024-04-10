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
public class ListaDobleCircular {

    private NodoLDC cabeza;
    private NodoLDC ultimo;
//i. Ingresar nuevas habitaciones

    public void Insertar(Habitaciones p) {
        //private int idHabitacion;
        //private int tipo;
        //private int cantidadCamas;
        //private boolean disponibilidad;
 
        // Crear el objeto Habitaciones con la entrada del usuario
        if (cabeza == null) {
            cabeza = new NodoLDC(p);
            ultimo = cabeza;
            cabeza.setAnterior(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAnterior(cabeza);

        } else {
            if (cabeza.getDato().getIdHabitacion() > p.getIdHabitacion()) {
                NodoLDC aux = new NodoLDC(p);
                aux.setSiguiente(cabeza);
                cabeza.setAnterior(aux);
                cabeza = aux;
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);

            } else {
                if (p.getIdHabitacion() > ultimo.getDato().getIdHabitacion()) {
                    NodoLDC aux = new NodoLDC(p);
                    aux.setAnterior(ultimo);
                    ultimo.setSiguiente(aux);
                    ultimo = aux;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    NodoLDC aux = cabeza.getSiguiente();
                    while (aux.getDato().getIdHabitacion() < p.getIdHabitacion()) {
                        aux = aux.getSiguiente();
                    }
                    NodoLDC temp = new NodoLDC(p);
                    temp.setAnterior(aux.getAnterior());
                    temp.setSiguiente(aux);
                    aux.setAnterior(temp);
                    temp.getAnterior().setSiguiente(temp);
                }
            }
        }
    }

//ii. Reservar una habitación: El usuario ingresa el tipo de habitación que
//desea y se deben mostrar las habitaciones disp   
//iii. Imprimir habitacones       
    @Override
    public String toString() {
        String respuesta = "Habitaciones \n";
        if (cabeza != null) {
            NodoLDC aux = cabeza;
            respuesta += aux.toString() + "\n";
            aux = aux.getSiguiente();
            while (aux != cabeza) {
                respuesta += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }
        } else {
            respuesta += "No hay habitaciones";
        }
        return respuesta;
    }
    
    public String imprimirDisponibilidad(){
        String print = "";
        NodoLDC aux = cabeza;
        
        if(cabeza != null){

            if(aux.getDato().getDisponibilidad().equalsIgnoreCase("SI")){
                print += aux.getDato().toString();        
            }

            aux = aux.getSiguiente();
            while(aux != cabeza){

                if(aux.getDato().getDisponibilidad().equalsIgnoreCase("SI")){
                    print += aux.getDato().toString();
                }
                aux = aux.getSiguiente();
            }
        }
            
        else{
            print = "La lista de HABITACIONES está vacía";
        }
            
        return print;
    }
    
    public String printReservarHabitacion(String tipo){
        String print = "";
        NodoLDC aux = cabeza;
        
        if(cabeza != null){

            if(aux.getDato().getDisponibilidad().equalsIgnoreCase("SI") && aux.getDato().getTipo().equalsIgnoreCase(tipo)){
                print += aux.getDato().toString();        
            }

            aux = aux.getSiguiente();
            while(aux != cabeza){

                if(aux.getDato().getDisponibilidad().equalsIgnoreCase("SI") && aux.getDato().getTipo().equalsIgnoreCase(tipo)){
                    print += aux.getDato().toString();
                }
                aux = aux.getSiguiente();
            }
        }else{
            print = "La lista de HABITACIONES está vacía";
        }
            
        return print;
    }

    public void reservarHabitacion(int id){
        NodoLDC aux = cabeza;
        
        if(cabeza != null){

            if(aux.getDato().getIdHabitacion() == id){
                aux.getDato().setDisponibilidad("NO");
            }

            aux = aux.getSiguiente();
            
            while(aux != cabeza){

                if(aux.getDato().getIdHabitacion() == id){
                    aux.getDato().setDisponibilidad("NO");
                    break;
                }
                
                aux = aux.getSiguiente();
            }
        }
    }
    //iv.
    public void aumentarPrecio(String criterio, int cantidad, double porcentaje){
        NodoLDC aux = cabeza;
        double percent = porcentaje / 100.0;
        
        
        
        if(cabeza != null){
            
            if(criterio.equalsIgnoreCase("Cantidad de camas")){
                if(aux.getDato().getCantidadCamas() == cantidad){
                    aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                }
                
                aux = aux.getSiguiente();
            
                while(aux != cabeza){

                    if(aux.getDato().getCantidadCamas() == cantidad){
                        aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                    }

                    aux = aux.getSiguiente();
                }
            }
            if (criterio.equalsIgnoreCase("ID")) {
                if (aux.getDato().getIdHabitacion() == cantidad) {
                    aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                }

                aux = aux.getSiguiente();

                while (aux != cabeza) {

                    if (aux.getDato().getIdHabitacion() == cantidad) {
                        aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                        break;
                    }

                    aux = aux.getSiguiente();
                }
            }//Se duplica porque el Joption pane solo tira valores booleanos , por eso el metodo no acepta cantidad de tipo string se duplica
            if (criterio.equalsIgnoreCase("Tipo de habitación")) {
                if (cantidad == 0) {
                    if (aux.getDato().getTipo().equals("Estandar")) {
                        aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                    }

                    aux = aux.getSiguiente();

                    while (aux != cabeza) {

                        if (aux.getDato().getTipo().equals("Estandar")) {
                            aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                            break;
                        }

                        aux = aux.getSiguiente();
                    }

                } else if (cantidad == 1) {
                    if (aux.getDato().getTipo().equals("Premium")) {
                        aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                    }

                    aux = aux.getSiguiente();

                    while (aux != cabeza) {

                        if (aux.getDato().getTipo().equals("Premium")) {
                            aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                            break;
                        }

                        aux = aux.getSiguiente();
                    }

                }
            }
            
            if(criterio.equalsIgnoreCase("Precio")){
                if(aux.getDato().getPrecio() == cantidad){
                    aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                }
                
                aux = aux.getSiguiente();
            
                while(aux != cabeza){

                    if(aux.getDato().getPrecio() == cantidad){
                        aux.getDato().setPrecio(aux.getDato().getPrecio() + (aux.getDato().getPrecio() * percent));
                    }

                    aux = aux.getSiguiente();
                }
                
        } else {
            System.out.println("La lista de HABITACIONES está vacía");
        }
    }

    }
}
