package trabajoPractico;

public class FiguritaTOP10 extends Figuritas{
	private String posicionEnMundial;

	public FiguritaTOP10(String pais, Integer numeroJugador) {
		super(pais, numeroJugador); //pais= sede mundial;
		this.posicionEnMundial=getFabrica().balonDeOroOPlata(pais);
	}

	public String getPosicionEnMundial() {
		return posicionEnMundial;
	}
	
	public void setPosicionEnMundial(String podioMundial) {
		this.posicionEnMundial = podioMundial;
	}

	@Override
	public double valorFinal() {
		if(getFabrica().PrimerOSegundoLugar().equals(0)) {
			return (getFabrica().ValorFiguritaTradicional(posicionEnMundial, getNumeroJugador()) * 1.20);
		}
		else {
			return (getFabrica().ValorFiguritaTradicional(posicionEnMundial, getNumeroJugador()) * 1.10);
		}
		
	}
	

	@Override
	public String tipo() {
		return "TOP10";
	}

	@Override
	public String toString() {
		return "[ Mundial : " + getPais() + ", N.Jugador: " + getNumeroJugador()+ " (" + posicionEnMundial + ')' + " Valor: " + valorFinal() + " ]";
	}

}
