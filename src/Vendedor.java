/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rui
 */
public class Vendedor extends Usuario {

    public Vendedor(String nombre, String password) {
        super(nombre, password);
    }
    
    @Override
    public String toString() {
        return "Vendedor{" + ", nombre=" + super.getNombre() + ", password=" + super.getPassword() + '}';
    }
    
}
