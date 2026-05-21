package adstack.components;

import adstack.models.IComponent;

public class ModelPredictiveControl implements IComponent {

	@Override
	public void start() {
        System.out.println("[ModelPredictiveControl] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[ModelPredictiveControl] Stopping.");
	}

}
