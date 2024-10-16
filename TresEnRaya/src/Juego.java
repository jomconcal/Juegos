import java.util.Scanner;

public class Juego {

	public Juego() {
		this.casillero=new Casillero();
		System.out.println(casillero);
	}
	
	private Casillero casillero;
	
	public void turnoJugador() {
		
		Scanner sc  = new Scanner(System.in);
		int fila;		
		int columna;
		
		do {
		
		System.out.println("Elija una fila");
		fila=sc.nextInt()-1;

		System.out.println("Elija una columna");
		columna=sc.nextInt()-1;
		
		}while(!casillero.getCasillero()[fila][columna].getRellenable());
		
		casillero.getCasillero()[fila][columna].setHueco("X");
		
		System.out.println(casillero);
		
	}
	
	public void turnoMaquina() {
		
		int fila;		
		int columna;
		
		do {
			fila=(int)(Math.random()*3);
			columna=(int)(Math.random()*3);
		}while(!casillero.getCasillero()[fila][columna].getRellenable());
		
		casillero.getCasillero()[fila][columna].setHueco("O");
		System.out.println(casillero);
		
	}
	
	public boolean ganaJugador() {
		
		boolean victoria=false;
			
		if(casillero.getCasillero()[0][0].getHueco()=="X"&&casillero.getCasillero()[0][1].getHueco()=="X"&&casillero.getCasillero()[0][2].getHueco()=="X"
				||casillero.getCasillero()[1][0].getHueco()=="X"&&casillero.getCasillero()[1][1].getHueco()=="X"&&casillero.getCasillero()[1][2].getHueco()=="X"
				||casillero.getCasillero()[2][0].getHueco()=="X"&&casillero.getCasillero()[2][1].getHueco()=="X"&&casillero.getCasillero()[2][2].getHueco()=="X"
				||casillero.getCasillero()[0][0].getHueco()=="X"&&casillero.getCasillero()[1][0].getHueco()=="X"&&casillero.getCasillero()[2][0].getHueco()=="X"
				||casillero.getCasillero()[0][1].getHueco()=="X"&&casillero.getCasillero()[1][1].getHueco()=="X"&&casillero.getCasillero()[2][1].getHueco()=="X"
				||casillero.getCasillero()[0][2].getHueco()=="X"&&casillero.getCasillero()[1][2].getHueco()=="X"&&casillero.getCasillero()[2][2].getHueco()=="X"
				||casillero.getCasillero()[0][0].getHueco()=="X"&&casillero.getCasillero()[1][1].getHueco()=="X"&&casillero.getCasillero()[2][2].getHueco()=="X"
				||casillero.getCasillero()[2][0].getHueco()=="X"&&casillero.getCasillero()[1][1].getHueco()=="X"&&casillero.getCasillero()[0][2].getHueco()=="X") {
			victoria=true;
		}
		return victoria;
	}
	
	public boolean ganaMaquina() {
		
		boolean victoria=false;
			
		if(casillero.getCasillero()[0][0].getHueco()=="O"&&casillero.getCasillero()[0][1].getHueco()=="O"&&casillero.getCasillero()[0][2].getHueco()=="O"
				||casillero.getCasillero()[1][0].getHueco()=="O"&&casillero.getCasillero()[1][1].getHueco()=="O"&&casillero.getCasillero()[1][2].getHueco()=="O"
				||casillero.getCasillero()[2][0].getHueco()=="O"&&casillero.getCasillero()[2][1].getHueco()=="O"&&casillero.getCasillero()[2][2].getHueco()=="O"
				||casillero.getCasillero()[0][0].getHueco()=="O"&&casillero.getCasillero()[1][0].getHueco()=="O"&&casillero.getCasillero()[2][0].getHueco()=="O"
				||casillero.getCasillero()[0][1].getHueco()=="O"&&casillero.getCasillero()[1][1].getHueco()=="O"&&casillero.getCasillero()[2][1].getHueco()=="O"
				||casillero.getCasillero()[0][2].getHueco()=="O"&&casillero.getCasillero()[1][2].getHueco()=="O"&&casillero.getCasillero()[2][2].getHueco()=="O"
				||casillero.getCasillero()[0][0].getHueco()=="O"&&casillero.getCasillero()[1][1].getHueco()=="O"&&casillero.getCasillero()[2][2].getHueco()=="O"
				||casillero.getCasillero()[2][0].getHueco()=="O"&&casillero.getCasillero()[1][1].getHueco()=="O"&&casillero.getCasillero()[0][2].getHueco()=="O") {
			victoria=true;
		}
		return victoria;
	}
}
