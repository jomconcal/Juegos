package aplicacion;

import java.awt.GridLayout;

import javax.swing.*;

public class Casillero extends JPanel {

	public Casillero(int filas, int columnas) {

		this.setLayout(new GridLayout(filas, columnas));
		Casillero.filas = filas;
		Casillero.columnas = columnas;
		crearCasillero();

	}

	private static Casilla casilla[][];
	private static int filas;
	private static int columnas;
	private static int casillas;

	public static void distribuirNumeros(int bombas) {
		int contador = bombas;
		casillas = casillasTotales() - bombas;

		while (contador > 0) {
			int i = (int) (Math.random() * filas);
			int j = (int) (Math.random() * columnas);
			if (casilla[i][j].isBombeable() && !casilla[i][j].isBomba()) {
				casilla[i][j].setBomba();
				contador--;
			}
		}

		Casillero.setNum();

	}

	private void crearCasillero() {

		casilla = new Casilla[filas][columnas];

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilla[i][j] = new Casilla();

			}
		}

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilla[i][j].setFila(i);
				casilla[i][j].setColumna(j);
				this.add(casilla[i][j]);
			}
		}

	}

	public static int getCasillas() {
		return Casillero.casillas;
	}

	public static void restarCasillas() {
		Casillero.casillas--;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public static Casilla[][] getCasilla() {
		return casilla;
	}

	public static int casillasTotales() {
		int num;
		num = columnas * filas;
		return num;
	}

	public static void bloquearBotones() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilla[i][j].getBoton().setEnabled(false);
			}
		}

	}

	public static void setImbombeable() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (casilla[i][j].isCasillaPrimera()) {
					if (i == 0 && j == 0) {
						casilla[i][j + 1].setImBombeable();
						casilla[i + 1][j].setImBombeable();
						casilla[i + 1][j + 1].setImBombeable();
					} else if (i == 0 && j == columnas - 1) {
						casilla[i][j - 1].setImBombeable();
						casilla[i + 1][j - 1].setImBombeable();
						casilla[i + 1][j].setImBombeable();
					} else if (i == 0) {
						casilla[i][j - 1].setImBombeable();
						casilla[i][j + 1].setImBombeable();
						casilla[i + 1][j - 1].setImBombeable();
						casilla[i + 1][j].setImBombeable();
						casilla[i + 1][j + 1].setImBombeable();
					} else if (i == filas - 1 && j == 0) {
						casilla[i - 1][j].setImBombeable();
						casilla[i - 1][j + 1].setImBombeable();
						casilla[i][j + 1].setImBombeable();
					} else if (i == filas - 1 && j == columnas - 1) {
						casilla[i - 1][j - 1].setImBombeable();
						casilla[i - 1][j].setImBombeable();
						casilla[i][j - 1].setImBombeable();
					} else if (i == filas - 1) {
						casilla[i - 1][j - 1].setImBombeable();
						casilla[i - 1][j].setImBombeable();
						casilla[i - 1][j + 1].setImBombeable();
						casilla[i][j - 1].setImBombeable();
						casilla[i][j + 1].setImBombeable();
					} else if (j == 0) {
						casilla[i - 1][j].setImBombeable();
						casilla[i - 1][j + 1].setImBombeable();
						casilla[i][j + 1].setImBombeable();
						casilla[i + 1][j].setImBombeable();
						casilla[i + 1][j + 1].setImBombeable();
					} else if (j == columnas - 1) {
						casilla[i - 1][j - 1].setImBombeable();
						casilla[i - 1][j].setImBombeable();
						casilla[i][j - 1].setImBombeable();
						casilla[i + 1][j - 1].setImBombeable();
						casilla[i + 1][j].setImBombeable();
					} else {
						casilla[i - 1][j - 1].setImBombeable();
						casilla[i - 1][j].setImBombeable();
						casilla[i - 1][j + 1].setImBombeable();
						casilla[i][j - 1].setImBombeable();
						casilla[i][j + 1].setImBombeable();
						casilla[i + 1][j - 1].setImBombeable();
						casilla[i + 1][j].setImBombeable();
						casilla[i + 1][j + 1].setImBombeable();
					}
				}
			}
		}
	}

	private static void setNum() {
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

	public static void removeBotones(int i, int j) {

		int num1 = 9;
		int num2 = 9;
		int num3 = 9;
		int num4 = 9;
		int num5 = 9;
		int num6 = 9;
		int num7 = 9;
		int num8 = 9;

		casilla[i][j].removeBoton();
		casilla[i][j].activarCero();
		if (i == 0 && j == 0) {
			num5 = casilla[i][j + 1].removeBoton();
			num7 = casilla[i + 1][j].removeBoton();
			num8 = casilla[i + 1][j + 1].removeBoton();
		} else if (i == 0 && j == columnas - 1) {
			num4 = casilla[i][j - 1].removeBoton();
			num6 = casilla[i + 1][j - 1].removeBoton();
			num7 = casilla[i + 1][j].removeBoton();
		} else if (i == 0) {
			num4 = casilla[i][j - 1].removeBoton();
			num5 = casilla[i][j + 1].removeBoton();
			num6 = casilla[i + 1][j - 1].removeBoton();
			num7 = casilla[i + 1][j].removeBoton();
			num8 = casilla[i + 1][j + 1].removeBoton();
		} else if (i == filas - 1 && j == 0) {
			num2 = casilla[i - 1][j].removeBoton();
			num3 = casilla[i - 1][j + 1].removeBoton();
			num5 = casilla[i][j + 1].removeBoton();
		} else if (i == filas - 1 && j == columnas - 1) {
			num1 = casilla[i - 1][j - 1].removeBoton();
			num2 = casilla[i - 1][j].removeBoton();
			num4 = casilla[i][j - 1].removeBoton();
		} else if (i == filas - 1) {
			num1 = casilla[i - 1][j - 1].removeBoton();
			num2 = casilla[i - 1][j].removeBoton();
			num3 = casilla[i - 1][j + 1].removeBoton();
			num4 = casilla[i][j - 1].removeBoton();
			num5 = casilla[i][j + 1].removeBoton();
		} else if (j == 0) {
			num2 = casilla[i - 1][j].removeBoton();
			num3 = casilla[i - 1][j + 1].removeBoton();
			num5 = casilla[i][j + 1].removeBoton();
			num7 = casilla[i + 1][j].removeBoton();
			num8 = casilla[i + 1][j + 1].removeBoton();
		} else if (j == columnas - 1) {
			num1 = casilla[i - 1][j - 1].removeBoton();
			num2 = casilla[i - 1][j].removeBoton();
			num4 = casilla[i][j - 1].removeBoton();
			num6 = casilla[i + 1][j - 1].removeBoton();
			num7 = casilla[i + 1][j].removeBoton();
		} else {
			num1 = casilla[i - 1][j - 1].removeBoton();
			num2 = casilla[i - 1][j].removeBoton();
			num3 = casilla[i - 1][j + 1].removeBoton();
			num4 = casilla[i][j - 1].removeBoton();
			num5 = casilla[i][j + 1].removeBoton();
			num6 = casilla[i + 1][j - 1].removeBoton();
			num7 = casilla[i + 1][j].removeBoton();
			num8 = casilla[i + 1][j + 1].removeBoton();
		}

		if (num1 == 0 && !casilla[i - 1][j - 1].ceroActivado()) {
			removeBotones(i - 1, j - 1);
		}
		if (num2 == 0 && !casilla[i - 1][j].ceroActivado()) {
			removeBotones(i - 1, j);
		}
		if (num3 == 0 && !casilla[i - 1][j + 1].ceroActivado()) {
			removeBotones(i - 1, j + 1);
		}
		if (num4 == 0 && !casilla[1][j - 1].ceroActivado()) {
			removeBotones(i, j - 1);
		}
		if (num5 == 0 && !casilla[i][j + 1].ceroActivado()) {
			removeBotones(i, j + 1);
		}
		if (num6 == 0 && !casilla[i + 1][j - 1].ceroActivado()) {
			removeBotones(i + 1, j - 1);
		}
		if (num7 == 0 && !casilla[i + 1][j].ceroActivado()) {
			removeBotones(i + 1, j);
		}
		if (num8 == 0 && !casilla[i + 1][j + 1].ceroActivado()) {
			removeBotones(i + 1, j + 1);
		}

	}

	public static void explosion() {

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casilla[i][j].removeBoton();
			}
		}
		Final resultado = new Final("Has perdido");
		resultado.setVisible(true);
	}
}
