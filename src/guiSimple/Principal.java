package guiSimple;

import javax.swing.JFrame;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana = new JFrame ("GUI simple");
		Panel panel = new Panel();
		ventana.setContentPane(panel);
		ventana.setVisible(true);
		ventana.pack();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
