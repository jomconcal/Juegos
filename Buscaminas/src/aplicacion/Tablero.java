package aplicacion;

import java.awt.*;

import javax.swing.*;

public class Tablero extends JFrame{

	public Tablero() {
		setLayout(new BorderLayout());
		iniciaTablero();
		this.add(casillero, BorderLayout.CENTER);
		this.add(menu,BorderLayout.NORTH);
		this.setBounds(300,300,ancho,largo);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private static Casillero casillero;
	private static int largo, ancho;
	private static Menu menu;
	
	public static void iniciaTablero() {
		casillero= new Casillero(8,8);
		menu= new Menu();
		ancho=casillero.getColumnas()*35;
		largo=casillero.getFilas()*35+30;
	}
	
}
