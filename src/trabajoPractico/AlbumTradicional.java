package trabajoPractico;

public class AlbumTradicional extends Album{
	
	public AlbumTradicional(Integer codigoID) {
		super(codigoID);
	}	

	@Override
	public String premioFinal() {
		return "Pelota" ;
	}

	@Override
	public String tipo() {
		return "Tradicional";
	}


}