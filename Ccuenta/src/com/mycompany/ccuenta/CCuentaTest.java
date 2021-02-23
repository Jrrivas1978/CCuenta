package com.mycompany.ccuenta;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 
 * @author Belegan
 */
public class CCuentaTest {
    
    public CCuentaTest() {
    }

    /**
     * Test of setNombre method, of class CCuenta.
     */
    @Test
    public void testSetNombre() {
        System.out.println("asignarNombre");
        String nom = "Juan Palomo";
        CCuenta instance = new CCuenta();
        instance.setNombre(nom);
        String result = instance.getNombre();
        assertEquals(nom, result);

    }

    /**
     * Test of getNombre method, of class CCuenta.
     */
    @Test
    public void testGetNombre() {
        System.out.println("obtenerNombre");
        String nom = "Juan Palomo";
        CCuenta instance = new CCuenta();
        instance.setNombre(nom);
        String result = instance.getNombre();
        assertEquals(nom, result);
    }

    /**
     * Test of getSaldo method, of class CCuenta.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("estado");
        CCuenta instance = new CCuenta("Juan López","1000-2365-85-123456789",2500,0);
        double expResult = 2500.0;
        double result = instance.getSaldo();
        assertEquals(expResult, result, 0.000000001);
    }

    /**
     * Test of ingresar method, of class CCuenta.
     * @param nombre
     * @param cuenta
     * @param saldo
     * @param tipo
     * @param cantidad a ingresar
     * @throws java.lang.Exception
     */
    @ParameterizedTest
    @CsvSource({"'Juan López', '1000-2365-85-123456789', 2500, 0, -100.23",
                "'Juan Palomo', '1111-2385-66-987654321', 100.23, 0.0, 2500"})
    public void testIngresar(String nombre, String cuenta, double saldo, double tipo, double cantidad) throws Exception {
        System.out.println("ingresar");
        CCuenta instance = new CCuenta(nombre, cuenta, saldo, tipo);
        try 
        {
            instance.ingresar(cantidad);
        } catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.out.println("Fallo al ingresar");
            assertTrue(cantidad<0);
        }
        if (cantidad>=0) {
            assertEquals(saldo+cantidad, instance.getSaldo(), 0.000000001);
        }
        
    }

    /**
     * Test of retirar method, of class CCuenta.
     */
    @ParameterizedTest
    @CsvSource({"'Juan López', '1000-2365-85-123456789', 2500, 0, -100.23",
                "'Juan Palomo', '1111-2385-66-987654321', 100.23, 0.0, 2500",
                "'Juan Palomo', '1111-2385-66-987654321', 2500, 0.0, 100.23"})
    public void testRetirar(String nombre, String cuenta, double saldo, double tipo, double cantidad) throws Exception {
        System.out.println("retirar");
        CCuenta instance = new CCuenta(nombre, cuenta, saldo, tipo);
        try 
        {
            instance.retirar(cantidad);
        } catch (Exception e)
        {
            String result = e.getMessage();
            String expResult;
            System.err.println(result);
            System.out.println("Fallo al retirar");
            if(cantidad<0) {
                expResult = "No se puede retirar una cantidad negativa";
                assertEquals(expResult, result);
            }
            else if (cantidad>saldo) {
                expResult = "No hay suficiente saldo";
                assertEquals(expResult, result);
            }
            
        }
        if (saldo>=cantidad && cantidad>=0) {
            assertEquals(saldo-cantidad, instance.getSaldo(), 0.000000001);
        }
    }

    /**
     * Test of getCuenta method, of class CCuenta.
     */
    @Test
    public void testGetCuenta() {
        System.out.println("obtenerCuenta");
        CCuenta instance = new CCuenta("Juan López","1000-2365-85-123456789",2500,0);
        String expResult = "1000-2365-85-123456789";
        String result = instance.getCuenta();
        assertEquals(expResult, result);
    }
    
}
