package adstack.components;

import adstack.models.IComponent;

public class YoloV8PedestrianDetector implements IComponent {

	@Override
	public void start() {
        System.out.println("[YoloV8PedestrianDetector] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[YoloV8PedestrianDetector] Stopping.");
	}

}
