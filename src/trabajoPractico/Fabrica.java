package trabajoPractico;

import java.util.HashMap;
import java.util.Map;

public class Fabrica {

	private String[] premiosInstantaneos;
	private String[] paisesParticipantes;
	private String[] listadoDeMundialesTop10;
	private Map<String, String[]> balonYPaisPorMundialTop10;
	private Map<String, Integer> ranking;
	
/*--------------------------------------------------------------*/

		Fabrica() {			
			paisesParticipantes = generarPaisesClasificados();
			listadoDeMundialesTop10 = generarListadoDeMundiales();
			balonYPaisPorMundialTop10 = generarPaisesPorMundial();
			ranking = generarRanking();
			premiosInstantaneos = generarPremiosParaSorteoInstantaneo();
		}

/*--------------------------------------------------------------*/
		
		public FiguritaTradicional generarFigurita() {
			String pais= paisRandom();
			Integer numeroJugador= jugadorRandom();
			return new FiguritaTradicional(pais, numeroJugador);
		}
		
		public FiguritaTOP10 generarFiguritaTOP10() {
			String mundial= mundialRandom();
			Integer numeroJugador= jugadorRandom();
			return new FiguritaTOP10(mundial, numeroJugador);
		}
		
		public String generarPremio(Participante p) {
			int numero=(int)(Math.random() * 3) + 0;
			return premiosInstantaneos[numero];
		}
		
		private String paisRandom() {					
			int numero=(int)(Math.random() * 31) + 0;
			return paisesParticipantes[numero];
		}
		
		private Integer jugadorRandom() {				
			int numero=(int)(Math.random() * 11) + 1;
			return numero;
		}
		
		private String mundialRandom() {				
			int numero=(int)(Math.random() * 9) + 0;
			return listadoDeMundialesTop10[numero];
		}
		
		public int ValorFiguritaTradicional(String pais, int numero) {  
			return calcularValorFinal(pais, numero);
		}
	
		public Integer PrimerOSegundoLugar() {								
			int numero=(int)(Math.random() * 2);
			return numero;
		}
		
		public String balonDeOroOPlata(String pais) {								
			return balonYPaisPorMundialTop10.get(pais)[PrimerOSegundoLugar()];
}
		
/*--------------------------------------------------------------*/
		
		
		///////////////////////////////////////////////////////
		///////////// METODOS FACILITADOS POR LA CATEDRA //////
		///////////////////////////////////////////////////////
		
		// Dado el pais y numero de jugador de una figurita calcula
		// cual es su valor base simbolico.
		
		private int calcularValorFinal(String pais, int numero) {
			return ranking.get(pais) + numero;
		}
		
		private String[] generarPremiosParaSorteoInstantaneo() {
			return new String[]{
					"Una pelota","1 Sobre Gratis", "Una camiseta"
				};
		}

		private String[] generarPaisesClasificados() {
			return new String[]{ 
					"Alemania",   "Arabia Saud�",   "Argentina",          "Australia", 
					"Brasil",     "B�lgica",        "Camer�n",            "Canad�", 
					"Costa Rica", "Croacia",        "Dinamarca",          "Ecuador",
					"Espa�a",     "Estados Unidos", "Francia",            "Gales",
					"Ghana",      "Inglaterra",     "Ir�n",               "Jap�n", 
					"Marruecos",  "M�xico",         "Pa�ses Bajos",       "Polonia",
					"Portugal",   "Qatar",          "Rep�blica de Corea", "Senegal", 
					"Serbia",     "Suiza",          "T�nez",              "Uruguay" 
				};
		}

		private String[] generarListadoDeMundiales() {
			return new String[] { 
					"Espa�a '82",    "M�xico '86", "Italia '90",  "Estados Unidos '94",
					"Francia '98",   "Corea del Sur y Jap�n '02", "Alemania '06", 
					"Sud�frica '10", "Brasil '14", "Rusia '18" };
		}
		
		private Map<String, String[]> generarPaisesPorMundial() {
			Map<String, String[]> ret = new HashMap<>();
			ret.put("Espa�a '82", new String[] { "Italia", "Alemania" });
			ret.put("M�xico '86", new String[] { "Argentina", "Alemania" });
			ret.put("Italia '90", new String[] { "Alemania", "Argentina" });
			ret.put("Estados Unidos '94", new String[] { "Brasil", "Italia" });
			ret.put("Francia '98", new String[] { "Francia", "Brasil" });
			ret.put("Corea del Sur y Jap�n '02", new String[] { "Brasil", "Alemania" });
			ret.put("Alemania '06", new String[] { "Italia", "Francia" });
			ret.put("Sud�frica '10", new String[] { "Espa�a", "Pa�ses Bajos" });
			ret.put("Brasil '14", new String[] { "Alemania", "Argentina" });
			ret.put("Rusia '18", new String[] { "Francia", "Croacia" });
			return ret;
		}
		
