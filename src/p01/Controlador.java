package p01;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{ 
	//Tiene que implementar la(s) interfaz(/ces) necesarias para los diferentes eventos que escucha
	//En este caso solo escucha los eventos de los botones y el campo de texto -> 
	// Los manejadores de los ActionEvent se definen en la interfaz ActionListener
	
	//Necesita una referencia a la vista para poder llamar a los metodos que ofrece la vista para registrarse y modifcarla
	private Panel vista;
	private Modelo modelo;
	public Controlador(Panel vista, Modelo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		//Registramos el controlador en los eventos de la lista
    	vista.setControlador(this); 
	}
	
	
	//Implementacion de los manejadores que nos pide la interfaz
	//Tenemos varias fuentes de eventos ActionEvent y todos los eventos se procesan con este manejador
	//Si queremos realizar tareas diferentes segun la fuente del evento tendremos que tenerlo en cuenta en la implementacion
	@Override
	public void actionPerformed(ActionEvent e) {
		int valor;
		if(e.getActionCommand().equals(Panel.INCREMENTAR)){ // evento producido por el boton de incremento 	
			
			//El controlador debe tardar poco en manejar un evento -> si es una tarea rapida lo puede hacer aqui
			// si es una tarea costosa podemos lanzar una hebra trabajadora
			valor = modelo.incrementar();
			vista.escribirMensaje(Integer.toString(valor));
		}else if(e.getActionCommand().equals(Panel.DECREMENTAR)) {  // evento producido por el boton de decremento 
			valor = modelo.decrementar();
			vista.escribirMensaje(Integer.toString(valor));
		}
		else if(e.getActionCommand().equals(Panel.INIT)) { // evento producido por el campo de texto
			int valorIni = Integer.parseInt(vista.fieldValor.getText());
			modelo.setValor(valorIni);
			vista.limpiarArea();
			vista.limpiarFieldValor();
			vista.escribirMensaje("Modelo inicializado: "+modelo.getValor());
		}
		
	}

}
