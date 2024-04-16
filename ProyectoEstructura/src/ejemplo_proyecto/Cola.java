
package ejemplo_proyecto;

import javax.swing.JOptionPane;


public class Cola {
    private NodoCola inicio;
    private NodoCola fin;

    public Cola() {
    }

    public NodoCola getInicio() {
        return inicio;
    }

    public void setInicio(NodoCola inicio) {
        this.inicio = inicio;
    }

    public NodoCola getFin() {
        return fin;
    }

    public void setFin(NodoCola fin) {
        this.fin = fin;
    }
    
    public void Encolar(){
        Clientes c = new Clientes();
        
        c.setNombre(JOptionPane.showInputDialog("Ingrese el nombre completo del cliente."));
        c.setCedula(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula del cliente sin guiones.")));
        c.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente.")));
        int membresia =JOptionPane.showConfirmDialog(null, "¿Tiene membresia?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if(membresia==0){
            c.setMembresia("si");
        }else{
            c.setMembresia("no");
        }
        c.setFechaReserva(JOptionPane.showInputDialog("Ingrese la fecha de la reserva en el siguiente formato."
                                                    + "\n01-01-2023"));
        
        NodoCola encolar = new NodoCola();
        
        encolar.setElemento(c);
        
        if(inicio == null){
            inicio = encolar;
            fin = encolar;
        }
        else{
            fin.setAtras(encolar);
            fin = encolar;
        }                                  
    }

    public void clienteSiguiente(){
        JOptionPane.showMessageDialog(null,"El proximo cliente de la cola es:"
                         + "\nNombre: " + inicio.getElemento().getNombre()
                         + "\nCedula: " + inicio.getElemento().getCedula()
                         + "\nEdad: " + inicio.getElemento().getEdad()
                         + "\n¿Tiene Membresia? : " + inicio.getElemento().getMembresia()
                         + "\nFecha de Reserva: " + inicio.getElemento().getFechaReserva());
        inicio = inicio.getAtras();
    }
    
    public void vaciarCola(){
        
        if(inicio != null){
            while(inicio != null){
                inicio = inicio.getAtras();
            }

            if(inicio == null){
                JOptionPane.showMessageDialog(null,"La cola se vacío correctamente.");
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"La cola está vacía.");
        }
    }
    
    public void posicionCliente() {
        int posicion = 0;
        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cedula del cliente sin guiones."));
        NodoCola temp = inicio; 

        if (temp == null) {
            JOptionPane.showMessageDialog(null,"La cola está vacía.");
        } 
        else {
            while (temp != null) {
                if (cedula == temp.getElemento().getCedula()) {
                    posicion += 1;
                    JOptionPane.showMessageDialog(null,"La persona buscada está en la posición número " + posicion + ".");
                    break; 
                } 
                else {
                    posicion += 1;
                    temp = temp.getAtras();
                }
            }

            if (temp == null) {
                JOptionPane.showMessageDialog(null,"La persona buscada no está en la cola.");
                }
        }
    }
    
    public void tamañoCola(){
        int tam = 0;
        NodoCola temp = inicio;
        
        if (temp == null) {
            JOptionPane.showMessageDialog(null,"La cola está vacía.");
        }
        else{
            while (temp != null) {
                tam += 1;
                temp = temp.getAtras();
            }
            JOptionPane.showMessageDialog(null,"El tamaño de la cola es de " + tam + " clientes.");
        }
    }
    
   
    @Override
    public String toString(){
        String cadena = "Los clientes en la cola son:";
        NodoCola temp;
        temp = inicio;
        
        if(temp == null){
            cadena = "La cola está vacía.";
        }else{
            while(temp != null){
                cadena += "\n-----------------------------------------------" 
                        + "\nNombre: " + temp.getElemento().getNombre()
                        + "\nCedula: " + temp.getElemento().getCedula()
                        + "\nEdad: " + temp.getElemento().getEdad()
                        + "\n¿Tiene Membresia? : " + temp.getElemento().getMembresia()
                        + "\nFecha de Reserva: " + temp.getElemento().getFechaReserva();
                
                temp = temp.getAtras();
            } 
        }
        return cadena;
    }
    
    //bunta 5.vi//
     public void EncolarCola(Clientes ci){
        Clientes c = new Clientes();
        
        c.setNombre(ci.getNombre());
        c.setCedula(ci.getCedula());
        c.setEdad(ci.getEdad());
        c.setMembresia(ci.getMembresia());
        c.setFechaReserva(ci.getFechaReserva());
        
        NodoCola encolar = new NodoCola();
        
        encolar.setElemento(c);
        
        if(inicio == null){
            inicio = encolar;
            fin = encolar;
        }
        else{
            fin.setAtras(encolar);
            fin = encolar;
        }                                 
    }
    
    NodoCola frenteClone;
    NodoCola ultimoClone;
    NodoCola frenteAux;
    NodoCola ultimoAux;
    
    public void EncolarClone(NodoCola elemento){
        NodoCola encolar = new NodoCola();
        
        encolar.setElemento(elemento.getElemento());
        
        if(frenteClone == null){
            frenteClone = encolar;
            ultimoClone = encolar;
        }
        else{
            ultimoClone.setAtras(encolar);
            ultimoClone = encolar;
        }                       
    }
    
    public void Encolaraux(NodoCola elemento){
          NodoCola encolar = new NodoCola();
        
        encolar.setElemento(elemento.getElemento());
        
        if(frenteAux == null){
            frenteAux = encolar;
            ultimoAux = encolar;
        }
        else{
            ultimoAux.setAtras(encolar);
            ultimoAux = encolar;
        }                                
    }

    public void prioridadCliente(NodoCola elemento) {
        
        if (elemento != null) {
            if (elemento.getElemento().getMembresia().equals("si")) {
                EncolarClone(elemento);
                

                inicio = inicio.getAtras();
            } else {
                if (elemento.getElemento().getMembresia().equals("no")) {
                    Encolaraux(elemento);
                    
                    inicio = inicio.getAtras();
                }
            }
            prioridadCliente(inicio);
        } else {

            while (frenteClone != null) {
                EncolarCola(frenteClone.getElemento());
                frenteClone = frenteClone.getAtras();
            }
            while (frenteAux != null) {
                EncolarCola(frenteAux.getElemento());
                frenteAux = frenteAux.getAtras();
            }
        }
    }
         
    
    
}

