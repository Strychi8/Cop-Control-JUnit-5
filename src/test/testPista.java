package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.Test;

import avion.Avion;
import avion.AvionSimple;
import copControl.Posicion;

import org.junit.Before;
import java.util.List;
import copControl.Mapa;
import pista.Helipuerto;
import pista.Pista;
import pista.PistaDoble;
import pista.PistaLarga;
import pista.PistaSimple;

public class testPista {
    private Pista pista;
    private PistaSimple pistaSimple;
    private PistaDoble pistaDoble;
    private PistaLarga pistaLarga;
    private Helipuerto helipuerto;
    private Posicion coordenadas;
    private Mapa mapa;
    private List<Pista> pistas;
    
    @Before
    public void setUp() throws Exception{
        coordenadas = new Posicion(10, 50);
        mapa = new Mapa(pistas);
        pista = new PistaSimple(coordenadas);
        pistaSimple = null;
        pistaDoble = new PistaDoble(coordenadas);
        pistaLarga = null;
        helipuerto = null;
    }
    @Test
    public void testAssertNullYNotNull(){
        assertNull(helipuerto);
        assertNull(pistaSimple);
        assertNull("Es nulo", pistaLarga);
        assertNotNull("No es nulo", pistaDoble);
		assertNotNull(pista);
    }
    @Test
    public void testAssertSameYNotSame(){
        try {
            assertSame(helipuerto,pistaLarga);
            assertSame(pistaSimple,helipuerto);
        } catch (Exception e) {
            fail("No son el mismo tipo");
        }
        assertNotSame("No son el mismo tipo", pistaDoble, helipuerto);
        assertNotSame(pistaSimple,pista);
    }
    @Test 
    public void testAssertEquals(){
        int largo = pistaDoble.getLargo() + 10;
        double getX = pista.getX() + 200 -(20*2);
        double getY = pista.getY() + 200 -(321/89);
        assertEquals(30,largo,"El resultado es correcto");
        assertEquals(170,getX,"El resultado es correcto");
        assertEquals(247,getY,"El resultado es correcto");
    }
    @Test
    public void testAssertTrue(){
        try {
            assertTrue(pistaDoble.getPosicionEntrada() != pistaDoble.getPosicionEntradaSecundaria());
            assertTrue(pistaDoble.getPosicionEntradaPrincipal() == pistaDoble.getPosicionEntradaPrincipal());
            assertTrue(pista.getPosicionEntrada() == pista.getPosicionEntrada());
        } catch (Exception e) {
            fail("Falla - No es verdadero");
        }
        
    }
    @Test
    public void testAssertFalse(){
        Avion avion = new AvionSimple(coordenadas,coordenadas,mapa);
        Avion avion1 = new AvionSimple(coordenadas,coordenadas,mapa);
        int getX = pista.getX()+300;
        int getY = pistaDoble.getY()+500;
        assertFalse("Falla - Es falso", pista.estaEnZonaAterrizaje(avion) != pista.estaEnZonaAterrizaje(avion1));
        assertFalse("Falla - Es falso", getX == pista.getX());
        assertFalse(getY == getX);
    }

}
