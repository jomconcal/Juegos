package aplicacionBeta;

import java.awt.*;

import javax.swing.*;

public class Tablero extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Tablero() {
		setLayout(new BorderLayout());
		this.menu = new Menu();
		this.resultado= new Resultado();
		this.add(resultado, BorderLayout.SOUTH);
		this.add(menu, BorderLayout.NORTH);
		this.setBounds(300, 10, 200, 300);
		iniciado = false;
	}

	private int largo, ancho;
	private int filas, columnas;
	private Casillero casillero;
	private Menu menu;
	private Resultado resultado;
	private boolean iniciado;
	private String nivel;

	/*
	 * Determinar tamaño, cantidad de bombas y casillas sin bombas (victoria) en función del nivel.
	 */
	public void iniciaTablero(String nivel) {
		if (iniciado) {
			this.remove(casillero);
		}
		iniciado = true;
		this.nivel = nivel;
		if (nivel == "principiante") {
			casillero = new Casillero(filas, columnas);
			casillero.setBombas(15);
		} else if (nivel == "avanzado") {
			casillero = new Casillero(filas, columnas);
			casillero.setBombas(50);
		} else {
			casillero = new Casillero(filas, columnas);
			casillero.setBombas(100);
		}
		casillero.setVictoria(filas*columnas-casillero.getBombas());
		ancho = casillero.getColumnas() * 35;
		largo = casillero.getFilas() * 35 + 90;
		this.add(casillero, BorderLayout.CENTER);
		this.setBounds(300, 10, ancho, largo);
		this.setResizable(false);
		casillero.updateUI();

	}

	public Casillero getCasillero() {
		return casillero;
		
	}

	public Menu getMenu() {
		return menu;
	}

	public Resultado getResultado() {
		return this.resultado;
	}
	
	public boolean isIniciado() {
		return iniciado;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setFilas(int filas) {
		this.filas=filas;
	}

	public void setColumnas(int columnas) {
		this.columnas=columnas;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

}
