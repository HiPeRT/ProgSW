
public class Rettangolo extends ASquaredShape {
	
	public Rettangolo(double width, double height) {
		super(width, height);
	}
	
	public double calcArea() {
		return this.getWidth() * this.getHeight();
	}
}
