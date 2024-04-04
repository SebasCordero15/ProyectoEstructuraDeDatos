
package ejemplo_proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author valer
 */
public class ListaActividades {

    private NodoActividad cabeza;
    private NodoActividad ultimo;
//i. Ingresar nuevas habitaciones

    public void Insertar(Actividad a) {
     
        Actividad h = new Actividad();
 
        
        // Crear el objeto Actividad con la entrada del usuario
        if (cabeza == null) {
            cabeza = new NodoActividad(a);
            ultimo = cabeza;
            cabeza.setAnterior(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAnterior(cabeza);

        } else {
            if (cabeza.getDato().getIdActividad()> a.getIdActividad()) {
                NodoActividad aux = new NodoActividad(a);
                aux.setSiguiente(cabeza);
                cabeza.setAnterior(aux);
                cabeza = aux;
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);

            } else {
                if (a.getIdActividad()> ultimo.getDato().getIdActividad()) {
                    NodoActividad aux = new NodoActividad(a);
                    aux.setAnterior(ultimo);
                    ultimo.setSiguiente(aux);
                    ultimo = aux;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    NodoActividad aux = cabeza.getSiguiente();
                    while (aux.getDato().getIdActividad()< a.getIdActividad()) {
                        aux = aux.getSiguiente();
                    }
                    NodoActividad temp = new NodoActividad(a);
                    temp.setAnterior(aux.getAnterior());
                    temp.setSiguiente(aux);
                    aux.setAnterior(temp);
                    temp.getAnterior().setSiguiente(temp);
                }
            }
        }
    }

    public String imprimirActividades(String orden){
        String print = "";
        NodoActividad nodoAct;
        
        if(cabeza != null){
            if(orden.equalsIgnoreCase("D")){
                nodoAct = cabeza;
                print +=  nodoAct.getDato().toString();
                nodoAct = nodoAct.getSiguiente();
                
                while(nodoAct != cabeza){
                    print += nodoAct.getDato().toString();
                    nodoAct = nodoAct.getSiguiente();
                } 
            }
            else if(orden.equalsIgnoreCase("A")){
                nodoAct = ultimo;
                print +=  nodoAct.getDato().toString();
                nodoAct = nodoAct.getAnterior();
                
                while(nodoAct != ultimo){
                    print += nodoAct.getDato().toString();
                    nodoAct = nodoAct.getAnterior();
                }
            }
        }
        else{
            print = "La  lista está vacía";
        }
        
        return print;
    }
    
    public  void elimarActividad(int id){
        if(cabeza != null){
            if(id  == cabeza.getDato().getIdActividad()){
                cabeza = cabeza.getSiguiente();
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);
            }
            else{
                NodoActividad aux = cabeza; 
                aux = aux.getSiguiente();
                
                while(aux != cabeza && aux.getSiguiente().getDato().getIdActividad() != id){
                    aux = aux.getSiguiente();
                }
                if(aux == cabeza){
                    System.out.println("El ID  buscado no existe, no se puede eliminar");
                }
                else{
                    if(aux.getSiguiente() == ultimo){
                        ultimo = aux;
                        ultimo.setSiguiente(cabeza);
                    }
                    else{
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        aux.getSiguiente().getSiguiente().setAnterior(aux);
                    }
                    
                }
            }
        }
        else{
            System.out.println("La  lista está vacía");
        }
    }
    
    public String imprimirPorHorario(String horario){
        String print = "";
        String diurnas = "";
        String nocturnas = "";
        NodoActividad aux = cabeza;
        
        if(cabeza != null){
            if(horario.equalsIgnoreCase("Diurno")){
                if(aux.getDato().getHorario().equalsIgnoreCase("Diurno")){
                    diurnas += aux.getDato().toString();
                }
                
                aux = aux.getSiguiente();
                while(aux != cabeza){
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
                while(aux != cabeza){
                    if(aux.getDato().getHorario().equalsIgnoreCase("Nocturno")){
                        nocturnas += aux.getDato().toString();
                    }
                    aux = aux.getSiguiente();
                }
            }
            print = nocturnas + diurnas; 
        }else{
            print = "La lista de actividades está vacía";
        }
            
        return print;
    }
   
    @Override
    public String toString() {
        String respuesta = "Actividad \n";
        if (cabeza != null) {
            NodoActividad aux = cabeza;
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


}
