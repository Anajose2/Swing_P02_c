import java.io.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * panelRegistros.java
   25 nov. 2020 8:48:56
 */

/**
 * @author Ana José García Rodríguez
 *
 */
public class panelRegistros extends JPanel implements ActionListener, FocusListener{

	/** The importe total. */
	private JLabel pintura1, pintura2, tituloArrendador, nombre, dni, ape, tlf, datosHab, dir, f_Alta, f_Final, t_Estancia,
	n_hab,n_dormitorio,n_baños, n_camas, t_hab, ninios, edad,extras,importeTotal;
	
	/** The lista hab. */
	private JComboBox<String> listaHab;
	
	/** The caja importe. */
	JFormattedTextField cajaNom, cajaApe, cajaDni, cajaTlf, cajaDir, cajaAlta, cajaSalida, cajaEstancia ,cajaHab,cajaExtras,
	cajaImporte;
	
	/** The mascara. */
	MaskFormatter mascara;
	
	/** The foto. */
	private ImageIcon tituloHotel, iconoHotel, foto;
	
	/** The edad ninios. */
	private JSpinner contador_Hab, edad_Ninios;
	
	/** The check ninios. */
	private JCheckBox checkNinios;
	
	/** The pestana 2. */
	private JPanel pNinios, pestana1,pestana2;
	
	/** The estancia. */
	private int estancia;
	
	/** The b save. */
	private JButton b1, b_New, b_Imprimir, b_Save;
	
	/** The cont boton. */
	int contBoton=1; //Vamos a crear un contador para que nos vaya cambiando las imagenes
	
	/** The misma foto 4. */
	private ImageIcon mismaFoto2,mismaFoto3,mismaFoto4;
	
	/** The txt area hab. */
	private JTextArea txtArea_Cliente, txtArea_Hab;
	
	/** The convertido 2. */
	private String convertido1,convertido2;
	
	/** The p 4. */
	private JTabbedPane p4;
	
