package pista;

import avion.AvionComputarizado;
import avion.AvionPesado;
import avion.AvionSimple;
import avion.Helicoptero;

import copControl.Posicion;

public class PistaLarga extends Pista{

	public PistaLarga(Posicion posicionEntrada) throws PosicionesEntradaVaciaException {
		super(posicionEntrada);
	}

	@Override
	public boolean puedeAterrizar(AvionSimple avionSimple) {
		return true;
	}

	@Override
	public boolean puedeAterrizar(AvionPesado avionPesado) {
		return true;
	}

	@Override
	public boolean puedeAterrizar(AvionComputarizado avionComputarizado) {
		return true;
	}

	@Override
	public boolean puedeAterrizar(Helicoptero helicoptero) {
		return false;
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
