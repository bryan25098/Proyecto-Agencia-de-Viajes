package co.edu.uptc.persistence;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ManipuladorArchivos{
   
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T> List<T> leerArchivo(String filepath, Class<T> clase) {
        try (Reader reader = new FileReader(filepath)) {
            Type tipoLista = TypeToken.getParameterized(List.class, clase).getType();
            return gson.fromJson(reader, tipoLista);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void subirArchivo(String filepath, List<T> datos) {
        try (Writer wt = new FileWriter(filepath)) {
            gson.toJson(datos, wt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}