	/**
	 * Instantiates a new panel registros.
	 */
	public panelRegistros() {
		this.setLayout(null);
		
		JPanel pTitulo = new JPanel();
		pTitulo.setBounds(30, 5, 600,180 );
		pTitulo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED , 
				Color.WHITE,Color.BLACK,Color.WHITE, Color.BLACK));
		pTitulo.setBackground(new Color(229,252,194));
		pTitulo.setLayout(null);
	
		
		JPanel pArrendador = new JPanel();
		pArrendador.setBounds(30, 220, 600, 175);
		pArrendador.setBackground(new Color(229,252,194));
		pArrendador.setLayout(null);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(30, 430, 600, 230);
		panel3.setBackground(new Color(229,252,194));
		panel3.setLayout(null);
		
		//Agregamos el nombre del Hotel
		tituloHotel = new ImageIcon(getClass().getResource("recursos/titulo.jpg"));
		//La pasamos a una clase Image
		Image imagen = tituloHotel.getImage();
		//La volvemos a pasar a ImageIcon para poder ajustarla
		ImageIcon mismaFoto = new ImageIcon(imagen.getScaledInstance(500, 150, Image.SCALE_SMOOTH));
		//El JLabel adquiere el valor de la imagen y le damos sus medidas
		pintura1 = new JLabel(mismaFoto);
		pintura1.setBounds(50, 15, 500, 150);


		
		tituloArrendador= new JLabel();
		tituloArrendador.setText("Datos Arrendador");
		tituloArrendador.setBounds(30, 200, 150, 25);
		tituloArrendador.setFont(new Font("SansSerif", Font.BOLD, 12));
		tituloArrendador.setForeground(new Color(84,121,128));
		
		nombre = new JLabel();
		nombre.setText("Nombre: ");
		nombre.setBounds(15, 15, 65, 25);
		nombre.setFont(new Font("SansSerif", Font.BOLD, 12));
		nombre.setForeground(new Color(69,173,168));
		
		cajaNom = new JFormattedTextField();
		cajaNom .setBounds(75, 15, 150, 25);
		
		dni = new JLabel();
		dni.setText("DNI: ");
		dni.setBounds(15, 55, 65, 25);
		dni.setFont(new Font("SansSerif", Font.BOLD, 12));
		dni.setForeground(new Color(69,173,168));
		
		try {
			mascara = new MaskFormatter("AAAAAAAAA");
			cajaDni = new JFormattedTextField(mascara);
			cajaDni.setBounds(75, 55, 150, 25);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
				
		ape = new JLabel();
		ape.setText("Apellidos: ");
		ape.setBounds(280, 15, 65, 25);
		ape.setFont(new Font("SansSerif", Font.BOLD, 12));
		ape.setForeground(new Color(69,173,168));
		
		cajaApe = new JFormattedTextField();
		cajaApe.setBounds(345, 15, 150, 25);
		
		//Linea de Tlf
		tlf = new JLabel();
		tlf.setText("Telefono: ");
		tlf.setBounds(280, 55, 65, 25);
		tlf.setForeground(new Color(69,173,168));
		
		try {
			mascara = new MaskFormatter("#########");
			cajaTlf = new JFormattedTextField(mascara);
			cajaTlf.setFocusLostBehavior(cajaTlf.COMMIT);
			cajaTlf.setBounds(345, 55, 150, 25);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}
		
		//Fecha de alta que coge por defecto la fecha actual, podemos modificarla
		f_Alta = new JLabel();
		f_Alta.setText("Fecha de Alta: ");
		f_Alta.setBounds(15, 95, 100, 25);
		f_Alta.setForeground(new Color(69,173,168));
		
		Date date = new Date();
		DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		convertido1 = fecha.format(date);
		
		cajaAlta = new JFormattedTextField();
		cajaAlta.setText(convertido1);
		cajaAlta.setBounds(110, 95, 115, 25);
		cajaAlta.addActionListener(this);
		
		//Fecha de salida, que por defecto le suma uno a la fecha actual
		f_Final = new JLabel();
		f_Final.setText("Fecha Salida: ");
		f_Final.setBounds(280, 95, 100, 25);
		f_Final.setForeground(new Color(69,173,168));
		
		cajaSalida = new JFormattedTextField();
		
		//Cogemos la fecha actual y le sumamos los milisegundos correspondientes a un día
		Date tomorrow = new Date(date.getTime()+(1000*60*60*24));
		convertido2 = fecha.format(tomorrow);
		cajaSalida = new JFormattedTextField();
		cajaSalida.setText(convertido2);
		cajaSalida.setBounds(380, 95, 115, 25);
		cajaSalida.addActionListener(this);
		
		t_Estancia = new JLabel();
		t_Estancia.setText("Estancia Total: ");
		t_Estancia.setBounds(15, 130, 100, 25);
		t_Estancia.setForeground(new Color(69,173,168));
		
		//Queremos saber cuantos dias de estancia, para ello pasamos la fecha a string y vamso stransformando el 
		//string cogiendo dia, mes y año y tansformandolo en entero
		String Alta = cajaAlta.getText();
		String Salida = cajaSalida.getText();
		int NAlta = Integer.parseInt(Alta.substring(0,2))+Integer.parseInt(Alta.substring(3,5))*30+Integer.parseInt(Alta.substring(6,10))*365;
		int NSalida = Integer.parseInt(Salida.substring(0,2))+Integer.parseInt(Salida.substring(3,5))*30+Integer.parseInt(Salida.substring(6,10))*365;
		
		//Hacemos la resta para saber cuantos días de stancia, suponiendo que todos los meses son de 31 dia
		estancia = NSalida - NAlta ;
		
		cajaEstancia = new JFormattedTextField(estancia+" dias");
		cajaEstancia.setBounds(110, 130, 100, 25);
		
		datosHab= new JLabel();
		datosHab.setText("Datos Habitación");
		datosHab.setBounds(30, 410, 150, 25);
		datosHab.setFont(new Font("SansSerif", Font.BOLD, 12));
		datosHab.setForeground(new Color(84,121,128));
		
		t_hab = new JLabel();
		t_hab.setText("Tipo de Habitación: ");
		t_hab.setBounds(15, 15, 120, 25);
		t_hab.setForeground(new Color(69,173,168));
		
		//Vamos a crear nuestra lista de Habitaciones
		String[] opciones = {"Simple", "Doble", "Suite"};
		listaHab = new JComboBox<String>(opciones);
		listaHab.setBounds(135, 15, 100, 25);
		listaHab.setForeground(new Color(93,109,126));
		listaHab.addActionListener(this);
		
		n_hab = new JLabel();
		n_hab.setText("Nº Habitaciones: ");
		n_hab.setBounds(15, 55, 120, 25);
		n_hab.setForeground(new Color(69,173,168));
		
		//Limitar el valor de un spinner de 0 hasta 50
		SpinnerModel sm = new SpinnerNumberModel(0,0,50,1);
		contador_Hab = new JSpinner(sm);
		contador_Hab.setBounds(135, 55, 50, 25);
		
		//Casilla de verificacion de niños
		ninios = new JLabel();
		ninios.setText("¿Niños?");
		ninios.setBounds(15, 95, 70, 25);
		ninios.setForeground(new Color(69,173,168));
		
		checkNinios = new JCheckBox();
		checkNinios.setBounds(85, 95, 25, 25);
		checkNinios.addActionListener(this);
		
		//Si los niños están entre 0-14 abre un tercer panel
		pNinios = new JPanel();
		pNinios.setBounds(15,120, 250, 90);
		pNinios.setBackground(new Color(157,224,173));
		pNinios.setLayout(null);
		
		edad = new JLabel();
		edad.setText("Edad: ");
		edad.setBounds(5, 15, 40, 25);
		edad.setForeground(new Color(69,173,168));
		
		//Limitar el valor de un spinner de 0 hasta 14
		SpinnerModel se = new SpinnerNumberModel(0,0,14,1);
		edad_Ninios = new JSpinner(se);
		edad_Ninios.setBounds(55, 15, 50, 20);
		
		extras = new JLabel();
		extras.setText("Extras: ");
		extras.setBounds(5, 45, 50, 25);
		extras.setForeground(new Color(69,173,168));
		
		cajaExtras = new JFormattedTextField();
		cajaExtras.setBounds(55, 45, 150, 25);
		cajaExtras.addFocusListener(this);
		
		importeTotal = new JLabel();
		importeTotal.setText("Importe Total: ");
		importeTotal.setBounds(275, 200, 100, 25);
		importeTotal.setForeground(new Color(69,173,168));
		
		cajaImporte = new JFormattedTextField();
		cajaImporte.setBounds(375, 200, 100, 25);
		cajaImporte.addFocusListener(this);
		
		
		//Añadimos una imagen del interior del Hotel
		foto = new ImageIcon(getClass().getResource("recursos/hotel.jpg"));
		//La pasamos a una clase Image
		Image imagen2 = foto.getImage();
		//La volvemos a pasar a ImageIcon para poder ajustarla
		mismaFoto2 = new ImageIcon(imagen2.getScaledInstance(250, 180, Image.SCALE_SMOOTH));
		
		//Imagen de la Habitacion del Hotel
		foto = new ImageIcon(getClass().getResource("recursos/hab.jpg"));
		//La pasamos a una clase Image
		Image imagen3 = foto.getImage();
		//La volvemos a pasar a ImageIcon para poder ajustarla
		mismaFoto3 = new ImageIcon(imagen3.getScaledInstance(250, 180, Image.SCALE_SMOOTH));
		
		//Imagen del paisaje donde está situado el hotel
		foto = new ImageIcon(getClass().getResource("recursos/paisaje.jpg"));
		//La pasamos a una clase Image
		Image imagen4 = foto.getImage();
		//La volvemos a pasar a ImageIcon para poder ajustarla
		mismaFoto4 = new ImageIcon(imagen4.getScaledInstance(250, 180, Image.SCALE_SMOOTH));
		
		pintura2 = new JLabel(mismaFoto2);
		pintura2.setBounds(275, 15, 250, 180);
		
		//Apuntamos a la imagen de New
		ImageIcon fotoNew = new ImageIcon("src/recursos/new.jpg");
		//La pasamos a una clase Image
		Image imagenNew = fotoNew.getImage();
		//La volvemos a pasar a ImageIcon para poder ajustarla
		ImageIcon iconoNew = new ImageIcon(imagenNew.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
		//Creamos los botones de nuevo,Guargar e imprimir
		b_New = new JButton(iconoNew);
		b_New.setBounds(230, 665, 30, 30);
		b_New.addActionListener(this);
		b_New.setToolTipText("Nuevo Registro");
		
		//Apuntamos a la imagen de Guardar o save
		ImageIcon fotoSave = new ImageIcon("src/recursos/save.jpg");
		//La pasamos a una clase Image
		Image imagenSave = fotoSave.getImage();
		//La volvemos a pasar a ImageIcon para poder ajustarla
		ImageIcon iconoSave = new ImageIcon(imagenSave.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
		//Creamos los botones de nuevo,Guargar e imprimir
		b_Save = new JButton(iconoSave);
		b_Save.setBounds(265, 665, 30, 30);
		b_Save.addActionListener(this);
		b_Save.setToolTipText("Guardar");
		
		//Apuntamos a la imagen de imprimir
		ImageIcon fotoPrint = new ImageIcon("src/recursos/print.jpg");
		//La pasamos a una clase Image
		Image imagenPrint = fotoPrint.getImage();
		//La volvemos a pasar a ImageIcon para poder ajustarla
		ImageIcon iconoPrint = new ImageIcon(imagenPrint.getScaledInstance(30, 30, Image.SCALE_SMOOTH));
				
		//Creamos los botones de nuevo,Guargar e imprimir
		b_Imprimir = new JButton(iconoPrint);
		b_Imprimir.setBounds(300, 665, 30, 30);
		b_Imprimir.addActionListener(this);
		b_Imprimir.setToolTipText("Imprimir");
		
		b1 = new JButton("➮");
		b1.setBounds(530, 170, 45, 25);
		b1.addActionListener(this);
		//Añadimos la etiqueta de infromacion para indicar la accion del boton
		b1.setToolTipText("Pulsar para cambiar de imagen");
		
		//Creamos el panel de Pestañas
		pestana1 = new JPanel();
		pestana1.setBackground(Color.WHITE);
		pestana1.setBounds(0, 0, 600, 645);
		pestana1.setLayout(null);
		
		pestana2 = new JPanel();
		pestana2.setForeground(new Color(69,173,168));
		pestana2.setBackground(Color.WHITE);
		pestana2.setBounds(50, 50, 400, 400);
		pestana2.setLayout(null);
		
		p4 = new JTabbedPane();
		p4.addTab("Datos Cliente", pestana1);
		p4.addTab("Datos Habitación", pestana2);
		p4.setForeground(new Color(69,173,168));
		p4.setBounds(640, 15, 600, 645);
		
		
		//Creamos los textAreas que nos apareceran en uestras pestañas con los datos introducidos
		txtArea_Cliente = new JTextArea();
		txtArea_Cliente.setBounds(50, 50, 250, 400);
		pestana1.add(txtArea_Cliente);
		
		txtArea_Hab = new JTextArea();
		txtArea_Hab.setBounds(50, 50, 250, 400);
		pestana2.add(txtArea_Hab);


		
		this.add(pTitulo);
		pTitulo.add(pintura1);
		
		
		//Añadimos el segundo panel, donde se recoge los datos del cliente
		this.add(tituloArrendador);
		pArrendador.add(nombre);
		pArrendador.add(cajaNom);
		pArrendador.add(dni);
		pArrendador.add(cajaDni);
		pArrendador.add(ape);
		pArrendador.add(cajaApe);
		pArrendador.add(tlf);
		pArrendador.add(cajaTlf);
		pArrendador.add(f_Alta);
		pArrendador.add(cajaAlta);
		pArrendador.add(f_Final);
		pArrendador.add(cajaSalida);
		pArrendador.add(t_Estancia);
		pArrendador.add(cajaEstancia);
		this.add(pArrendador);
		
		//Añadimos los daros de la habitacion
		this.add(datosHab);
		panel3.add(t_hab);
		panel3.add(listaHab);
		panel3.add(n_hab);
		panel3.add(contador_Hab);
		panel3.add(ninios);
		panel3.add(checkNinios);
		panel3.add(pNinios);
		//Panel estra ninios
		pNinios.add(edad);
		pNinios.add(edad_Ninios);
		pNinios.add(extras);
		pNinios.add(cajaExtras);
		pNinios.setVisible(false);
		//Importe Total
		panel3.add(importeTotal);
		panel3.add(cajaImporte);
		panel3.add(pintura2);
		panel3.add(b1);
		this.add(panel3);
		this.add(b_New);
		this.add(b_Save);
		this.add(b_Imprimir);
		this.add(p4);
		


		
	}
	

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String Alta = cajaAlta.getText();
		String Salida = cajaSalida.getText();
		int NAlta = Integer.parseInt(Alta.substring(0,2))+Integer.parseInt(Alta.substring(3,5))*30+Integer.parseInt(Alta.substring(6,10))*365;
		int NSalida = Integer.parseInt(Salida.substring(0,2))+Integer.parseInt(Salida.substring(3,5))*30+Integer.parseInt(Salida.substring(6,10))*365;

		estancia = NSalida - NAlta ;
		cajaEstancia.setText(estancia+" días");
		
		//Mostrar el panel secundario si hay niños menores de 14 
		if(checkNinios.isSelected()) {
			pNinios.setVisible(true);
		}else {
			pNinios.setVisible(false);
		}
		if(e.getSource()==b1) {
			if(contBoton<3) {
				contBoton=contBoton+1;
			}else {
				contBoton=1;
			}
			
			if(contBoton==1) {
				pintura2.setIcon(mismaFoto2);
			}else if (contBoton==2) {
				pintura2.setIcon(mismaFoto3);
			}else {
				pintura2.setIcon(mismaFoto4);
			}
			
		}
		
		//aCTIONlISTENER DE LOS BOTONES NEW,SAVE Y PRINT
		if(e.getSource()==b_New) {
			cajaNom.setText(null);
			cajaApe.setText(null);
			cajaDni.setText(null);
			cajaTlf.setText(null);
			cajaAlta.setText(convertido1);
			cajaSalida.setText(convertido2);
			cajaEstancia.setText("1 dias");
			listaHab.setSelectedItem("Simple");
			contador_Hab.setValue(0);
			checkNinios.setSelected(false);
			edad_Ninios.setValue(0);
			cajaExtras.setText(null);
			cajaImporte.setText(null);
			txtArea_Cliente.setText(null);
			txtArea_Hab.setText(null);
			cajaNom.requestFocus();
		}
		if(e.getSource()==b_Imprimir) {

			
			if(cajaNom.getText().length()>0 && cajaApe.getText().length()>0 && cajaDni.getText()!=null && cajaTlf.getText()!=null && (Integer) contador_Hab.getValue()!=0 ) {
				txtArea_Cliente.setText("Nombre: "+cajaNom.getText()+"\nApellidos: "+cajaApe.getText()+
						"\nDNI: "+cajaDni.getText()+"\nTelefono: "+cajaTlf.getText());
						txtArea_Hab.setText("Fecha de Entrada: "+cajaAlta.getText()+"\nFecha de Salida: "+
						cajaSalida.getText()+"\nTipo de Habitación: "+listaHab.getSelectedItem()+"\nNª de Habitaciones: "+contador_Hab.getValue()+
						"\nExtras: "+cajaExtras.getText()+"\nImporte Total: "+cajaImporte.getText());
			}else {
				JOptionPane.showMessageDialog(null, "No están todos los campos correctamente cumplimentados");
			}

		}
		
		if(e.getSource()==b_Save) {
			System.out.println(cajaNom.getText().length());
			System.out.println("aa"+cajaDni.getText()+"aa");
			System.out.println((String) cajaDni.getText()!="         ");
			
			if(cajaNom.getText().length()>0 & cajaApe.getText().length()>0 & cajaDni.getText()!=null & cajaTlf.getText()!=null & (Integer) contador_Hab.getValue()!=0 & cajaImporte.getText().length()>0) {
				JOptionPane.showMessageDialog(null, "Registro Guardado");
			}else {
				JOptionPane.showMessageDialog(null, "No están todos los campos correctamente cumplimentados");
			}

		}
		
	}

	/**
	 * Focus gained.
	 *
	 * @param e the e
	 */
	@Override
	public void focusGained(FocusEvent e) {
		
		int Edad = (Integer) edad_Ninios.getValue();
		
		if(checkNinios.isSelected()) {
			if(Edad<4) {
				cajaExtras.setText("Cuna");
			}else if (Edad<10) {
				cajaExtras.setText("Cama supletoria pequeña");
			}else {
				cajaExtras.setText("Cama supletoria simple");
			}			
		}
		
		

		
		if(cajaImporte.isFocusOwner()) {
			int P_hab=0;
			int P_extras = 0;
			if(listaHab.getSelectedItem().toString()=="Simple") {
				P_hab=50;
			}else if (listaHab.getSelectedItem().toString()=="Doble") {
				P_hab=75;
			}else if (listaHab.getSelectedItem().toString()=="Suite") {
				P_hab=125;
			}
			
			if (checkNinios.isSelected()) {
				P_extras=20;
			}	
			
			int P_total=(Integer)contador_Hab.getValue()*estancia*(P_hab+P_extras);
			
			cajaImporte.setText(P_total+" €");
		
		}
		
		
	}

	/**
	 * Focus lost.
	 *
	 * @param e the e
	 */
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
