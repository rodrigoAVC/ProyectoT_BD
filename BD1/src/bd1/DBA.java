/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd1;

/**
 *
 * @author luisc
 */
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class DBA {
    // Atributos para conexión con base de datos AWS
    private String url;
    private String user;
    private String contrasena;
    private Connection conexion;

    // Constructor con Datos Fijos
    public DBA() {
        this.url = "jdbc:sqlserver://database-1.cfqehlgfauqf.us-east-1.rds.amazonaws.com:1433;databaseName=Project;encrypt=true;trustServerCertificate=true";
        this.user = "admin";
        this.contrasena = "gruponumero5";
    }

    public void conectar() {
        try {
            conexion = DriverManager.getConnection(url,user,contrasena);
            JOptionPane.showMessageDialog(null, "Conexion exitosa a SQL Server.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }

    public Connection obtenerConexion() {
        return conexion;
    }

    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
                JOptionPane.showMessageDialog(null, "Conexion cerrada.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Metodos para llamar Procedimientos Almacenados

    // Metodos CRUD Tienda
    public void InsertTiendas(String nombre, String horario) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertTiendas(?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setString(1, nombre);
            stmt.setString(2, horario);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Tienda insertada exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void UpdateTiendas(int id, String nombre, String horario) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL updateTiendas(?, ?, ?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, id);
        stmt.setString(2, nombre);
        stmt.setString(3, horario);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Tienda actualizada exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    public void DeleteTiendas(int id) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL deleteTiendas(?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, id);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Tienda eliminada exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    // Metods Ubicación
    public void InsertUbicaciones(String ubicacion) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertUbicaciones(?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setString(1, ubicacion);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Ubicacion insertada exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void DeleteUbicaciones(int idT) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL deleteUbicaciones(?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, idT);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Ubicación eliminada exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    // Metodos CRUD Vendedor
    public void InsertVendedores(String nombre) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertVendedores(?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setString(1, nombre);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Vendedor insertadado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void UpdateVendedores(int id, String nombre) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL updateVendedores(?, ?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, id);
        stmt.setString(2, nombre);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Vendedor actualizado exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    public void DeleteVendedores(int id) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL deleteVendedores(?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, id);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Vendedor eliminado exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    // Metodos CRUD Vende - Relación entre Vendedores y Productos
    public void InsertVende(int idV, int upc) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertVende(?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1, idV);
            stmt.setInt(2, upc);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Vende insertadado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void DeleteVende(int idV, int upc) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL deleteVende(?, ?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, idV);
        stmt.setInt(2, upc);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Vende eliminado exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    // Metodos CRUD Cliente
    public void InsertClientes(String nombre, String correo) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertClientes(?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setString(1, nombre);
            stmt.setString(2, correo);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente insertado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void UpdateClientes(int id, String nombre, String correo) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL updateClientes(?, ?, ?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, id);
        stmt.setString(2, nombre);
        stmt.setString(3, correo);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Cliente actualizado exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    public void DeleteClientes(int id) {
    CallableStatement stmt = null;
    try {
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        String sql = "{CALL deleteClientes(?)}";
        stmt = conexion.prepareCall(sql);

        stmt.setInt(1, id);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    // Metodos CRUD Productos
    public void InsertProductos(int numero, String nombre, float tamanio, String embalaje, String marca, String tipo) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertProductos(?, ?, ?, ?, ?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1,numero);
            stmt.setString(2, nombre);
            stmt.setFloat(3, tamanio);
            stmt.setString(4, embalaje);
            stmt.setString(5, marca);
            stmt.setString(6, tipo);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Producto insertado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void UpdateProductos(int upc, int numero, String nombre, float tamanio, String embalaje, String marca, String tipo) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL updateProductos(?, ?, ?, ?, ?, ?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1, upc);
            stmt.setInt(2,numero);
            stmt.setString(3, nombre);
            stmt.setFloat(4, tamanio);
            stmt.setString(5, embalaje);
            stmt.setString(6, marca);
            stmt.setString(7, tipo);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void DeleteProductos(int upc) {
    CallableStatement stmt = null;
    try {
        // Ensure connection is open
        if (conexion == null || conexion.isClosed()) {
            conectar();
        }

        // Prepare the stored procedure call
        String sql = "{CALL deleteProductos(?)}";
        stmt = conexion.prepareCall(sql);

        // Set the input parameter
        stmt.setInt(1, upc);

        // Execute the stored procedure
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close the statement if it's not null
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    // Métodos CRUD Factura
    public void InsertFacturas(int idT, int idC, Date fecha, float subtotal, String ISV, float Total) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertFacturas(?, ?, ?, ?, ?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1,idT);
            stmt.setInt(2, idC);
            stmt.setDate(3, (java.sql.Date) fecha);
            stmt.setFloat(4, subtotal);
            stmt.setString(5, ISV);
            stmt.setFloat(6, Total);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Factura insertada exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void UpdateFacturas(int numero, int idT, int idC, Date fecha, float subtotal, String ISV, float Total) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL updateFacturas(?, ?, ?, ?, ?, ?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1, numero);
            stmt.setInt(2,idT);
            stmt.setInt(3, idC);
            stmt.setDate(4, (java.sql.Date) fecha);
            stmt.setFloat(5, subtotal);
            stmt.setString(6, ISV);
            stmt.setFloat(7, Total);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Factura actualizada exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void DeleteFacturas(int numero, int idT, int idC, Date fecha, float subtotal, String ISV, float Total) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL deleteFacturas(?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1, numero);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Factura eliminada exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Métodos CRUD Tiene - Relación entre Productos y Tiendas
    public void InsertTiene(int idT, int upc, float precio, int cantidad, String reordenar) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL insertTiene(?, ?, ?, ?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1,idT);
            stmt.setInt(2, upc);
            stmt.setFloat(3,precio);
            stmt.setInt(4, cantidad);
            stmt.setString(5, reordenar);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Tiene insertado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void UpdateTiene(int idT, int upc, float precio, int cantidad, String reordenar) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL updateTiene(?, ?, ?, ?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1,idT);
            stmt.setInt(2, upc);
            stmt.setFloat(3,precio);
            stmt.setInt(4, cantidad);
            stmt.setString(5, reordenar);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Tiene actualizado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void DeleteTiene(int idT, int upc) {
        CallableStatement stmt = null;
        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "{CALL deleteTiene(?, ?, ?, ?, ?)}";
            stmt = conexion.prepareCall(sql);

            stmt.setInt(1,idT);
            stmt.setInt(2, upc);

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Tiene eliminado exitosamente.");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar al: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el statement: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    // Métodos para llamar Vistas Complejas
    
    // Método para Vista Inventario
    public String Vista_Inventario() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_Inventario"; 
            stmt = conexion.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombreTienda = rs.getString("NombreTienda");
                String nombreProducto = rs.getString("NombreProducto");
                int cantidad = rs.getInt("Cantidad");
                double precio = rs.getDouble("Precio");

                result.append(nombreTienda)
                      .append("&").append(nombreProducto)
                      .append("&").append(cantidad)
                      .append("&").append(precio)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1); 
            }

        } catch (SQLException e) {
            result.setLength(0); 
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
    
    // Metodo para Vista Compras por Cliente
     public String Vista_ComprasPorCliente() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_ComprasPorCliente"; // Use your view's actual name
            stmt = conexion.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombreCliente = rs.getString("NombreCliente");
                int idCliente = rs.getInt("idCliente");
                int numeroCompras = rs.getInt("NumeroCompras");

                result.append(nombreCliente)
                      .append("&").append(idCliente)
                      .append("&").append(numeroCompras)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1); 
            }

        } catch (SQLException e) {
            result.setLength(0); 
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     // Metodo para Vista Historial de Ventas por Tienda
     public String Vista_HistorialVentasxTienda() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_HistorialVentasxTienda";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombreTienda = rs.getString("NombreTienda");
                int idTienda = rs.getInt("idTienda");
                int numeroVentas = rs.getInt("NumeroVentas");

                result.append(nombreTienda)
                      .append("&").append(idTienda)
                      .append("&").append(numeroVentas)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     // Metodo para Vista Top 5 Tiendas con mas ventas
     public String Vista_Top5TiendasConMasVentas() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_Top5TiendasConMasVentas";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String nombreTienda = rs.getString("NombreTienda");
                float totalVentas = rs.getFloat("TotalVentas");

                result.append(nombreTienda)
                      .append("&").append(totalVentas)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     // Metodo para Vista Top 20 Productos por Tienda
     public String Vista_Top20ProductsPorTienda() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_Top20ProductsPorTienda";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String tienda = rs.getString("Tienda");
                String producto = rs.getString("Producto");
                int totalVentas = rs.getInt("TotalVentas");

                result.append(tienda)
                      .append("&").append(producto)
                      .append("&").append(totalVentas)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     //Metodo para Vista Top 3 Productos excepto Computadoras
     public String Vista_Top3ProductosNoComputadora() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_Top3ProductosNoComputadora";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String tipoProducto = rs.getString("TipoProducto");
                int totalVentas = rs.getInt("TotalVentas");

                result.append(tipoProducto)
                      .append("&").append(totalVentas)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     //Metodo para Vista PS5 vs XBOX
     public String Vista_PS5vsXBOX() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vw_CocaColaVsPepsi";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String tienda = rs.getString("Tienda");
                int cocaColaVentas = rs.getInt("CocaColaVentas");
                int pepsiVentas = rs.getInt("PepsiVentas");
                String masVendido = rs.getString("MasVendido");

                result.append(tienda)
                      .append("&").append(cocaColaVentas)
                      .append("&").append(pepsiVentas)
                      .append("&").append(masVendido)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
    // Metods para llamar Vistas Simples
     
     // Vista Tiendas
     public String Vista_VerTiendas() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerTiendas"; // Use your view's actual name
            stmt = conexion.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idT = rs.getInt("idT");
                String nombre = rs.getString("nombre");
                String horario = rs.getString("horario");

                result.append(idT)
                      .append("&").append(nombre)
                      .append("&").append(horario)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1); 
            }

        } catch (SQLException e) {
            result.setLength(0); 
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     // Vista Clientes
     public String fetchFromVistaVerClientes() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerClientes";
            stmt = conexion.createStatement();

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idC = rs.getInt("idC");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");

                result.append(idC)
                      .append("&").append(nombre)
                      .append("&").append(correo != null ? correo : "NULL") 
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1); 
            }

        } catch (SQLException e) {
            result.setLength(0); 
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
    
     // Vista Facturas
     public String Vista_VerFacturas() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerFacturas";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int numero = rs.getInt("numero");
                int idT = rs.getInt("idT");
                int idC = rs.getInt("idC");
                String fecha = rs.getString("fecha");
                float subtotal = rs.getFloat("subtotal");
                String isv = rs.getString("ISV");
                float total = rs.getFloat("total");

                result.append(numero)
                      .append("&").append(idT)
                      .append("&").append(idC)
                      .append("&").append(fecha)
                      .append("&").append(subtotal)
                      .append("&").append(isv)
                      .append("&").append(total)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
    
     // Vista Productos
     public String Vista_VerProductos() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerProductos";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int upc = rs.getInt("upc");
                int numero = rs.getInt("numero");
                String nombre = rs.getString("nombre");
                float tamanio = rs.getFloat("tamanio");
                String embalaje = rs.getString("embalaje");
                String marca = rs.getString("marca");
                String tipo = rs.getString("tipo");

                result.append(upc)
                      .append("&").append(numero)
                      .append("&").append(nombre)
                      .append("&").append(tamanio)
                      .append("&").append(embalaje)
                      .append("&").append(marca)
                      .append("&").append(tipo)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     // Vista Vendedores
     public String Vista_VerVendedores() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerVendedores";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idV = rs.getInt("idV");
                String nombreVendedor = rs.getString("nombre_vendedor");

                result.append(idV)
                      .append("&").append(nombreVendedor)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     // Vista Ubicaciones
     public String Vista_VerUbicaciones() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerUbicaciones";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idT = rs.getInt("idT");
                String ubicacion = rs.getString("ubicacion");

                result.append(idT)
                      .append("&").append(ubicacion)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
     // Vista Vende
     public String Vista_VerVende() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerVende";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idV = rs.getInt("idV");
                int upc = rs.getInt("upc");

                result.append(idV)
                      .append("&").append(upc)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
    
    // Vista Tiene
     public String Vista_VerTiene() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerTiene";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idT = rs.getInt("idT");
                int upc = rs.getInt("upc");
                float precio = rs.getFloat("precio");
                int cantidad = rs.getInt("cantidad");
                String reordenar = rs.getString("reordenar");

                result.append(idT)
                      .append("&").append(upc)
                      .append("&").append(precio)
                      .append("&").append(cantidad)
                      .append("&").append(reordenar)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }
     
    // Vista Bitacora
    public String Vista_VerBitacora() {
        Statement stmt = null;
        ResultSet rs = null;
        StringBuilder result = new StringBuilder();

        try {
            if (conexion == null || conexion.isClosed()) {
                conectar();
            }

            String sql = "SELECT * FROM vista_VerBitacora";
            stmt = conexion.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int idBitacora = rs.getInt("idBitacora");
                String usuario = rs.getString("usuario");
                String tablaModificada = rs.getString("tablaModificada");
                String operacion = rs.getString("operacion");
                String datoModificado = rs.getString("datoModificado");
                String fecha = rs.getString("fecha");

                result.append(idBitacora)
                      .append("&").append(usuario)
                      .append("&").append(tablaModificada)
                      .append("&").append(operacion)
                      .append("&").append(datoModificado)
                      .append("&").append(fecha)
                      .append("|");
            }

            if (result.length() > 0) {
                result.setLength(result.length() - 1);
            }

        } catch (SQLException e) {
            result.setLength(0);
            result.append("Error al obtener datos de la vista: ").append(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                result.append("\nError al cerrar los recursos: ").append(e.getMessage());
            }
        }

        return result.toString();
    }

}


