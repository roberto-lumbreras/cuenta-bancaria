/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

package org.factoriaf5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author CODER F5 ASTURIAS
 */
public class CuentaAhorroTest {

    public CuentaAhorroTest() {
    }

    /**
     * Test of retirar method, of class CuentaAhorro.
     */
    @Test
    public void testRetirar_CuandoElSaldoEsMayorALaCantidadYElSaldoEsMayorOIgualA10_000_LaOperacionEsValida() {
        Double cantidad = 100.0;
        CuentaAhorro instance = new CuentaAhorro(10_000.0, 0.0);
        String expResult = instance.operacionValida;
        String result = instance.retirar(cantidad);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetirar_CuandoElSaldoEsMayorALaCantidadYElSaldoEsMenorA10_000_LaOperacionEsNoValida() {
        Double cantidad = 100.0;
        CuentaAhorro instance = new CuentaAhorro(1_000.0, 0.0);
        String expResult = instance.operacionNoValida;
        String result = instance.retirar(cantidad);
        assertEquals(expResult, result);
    }

    @Test
    public void testRetirar_CuandoElSaldoEsMenorALaCantidad_LaOperacionEsNoValida() {
        Double cantidad = 10_000.0;
        CuentaAhorro instance = new CuentaAhorro(1_000.0, 0.0);
        String expResult = instance.operacionNoValida;
        String result = instance.retirar(cantidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of consignar method, of class CuentaAhorro.
     */
    @Test
    public void testConsignar_CuandoLaCantidadEsValidaYElSaldoEsMenorA10_000_LaOperacionEsNoValida() {
        Double cantidad = 100.0;
        CuentaAhorro instance = new CuentaAhorro(1_000.0, 0.0);
        String expResult = instance.operacionNoValida;
        String result = instance.consignar(cantidad);
        assertEquals(expResult, result);
    }

    @Test
    public void testConsignar_CuandoLaCantidadEsValidaYElSaldoEsMayorOIgualA10_000_LaOperacionEsValida() {
        Double cantidad = 100.0;
        CuentaAhorro instance = new CuentaAhorro(10_000.0, 0.0);
        String expResult = instance.operacionValida;
        String result = instance.consignar(cantidad);
        assertEquals(expResult, result);
    }

    @Test
    public void testConsignar_CuandoLaCantidadNoEsValidaYElSaldoEsMenorA10_000_LaOperacionNoEsValida() {
        Double cantidad = -100.0;
        CuentaAhorro instance = new CuentaAhorro(1_000.0, 0.0);
        String expResult = instance.operacionNoValida;
        String result = instance.consignar(cantidad);
        assertEquals(expResult, result);
    }

    @Test
    public void testConsignar_CuandoLaCantidadNoEsValidaYElSaldoEsMayorOIgualA10_000_LaOperacionNoEsValida() {
        Double cantidad = -100.0;
        CuentaAhorro instance = new CuentaAhorro(10_000.0, 0.0);
        String expResult = instance.operacionNoValida;
        String result = instance.consignar(cantidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of calcularComisionMensual method, of class CuentaAhorro.
     */
    @Test
    public void testCalcularComisionMensual() {
        System.out.println("calcularComisionMensual");
        CuentaAhorro instance = new CuentaAhorro(1_000.0, 0.0);
        instance.calcularComisionMensual();
        assertTrue(0.0==instance.comisionMensual);
        instance.numeroDeRetiros = 5;
        instance.calcularComisionMensual();
        assertTrue(1000.0==instance.comisionMensual);
    }

    /**
     * Test of extractoMensual method, of class CuentaAhorro.
     */
    @Test
    public void testExtractoMensual() {
        CuentaAhorro instance = new CuentaAhorro(10_000.0, 0.0);
        instance.extractoMensual();
        assertTrue(instance.activa);
        instance.retirar(1000.0);
        instance.extractoMensual();
        assertFalse(instance.activa);
    }

    /**
     * Test of toString method, of class CuentaAhorro.
     */
    /* @Test
    public void testToString() {
        System.out.println("toString");
        CuentaAhorro instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

}