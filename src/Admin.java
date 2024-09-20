/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rui
 */
public class Admin extends Usuario {

    public Admin(String nombre, String password) {
        super(nombre, password);
    }

    @Override
    public String toString() {
        return "Admin{" + ", nombre=" + super.getNombre() + ", password=" + super.getPassword() + '}';
    }
    
}
