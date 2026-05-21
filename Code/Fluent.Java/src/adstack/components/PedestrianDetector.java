package adstack.components;

import adstack.models.IComponent;
import adstack.models.IFusion;

public class PedestrianDetector implements IFusion {
	
	@Override
	public void bind(IComponent component) {
        System.out.println("[PedestrianDetector] Binding component: " + component.getClass().getName());
	}
	
	@Override
	public void start() {
        System.out.println("[PedestrianDetector] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[PedestrianDetector] Stopping.");
	}

}
