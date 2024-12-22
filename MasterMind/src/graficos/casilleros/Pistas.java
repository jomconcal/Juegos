package graficos.casilleros;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

import graficos.casillas.CasillaPista;

/**
 * Casillero que recibe las pistas que verá el jugador.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class Pistas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Array con las diferentes pistas que recibirá el jugador.
	 */
	private CasillaPista[] pistas;

	/**
	 * Inicia el casillero con las pistas en blanco. Se colocan en una fila
	 * vertical.
	 * 
	 * @param filas dimensión del casillero.
	 */
	public Pistas(int filas) {
		this.setLayout(new GridLayout(filas, 1));
		this.pistas = new CasillaPista[filas];
		rellenarPistas(filas);
		setPreferredSize(new Dimension(60, filas * 60));
	}

	/**
	 * Rellena las pistas sin informaciÃ³n.
	 * 
	 * @param filas cantidad de filas
	 */
	private void rellenarPistas(int filas) {
		for (int i = 0; i < filas; i++) {
			CasillaPista cp = new CasillaPista();
			pistas[i] = cp;
			this.add(cp);
		}
	}

	public CasillaPista getPista(int fila) {
		return pistas[fila];
	}
	
	

}
