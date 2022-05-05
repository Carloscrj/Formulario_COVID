package dam.main;

import java.awt.EventQueue;

import dam.control.EncuestasControlador;
import dam.view.VEncuestador;

public class EncuestasInicio {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				VEncuestador ventana = new VEncuestador();
				
				EncuestasControlador controlador = new EncuestasControlador(ventana);
				
				ventana.setControlador(controlador);
				
				ventana.hacerVisible();
			}
		});
	}

}
