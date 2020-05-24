package Gson;

import modelo.Cliente;

public class Mediador {

    public static Cliente retornaCliente(String id){
        Cliente[] clientes = (Cliente[]) Serializador.deserializarOP("registro_clientes.json", Cliente[].class);
        //ArrayList<Cliente> clientes = new ArrayList<Cliente>(Arrays.asList((Cliente[]) Serializador.deserializarOP("registro_clientes.json", Cliente[].class)));

        if(clientes!=null) {
            for (Cliente clienteRecorrido :  clientes) {
                if (clienteRecorrido.getId().equals(id)) {
                    return (Cliente) clienteRecorrido;
                }
            }
        }

        //si se llega a este punto no había registro alguno de clientes
        return null;
    }


}
