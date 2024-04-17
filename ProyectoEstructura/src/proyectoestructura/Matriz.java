/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

/**
 *
 * @author XSF
 */
public class Matriz {
    private int n;
    private int [][] mat;
    private String[] ubi;
    
    public Matriz(int n){
        this.n = n;
        mat = new int[this.n][this.n];
        ubi = new String[this.n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 0;
            }
        }
    }
    
    public void agregarUbi(int in, String nom){
        ubi[in] = nom;
    }
    
    public void agregarCone(int o, int d){
        mat[o][d] += 1;
        mat[d][o] += 1;
    }
    
    public void ruta(int[] ruta){
        System.out.println("Ruta de llegada al hotel:");
        for (int in : ruta) {
            System.out.print(ubi[in] + " -> ");
        }
        System.out.println("Hotel");
    }
    

}
