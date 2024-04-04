/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_proyecto;

/**
 *
 * @author valer
 */
public class Desayunos {
    private int idDesayuno;
    private String descripcion;
    private int tipo;
    private int calorias;

    public Desayunos() {
    }

    public Desayunos(int idDesayuno, String descripcion, int tipo, int calorias) {
        this.idDesayuno = idDesayuno;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getIdDesayuno() {
        return idDesayuno;
    }

    public void setIdDesayuno(int idDesayuno) {
        this.idDesayuno = idDesayuno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Desayunos{" + "idDesayuno=" + idDesayuno + ", descripcion=" + descripcion + ", tipo=" + tipo + ", calorias=" + calorias + '}';
    }


}
