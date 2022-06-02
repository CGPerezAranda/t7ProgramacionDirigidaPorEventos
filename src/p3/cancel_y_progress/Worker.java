package p3.cancel_y_progress;

import java.beans.PropertyChangeListener;
import java.util.List;


import javax.swing.SwingWorker;

public class Worker extends SwingWorker<Void, Integer> {

	private int numero;
	private Panel panel;
	
	public Worker(int numero, Panel panel)
	{
		this.numero = numero;
		this.panel = panel;
	}
	
	@Override
	protected Void doInBackground() throws Exception {		
		int i=numero;
		while(!isCancelled() && i>0)
		{
			publish(i);
			this.setProgress((numero-i)*100/numero);
			Thread.sleep(100);
			i--;
		}
		this.setProgress(100);
		return null;
	}

	protected void process(List<Integer> lista)
	{	
		panel.escribirLista(lista);
	}
	
	protected void setControlador(PropertyChangeListener controlador)
	{
		this.addPropertyChangeListener(controlador);
	}	
}