		private Map<String, Integer> generarRanking() {
			Map<String, Integer> ret = new HashMap<>();
			ret.put("Brasil",1);
			ret.put("B�lgica",2);
			ret.put("Argentina",3);
			ret.put("Francia",4);
			ret.put("Inglaterra",5);
			ret.put("Italia",6);
			ret.put("Espa�a",7);
			ret.put("Pa�ses Bajos",8);
			ret.put("Portugal",9);
			ret.put("Dinamarca",10);
			ret.put("Alemania",11);
			ret.put("Croacia",12);
			ret.put("M�xico",13);
			ret.put("Uruguay",14);
			ret.put("Suiza",15);
			ret.put("Estados Unidos",16);
			ret.put("Colombia",17);
			ret.put("Senegal",18);
			ret.put("Gales",19);
			ret.put("Ir�n",20);
			ret.put("Serbia",21);
			ret.put("Marruecos",22);
			ret.put("Per�",23);
			ret.put("Jap�n",24);
			ret.put("Suecia",25);
			ret.put("Polonia",26);
			ret.put("Ucrania",27);
			ret.put("Rep�blica de Corea",28);
			ret.put("Chile",29);
			ret.put("T�nez",30);
			ret.put("Costa Rica",31);
			ret.put("Nigeria",32);
			ret.put("Rusia",33);
			ret.put("Austria",34);
			ret.put("Rep�blica Checa",35);
			ret.put("Hungr�a",36);
			ret.put("Argelia",37);
			ret.put("Australia",38);
			ret.put("Egipto",39);
			ret.put("Escocia",40);
			ret.put("Canad�",41);
			ret.put("Noruega",42);
			ret.put("Camer�n",43);
			ret.put("Ecuador",44);
			ret.put("Turqu�a",45);
			ret.put("Mali",46);
			ret.put("Paraguay",47);
			ret.put("Costa de Marfil",48);
			ret.put("Rep�blica de Irlanda",49);
			ret.put("Qatar",50);
			ret.put("Arabia Saud�",51);
			ret.put("Grecia",52);
			ret.put("Ruman�a",53);
			ret.put("Burkina Faso",54);
			ret.put("Eslovaquia",55);
			ret.put("Finlandia",56);
			ret.put("Venezuela",57);
			ret.put("Bosnia y Herzegovina",58);
			ret.put("Irlanda del Norte",59);
			ret.put("Panam�",60);
			ret.put("Ghana",61);
			ret.put("Islandia",62);
			ret.put("Eslovenia",63);
			ret.put("Jamaica",64);
			ret.put("Macedonia del Norte",65);
			ret.put("Albania",66);
			ret.put("Sud�frica",67);
			ret.put("Irak",68);
			ret.put("Montenegro",69);
			ret.put("Emiratos �rabes Unidos",70);
			ret.put("Cabo Verde",71);
			ret.put("Bulgaria",72);
			ret.put("RD del Congo",73);
			ret.put("El Salvador",74);
			ret.put("Om�n",75);
			ret.put("Israel",76);
			ret.put("Uzbekist�n",77);
			ret.put("Georgia",78);
			ret.put("RP China",79);
			ret.put("Honduras",80);
			ret.put("Gab�n",81);
			ret.put("Bolivia",82);
			ret.put("Guinea",83);
			ret.put("Jordania",84);
			ret.put("Bahr�in",85);
			ret.put("Cura�ao",86);
			ret.put("Hait�",87);
			ret.put("Zambia",88);
			ret.put("Uganda",89);
			ret.put("Siria",90);
			ret.put("Ben�n",91);
			ret.put("Luxemburgo",92);
			ret.put("Armenia",93);
			ret.put("Palestina",94);
			ret.put("Rep�blica Kirguisa",95);
			ret.put("Vietnam",96);
			ret.put("Bielorrusia",97);
			ret.put("Guinea Ecuatorial",98);
			ret.put("L�bano",99);
			ret.put("Congo",100);
			ret.put("Kenia",101);
			ret.put("Madagascar",102);
			ret.put("Mauritania",103);
			ret.put("Trinidad y Tobago",104);
			ret.put("Nueva Zelanda",105);
			ret.put("India",106);
			ret.put("Kosovo",107);
			ret.put("Tayikist�n",108);
			ret.put("Estonia",109);
			ret.put("Chipre",110);
			ret.put("Tailandia",111);
			ret.put("RDP de Corea",112);
			ret.put("Kazajst�n",113);
			ret.put("Mozambique",114);
			ret.put("Namibia",115);
			ret.put("Guinea-Biss�u",116);
			ret.put("Sierra Leona",117);
			ret.put("Guatemala",118);
			ret.put("Angola",119);
			ret.put("Libia",120);
			ret.put("N�ger",121);
			ret.put("Islas Feroe",122);
			ret.put("Azerbaiy�n",123);
			ret.put("Malaui",124);
			ret.put("Zimbabue",125);
			ret.put("Gambia",126);
			ret.put("Togo",127);
			ret.put("Sud�n",128);
			ret.put("Comoras",129);
			ret.put("Tanzania",130);
			ret.put("Antigua y Barbuda",131);
			ret.put("Rep�blica Centroafricana",132);
			ret.put("Filipinas",133);
			ret.put("Letonia",134);
			ret.put("Turkmenist�n",135);
			ret.put("Islas Salom�n",136);
			ret.put("Ruanda",137);
			ret.put("Etiop�a",138);
			ret.put("Surinam",139);
			ret.put("San Crist�bal y Nieves",140);
			ret.put("Burundi",141);
			ret.put("Nicaragua",142);
			ret.put("Esuatini",143);
			ret.put("Lituania",144);
			ret.put("Hong Kong",145);
			ret.put("Malasia",146);
			ret.put("Lesoto",147);
			ret.put("Botsuana",148);
			ret.put("Kuwait",149);
			ret.put("Liberia",150);
			ret.put("Andorra",151);
			ret.put("Indonesia",152);
			ret.put("Rep�blica Dominicana",153);
			ret.put("Maldivas",154);
			ret.put("Yemen",155);
			ret.put("Afganist�n",156);
			ret.put("Chinese Taipei",157);
			ret.put("Myanmar",158);
			ret.put("Pap�a Nueva Guinea",159);
			ret.put("Singapur",160);
			ret.put("Nueva Caledonia",161);
			ret.put("Tahit�",162);
			ret.put("Fiyi",163);
			ret.put("Vanuatu",164);
			ret.put("Sud�n del Sur",165);
			ret.put("Barbados",166);
			ret.put("Cuba",167);
			ret.put("Malta",168);
			ret.put("Bermudas",169);
			ret.put("Puerto Rico",170);
			ret.put("Guyana",171);
			ret.put("Santa Luc�a",172);
			ret.put("Granada",173);
			ret.put("Moldavia",174);
			ret.put("Nepal",175);
			ret.put("Belice",176);
			ret.put("Camboya",177);
			ret.put("San Vicente y las Granadinas",178);
			ret.put("Montserrat",179);
			ret.put("Mauricio",180);
			ret.put("Chad",181);
			ret.put("Macao",182);
			ret.put("Mongolia",183);
			ret.put("Dominica",184);
			ret.put("But�n",185);
			ret.put("Santo Tom� y Pr�ncipe",186);
			ret.put("Laos",187);
			ret.put("Samoa Estadounidense",188);
			ret.put("Islas Cook",189);
			ret.put("Brun�i Darussalam",190);
			ret.put("Samoa",191);
			ret.put("Bangladesh",192);
			ret.put("Yibuti",193);
			ret.put("Pakist�n",194);
			ret.put("Islas Caim�n",195);
			ret.put("Liechtenstein",196);
			ret.put("Tonga",197);
			ret.put("Timor Oriental",198);
			ret.put("Seychelles",199);
			ret.put("Eritrea",200);
			ret.put("Aruba",201);
			ret.put("Bahamas",202);
			ret.put("Somalia",203);
			ret.put("Gibraltar",204);
			ret.put("Guam",205);
			ret.put("Turcas y Caicos",206);
			ret.put("Sri Lanka",207);
			ret.put("Islas V�rgenes Estadounidenses",208);
			ret.put("Islas V�rgenes Brit�nicas",209);
			ret.put("Anguila",210);
			ret.put("San Marino",211);
			return ret;
		}

}
