package modelo;

import Gson.Serializador;
import operacion.Operacion;

import javax.swing.*;

public class Sucursal {
    private String id;
    private String direccion;
    private String ciudad;
    private String nombre;
    private static Sucursal sucursal;

    public Sucursal() {

    }

    public static Sucursal getSingletonInstance() {
        if (sucursal == null){
            Sucursal[] sucursales = (Sucursal[]) Serializador.deserializarOP("sucursales.json", Sucursal[].class);
            while(sucursal==null) {
                String nombreSucursal = JOptionPane.showInputDialog("Introduzca el nombre de la sucursal actual");
                for (int i = 0; i < sucursales.length; i++) {
                    if (sucursales[i].getNombre().equals(nombreSucursal)) {
                        sucursal = sucursales[i];
                    }
                }
                if(sucursal==null) JOptionPane.showMessageDialog(null,"Introduzca una sucursal válida");
            }
        }
        return sucursal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
