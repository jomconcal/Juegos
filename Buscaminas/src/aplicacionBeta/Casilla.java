package aplicacionBeta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class Casilla extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Casilla() {
		this.setLayout(new BorderLayout());
		boton = new JButton();
		boton.setName("a");
		boton.addActionListener(new BuscaBomba());
		boton.addMouseListener(new PonBandera());
		this.add(boton, BorderLayout.CENTER);
		this.num = 0;

	}

	private JButton boton;
	private boolean bomba;
	private JLabel fondo;
	private int num;
	private int fila, columna;
	private boolean casillaPrimera = false; // primera casilla que pulso
	private static boolean primeraJugada = true; // primara vez que juego
	private boolean bombeable = true;
	private boolean bandera = false;
	private boolean usada = false;

	/*
	 * Establecer el fondo de la casilla si es bomba o número
	 */
	private void setFondo() {
		if (this.bomba) {
			this.fondo = new JLabel(new ImageIcon(Juego.class.getResource("/imagenes/bomba.jpg")));
		} else {
			if (num != 0) {
				this.fondo = new JLabel(Integer.toString(num), SwingConstants.CENTER);
				switch (num) {
				case 1:
					this.fondo.setForeground(Color.BLUE);
					break;
				case 2:
					this.fondo.setForeground(Color.MAGENTA);
					break;
				case 3:
					this.fondo.setForeground(Color.PINK);
					break;
				case 4:
					this.fondo.setForeground(Color.ORANGE);
					break;
				case 5:
					this.fondo.setForeground(Color.RED);
					break;
				case 6:
					this.fondo.setForeground(Color.BLACK);
					break;
				case 7:
					this.fondo.setForeground(Color.BLACK);
					break;
				case 8:
					this.fondo.setForeground(Color.BLACK);
					break;

				}
			}else {
				this.fondo=new JLabel();
			}
		}

		this.setBorder(BorderFactory.createBevelBorder(0));
		this.add(fondo);
		updateUI();
	}

	public void changeFondo() {
		if (this.bomba) {
			this.fondo = new JLabel(new ImageIcon(Juego.class.getResource("/imagenes/sonrisa.png")));
			this.add(fondo);
			updateUI();
		}
	}

	public void setImBombeable() {
		this.bombeable = false;
	}

	public boolean isBombeable() {
		return this.bombeable;
	}

	public boolean isCasillaPrimera() {
		return casillaPrimera;
	}

	public static boolean isPrimeraJugada() {
		return primeraJugada;
	}

	public static void setPrimeraJugada(boolean primeraJugada) {
		Casilla.primeraJugada = primeraJugada;
	}

	public boolean isBomba() {
		return bomba;
	}

	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void increaseNum() {
		this.num += 1;
	}

	public boolean isUsada() {
		return usada;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public void removeBoton() {
		this.remove(boton);
		this.usada = true;
		this.setFondo();
		this.updateUI();
	}

	/*
	 * Clase para pulsar el botón en búsqueda de bombas
	 */
	public class BuscaBomba implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (!Casilla.this.bandera) {
				if (primeraJugada) {

					Casilla.this.casillaPrimera = true;
					Juego.setBombeable();
					Juego.setBombas();
					Juego.setNum();
					Casilla.primeraJugada = false;
				}
				Juego.removeBotones(Casilla.this.fila, Casilla.this.columna);
			}
		}

	}

	private class PonBandera implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			int banderas= Juego.getTablero().getCasillero().getBanderas();
			if (!Casilla.this.bandera&&banderas>0&&!primeraJugada) {
				Casilla.this.boton.setIcon(new ImageIcon(Juego.class.getResource("/imagenes/bandera.jpg")));
				Casilla.this.updateUI();
				Casilla.this.bandera = true;
				Juego.getTablero().getCasillero().setBanderas(-1);
				banderas= Juego.getTablero().getCasillero().getBanderas();
				Juego.getTablero().getResultado().setLabel(Integer.toString(banderas),Resultado.BANDERA);
			} else if(Casilla.this.bandera){
				Casilla.this.boton.setIcon(null);
				Casilla.this.updateUI();
				Casilla.this.bandera = false;
				Juego.getTablero().getCasillero().setBanderas(1);
				banderas= Juego.getTablero().getCasillero().getBanderas();
				Juego.getTablero().getResultado().setLabel(Integer.toString(banderas),Resultado.BANDERA);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
