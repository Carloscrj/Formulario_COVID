package dam.model;

import java.util.ArrayList;

public class ListaEncuestas {
	private ArrayList<Encuesta> listado;
	
	public ListaEncuestas() { //constructor
		listado = new ArrayList<>(); //inicializamos el arraylist para cuando empecemos a introducir encuestas
	}

	public ArrayList<Encuesta> getListado() { //getter de la encuesta
		return listado;
	}
	
	public void nuevaEncuesta(Encuesta encuesta) { //método para añadir encuestas
		listado.add(encuesta);
	}
}
