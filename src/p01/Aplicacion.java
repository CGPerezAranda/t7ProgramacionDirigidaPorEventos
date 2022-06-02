package p01;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Aplicacion {

	public static void main(String[] args) {
		//System.out.println("main() - isEventDispatchThread? "+ SwingUtilities.isEventDispatchThread());
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				//System.out.println("run() - isEventDispatchThread? "+ SwingUtilities.isEventDispatchThread());
				//Creamos la vista
            	Panel vista = new Panel();
            	//Creamos el modelo
            	Modelo modelo = new Modelo();
            	
            	// Creamos el controlador - le pasamos la vista que tiene que "escuchar"
            	// y el modelo que ofrece los metodos que deben invocarse para realizar las tareas asociadas a los eventos
            	Controlador controlador = new Controlador(vista, modelo);
            	           	
            	
            	//Creamos la ventana y metemos en la ventana la vista
            	JFrame frame = new JFrame();
            	frame.setTitle("Incrementador!");
            	
            	frame.setContentPane(vista);
                frame.pack();
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});

	}

}
