package trabajoPractico;

public abstract class Figuritas {
	
	private String Pais;
	private Integer numeroJugador;
	private Fabrica fabrica= new Fabrica();
	
	public Figuritas(String pais, Integer numeroJugador) {
		this.Pais=pais;
		this.numeroJugador= numeroJugador;
	}
	
	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}
	
	public Integer getNumeroJugador() {
		return numeroJugador;
	}

	public void setNumeroJugador(Integer numeroJugador) {
		this.numeroJugador = numeroJugador;
	}

	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	public abstract double valorFinal();
	public abstract String tipo();

/*------------------------------------------------*/
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("Pais: ");
		sb.append(Pais);
		sb.append(", ");
		sb.append("Nro. figurita: ");
		sb.append(numeroJugador);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Pais == null) ? 0 : Pais.hashCode());
		result = prime * result + ((numeroJugador == null) ? 0 : numeroJugador.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figuritas other = (Figuritas) obj;
		return other.Pais.equals(this.Pais) && other.numeroJugador.equals(this.numeroJugador);
	}
}
