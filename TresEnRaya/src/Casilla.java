
public class Casilla {

	public Casilla() {
		
		this.hueco=" ";
		this.rellenable=true;
	}
	private String hueco;
	private boolean rellenable;
	
	public void setHueco(String hueco) {
		
		this.hueco=hueco;
		this.rellenable=false;
	}
	
	public String getHueco() {
		return this.hueco;
	}
	
	public boolean getRellenable() {
		return this.rellenable;
	}
	
	public String toString() {
		return this.hueco;
	}

}
