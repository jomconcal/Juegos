package aplicacion;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class Casilla extends JPanel {

	public Casilla() {
		this.setLayout(new BorderLayout());
		boton = new JButton();
		boton.addActionListener(new BuscaBomba());
		boton.addMouseListener(new PonBandera());
		this.add(boton, BorderLayout.CENTER);
		this.num = 0;
		this.activarCero = false;

	}

	private JButton boton;
	private boolean bomba;
	private JLabel fondo;
	private int num;
	private int fila, columna;
	private boolean activarCero;
	private boolean casillaPrimera = false;
	public static boolean primeraVez = true;
	private boolean bombeable = true;
	private boolean bandera = false;
	private boolean usada=false;

	private void setCasilla() {
		if (this.bomba) {
			this.fondo = new JLabel(new ImageIcon("src/imagenes/bomba.jpg"));
		} else {
			this.fondo = new JLabel(Integer.toString(num), SwingConstants.CENTER);
		}

		this.setBorder(BorderFactory.createBevelBorder(0));
		this.add(fondo);
		updateUI();
	}

	public void setImBombeable() {
		this.bombeable = false;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public boolean ceroActivado() {
		return this.activarCero;
	}

	public void activarCero() {
		this.activarCero = true;
	}

	private class PonBandera implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if(!Casilla.this.bandera) {
				Casilla.this.boton.setIcon(new ImageIcon("src/imagenes/bandera.jpg"));
				Casilla.this.updateUI();
				Casilla.this.bandera = true;
			}else {
				Casilla.this.boton.setIcon(null);
				Casilla.this.updateUI();
				Casilla.this.bandera = false;
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

	private class BuscaBomba implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (primeraVez&&!Casilla.this.bandera) {
				casillaPrimera = true;
				primeraVez = false;
				num = 0;
				bombeable = false;
				Casillero.setImbombeable();
				Casillero.distribuirNumeros(10);
			}

			if (!Casilla.this.bandera) {
				if (Casilla.this.num == 0) {
					int fila = Casilla.this.fila;
					int columna = Casilla.this.columna;

					Casillero.removeBotones(fila, columna);

					Casilla.this.updateUI();

				} else {
					Casilla.this.removeBoton();
					if(isBomba()) {
						Casillero.explosion();
					}
				}
			}
		}

	}

	public int getNum() {
		return num;
	}

	public void increaseNum() {
		this.num += 1;
	}

	public boolean isBomba() {
		return bomba;
	}

	public JButton getBoton() {
		return this.boton;
	}

	public int removeBoton() {

		this.remove(boton);
		this.setCasilla();
		if(!this.usada) {
			Casillero.restarCasillas();
			usada=true;
		}
		if(Casillero.getCasillas()==0) {
			Final resultado= new Final("Has ganado");
			resultado.setVisible(true);
		}
		return this.num;
	}

	public void setNum(int num) {
		this.num = num;

	}

	public void setBomba() {
		this.bomba = true;
		this.num = 9;
	}

	public boolean isCasillaPrimera() {
		return this.casillaPrimera;
	}

	public boolean isBombeable() {
		return this.bombeable;
	}
}
