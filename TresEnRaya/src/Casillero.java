
public class Casillero {

	public Casillero() {

		crearCasillero();
		
	}

	private Casilla casillero[][];

	private void crearCasillero() {

		this.casillero = new Casilla[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.casillero[i][j] = new Casilla();
			}
		}
	}

	public Casilla[][] getCasillero() {
		return casillero;
	}

	public String toString() {

		String casillero = "";

		for (int i = 2; i >= 0; i--) {
			casillero+=(i+1)+"|";
			for (int j = 0; j < 3; j++) {
				
				casillero+=this.casillero[i][j]+"|";
			}
			casillero+="\n";
		}
		casillero+="  1 2 3\n";
		
		return casillero;
	}
}
