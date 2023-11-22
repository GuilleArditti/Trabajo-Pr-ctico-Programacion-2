package trabajoPractico;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class AlbumDelMundial implements IAlbumDelMundial {
	
	private Set<Participante> registroDeParticipantes;
	private Fabrica f= new Fabrica();
	
	
	public AlbumDelMundial() {
		this.registroDeParticipantes= new HashSet<>();
	}

	public Set<Participante> getRegistroDeParticipantes() {
		return registroDeParticipantes;
	}

	public void setRegistroDeParticipantes(Set<Participante> registroDeParticipantes) {
		this.registroDeParticipantes = registroDeParticipantes;
	}

	@Override
	public int registrarParticipante(int dni, String nombre, String tipoAlbum) {
		Participante p = new Participante(dni, nombre,tipoAlbum);
		if(!getRegistroDeParticipantes().contains(p) && (p.getTipoDeAlbum().equals("Extendido")
			|| p.getTipoDeAlbum().equals("Tradicional") || p.getTipoDeAlbum().equals("Web"))) {
			getRegistroDeParticipantes().add(p);
		}
		else {
			throw new RuntimeException("Participante ya registrado o álbum invalido");
		}
		return p.getAlbum().getCodigoID();
	}

	@Override
	public void comprarFiguritas(int dni) {
		int contador = 0;
		FiguritaTradicional aux;
		boolean registrado = false;
		for (Participante p : getRegistroDeParticipantes()) {
			if (p.getDNI().equals(dni)) {
				registrado = true;
				do{
					aux=f.generarFigurita();
						for(Figuritas f1: p.getColeccionDeFiguritas())
							if(aux.equals(f1)) {
								p.getFiguritasRepetidas().add(aux);
							}
						p.getColeccionDeFiguritas().add(aux);
					contador++;
				}while(contador<4);
			}
		}
		if (!registrado) {
			throw new RuntimeException("El DNI " + dni + "no esta registrado");
		}
	}

	@Override
	public void comprarFiguritasTop10(int dni) {
		int contador = 0;
		boolean registrado = false;
		FiguritaTOP10 aux;
		for (Participante p : getRegistroDeParticipantes()) {
			if (p.getDNI().equals(dni) && p.getTipoDeAlbum().equals("Extendido")) {
				registrado = true;
				do{
					aux=f.generarFiguritaTOP10();
					
						for(Figuritas f1: p.getColeccionDeFiguritas())
							if(aux.equals(f1)) {
								p.getFiguritasRepetidas().add(aux);
							}
						p.getColeccionDeFiguritas().add(aux);
					contador++;
				}while(contador<4);
			}
		}
		if (!registrado) {
			throw new RuntimeException("El DNI " + dni + " no esta registrado o no tiene album Extendido");
		}
	}

	@Override
	public void comprarFiguritasConCodigoPromocional(int dni) {
		int contador = 0;
		FiguritaTradicional aux;
		boolean registrado = false;
		for (Participante p : getRegistroDeParticipantes()) {
			if(p.getDNI().equals(dni) && p.getTipoDeAlbum().equals("Web") && p.getAlbum().getCodigoPromocional()) {
				registrado = true;
				do {
					aux=f.generarFigurita();
					for(Figuritas f1: p.getColeccionDeFiguritas())
						if(aux.equals(f1)) {
							p.getFiguritasRepetidas().add(aux);
						}
						p.getColeccionDeFiguritas().add(aux);
						contador++;
				} while (contador < 4);
			}
			if (!p.getAlbum().getCodigoPromocional()) {
				throw new RuntimeException("El código promocional del jugador ya fue utilizado");
			}
			if(registrado) {
				p.getAlbum().setCodigoPromocional(false);
			}
		}
		if (!registrado)
			throw new RuntimeException("Dni " + dni + " no valido");
	}

	@Override
	public List<String> pegarFiguritas(int dni) {
		boolean registrado = false;
		List<String> pegadas = new ArrayList<>();
		for (Participante p : getRegistroDeParticipantes()) {
			if (p.getDNI().equals(dni)) {
				registrado = true;
				Iterator<Figuritas> iterador = p.getColeccionDeFiguritas().iterator();
				while (iterador.hasNext()) {
					Figuritas t = iterador.next();
					p.getAlbum().getFiguritasPegadas().add(t);
					pegadas.add(t.toString());
					iterador.remove();
				}
			}
		}
		if (!registrado) {
			throw new RuntimeException("Dni " + dni + "No se encuentra registrado");
		}
		return pegadas;
	}
	
	@Override
	public boolean llenoAlbum(int dni) {
		boolean registrado=false;
		for(Participante p: getRegistroDeParticipantes()) {
			if(p.getDNI().equals(dni)){
				registrado=true;
				if(!p.getTipoDeAlbum().equals("Extendido")) {
					return p.getAlbum().getFiguritasPegadas().size()==341;
				}
				else {
					return p.getAlbum().getFiguritasPegadas().size()==361;
				}
			}
		}
		if(!registrado) {
			throw new RuntimeException("Dni " + dni + " no registrado");
		}
		return false;
	}

	@Override
	public String aplicarSorteoInstantaneo(int dni) {
		boolean registrado = false;
		boolean codigoDisponible=true;
		for (Participante p : getRegistroDeParticipantes()) {
			if (p.getTipoDeAlbum().equals("Tradicional") && p.getDNI().equals(dni)) {
				registrado = true;
				if ((p.getAlbum().getCodigoPromocional())) {
					p.getAlbum().setCodigoPromocional(false);
					codigoDisponible=false;
					return f.generarPremio(p);
				}
			}
		}
		if (!codigoDisponible) {
			throw new RuntimeException("El código promocional del jugador ya fue utilizado");
		}
		if (!registrado) {
			throw new RuntimeException("dni " + dni + " no registrado");
		}
		return "No se sorteo nada";
	}

	@Override
	public int buscarFiguritaRepetida(int dni) {
		boolean registrado = false;
		int resultado = 0;
		for (Participante p : getRegistroDeParticipantes()) {
			if (p.getDNI().equals(dni)) {
				registrado = true;
				if (!p.getColeccionDeFiguritas().isEmpty()) {
					return p.getColeccionDeFiguritas().get(0).getNumeroJugador();
				} else {
					resultado = -1;
				}
			}
		}
		if (!registrado)
			throw new RuntimeException("Dni " + dni + " no registrado");
		return resultado;
	}
	

	@Override
	public boolean intercambiar(int dni, int codFigurita) {	
		boolean registrado=false;																			
		boolean intercambio=false;										
		for(Participante p: getRegistroDeParticipantes()){
			if(p.getDNI().equals(dni)) {
				registrado=true;
					for(Participante p1: getRegistroDeParticipantes()) {
						if(p.getTipoDeAlbum().equals(p1.getTipoDeAlbum())) {
							for(Figuritas f: p1.getColeccionDeFiguritas()) {							
								if(f.getNumeroJugador()<=codFigurita) {
									p.getColeccionDeFiguritas().add(f);
									p1.getColeccionDeFiguritas().remove(f);
									p1.getFiguritasRepetidas().remove(f);
									intercambio=true;
									break;
								}
							}
						}
					}
				}
		}
		if(!registrado) {
			throw new RuntimeException("El dni ingresado es invalido o el participante no tiene esa figurita");
		}
		return intercambio;
	}
	
	
	@Override
	public boolean intercambiarUnaFiguritaRepetida(int dni) {
		boolean registrado=false;
		boolean intercambio=false;
		for(Participante p: getRegistroDeParticipantes()) {
			if(p.getDNI().equals(dni)) {
				registrado=true;
				intercambio= intercambiar(dni, buscarFiguritaRepetida(dni));
			}
		}
		if(!registrado) {
			throw new RuntimeException("Dni "+ dni + " no registrado");
		}
		return intercambio;
	}

	@Override
	public String darNombre(int dni) {
		boolean registrado=false;
		for(Participante p: getRegistroDeParticipantes()) {
			if(p.getDNI().equals(dni)) {
				registrado=true;
				return p.getNombreUsuario();
			}
		}
		if(!registrado) throw new RuntimeException("DNI " + dni + " no registrado");
		
		return null;
	}

	@Override
	public String darPremio(int dni) {
		boolean registrado=false;
		for(Participante p: getRegistroDeParticipantes()) {
			if(p.getDNI().equals(dni)) {
				registrado=true;
				if(llenoAlbum(dni)) {
					return p.getAlbum().premioFinal();
				}
				if(!llenoAlbum(dni)) {
					throw new RuntimeException("Album incompleto");
				}
			}
		}
		if(!registrado) throw new RuntimeException("DNI " + dni + " no registrado");
		
		return "";
	}

	@Override
	public String listadoDeGanadores() {
		String ganadores="";
		for(Participante p: getRegistroDeParticipantes()) {
			if(llenoAlbum(p.getDNI())) {
				ganadores= ganadores + "[" +p.getNombreUsuario().toString() + "]";	
			}
		}
		return ganadores;
	}

	@Override
	public List<String> participantesQueCompletaronElPais(String nombrePais) {
		List<String> participantes= new ArrayList<>();
		for(Participante p: getRegistroDeParticipantes()) {
			if(contarFiguritas(p,nombrePais)==11) {
				participantes.add(p.getNombreUsuario());
			}
		}
		return participantes;
	}
	
	@Override
	public String toString() {
		StringBuilder sb= new StringBuilder();
		sb.append("Participantes cargados en el sistema:");
		sb.append("\n");
		sb.append(getRegistroDeParticipantes().toString());
		return sb.toString();
	}
	
/*-----------METODOS AUXILIARES---------------*/
	
	private int contarFiguritas(Participante p,String Pais) {
		int contador=0;
			for(Figuritas f: p.getAlbum().getFiguritasPegadas()) {
				if(f.getPais().equals(Pais)) {
					contador++;
				}
			}
		return contador;
	}
}
