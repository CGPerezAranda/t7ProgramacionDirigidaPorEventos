package guiSimple;

import java.security.PublicKey;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private JLabel etq = new JLabel("Es verdad?");
	private JButton si = new JButton("si");
	private JButton no = new JButton("no");
	
	public Panel () {
		add(etq);
		add(si);
		add(no);
	}

}
