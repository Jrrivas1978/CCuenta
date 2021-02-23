/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ccuenta;

/**
 * Clase que permite gestionar una cuenta bancaria.
 * @author Francisco Javier Cabrerizo Membrilla
 * @version 0.1
 */
public class CCuenta {


    // Propiedades de la Clase Cuenta
    private String nombre;
    private String numCuenta;
    private double saldo;

    /* Constructor sin argumentos */
    public CCuenta ()
    {
    }
    /** Constructor con parámetro para iniciar todas las propiedades de la clase
     * 
     * @param cliente nombre del titular de la cuenta
     * @param cuenta número de cuenta
     * @param cantidad saldo de la cuenta
     * @param tipoInt tipo de interes que se aplica a la cuenta
     */
    public CCuenta (String cliente, String cuenta, double cantidad, double tipoInt)
    {
        nombre = cliente;
        numCuenta = cuenta;
        saldo = cantidad;
    }
   /** Método para asignar el nombre del titular de la cuenta
    * 
    * @param nom nombre del propietario de la cuenta
    */
    public void setNombre(String nom)
    {
        nombre=nom;
    }
    /** Método que me devuelve el nombre del titular
     * 
     * @return el nombre del propietario de la cuenta
     */
    public String getNombre()
    {
        return nombre;
    }

    /** Método que me devuelve el saldo disponible en cada momento
     * 
     * @return el saldo actual de la cuenta
     */
     public double getSaldo ()
    {
        return saldo;
    }

    /** Método para ingresar cantidades en la cuenta. Modifica el saldo.
     * 
     * @param cantidad cantidad que se quiere ingresar en la cuenta
     * @throws Exception No se puede ingresar una cantidad negativa
     */
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0) {
            throw new Exception("No se puede ingresar una cantidad negativa");
        }
        saldo = saldo + cantidad;
    }



    /** Método para retirar cantidades en la cuenta. Modifica el saldo.
     * 
     * @param cantidad cantidad que se quiere retirar de la cuenta
     * @throws Exception No se puede retirar una cantidad negativa
     * @throws Exception No hay suficiente saldo
     */
    public void retirar (double cantidad) throws Exception
    {
        if (cantidad < 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (getSaldo()< cantidad)
            throw new Exception ("No hay suficiente saldo");
        saldo = saldo - cantidad;
    }

    /** Método que me devuelve el número de cuenta
     * 
     * @return el nÃºmero de cuenta
     */
    public String getCuenta ()
    {
        return numCuenta;
    }
}
