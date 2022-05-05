package dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import dam.model.Encuesta;
import dam.model.ListaEncuestas;
import dam.view.VEncuestador;

public class EncuestasControlador implements ActionListener, ItemListener { //itemlistener para controlar el estado de un checkbox
	
	VEncuestador ventana;
	ListaEncuestas listaEncuestas; //contiene una lista, pero no es una lista
	
	public EncuestasControlador(VEncuestador ventana) {
		this.ventana = ventana;
		this.listaEncuestas = new ListaEncuestas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		e.getSource();//con este método obtengo el componente en el que se ha producido el evento; porque tenemos muchos
		
		e.getActionCommand();//este me facilita el comando asociado al componente en el que se ha producido el evento
		
		if (e.getSource() instanceof JButton) { //si el componente en el que se ha producido el evento es un botón
			if (e.getActionCommand().equals(VEncuestador.BTN_LIMPIAR)) { //así identifico que se ha seleccionado el botón limpiar
				ventana.limpiarComponentes();
			} else if (e.getActionCommand().equals(VEncuestador.BTN_GUARDAR)) { //si hace click en guardar encuesta:
				Encuesta encuesta = ventana.obtenerEncuesta(); //almacenamos los datos con este objeto a través del método y después
				listaEncuestas.nuevaEncuesta(encuesta); //añadimos al ArrayList del pojo ListaEncuestas, una nueva encuesta con los datos obtenido en la línea anterior
			} else if (e.getActionCommand().equals(VEncuestador.BTN_VER)) { //si ha hecho click en ver encuestas:
				ventana.mostrarEncuestas(listaEncuestas.getListado()); //getter de la encuesta
			}
		} else if (e.getSource() instanceof JComboBox) {//si el componente en el que se ha producido el evento es un desplegable
			if (ventana.getCmbRespCovid().getSelectedIndex() == 0) {//accedemos al getter del combo box para saber si se puso "sí" o "no" en covid
				ventana.habilitarComponentes(true);
			} else {//si ha seleccionado 1; significa que ha seleccionado no (posición 2 del array)
				ventana.habilitarComponentes(false);
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) { //para controlar si se da check a "sin síntomas"
		if (e.getSource() instanceof JCheckBox) { //comprobar que es de tipo checkbox
			if (e.getStateChange() == ItemEvent.SELECTED) { //si el check está seleccionado
				ventana.limpiarChkSintomas();
			}
		}

	}
}
