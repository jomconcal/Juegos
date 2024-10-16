package aplicacion;
import javax.swing.*;

public class Menu extends JPanel{
	
	public Menu() {
		
		menuBar= new JMenuBar();
		nivel = new JMenu("nivel");
		reiniciar=new JMenuItem("reiniciar");
		principiante= new JMenuItem("principiante");
		avanzado= new JMenuItem("avanzado");
		experto= new JMenuItem("experto");
		
		reiniciar.addActionListener(null);
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
}
