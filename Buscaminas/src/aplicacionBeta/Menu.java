package aplicacionBeta;

import javax.swing.*;

public class Menu extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu() {
		
		menuBar= new JMenuBar();
		nivel = new JMenu("nivel");
		reiniciar=new JMenuItem("reiniciar");
		principiante= new JMenuItem("principiante");
		avanzado= new JMenuItem("avanzado");
		experto= new JMenuItem("experto");
		
		reiniciar.addActionListener(new Juego.Reiniciar());
		principiante.addActionListener(new Juego.Nivel());
		avanzado.addActionListener(new Juego.Nivel());
		experto.addActionListener(new Juego.Nivel());
		
		nivel.add(principiante);
		nivel.add(avanzado);
		nivel.add(experto);
		menuBar.add(nivel);
		menuBar.add(reiniciar);
		add(menuBar);
	}
	
	private JMenu nivel;
	private JMenuItem reiniciar, principiante, avanzado, experto;
	private JMenuBar menuBar;
	
	public JMenuItem getPrincipiante() {
		return principiante;
	}
	public JMenuItem getAvanzado() {
		return avanzado;
	}
	public JMenuItem getExperto() {
		return experto;
	}
	public JMenuItem getReiniciar() {
		return reiniciar;
	}
	
}
