package calculators;

import interfaces.ICalculator;
import interfaces.IRectangle;
import interfaces.ISquare;

/**
 * Base implementation that makes no use, e.g., of Math library for square
 */
public class Calculator implements ICalculator {

	@Override
    public double calcArea(IRectangle r) {
        return r.getHeight() * r.getWidth();
    }

	@Override
	public double calcArea(ISquare r) {
		return r.getSide() * r.getSide();
	}

}
