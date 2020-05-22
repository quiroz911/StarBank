package Gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

public class Serializador {

    //nombre del archivo en el cual se realizará el proceso de serializado. Es necesario indicarlo cada vez que se quiere serializar
    public void serializarOP(Object obj, String archivo) {
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Object[] objetos = gson.fromJson(json, Object[].class);
        json = "[";
        if(objetos!=null){

            for(Object recorrido: objetos){
                json += gson.toJson(recorrido) + ",";
            }
        }

        json += gson.toJson(obj) + "]";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            bw.write(json);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PersonaNatural[] deserializarPersonaNatural(){
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader("registro_clientesPersonaNatural.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return gson.fromJson(json, PersonaNatural[].class);
    }

    public Empresa[] deserializarEmpresa(){
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader("registro_clientesEmpresa.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return gson.fromJson(json, Empresa[].class);
    }

    public CuentaAhorros[] deserializarCuentaAhorros(){
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader("registro_cuentasAhorros.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return gson.fromJson(json, CuentaAhorros[].class);
    }

    public CuentaCorriente[] deserializarCuentaCorriente(){
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader("registro_cuentaCorriente.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return gson.fromJson(json, CuentaCorriente[].class);
    }

    //intento fallido de deserializador genérico
    public Object[] deserializarOP(String archivo, Class clase){
        Gson gson = new GsonBuilder().disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return gson.fromJson(json, (Type) clase);
    }

}