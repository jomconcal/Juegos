package aplicacion;

import java.awt.*;

import javax.swing.*;

public class Casillero extends JFrame {

	public Casillero() {

		setLayout(new GridLayout(3, 3));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 300, 300);
		setResizable(false);

		casillero = new Casilla[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				casillero[i][j] = new Casilla();
				add(casillero[i][j]);
			}
		}
	}

	private static Casilla[][] casillero;

	public Casilla[][] getCasilla() {
		return casillero;
	}

	public static void setTurnoMaquina() {

		int i, j;
		do {
			i = (int) (Math.random() * 3);
			j = (int) (Math.random() * 3);
		} while (casillero[i][j].getPulsado());

		casillero[i][j].setJugada("O", Color.MAGENTA);
	}

	public static void setGanador() {
		if (casillero[0][0].getJugada().equals("X") && casillero[0][1].getJugada().equals("X")
				&& casillero[0][2].getJugada().equals("X")
				|| casillero[1][0].getJugada().equals("X") && casillero[1][1].getJugada().equals("X")
						&& casillero[1][2].getJugada().equals("X")
				|| casillero[2][0].getJugada().equals("X") && casillero[2][1].getJugada().equals("X")
						&& casillero[2][2].getJugada().equals("X")
				|| casillero[0][0].getJugada().equals("X") && casillero[1][0].getJugada().equals("X")
						&& casillero[2][0].getJugada().equals("X")
				|| casillero[0][1].getJugada().equals("X") && casillero[1][1].getJugada().equals("X")
						&& casillero[2][1].getJugada().equals("X")
				|| casillero[0][2].getJugada().equals("X") && casillero[1][2].getJugada().equals("X")
						&& casillero[2][2].getJugada().equals("X")
				|| casillero[0][0].getJugada().equals("X") && casillero[1][1].getJugada().equals("X")
						&& casillero[2][2].getJugada().equals("X")
				|| casillero[2][0].getJugada().equals("X") && casillero[1][1].getJugada().equals("X")
						&& casillero[0][2].getJugada().equals("X")) {
			Resultado resultado = new Resultado("Has ganado",Color.CYAN);
			resultado.setVisible(true);
			Casilla.setFin();

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					casillero[i][j].setBoton();
				}
			}
		} else if (casillero[0][0].getJugada().equals("O") && casillero[0][1].getJugada().equals("O")
				&& casillero[0][2].getJugada().equals("O")
				|| casillero[1][0].getJugada().equals("O") && casillero[1][1].getJugada().equals("O")
						&& casillero[1][2].getJugada().equals("O")
				|| casillero[2][0].getJugada().equals("O") && casillero[2][1].getJugada().equals("O")
						&& casillero[2][2].getJugada().equals("O")
				|| casillero[0][0].getJugada().equals("O") && casillero[1][0].getJugada().equals("O")
						&& casillero[2][0].getJugada().equals("O")
				|| casillero[0][1].getJugada().equals("O") && casillero[1][1].getJugada().equals("O")
						&& casillero[2][1].getJugada().equals("O")
				|| casillero[0][2].getJugada().equals("O") && casillero[1][2].getJugada().equals("O")
						&& casillero[2][2].getJugada().equals("O")
				|| casillero[0][0].getJugada().equals("O") && casillero[1][1].getJugada().equals("O")
						&& casillero[2][2].getJugada().equals("O")
				|| casillero[2][0].getJugada().equals("O") && casillero[1][1].getJugada().equals("O")
						&& casillero[0][2].getJugada().equals("O")) {
			Resultado resultado = new Resultado("Has perdido",Color.MAGENTA);
			resultado.setVisible(true);
			Casilla.setFin();

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					casillero[i][j].setBoton();
				}
			}
		}else if(Casilla.getFin()==9) {
			Resultado resultado = new Resultado("Empate",Color.YELLOW);
			resultado.setVisible(true);
		}
	}
}
