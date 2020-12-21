import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * Ventana.java
   25 nov. 2020 8:48:04
 */

/**
 * @author Ana José García Rodríguez
 *
 */
public class Ventana extends JFrame implements ActionListener{
	
	/** The p 1. */
	private panelRegistros p1;
	
	/** The p botones. */
	private Panel pBotones;
	
	/** The mi barra. */
	private JMenuBar miBarra;
	
	/** The ayuda. */
	private JMenu archivo, registro, ayuda;
	
	/** The acerca de. */
	private JMenuItem salir, altasReservas, bajasReservas, acercaDe;
	
	/** The btn reservar. */
	private JButton btnEliminar, btnReservar;
	
	/** The Ventana registros. */
	private JFrame VentanaRegistros;
	
	/**
	 * Instantiates a new ventana.
	 */
	public Ventana() {
		super("GESTION HOTEL MARAVILLA");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Tamaño y posicion de la ventana
		 
		
		//Hay que crear un objeto Toolkit ya que nos lo devuelve
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		//ponemos la ventana en el centro de la pantalla
		this.setLocationRelativeTo(null);
		Dimension tamagnoPantalla = miPantalla.getScreenSize();
		//Ancho y alto de la pantalla
		int altoPantalla = tamagnoPantalla.height;
		int anchoPantalla = tamagnoPantalla.width;
		//Si queremos que la resolución de la ventana sea la mitad que la de nuestra pantalla
		//tenemos que dividir el alto y ancho de nuestra pantalla entre raiz de 2.
		int anchoVentana = (int) (anchoPantalla/1.41421356237);
		int altoVentana = (int) (altoPantalla/1.41421356237);
		//Centramos la ventana
		this.setBounds(anchoPantalla/2-anchoVentana/2, altoPantalla/2-altoVentana/2, anchoVentana, altoVentana);
		this.setLayout(null);
		
		//Nuevo Icono
		Image miIcono = miPantalla.getImage("src\\recursos\\Logo.jpg");
		this.setIconImage(miIcono);
		
		
		VentanaRegistros = new JFrame();
		VentanaRegistros.setBounds(0, 0, anchoPantalla, altoPantalla);
		VentanaRegistros.setIconImage(miIcono);
		VentanaRegistros.setTitle("GESTION HOTEL MARAVILLA");
		
		
		p1 = new panelRegistros();
		p1.setBounds(0, 0, 500, 100);
		
		
		pBotones = new Panel();
		pBotones.setBounds(anchoVentana/2-160, altoVentana/2-120, 280, 120);

		
		btnEliminar = new JButton();
		btnEliminar.setBounds(0, 0, 100, 100);
		//Le ponemos foto a nuestro boton de eliminar
		ImageIcon fotoEliminar = new ImageIcon("src\\recursos\\eliminar.jpg");
		Image imgEliminar = fotoEliminar.getImage();
		ImageIcon elim = new ImageIcon(imgEliminar.getScaledInstance(100, 100, Image.SCALE_SMOOTH)); 
		btnEliminar.setIcon(elim);
		btnEliminar.addActionListener(this);
		btnEliminar.setMnemonic(KeyEvent.VK_B);
		
		btnReservar = new JButton();
		btnReservar.setBounds(100, 0, 100, 100);
		//Le ponemos foto a nuestro boton de eliminar
		ImageIcon fotoReserva = new ImageIcon("src\\recursos\\registrar.png");
		Image imgReserva = fotoReserva.getImage();
		ImageIcon reservar = new ImageIcon(imgReserva.getScaledInstance(100, 100, Image.SCALE_SMOOTH)); 
		btnReservar.setIcon(reservar);
		btnReservar.addActionListener(this);
		btnReservar.setMnemonic(KeyEvent.VK_A);
		
		this.add(pBotones);
		pBotones.add(btnEliminar);
		pBotones.add(btnReservar);
		this.iniciarComponentes();
		
		

		
		

	}
	
	/**
	 * Iniciar componentes.
	 */
	//Vamos a crear nuestra barra de menu
	public void iniciarComponentes() {
		miBarra = new JMenuBar();
		
		archivo = new JMenu("Archivo");
		//Opcion que tiene la barraMenu de Archivos
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		
		registro = new JMenu("Registros");
		altasReservas = new JMenuItem("Altas Reservas");
		altasReservas.addActionListener(this);
		registro.setMnemonic(KeyEvent.VK_R);

		
		
		bajasReservas = new JMenuItem("Bajas Reservas");
		bajasReservas.addActionListener(this);
		
		ayuda = new JMenu("Ayuda");
		acercaDe = new JMenuItem("Acerca De..");
		acercaDe.addActionListener(this);
		
		//añadimos la barra a la ventana 
		this.setJMenuBar(miBarra);
		miBarra.add(archivo);
		miBarra.add(registro);
		miBarra.add(ayuda);
		archivo.add(salir);
		registro.add(altasReservas);
		registro.add(bajasReservas);
		ayuda.add(acercaDe);
		
		
		
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Si pulsamos salir cerraremos la ventana 
		if(e.getSource()==salir) {
			//Cerramos ventana
			System.exit(0);
			
		}
		
		if(e.getSource()==acercaDe) {
			JOptionPane.showMessageDialog(null, "Esta aplicación es la pagína del Hotel Maravilla."
					+ "\nDedicada al serctor turístico desde su fundación en 1931. Cuenta con una "
					+ "\ndivisión hotelera y una división de viajes que le convierten en unas de las"
					+ "\nempresas más importantes."
					+ "\nEste maravilloso hotel se encuentra en la provincia de Almería, concretamente, en el municipio de Macael."
					+ "\nSu creadora es Ana José García Rodríguez, que ha realizado este proyecto con "
					+ "\nmucha ilusión y ganas. ");
		}
		if(e.getSource()== btnReservar || e.getSource()== altasReservas) {
			
			
				VentanaRegistros.setVisible(true);
				VentanaRegistros.add(p1);
				p1.setVisible(true);	
			}
		if(e.getSource()== bajasReservas || e.getSource()==btnEliminar) {
			
			JOptionPane.showMessageDialog(null, "Esta opción no está desarrolla por ahora por problemas técnicos.\n"
					+ "Muchas gracias por su visita."
					+ "\nUn cordial saludo");	
		}
		
	}
	
	

}
