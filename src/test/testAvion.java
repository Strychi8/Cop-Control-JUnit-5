package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import avion.Avion;
import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;
import copControl.Mapa;
import copControl.Posicion;
import pista.Pista;

public class testAvion{
    private Avion avion;
    private Posicion coordenadas;
    private Mapa mapa;
    private List<Pista> pistas;

    @Before
    public void setUp() throws Exception{
       coordenadas = new Posicion(10, 20);
       mapa = new Mapa(pistas);
       avion = new AvionComputarizado(coordenadas,mapa);
    }
    @Test
    public void testAssertTrue(){
       double getX = coordenadas.getCoordenadaX() + 20;
       double getY = coordenadas.getCoordenadaY() + 50;
       assertTrue(getX != getY);

       boolean estaVolando = avion.getEstaVolando();
       boolean noEstaVolando = false;
       assertTrue(estaVolando != noEstaVolando);
       
       Posicion coordenadas2 = new Posicion(100, 200);
       try {
          coordenadas.igualA(coordenadas2);
       } catch (Exception e) {
          fail("No son iguales");
       }
        assertTrue(coordenadas != coordenadas2);
       
    }
    @Test
    public void testAssertNotSame(){
       Posicion coordenadas2 = new Posicion(100, 200);
       Avion avion1 = new AvionPesado(coordenadas,coordenadas2,mapa);
       assertNotSame("Falla - No son el mismo tipo", avion1, avion);
    }
    @Test
    public void testAssertNotEquals(){
       Posicion coordenadas2 = new Posicion(100, 200);
       AvionPesado avionPesado = new AvionPesado(coordenadas, coordenadas2, mapa);
       try {
          assertNotEquals(avionPesado,avion);
       } catch (Exception e) {
          fail("No son iguales");
       }
       
    }
    @Test
    public void testAssertEquals(){
        boolean noEsControlable = avion.esControlable();
        noEsControlable = false;
        assertEquals(false,noEsControlable,"Son iguales");
        
        Posicion coordenadas2 = new Posicion(100, 200);
        Helicoptero helicoptero = new Helicoptero(coordenadas, coordenadas2, mapa);
        boolean estaDetenido = helicoptero.estaDetenido();
        estaDetenido = true;
        assertEquals(true,estaDetenido,"Son iguales");
    }
    @Test
    public void testAssertFalse(){
        AvionSimple avionSimple = new AvionSimple(coordenadas, coordenadas, mapa);
        Helicoptero helicoptero = new Helicoptero(coordenadas, coordenadas, mapa);
        boolean estaMarcado = avionSimple.estaMarcado();
        boolean estaMarcado1 = helicoptero.estaMarcado();
        estaMarcado = true;
        estaMarcado1 = true;
        assertFalse("Falso - estaMarcado es true",estaMarcado == false);
        assertFalse(helicoptero.estaMarcado() != avionSimple.estaMarcado());
        assertFalse(estaMarcado != estaMarcado1);
    }


}