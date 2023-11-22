package trabajoPractico;

import java.util.ArrayList;
import java.util.List;


public class Participante {
	
	private Album album;
	private String tipoDeAlbum;
	private Integer DNI;
	private String nombreUsuario;
	private List<Figuritas> coleccionDeFiguritas;
	private List<Figuritas> figuritasRepetidas;
	private static Integer numero = (int)(Math. random()*5000+1);
	
	public Participante(Integer DNI, String nombreUsuario, String tipoDeAlbum) {
		this.tipoDeAlbum =tipoDeAlbum;
		this.DNI = DNI;
		this.nombreUsuario = nombreUsuario;
		this.figuritasRepetidas= new ArrayList<>();
		this.coleccionDeFiguritas= new ArrayList<>();
		this.album=asignarAlbum();
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getTipoDeAlbum() {
		return tipoDeAlbum;
	}

	public void setTipoDeAlbum(String tipoDeAlbum) {
		this.tipoDeAlbum = tipoDeAlbum;
	}

	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Figuritas> getColeccionDeFiguritas() {
		return coleccionDeFiguritas;
	}

	public void setColeccionDeFiguritas(List<Figuritas> coleccionDeFiguritas) {
		this.coleccionDeFiguritas = coleccionDeFiguritas;
	}

	public List<Figuritas> getFiguritasRepetidas() {
		return figuritasRepetidas;
	}

	public void setFiguritasRepetidas(List<Figuritas> figuritasRepetidas) {
		this.figuritasRepetidas = figuritasRepetidas;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("[ ");
		sb.append(nombreUsuario);
		sb.append(", ");
		sb.append("Tipo de album: ");
		sb.append(tipoDeAlbum);
		sb.append(", ");
		sb.append("DNI: ");
		sb.append(DNI);
		sb.append(", ");
		sb.append("Cantidad de figuritas pegadas: ");
		sb.append(getAlbum().getFiguritasPegadas().size());
		sb.append(" ]");
		sb.append("\n");
		return sb.toString();
	}
	
	private Album asignarAlbum() {
		if(getTipoDeAlbum().equals("Tradicional")) {
			return new AlbumTradicional(numero);
		}
		if(getTipoDeAlbum().equals("Web")) {
			return new AlbumWeb(numero);
		}
		if(getTipoDeAlbum().equals("Extendido")) {
			return new AlbumExtendido(numero);	
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if( !(obj instanceof Participante)) {
			return false;
		}
		Participante other= (Participante) obj;
		return other.DNI.equals(this.DNI);
	}
	
}
