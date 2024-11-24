/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package org.factoriaf5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author CODER F5 ASTURIAS
 */

public class CuentaCorrienteTest {

    public CuentaCorrienteTest() {
    }

    /**
     * Test of retirar method, of class CuentaCorriente.
     */
    @Test
    public void testRetirar_CuandoLaCantidadEsValidaYLaCantidadExcedeElSaldo_ElSobregiroEsIgualAlExcesoYElSaldoEs0YLaOperacionEsValida() {
        Double cantidad = 11_000.0;
        CuentaCorriente instance = new CuentaCorriente(10_000.0, 0.0);
        String expResult = instance.operacionValida;
        String result = instance.retirar(cantidad);
        assertTrue(instance.sobregiro==1000.0);
        assertTrue(instance.saldo==0);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetirar_CuandoLaCantidadNoEsValida_LaOperacionNoEsValida() {
        Double cantidad = -11_000.0;
        CuentaCorriente instance = new CuentaCorriente(10_000.0, 0.0);
        String expResult = instance.operacionNoValida;
        String result = instance.retirar(cantidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of consignar method, of class CuentaCorriente.
     */
    @Test
    public void testConsignar_CuandoLaCantidadEsValidaYElSobregiroEsMayorOIgualALaCantidad_LaCantidadSeDeduceDelSobregiroYLaOperacionEsValida() {
        Double cantidad = 1_000.0;
        CuentaCorriente instance = new CuentaCorriente(11_000.0, 0.0);
        instance.sobregiro=1_000.0;
        String expResult = instance.operacionValida;
        String result = instance.consignar(cantidad);
        assertTrue(instance.sobregiro==0.0);
        assertTrue(instance.saldo==11_000.0);
        assertEquals(expResult, result);
    }

    @Test
    public void testConsignar_CuandoLaCantidadEsValidaYElSobregiroEsMenorALaCantidad_LaDiferenciaDeLaCantidadYElSobregiroSeConsignaYElSobregiroes0YLaOperacionEsValida() {
        Double cantidad = 1_000.0;
        CuentaCorriente instance = new CuentaCorriente(11_000.0, 0.0);
        instance.sobregiro=500.0;
        String expResult = instance.operacionValida;
        String result = instance.consignar(cantidad);
        assertTrue(instance.sobregiro==0.0);
        assertTrue(instance.saldo==11_500.0);
        assertEquals(expResult, result);
    }

    @Test
    public void testConsignar_CuandoLaCantidadNoEsValida_LaOperacionNoEsValida() {
        Double cantidad = -11_000.0;
        CuentaCorriente instance = new CuentaCorriente(10_000.0, 0.0);
        String expResult = instance.operacionNoValida;
        String result = instance.consignar(cantidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class CuentaCorriente.
     */
    /* @Test
    public void testToString() {
        System.out.println("toString");
        CuentaCorriente instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

}