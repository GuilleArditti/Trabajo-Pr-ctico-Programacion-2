package trabajoPractico;

import java.util.HashSet;
import java.util.Set;

public abstract class Album {
	private Set<Figuritas> figuritasPegadas;
	private Integer codigoID;
	private boolean codigoPromocional=true;
	
	public Album(Integer codigoID) {
		this.codigoID = codigoID;
		this.figuritasPegadas= new HashSet<>();
	}

	public Integer getCodigoID() {
		return codigoID;
	}
	
	public void setCodigoID(Integer codigoID) {
		this.codigoID = codigoID;
	}
	
	public Set<Figuritas> getFiguritasPegadas() {
		return figuritasPegadas;
	}

	public void setFiguritasPegadas(Set<Figuritas> figuritasPegadas) {
		this.figuritasPegadas = figuritasPegadas;
	}
	
	public boolean getCodigoPromocional() {
		return codigoPromocional;
	}

	public void setCodigoPromocional(boolean codigoPromocional) {
		this.codigoPromocional = codigoPromocional;
	}

	public abstract String premioFinal();
	public abstract String tipo();

	

	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("Codigo ID: ");
		sb.append(codigoID);
		sb.append("\n");
		sb.append("Codigo promocional: ");
		sb.append(codigoPromocional);
		sb.append("\n");
		sb.append("Figuritas pegadas: ");
		sb.append("\n");
		sb.append(figuritasPegadas);
		return sb.toString();
	}
	
}
