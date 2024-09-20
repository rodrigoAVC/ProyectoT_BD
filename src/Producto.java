/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rui
 */
public class Producto {
    public int upc;
    public String nombre;
    public float size;
    public String embalaje;
    public String marca;
    public String tipo;

    public Producto(int upc, String nombre, float size, String embalaje, String marca, String tipo) {
        this.upc = upc;
        this.nombre = nombre;
        this.size = size;
        this.embalaje = embalaje;
        this.marca = marca;
        this.tipo = tipo;
    }

    public int getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(String embalaje) {
        this.embalaje = embalaje;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" + "upc=" + upc + ", nombre=" + nombre + ", size=" + size + ", embalaje=" + embalaje + ", marca=" + marca + ", tipo=" + tipo + '}';
    }
    
}
