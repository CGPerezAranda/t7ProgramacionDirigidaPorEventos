package p4.sinc_hebras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controlador implements ActionListener, PropertyChangeListener  {
	
	Panel panel;
	Worker w;
	Worker_sync ws;
	private int pausedValue = 10;
	public Controlador(Panel panel)
	{
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(panel.START)){											
			panel.area.setText("");//Limpiamos el panel
			w = new Worker(Integer.parseInt(panel.tiempoField.getText()), panel);			
			/*Este objeto controlador (this) también actuará como 
			 * listener del evento de cambio de propiedad progreso */
			w.setControlador(this);
			//creamos también una hebra  trabajadora que se sincronizará con w
			ws = new Worker_sync(Integer.parseInt(panel.tiempoField.getText()), panel, w);			
			w.execute();
			ws.execute();
			panel.boton.setText("Cancelar");
			panel.boton.setActionCommand(panel.CANCEL);
			
		}else if(e.getActionCommand().equals(panel.CANCEL) && w!=null) {
				w.cancel(true);
				ws.cancel(true);
				panel.boton.setText("Cuenta atras!");
				panel.boton.setActionCommand(panel.START);
				w.cancel(true);
				ws.cancel(true);
		}
		else if(e.getActionCommand().equals("PAUSA")){
			pausedValue = panel.getLastNumber();
			w.cancel(true);
			ws.cancel(true);
			
			panel.boton.setText("Resume");
			panel.boton.setActionCommand("RESUME");
			
		}else if(e.getActionCommand().equals("RESUME")){
			w = new Worker(pausedValue, panel);
			ws = new Worker_sync(pausedValue, panel, w);
			w.execute();
			ws.execute();
			panel.boton.setText("Cuenta atras!");
			panel.boton.setActionCommand(panel.START);
		}
	}
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("progress")){
			panel.bar.setValue((Integer)evt.getNewValue());
		}
		
	}
}
