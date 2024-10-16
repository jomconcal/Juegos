package aplicacionBeta;

import java.awt.GridLayout;

import javax.swing.*;

public class Casillero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Casillero(int filas, int columnas) {
		this.setLayout(new GridLayout(filas, columnas));
		this.filas = filas;
		this.columnas = columnas;
		this.casillasPulsadas=0;
		crearCasillero();
//
	}

//
	private Casilla casilla[][];
	private int filas;
	private int columnas;
	private int bombas;
	private int banderas;
	private int casillasPulsadas=0;
	private int victoria;

	private void crearCasillero() {

		casilla = new Casilla[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilla[i][j] = new Casilla();
				casilla[i][j].setFila(i);
				casilla[i][j].setColumna(j);
				this.add(casilla[i][j]);
			}
		}

	}


	public int getCasillasPulsadas() {
		return this.casillasPulsadas;
	}

	public void sumarCasillasPulsadas() {
		this.casillasPulsadas++;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setBombas(int bombas) {
		this.bombas = bombas;
		this.banderas=bombas;
	}

	public int getBanderas() {
		return this.banderas;
	}
	
	public void setBanderas(int num) {
		this.banderas+=num;
	}
	public int getBombas() {
		return bombas;
	}

	public Casilla[][] getCasilla() {
		return casilla;
	}

	public int getVictoria() {
		return victoria;
	}

	public void setVictoria(int victoria) {
		this.victoria = victoria;
	}

}
