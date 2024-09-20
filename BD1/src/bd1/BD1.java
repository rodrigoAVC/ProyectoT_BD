/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bd1;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author luisc
 */
public class BD1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       DBA db = new DBA();
       db.conectar();
       db.desconectar();
      
    }
    
}
