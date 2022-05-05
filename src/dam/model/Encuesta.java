package dam.model;

public class Encuesta {
	
	public static final String PRE_EDAD = "Edad: ";
	public static final String PRE_COVID = "¿Ha pasado usted el COVID-19? ";
	public static final String PRE_SINTOMAS = "¿Qué síntomas padeció? ";
	public static final String PRE_GRAV = "Nivel de gravedad: ";
	public static final String[] NIVELES_GRAV = {"Ninguna", "Leve", "Media", "Alta", "Hospitalización"};
	public static final String[] RESP_COVID = {"SI", "NO" };
	
	private int edad;
	private boolean covid;
	private String sintomas;
	private int gravedad;
	
	
	public Encuesta(int edad, boolean covid, String sintomas, int gravedad) {
		this.edad = edad;
		this.covid = covid;
		this.sintomas = sintomas;
		this.gravedad = gravedad;
	}


	@Override
	public String toString() {
		return 			 PRE_EDAD + edad 
				+ "\n" + PRE_COVID + traducirCovid()
				+ "\n" + PRE_SINTOMAS + sintomas 
				+ "\n" + PRE_GRAV + traducirGravedad();
	}


	private String traducirGravedad() {
		return covid? RESP_COVID[0]:RESP_COVID[1]; //ternario para traducir si es o no positivo en covid
	}

	//nos hemos creado un array con los posibles niveles de gravedad y retornamos lo que haya introducido en "gravedad" -1
	//para acceder a la posición de ese array
	private String traducirCovid() {
		return NIVELES_GRAV[gravedad-1]; 
	}
	
	
	
}
