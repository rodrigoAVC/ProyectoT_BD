import java.io.*;
import java.util.ArrayList;

public class adminBin {
            
    public static void writeUsuarios(ArrayList<Usuario> usuarios, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            System.err.println("Error al guardar los usuarios: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Usuario> readUsuarios(String filePath) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            usuarios = (ArrayList<Usuario>) ois.readObject();
            System.out.println("Usuarios cargados exitosamente desde el archivo: " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("El archivo no fue encontrado: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los usuarios: " + e.getMessage());
        }
        return usuarios;
    }
}

