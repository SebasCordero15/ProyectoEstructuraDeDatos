
package ejemplo_proyecto;

/**
 *
 * @author alede
 */
public class Arbol {
    private NodoArbol raiz;
    
    public Arbol() {
        raiz = null;
    }
    
    public void insertar(Clientes c){
        raiz = insertarCliente(raiz, c);
    }
    
    private NodoArbol insertarCliente(NodoArbol nodo, Clientes c){
        if(nodo == null){
            nodo = new NodoArbol(c);
            return nodo; 
        }
        
        if(c.getEdad() < nodo.cliente.getEdad()){
            nodo.izquierda = insertarCliente(nodo.izquierda, c);
        }
        else if(c.getEdad() > nodo.cliente.getEdad()){
            nodo.derecha = insertarCliente(nodo.derecha, c);
        }
        
        return nodo;
    }
    
    private void recorrerOrden(NodoArbol nodo){
        if(nodo != null){
            recorrerOrden(nodo.izquierda);
            
            System.out.println(nodo.cliente.toString());
            
            recorrerOrden(nodo.derecha);
        }
    }
    
    public void recorrerEnOrden(){
        recorrerOrden(raiz);
    }
    
    private void recorrerPreOrden(NodoArbol nodo){
        if(nodo != null){
            System.out.println(nodo.cliente.toString());
            
            recorrerOrden(nodo.izquierda);
            
            recorrerOrden(nodo.derecha);
        }
    }
    
    public void recorrerEnPreOrden(){
        recorrerPreOrden(raiz);
    }
    
    private void recorrerPosOrden(NodoArbol nodo){
        if(nodo != null){
            
            recorrerOrden(nodo.izquierda);
            
            recorrerOrden(nodo.derecha);
            
            System.out.println(nodo.cliente.toString());
        }
    }
    
    public void recorrerEnPosOrden(){
        recorrerPosOrden(raiz);
    }
    
    private int contarClientes(NodoArbol nodo){
        int cantidad = 0;
        
        if(nodo == null){
            return 0;
        }
        
        if(nodo != null){
            cantidad += 1;
        }
        
        cantidad += contarClientes(nodo.izquierda);
        cantidad += contarClientes(nodo.derecha);
        
        return cantidad;
    }
    
    public void contarClientes(){
        if(raiz != null){
            System.out.println(contarClientes(raiz));
        }
        else{
            System.out.println("El arbol está vacío");
        }   
    }
    
}
