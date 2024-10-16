package aplicacion;

import javax.swing.*;

public class Final extends JFrame{

	public Final(String resultado) {
		
		this.setBounds(300,200,200,100);
		panel=new JPanel();
		label = new JLabel(resultado);
		panel.add(label);
		this.add(panel);
		
		Casillero.bloquearBotones();
		
	}
	
	private JPanel panel;
	private JLabel label;
}
