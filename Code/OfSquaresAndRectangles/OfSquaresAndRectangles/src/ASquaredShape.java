
public abstract class ASquaredShape {

	private	double _width;
	private double _height;

	public ASquaredShape(double width, double height) {
		this._height = height;
		this._width = width;
	
	}
	
	public void setWidth(double val) {
		this._width = val;
	}
	
	public double getWidth() {
		return this._width;
	}
	
	public void setHeight(double val) {
		this._height = val;
	}
	
	public double getHeight() {
		return this._height;
	}
	
	public abstract double calcArea();
}
