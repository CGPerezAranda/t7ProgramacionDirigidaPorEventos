package p01;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel extends JPanel {
	//Esta clase es la vista, incluye todos los componentes graficos de la GUI. En GUIs mas complejas puede estar distribuida en varias clases

	private JButton botonInc;
	private JButton botonDec;
	protected JTextField fieldValor; 
    protected JTextArea area;
    protected JScrollPane scroll;
    
   
    
    // Definimos una constante por cada accion de la vista de la que el controlador tiene que estar pendiente
    public static final String INCREMENTAR = "INCREMENTAR";
    public static final String DECREMENTAR = "DECREMENTAR";
    //
    public static final String INIT = "INIT";
    //Constructor
    public Panel() {
    	//1 . Inicializamos los componetes graficos
        botonInc = new JButton(); 
        botonDec = new JButton();
       
        fieldValor = new JTextField(10); //10 columnas (ancho)
        
        area = new JTextArea(20,40); //20 filas y 40 columnas (largo, ancho)
        scroll = new JScrollPane(area); //dentro del scroll esta el area de texto
        
        // Configuramos algunos aspectos, por ejemplo la etiqueta que se muestra en cada boton
        botonInc.setText(INCREMENTAR);         
        botonDec.setText(DECREMENTAR);     
        
        //2. El layout define como se distribuyen los elementos. 
        //   Podemos usar otros paneles para llevar a cabo distribuciones mas compeljas
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));      // estamos diciendo se se organicen en vertical de arriba a abajo   
       
        //3. Organizamos los elementos usando algunos paneles auxiliares
        
        JPanel sup= new JPanel(); //Panel auxiliar, lo pondremos en la parte superior de this. Por defecto el layout es horizontal
        JPanel mid = new JPanel(); //Panel auxiliar, lo pondremos en la parte media
        
        //Elementos en el panel superior (se distribuyen horizontalmente)
        sup.add(botonInc); 
        sup.add(botonDec);
       
        //Elementos en el panel intermedio 
        mid.add(new JLabel("Inicializar: "));
        mid.add(fieldValor);
        
      //a�adimos los paneles auxiliares a this, el orden de llamada a add indica como se ordenaran 
        this.add(sup); 
        this.add(mid);
        this.add(scroll);   //el JScrollPane estara en la zona inferior
    }
    
    
    //Metodo que usamos para registrar al controlador en los eventos de la vista 
    //En este caso el controlador  tiene que registrarse en los eventos de los dos botones y el campo de texto
    public void setControlador (ActionListener ctr) {
    	botonInc.addActionListener(ctr); 
    	botonInc.setActionCommand(INCREMENTAR); //comando que identifica que un evento se ha producido por el boton de incremento
    	
    	botonDec.addActionListener(ctr);
    	botonDec.setActionCommand(DECREMENTAR);//comando que identifica que un evento se ha producido por el boton de decremento
    	
    	fieldValor.addActionListener(ctr); 
    	fieldValor.setActionCommand(INIT);//comando que identifica que un evento se ha producido por el campo de texto
    }

    //Los siguientes metodos los usara el controlador para actualizar la vista
    // En este caso hay que cambiar el contenido del area de texto con el valor que aparece 
    public void escribirMensaje(String msg) {
			area.append(msg+"\n");
	}
    //
    public void limpiarArea() {
    	area.setText("");
    }
    //
    public void limpiarFieldValor() {
    	fieldValor.setText("");
    }
    

}
