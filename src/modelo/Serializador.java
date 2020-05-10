package modelo;

import com.google.gson.Gson;
import modelo.Cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Serializador {
    public void registrarClienteEmpresa(Cliente clienteaRegistrar) {
        Gson gson = new Gson();
        String json = "";

        try (BufferedReader br = new BufferedReader(new FileReader("registro_clientes.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Cliente[] clientes = gson.fromJson(json, Cliente[].class);
        json = "[";
        for(Cliente cliente: clientes){
            json += gson.toJson(cliente) + ",";
        }
        json += gson.toJson(clienteaRegistrar) + "]";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("registro_clientes.json"))) {
            bw.write(json);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}