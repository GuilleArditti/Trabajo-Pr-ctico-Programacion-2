package trabajoPractico;

public class FiguritaTradicional extends Figuritas {

	public FiguritaTradicional(String pais, Integer numeroJugador) {
		super(pais, numeroJugador);

	}

	@Override
	public double valorFinal() {
		return getFabrica().ValorFiguritaTradicional(getPais(), getNumeroJugador());
	}
	
	@Override
	public String tipo() {
		// TODO Auto-generated method stub
		return "Tradicional";
	}

	@Override
	public String toString() {
		return "[ Pais: "+ getPais() + ", Numero: " + getNumeroJugador() +" ]";
	}
	
	
}
