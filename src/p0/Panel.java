package p0;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel {

	private JLabel celsiusLabel;
    private JButton convertButton;
    private JLabel fahrenheitLabel;
    protected JTextField tempTextField;
    public final String CONVERTIR = "convertir";
    public Panel()
    {
    	 tempTextField = new JTextField(5);
         celsiusLabel = new JLabel();
         celsiusLabel.setText("Celsius");
         
         fahrenheitLabel = new JLabel(); 
         fahrenheitLabel.setText("Fahrenheit");   

         convertButton = new JButton();
         convertButton.setText("Convertir");
   
         JPanel sup= new JPanel();//por defecto distribución horizontal.
         sup.add(celsiusLabel);
         sup.add(tempTextField);
         
         JPanel med = new JPanel();
         med.add(convertButton);
         
         JPanel inf = new JPanel();
         inf.add(fahrenheitLabel);
         
         this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
         this.add(sup);    
         this.add(med);
//         this.add(convertButton);    
//         this.add(fahrenheitLabel);
         this.add(inf);
    }
    
    //Para registrar al controlador en los eventos - suscribirnos a los eventos
    public void setControlador(ActionListener c) {
    	convertButton.addActionListener(c);
    	convertButton.setActionCommand(CONVERTIR);
    }
    //auxiliares para modificar la GUI desde el controlador / worker o para coger informacion de la GUI
    public String getText() {
    	return tempTextField.getText();
    }
    
    public void setLabel(String text) {
    	fahrenheitLabel.setText(text);
    }
}
