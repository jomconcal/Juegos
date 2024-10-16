package aplicacionBeta;

import java.awt.event.*;

import javax.swing.JFrame;

public class Juego {

	public static void main(String[] args) {

		tablero = new Tablero();
		tablero.setVisible(true);
		tablero.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tablero.getMenu().getReiniciar().setEnabled(false);

	}

	private static Tablero tablero;

	public static class Reiniciar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			tablero.iniciaTablero(tablero.getNivel());
			Casilla.setPrimeraJugada(true);
			tablero.getResultado().setLabel(Integer.toString(tablero.getCasillero().getBanderas()),Resultado.BANDERA);
	
		}

	}

	public static Tablero getTablero() {
		return Juego.tablero;
	}
	public static class Nivel implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			tablero.getMenu().getReiniciar().setEnabled(true);
			Casilla.setPrimeraJugada(true);

			if (e.getSource().equals(tablero.getMenu().getPrincipiante())) {
				tablero.setFilas(8);
				tablero.setColumnas(8);
				tablero.iniciaTablero("principiante");
			}
			if (e.getSource().equals(tablero.getMenu().getAvanzado())) {
				tablero.setFilas(16);
				tablero.setColumnas(16);
				tablero.iniciaTablero("avanzado");
			}
			if (e.getSource().equals(tablero.getMenu().getExperto())) {
				tablero.setFilas(20);
				tablero.setColumnas(30);
				tablero.iniciaTablero("experto");
			}

			tablero.getResultado().setLabel(Integer.toString(tablero.getCasillero().getBanderas()),Resultado.BANDERA);

		}

	}

	/*
	 * QUé casillas pueden tener bombas.
	 */
	public static void setBombeable() {

		int filas = tablero.getFilas();
		int columnas = tablero.getColumnas();
		int filaInicial = 0, columnaInicial = 0;
		Casilla[][] casilla = tablero.getCasillero().getCasilla();
		/*
		 * Encuentra la casilla inicial
		 */
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (casilla[i][j].isCasillaPrimera()) {
					filaInicial = i;
					columnaInicial = j;
					break;
				}

			}
		}

		casilla[filaInicial][columnaInicial].setImBombeable();
		if (filaInicial == 0 && columnaInicial == 0) {
			casilla[filaInicial][columnaInicial + 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial].setImBombeable();
			casilla[filaInicial + 1][columnaInicial + 1].setImBombeable();
		} else if (filaInicial == 0 && columnaInicial == columnas - 1) {
			casilla[filaInicial][columnaInicial - 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial].setImBombeable();
		} else if (filaInicial == 0) {
			casilla[filaInicial][columnaInicial - 1].setImBombeable();
			casilla[filaInicial][columnaInicial + 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial].setImBombeable();
			casilla[filaInicial + 1][columnaInicial + 1].setImBombeable();
		} else if (filaInicial == filas - 1 && columnaInicial == 0) {
			casilla[filaInicial - 1][columnaInicial].setImBombeable();
			casilla[filaInicial - 1][columnaInicial + 1].setImBombeable();
			casilla[filaInicial][columnaInicial + 1].setImBombeable();
		} else if (filaInicial == filas - 1 && columnaInicial == columnas - 1) {
			casilla[filaInicial - 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial - 1][columnaInicial].setImBombeable();
			casilla[filaInicial][columnaInicial - 1].setImBombeable();
		} else if (filaInicial == filas - 1) {
			casilla[filaInicial - 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial - 1][columnaInicial].setImBombeable();
			casilla[filaInicial - 1][columnaInicial + 1].setImBombeable();
			casilla[filaInicial][columnaInicial - 1].setImBombeable();
			casilla[filaInicial][columnaInicial + 1].setImBombeable();
		} else if (columnaInicial == 0) {
			casilla[filaInicial - 1][columnaInicial].setImBombeable();
			casilla[filaInicial - 1][columnaInicial + 1].setImBombeable();
			casilla[filaInicial][columnaInicial + 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial].setImBombeable();
			casilla[filaInicial + 1][columnaInicial + 1].setImBombeable();
		} else if (columnaInicial == columnas - 1) {
			casilla[filaInicial - 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial - 1][columnaInicial].setImBombeable();
			casilla[filaInicial][columnaInicial - 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial].setImBombeable();
		} else {
			casilla[filaInicial - 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial - 1][columnaInicial].setImBombeable();
			casilla[filaInicial - 1][columnaInicial + 1].setImBombeable();
			casilla[filaInicial][columnaInicial - 1].setImBombeable();
			casilla[filaInicial][columnaInicial + 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial - 1].setImBombeable();
			casilla[filaInicial + 1][columnaInicial].setImBombeable();
			casilla[filaInicial + 1][columnaInicial + 1].setImBombeable();
		}
	}

	/*
	 * Colocar las bombas en las casillas imbombeables.
	 */
	public static void setBombas() {

		int bombas = tablero.getCasillero().getBombas();
		int filas = tablero.getFilas();
		int columnas = tablero.getColumnas();
		Casilla[][] casilla = tablero.getCasillero().getCasilla();

		while (bombas > 0) {
			int i = (int) (Math.random() * filas);
			int j = (int) (Math.random() * columnas);
			if (casilla[i][j].isBombeable() && !casilla[i][j].isBomba()) {
				casilla[i][j].setBomba(true);
				bombas--;
			}
		}

	}

	/*
	 * Asignar un número a las casillas sin bombas.
	 */
	public static void setNum() {
		int filas = tablero.getFilas();
		int columnas = tablero.getColumnas();
		Casilla[][] casilla = tablero.getCasillero().getCasilla();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (casilla[i][j].isBomba()) {
					casilla[i][j].setNum(9);
					if (i == 0 && j == 0) {
						casilla[i][j + 1].increaseNum();
						casilla[i + 1][j].increaseNum();
						casilla[i + 1][j + 1].increaseNum();
					} else if (i == 0 && j == columnas - 1) {
						casilla[i][j - 1].increaseNum();
						casilla[i + 1][j - 1].increaseNum();
						casilla[i + 1][j].increaseNum();
					} else if (i == 0) {
						casilla[i][j - 1].increaseNum();
						casilla[i][j + 1].increaseNum();
						casilla[i + 1][j - 1].increaseNum();
						casilla[i + 1][j].increaseNum();
						casilla[i + 1][j + 1].increaseNum();
					} else if (i == filas - 1 && j == 0) {
						casilla[i - 1][j].increaseNum();
						casilla[i - 1][j + 1].increaseNum();
						casilla[i][j + 1].increaseNum();
					} else if (i == filas - 1 && j == columnas - 1) {
						casilla[i - 1][j - 1].increaseNum();
						casilla[i - 1][j].increaseNum();
						casilla[i][j - 1].increaseNum();
					} else if (i == filas - 1) {
						casilla[i - 1][j - 1].increaseNum();
						casilla[i - 1][j].increaseNum();
						casilla[i - 1][j + 1].increaseNum();
						casilla[i][j - 1].increaseNum();
						casilla[i][j + 1].increaseNum();
					} else if (j == 0) {
						casilla[i - 1][j].increaseNum();
						casilla[i - 1][j + 1].increaseNum();
						casilla[i][j + 1].increaseNum();
						casilla[i + 1][j].increaseNum();
						casilla[i + 1][j + 1].increaseNum();
					} else if (j == columnas - 1) {
						casilla[i - 1][j - 1].increaseNum();
						casilla[i - 1][j].increaseNum();
						casilla[i][j - 1].increaseNum();
						casilla[i + 1][j - 1].increaseNum();
						casilla[i + 1][j].increaseNum();
					} else {
						casilla[i - 1][j - 1].increaseNum();
						casilla[i - 1][j].increaseNum();
						casilla[i - 1][j + 1].increaseNum();
						casilla[i][j - 1].increaseNum();
						casilla[i][j + 1].increaseNum();
						casilla[i + 1][j - 1].increaseNum();
						casilla[i + 1][j].increaseNum();
						casilla[i + 1][j + 1].increaseNum();
					}
				}
			}
		}
	}

	/*
	 * Eliminar los botones y los que rodeen a los ceros. Pueden explotar bombas.
	 */
	public static void removeBotones(int i, int j) {

		int filas = tablero.getFilas();
		int columnas = tablero.getColumnas();
		Casilla[][] casilla = tablero.getCasillero().getCasilla();

		if (casilla[i][j].getNum() == 0 && !casilla[i][j].isUsada()) {
			casilla[i][j].removeBoton();
			tablero.getCasillero().sumarCasillasPulsadas();

			if (i == 0 && j == 0) {
				removeBotones(i, j + 1);
				removeBotones(i + 1, j);
				removeBotones(i + 1, j + 1);
			} else if (i == 0 && j == columnas - 1) {
				removeBotones(i, j - 1);
				removeBotones(i + 1, j - 1);
				removeBotones(i + 1, j);
			} else if (i == 0) {
				removeBotones(i, j - 1);
				removeBotones(i, j + 1);
				removeBotones(i + 1, j - 1);
				removeBotones(i + 1, j);
				removeBotones(i + 1, j + 1);
			} else if (i == filas - 1 && j == 0) {
				removeBotones(i - 1, j);
				removeBotones(i - 1, j + 1);
				removeBotones(i, j + 1);
			} else if (i == filas - 1 && j == columnas - 1) {
				removeBotones(i - 1, j - 1);
				removeBotones(i - 1, j);
				removeBotones(i, j - 1);
			} else if (i == filas - 1) {
				removeBotones(i - 1, j - 1);
				removeBotones(i - 1, j);
				removeBotones(i - 1, j + 1);
				removeBotones(i, j - 1);
				removeBotones(i, j + 1);
			} else if (j == 0) {
				removeBotones(i - 1, j);
				removeBotones(i - 1, j + 1);
				removeBotones(i, j + 1);
				removeBotones(i + 1, j);
				removeBotones(i + 1, j + 1);
			} else if (j == columnas - 1) {
				removeBotones(i - 1, j - 1);
				removeBotones(i - 1, j);
				removeBotones(i, j - 1);
				removeBotones(i + 1, j - 1);
				removeBotones(i + 1, j);
			} else {
				removeBotones(i - 1, j - 1);
				removeBotones(i - 1, j);
				removeBotones(i - 1, j + 1);
				removeBotones(i, j - 1);
				removeBotones(i, j + 1);
				removeBotones(i + 1, j - 1);
				removeBotones(i + 1, j);
				removeBotones(i + 1, j + 1);
			}

		} else if (casilla[i][j].getNum() != 0 && !casilla[i][j].isUsada()) {
			casilla[i][j].removeBoton();

			if (casilla[i][j].isBomba()) {
				terminarJuego(false);
			} else {
				tablero.getCasillero().sumarCasillasPulsadas();
			}

			if (tablero.getCasillero().getCasillasPulsadas() == tablero.getCasillero().getVictoria()) {
				terminarJuego(true);
			}
		}
	}

	/*
	 * Mostrar todas las casillas por haber pulsado bomba o por haber ganado.
	 */
	private static void terminarJuego(boolean victoria) {
		int filas = tablero.getFilas();
		int columnas = tablero.getColumnas();
		Casilla[][] casilla = tablero.getCasillero().getCasilla();

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (!casilla[i][j].isUsada()) {

					casilla[i][j].removeBoton();
				}
				if (victoria) {
					casilla[i][j].changeFondo();
				}
			}
		}

		if (victoria) {
			tablero.getResultado().setLabel("Has ganado",Resultado.SONRISA);		
		} else {
			tablero.getResultado().setLabel("Has perdido",Resultado.BOMBA);
		}
	}
}
