package trabajoPractico;

public class AlbumWeb extends Album{
	
	public AlbumWeb(Integer codigoID) {
		super(codigoID);
	}

	@Override
	public String premioFinal() {
		return "Camiseta de f�tbol";
	}

	@Override
	public String tipo() {
		return "Web";
	}



}
