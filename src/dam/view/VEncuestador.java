package dam.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dam.control.EncuestasControlador;
import dam.model.Encuesta;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;

public class VEncuestador extends JFrame {
	
	public static final String BTN_GUARDAR = "Guardar";
	public static final String BTN_LIMPIAR = "Limpiar";
	public static final String BTN_VER = "Ver encuestas realizadas";
	
	private final ButtonGroup buttonGroupGravedad = new ButtonGroup(); //atributo necesario para poder añadir a un grupo varios radio button
	private JTextArea txtResultado;
	private JCheckBox chkRespiratorio;
	private JCheckBox chkOlfato;
	private JCheckBox chkCabeza;
	private JCheckBox chkSinSintomas;
	private JCheckBox chkCansancio;
	private JCheckBox chkGusto;
	private JCheckBox chkFiebre;
	private JCheckBox chkTos;
	private JRadioButton rbtnNinguno;
	private JRadioButton rbtnLeve;
	private JRadioButton rbtnModerado;
	private JRadioButton rbtnAlta;
	private JRadioButton rbtnHospitalizacion;
	private JSpinner spnEdad;
	private JComboBox<String> cmbRespCovid; //no olvidar poner el tipo de dato ya que hemos puesto un array
	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnVer;
	private JScrollPane scrpResultado;
	
	
	public VEncuestador() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		setTitle("Encuestas COVID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(600, 800);
		
		JLabel lblEdad = new JLabel(Encuesta.PRE_EDAD);
		lblEdad.setBounds(35, 34, 48, 14);
		getContentPane().add(lblEdad);
		
		JLabel lblCovid = new JLabel(Encuesta.PRE_COVID);
		lblCovid.setBounds(35, 88, 166, 14);
		getContentPane().add(lblCovid);
		
		JLabel lblSintomas = new JLabel(Encuesta.PRE_SINTOMAS);
		lblSintomas.setBounds(35, 143, 128, 14);
		getContentPane().add(lblSintomas);
		
		JLabel lblGravedad = new JLabel(Encuesta.PRE_GRAV);
		lblGravedad.setBounds(35, 334, 117, 14);
		getContentPane().add(lblGravedad);
		
		chkRespiratorio = new JCheckBox("Síntomas Respiratorios");
		chkRespiratorio.setBounds(64, 173, 137, 23);
		getContentPane().add(chkRespiratorio);
		
		chkOlfato = new JCheckBox("Pérdida Olfato");
		chkOlfato.setBounds(64, 210, 137, 23);
		getContentPane().add(chkOlfato);
		
		chkCabeza = new JCheckBox("Dolor de cabeza");
		chkCabeza.setBounds(64, 246, 137, 23);
		getContentPane().add(chkCabeza);
		
		chkSinSintomas = new JCheckBox("Sin síntomas");
		chkSinSintomas.setBounds(64, 288, 137, 23);
		getContentPane().add(chkSinSintomas);
		
		chkCansancio = new JCheckBox("Cansancio / Malestar");
		chkCansancio.setBounds(293, 173, 137, 23);
		getContentPane().add(chkCansancio);
		
		chkGusto = new JCheckBox("Pérdida del gusto");
		chkGusto.setBounds(293, 210, 137, 23);
		getContentPane().add(chkGusto);
		
		chkFiebre = new JCheckBox("Fiebre");
		chkFiebre.setBounds(293, 246, 137, 23);
		getContentPane().add(chkFiebre);
		
		chkTos = new JCheckBox("Tos seca");
		chkTos.setBounds(293, 288, 137, 23);
		getContentPane().add(chkTos);
		
		rbtnNinguno = new JRadioButton("1- "+Encuesta.NIVELES_GRAV[0]);
		buttonGroupGravedad.add(rbtnNinguno);
		rbtnNinguno.setBounds(64, 380, 109, 23);
		getContentPane().add(rbtnNinguno);
		
		rbtnLeve = new JRadioButton("2- "+Encuesta.NIVELES_GRAV[1]);
		buttonGroupGravedad.add(rbtnLeve);
		rbtnLeve.setBounds(206, 380, 109, 23);
		getContentPane().add(rbtnLeve);
		
		rbtnModerado = new JRadioButton("3- "+Encuesta.NIVELES_GRAV[2]);
		buttonGroupGravedad.add(rbtnModerado);
		rbtnModerado.setBounds(387, 380, 109, 23);
		getContentPane().add(rbtnModerado);
		
		rbtnAlta = new JRadioButton("4- "+Encuesta.NIVELES_GRAV[3]);
		buttonGroupGravedad.add(rbtnAlta);
		rbtnAlta.setBounds(126, 435, 109, 23);
		getContentPane().add(rbtnAlta);
		
		rbtnHospitalizacion = new JRadioButton("5- "+Encuesta.NIVELES_GRAV[4]);
		buttonGroupGravedad.add(rbtnHospitalizacion);
		rbtnHospitalizacion.setBounds(300, 435, 109, 23);
		getContentPane().add(rbtnHospitalizacion);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 115, 1));
		spnEdad.setBounds(106, 31, 57, 20);
		spnEdad.setEditor(new JSpinner.DefaultEditor(spnEdad));
		getContentPane().add(spnEdad);
		
		cmbRespCovid = new JComboBox<String>();
		cmbRespCovid.setModel(new DefaultComboBoxModel<String>(Encuesta.RESP_COVID)); //el combobox ya coje los item del array como opciones; "SI", "NO" en este caso
		cmbRespCovid.setBounds(211, 84, 62, 22);
		getContentPane().add(cmbRespCovid);
		
		btnGuardar = new JButton(BTN_GUARDAR);
		btnGuardar.setBounds(63, 482, 89, 23);
		getContentPane().add(btnGuardar);
		
		btnLimpiar = new JButton(BTN_LIMPIAR);
		btnLimpiar.setBounds(360, 482, 89, 23);
		getContentPane().add(btnLimpiar);
		
		btnVer = new JButton(BTN_VER);
		btnVer.setBounds(177, 537, 173, 23);
		getContentPane().add(btnVer);
		
		scrpResultado = new JScrollPane();
		scrpResultado.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrpResultado.setBounds(64, 592, 422, 79);
		getContentPane().add(scrpResultado);
		
		txtResultado = new JTextArea();
		scrpResultado.setViewportView(txtResultado);
		txtResultado.setColumns(10);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(EncuestasControlador controlador) {
		btnGuardar.addActionListener(controlador); //añadimos los 3 botones para controlar la acción de cada uno
		btnLimpiar.addActionListener(controlador);
		btnVer.addActionListener(controlador);
		cmbRespCovid.addActionListener(controlador);//para controlar que si se pone "no" ha pasado covid, deseleccionar los síntomas
		chkSinSintomas.addItemListener(controlador); //para controlar que se han puesto sin síntomas; aquí es ITEM LISTENER
	}

	public void limpiarComponentes() {
		spnEdad.setValue(0); //ponemos a 0 el campo edad
		
		cmbRespCovid.setSelectedIndex(0); //ponemos el predeterminado en el desplegable del combobox; en este caso, el "sí"
		
		limpiarChkRbtn();
		
		txtResultado.setText(""); //el área de texto, la vaciamos
	}

	private void limpiarChkRbtn() {
		limpiarChkSintomas(); //ponemos a false (deselecionar) todos los síntomas y
		chkSinSintomas.setSelected(false); //fuera del método, lo mismo con este
		
		rbtnNinguno.setSelected(true); //seleccionamos uno del grupo de botones; en este caso, el radiobutton de ninguna gravedad
	}

	public void limpiarChkSintomas() { //método para llamar en el controlador y así deseleccionar cuando seleccionamos "sin síntomas"
		chkRespiratorio.setSelected(false);
		chkCabeza.setSelected(false);
		chkCansancio.setSelected(false);
		chkFiebre.setSelected(false);
		chkGusto.setSelected(false);
		chkOlfato.setSelected(false);
		chkTos.setSelected(false);
	}

	public Encuesta obtenerEncuesta() {
		Encuesta encuesta = null;
		
		int edad = (int) spnEdad.getValue(); //necesita ser casteado para coger el valor primitivo del Integer
		
		boolean covid = true;
		//Comprobar si se ha seleccionado el no:
		//if (cmbRespCovid.getSelectedItem().equals(Encuesta.RESP_COVID[1]
		if (cmbRespCovid.getSelectedIndex() == 1) { //en la posición 1, tenemos el NO
			covid = false;
		}
		
		String sintomas = obtenerSintomas();
		
		int gravedad = obtenerGravedad();
		
		encuesta = new Encuesta(edad, covid, sintomas, gravedad);
		
		return encuesta;
	}

	private String obtenerSintomas() {
		
		String sintomas = "";
		if (chkCabeza.isSelected()) {
			sintomas += chkCabeza.getText();
		}
		if (chkCansancio.isSelected()) {
			if (!sintomas.isEmpty()) {
				sintomas += ", ";
			}
			sintomas += chkCansancio.getText();
		}
		if (chkFiebre.isSelected()) {
			if (!sintomas.isEmpty()) {
				sintomas += ", ";
			}
			sintomas += chkFiebre.getText();
		}
		if (chkGusto.isSelected()) {
			if (!sintomas.isEmpty()) {
				sintomas += ", ";
			}
			sintomas += chkGusto.getText();
		}
		if (chkOlfato.isSelected()) {
			
			if (!sintomas.isEmpty()) {
				sintomas += ", ";
			}
			sintomas += chkOlfato.getText();
		}
		if (chkFiebre.isSelected()) {
			if (!sintomas.isEmpty()) {
				sintomas += ", ";
			}
			sintomas += chkFiebre.getText();
		}
		if (chkRespiratorio.isSelected()) {
			if (!sintomas.isEmpty()) {
				sintomas += ", ";
			}
			sintomas += chkRespiratorio.getText();
		}
		if (chkSinSintomas.isSelected()) {
			if (!sintomas.isEmpty()) {
				sintomas += ", ";
			}
			sintomas += chkSinSintomas.getText();
		}
		return sintomas;
	}

	private int obtenerGravedad() {
		int gravedad = 1;
		
		if (rbtnLeve.isSelected()) {
			gravedad = 2;
		} else if (rbtnModerado.isSelected()) {
			gravedad = 3;
		} else if (rbtnAlta.isSelected()) {
			gravedad = 4;
		} else if (rbtnHospitalizacion.isSelected()) {
			gravedad = 5;
		}
		
		return gravedad;
	}

	public void mostrarEncuestas(ArrayList<Encuesta> listado) {
		String encuestas = "";
		
		for (Encuesta encuesta : listado) {
			encuestas += "\n" + encuesta; //añadimos cada elemento al string que almacenará todas las encuestas creadas
		}
		
		txtResultado.setText(encuestas); //mostramos en la caja de texto el listado
	}

	public JComboBox<String> getCmbRespCovid() { //getter para el combobox de si respuesta covid ha sido sí o no
		return cmbRespCovid;
	}

	public void habilitarComponentes(boolean b) {
		chkRespiratorio.setEnabled(b); 
		chkCabeza.setEnabled(b); 
		chkCansancio.setEnabled(b); 
		chkFiebre.setEnabled(b);
		chkGusto.setEnabled(b);
		chkOlfato.setEnabled(b);
		chkTos.setEnabled(b);
		chkSinSintomas.setEnabled(b);
		
		rbtnAlta.setEnabled(b);
		rbtnHospitalizacion.setEnabled(b);
		rbtnLeve.setEnabled(b);
		rbtnModerado.setEnabled(b);
		rbtnNinguno.setEnabled(b);
		
		if (!b) { //
			limpiarChkRbtn();
		}
	}
}
