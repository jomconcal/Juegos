package aplicacionBeta;

import javax.swing.*;


public class Resultado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Resultado() {

		label = new JLabel();
		this.add(label);

	}

	private JLabel label;
	public static final int BANDERA = 0;
	public static final int BOMBA = 1;
	public static final int SONRISA = 2;

	public void setLabel(String label, int num) {
		this.label.setText(label);
		if (num == 0) {
			this.label.setIcon(new ImageIcon(Juego.class.getResource("/imagenes/bandera.jpg")));
			
		}
		if (num == 1) {
			this.label.setIcon(new ImageIcon(Juego.class.getResource("/imagenes/bomba.jpg")));
		}
		if (num == 2) {
			this.label.setIcon(new ImageIcon(Juego.class.getResource("/imagenes/sonrisa.png")));
		}
	}
}
