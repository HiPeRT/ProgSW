
public class Quadrato extends Rettangolo {

	public Quadrato(int side) {
		super(side, side);
	}
	
	public double calcArea() {
		return this.getWidth() * this.getWidth();
	}
	
}
