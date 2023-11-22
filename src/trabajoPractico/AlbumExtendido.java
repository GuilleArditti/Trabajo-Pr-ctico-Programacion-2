package trabajoPractico;

public class AlbumExtendido extends Album {
	
	public AlbumExtendido(Integer codigoID) {
		super(codigoID);
	}

	@Override
	public String premioFinal() {
		return "Una pelota y un viaje";
	}

	@Override
	public String tipo() {
		return "Extendido";
	}



}
