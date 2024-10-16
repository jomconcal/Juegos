package aplicacion;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Casilla extends JPanel {

	public Casilla() {

		setLayout(new BorderLayout());
		Casilla.fin = 0;
		this.boton = new JButton();
		boton.addActionListener(new pulsaBoton());
		add(boton, BorderLayout.CENTER);
		pulsado = false;
		this.jugada = " ";
	}

	private JButton boton;
	private String jugada;
	private static int fin;
	private boolean pulsado;

	public boolean getPulsado() {
		return this.pulsado;
	}

	public void setJugada(String jugada, Color color) {
		this.jugada = jugada;
		this.boton.setText(jugada);
		this.boton.setEnabled(false);
		this.boton.setBackground(color);
		this.pulsado = true;
		fin += 1;
	}

	public String getJugada() {
		return this.jugada;
	}

	public static void setFin() {
		fin = 9;
	}

	public static int getFin() {
		return fin;
	}

	public void setBoton() {
		this.boton.setEnabled(false);
	}

	private class pulsaBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Casilla.this.setJugada("X", Color.CYAN);
			Casillero.setGanador();

			if (Casilla.fin != 9) {
				Casillero.setTurnoMaquina();
				Casillero.setGanador();
			}

		}
	}
}
