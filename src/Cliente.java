/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rui
 */
public class Cliente extends Usuario{
    public String correo_elec;

    public Cliente(String correo_elec,String nombre, String password) {
        super(nombre, password);
        this.correo_elec = correo_elec;
    }

    public String getCorreo_elec() {
        return correo_elec;
    }

    public void setCorreo_elec(String correo_elec) {
        this.correo_elec = correo_elec;
    }

    
    
    @Override
    public String toString() {
        return "Cliente{" + ", nombre=" + super.getNombre() + ", password=" + super.getPassword() + "correo_elec=" + correo_elec + '}';
    }
    
    
}
