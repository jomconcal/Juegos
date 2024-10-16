public class Main {

	public static void main(String[] args) {
		
		jugar();
		
	}
	

	private static void jugar() {
		Juego juego = new Juego();
		boolean victoriaJugador=false;
		boolean victoriaMaquina=false;
		
		for(int i=0;i<4;i++) {
			juego.turnoJugador();
			victoriaJugador=juego.ganaJugador();
			if(victoriaJugador) {
				System.out.println("Has ganado");
				break;
			}
			juego.turnoMaquina();
			victoriaMaquina=juego.ganaMaquina();
			if(victoriaMaquina) {
				System.out.println("Has perdido");
				break;
			}
		}
		if(!victoriaJugador&&!victoriaMaquina) {
			juego.turnoJugador();
			victoriaJugador=juego.ganaJugador();
			if(victoriaJugador) {
				System.out.println("Has ganado");
			}else {
				System.out.println("Empate");
			}
		}
	}
}
