package modelo;

import javax.swing.*;
import java.util.Random;

public class Cuenta {
    protected String id;
    protected Cliente cliente;
    protected double saldo;
    protected boolean estado;
    protected Sucursal sucursal;
    protected Operacion[] operaciones;
    protected double cobroRetiro;

    public Cuenta(Cliente cliente, Sucursal sucursal) {
        this.id = generarId();
        this.cliente = cliente;
        this.saldo = 20000;
        this.estado = true;
        this.sucursal = sucursal;
        //Es útil imprimir el id randomico que se genera
        System.out.println(this.id);
    }

    public Cuenta() {

    }

    public static String generarId(){
        //Variables para Generar el ID de Forma Aleatoria
        Random aleatorio = new Random();
        String alfa = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
        String cadena = "";    //Inicializamos la Variable
        int numero;
        int forma;
        //Método para el Cálculo de Código
        forma=(int)(aleatorio.nextDouble() * alfa.length()-1+0);
        //Definimos la cantidad máxima de números aleatorios (99) y sumamos 100 para mantener 3 números cada vez
        numero=(int)(aleatorio.nextDouble() * 99+100);
        cadena=cadena+alfa.charAt(forma)+numero;
        return cadena;

    }


    //inicio getter y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Operacion[] getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(Operacion[] operaciones) {
        this.operaciones = operaciones;
    }
    //fin getters y setters


    public void cancelarCuenta(){
        estado = false;
    }

    //El método retirarDinero debe retornar un double que será la cantidad de dinero que se le agregará como saldo a la cuenta del banco
    public double retirarDinero(double cantARetirar){
        if(cantARetirar<20000){
            JOptionPane.showMessageDialog(null, "No se puede retirar menos de $20.000");
            return 0;
        }
        if(cantARetirar>this.saldo-10000-cantARetirar*cobroRetiro){
            JOptionPane.showMessageDialog(null, "Fondos insuficientes");
            return 0;
        }
        saldo = saldo - cantARetirar - cantARetirar*cobroRetiro;
        return cantARetirar*cobroRetiro;
    }

    public void desactivarCuenta(boolean retirar, Cuenta cuentaStarBank){
        cancelarCuenta();
        //Si decide sacar todo el dinero
        if(retirar){
            saldo = 0;
            cuentaStarBank.setSaldo(saldo*cobroRetiro);
        }

    }



}
