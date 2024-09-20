/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rui
 */
public class Venta {
    public int vdd_id;
    public int prd_upc;

    public Venta(int vdd_id, int prd_upc) {
        this.vdd_id = vdd_id;
        this.prd_upc = prd_upc;
    }

    public int getVdd_id() {
        return vdd_id;
    }

    public void setVdd_id(int vdd_id) {
        this.vdd_id = vdd_id;
    }

    public int getPrd_upc() {
        return prd_upc;
    }

    public void setPrd_upc(int prd_upc) {
        this.prd_upc = prd_upc;
    }

    @Override
    public String toString() {
        return "Venta{" + "vdd_id=" + vdd_id + ", prd_upc=" + prd_upc + '}';
    }
    
}
