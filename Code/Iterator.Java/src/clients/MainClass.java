package clients;

import datastructure.*;
import iterators.IIterator;
import model.Item;

/**
 * Application entry point
 */
public class MainClass {
	
	public static void main(String[] args) {
		
		IIterableCollection collection = TreeCollection.createSample();

		//IIterator iter = collection.getDepthIterator();
		IIterator iter = collection.getBreadthIterator();
		
		while(iter.hasMore()) {
			Item i = iter.getNext();
			System.out.println(i);
		}
		
	}

}
