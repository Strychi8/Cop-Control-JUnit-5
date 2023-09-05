package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import copControl.Dificultad;
import copControl.Jugador;

public class testCopControl{
    private Dificultad dificultad;
    private Jugador jugador;
 
    @Before
    public void setUp()  throws Exception{
        dificultad = new Dificultad(10, 19,10);
        jugador = new Jugador("Alberto Gutierrez");     
    }
    @Test
    public void testAssertFalse(){
        assertFalse("Falla - Es falso",dificultad.getVelocidad() == 20);
    }
    @Test
    public void testAssertEquals(){
        int cantidadDeAviones = dificultad.getCantidadDeAvionesPorAterrizar() + 200;
        assertEquals(210,cantidadDeAviones,"Falla - Son iguales");
    }
    @Test
    public void testAssertTrue(){
        String nombre = "Santiago Alonso";

        try {
            assertTrue(jugador.getNombre() != nombre);
        } catch (Exception e) {
            fail("No son los mismos nombres");
        }
    
    }
    @Test
    public void testAssertSame(){
        try {
            assertSame(jugador,jugador);
        } catch (Exception e) {
            fail("Fallo");
        }   
        
    }
    @Test
    public void testAssertNotSame(){
        try {
            assertNotSame("No es el mismo tipo de objeto", jugador, dificultad);
        } catch (Exception e) {
            fail("Fallo");
        }
        
    }





}