package graficos.casillas;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import graficos.Colores;

/**
 * Casilla para que el jugador coloque el color que puede ser la
 * respuesta.
 * 
 * @author jomco
 * @version 2
 * @since 25/05/2024
 */
public class CasillaJugada extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Etiqueta para mostrar el color
	 */
	private JLabel color;
	
	/**
	 * N�mero que identifica la posici�n del elemento del numerador que representa
	 * el color.
	 */
	private int numColor;
	
	/**
	 * Variable para determinar si el jugador ha colocado el color correcto en esta
	 * casilla
	 */
	private boolean acertada;

	/**
	 * Inicia la casilla colocando las etiquetas de los colores dependiendo de si es
	 * jugable o no,
	 * 
	 * @param jugable Para determinar si colocar el fondo con un color o no.
	 */
	public CasillaJugada(boolean jugable) {
		// Estructura visual
		setLayout(new BorderLayout());
		this.acertada = false;
		this.color = new JLabel("", JLabel.CENTER);
		setBackground(new Color(111, 65, 20));
		setBorder(new BevelBorder(1));
		this.add(color, BorderLayout.CENTER);

		// Colocar color de fondo o no. Se inicia a 0 (rojo).
		if (jugable) {
			this.numColor = 0;
			setColor(numColor);
		}
	}

	/**
	 * N�mero que identifica la posici�n del elemento del enumerado que representa
	 * el color.
	 * 
	 * @return numColor
	 */
	public int getNumColor() {
		return this.numColor;
	}

	/**
	 * Modifica el n�mero que identifica la posici�n del elemento del enumerado que
	 * representa el color. S�lo puede ser de 0 a 5, ya que el 6 (negro) no se puede
	 * utilizar aqu�. Esta funci�n no se utiliza libremente, s�lo ser� llamada por
	 * acciones de teclado.
	 * 
	 * @param num entero de -1 a 6
	 */
	public void setColor(int num) {
		// N�mero que recibir� las modificaciones.
		int numColor = num;

		// Si el n�mero es menor a 0 (-1) numColor valdr� 5 (azul);
		if (num < 0)
			numColor = Colores.values().length - 2;
		// Si el n�mero es mayor o igual a 6 (negro) numColor valdr� 0 (rojo);
		if (num >= Colores.values().length - 1)
			numColor = 0;

		// La variable que recoge el n�mero de color de esta casilla se actualiza.
		this.numColor = numColor;
		// Se modifica el color que se muestra en la etiqueta color.
		this.color.setIcon(Colores.values()[numColor].getColor());
		updateUI();
	}

	/**
	 * Devuelve la situaci�n de la casilla actual. Si la respuesta del jugador es
	 * correcta o no.
	 * 
	 * @return acertada
	 */
	public boolean isAcertada() {
		return acertada;
	}

	/**
	 * Informa sobre si el jugador ha acertado modifica la variable booleana que lo
	 * especifica.
	 * 
	 * @param acertada
	 */
	public void setAcertada(boolean acertada) {
		this.acertada = acertada;
	}

}
