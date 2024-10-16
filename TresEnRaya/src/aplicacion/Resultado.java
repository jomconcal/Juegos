package aplicacion;

import java.awt.*;

import javax.swing.*;

public class Resultado extends JFrame{

	public Resultado(String resultado, Color color) {
		
		setBounds(250, 300, 200, 150);
		this.resultado= new JLabel(resultado);
		this.panel= new JPanel();
		this.panel.add(this.resultado);
		add(this.panel);
		this.panel.setBackground(color);
		setResizable(false);
	}
	private JPanel panel;
	private JLabel resultado;
	
}
