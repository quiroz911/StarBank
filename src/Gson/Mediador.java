package Gson;

import modelo.Cliente;
import modelo.Empresa;
import modelo.PersonaNatural;

public class Mediador {

    public static Cliente retornaCliente(String id){
        Serializador serializador = new Serializador();
        PersonaNatural[] personasNaturales = serializador.deserializarPersonaNatural();
        Empresa[] empresas = serializador.deserializarEmpresa();

        //se recorren primero las personas naturales y luego las empresas
        if(personasNaturales!=null) {
            for (Cliente clienteRecorrido : personasNaturales) {
                if (clienteRecorrido.getId().equals(id)) {
                    return clienteRecorrido;
                }
            }
        }

        if(empresas!=null) {
            for (Cliente clienteRecorrido : empresas) {
                if (clienteRecorrido.getId().equals(id)) {
                    return clienteRecorrido;
                }
            }
        }

        //si se llega a este punto no había registro alguno de clientes
        return null;
    }


}
