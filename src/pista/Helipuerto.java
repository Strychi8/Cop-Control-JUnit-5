package pista;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

public class Helipuerto extends Pista{

	public Helipuerto(Posicion posicionEntrada) throws PosicionesEntradaVaciaException{
		super(posicionEntrada);
		this.posicionEntrada= posicionEntrada;		
		this.radioAterrizaje=15;
	}

	@Override
	public boolean puedeAterrizar(AvionSimple avionSimple) {
		return false;
	}

	@Override
	public boolean puedeAterrizar(AvionPesado avionPesado) {
		return false;
	}

	@Override
	public boolean puedeAterrizar(AvionComputarizado avionComputarizado) {
		return false;
	}

	@Override
	public boolean puedeAterrizar(Helicoptero helicoptero) {
		return true;
	}
	
	@Override
	public int getX() {
		return (int)getPosicionEntrada().getCoordenadaX();
	}

	@Override
	public int getY() {
		return (int)getPosicionEntrada().getCoordenadaY();
	}
}
