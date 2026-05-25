package models;

import visitors.IVisitor;

/**
 * This class handles the status of a Rectangle.
 * In this version, I directly modify the Rectangle class.
 */
public class Rectangle implements IVisitableObject {
    private double _height;
    private double _width;

    public void setHeight(double height) {
        this._height = height;
    }

    public void setWidth(double width) {
        this._width = width;
    }

    public double getWidth() {
        return this._width;
    }

    public double getHeight() {
        return this._height;
    }

    public Rectangle(double height, double width) {
        this._height = height;
        this._width = width;
    }

	@Override
	public void accept(IVisitor v) {
		v.visit(this);
		
	}
}