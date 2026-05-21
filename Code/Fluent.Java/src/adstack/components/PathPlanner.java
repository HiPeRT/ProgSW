package adstack.components;

import adstack.models.IComponent;

public class PathPlanner implements IComponent {

	@Override
	public void start() {
        System.out.println("[PathPlanner] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[PathPlanner] Stopping.");
	}

}
