package clients;

import models.*;
import visitors.*;

/**
 * Application entry point
 */
public class MainClass {

	public static void main(String[] args) {
		
		new Rectangle(4, 5).accept(new PrintVisitor());
		
		new VisitableSquare(5).accept(new DrawVisitor());
		
	}

}
