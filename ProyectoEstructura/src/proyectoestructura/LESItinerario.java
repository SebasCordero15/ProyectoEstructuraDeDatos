package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
// lista enlazada simple
public class LESItinerario {

    private NodoA inicio;

    public LESItinerario() {
        this.inicio = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Actividad a) {

        NodoA nuevo = new NodoA();
        
        nuevo.setDato(a);
        
        if (vacia()) {
            inicio = nuevo;
            /* si el valor que voy a a insertar es menor que el que esta en la lista
            se inserta el dato a la izquierda ej. tengo un 10 y voy a insertar un 5 */
        } else if (a.getIdActividad() < inicio.getDato().getIdActividad()) {
            // creo el enlace
            nuevo.setSiguiente(inicio);
            // se coloca el dato inicial
            inicio = nuevo;
            // si el valor del ultimo en la lista (siguiente) es null e coloca a la derecha
        } else if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(nuevo);
        } else {// insertar al medio
            NodoA aux = inicio;
            /*mientras el dato siguinte no este nulo y el dato a insertar sea
            mayor que el de la lista apunta al siguiente*/
            while ((aux.getSiguiente() != null) && aux.getSiguiente().getDato().getIdActividad()< a.getIdActividad()) {
                aux = aux.getSiguiente();
            }
            //creo el enlace al siguiente
            nuevo.setSiguiente(aux.getSiguiente());
            // se inserta en el medio
            aux.setSiguiente(nuevo);

        }
    }
    
    public void mostrar() {
        if (!vacia()) {
            String s = "";
            NodoA aux = inicio;
            while (aux != null) {
                s += aux.toString();
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s,
                    "Contenido de la lista", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al mostrar", "Lista Vacia", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public  void eliminarActividad(int id){
        if(!vacia()){
            if(inicio.getDato().getIdActividad()==id){
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null, "Actividad eliminada");
            }
            else{
                NodoA anterior;
                NodoA aux;
                anterior = inicio;
                aux = inicio.getSiguiente();
                
                while((aux != inicio) && (aux.getSiguiente().getDato().getIdActividad() != id)){
                    anterior = anterior.getSiguiente();
                    aux = aux.getSiguiente();
                }
                if(aux == inicio){
                    System.out.println("El ID  buscado no existe, no se puede eliminar la actividad");
                }
                if (aux != null) {
                    anterior.setSiguiente(aux.getSiguiente());
                }
            }
        }
        else{
            System.out.println("La  lista de actividades se encuentra vacía");
        }
    }
    
    public String imprimirHorarios(String horario){
        String s = "";
        String diurnas = "";
        String nocturnas = "";
        NodoA aux = inicio;
        
        if(inicio != null){
            if(horario.equalsIgnoreCase("Diurno")){
                if(aux.getDato().getHorario().equalsIgnoreCase("Diurno")){
                    diurnas += aux.getDato().toString();
                }
                
                aux = aux.getSiguiente();
                while(aux != inicio){
                    if(aux.getDato().getHorario().equalsIgnoreCase("Diurno")){
                        diurnas += aux.getDato().toString();
                    }
                    aux = aux.getSiguiente();
                }
            }
            
            if(horario.equalsIgnoreCase("Nocturno")){

                if(aux.getDato().getHorario().equalsIgnoreCase("Nocturno")){
                    nocturnas += aux.getDato().toString();
                }
                
                aux = aux.getSiguiente();
                while(aux != inicio){
                    if(aux.getDato().getHorario().equalsIgnoreCase("Nocturno")){
                        nocturnas += aux.getDato().toString();
                    }
                    aux = aux.getSiguiente();
                }
            }
            s = nocturnas + diurnas; 
        }else{
            s = "La lista de actividades está vacía";
        }
            
        return s;
    }
}
