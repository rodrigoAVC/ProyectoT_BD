
import java.time.LocalTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rui
 */
public class Tienda extends Usuario {
    public LocalTime abre;
    public LocalTime cierra;
    

    public Tienda(LocalTime abre, LocalTime cierra, String nombre, String password) {
        super(nombre, password);
        this.abre = abre;
        this.cierra = cierra;
    }

    public LocalTime getAbre() {
        return abre;
    }

    public void setAbre(LocalTime abre) {
        this.abre = abre;
    }

    public LocalTime getCierra() {
        return cierra;
    }

    public void setCierra(LocalTime cierra) {
        this.cierra = cierra;
    }

    @Override
    public String toString() {
        return "Tienda{" + "abre=" + abre + ", cierra=" + cierra + '}';
    }
    
}
